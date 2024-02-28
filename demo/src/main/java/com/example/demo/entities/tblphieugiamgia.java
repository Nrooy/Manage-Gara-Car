package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tblphieugiamgia")
public class tblphieugiamgia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "gia")
    private Float gia;

    @Column(name = "mota")
    private String mota;

    @Column(name = "hansudung")
    private Date hansudung;

    @JsonIgnore
    @OneToMany(mappedBy = "tblphieugiamgia")
    private List<tblphieugiamgiadasudung> tblphieugiamgiadasudungs;
}
