package com.example.assignment_gd1.service;

import com.example.assignment_gd1.model.KhachHang;
import com.example.assignment_gd1.model.MauSac;
import com.example.assignment_gd1.model.SanPhamChiTiet;
import com.example.assignment_gd1.repository.MauSacRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MauSacService {
    @Autowired
    MauSacRepo mauSacRepo;

    public List<MauSac> getListMS() {
        return mauSacRepo.findAll();
    }

//    public MauSac getByIDMS(int idMS){
//        for (MauSac mauSac: listMS ){
//            if (mauSac.getIdMauSac() == idMS){
//                return mauSac;
//            }
//        }
//        return null;
//    }

//    public ArrayList<MauSac> ListIDMS(int idMS) {
//        ArrayList<MauSac> list = new ArrayList<>();
//        for (MauSac mauSac:listMS ) {
//            if (mauSac.getIdMauSac() == idMS){
//                list.add(mauSac);
//            }
//        }
//        return list;
//    }
    public ArrayList<MauSac> TrueListIDMS() {
        ArrayList<MauSac> list = new ArrayList<>();
        for (MauSac mauSac:getListMS() ) {
            if (mauSac.isTrangThai() == true){
                list.add(mauSac);
            }
        }
        return list;
    }
//    public void deleteMS(int idMS){
//        MauSac mauSac = getByIDMS(idMS);
//        if (mauSac!=null){
//            listMS.remove(mauSac);
//        }
//    }
//    public void updateMS(MauSac mauSac){
//        for (int i = 0; i < listMS.size(); i++) {
//            if (listMS.get(i).getIdMauSac() == mauSac.getIdMauSac()){
//                listMS.set(i,mauSac);
//            }
//        }
//    }
//
//    public void addMS(MauSac mauSac){
//        try {
//            listMS.add(mauSac);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
