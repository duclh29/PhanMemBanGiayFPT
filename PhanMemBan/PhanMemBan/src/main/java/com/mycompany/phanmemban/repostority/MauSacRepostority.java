/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

import com.mycompany.phanmemban.model.MauSac;
import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.ChiTietSP;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author LONG
 */
public class MauSacRepostority {

    Session session = hibernateconfig.getFACTORY().openSession();

    public ArrayList<MauSac> getAllData() {
        Query query = session.createQuery("From MauSac");
        ArrayList<MauSac> list = (ArrayList<MauSac>) query.getResultList();
        return list;

    }

    public Boolean add(MauSac mausac) {
        String check = null;
        Transaction transaction = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            session = hibernateconfig.getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.save(mausac);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public Boolean Update(MauSac mausac) {
        String check = null;
        Transaction transaction = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            session = hibernateconfig.getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(mausac);
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
            String hql = "delete MauSac where ma=:ma";
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
        javax.persistence.Query q = session.createQuery("FROM MauSac WHERE id = :id");
        q.setParameter("id", id);
        try {
            MauSac = (MauSac) q.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
        return MauSac;
    }

    public List<String> listcbbmausac() {
        ArrayList<String> list = new ArrayList<>();
        try ( Session s = hibernateconfig.getFACTORY().openSession()) {
            String hql = "Select MauSac.ten from MauSac MauSac";
            TypedQuery<String> query = s.createQuery(hql, String.class);
            list = (ArrayList<String>) query.getResultList();
        }
        return list;
    }
}
