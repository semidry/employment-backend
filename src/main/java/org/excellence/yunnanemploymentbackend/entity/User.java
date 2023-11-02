package org.excellence.yunnanemploymentbackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class User {
    @Id private String userId;
    private String password;
    private Integer userType;
}
