package org.excellence.yunnanemploymentbackend.service;

import org.excellence.yunnanemploymentbackend.entity.Enterprise;
import org.excellence.yunnanemploymentbackend.entity.EnterpriseInfo;
import org.excellence.yunnanemploymentbackend.entity.Province;
import org.excellence.yunnanemploymentbackend.entity.ReportedData;
import org.excellence.yunnanemploymentbackend.repository.EnterpriseInfoRepository;
import org.excellence.yunnanemploymentbackend.repository.EnterpriseRepository;
import org.excellence.yunnanemploymentbackend.repository.ProvinceRepository;
import org.excellence.yunnanemploymentbackend.repository.ReportedDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProvinceService {

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private EnterpriseRepository enterpriseRepository;

    @Autowired
    private EnterpriseInfoRepository enterpriseInfoRepository;

    @Autowired
    private ReportedDataRepository reportedDataRepository;

    /**
     * 查看所有已备案企业信息
     *
     * @return 所有已备案企业的列表
     */
    public List<EnterpriseInfo> getAllRegisteredEnterprise() {
        return enterpriseRepository.findEnterprisesByIsRegisteredIsTrue().stream()
                .map(enterprise -> enterpriseInfoRepository.findEnterpriseInfoByEnterpriseUserId(enterprise.getUserId()))
                .collect(Collectors.toList());
    }

    /**
     * 查看各市已备案企业信息
     *
     * @param cityUserId 所查询的市的userId
     * @return 当前市已备案的所有企业列表
     */
    public List<EnterpriseInfo> getRegisteredEnterpriseIn(String cityUserId) {
        return enterpriseRepository.findEnterprisesByIsRegisteredIsTrueAndLocatedCityIs(cityUserId).stream()
                .map(enterprise -> enterpriseInfoRepository.findEnterpriseInfoByEnterpriseUserId(enterprise.getUserId()))
                .collect(Collectors.toList());
    }

    /**
     * 获取所有待审核的企业上报数据
     * @return 待审核的企业上报数据的列表
     * @param provinceUserId 省的userId(方便多省扩展)
     */
    public List<ReportedData> getAllReportedDataAwaitingReview(String provinceUserId) {
        return provinceRepository.findById(provinceUserId)
                .map(province -> province.getDataAwaitingReview().stream()
                .map(reportedDataId -> reportedDataRepository.findById(reportedDataId).orElseGet(ReportedData::new))
                .collect(Collectors.toList())).orElseGet(ArrayList::new);
    }

    /**
     * 省审核通过上报的数据
     * @param reportedDataId 上报数据的Id
     * @return 操作是否成功
     */
    public Boolean approveReportedData(String provinceUserId, Integer reportedDataId) {
        try {
            final var wrappedProvince = provinceRepository.findById(provinceUserId);
            if (wrappedProvince.isPresent()) {
                // 省表中移除待审核标志
                final var province = wrappedProvince.get();
                province.getDataAwaitingReview().removeIf(integer -> integer.equals(reportedDataId));
                provinceRepository.save(province);
                // 数据表中添加"已审核"标志
                reportedDataRepository.findById(reportedDataId).ifPresentOrElse(reportedData -> {
                    reportedData.setIsApproved(true);
                    reportedDataRepository.save(reportedData);
                }, () -> {});
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
