package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "tbldichvu")
@AllArgsConstructor
@NoArgsConstructor
public class tbldichvu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name ="gia" )
    private Float gia;

    @Column(name = "mota")
    private String mota;

    @JsonIgnore
    @OneToMany(mappedBy = "tbldichvu")
    private List< tbldichvudasudung > tbldichvudasudungs;

}
