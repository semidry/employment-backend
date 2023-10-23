package org.excellence.yunnanemploymentbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collation = "enterprise-info")
public class EnterpriseInfo {
    @Id private String enterpriseInfoId;
    private String enterpriseUserId;
    private Boolean isApproved;
    private String cityOfAffiliation; // 所属的市
    private String code; // 组织机构代码
    private String name; // 企业名称
    private String property; // 企业性质
    private String industry; // 所属行业
    private String mainBusiness; // 主要经营业务
    private String contact; // 联系人
    private String address; // 联系地址
    private String postalCode; // 邮政编码
    private String phoneNumber; // 联系电话
    private String fax;
    private String email;
}
