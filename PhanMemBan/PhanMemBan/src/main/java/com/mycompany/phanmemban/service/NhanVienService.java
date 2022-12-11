/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.phanmemban.service;

import com.mycompany.phanmemban.model.ChucVu;
import com.mycompany.phanmemban.model.CuaHang;
import com.mycompany.phanmemban.model.NhanVien;
import java.util.ArrayList;

/**
 *
 * @author LONG
 */
public interface NhanVienService {
<<<<<<< HEAD
     ArrayList<NhanVien>getlistnhanvien();
    String addnhanvien(NhanVien nhanvien);
    String deletenhanvien(String ma);
    String updatenhanvien(NhanVien nhanvien);
    ArrayList<CuaHang>getlistcuahang();
    ArrayList<ChucVu>getlistchucvu();
    
    public NhanVien getOne(String ma);
=======

    ArrayList<NhanVien> getlistnhanvien();

    String addnhanvien(NhanVien nhanvien);

    String deletenhanvien(String ma);

    String updatenhanvien(NhanVien nv);

    ArrayList<CuaHang> getlistcuahang();

    ArrayList<ChucVu> getlistchucvu();

    public NhanVien getOne(String ma);

    public String updatemk(String mk, String ma);
    
    public NhanVien getOnes(String ma);
    
    public String updateMK(String mk, String ma);
>>>>>>> 04b43d346461bf4313d9bb8fc82fcfbd8b8ecab0
}
