package com.example.assignment_gd1.repository;

import com.example.assignment_gd1.model.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepo extends JpaRepository<MauSac , Integer> {
}