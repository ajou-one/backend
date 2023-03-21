package com.example.ajouthon.notice.service;


import com.example.ajouthon.notice.domain.Notice;
import com.example.ajouthon.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeRepository noticeRepository;
    private final EntityManager em;

    public List<Notice> getRangedNotice(int start, int end, int page){
        TypedQuery<Notice> query = em.createQuery("SELECT n FROM Notice n WHERE n.classify_code BETWEEN :start and :end", Notice.class);
        query.setParameter("start",start);
        query.setParameter("end",end);
        query.setFirstResult((page-1) * 10);
        query.setMaxResults(10);
        return query.getResultList();
    }
    public int getPageCntOfSource(int start, int end){
        int size = noticeRepository.findBetweenSource(start, end).size();
        return (size - 1)/10 + 1;
    }

    public List<Notice> getRecentNotice(int page) {
        TypedQuery<Notice> query = em.createQuery("SELECT n FROM Notice n WHERE n.age = :new", Notice.class);
        query.setParameter("new","new");
        query.setFirstResult((page-1) * 10);
        query.setMaxResults(10);
        return query.getResultList();
    }

    public int getPageCntOfRecent(){
        TypedQuery<Notice> query = em.createQuery("SELECT n FROM Notice n WHERE n.age = :new", Notice.class);
        query.setParameter("new","new");
        int size = query.getResultList().size();
        return (size - 1)/10 + 1;
    }
}