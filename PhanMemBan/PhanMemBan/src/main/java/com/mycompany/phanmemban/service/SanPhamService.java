/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.phanmemban.service;

import com.mycompany.phanmemban.model.SanPham;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
//adada//
public interface SanPhamService {

    ArrayList<SanPham> getAll();

    String delete(String  ma);

    String add(SanPham sanpham);

    SanPham getOne(String id);
    
    public List<String> listcbbsanpham();
}
