package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "tbllinhkien")
@AllArgsConstructor
@NoArgsConstructor
public class tbllinhkien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private  String ten;

    @Column(name = "thongtin")
    private  String thongtin;

    @Column(name = "gia")
    private Float gia;

    @JsonIgnore
    @OneToMany(mappedBy = "tbllinhkien")
    private List <tbllinhkiendasudung> tbllinhkiendasudungs;

}
