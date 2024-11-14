package com.example.assignment_gd1.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "san_pham")
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idSP;
    String maSP;
    String ten;

    @Column(name = "trang_thai")
    boolean trangThai;
}
