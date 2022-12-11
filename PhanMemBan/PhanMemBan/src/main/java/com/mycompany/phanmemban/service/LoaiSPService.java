/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.phanmemban.service;

<<<<<<< HEAD

import com.mycompany.phanmemban.model.LoaiSP;
import java.util.List;
//sssss/
/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public interface LoaiSPService {

    public List<LoaiSP> loadData();
=======
import com.mycompany.phanmemban.model.LoaiSP;
import java.util.List;

/**
 *
 * @author PC
 */
public interface LoaiSPService {
       public List<LoaiSP> loadData();
>>>>>>> 0d4c1d69402232055105ca16eebb03d553ba5fe0

    public String ADD(LoaiSP loaiSP);

    public String update(LoaiSP loaiSP);

    public String Delete(String ma);
    
    public List<String> listcbbloaisp();
<<<<<<< HEAD
    
=======
>>>>>>> 0d4c1d69402232055105ca16eebb03d553ba5fe0
}
