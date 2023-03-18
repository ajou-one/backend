package com.example.ajouthon.notice;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public List<Notice> getRangedNotice(int start, int end){
        return noticeRepository.findRangedNotice(start, end);
    }
}
