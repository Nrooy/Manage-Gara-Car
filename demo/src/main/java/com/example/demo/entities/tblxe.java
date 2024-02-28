package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "tblxe")
@AllArgsConstructor
@NoArgsConstructor
public class tblxe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mauxe")
    private String mauxe;

    @Column(name = "bienso")
    private String bienso;

    @Column(name = "mota")
    private String mota;

    @ManyToOne
    @JoinColumn(name = "tblnguoidung_id")
    private tblnguoidung tblnguoidung;

    @JsonIgnore
    @OneToMany(mappedBy = "tblxe")
    private List<tblxedasua> tblxedasuas;

}
