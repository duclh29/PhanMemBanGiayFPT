/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.phanmemban.view;

import com.mycompany.phanmemban.model.ChiTietSP;
import com.mycompany.phanmemban.model.KhachHang;
import com.mycompany.phanmemban.model.LoaiSP;
import com.mycompany.phanmemban.model.MauSac;
import com.mycompany.phanmemban.model.SanPham;
import com.mycompany.phanmemban.model.Size;
import com.mycompany.phanmemban.service.ChiTietSPService;
import com.mycompany.phanmemban.service.LoaiSPService;
import com.mycompany.phanmemban.service.MauSacService;
import com.mycompany.phanmemban.service.SanPhamService;
import com.mycompany.phanmemban.service.SizeService;
import com.mycompany.phanmemban.service.impl.ChiTietSPServiceImpl;
import com.mycompany.phanmemban.service.impl.LoaiSPServiceImpl;
import com.mycompany.phanmemban.service.impl.MauSacServicelmpl;
import com.mycompany.phanmemban.service.impl.SanPhamServiceImpl;
import com.mycompany.phanmemban.service.impl.SizeImpl;
import com.mycompany.phanmemban.viewmodel.ChiTietSPReponse;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//hjsdjdhf

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class QuanLySanPham extends javax.swing.JFrame {

    /**
     * Creates new form QuanLySanPham
     */
    private DefaultTableModel defaultTableModel;

    private DefaultComboBoxModel dcmms;
    private DefaultComboBoxModel dcmloaisp;
    private DefaultComboBoxModel dcmsanp;
    private DefaultComboBoxModel dcmsize;
    private DefaultComboBoxModel dcmtt;

    private MauSacService mauSacService = new MauSacServicelmpl();
    private SizeService sizeService = new SizeImpl();
    private LoaiSPService loaiSPService = new LoaiSPServiceImpl();
    private SanPhamService sanPhamService = new SanPhamServiceImpl();
    private ChiTietSPService chiTietSPService = new ChiTietSPServiceImpl();

    public QuanLySanPham() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Hệ Thống Quản Lý Cửa Hàng Bán Giày FPT");
        loadDatadssp(chiTietSPService.getAllData());
        loadCbbloaisp(chiTietSPService.getListLoaiSP());
        loadCbbmausac(chiTietSPService.getListMauSac());
        loadCbbsanpham((ArrayList<SanPham>) chiTietSPService.getListSP());
        loadCbbsize(chiTietSPService.getListSize());
        txtid.disable();
    }

    public void loadCbbmausac(List<MauSac> list) {
        dcmms = (DefaultComboBoxModel) cbbmsac.getModel();
        for (MauSac mauSac : list) {
            dcmms.addElement(mauSac);
        }
    }

    public void loadCbbloaisp(List<LoaiSP> list) {
        dcmloaisp = (DefaultComboBoxModel) cbbloaisp.getModel();
        for (LoaiSP loaiSP : list) {
            dcmloaisp.addElement(loaiSP);
        }
    }

    public void loadCbbsize(List<Size> list) {
        dcmsize = (DefaultComboBoxModel) cbbsize.getModel();
        for (Size size : list) {
            dcmsize.addElement(size);
        }
    }

    public void loadCbbsanpham(ArrayList<SanPham> list) {
        dcmsanp = (DefaultComboBoxModel) cbbsp.getModel();
        for (SanPham sanPham : list) {
            dcmsanp.addElement(sanPham);
        }
    }

    public void loadDatadssp(List<ChiTietSP> list) {
        defaultTableModel = (DefaultTableModel) tblctsp.getModel();
        defaultTableModel.setRowCount(0);
        for (ChiTietSP chiTietSP : list) {
            try {
                defaultTableModel.addRow(new Object[]{
                    chiTietSP.getChiTietSanPhamId(),
                    chiTietSP.getSanPham().getTen(),
                    chiTietSP.getLoaiSP().getTen(),
                    chiTietSP.getMauSac().getTen(),
                    chiTietSP.getSize().getSize(),
                    chiTietSP.getNamBH(),
                    chiTietSP.getSoLuongTon(),
                    chiTietSP.getMoTa(),
                    chiTietSP.getGiaNhap(),
                    chiTietSP.getGiaBan()
                });
            } catch (Exception e) {
            }
        }

    }

    public boolean checkdl() {
        if (txtnambh.getText().isEmpty()) {
            txtnambh.setText("Năm BH không được để trống");
            return false;
        } else if (txtnambh.getText().matches("[0-9]+") == false) {
            txtnambh.setText("Năm BH phải là số");
            return false;
        } else if (txtmota.getText().isEmpty()) {
            txtmota.setText("Mô tả không được để trống");
            return false;
        } else if (txtmota.getText().matches("[a-z A-Z]+") == false) {
            txtmota.setText("Mô tả phải là chữ");
            return false;
        } else if (txtsoluong.getText().isEmpty()) {
            txtsoluong.setText("Số lượng tồn không được để trống");
            return false;
        } else if (txtsoluong.getText().matches("[0-9]+") == false) {
            txtsoluong.setText("Số lượng tồn phải là số");
            return false;
        } else if (txtgianhap.getText().isEmpty()) {
            txtgianhap.setText("Gía nhập không được để trống");
            return false;
        } else if (txtgianhap.getText().matches("[0-20]+") == false) {
            txtgianhap.setText("Gía nhập phải là số");
            return false;
        } else if (txtgiaban.getText().isEmpty()) {
            txtgiaban.setText("Gía bán không được để trống");
            return false;
        }
//        } else if (txtgiaban.getText().matches("[0-20]+") == false) {
//            txtgiaban.setText("Gía bán phải là số");
//            return false;
//        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_timkiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        btnlammoi = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cbbtt = new javax.swing.JComboBox<>();
        txtgiaban = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtgianhap = new javax.swing.JTextField();
        cbbloaisp = new javax.swing.JComboBox<>();
        cbbsize = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtnambh = new javax.swing.JTextField();
        txtsoluong = new javax.swing.JTextField();
        txtmota = new javax.swing.JTextField();
        cbbsp = new javax.swing.JComboBox<>();
        cbbmsac = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnthemsp = new javax.swing.JButton();
        btnthemms = new javax.swing.JButton();
        btnthemloaisp = new javax.swing.JButton();
        btnsize = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblctsp = new javax.swing.JTable();

        jLabel11.setText("Sản Phẩm");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setForeground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Quản Lý Sản Phẩm");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setForeground(new java.awt.Color(51, 204, 255));

        jButton1.setText("Tìm kiếm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        btnthem.setIcon(new javax.swing.ImageIcon("C:\\Users\\lehuy\\OneDrive\\Documents\\PhanMemBanGiayFPT\\PhanMemBan\\src\\main\\resource\\images\\Save.png")); // NOI18N
        btnthem.setText("Lưu");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setIcon(new javax.swing.ImageIcon("C:\\Users\\lehuy\\OneDrive\\Documents\\PhanMemBanGiayFPT\\PhanMemBan\\src\\main\\resource\\images\\Refresh.png")); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setIcon(new javax.swing.ImageIcon("C:\\Users\\lehuy\\OneDrive\\Documents\\PhanMemBanGiayFPT\\PhanMemBan\\src\\main\\resource\\images\\Delete.png")); // NOI18N
        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnlammoi.setIcon(new javax.swing.ImageIcon("C:\\Users\\lehuy\\OneDrive\\Documents\\PhanMemBanGiayFPT\\PhanMemBan\\src\\main\\resource\\images\\Notes.png")); // NOI18N
        btnlammoi.setText("Mới");
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        jButton5.setText("<=");

        jButton6.setText("<<");

        jButton7.setText(">>");

        jButton8.setText("=>");

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel15.setText("Trạng Thái");

        jLabel16.setText("Giá Nhập");

        jLabel17.setText("ID");

        jLabel18.setText("Giá Bán");

        jLabel19.setText("Loại SP");

        jLabel20.setText("Size");

        jLabel14.setText("Sản Phẩm");

        jLabel21.setText("Số Lượng Tồn");

        jLabel22.setText("Mô Tả");

        jLabel9.setText("Màu Sắc");

        jLabel23.setText("Năm BH");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnthemsp.setIcon(new javax.swing.ImageIcon("C:\\Users\\lehuy\\OneDrive\\Documents\\PhanMemBanGiayFPT\\PhanMemBan\\src\\main\\resource\\images\\Add.png")); // NOI18N
        btnthemsp.setText("Thêm SanPham");
        btnthemsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemspActionPerformed(evt);
            }
        });

        btnthemms.setIcon(new javax.swing.ImageIcon("C:\\Users\\lehuy\\OneDrive\\Documents\\PhanMemBanGiayFPT\\PhanMemBan\\src\\main\\resource\\images\\Add.png")); // NOI18N
        btnthemms.setText("Thêm Màu Sắc");
        btnthemms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemmsActionPerformed(evt);
            }
        });

        btnthemloaisp.setIcon(new javax.swing.ImageIcon("C:\\Users\\lehuy\\OneDrive\\Documents\\PhanMemBanGiayFPT\\PhanMemBan\\src\\main\\resource\\images\\Add.png")); // NOI18N
        btnthemloaisp.setText("Thêm LoaiSP");
        btnthemloaisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemloaispActionPerformed(evt);
            }
        });

        btnsize.setIcon(new javax.swing.ImageIcon("C:\\Users\\lehuy\\OneDrive\\Documents\\PhanMemBanGiayFPT\\PhanMemBan\\src\\main\\resource\\images\\Add.png")); // NOI18N
        btnsize.setText("Thêm Size");
        btnsize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnthemsp)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnsize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnthemloaisp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnthemms, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnthemsp)
                .addGap(18, 18, 18)
                .addComponent(btnthemms)
                .addGap(35, 35, 35)
                .addComponent(btnthemloaisp)
                .addGap(27, 27, 27)
                .addComponent(btnsize)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbtt, 0, 227, Short.MAX_VALUE)
                            .addComponent(txtgianhap)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel23)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsoluong)
                            .addComponent(txtnambh, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtgiaban, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel19)
                                .addComponent(jLabel9)))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbsp, javax.swing.GroupLayout.Alignment.LEADING, 0, 223, Short.MAX_VALUE)
                            .addComponent(cbbloaisp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbmsac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel20))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbsize, 0, 223, Short.MAX_VALUE)
                            .addComponent(txtmota))))
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbmsac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbloaisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbsize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtmota)
                        .addGap(23, 23, 23)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgiaban, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnambh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbtt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tblctsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Sản Phẩm", "Loại SP", "Màu Sắc", "Size", "Năm BH", "Số Lượng Tồn", "Mô Tả", "Giá Nhập", "Giá Bán"
            }
        ));
        tblctsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblctspMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblctsp);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1313, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(btnthem)
                .addGap(41, 41, 41)
                .addComponent(btnsua)
                .addGap(43, 43, 43)
                .addComponent(btnxoa)
                .addGap(56, 56, 56)
                .addComponent(btnlammoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(57, 57, 57)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addGap(181, 181, 181))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(572, 572, 572))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(33, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton6)
                        .addComponent(jButton7)
                        .addComponent(jButton8))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnthem)
                        .addComponent(btnsua)
                        .addComponent(btnxoa)
                        .addComponent(btnlammoi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        if (checkdl()) {
            ChiTietSP ctsp = new ChiTietSP();
            ctsp.setLoaiSP((LoaiSP) cbbloaisp.getSelectedItem());
            ctsp.setSanPham((SanPham) cbbsp.getSelectedItem());
            ctsp.setSize((Size) cbbsize.getSelectedItem());
            ctsp.setMauSac((MauSac) cbbmsac.getSelectedItem());
            ctsp.setMoTa(txtmota.getText());
            ctsp.setSoLuongTon(Integer.valueOf(txtsoluong.getText()));
            ctsp.setNamBH(Integer.valueOf(txtnambh.getText()));
            ctsp.setGiaNhap(BigDecimal.valueOf(Double.valueOf(txtgianhap.getText())));
            ctsp.setGiaBan(BigDecimal.valueOf(Double.valueOf(txtgiaban.getText())));

            String result = chiTietSPService.add(ctsp);
            JOptionPane.showMessageDialog(this, result);
            loadDatadssp(chiTietSPService.getAllData());
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:

        if (checkdl()) {
            int r = tblctsp.getSelectedRow();
            ChiTietSP ctsp = new ChiTietSP();
            ctsp.setLoaiSP((LoaiSP) cbbloaisp.getSelectedItem());
            ctsp.setSanPham((SanPham) cbbsp.getSelectedItem());
            ctsp.setSize((Size) cbbsize.getSelectedItem());
            ctsp.setMauSac((MauSac) cbbmsac.getSelectedItem());

            ctsp.setMoTa(txtmota.getText());
            ctsp.setSoLuongTon(Integer.valueOf(txtsoluong.getText()));
            ctsp.setNamBH(Integer.valueOf(txtnambh.getText()));
            ctsp.setGiaNhap(BigDecimal.valueOf(Double.valueOf(txtgianhap.getText())));
            ctsp.setGiaBan(BigDecimal.valueOf(Double.valueOf(txtgiaban.getText())));

            chiTietSPService.update(ctsp);
            loadDatadssp(chiTietSPService.getAllData());
        }

    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        int r = tblctsp.getSelectedRow();
        UUID id = UUID.fromString(tblctsp.getValueAt(r, 0).toString());
        chiTietSPService.delete(id);
        loadDatadssp(chiTietSPService.getAllData());
    }//GEN-LAST:event_btnxoaActionPerformed

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        // TODO add your handling code here:
        int r = tblctsp.getSelectedRow();
        txtid.setText("");
        txtgiaban.setText("");
        txtgianhap.setText("");
        txtmota.setText("");
        txtnambh.setText("");
        txtsoluong.setText("");
        cbbloaisp.setSelectedIndex(0);
        cbbmsac.setSelectedIndex(0);
        cbbsize.setSelectedIndex(0);
        cbbsp.setSelectedIndex(0);
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void tblctspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblctspMouseClicked
        // TODO add your handling code here:
        int index = tblctsp.getSelectedRow();
        ChiTietSP ctsp = chiTietSPService.getAllData().get(index);
        txtid.setText(String.valueOf(ctsp.getChiTietSanPhamId()));
        txtgiaban.setText(String.valueOf(ctsp.getGiaBan()));
        cbbsize.setSelectedItem(ctsp.getSize().getSize());
        cbbloaisp.setSelectedItem(ctsp.getLoaiSP().getTen());
        cbbmsac.setSelectedItem(ctsp.getMauSac().getTen());
        cbbsp.setSelectedItem(ctsp.getSanPham().getTen());
        txtnambh.setText(String.valueOf(ctsp.getNamBH()));
        txtsoluong.setText(String.valueOf(ctsp.getSoLuongTon()));
        txtmota.setText(ctsp.getMoTa());
        txtgianhap.setText(String.valueOf(ctsp.getGiaNhap()));
    }//GEN-LAST:event_tblctspMouseClicked

    private void btnthemspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemspActionPerformed
        // TODO add your handling code here:
        SanPhamView sanPhamview = new SanPhamView();
        setLocationRelativeTo(null);
        sanPhamview.setVisible(true);
        sanPhamview.setDefaultCloseOperation(HomeView.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnthemspActionPerformed

    private void btnthemmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemmsActionPerformed
        // TODO add your handling code here:
        MauSacView mauSacView = new MauSacView();
        setLocationRelativeTo(null);
        mauSacView.setVisible(true);
        mauSacView.setDefaultCloseOperation(HomeView.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnthemmsActionPerformed

    private void btnthemloaispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemloaispActionPerformed
        // TODO add your handling code here:
        LoaiSPView loaiSPView = new LoaiSPView();
        setLocationRelativeTo(null);
        loaiSPView.setVisible(true);
        loaiSPView.setDefaultCloseOperation(HomeView.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnthemloaispActionPerformed

    private void btnsizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsizeActionPerformed
        // TODO add your handling code here:
        SizeView sizeView = new SizeView();
        setLocationRelativeTo(null);
        sizeView.setVisible(true);
        sizeView.setDefaultCloseOperation(HomeView.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnsizeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        String tenSanPham = txt_timkiem.getText().trim();
//        if (tenSanPham.length() <= 0) {
//            loadDatadssp(chiTietSPService.getAllData());
//        } else {
//            loadDatadssp(chiTietSPService.searchByNameSanPham(tenSanPham));
//        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLySanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnsize;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnthemloaisp;
    private javax.swing.JButton btnthemms;
    private javax.swing.JButton btnthemsp;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cbbloaisp;
    private javax.swing.JComboBox<String> cbbmsac;
    private javax.swing.JComboBox<String> cbbsize;
    private javax.swing.JComboBox<String> cbbsp;
    private javax.swing.JComboBox<String> cbbtt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblctsp;
    private javax.swing.JTextField txt_timkiem;
    private javax.swing.JTextField txtgiaban;
    private javax.swing.JTextField txtgianhap;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtmota;
    private javax.swing.JTextField txtnambh;
    private javax.swing.JTextField txtsoluong;
    // End of variables declaration//GEN-END:variables
}
