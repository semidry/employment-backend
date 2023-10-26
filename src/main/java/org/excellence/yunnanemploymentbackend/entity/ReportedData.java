package org.excellence.yunnanemploymentbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class ReportedData {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer reportedDataId;
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
