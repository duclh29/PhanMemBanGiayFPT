/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.LoaiSP;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author PC
 */
public class LoaiSPRepostority {
    
    Session session = hibernateconfig.getFACTORY().openSession();

    public ArrayList<LoaiSP> getAllData() {
        Query query = session.createQuery("From LoaiSP");
        ArrayList<LoaiSP> list = (ArrayList<LoaiSP>) query.getResultList();
        return list;

    }

    public Boolean add(LoaiSP loaiSP) {
        String check = null;
        Transaction transaction = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            session = new hibernateconfig().getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.save(loaiSP);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public Boolean Update(LoaiSP loaiSP) {
        String check = null;
        Transaction transaction = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            session = new hibernateconfig().getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(loaiSP);
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
            String hql = "delete LoaiSP where ma=:ma";
            Query qr = session.createQuery(hql);
            qr.setParameter("ma", ma);
            qr.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;

    }

    public LoaiSP checkTrungID(String id) {
        LoaiSP loaiSP = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        javax.persistence.Query q = session.createQuery("FROM LoaiSP WHERE id = :id");
        q.setParameter("id", id);
        try {
            loaiSP = (LoaiSP) q.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
        return loaiSP;
    }
    public List<String> listcbbloaisp() {
        ArrayList<String> list = new ArrayList<>();
        try (Session s = hibernateconfig.getFACTORY().openSession()) {
            String hql = "Select LoaiSP.ten from LoaiSP LoaiSP";
            TypedQuery<String> query = s.createQuery(hql, String.class);
            list = (ArrayList<String>) query.getResultList();
        }
        return list;
    }
}
