/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class GioHangChiTietId implements Serializable{

    private String idGioHang;
    private String idChiTietSp;

    public GioHangChiTietId() {
    }

    public GioHangChiTietId(String idGioHang, String idChiTietSp) {
        this.idGioHang = idGioHang;
        this.idChiTietSp = idChiTietSp;
    }

    public String getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        this.idGioHang = idGioHang;
    }

    public String getIdChiTietSp() {
        return idChiTietSp;
    }

    public void setIdChiTietSp(String idChiTietSp) {
        this.idChiTietSp = idChiTietSp;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.idGioHang);
        hash = 29 * hash + Objects.hashCode(this.idChiTietSp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GioHangChiTietId other = (GioHangChiTietId) obj;
        if (!Objects.equals(this.idGioHang, other.idGioHang)) {
            return false;
        }
        if (!Objects.equals(this.idChiTietSp, other.idChiTietSp)) {
            return false;
        }
        return true;
    }
}
