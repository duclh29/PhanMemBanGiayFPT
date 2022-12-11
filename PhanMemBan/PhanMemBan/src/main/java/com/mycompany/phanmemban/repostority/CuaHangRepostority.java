/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.CuaHang;
import com.mycompany.phanmemban.model.MauSac;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author LONG
 */
public class CuaHangRepostority {
     public List<CuaHang> getAll() {
        List<CuaHang> cuahang = new ArrayList<>();
        Transaction trns = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            trns = session.beginTransaction();
            cuahang = session.createQuery("from CuaHang").list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return cuahang;
        

    }

    public Boolean add(CuaHang cuahang) {
        String check = null;
        Transaction transaction = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            session = hibernateconfig.getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.save(cuahang);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public Boolean Update(CuaHang cuahang) {
        String check = null;
        Transaction transaction = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            session = hibernateconfig.getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(cuahang);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public Boolean delete(String ma) {
        Session session = hibernateconfig.getFACTORY().openSession();
        session = hibernateconfig.getFACTORY().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            String hql = "delete CuaHang where ma=:ma";
            Query qr = session.createQuery(hql);
            qr.setParameter("ma", ma);
            qr.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;

    }

    public MauSac checkTrungID(String id) {
        MauSac MauSac = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        javax.persistence.Query q = session.createQuery("FROM CuaHang WHERE id = :id");
        q.setParameter("id", id);
        try {
            MauSac = (MauSac) q.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
        return MauSac;
    }
}
