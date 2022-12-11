/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.phanmemban.service;

import com.mycompany.phanmemban.model.Size;
import java.util.List;

/**
 *
 * @author PC
 */
public interface SizeService {

    public List<Size> getALlSize();

    String add(Size sz);

    String update(Size sz);

    String delete(String ma);

    public List<String> listcbbsize();
}
