/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.service.impl;

import com.mycompany.phanmemban.model.HoaDonChiTiet;
import com.mycompany.phanmemban.repostority.ThongKeRepostority;
import com.mycompany.phanmemban.service.ThongKeService;
import java.util.ArrayList;

/**
 *
 * @author LONG
 */
public class ThongKeServiceimpl implements ThongKeService{
private ThongKeRepostority thongkerepostority=new ThongKeRepostority();
    @Override
    public ArrayList<HoaDonChiTiet> getlisthoadonct() {
       return (ArrayList<HoaDonChiTiet>) thongkerepostority.getAll();
    }
    
}
