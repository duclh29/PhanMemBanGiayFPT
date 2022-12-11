/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Data
@Table(name = "SanPham")
@AllArgsConstructor
@NoArgsConstructor
public class SanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID idSP;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "TrangThai")
    private int trangThai;
    @Column(name = "NgayTao")
    private Date ngayTao;
    @Column(name = "NgaySua")
    private Date ngaySua;

    @OneToMany(mappedBy = "chiTietSanPhamId",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ChiTietSP> chiTietSPs;
////
////    public SanPham() {
////    }
//
//  
//
////    public List<ChiTietSP> getChiTietSPs() {
////        return chiTietSPs;
////    }
////
////    public void setChiTietSPs(List<ChiTietSP> chiTietSPs) {
////        this.chiTietSPs = chiTietSPs;
////    }
////
////    public SanPham(String ma, String ten, int trangThai, Date ngayTao, Date ngaySua) {
////        this.ma = ma;
////        this.ten = ten;
////        this.trangThai = trangThai;
////        this.ngayTao = ngayTao;
////        this.ngaySua = ngaySua;
////    }
////
////    public UUID getId() {
////        return id;
////    }
////
////    public void setId(UUID id) {
////        this.id = id;
////    }
////
////    public String getMa() {
////        return ma;
////    }
////
////    public void setMa(String ma) {
////        this.ma = ma;
////    }
////
////    public String getTen() {
////        return ten;
////    }
////
////    public void setTen(String ten) {
////        this.ten = ten;
////    }
////
////    public int getTrangThai() {
////        return trangThai;
////    }
////
////    public void setTrangThai(int trangThai) {
////        this.trangThai = trangThai;
////    }
////
////    public Date getNgayTao() {
////        return ngayTao;
////    }
////
////    public void setNgayTao(Date ngayTao) {
////        this.ngayTao = ngayTao;
////    }
////
////    public Date getNgaySua() {
////        return ngaySua;
////    }
////
////    public void setNgaySua(Date ngaySua) {
////        this.ngaySua = ngaySua;
////    }
////

    public String trangThaiSanPham() {
        if (trangThai == 0) {
            return "Còn Hàng";
        } else {
            return "Hết Hàng";
        }
    }

////
    public Object[] toRowData() {
        return new Object[]{
            idSP, ma, ten, trangThaiSanPham(), ngayTao, ngaySua
        };
    }

////
    @Override
    public String toString() {
        return ten;
    }
}
//
//    
//
//}
