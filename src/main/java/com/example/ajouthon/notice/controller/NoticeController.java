package com.example.ajouthon.notice.controller;

import com.example.ajouthon.notice.service.NoticeService;
import com.example.ajouthon.notice.domain.ResponseDto;
import com.example.ajouthon.notice.domain.Notice;
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
    public ResponseEntity<ResponseDto> getRangedNotice(@RequestParam("start") int start, @RequestParam("end") int end, @RequestParam("page") int page){
        List<Notice> notices = noticeService.getRangedNotice(start, end, page);
        int totalNumber = noticeService.getPageCntOfSource(start, end);
        return new ResponseEntity<>(ResponseDto.of(notices, totalNumber), HttpStatus.OK);
    }
    @GetMapping("/recent")
    public ResponseEntity<ResponseDto> getRecentNotice(@RequestParam("page") int page){
        List<Notice> notices = noticeService.getRecentNotice(page);
        int totalNumber = noticeService.getPageCntOfRecent();
        return new ResponseEntity<>(ResponseDto.of(notices, totalNumber), HttpStatus.OK);
    }
}