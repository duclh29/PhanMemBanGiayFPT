/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.service.impl;

import com.mycompany.phanmemban.model.ChiTietSP;
import com.mycompany.phanmemban.model.LoaiSP;
import com.mycompany.phanmemban.model.MauSac;
import com.mycompany.phanmemban.model.SanPham;
import com.mycompany.phanmemban.model.Size;
import com.mycompany.phanmemban.repostority.ChiTietSPRepostority;
import com.mycompany.phanmemban.repostority.LoaiSPRepostority;
import com.mycompany.phanmemban.repostority.MauSacRepostority;
import com.mycompany.phanmemban.repostority.SanPhamRepository;
import com.mycompany.phanmemban.repostority.SizeRepository;
import com.mycompany.phanmemban.service.ChiTietSPService;
import com.mycompany.phanmemban.viewmodel.ChiTietSPReponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ChiTietSPServiceImpl implements ChiTietSPService {

    private ChiTietSPRepostority chiTietSPRepostority = new ChiTietSPRepostority();
    private SanPhamRepository sanPhamRepo = new SanPhamRepository();
    private LoaiSPRepostority loaiSPRepo = new LoaiSPRepostority();
    private MauSacRepostority mauSacRepo = new MauSacRepostority();
    private SizeRepository sizeRepo = new SizeRepository();

    @Override
    public String add(ChiTietSP chiTietSP) {
        if (chiTietSPRepostority.add(chiTietSP)) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }
    @Override
    public UUID delete(UUID id) {
        return chiTietSPRepostority.delete(id);
    }

    @Override
    public void update(ChiTietSP chiTietSp) {
        chiTietSPRepostority.update(chiTietSp);
    }

    @Override
    public ArrayList<String> listcbbctsp() {
        return (ArrayList<String>) chiTietSPRepostority.listcbbctsp();
    }

    @Override
    public List<SanPham> getListSP() {
        return sanPhamRepo.getAll();
    }

    @Override
    public List<LoaiSP> getListLoaiSP() {
        return loaiSPRepo.getAllData();
    }

    @Override
    public List<MauSac> getListMauSac() {
        return mauSacRepo.getAllData();
    }

    @Override
    public List<Size> getListSize() {
        return sizeRepo.getAllSize();
    }
//    @Override
//    public UUID findbyidctsp(String ma) {
//        return chiTietSPRepostority.(ma);
//    }
//
//    @Override
//    public UUID findbyidhd(String ma) {
//        return chiTietSPRepostority.findByIdhd(ma);
//    }

    @Override
    public List<ChiTietSPReponse> getAll() {
        return chiTietSPRepostority.getAll();
    }

//    @Override
//    public UUID findByIdsp(String ten) {
//        return chiTietSPRepostority.findByIdsanpham(ten);
//    }
//
//    @Override
//    public UUID findByIdms(String ten) {
//        return chiTietSPRepostority.findByIdmauSac(ten);
//    }
//
//    @Override
//    public UUID findByIds(String ten) {
//        return chiTietSPRepostority.findByIdsize(ten);
//    }
//
//    @Override
//    public UUID findByIdlsp(String ten) {
//        return chiTietSPRepostority.findByIdloaisp(ten);

//    @Override
//    public UUID findbyidctsp(String ma) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public UUID findbyidhd(String ma) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

    @Override
    public List<ChiTietSP> getAllData() {
        return chiTietSPRepostority.getAllData();
    }

    @Override
    public List<ChiTietSPReponse> searchByNameSanPham(String tenSanPham) {
        return chiTietSPRepostority.searchByNameTenSp(tenSanPham);
    }
    
}
