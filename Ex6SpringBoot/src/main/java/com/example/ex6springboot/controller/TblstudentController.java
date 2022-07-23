package com.example.ex6springboot.controller;

import com.example.ex6springboot.model.Tblstudent;
import com.example.ex6springboot.service.TblstudentService;
import com.example.ex6springboot.service.TblstudentServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class TblstudentController {
    @Autowired
    TblstudentService tblstudentService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Tblstudent>> listAllStudent(){
        List<Tblstudent> tblstudentList = tblstudentService.getAllStudent();
        if (tblstudentList.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(tblstudentList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Tblstudent> saveStudent(@RequestBody Tblstudent tblstudent){
        tblstudentService.saveStudent(tblstudent);
        return ResponseEntity.ok(tblstudent);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tblstudent> updateStudent(@PathVariable("id") int id,
                                                @RequestBody Tblstudent tblstudent){
        Tblstudent oldTblStudent = tblstudentService.getOne(id);
        if (oldTblStudent == null){
            return ResponseEntity.notFound().build();
        }else{
            oldTblStudent.setCode(oldTblStudent.getCode());
            oldTblStudent.setName(oldTblStudent.getName());
            oldTblStudent.setAddress(oldTblStudent.getAddress());
            oldTblStudent.setPhone(oldTblStudent.getPhone());
            oldTblStudent.setEmail(oldTblStudent.getEmail());
            oldTblStudent.setTblclassByClassid(oldTblStudent.getTblclassByClassid());
            tblstudentService.saveStudent(oldTblStudent);
            return ResponseEntity.ok(oldTblStudent);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Tblstudent> deleteStudent(@PathVariable("id") int id){
        Optional<Tblstudent> deleteStudent = tblstudentService.findStudentByID(id);
        if (deleteStudent == null){
            return ResponseEntity.notFound().build();
        }else{
            tblstudentService.deleteStudent(id);
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Tblstudent> findStudentById(@PathVariable("id") int id){
        Tblstudent tblstudent = tblstudentService.getOne(id);
        return new ResponseEntity(tblstudent,HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Tblstudent>> findByName(@RequestParam String name){
        return new ResponseEntity(tblstudentService.findStudentByName(name),HttpStatus.OK);
    }
}
