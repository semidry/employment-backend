package org.excellence.yunnanemploymentbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collation = "enterprise")
public class Enterprise {
    @Id private String userId;
    private String locatedCity;
    private String information;
    private List<String> reportedData;
    private List<String> unreadNotices;
    private Boolean isRegistered;
}
