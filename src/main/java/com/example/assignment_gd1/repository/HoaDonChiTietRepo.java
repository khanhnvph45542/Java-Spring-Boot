package com.example.assignment_gd1.repository;

import com.example.assignment_gd1.model.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HoaDonChiTietRepo extends JpaRepository<HoaDonChiTiet,Integer> {
    Optional<HoaDonChiTiet> findByHoaDonIdHoaDon(Integer idHD);
}
