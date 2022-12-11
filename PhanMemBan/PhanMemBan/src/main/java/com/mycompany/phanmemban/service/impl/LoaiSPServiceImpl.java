/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.service.impl;

<<<<<<< HEAD

=======
>>>>>>> 0d4c1d69402232055105ca16eebb03d553ba5fe0
import com.mycompany.phanmemban.model.LoaiSP;
import com.mycompany.phanmemban.repostority.LoaiSPRepostority;
import com.mycompany.phanmemban.service.LoaiSPService;
import java.util.ArrayList;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author lehuy
 */
public class LoaiSPServiceImpl implements LoaiSPService {

=======
import java.util.List;

/**
 *
 * @author PC
 */
public class LoaiSPServiceImpl implements LoaiSPService{
>>>>>>> 0d4c1d69402232055105ca16eebb03d553ba5fe0
    private LoaiSPRepostority loaiSPRepostority = new LoaiSPRepostority();
    List<LoaiSP> listLoaiSP = new ArrayList<>();

    @Override
    public List<LoaiSP> loadData() {
        return loaiSPRepostority.getAllData();
    }

    @Override
    public String ADD(LoaiSP loaiSP) {
        boolean addLoaiSP = loaiSPRepostority.add(loaiSP);
        if (addLoaiSP) {
            return "Thêm thành công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String update(LoaiSP loaiSP) {
        boolean updateLoaiSP = loaiSPRepostority.Update(loaiSP);
        if (updateLoaiSP) {
            return "Cập nhật thành công";
        }
        return "Cập nhật thất bại";
    }

    @Override
    public String Delete(String ma) {
        boolean xoaLoaiSP = loaiSPRepostority.delete(ma);
        if (xoaLoaiSP) {
            return "Xóa thành công";
        }
        return "Xóa thất bại";
    }

    @Override
    public List<String> listcbbloaisp() {
        return loaiSPRepostority.listcbbloaisp();
    }
<<<<<<< HEAD

=======
>>>>>>> 0d4c1d69402232055105ca16eebb03d553ba5fe0
}
