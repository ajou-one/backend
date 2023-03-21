package com.example.ajouthon.notice.repository;

import com.example.ajouthon.notice.domain.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM Notice n WHERE n.classify_code BETWEEN :start and :end")
    List<Notice> findBetweenSource(@Param("start") int start, @Param("end") int end);

}