package com.example.ex6springboot.service;

import com.example.ex6springboot.model.Tblstudent;
import com.example.ex6springboot.repository.TblstudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TblstudentServiceImp implements TblstudentService {
    @Autowired
    TblstudentRepository tblstudentRepository;

    @Override
    public List<Tblstudent> getAllStudent() {
        return tblstudentRepository.findAll();
    }

    @Override
    public void saveStudent(Tblstudent tblstudent) {
        tblstudentRepository.save(tblstudent);
    }

    @Override
    public void deleteStudent(int id) {
        tblstudentRepository.deleteById(id);
    }

    @Override
    public Optional<Tblstudent> findStudentByID(int id) {
        return tblstudentRepository.findById(id);
    }

    @Override
    public Tblstudent getOne(int id) {
        return tblstudentRepository.findById(id).get();
    }

    @Override
    public List<Tblstudent> findStudentByName(String name) {
        return tblstudentRepository.findByName(name);
    }

    @Override
    public Long getCountByClassId() {
        return null;
    }
}
