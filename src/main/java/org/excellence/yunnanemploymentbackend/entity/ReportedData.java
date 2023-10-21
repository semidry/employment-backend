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
    private String enterpriseId;
    private Boolean isApproved;
}
