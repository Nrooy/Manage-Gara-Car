package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbldichvudasudung")
@AllArgsConstructor
@NoArgsConstructor
public class tbldichvudasudung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "mota")
    private String mota;

    @ManyToOne
    @JoinColumn(name = "tbldichvu_id")
    private tbldichvu tbldichvu;

    @ManyToOne
    @JoinColumn(name = "tblxedasua_id")
    private tblxedasua tblxedasua;
}
