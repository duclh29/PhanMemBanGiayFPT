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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "DoiTra")
public class DoiTra implements Serializable {

    @Id
    @GeneratedValue()
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private UUID id;

    @Column(name = "MaDT")
    private String maDT;

    @Column(name = "TenDT")
    private String tenDT;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "TrangThai")
    private int trangThai;

    @OneToMany(mappedBy = "doiTra",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDon> hoaDons;

    public DoiTra() {
    }

    public DoiTra(UUID id, String maDT, String tenDT, String moTa, int trangThai, List<HoaDon> hoaDons) {
        this.id = id;
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.hoaDons = hoaDons;
    }

    public DoiTra(UUID kL0LJ0, String doi_Mau, String string, String khong_thich_mau_do_muon_doi_sang_mau_tran, int i) {
        this.id = kL0LJ0;
        this.maDT = doi_Mau;
        this.tenDT = string;
        this.moTa = khong_thich_mau_do_muon_doi_sang_mau_tran;
        this.trangThai = i;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaDT() {
        return maDT;
    }

    public void setMaDT(String maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }

    public String hienthiTrangThai() {
        if (this.trangThai == 0) {
            return "Đổi trả thành công";
        } else {
            return "Đổi trả thất bại";
        }
    }

    @Override
    public String toString() {
        return maDT;
    }
    
}
