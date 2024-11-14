package com.example.assignment_gd1.service;

import com.example.assignment_gd1.model.HoaDon;
import com.example.assignment_gd1.model.HoaDonChiTiet;
import com.example.assignment_gd1.model.SanPhamChiTiet;
import com.example.assignment_gd1.repository.HoaDonChiTietRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class HoaDonChiTietService {
//    ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
    @Autowired
    HoaDonChiTietRepo hoaDonChiTietRepo;


    public List<HoaDonChiTiet> getListHDCT() {
        return hoaDonChiTietRepo.findAll();
    }

    public ArrayList<HoaDonChiTiet> getByIDHD(int idHD){
        ArrayList<HoaDonChiTiet> listCT = new ArrayList<>();
        for (HoaDonChiTiet hoaDonChiTiet: getListHDCT()) {
            if (hoaDonChiTiet.getHoaDon().getIdHoaDon()  == idHD){
                listCT.add(hoaDonChiTiet);
            }
        }
        return listCT;
    }
    public ArrayList<HoaDonChiTiet> timkiemHDCT(int idHDCT){
        ArrayList<HoaDonChiTiet> listTimKiem = new ArrayList<>();
        for (HoaDonChiTiet hoaDonChiTiet:getListHDCT()) {
            if (hoaDonChiTiet.getIdHDCT() == idHDCT){
                listTimKiem.add(hoaDonChiTiet);
            }
        }
        return listTimKiem;
    }

    public void addHDCT(HoaDonChiTiet hdct,int soluong1){
        try {
//            for (int i = 0; i < getListHDCT().size(); i++) {
//                if (getListHDCT().get(i).getHoaDon().getIdHoaDon() == hdct.getHoaDon().getIdHoaDon()
//                        && getListHDCT().get(i).getSanPhamChiTiet().getIdSPCT() == hdct.getSanPhamChiTiet().getIdSPCT()){
//                    HoaDonChiTiet hoaDonChiTiet = getListHDCT().get(i);
//                    int soLuong =soluong1 + hoaDonChiTiet.getSoLuong();
//                    hoaDonChiTiet.setSoLuong(soLuong);
//                    hoaDonChiTietRepo.save(hoaDonChiTiet);
//                }else {
                    hoaDonChiTietRepo.save(hdct);
//                }
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updatesoluongHDCT(int idHDCT, int soLuongthaydoi){
        for (int i = 0; i < getListHDCT().size(); i++) {
            if (getListHDCT().get(i).getIdHDCT() == idHDCT){
                HoaDonChiTiet hoaDonChiTiet = getListHDCT().get(i);
                hoaDonChiTiet.setSoLuong(soLuongthaydoi);
                hoaDonChiTietRepo.save(hoaDonChiTiet);
            }
        }
    }
    public void capNhatsoluongHDCT(int idHD, int idSPCT, int soluong1){
        for (int i = 0; i < getListHDCT().size(); i++) {
            if (getListHDCT().get(i).getHoaDon().getIdHoaDon() == idHD
            && getListHDCT().get(i).getSanPhamChiTiet().getIdSPCT() == idSPCT){
                HoaDonChiTiet hoaDonChiTiet = getListHDCT().get(i);
                int soLuong =soluong1 + hoaDonChiTiet.getSoLuong();
                hoaDonChiTiet.setSoLuong(soLuong);
                hoaDonChiTietRepo.save(hoaDonChiTiet);
                return;
            }
        }
    }
    public HoaDonChiTiet hoaDonChiTiet(int idHDCT){
        for (HoaDonChiTiet hdct:getListHDCT()) {
            if (hdct.getIdHDCT() == idHDCT){
                return hdct;
            }
        }
        return null;
    }

    public void deleteHDCT(int idhdct){
        hoaDonChiTietRepo.deleteById(idhdct);
    }

      public double tongTien(int idHD){
        double sum = 0;
          for (int i = 0; i < getListHDCT().size(); i++) {
              if (getListHDCT().get(i).getHoaDon().getIdHoaDon() == idHD){
                  sum += getListHDCT().get(i).getSoLuong() * getListHDCT().get(i).getDonGia();
//                  sum++;
              }
          }
          return sum;
    }
    public int soluongspdamua(int idHD, int idSPCT){
        int sum =0;
        for (int i = 0; i < getListHDCT().size(); i++) {
            if ( getListHDCT().get(i).getSanPhamChiTiet().getIdSPCT() == idSPCT){
                sum =getListHDCT().get(i).getSoLuong();
            }
        }
        return sum;
    }


}
