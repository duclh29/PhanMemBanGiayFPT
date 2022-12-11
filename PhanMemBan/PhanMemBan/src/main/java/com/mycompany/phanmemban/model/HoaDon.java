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
@Table(name = "HoaDon")
@AllArgsConstructor
@NoArgsConstructor
public class HoaDon implements Serializable {

//    @Id
//    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER")
//    @GeneratedValue
    @Id
    @GeneratedValue()
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "IdNV")
    private NhanVien nhanVien;

    @ManyToOne
    @JoinColumn(name = "IdKM")
    private KhuyenMai khuyenMai;

    @ManyToOne
    @JoinColumn(name = "IdDT")
    private DoiTra doiTra;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "TinhTrang")
    private int tinhTrang;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt_KH")
    private String sdt_kh;

    @OneToMany(mappedBy = "hoaDon",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> donChiTiets;

    public HoaDon(KhachHang khachHang, NhanVien nhanVien, KhuyenMai khuyenMai, DoiTra doiTra, String ma, Date ngayTao, Date ngayThanhToan, int tinhTrang, String diaChi, String sdt_kh) {
        this.khachHang = khachHang;
        this.nhanVien = nhanVien;
        this.khuyenMai = khuyenMai;
        this.doiTra = doiTra;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.tinhTrang = tinhTrang;
        this.diaChi = diaChi;
        this.sdt_kh = sdt_kh;

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

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhuyenMai getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public DoiTra getDoiTra() {
        return doiTra;
    }

    public void setDoiTra(DoiTra doiTra) {
        this.doiTra = doiTra;
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

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
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

    public List<HoaDonChiTiet> getDonChiTiets() {
        return donChiTiets;
    }

    public void setDonChiTiets(List<HoaDonChiTiet> donChiTiets) {
        this.donChiTiets = donChiTiets;
    }

    public String hienthiTrangThai() {
        if (tinhTrang == 0) {
            return "Đã thanh toán";
        } else if (tinhTrang == 1) {
            return "Chưa thanh toán ";
        } else if (tinhTrang == 2) {
            return "Chờ thanh toán";
        }
        return "";
    }

}
