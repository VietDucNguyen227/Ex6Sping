package com.example.ex6springboot.service;

import com.example.ex6springboot.model.Tblclass;

import java.util.List;
import java.util.Optional;

public interface TblclassService {
    List<Tblclass> getAllClass();

    void saveClass(Tblclass tblclass);

    void deleteCLass(int id);

    Optional<Tblclass> findClassByID(int id);

    Tblclass getOne(int id);

    List<Tblclass> getClassByName(String name);

    Long getCountByName();
}
