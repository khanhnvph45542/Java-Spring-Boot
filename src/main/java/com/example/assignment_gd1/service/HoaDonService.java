package com.example.assignment_gd1.service;

import com.example.assignment_gd1.model.HoaDon;
import com.example.assignment_gd1.model.HoaDonChiTiet;
import com.example.assignment_gd1.model.SanPhamChiTiet;
import com.example.assignment_gd1.repository.HoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HoaDonService {
//    ArrayList<HoaDon> listHD = new ArrayList<>();
    @Autowired
    HoaDonRepo hoaDonRepo;


    public List<HoaDon> getListHD() {
        return hoaDonRepo.findAll();
    }
    public ArrayList<HoaDon> getListHDChuaTT() {
        ArrayList<HoaDon> lisHDCT = new ArrayList<>();
        for (HoaDon hoaDon:getListHD()) {
            if (hoaDon.getTrangThai().equals("Chưa Thanh Toán")){
                lisHDCT.add(hoaDon);
            }
        }
        return lisHDCT;
    }
    public ArrayList<HoaDon> getListHDDaTT() {
        ArrayList<HoaDon> lisHDCTT = new ArrayList<>();
        for (HoaDon hoaDon:getListHD()) {
                if (hoaDon.getTrangThai().equals("Đã Thanh Toán")){
                lisHDCTT.add(hoaDon);
            }
        }
        return lisHDCTT;
    }
    public ArrayList<HoaDon> getListHDHuyTT() {
        ArrayList<HoaDon> lisHDCTTT = new ArrayList<>();
        for (HoaDon hoaDon:getListHD()) {
            if (hoaDon.getTrangThai().equals("Hủy Thanh Toán")){
                lisHDCTTT.add(hoaDon);
            }
        }
        return lisHDCTTT;
    }
//
//
    public HoaDon getByIDHD(int idHD){
        return hoaDonRepo.findById(idHD).get();
    }

    public ArrayList<HoaDon> timkiemHDByID(int idHD) {
        ArrayList<HoaDon> lisHD = new ArrayList<>();
        for (int i = 0; i < getListHD().size(); i++) {
           if (getListHD().get(i).getIdHoaDon() == idHD ){
               lisHD.add(getListHD().get(i));
        }
    }
        return lisHD;
    }
//
    public void addHD(HoaDon hoaDon){
        try {
            hoaDonRepo.save(hoaDon);

        }catch (Exception e){
         e.printStackTrace();
        }
    }
//
    public void thanhToanHD(HoaDon hoaDon){

                hoaDonRepo.save(hoaDon);

    }
    public void HuyHoaDon(int idHD){
            for (int i = 0; i < getListHD().size(); i++) {
                if (getListHD().get(i).getIdHoaDon() == idHD) {
                 HoaDon hoaDon =  getListHD().get(i);
                 hoaDon.setTrangThai("Hủy Thanh Toán");
                 hoaDonRepo.save(hoaDon);
            }
        }
    }

}
