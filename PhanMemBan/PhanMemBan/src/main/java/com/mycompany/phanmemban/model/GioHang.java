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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@Entity
@Table(name = "GioHang")
public class GioHang implements Serializable {

    @Id
    @Column(name = "Id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;

    @Column(name = "IdNV")
    private String idNv;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt_KH")
    private String sdt_kh;

    @Column(name = "TinhTrang")
    private int tinhTrang;

    @OneToMany(mappedBy = "gioHang",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<GioHangChiTiet> gioHangChiTiets;

    public GioHang() {
    }

    public GioHang(UUID id, KhachHang khachHang, String idNv, String ma, Date ngayTao, Date ngayThanhToan, String diaChi, String sdt_kh, int tinhTrang, List<GioHangChiTiet> gioHangChiTiets) {
        this.id = id;
        this.khachHang = khachHang;
        this.idNv = idNv;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.diaChi = diaChi;
        this.sdt_kh = sdt_kh;
        this.tinhTrang = tinhTrang;
        this.gioHangChiTiets = gioHangChiTiets;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getIdNv() {
        return idNv;
    }

    public void setIdNv(String idNv) {
        this.idNv = idNv;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt_kh() {
        return sdt_kh;
    }

    public void setSdt_kh(String sdt_kh) {
        this.sdt_kh = sdt_kh;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public List<GioHangChiTiet> getGioHangChiTiets() {
        return gioHangChiTiets;
    }

    public void setGioHangChiTiets(List<GioHangChiTiet> gioHangChiTiets) {
        this.gioHangChiTiets = gioHangChiTiets;
    }

    @Override
    public String toString() {
        return "GioHang{" + "id=" + id + ", khachHang=" + khachHang + ", idNv=" + idNv + ", ma=" + ma + ", ngayTao=" + ngayTao + ", ngayThanhToan=" + ngayThanhToan + ", diaChi=" + diaChi + ", sdt_kh=" + sdt_kh + ", tinhTrang=" + tinhTrang + ", gioHangChiTiets=" + gioHangChiTiets + '}';
    }

}
