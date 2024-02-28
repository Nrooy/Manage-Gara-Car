package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "tblnhanviensuachua")
@AllArgsConstructor
@NoArgsConstructor
public class tblnhanviensuachua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "chucvu")
    private String chucvu;

    @Column(name = "diachi")
    private String diachi;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "mota")
    private String mota;

    @JsonIgnore
    @OneToMany(mappedBy = "tblnhanviensuachua")
    private List <tblnhiemvu> tblnhiemvus;
}
