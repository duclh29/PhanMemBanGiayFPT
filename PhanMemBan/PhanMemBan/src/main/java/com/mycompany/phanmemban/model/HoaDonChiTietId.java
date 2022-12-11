/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class HoaDonChiTietId implements Serializable{

    private UUID idHoaDon;

    private UUID idChiTietSp;

    public HoaDonChiTietId() {
    }

    public HoaDonChiTietId(UUID idHoaDon, UUID idChiTietSp) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSp = idChiTietSp;
    }

    public UUID getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(UUID idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public UUID getIdChiTietSp() {
        return idChiTietSp;
    }

    public void setIdChiTietSp(UUID idChiTietSp) {
        this.idChiTietSp = idChiTietSp;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.idHoaDon);
        hash = 37 * hash + Objects.hashCode(this.idChiTietSp);
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
        final HoaDonChiTietId other = (HoaDonChiTietId) obj;
        if (!Objects.equals(this.idHoaDon, other.idHoaDon)) {
            return false;
        }
        return Objects.equals(this.idChiTietSp, other.idChiTietSp);
    }
}
