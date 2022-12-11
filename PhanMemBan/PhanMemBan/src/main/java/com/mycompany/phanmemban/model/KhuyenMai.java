/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "KhuyenMai")
public class KhuyenMai implements Serializable {

//     @Id
//    @GeneratedValue(generator = "system-uuid")
//    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Id
    @GeneratedValue()
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private UUID id;

    @Column(name = "MaKM")
    private String maKM;

    @Column(name = "TenKM")
    private String tenKM;

    @Column(name = "PhanTramKM")
    private BigDecimal phanTranKM;

    @Column(name = "NgayBatDau")
    private Date ngayBatDau;

    @Column(name = "NgayKetThuc")
    private Date ngayKetThuc;

    @Column(name = "TrangThai")
    private int trangThai;

    @OneToMany(mappedBy = "khuyenMai",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDon> hoaDons;

    public KhuyenMai() {
    }

    public KhuyenMai(UUID id, String maKM, String tenKM, BigDecimal phanTranKM, Date ngayBatDau, Date ngayKetThuc, int trangThai, List<HoaDon> hoaDons) {
        this.id = id;
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.phanTranKM = phanTranKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.hoaDons = hoaDons;
    }

    public KhuyenMai(UUID id, String maKM, String tenKM, BigDecimal phanTranKM, Date ngayBatDau, Date ngayKetThuc, int trangThai) {
        this.id = id;
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.phanTranKM = phanTranKM;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMaKM() {
        return maKM;
    }

    public void setMaKM(String maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public BigDecimal getPhanTranKM() {
        return phanTranKM;
    }

    public void setPhanTranKM(BigDecimal phanTranKM) {
        this.phanTranKM = phanTranKM;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
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

    public String hienthitt() {
        if (this.trangThai == 1) {
            return "Còn hạn sử dụng";
        } else {
            return "Hết hạn sử dụng";
        }
    }

    @Override
    public String toString() {
        return maKM;
    }

   

}
