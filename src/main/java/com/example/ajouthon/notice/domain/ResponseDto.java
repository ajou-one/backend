package com.example.ajouthon.notice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ResponseDto {
    private List<Item> items;
    private Meta meta;

    public static ResponseDto of(List<Notice> notices, int totalNumber){
        List<Item> items = notices.stream().map(notice ->
            new Item(notice.getUrl(), notice.getTitle(), notice.getClassify_code())
        ).collect(Collectors.toList());
        Meta meta = new Meta(totalNumber);
        return new ResponseDto(items, meta);
    }
}

@Data
@AllArgsConstructor
class Item{
    private String url;
    private String title;
    private Long classify_code;
}

@Data
@AllArgsConstructor
class Meta{
    private int total_number;
}