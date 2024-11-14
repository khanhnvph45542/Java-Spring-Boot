package com.example.assignment_gd1.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hoa_don")
    int idHoaDon;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien")
    NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    KhachHang khachHang;
    @Column(name = "ngay_mua_hang")
    LocalDate ngayMuaHang;

    @Column(name = "trang_thai")
    String trangThai;
}
