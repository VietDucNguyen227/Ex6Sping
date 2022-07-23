package com.example.ex6springboot.repository;

import com.example.ex6springboot.model.Tblsubjects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblsubjectsRepository extends JpaRepository<Tblsubjects, Integer> {
    List<Tblsubjects> findByName(String name);
}
