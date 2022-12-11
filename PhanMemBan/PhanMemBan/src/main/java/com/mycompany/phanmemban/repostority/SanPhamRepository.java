/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.SanPham;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class SanPhamRepository {

    Session ss = hibernateconfig.getFACTORY().openSession();

    public ArrayList<SanPham> getAll() {
        Query query = ss.createQuery(
                "FROM SanPham ");

        ArrayList<SanPham> list = (ArrayList<SanPham>) query.getResultList();
        return list;

    }

    public Boolean delete(String ma) {
        Session session = hibernateconfig.getFACTORY().openSession();
        session = hibernateconfig.getFACTORY().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            String hql = "delete SanPham where ma=:ma";
            org.hibernate.query.Query qr = session.createQuery(hql);
            qr.setParameter("ma", ma);
            qr.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;

    }

    public Boolean add(SanPham sanpham) {
        String check = null;
        Transaction transaction = null;
        Session ss = hibernateconfig.getFACTORY().openSession();
        try {
            ss = new hibernateconfig().getFACTORY().openSession();
            transaction = ss.beginTransaction();
            ss.save(sanpham);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public SanPham getOne(String id) {
        SanPham sp = new SanPham();
        try {
            String query = "delete from SanPham where id = :id";
            sp = (SanPham) ss.createQuery(query).setParameter("id", id).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return sp;
    }
    public List<String> listcbbsanpham() {
        ArrayList<String> list = new ArrayList<>();
        try (Session s = hibernateconfig.getFACTORY().openSession()) {
            String hql = "Select SanPham.ten from SanPham SanPham";
            TypedQuery<String> query = s.createQuery(hql, String.class);
            list = (ArrayList<String>) query.getResultList();
        }
        return list;
    }

}
