package org.excellence.yunnanemploymentbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collation = "notice")
public class Notice {
    @Id private String noticeId;
    private String content; // 通知内容
    private String date; // 发布日期
}
