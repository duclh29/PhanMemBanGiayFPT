/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.phanmemban.view;

import com.mycompany.phanmemban.model.ChucVu;
import com.mycompany.phanmemban.model.CuaHang;
import com.mycompany.phanmemban.model.KhachHang;
import com.mycompany.phanmemban.model.NhanVien;
import com.mycompany.phanmemban.service.ChucVuService;
import com.mycompany.phanmemban.service.CuaHangService;
import com.mycompany.phanmemban.service.NhanVienService;
import com.mycompany.phanmemban.service.impl.ChucVulmpl;
import com.mycompany.phanmemban.service.impl.CuahangServicelmpl;
import com.mycompany.phanmemban.service.impl.NhanVienServicelmpl;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LONG
 */
public class QuanLyNhanVien extends javax.swing.JFrame {

    private DefaultTableModel defaultTableModel;
    private DefaultComboBoxModel defaultComboBoxModel;
    private CuaHangService cuahangservice = new CuahangServicelmpl();
    private ChucVuService chucvuservice = new ChucVulmpl();
    private NhanVienService nhanvienservice = new NhanVienServicelmpl();

    /**
     * Creates new form QuanLyNhanVien
     */
    public QuanLyNhanVien() {
        initComponents();
        setLocationRelativeTo(null);
        loadData(nhanvienservice.getlistnhanvien());
        loadCombobox(nhanvienservice.getlistcuahang());
        loadComboboxmh(nhanvienservice.getlistchucvu());
        cb_trangthai.addItem("Đang làm viêc");
        cb_trangthai.addItem("Đang nghỉ ca");
        cb_trangthai.setSelectedIndex(0);
        setTitle("Hệ Thống Quản Lý Cửa Hàng Bán Giày FPT");
    }

    public void loadData(List<NhanVien> list) {
        defaultTableModel = (DefaultTableModel) tbl_bang.getModel();
        defaultTableModel.setRowCount(0);
        for (NhanVien nhanvien : list) {
            defaultTableModel.addRow(new Object[]{
                //                nhanvien.getId(),
                nhanvien.getMa(),
                nhanvien.getTen(),
                nhanvien.gGioiTinh(),
                nhanvien.getNgaySinh(),
                nhanvien.getDiaChi(),
                nhanvien.getSdt(),
                nhanvien.getMatKhau(),
                nhanvien.getCuaHang(),
                nhanvien.getChucVu(),
                nhanvien.hienthiTrangThai()
            });
        }
    }

//    public void loadcbb() {
//        ArrayList<String> listtt = new ArrayList<>();
//        listtt.add("Đang làm việc");
//        listtt.add("Đang nghỉ ca");
//        defaultComboBoxModel = (DefaultComboBoxModel) cb_trangthai.getModel();
//        for (String tt : listtt) {
//            defaultComboBoxModel.addElement(tt);
//        }
//        
//        
//
//    }
    private void loadCombobox(ArrayList<CuaHang> list) {
        defaultComboBoxModel = (DefaultComboBoxModel) cb_cuahang.getModel();
        for (CuaHang cuahang : list) {
            defaultComboBoxModel.addElement(cuahang);
        }
    }

    private void loadComboboxmh(ArrayList<ChucVu> list) {
        defaultComboBoxModel = (DefaultComboBoxModel) cb_chucvu.getModel();
        for (ChucVu chucvu : list) {
            defaultComboBoxModel.addElement(chucvu);
        }
    }
    private Map<String, Object> mapMa = new HashMap<>();

    public boolean checkDL() {
        String p_ten = "[a-zA-Z0-9]+";
        String sdt = "[0-9]{0,30}";
        if (txt_ma.getText().equals("")) {
            txt_ma.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Mã Nhân Viên không được trống");
            return false;
        } else if (txt_ma.getText().matches(p_ten) == false) {
            txt_ma.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Mã Nhân Vien không đúng định dạng");
            return false;
        }
        if (txt_ten.getText().equals("")) {
            txt_ten.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Tên Nhân Viên không được trống");
            return false;
        } else if (txt_ten.getText().matches(p_ten) == false) {
            txt_ten.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Tên Nhân Viên sai định dạng");
            return false;
        }
        if (txt_pass.getText().equals("")) {
            txt_pass.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Mật khẩu Nhân Viên không được trống");
            return false;
        } else if (txt_pass.getText().matches(p_ten) == false) {
            txt_pass.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Mật khẩu Nhân Viên sai định dạng");
            return false;
        }
        if (txt_sdt.getText().equals("")) {
            txt_sdt.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Số điện thoại ko được bỏ trống");
            return false;
        } else if (txt_sdt.getText().matches(sdt) == false) {
            txt_sdt.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Nhập sai định dạng");
            return false;
        }
        if (txt_diachi.getText().equals("")) {
            txt_diachi.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Số điện thoại ko được bỏ trống");
            return false;
//        }else if(txt_diachi.getText().matches(p_ten)==false){
//            txt_diachi.setBackground(Color.red);
//            JOptionPane.showMessageDialog(this, "Nhập sai định dạng");
//            return false;
        }
        if (txt_ngaysinh.getText().equals("")) {
            txt_ngaysinh.setBackground(Color.red);
            JOptionPane.showMessageDialog(this, "Ngày sinh ko được bỏ trống");
            return false;
        }
        

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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        rdo_nam = new javax.swing.JRadioButton();
        rdo_nu = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        txt_pass = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        txt_ngaysinh = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_diachi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_sdt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cb_cuahang = new javax.swing.JComboBox<>();
        cb_trangthai = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        cb_chucvu = new javax.swing.JComboBox<>();
        txt_ma = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_bang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setText("Quản Lý Nhân Viên");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Nhân Viên"));

        jLabel1.setText("Mã NV:");

        jLabel2.setText("Tên NV:");

        jLabel3.setText("GioiTinh:");

        buttonGroup1.add(rdo_nam);
        rdo_nam.setText("Nam");

        buttonGroup1.add(rdo_nu);
        rdo_nu.setText("Nữ");

        jLabel4.setText("Ngày Sinh:");

        jLabel10.setText("Trạng Thái:");

        jButton4.setText("Tìm Kiếm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Địa Chỉ:");

        jLabel6.setText("Sđt");

        jLabel7.setText("Mật Khẩu");

        jLabel8.setText("Chức Vụ");

        jLabel9.setText("Cửa Hàng");

        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Sửa");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        jButton5.setText("Thêm CH");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Thêm CV");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(153, 153, 153)
                                .addComponent(rdo_nu, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rdo_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ma, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                                    .addComponent(txt_ten)
                                    .addComponent(txt_ngaysinh)
                                    .addComponent(txt_diachi))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(71, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(51, 51, 51)
                        .addComponent(jButton2)
                        .addGap(62, 62, 62)
                        .addComponent(jButton3)
                        .addGap(63, 63, 63)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cb_chucvu, 0, 250, Short.MAX_VALUE)
                        .addComponent(txt_pass, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_sdt, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cb_cuahang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cb_trangthai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(39, 39, 39)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rdo_nu)
                                        .addComponent(rdo_nam))))
                            .addGap(32, 32, 32)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addGap(37, 37, 37)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_ma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_cuahang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cb_chucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_diachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(cb_trangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Bảng Nhân Viên"));

        tbl_bang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên NV", "Giới Tính", "Ngày Sinh", "Địa Chỉ", "Sđt", "Mật Khẩu", "Tên Cửa Hàng", "Tên Chức Vụ", "Trạng Thái"
            }
        ));
        tbl_bang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_bangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_bang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(419, 419, 419)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (checkDL()) {
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            NhanVien nhanvien = new NhanVien();
            nhanvien.setMa(txt_ma.getText());
            nhanvien.setTen(txt_ten.getText());
            try {

                Date ngaysinh = df.parse(txt_ngaysinh.getText());
                nhanvien.setNgaySinh(ngaysinh);

            } catch (ParseException ex) { 
                
                JOptionPane.showMessageDialog(this, "nhập đúng định dạng");
                return;

            }
            try{
                mapMa.containsKey(nhanvien.getMa());
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "không được trùng");
                return;
            }
//            NhanVien nv = new NhanVien();
//        if (mapMa.containsKey(nv.getMa())) {
//            JOptionPane.showMessageDialog(this, "Không được trùng");
//       
//           return;
//           
//        }

            nhanvien.setGioiTinh(rdo_nam.isSelected() ? 0 : 1);
            nhanvien.setDiaChi(txt_diachi.getText());
            nhanvien.setSdt(txt_sdt.getText());
            nhanvien.setMatKhau(txt_pass.getText());
            nhanvien.setCuaHang((CuaHang) cb_cuahang.getSelectedItem());
            nhanvien.setChucVu((ChucVu) cb_chucvu.getSelectedItem());

            nhanvien.setTrangThai(cb_trangthai.getSelectedIndex());

            String result = nhanvienservice.addnhanvien(nhanvien);
            JOptionPane.showMessageDialog(this, result);
            loadData(nhanvienservice.getlistnhanvien());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String ma = (txt_ma.getText());
        String result = nhanvienservice.deletenhanvien(ma);
        JOptionPane.showMessageDialog(this, result);
        loadData(nhanvienservice.getlistnhanvien());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tbl_bangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_bangMouseClicked
        // TODO add your handling code here:
        int index = tbl_bang.getSelectedRow();
        NhanVien ctsp = nhanvienservice.getlistnhanvien().get(index);
//        txtid.setText(String.valueOf(ctsp.getId()));
        txt_ma.setText(String.valueOf(ctsp.getMa()));
        cb_chucvu.setSelectedItem(ctsp.getChucVu().getTen());
        cb_cuahang.setSelectedItem(ctsp.getCuaHang().getTen());
//        cbbmsac.setSelectedItem(ctsp.getMauSac().getTen());
//        cbbsp.setSelectedItem(ctsp.getSanPham().getTen());
        txt_ten.setText(String.valueOf(ctsp.getTen()));
        txt_sdt.setText(String.valueOf(ctsp.getSdt()));
        txt_diachi.setText(String.valueOf(ctsp.getDiaChi()));
        txt_pass.setText(String.valueOf(ctsp.getMatKhau()));
        txt_ngaysinh.setText(String.valueOf(ctsp.getNgaySinh()));
        cb_trangthai.setSelectedItem(ctsp.getTrangThai());
        if (tbl_bang.getValueAt(index, 2).equals("Nam")) {
            rdo_nam.setSelected(true);
        } else {
            rdo_nu.setSelected(true);
        }
    }//GEN-LAST:event_tbl_bangMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (checkDL()) {
            int r = tbl_bang.getSelectedRow();
            SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
            NhanVien nhanvien = new NhanVien();
            nhanvien.setMa(txt_ma.getText());
            nhanvien.setTen(txt_ten.getText());
            java.sql.Date ngayt = new java.sql.Date(new java.util.Date().getTime());
            nhanvien.setNgaySinh(ngayt);
            nhanvien.setGioiTinh(rdo_nam.isSelected() ? 0 : 1);
            nhanvien.setDiaChi(txt_diachi.getText());
            nhanvien.setSdt(txt_sdt.getText());
            nhanvien.setMatKhau(txt_pass.getText());
            nhanvien.setCuaHang((CuaHang) cb_cuahang.getSelectedItem());
            nhanvien.setChucVu((ChucVu) cb_chucvu.getSelectedItem());

            nhanvien.setTrangThai(cb_trangthai.getSelectedIndex());

            String result = nhanvienservice.addnhanvien(nhanvien);
            JOptionPane.showMessageDialog(this, result);
            loadData(nhanvienservice.getlistnhanvien());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        CuaHangView cuaHangView = new CuaHangView();
        cuaHangView.setLocationRelativeTo(null);
        cuaHangView.setVisible(true);
        cuaHangView.setDefaultCloseOperation(QuanLyNhanVien.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        ChucVuView chuaVuView = new ChucVuView();
        chuaVuView.setLocationRelativeTo(null);
        chuaVuView.setVisible(true);
        chuaVuView.setDefaultCloseOperation(QuanLyNhanVien.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNhanVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_chucvu;
    private javax.swing.JComboBox<String> cb_cuahang;
    private javax.swing.JComboBox<String> cb_trangthai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JRadioButton rdo_nam;
    private javax.swing.JRadioButton rdo_nu;
    private javax.swing.JTable tbl_bang;
    private javax.swing.JTextField txt_diachi;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ngaysinh;
    private javax.swing.JPasswordField txt_pass;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
