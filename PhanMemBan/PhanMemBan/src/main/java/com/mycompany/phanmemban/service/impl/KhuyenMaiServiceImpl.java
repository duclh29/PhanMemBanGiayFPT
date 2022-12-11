/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.service.impl;

import com.mycompany.phanmemban.model.KhuyenMai;
import com.mycompany.phanmemban.repostority.KhuyenMaiRepostority;
import com.mycompany.phanmemban.service.KhuyenMaiService;
import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class KhuyenMaiServiceImpl implements KhuyenMaiService {

    private KhuyenMaiRepostority khuyenMairepo = new KhuyenMaiRepostority();

    @Override
    public List<KhuyenMai> getALL() {
       return khuyenMairepo.getAll();
    }

    @Override
    public List<String> listcbbKM() {
        return khuyenMairepo.listcbbkm();
    }

    @Override
    public KhuyenMai getOne(String ma) {
        KhuyenMai khuyenMai = khuyenMairepo.getOne(ma.trim());
        return khuyenMai;
    }
    

}
