package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "tbllingkiendasudung")
@AllArgsConstructor
@NoArgsConstructor
public class tbllinhkiendasudung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "soluong")
    private Integer soluong;

    @ManyToOne
    @JoinColumn(name = "tbllinhkien_id")
    private tbllinhkien tbllinhkien;

    @ManyToOne
    @JoinColumn(name = "tblxedasua_id")
    private tblxedasua tblxedasua;
}
