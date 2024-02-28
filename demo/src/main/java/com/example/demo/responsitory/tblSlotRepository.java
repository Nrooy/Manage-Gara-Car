package com.example.demo.responsitory;

import com.example.demo.entities.tblslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface tblSlotRepository extends JpaRepository<tblslot, Integer> {

    @Query("SELECT s FROM tblslot s " +
            "WHERE s.id NOT IN (" +
            "    SELECT DISTINCT xs.tblslot.id " +
            "    FROM tblxedasua xs " +
            "    LEFT JOIN xs.tblhoadon h ON xs.tblhoadon.id = h.id " +
            "    WHERE h.dathanhtoan = false) OR s.id IS NULL" )
    List<tblslot> getAllEmptyXe();

}
