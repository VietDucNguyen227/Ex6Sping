package com.example.ex6springboot.dto;

import com.example.ex6springboot.model.Tblsubjects;

import java.util.List;

public class ListSubject {
    private List<Tblsubjects> data;

    public List<Tblsubjects> getData() {
        return data;
    }

    public void setData(List<Tblsubjects> data) {
        this.data = data;
    }
}
