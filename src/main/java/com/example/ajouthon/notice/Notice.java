package com.example.ajouthon.notice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Notice {
    @Id
    private int id;

    private String url;

    private String title;

    private int classify_code;

    private String age;
}
