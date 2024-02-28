package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "tblslot")
@AllArgsConstructor
@NoArgsConstructor
public class tblslot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "so")
    private Integer so;

    @Column(name = "mota")
    private String mota;

    @JsonIgnore
    @OneToMany(mappedBy = "tblslot")
    private List<tblxedasua> tblxedasuas;
}
