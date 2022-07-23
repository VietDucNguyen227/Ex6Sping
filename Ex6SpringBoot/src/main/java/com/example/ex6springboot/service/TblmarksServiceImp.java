package com.example.ex6springboot.service;

import com.example.ex6springboot.model.Tblmarks;
import com.example.ex6springboot.repository.TblmarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TblmarksServiceImp implements TblmarksService {
    @Autowired
    TblmarksRepository tblmarksRepository;

    @Override
    public List<Tblmarks> getAllMark() {
        return tblmarksRepository.findAll();
    }

    @Override
    public void saveMark(Tblmarks tblmarks) {
        tblmarksRepository.save(tblmarks);
    }

    @Override
    public void deleteMark(int id) {
        tblmarksRepository.deleteById(id);
    }

    @Override
    public Optional<Tblmarks> findMarkByID(int id) {
        return tblmarksRepository.findById(id);
    }

    @Override
    public Tblmarks getOne(int id) {
        return tblmarksRepository.findById(id).get();
    }

    @Override
    public List<Tblmarks> findByMark(int mark) {
        return tblmarksRepository.findByMark(mark);
    }

    @Override
    public Long getCountMark() {
        return tblmarksRepository.getCountMark();
    }
}
