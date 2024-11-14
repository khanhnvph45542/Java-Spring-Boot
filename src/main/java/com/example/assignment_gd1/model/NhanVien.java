package com.example.assignment_gd1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "nhan_vien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idNV;
    String maNV;
    String ten;
    @Column(name = "ten_dang_nhap")
    String tenDangNhap;
    @Column(name = "mat_khau")
    String matKhau;
    @Column(name = "vai_tro")
    String vaiTro;
    @Column(name = "trang_thai")
    boolean trangThai;
}
