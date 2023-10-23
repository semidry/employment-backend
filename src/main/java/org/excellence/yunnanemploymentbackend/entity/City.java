package org.excellence.yunnanemploymentbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@Document(collation = "city")
public class City {
    @Id private String userId;
    private List<String> dataAwaitingReview;
    private List<String> enterprises;
}
