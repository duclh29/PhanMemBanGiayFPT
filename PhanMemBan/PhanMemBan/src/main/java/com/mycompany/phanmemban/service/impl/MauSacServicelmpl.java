/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.service.impl;

import com.mycompany.phanmemban.model.MauSac;
import com.mycompany.phanmemban.repostority.MauSacRepostority;
import com.mycompany.phanmemban.service.MauSacService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LONG
 */
public class MauSacServicelmpl implements MauSacService{
    private MauSacRepostority mausacrepostority=new MauSacRepostority();
    ArrayList<MauSac>listmausac=new ArrayList<>();
    @Override
    public ArrayList<MauSac> getlistmausac() {
       return  mausacrepostority.getAllData();
    }

    @Override
    public String addmausac(MauSac mausac) {
        if(mausacrepostority.add(mausac)){
            return "Thành công";
        }else{
            return "Thất bại";
        }
    }

    @Override
    public String update(MauSac mausac) {
       if(mausacrepostority.Update(mausac)){
           return "Thành công";
       }else{
           return "thất bại";
       }
    }

    @Override
    public String delete(String mausac) {
       if(mausacrepostority.delete(mausac)){
           return "Thành công";
       }else{
           return "Thất bại";
       }
    }

    @Override
    public List<String> listcbbmausac() {
        return mausacrepostority.listcbbmausac();
    }
    
}
