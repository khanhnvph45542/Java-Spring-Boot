package com.example.assignment_gd1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "mau_sac")
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mau_sac")
    int idMauSac;
    String maMS;
    String tenMS;
    @Column(name = "trang_thai")
    boolean trangThai;
}
