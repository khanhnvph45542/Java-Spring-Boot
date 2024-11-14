package com.example.assignment_gd1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "kich_thuoc")
public class KichThuoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_kich_thuoc")
    int idKichThuoc;
    String maKT;
    String tenKT;
    @Column(name = "trang_thai")
    boolean trangThai;

}
