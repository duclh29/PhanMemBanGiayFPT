/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.service.impl;

import com.mycompany.phanmemban.model.CuaHang;
import com.mycompany.phanmemban.model.LoaiSP;
import com.mycompany.phanmemban.repostority.CuaHangRepostority;
import com.mycompany.phanmemban.service.CuaHangService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LONG
 */
public class CuahangServicelmpl implements CuaHangService{
    private CuaHangRepostority cuahangrepostority=new CuaHangRepostority();
     ArrayList<CuaHang>listcuahang=new ArrayList<>();

  
    @Override
    public String Delete(String ma) {
        if(cuahangrepostority.delete(ma)){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }

    @Override
    public ArrayList<CuaHang> loadData() {
     return (ArrayList<CuaHang>) cuahangrepostority.getAll();
    }

    @Override
    public String ADD(CuaHang cuahang) {
        if(cuahangrepostority.add(cuahang)){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }

    @Override
    public String update(CuaHang cuahang) {
        if(cuahangrepostority.Update(cuahang)){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }
    
}
