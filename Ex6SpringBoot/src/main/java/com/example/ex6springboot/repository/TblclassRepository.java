package com.example.ex6springboot.repository;

import com.example.ex6springboot.model.Tblclass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblclassRepository extends JpaRepository<Tblclass, Integer> {
    List<Tblclass> findByName(String name);

    @Query("SELECT COUNT(s.name) FROM Tblclass s")
    long getCountByName();
}
