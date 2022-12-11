/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.phanmemban.service;

import com.mycompany.phanmemban.model.CuaHang;
import com.mycompany.phanmemban.model.LoaiSP;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LONG
 */
public interface CuaHangService {
     public ArrayList<CuaHang> loadData();

    public String ADD(CuaHang cuahang);

    public String update(CuaHang cuahang);

    public String Delete(String ma);
}
