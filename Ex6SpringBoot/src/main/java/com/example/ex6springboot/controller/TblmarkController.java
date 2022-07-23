package com.example.ex6springboot.controller;


import com.example.ex6springboot.model.Tblmarks;
import com.example.ex6springboot.service.TblmarksService;
import com.example.ex6springboot.service.TblmarksServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mark")
public class TblmarkController {
    @Autowired
    TblmarksService tblmarksService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Tblmarks>> listAllMarks(){
        List<Tblmarks> tblmarksList = tblmarksService.getAllMark();
        if (tblmarksList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(tblmarksList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Tblmarks> saveMark(@RequestBody Tblmarks tblmarks){
        tblmarksService.saveMark(tblmarks);
        return ResponseEntity.ok(tblmarks);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tblmarks> updateMark(@PathVariable("id") int id,
                                                @RequestBody Tblmarks tblmarks){
        Tblmarks oldTblMark = tblmarksService.getOne(id);
        if (oldTblMark == null){
            return ResponseEntity.notFound().build();
        }else{
            oldTblMark.setMark(oldTblMark.getMark());
            oldTblMark.setNote(oldTblMark.getNote());
            oldTblMark.setTblstudentByStudentId(oldTblMark.getTblstudentByStudentId());
            oldTblMark.setTblsubjectsBySubjectId(oldTblMark.getTblsubjectsBySubjectId());
            tblmarksService.saveMark(oldTblMark);
            return ResponseEntity.ok(oldTblMark);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Tblmarks> deleteMark(@PathVariable("id") int id){
        Optional<Tblmarks> deleteMark = tblmarksService.findMarkByID(id);
        if (deleteMark == null){
            return ResponseEntity.notFound().build();
        }else{
            tblmarksService.deleteMark(id);
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Tblmarks> findMarkById(@PathVariable("id") int id){
        Tblmarks tblmarks = tblmarksService.getOne(id);
        return new ResponseEntity(tblmarks,HttpStatus.OK);
    }

    @GetMapping("/findByMark")
    public ResponseEntity<List<Tblmarks>> findByMark(@RequestParam int mark){
        return new ResponseEntity(tblmarksService.findByMark(mark),HttpStatus.OK);
    }

    @GetMapping("/countMark")
    public ResponseEntity<Tblmarks> countMark(){
        Long tblMark = tblmarksService.getCountMark();
        return new ResponseEntity(tblMark, HttpStatus.OK);
    }
}
