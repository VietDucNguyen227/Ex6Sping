package com.example.ex6springboot.controller.view.admin;

import com.example.ex6springboot.model.Tblsubjects;
import com.example.ex6springboot.service.TblsubjectsService;
import com.example.ex6springboot.service.TblsubjectsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    TblsubjectsService tblsubjectsService;

    @GetMapping("/admin/list")
    public String showSubjectList(Model model){
        List<Tblsubjects> list = tblsubjectsService.getAllSubjects();
        model.addAttribute("list", list);
        return "listSubject";
    }
}
