package org.excellence.yunnanemploymentbackend.controller;

import org.excellence.yunnanemploymentbackend.entity.EnterpriseInfo;
import org.excellence.yunnanemploymentbackend.entity.Notice;
import org.excellence.yunnanemploymentbackend.entity.Province;
import org.excellence.yunnanemploymentbackend.entity.ReportedData;
import org.excellence.yunnanemploymentbackend.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    // 企业备案 - 查看各市已备案企业信息
    @GetMapping("/viewRecordedEnterprises/{city}")
    public List<EnterpriseInfo> viewRecordedEnterprises(@PathVariable String city) {
        return provinceService.viewRecordedEnterprises(city);
    }

    // 企业查询 - 按需要对备案企业进行查询
    @GetMapping("/searchEnterprises/{city}")
    public List<EnterpriseInfo> searchEnterprises(@PathVariable String city, @RequestParam String keyword) {
        return provinceService.searchEnterprises(city, keyword);
    }

    // 报表管理 - 审核上报的数据并汇总上报
    @PostMapping("/reviewAndSummarizeReportedData")
    public void reviewAndSummarizeReportedData() {
        provinceService.reviewAndSummarizeReportedData();
    }

    // 数据修改 - 修改企业上报数据
    @PostMapping("/modifyReportedData/{enterpriseUserId}")
    public void modifyReportedData(@PathVariable String enterpriseUserId, @RequestBody ReportedData modifiedData) {
        provinceService.modifyReportedData(enterpriseUserId, modifiedData);
    }

    // 数据删除 - 删除历史数据
    @DeleteMapping("/deleteReportedData/{enterpriseUserId}/{reportedDataId}")
    public void deleteReportedData(@PathVariable String enterpriseUserId, @PathVariable String reportedDataId) {
        provinceService.deleteReportedData(enterpriseUserId, reportedDataId);
    }

    // 数据退回 - 退回上报数据
    @PostMapping("/returnReportedData/{enterpriseUserId}/{reportedDataId}")
    public void returnReportedData(@PathVariable String enterpriseUserId, @PathVariable String reportedDataId) {
        provinceService.returnReportedData(enterpriseUserId, reportedDataId);
    }

    // 数据汇总 - 查询汇总表
    @GetMapping("/viewSummary")
    public List<ReportedData> viewSummary() {
        return provinceService.viewSummary();
    }

    // 数据导出 - 按报送期导出企业信息、企业报表等数据
    @PostMapping("/exportData/{period}")
    public void exportData(@PathVariable String period) {
        provinceService.exportData(period);
    }

    // 数据查询 - 对全省已创建用户进行条件查询
    @GetMapping("/queryProvincesByCondition")
    public List<Province> queryProvincesByCondition(@RequestParam String condition) {
        return provinceService.queryProvincesByCondition(condition);
    }

    // 多维分析 - 用多维方式分析全省企业岗位变动情况
    @GetMapping("/performMultidimensionalAnalysis")
    public void performMultidimensionalAnalysis() {
        provinceService.performMultidimensionalAnalysis();
    }

    // 图表分析 - 用图表方式分析全省企业岗位变动情况
    @GetMapping("/performChartAnalysis")
    public void performChartAnalysis() {
        provinceService.performChartAnalysis();
    }

    // 发布通知 - 发布通知信息
    @PostMapping("/publishNotice")
    public void publishNotice(@RequestBody Notice notice) {
        provinceService.publishNotice(notice.getContent(), notice.getDate());
    }

    // 删除通知 - 删除通知信息
    @DeleteMapping("/deleteNotice/{noticeId}")
    public void deleteNotice(@PathVariable String noticeId) {
        provinceService.deleteNotice(noticeId);
    }

    // 系统管理 - 设置上报时限
    @PostMapping("/configureSystem/{timeLimit}")
    public void configureSystem(@PathVariable int timeLimit) {
        provinceService.configureSystem(timeLimit);
    }

    // 系统管理 - 管理用户
    @PostMapping("/manageUser/{userId}")
    public void manageUser(@PathVariable String userId) {
        provinceService.manageUser(userId);
    }

    // 系统管理 - 监控系统运行情况
    @GetMapping("/monitorSystem")
    public void monitorSystem() {
        provinceService.monitorSystem();
    }
}
