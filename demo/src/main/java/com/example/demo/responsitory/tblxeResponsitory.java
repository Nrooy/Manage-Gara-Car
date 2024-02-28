package com.example.demo.responsitory;

import lombok.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.tblxe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface tblxeResponsitory extends JpaRepository<tblxe,Integer> {

    tblxe findByBienso(String bienso);

    @Query("SELECT xe FROM tblxe xe JOIN tblnguoidung nguoi WHERE nguoi.ten = :ten")
    List<tblxe> findByTenNguoiDung(@Param("ten") String ten);

    @Query(value = "select x from tblxe x where (?1 is null or x.bienso like %?1% or x.tblnguoidung.ten like %?1%)")
    Page <tblxe> dosearch (String keyword, Pageable pageable);

    @Query(value ="select xe from tblxe xe where xe.tblnguoidung.id =:id_nguoidung")
    List<tblxe> getAllXeCuaNguoiDung( Integer id_nguoidung);
}
