package com.example.ex6springboot.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Objects;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Tblstudent {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
//    @Basic
//    @Column(name = "classid")
//    private Integer classid;
    @Basic
    @Column(name = "code")
    @NotBlank(message = "Student code is mandatory")
    private String code;
    @Basic
    @Column(name = "name")
    @NotBlank(message = "Student's Name is mandatory")
    private String name;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "phone")
    private String phone;
    @Basic
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "tblstudentByStudentId")
//    @JsonManagedReference
    @JsonIgnore
    private Collection<Tblmarks> tblmarksById;

    @ManyToOne
    @JoinColumn(name = "classid", referencedColumnName = "id")
//    @JsonBackReference
    private Tblclass tblclassByClassid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public Integer getClassid() {
//        return classid;
//    }
//
//    public void setClassid(Integer classid) {
//        this.classid = classid;
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Tblstudent that = (Tblstudent) o;
//        return id == that.id && Objects.equals(classid, that.classid) && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(phone, that.phone) && Objects.equals(email, that.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, classid, code, name, address, phone, email);
//    }

    public Collection<Tblmarks> getTblmarksById() {
        return tblmarksById;
    }

    public void setTblmarksById(Collection<Tblmarks> tblmarksById) {
        this.tblmarksById = tblmarksById;
    }

    public Tblclass getTblclassByClassid() {
        return tblclassByClassid;
    }

    public void setTblclassByClassid(Tblclass tblclassByClassid) {
        this.tblclassByClassid = tblclassByClassid;
    }
}
