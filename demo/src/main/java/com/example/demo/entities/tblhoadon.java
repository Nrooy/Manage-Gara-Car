package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "tblhoadon")
@AllArgsConstructor
@NoArgsConstructor
public class tblhoadon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ghichu")
    private String ghichu;

    @Column(name = "dathanhtoan", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean dathanhtoan;

    @Column(name = "ngaythanhtoan")
    private Date ngaythanhtoan;

    @Column(name="ngayDatDon")
    private Date ngayDatDon;

    @JsonIgnore
    @OneToMany(mappedBy = "tblhoadon")
    private List <tblxedasua> tblxedasuas;

    @JsonIgnore
    @OneToMany(mappedBy = "tblhoadon")
    private List<tblphieugiamgiadasudung> tblphieugiamgiadasudungs;

    @ManyToOne
    @JoinColumn(name = "nguoidung_id")
    private tblnguoidung tblnguoidung;

    @ManyToOne
    @JoinColumn(name = "phuongthucthanhtoan_id")
    private tblphuongthucthanhtoan tblphuongthucthanhtoan;
}
