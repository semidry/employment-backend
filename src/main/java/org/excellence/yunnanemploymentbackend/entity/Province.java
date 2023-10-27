package org.excellence.yunnanemploymentbackend.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Province {
    @Id private String userId;
    @ElementCollection private List<String> dataAwaitingReview;
    @ElementCollection private List<String> cities;
    @ElementCollection private List<String> releasedNotices;
    private Integer timeLimit;
}
