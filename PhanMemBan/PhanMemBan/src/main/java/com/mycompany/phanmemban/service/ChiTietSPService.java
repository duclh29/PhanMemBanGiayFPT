/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.phanmemban.service;


import com.mycompany.phanmemban.model.ChiTietSP;
import com.mycompany.phanmemban.model.LoaiSP;
import com.mycompany.phanmemban.model.MauSac;
import com.mycompany.phanmemban.model.SanPham;
import com.mycompany.phanmemban.model.Size;
import com.mycompany.phanmemban.viewmodel.ChiTietSPReponse;

import java.util.List;
import java.util.UUID;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface ChiTietSPService {

   List<ChiTietSPReponse> getAll();
   
   List<ChiTietSP> getAllData();

    List<SanPham> getListSP();

    List<LoaiSP> getListLoaiSP();

    List<MauSac> getListMauSac();

    List<Size> getListSize();

    String add(ChiTietSP chiTietSP);

    UUID delete(UUID id);

    void update(ChiTietSP chiTietSp);

    public List<String> listcbbctsp();
    
    List<ChiTietSPReponse> searchByNameSanPham(String tenSanPham);

//    public UUID findbyidctsp(String ma);
//
//    public UUID findbyidhd(String ma);
    
//    UUID findByIdsp(String ten);
//    
//    UUID findByIdms(String ten);
//    
//    UUID findByIds(String ten);
//    
//    UUID findByIdlsp(String ten);

}
