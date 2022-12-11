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
<<<<<<< HEAD
=======
import java.util.HashMap;
import java.util.Map;
>>>>>>> 04b43d346461bf4313d9bb8fc82fcfbd8b8ecab0

/**
 *
 * @author LONG
 */
public class NhanVienServicelmpl implements NhanVienService{
     private NhanVienRepostority nhanvienrepostority=new NhanVienRepostority();
    private CuaHangRepostority cuahangrepostority=new CuaHangRepostority();
    private ChucVuRepostority chucVuRepostority=new ChucVuRepostority();
    ArrayList<NhanVien>listnhanvien=new ArrayList<>();
<<<<<<< HEAD

=======
private Map<String, Object> mapMa = new HashMap<>();
>>>>>>> 04b43d346461bf4313d9bb8fc82fcfbd8b8ecab0
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
<<<<<<< HEAD
    public String updatenhanvien(NhanVien nhanvien) {
        if(nhanvienrepostority.Update(nhanvien)){
            return "Thành công";
        }else{
            return "Thất bại";
=======
    public String updatenhanvien(NhanVien nv) {
        if (!mapMa.containsKey(nv.getMa())) {
            return "Không được sửa mã";
        } else {
            return nhanvienrepostority.update(nv);
>>>>>>> 04b43d346461bf4313d9bb8fc82fcfbd8b8ecab0
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
<<<<<<< HEAD
=======

    @Override
    public String updatemk(String mk, String ma) {
        return nhanvienrepostority.updatenmk(mk, ma);
        
    }
    @Override
    public NhanVien getOnes(String ma) {
        NhanVien nhanVien = nhanvienrepostority.getOnes(ma.trim());
        return nhanVien;
    }
    public static void main(String[] args) {
        System.out.println(new NhanVienServicelmpl().updateMK("123456", "NV01"));
    }

    @Override
    public String updateMK(String mk, String ma) {
        if(nhanvienrepostority.updateMK(mk, ma)){
            return "Đổi mật khẩu thành công";
        }else {
            return "Đổi mật khẩu thất bại";
        }
    }
    
>>>>>>> 04b43d346461bf4313d9bb8fc82fcfbd8b8ecab0
}
