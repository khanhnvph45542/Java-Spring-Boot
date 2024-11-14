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
//    public KichThuoc getBYIDKT(int idKT){
//        for (KichThuoc kichThuoc:listKichThuoc ) {
//            if (kichThuoc.getIdKichThuoc()== idKT){
//                return kichThuoc;
//
//            }
//        }
//        return null;
//    }
//    public ArrayList<KichThuoc> ListIDKT(int idKT) {
//        ArrayList<KichThuoc> list = new ArrayList<>();
//        for (KichThuoc kichThuoc:listKichThuoc ) {
//            if (kichThuoc.getIdKichThuoc() == idKT){
//                list.add(kichThuoc);
//            }
//        }
//        return list;
//    }
    public List<KichThuoc> TrueListIDKT() {
        ArrayList<KichThuoc> listkt = new ArrayList<>();
        for (KichThuoc kichThuoc:getListKichThuoc() ) {
            if (kichThuoc.isTrangThai() == true){
                listkt.add(kichThuoc);
            }
        }
        return listkt;
    }

//    public KichThuoc getByIDKHTrue(int idKT) {
//        for (KichThuoc kichThuoc:listKichThuoc ) {
//            if (kichThuoc.getIdKichThuoc() == idKT && kichThuoc.isTrangThai() == true){
//                return kichThuoc;
//            }
//        }
//        return null;
//    }
//    public void deleteKT(int idKT){
//        KichThuoc kichThuoc = getBYIDKT(idKT);
//        if (kichThuoc!=null){
//            listKichThuoc.remove(kichThuoc);
//        }
//    }
//    public void updateKT(KichThuoc kichThuoc){
//        for (int i = 0; i < listKichThuoc.size(); i++) {
//            if (listKichThuoc.get(i).getIdKichThuoc() == kichThuoc.getIdKichThuoc()){
//                listKichThuoc.set(i,kichThuoc);
//            }
//        }
//    }
//
//    public void addKT(KichThuoc kichThuoc){
//        try {
//            listKichThuoc.add(kichThuoc);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }

}
