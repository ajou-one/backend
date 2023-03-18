package com.example.ajouthon.notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Integer> {

    @Query("SELECT n FROM Notice n WHERE n.classify_code BETWEEN ?1 and ?2")
    List<Notice> findRangedNotice(int start, int end);

    List<Notice> findByAge(String age);
}
