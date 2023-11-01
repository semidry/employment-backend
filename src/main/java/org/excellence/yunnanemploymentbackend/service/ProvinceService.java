package org.excellence.yunnanemploymentbackend.service;

import org.excellence.yunnanemploymentbackend.entity.EnterpriseInfo;
import org.excellence.yunnanemploymentbackend.repository.EnterpriseInfoRepository;
import org.excellence.yunnanemploymentbackend.repository.EnterpriseRepository;
import org.excellence.yunnanemploymentbackend.repository.ProvinceRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProvinceService {
    private ProvinceRepository provinceRepository;

    private EnterpriseRepository enterpriseRepository;

    private EnterpriseInfoRepository enterpriseInfoRepository;

    /**
     * 查看所有已备案企业信息
     * @return 所有已备案企业的列表
     */
    public List<EnterpriseInfo> getAllRegisteredEnterprise() {
        final var registered = enterpriseRepository.findEnterprisesByIsRegisteredIsTrue();
        List<EnterpriseInfo> infos = new ArrayList<>();
        for (var enterprise : registered) {
            infos.add(enterpriseInfoRepository.findEnterpriseInfoByEnterpriseUserId(enterprise.getUserId()));
        }
        return infos;
    }

    /**
     * 查看各市已备案企业信息
     * @param cityUserId 所查询的市的userId
     * @return 当前市已备案的所有企业列表
     */
    public List<EnterpriseInfo> getRegisteredEnterpriseIn(String cityUserId) {

    }
}
