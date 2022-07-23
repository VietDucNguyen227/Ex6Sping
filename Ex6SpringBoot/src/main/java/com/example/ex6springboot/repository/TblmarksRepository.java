package com.example.ex6springboot.repository;

import com.example.ex6springboot.model.Tblmarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblmarksRepository extends JpaRepository<Tblmarks, Integer> {
    List<Tblmarks> findByMark(int mark);

    @Query("SELECT COUNT(s.mark) FROM Tblmarks s GROUP BY s.mark")
    long getCountMark();
}
