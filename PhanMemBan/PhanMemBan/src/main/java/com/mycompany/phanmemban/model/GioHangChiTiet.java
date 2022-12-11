/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "GioHangChiTiet")

public class GioHangChiTiet implements Serializable {

    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
    private UUID id;

    @Column(name = "IdGioHang")
    private String idGioHang;

    @Column(name = "IdChiTietSP")
    private String idChiTietSP;
    
    @ManyToOne
    @MapsId("idGioHang")
    @JoinColumn(name = "IdGioHang",referencedColumnName = "Id")
    private GioHang gioHang;
   
    @ManyToOne
    @MapsId("idChiTietSp")
    @JoinColumn(name = "IdChiTietSP",referencedColumnName = "Id")
    private ChiTietSP chiTietSp;
    
    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private BigDecimal donGia;

    @Column(name = "DonGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(UUID id, String idGioHang, String idChiTietSP, GioHang gioHang, ChiTietSP chiTietSp, int soLuong, BigDecimal donGia, BigDecimal donGiaKhiGiam) {
        this.id = id;
        this.idGioHang = idGioHang;
        this.idChiTietSP = idChiTietSP;
        this.gioHang = gioHang;
        this.chiTietSp = chiTietSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        this.idGioHang = idGioHang;
    }

    public String getIdChiTietSP() {
        return idChiTietSP;
    }

    public void setIdChiTietSP(String idChiTietSP) {
        this.idChiTietSP = idChiTietSP;
    }

    public GioHang getGioHang() {
        return gioHang;
    }

    public void setGioHang(GioHang gioHang) {
        this.gioHang = gioHang;
    }

    public ChiTietSP getChiTietSp() {
        return chiTietSp;
    }

    public void setChiTietSp(ChiTietSP chiTietSp) {
        this.chiTietSp = chiTietSp;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getDonGia() {
        return donGia;
    }

    public void setDonGia(BigDecimal donGia) {
        this.donGia = donGia;
    }

    public BigDecimal getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(BigDecimal donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    @Override
    public String toString() {
        return "GioHangChiTiet{" + "id=" + id + ", idGioHang=" + idGioHang + ", idChiTietSP=" + idChiTietSP + ", gioHang=" + gioHang + ", chiTietSp=" + chiTietSp + ", soLuong=" + soLuong + ", donGia=" + donGia + ", donGiaKhiGiam=" + donGiaKhiGiam + '}';
    }
    
    
}
