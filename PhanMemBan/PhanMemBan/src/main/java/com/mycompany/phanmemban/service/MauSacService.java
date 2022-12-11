/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.phanmemban.service;

import com.mycompany.phanmemban.model.MauSac;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LONG
 */
public interface MauSacService {
   public ArrayList<MauSac>getlistmausac();
   public String addmausac(MauSac mausac);
   public String update(MauSac mausac);
   public String delete(String mausac);
   public List<String> listcbbmausac();
}
