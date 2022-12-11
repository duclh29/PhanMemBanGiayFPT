/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.phanmemban.service;

import com.mycompany.phanmemban.model.KhuyenMai;
import com.mycompany.phanmemban.model.LoaiSP;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface KhuyenMaiService {

    public List<KhuyenMai> getALL();
    
    public List<String> listcbbKM();
    
    public KhuyenMai getOne(String ma);
}
