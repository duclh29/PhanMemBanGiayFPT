/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.ChucVu;
import com.mycompany.phanmemban.model.HoaDonChiTiet;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author LONG
 */
public class ThongKeRepostority {
    public List<HoaDonChiTiet> getAll() {
        List<HoaDonChiTiet> hoadonct = new ArrayList<>();
        Transaction trns = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            trns = session.beginTransaction();
            hoadonct = session.createQuery("from HoaDonChiTiet").list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return hoadonct;
        

    }
}
