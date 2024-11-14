package com.example.assignment_gd1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "khach_hang")
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idKH;
    String maKH;
    String tenKH;
    String sdt;
    @Column(name = "trang_thai")
    boolean trangThai;

}
