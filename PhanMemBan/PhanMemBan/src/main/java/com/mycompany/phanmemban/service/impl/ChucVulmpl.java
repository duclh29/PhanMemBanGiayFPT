/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.service.impl;

import com.mycompany.phanmemban.model.ChucVu;
import com.mycompany.phanmemban.repostority.ChucVuRepostority;
import com.mycompany.phanmemban.service.ChucVuService;
import java.util.ArrayList;

/**
 *
 * @author LONG
 */
public class ChucVulmpl implements ChucVuService{
   public ChucVuRepostority chucvurepostority=new ChucVuRepostority();
   ArrayList<ChucVu>listchucvu=new ArrayList<>();

    @Override
    public ArrayList<ChucVu> getlistchucvu() {
       return (ArrayList<ChucVu>) chucvurepostority.getAll();
    }

    @Override
    public String addchucvu(ChucVu chucvu) {
        if(chucvurepostority.add(chucvu)){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }

    @Override
    public String deletechucvu(String ma) {
       if(chucvurepostority.delete(ma)){
           return "Thành công";
       }else{
           return "Thất bại";
       }
    }

    @Override
    public String update(ChucVu chucvu) {
        if(chucvurepostority.Update(chucvu)){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }
   
}
