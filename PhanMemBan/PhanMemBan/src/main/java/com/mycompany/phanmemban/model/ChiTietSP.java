/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Data
@Table(name = "ChiTietSP")
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSP implements Serializable {

    @Id
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
    @GeneratedValue
//    @Id
//    @GeneratedValue()
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private UUID chiTietSanPhamId;

    @ManyToOne
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "IdSize")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "IdLoaiSP")
    private LoaiSP loaiSP;

    @Column(name = "NamBH")
    private int namBH;

    @Column(name = "MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;

    @Column(name = "GiaBan")
    private BigDecimal giaBan;

//    @OneToMany(mappedBy = "chiTietSP", fetch = FetchType.LAZY)
//    private List<GioHangChiTiet> listGHCT;
//    @OneToMany(mappedBy = "chiTietSP", fetch = FetchType.LAZY)
//    private List<HoaDonChiTiet> listHDCT;
//    public ChiTietSP() {
//    }

    public ChiTietSP(SanPham sanPham, Size size, MauSac mauSac, LoaiSP loaiSP, int namBH, String moTa, int soLuongTon, BigDecimal giaNhap, BigDecimal giaBan) {
        this.sanPham = sanPham;
        this.size = size;
        this.mauSac = mauSac;
        this.loaiSP = loaiSP;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }

   
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public SanPham getSanPham() {
//        return sanPham;
//    }
//
//    public void setSanPham(SanPham sanPham) {
//        this.sanPham = sanPham;
//    }
//
//    public Size getSize() {
//        return size;
//    }
//
//    public void setSize(Size size) {
//        this.size = size;
//    }
//
//    public MauSac getMauSac() {
//        return mauSac;
//    }
//
//    public void setMauSac(MauSac mauSac) {
//        this.mauSac = mauSac;
//    }
//
//    public LoaiSP getLoaiSP() {
//        return loaiSP;
//    }
//
//    public void setLoaiSP(LoaiSP loaiSP) {
//        this.loaiSP = loaiSP;
//    }
//
//    public int getNamBH() {
//        return namBH;
//    }
//
//    public void setNamBH(int namBH) {
//        this.namBH = namBH;
//    }
//
//    public String getMoTa() {
//        return moTa;
//    }
//
//    public void setMoTa(String moTa) {
//        this.moTa = moTa;
//    }
//
//    public int getSoLuongTon() {
//        return soLuongTon;
//    }
//
//    public void setSoLuongTon(int soLuongTon) {
//        this.soLuongTon = soLuongTon;
//    }
//
//    public BigDecimal getGiaNhap() {
//        return giaNhap;
//    }
//
//    public void setGiaNhap(BigDecimal giaNhap) {
//        this.giaNhap = giaNhap;
//    }
//
//    public BigDecimal getGiaBan() {
//        return giaBan;
//    }
//
//    public void setGiaBan(BigDecimal giaBan) {
//        this.giaBan = giaBan;
//    }
//
////    public List<GioHangChiTiet> getListGHCT() {
////        return listGHCT;
////    }
////
////    public void setListGHCT(List<GioHangChiTiet> listGHCT) {
////        this.listGHCT = listGHCT;
////    }
////    public List<HoaDonChiTiet> getListHDCT() {
////        return listHDCT;
////    }
////
////    public void setListHDCT(List<HoaDonChiTiet> listHDCT) {
////        this.listHDCT = listHDCT;
////    }
    

}
