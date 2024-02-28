package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "tblnguoidung")
@AllArgsConstructor
@NoArgsConstructor
public class tblnguoidung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "sdt")
    private String sdt;

    @Column(name = "diachi")
    private String diachi;

    @Column(name="taikhoan")
    private String taikhoan;

    @Column(name="matkhau")
    private String matkhau;

    @Column(name="isadmin")
    private Integer isadmin;

    @JsonIgnore
    @OneToMany(mappedBy = "tblnguoidung")
    private List <tblxe> tblxes;

    @JsonIgnore
    @OneToMany(mappedBy = "tblnguoidung")
    private List <tblhoadon> tblhoadons;
}
