package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tblnhiemvu")
@AllArgsConstructor
@NoArgsConstructor
public class tblnhiemvu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "mota")
    private String mota;

    @ManyToOne
    @JoinColumn(name = "tblnhanviensuachua_id")
    private tblnhanviensuachua tblnhanviensuachua;

    @ManyToOne
    @JoinColumn(name = "tblxedasua_id")
    private tblxedasua tblxedasua;
}
