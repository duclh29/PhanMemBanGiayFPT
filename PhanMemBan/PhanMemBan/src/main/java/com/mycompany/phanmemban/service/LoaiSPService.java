/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.phanmemban.service;

import com.mycompany.phanmemban.model.LoaiSP;
import java.util.List;

/**
 *
 * @author PC
 */
public interface LoaiSPService {
       public List<LoaiSP> loadData();

    public String ADD(LoaiSP loaiSP);

    public String update(LoaiSP loaiSP);

    public String Delete(String ma);
    
    public List<String> listcbbloaisp();
}
