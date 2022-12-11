/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.service.impl;

import com.mycompany.phanmemban.model.ChucVu;
import com.mycompany.phanmemban.model.CuaHang;
import com.mycompany.phanmemban.model.NhanVien;
import com.mycompany.phanmemban.repostority.ChucVuRepostority;
import com.mycompany.phanmemban.repostority.CuaHangRepostority;
import com.mycompany.phanmemban.repostority.NhanVienRepostority;
import com.mycompany.phanmemban.service.NhanVienService;
import java.util.ArrayList;

/**
 *
 * @author LONG
 */
public class NhanVienServicelmpl implements NhanVienService{
     private NhanVienRepostority nhanvienrepostority=new NhanVienRepostority();
    private CuaHangRepostority cuahangrepostority=new CuaHangRepostority();
    private ChucVuRepostority chucVuRepostority=new ChucVuRepostority();
    ArrayList<NhanVien>listnhanvien=new ArrayList<>();

    @Override
    public ArrayList<NhanVien> getlistnhanvien() {
        return (ArrayList<NhanVien>) nhanvienrepostority.getAll();
    }

    @Override
    public String addnhanvien(NhanVien nhanvien) {
        if(nhanvienrepostority.add(nhanvien)){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }

    @Override
    public String deletenhanvien(String ma) {
        if(nhanvienrepostority.delete(ma)){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }

    @Override
    public String updatenhanvien(NhanVien nhanvien) {
        if(nhanvienrepostority.Update(nhanvien)){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }

    

    @Override
    public ArrayList<ChucVu> getlistchucvu() {
        return (ArrayList<ChucVu>) chucVuRepostority.getAll();
    }

    @Override
    public ArrayList<CuaHang> getlistcuahang() {
       return (ArrayList<CuaHang>) cuahangrepostority.getAll();
    }

    @Override
    public NhanVien getOne(String ma) {
        NhanVien nhanVien = nhanvienrepostority.getOne(ma.trim());
        return nhanVien;
    }
}
