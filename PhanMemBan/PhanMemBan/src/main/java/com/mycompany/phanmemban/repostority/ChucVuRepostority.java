/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.ChucVu;
import com.mycompany.phanmemban.model.MauSac;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author LONG
 */
public class ChucVuRepostority {
    public List<ChucVu> getAll() {
        List<ChucVu> chucvu = new ArrayList<>();
        Transaction trns = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            trns = session.beginTransaction();
            chucvu = session.createQuery("from ChucVu").list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return chucvu;
        

    }

    public Boolean add(ChucVu chucvu) {
        String check = null;
        Transaction transaction = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            session =hibernateconfig.getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.save(chucvu);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public Boolean Update(ChucVu chucvu) {
        String check = null;
        Transaction transaction = null;
        Session session =hibernateconfig.getFACTORY().openSession();
        try {
            session = hibernateconfig.getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(chucvu);
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
            String hql = "delete ChucVu where ma=:ma";
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
        javax.persistence.Query q = session.createQuery("FROM ChucVu WHERE id = :id");
        q.setParameter("id", id);
        try {
            MauSac = (MauSac) q.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
        return MauSac;
    }
    public List<ChucVu> paging(Long position) {
        List<ChucVu> listChucVus = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        String sql = "SELECT * FROM  ChucVu"
                + "ORDER BY id/n"
                + "OFFSET :position ROWS\n"
                + "FETCH NEXT 5 ROWS ONLY";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(ChucVu.class);
        query.setParameter("position", position);
        listChucVus = query.list();
        return listChucVus;
    }

    public Long countTotalRecords() {
        Session session = hibernateconfig.getFACTORY().openSession();
        String countQ = "Select count (cv.id) from ChucVu cv";
        Query countQuery = session.createQuery(countQ);
        return (Long) countQuery.getSingleResult();
    }
}
