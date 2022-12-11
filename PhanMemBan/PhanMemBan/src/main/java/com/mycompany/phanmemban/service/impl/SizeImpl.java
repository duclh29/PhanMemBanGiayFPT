/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.service.impl;

import com.mycompany.phanmemban.model.Size;
import com.mycompany.phanmemban.repostority.SizeRepository;
<<<<<<< HEAD
import com.mycompany.phanmemban.service.SizeService;
=======
>>>>>>> 51edad8e9c2428317c29833f36cb3c7f3beac012
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
<<<<<<< HEAD
public class SizeImpl implements SizeService {

    private SizeRepository srp = new SizeRepository();
    private Map<String, Object> mapMa = new HashMap<>();
    List<Size> listSZ = new ArrayList<>();

    public List<Size> getALlSize() {
        listSZ = new ArrayList<>();
        listSZ = srp.getAllSize();
        for (Size size : listSZ) {
            mapMa.put(size.getMa(), size);

        }

=======
public class SizeImpl {
     private SizeRepository srp = new SizeRepository();
    private Map<String, Object> mapMa = new HashMap<>();
    List<Size> listSZ = new ArrayList<>();

     public List<Size> getALlSize(){
     listSZ=new ArrayList<>();
     listSZ=srp.getAllSize();
        for (Size size : listSZ) {
            mapMa.put(size.getMa(), size);
            
        }
        
>>>>>>> 51edad8e9c2428317c29833f36cb3c7f3beac012
        return srp.getAllSize();
    }

    public String add(Size sz) {
        if (sz.getMa().isEmpty() || sz.getSize().isEmpty() || String.valueOf(sz.getTrangThai()).equals("")) {
            return "Không được bỏ trống";
        } else if (!sz.getSize().matches("[0-9]{0,30}")) {
            return "Phải điền số";
        } else if (mapMa.containsKey(sz.getMa())) {
            return "Trùng mã";
        } else {
            return srp.add(sz);
        }
    }

    public String update(Size sz) {
        if (sz.getMa().isEmpty() || sz.getSize().isEmpty() || String.valueOf(sz.getTrangThai()).equals("")) {
            return "Không được bỏ trống";
        } else if (!sz.getSize().matches("[0-9]{0,30}")) {
            return "Phải điền số";
        } else if (!mapMa.containsKey(sz.getMa())) {
            return "Không được sửa mã";
        } else {
            return srp.update(sz);
        }
    }

    public String delete(String ma) {
        return srp.delete(ma);
    }

<<<<<<< HEAD
    @Override
=======
>>>>>>> 51edad8e9c2428317c29833f36cb3c7f3beac012
    public List<String> listcbbsize() {
        return srp.listcbbsize();
    }
}
