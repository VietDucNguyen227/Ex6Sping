package com.example.ex6springboot.service;

import com.example.ex6springboot.model.Tblsubjects;

import java.util.List;
import java.util.Optional;

public interface TblsubjectsService {
    List<Tblsubjects> getAllSubjects();

    void saveSubject(Tblsubjects tblstudent);

    void deleteSubject(int id);

    Optional<Tblsubjects> findSubjectByID(int id);

    Tblsubjects getOne(int id);

    List<Tblsubjects> findSubjectByName(String name);
}
