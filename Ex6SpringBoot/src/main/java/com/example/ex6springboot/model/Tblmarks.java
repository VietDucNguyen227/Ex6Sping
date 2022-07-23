package com.example.ex6springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Tblmarks {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
//    @Basic
//    @Column(name = "student_id")
//    private Integer studentId;
//    @Basic
//    @Column(name = "subject_id")
//    private Integer subjectId;
    @Basic
    @Column(name = "mark")
    private Integer mark;
    @Basic
    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
//    @JsonBackReference
    private Tblstudent tblstudentByStudentId;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
//    @JsonBackReference
    private Tblsubjects tblsubjectsBySubjectId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Integer getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(Integer studentId) {
//        this.studentId = studentId;
//    }
//
//    public Integer getSubjectId() {
//        return subjectId;
//    }
//
//    public void setSubjectId(Integer subjectId) {
//        this.subjectId = subjectId;
//    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Tblmarks tblmarks = (Tblmarks) o;
//        return id == tblmarks.id && Objects.equals(studentId, tblmarks.studentId) && Objects.equals(subjectId, tblmarks.subjectId) && Objects.equals(mark, tblmarks.mark) && Objects.equals(note, tblmarks.note);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, studentId, subjectId, mark, note);
//    }

    public Tblstudent getTblstudentByStudentId() {
        return tblstudentByStudentId;
    }

    public void setTblstudentByStudentId(Tblstudent tblstudentByStudentId) {
        this.tblstudentByStudentId = tblstudentByStudentId;
    }

    public Tblsubjects getTblsubjectsBySubjectId() {
        return tblsubjectsBySubjectId;
    }

    public void setTblsubjectsBySubjectId(Tblsubjects tblsubjectsBySubjectId) {
        this.tblsubjectsBySubjectId = tblsubjectsBySubjectId;
    }
}
