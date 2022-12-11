/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC
 */
@Entity
@Table(name = "Size")
public class Size implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID Id;
    private String ma;
    private String size;
    private int trangThai;
    private Date ngayTao;
    private Date ngaySua;

    public Size() {
    }

    public Size(UUID Id, String ma, String size, int trangThai, Date ngayTao, Date ngaySua, List<ChiTietSP> chiTietSPs) {
    }

    public Size(UUID Id, String ma, String size, int trangThai, Date ngayTao, Date ngaySua) {

        this.Id = Id;
        this.ma = ma;
        this.size = size;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public Size(String ma, String size, int trangThai) {
        this.ma = ma;
        this.size = size;
        this.trangThai = trangThai;
    }

    public Size(String ma, String size, int trangThai, Date ngayTao, Date ngaySua) {
        this.ma = ma;
        this.size = size;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
    }

    public UUID getId() {
        return Id;
    }

    public void setId(UUID Id) {
        this.Id = Id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String trangThai() {
        if (trangThai == 1) {
            return "Còn Hàng";
        } else {
            return "Hết Hàng";
        }
    }

    @Override
    public String toString() {
        return size;
    }
    
}
