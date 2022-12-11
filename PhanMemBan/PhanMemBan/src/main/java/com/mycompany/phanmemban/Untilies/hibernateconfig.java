/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.phanmemban.Untilies;

import com.mycompany.phanmemban.model.ChiTietSP;
import com.mycompany.phanmemban.model.ChucVu;
import com.mycompany.phanmemban.model.CuaHang;
import com.mycompany.phanmemban.model.DoiTra;
import com.mycompany.phanmemban.model.GioHang;
import com.mycompany.phanmemban.model.GioHangChiTiet;
import com.mycompany.phanmemban.model.HoaDon;
import com.mycompany.phanmemban.model.HoaDonChiTiet;
import com.mycompany.phanmemban.model.KhachHang;
import com.mycompany.phanmemban.model.KhuyenMai;
import com.mycompany.phanmemban.model.LoaiSP;
import com.mycompany.phanmemban.model.MauSac;
import com.mycompany.phanmemban.model.NhanVien;
import com.mycompany.phanmemban.model.SanPham;
import com.mycompany.phanmemban.model.Size;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class hibernateconfig {

    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();
        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=QL_BAN_GIAY_ADIDAS");
        properties.put(Environment.USER, "sa");
        properties.put(Environment.PASS, "lehuynhduc29");
        properties.put(Environment.SHOW_SQL, "true");
        //gen DB tự động
        //properties.put(Environment.HBM2DDL_AUTO, "create");

        conf.setProperties(properties);
        conf.addAnnotatedClass(LoaiSP.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(NhanVien.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(HoaDonChiTiet.class);
        conf.addAnnotatedClass(KhachHang.class);
        conf.addAnnotatedClass(KhuyenMai.class);
        conf.addAnnotatedClass(GioHangChiTiet.class);
        conf.addAnnotatedClass(DoiTra.class);
        conf.addAnnotatedClass(ChiTietSP.class);
        conf.addAnnotatedClass(MauSac.class);
        conf.addAnnotatedClass(SanPham.class);
        conf.addAnnotatedClass(Size.class);
        conf.addAnnotatedClass(HoaDon.class);
        conf.addAnnotatedClass(GioHang.class);

        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        getFACTORY();
    }

}
