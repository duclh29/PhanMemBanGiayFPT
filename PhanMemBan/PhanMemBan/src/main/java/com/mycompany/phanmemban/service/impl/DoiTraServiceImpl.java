/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.service.impl;

import com.mycompany.phanmemban.model.DoiTra;
import com.mycompany.phanmemban.model.NhanVien;
import com.mycompany.phanmemban.repostority.DoiTraRespository;
import com.mycompany.phanmemban.service.DoiTraService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DoiTraServiceImpl implements DoiTraService {

    private DoiTraRespository doiTraRepo = new DoiTraRespository();

    @Override
    public ArrayList<DoiTra> getALL() {
        return (ArrayList<DoiTra>) doiTraRepo.getAll();
    }

    @Override
    public List<String> listcbbDT() {
        return doiTraRepo.listcbbdt();
    }

    @Override
    public DoiTra getOne(String ma) {
        DoiTra doiTra = doiTraRepo.getOne(ma.trim());
        return doiTra;
    }

    
}
