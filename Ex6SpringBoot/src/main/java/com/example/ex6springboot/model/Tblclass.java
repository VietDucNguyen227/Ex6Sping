package com.example.ex6springboot.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Objects;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Tblclass {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    @NotBlank(message = "Class's name is mandatory")
    private String name;
    @Basic
    @Column(name = "note")
    private String note;
    @OneToMany(mappedBy = "tblclassByClassid")
    @JsonIgnore
    private Collection<Tblstudent> tblstudentsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tblclass tblclass = (Tblclass) o;
        return id == tblclass.id && Objects.equals(name, tblclass.name) && Objects.equals(note, tblclass.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, note);
    }

    public Collection<Tblstudent> getTblstudentsById() {
        return tblstudentsById;
    }

    public void setTblstudentsById(Collection<Tblstudent> tblstudentsById) {
        this.tblstudentsById = tblstudentsById;
    }
}
