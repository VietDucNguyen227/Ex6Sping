package com.example.ex6springboot.controller;

import com.example.ex6springboot.model.Tblclass;
import com.example.ex6springboot.service.TblclassService;
import com.example.ex6springboot.service.TblclassServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/class")
public class TblclassController {
    @Autowired
    TblclassServiceImp tblclassService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Tblclass>> listAllClass(){
        List<Tblclass> tblclassList = tblclassService.getAllClass();
        if (tblclassList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(tblclassList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Tblclass> saveClass(@RequestBody Tblclass tblclass){
        tblclassService.saveClass(tblclass);
        return ResponseEntity.ok(tblclass);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tblclass> updateClass(@PathVariable("id") int id,
                                                @RequestBody Tblclass tblclass){
        Tblclass oldTblClass = tblclassService.getOne(id);
        if (oldTblClass == null){
            return ResponseEntity.notFound().build();
        }else{
            oldTblClass.setName(tblclass.getName());
            oldTblClass.setNote(tblclass.getNote());
            oldTblClass.setTblstudentsById(tblclass.getTblstudentsById());
            tblclassService.saveClass(oldTblClass);
            return ResponseEntity.ok(oldTblClass);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Tblclass> deleteClass(@PathVariable("id") int id){
        Optional<Tblclass> deleteClass = tblclassService.findClassByID(id);
        if (deleteClass == null){
            return ResponseEntity.notFound().build();
        }else{
            tblclassService.deleteCLass(id);
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Tblclass> findClassById(@PathVariable("id") int id){
        Tblclass tblclass = tblclassService.getOne(id);
        return new ResponseEntity(tblclass,HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Tblclass>> findClassByName(@RequestParam String name){
        return new ResponseEntity(tblclassService.getClassByName(name),HttpStatus.OK);
    }

    @GetMapping("/countByName")
    public ResponseEntity<Tblclass> countByName(){
        Long tblClass = tblclassService.getCountByName();
        return new ResponseEntity(tblClass, HttpStatus.OK);
    }




}