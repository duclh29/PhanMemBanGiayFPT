/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.phanmemban.service;

import com.mycompany.phanmemban.model.KhachHang;
import java.util.ArrayList;

/**
 *
 * @author LONG
 */
public interface KhachHangService {
    ArrayList<KhachHang>getlistkhachhang();
    String addkhachhang(KhachHang khachhang);
    String delete(String ma);
    String update(KhachHang khachhang);
    
    public KhachHang getOne(String ma);
}
