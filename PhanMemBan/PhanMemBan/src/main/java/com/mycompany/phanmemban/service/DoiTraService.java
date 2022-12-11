/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.phanmemban.service;

import com.mycompany.phanmemban.model.DoiTra;
import com.mycompany.phanmemban.model.KhuyenMai;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface DoiTraService {

    public ArrayList<DoiTra> getALL();

    public List<String> listcbbDT();

    public DoiTra getOne(String ma);
}
