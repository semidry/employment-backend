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

    // 查看各市已备案企业信息
    @GetMapping("/registered-enterprises/{city}")
    public List<EnterpriseInfo> viewRecordedEnterprises(@PathVariable String city) {
        return provinceService.getRegisteredEnterpriseIn(city);
    }

    // 企业查询
    @GetMapping("/search-enterprises")
    public List<EnterpriseInfo> searchEnterprises(@RequestParam String city, @RequestParam String keyword) {
        return provinceService.searchEnterprises(city, keyword);
    }

    // 报表管理
    @PostMapping("/review-and-summarize-reported-data")
    public void reviewAndSummarizeReportedData() {
        provinceService.reviewAndSummarizeReportedData();
    }

    // 数据修改
    @PutMapping("/modify-reported-data")
    public void modifyReportedData(@RequestBody ReportedData modifiedData) {
        provinceService.modifyReportedData(modifiedData);
    }

    // 数据删除
    @DeleteMapping("/delete-reported-data")
    public void deleteReportedData(@RequestParam String enterpriseUserId, @RequestParam String reportedDataId) {
        provinceService.deleteReportedData(enterpriseUserId, reportedDataId);
    }

    // 数据退回
    @PutMapping("/return-reported-data")
    public void returnReportedData(@RequestParam String enterpriseUserId, @RequestParam String reportedDataId) {
        provinceService.returnReportedData(enterpriseUserId, reportedDataId);
    }

    // 数据汇总
    @GetMapping("/view-summary")
    public List<ReportedData> viewSummary() {
        return provinceService.viewSummary();
    }

    // 数据导出
    @GetMapping("/export-data")
    public void exportData(@RequestParam String period) {
        provinceService.exportData(period);
    }

    // 数据查询
    @GetMapping("/query-provinces")
    public List<Province> queryProvincesByCondition(@RequestParam String condition) {
        return provinceService.queryProvincesByCondition(condition);
    }

    // 多维分析
    @PostMapping("/perform-multidimensional-analysis")
    public void performMultidimensionalAnalysis() {
        provinceService.performMultidimensionalAnalysis();
    }

    // 图表分析
    @PostMapping("/perform-chart-analysis")
    public void performChartAnalysis() {
        provinceService.performChartAnalysis();
    }

    // 发布通知
    @PostMapping("/publish-notice")
    public void publishNotice(@RequestBody Notice notice) {
        provinceService.publishNotice(notice);
    }

    // 删除通知
    @DeleteMapping("/delete-notice/{noticeId}")
    public void deleteNotice(@PathVariable String noticeId) {
        provinceService.deleteNotice(noticeId);
    }

    // 系统管理
    @PutMapping("/configure-system")
    public void configureSystem(@RequestParam int timeLimit) {
        provinceService.configureSystem(timeLimit);
    }

    @PostMapping("/manage-user")
    public void manageUser(@RequestParam String userId) {
        provinceService.manageUser(userId);
    }

    @GetMapping("/monitor-system")
    public void monitorSystem() {
        provinceService.monitorSystem();
    }
}
