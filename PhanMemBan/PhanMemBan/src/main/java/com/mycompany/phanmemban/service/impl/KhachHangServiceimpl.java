/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.service.impl;

import com.mycompany.phanmemban.model.KhachHang;
import com.mycompany.phanmemban.model.NhanVien;
import com.mycompany.phanmemban.repostority.KhachHangRepostority;
import com.mycompany.phanmemban.service.KhachHangService;
import java.util.ArrayList;

/**
 *
 * @author LONG
 */
public class KhachHangServiceimpl implements KhachHangService{
    private KhachHangRepostority khachhangrepostority=new KhachHangRepostority();

    @Override
    public ArrayList<KhachHang> getlistkhachhang() {
        return (ArrayList<KhachHang>) khachhangrepostority.getAll();
    }

    @Override
    public String addkhachhang(KhachHang khachhang) {
        if(khachhangrepostority.add(khachhang)){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }

    @Override
    public String delete(String ma) {
        if(khachhangrepostority.delete(ma)){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }

    @Override
    public String update(KhachHang khachhang) {
        if(khachhangrepostority.Update(khachhang)){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }

    @Override
    public KhachHang getOne(String ma) {
        KhachHang khachHang = khachhangrepostority.getOne(ma.trim());
        return khachHang;
    }
    
}
