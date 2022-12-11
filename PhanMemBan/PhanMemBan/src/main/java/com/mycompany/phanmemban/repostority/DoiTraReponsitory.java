/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.DoiTra;
import com.mycompany.phanmemban.model.KhuyenMai;
import com.mycompany.phanmemban.model.NhanVien;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class DoiTraReponsitory {

    public List<DoiTra> getAll() {
        List<DoiTra> khuyenMai = new ArrayList<>();
        Transaction trns = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            trns = session.beginTransaction();
            khuyenMai = session.createQuery("from DoiTra").list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
//            session.flush();
            session.close();
        }
        return khuyenMai;
    }

    public DoiTra getOne(String ma) {
        DoiTra doiTra = new DoiTra();
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            String query = "SELECT sp "
                    + "FROM DoiTra sp "
                    + "WHERE sp.ma LIKE :ma ";
            Query<DoiTra> hth = session.createQuery(query);
            hth.setParameter("ten", "%" + ma + "%");
            doiTra = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return doiTra;

    }
}
