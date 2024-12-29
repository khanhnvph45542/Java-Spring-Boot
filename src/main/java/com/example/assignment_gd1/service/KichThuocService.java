package com.example.assignment_gd1.service;

import com.example.assignment_gd1.model.KhachHang;
import com.example.assignment_gd1.model.KichThuoc;
import com.example.assignment_gd1.model.MauSac;
import com.example.assignment_gd1.repository.KichThuocRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KichThuocService {
//    ArrayList<KichThuoc> listKichThuoc = new ArrayList<>();
    @Autowired
    KichThuocRepo kichThuocRepo;

    public List<KichThuoc> getListKichThuoc() {
        return kichThuocRepo.findAll();
    }
    public KichThuoc getBYIDKT(int idKT){

        return kichThuocRepo.findById(idKT).get();
    }
    public ArrayList<KichThuoc> ListIDKT(int idKT) {
        ArrayList<KichThuoc> list = new ArrayList<>();
        for (KichThuoc kichThuoc:getListKichThuoc() ) {
            if (kichThuoc.getIdKichThuoc() == idKT){
                list.add(kichThuoc);
            }
        }
        return list;
    }
    public List<KichThuoc> TrueListIDKT() {
        ArrayList<KichThuoc> listkt = new ArrayList<>();
        for (KichThuoc kichThuoc:getListKichThuoc() ) {
            if (kichThuoc.isTrangThai() == true){
                listkt.add(kichThuoc);
            }
        }
        return listkt;
    }

    public KichThuoc getByIDKHTrue(int idKT) {
        for (KichThuoc kichThuoc:getListKichThuoc() ) {
            if (kichThuoc.getIdKichThuoc() == idKT && kichThuoc.isTrangThai() == true){
                return kichThuoc;
            }
        }
        return null;
    }
    public void deleteKT(int idKT){
       kichThuocRepo.deleteById(idKT);
    }
    public void updateKT(KichThuoc kichThuoc){
        try {
            kichThuocRepo.save(kichThuoc);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//
    public void addKT(KichThuoc kichThuoc){
        try {
            kichThuocRepo.save(kichThuoc);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
