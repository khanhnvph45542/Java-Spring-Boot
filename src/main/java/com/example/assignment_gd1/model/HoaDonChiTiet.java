package com.example.assignment_gd1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "hoa_don_chi_tiet")
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHDCT")
    int idHDCT;

    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "id_spct")
    SanPhamChiTiet sanPhamChiTiet;

    @Column(name = "so_luong")
    int soLuong;

    @Column(name = "don_gia")
    double donGia;

    @Column(name = "trang_thai")
    boolean trangThai;
}
