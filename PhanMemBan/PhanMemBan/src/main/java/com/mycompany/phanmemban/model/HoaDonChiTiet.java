/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.model;

import java.io.Serializable;
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
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet implements Serializable {

//    @Id
//    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
//    @GeneratedValue
//    private UUID id;
    
    @Id
    @Column(name = "IdHoaDon")
    private UUID idHoaDon;

    @Id
    @Column(name = "IdChiTietSP")
    private UUID idChiTietSp;

    @ManyToOne
    @MapsId("idHoaDon")
    @JoinColumn(name = "IdHoaDon", referencedColumnName = "Id")
    private HoaDon hoaDon;

    @ManyToOne
    @MapsId("idChiTietSp")
    @JoinColumn(name = "IdChiTietSP", referencedColumnName = "Id")
    private ChiTietSP chiTietSp;

    @Column(name = "SoLuong")
    private int soLuong;

    @Column(name = "DonGia")
    private Double donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(UUID idHoaDon, UUID idChiTietSp, HoaDon hoaDon, ChiTietSP chiTietSp, int soLuong, Double donGia) {
        this.idHoaDon = idHoaDon;
        this.idChiTietSp = idChiTietSp;
        this.hoaDon = hoaDon;
        this.chiTietSp = chiTietSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
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

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
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

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Double thanhtien() {

        return soLuong * donGia;
    }

}
