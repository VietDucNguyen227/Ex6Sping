package com.example.ex6springboot.service;

import com.example.ex6springboot.model.Tblclass;
import com.example.ex6springboot.repository.TblclassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TblclassServiceImp implements TblclassService {
    @Autowired
    TblclassRepository tblclassRepository;

    @Override
    public List<Tblclass> getAllClass() {
        return tblclassRepository.findAll();
    }

    @Override
    public void saveClass(Tblclass tblclass) {
        tblclassRepository.save(tblclass);
    }

    @Override
    public void deleteCLass(int id) {
        tblclassRepository.deleteById(id);
    }

    @Override
    public Optional<Tblclass> findClassByID(int id) {
        return tblclassRepository.findById(id);
    }

    @Override
    public Tblclass getOne(int id) {
        return tblclassRepository.findById(id).get();
    }

    @Override
    public List<Tblclass> getClassByName(String name) {
        return tblclassRepository.findByName(name);
    }

    @Override
    public Long getCountByName() {
        return tblclassRepository.getCountByName();
    }

}
