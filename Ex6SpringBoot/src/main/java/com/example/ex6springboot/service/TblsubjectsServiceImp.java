package com.example.ex6springboot.service;

import com.example.ex6springboot.model.Tblsubjects;
import com.example.ex6springboot.repository.TblsubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TblsubjectsServiceImp implements TblsubjectsService{
    @Autowired
    TblsubjectsRepository tblsubjectsRepository;

    @Override
    public List<Tblsubjects> getAllSubjects() {
        return tblsubjectsRepository.findAll();
    }

    @Override
    public void saveSubject(Tblsubjects tblsubjects) {
        tblsubjectsRepository.save(tblsubjects);
    }

    @Override
    public void deleteSubject(int id) {
        tblsubjectsRepository.deleteById(id);
    }

    @Override
    public Optional<Tblsubjects> findSubjectByID(int id) {
        return tblsubjectsRepository.findById(id);
    }

    @Override
    public Tblsubjects getOne(int id) {
        return tblsubjectsRepository.findById(id).get();
    }

    @Override
    public List<Tblsubjects> findSubjectByName(String name) {
        return tblsubjectsRepository.findByName(name);
    }
}
