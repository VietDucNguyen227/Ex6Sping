package com.example.ex6springboot.service;

import com.example.ex6springboot.model.Tblmarks;

import java.util.List;
import java.util.Optional;

public interface TblmarksService {
    List<Tblmarks> getAllMark();

    void saveMark(Tblmarks tblmarks);

    void deleteMark(int id);

    Optional<Tblmarks> findMarkByID(int id);

    Tblmarks getOne(int id);

    List<Tblmarks> findByMark(int mark);

    Long getCountMark();
}
