/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.phanmemban.service;

import com.mycompany.phanmemban.model.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author LONG
 */
public interface ChucVuService {
    ArrayList<ChucVu>getlistchucvu();
    public String addchucvu(ChucVu chucvu);
    public String deletechucvu(String ma);
    public String update(ChucVu chucvu);
            
            
            
}
