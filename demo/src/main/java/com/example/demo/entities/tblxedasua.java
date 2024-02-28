package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "tblxedasua")
@AllArgsConstructor
@NoArgsConstructor
public class tblxedasua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mota")
    private String mota;

    @JsonIgnore
    @OneToMany(mappedBy = "tblxedasua")
    private List<tblnhiemvu> tblnhiemvus;

    @JsonIgnore
    @OneToMany(mappedBy = "tblxedasua")
    private List<tbldichvudasudung> tbldichvudasudungs;

    @JsonIgnore
    @OneToMany(mappedBy = "tblxedasua")
    private List<tbllinhkiendasudung> tbllinhkiendasudungs;

    @ManyToOne
    @JoinColumn(name = "tblhoadon_id")
    private tblhoadon tblhoadon;

    @ManyToOne
    @JoinColumn(name="tblslot_id")
    private tblslot tblslot;

    @ManyToOne
    @JoinColumn(name = "xe_id")
    private tblxe tblxe;
}
