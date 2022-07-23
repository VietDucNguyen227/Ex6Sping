package com.example.ex6springboot.controller;

import com.example.ex6springboot.dto.ListSubject;
import com.example.ex6springboot.model.Tblsubjects;
import com.example.ex6springboot.service.TblsubjectsService;
import com.example.ex6springboot.service.TblsubjectsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class TblsubjectsController {
    @Autowired
    TblsubjectsService tblsubjectsService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Tblsubjects>> listAllSubjects(){
        List<Tblsubjects> tblsubjects = tblsubjectsService.getAllSubjects();
        if (tblsubjects.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(tblsubjects, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Tblsubjects> saveSubject(@RequestBody Tblsubjects tblsubjects){
        tblsubjectsService.saveSubject(tblsubjects);
        return ResponseEntity.ok(tblsubjects);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tblsubjects> updateSubject(@PathVariable("id") int id,
                                                @RequestBody Tblsubjects tblsubjects){
        Tblsubjects oldTblSubject = tblsubjectsService.getOne(id);
        if (oldTblSubject == null){
            return ResponseEntity.notFound().build();
        }else{
            oldTblSubject.setName(tblsubjects.getName());
            oldTblSubject.setDescription(tblsubjects.getDescription());
            oldTblSubject.setSem(tblsubjects.getSem());
            oldTblSubject.setDuration(tblsubjects.getDuration());
            tblsubjectsService.saveSubject(oldTblSubject);
            return ResponseEntity.ok(oldTblSubject);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Tblsubjects> deleteClass(@PathVariable("id") int id){
        Optional<Tblsubjects> deleteClass = tblsubjectsService.findSubjectByID(id);
        if (deleteClass == null){
            return ResponseEntity.notFound().build();
        }else{
            tblsubjectsService.deleteSubject(id);
            return ResponseEntity.ok().build();
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Tblsubjects> findClassById(@PathVariable("id") int id){
        Tblsubjects tblsubjects = tblsubjectsService.getOne(id);
        return new ResponseEntity(tblsubjects,HttpStatus.OK);
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Tblsubjects>> findClassByName(@RequestParam String name){
        return new ResponseEntity(tblsubjectsService.findSubjectByName(name),HttpStatus.OK);
    }

    @RequestMapping(value = "/lsSubject", method = RequestMethod.GET)
    public ResponseEntity<ListSubject> listListSubjects(){
        List<Tblsubjects> listSubject = tblsubjectsService.getAllSubjects();
        ListSubject ls = new ListSubject();
        ls.setData(listSubject);
        return new ResponseEntity<ListSubject>(ls, HttpStatus.OK);
    }
}

