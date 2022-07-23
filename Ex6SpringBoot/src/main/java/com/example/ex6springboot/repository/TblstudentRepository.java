package com.example.ex6springboot.repository;

import com.example.ex6springboot.model.Tblstudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TblstudentRepository extends JpaRepository<Tblstudent, Integer> {
    List<Tblstudent> findByName(String name);
}
