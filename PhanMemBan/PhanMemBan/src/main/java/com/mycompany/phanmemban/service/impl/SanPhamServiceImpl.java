/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.service.impl;

import com.mycompany.phanmemban.model.SanPham;
import com.mycompany.phanmemban.repostority.SanPhamRepository;
import com.mycompany.phanmemban.service.SanPhamService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SanPhamServiceImpl implements SanPhamService {

    SanPhamRepository sprp = new SanPhamRepository();

    @Override
    public ArrayList<SanPham> getAll() {
        return sprp.getAll();

    }

    @Override
    public String add(SanPham sp) {
        boolean add = sprp.add(sp);
        if (add) {
            return "ADD Thanh Cong";
        } else {
            return "ADD that bai";
        }

    }

    @Override
    public String delete(String ma) {
        boolean dlt = sprp.delete(ma);

        if (dlt) {
            return " Xóa thành công";
        }
        return " Xóa Không thành công";

    }

    @Override
    public SanPham getOne(String id) {
        return sprp.getOne(id);
    }

    @Override
    public List<String> listcbbsanpham() {
        return sprp.listcbbsanpham();
    }

}
