package com.example.ajouthon.notice.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Notice {
    @Id
    private Long id;

    private String url;

    private String title;

    private Long classify_code;

    private String age;
}
