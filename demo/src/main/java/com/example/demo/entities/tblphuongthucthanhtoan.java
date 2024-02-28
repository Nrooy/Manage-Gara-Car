package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "tblphuongthucthanhtoan")
@AllArgsConstructor
@NoArgsConstructor
public class tblphuongthucthanhtoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @JsonIgnore
    @OneToMany(mappedBy = "tblphuongthucthanhtoan")
    private List<tblhoadon> tblhoadons;
}
