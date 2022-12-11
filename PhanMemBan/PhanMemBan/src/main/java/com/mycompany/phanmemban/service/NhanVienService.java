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
     ArrayList<NhanVien>getlistnhanvien();
    String addnhanvien(NhanVien nhanvien);
    String deletenhanvien(String ma);
    String updatenhanvien(NhanVien nhanvien);
    ArrayList<CuaHang>getlistcuahang();
    ArrayList<ChucVu>getlistchucvu();
    
    public NhanVien getOne(String ma);
}
