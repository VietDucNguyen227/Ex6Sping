package com.example.ex6springboot.service;

import com.example.ex6springboot.model.Tblstudent;

import java.util.List;
import java.util.Optional;

public interface TblstudentService {
    List<Tblstudent> getAllStudent();

    void saveStudent(Tblstudent tblstudent);

    void deleteStudent(int id);

    Optional<Tblstudent> findStudentByID(int id);

    Tblstudent getOne(int id);

    List<Tblstudent> findStudentByName(String name);

    Long getCountByClassId();
}
