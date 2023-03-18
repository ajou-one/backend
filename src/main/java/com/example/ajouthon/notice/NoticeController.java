package com.example.ajouthon.notice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/all")
    public ResponseEntity<List<Notice>> getRangedNotice(@RequestParam("start") int start, @RequestParam("end") int end){

        return new ResponseEntity<>(noticeService.getRangedNotice(start, end), HttpStatus.OK);
    }
}
