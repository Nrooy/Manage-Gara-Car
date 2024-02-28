package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tblphieugiamgiadasudung")
@AllArgsConstructor
@NoArgsConstructor
public class tblphieugiamgiadasudung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "soluong")
    private Integer soluong;


    @ManyToOne
    @JoinColumn(name = "tblphieugiamgia_id")
    private tblphieugiamgia tblphieugiamgia;

    @ManyToOne
    @JoinColumn(name = "tblhoadon_id")
    private tblhoadon tblhoadon;
}
