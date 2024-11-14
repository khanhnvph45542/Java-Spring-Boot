package com.example.assignment_gd1.repository;

import com.example.assignment_gd1.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham , Integer> {
}
