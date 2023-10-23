package org.excellence.yunnanemploymentbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collation = "reported_data")
public class ReportedData {
    @Id private String reportedDataId;
    private String enterpriseUserId;
    private Integer employedNumDuringFilingPeriod;
    private Integer employedNumDuringSurveyPeriod;
    private String otherReasons;
    private String reducedType;
    private String mainReason;
    private String mainReasonDescription;
    private String secondaryReason;
    private String secondaryReasonDescription;
    private String thirdReason;
    private String thirdReasonDescription;
}
