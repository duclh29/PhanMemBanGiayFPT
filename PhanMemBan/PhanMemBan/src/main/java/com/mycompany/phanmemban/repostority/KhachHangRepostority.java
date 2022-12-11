/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.KhachHang;
import com.mycompany.phanmemban.model.NhanVien;

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
public class KhachHangRepostority {
      public List<KhachHang> getAll() {
        List<KhachHang> khachhang = new ArrayList<>();
        Transaction trns = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            trns = session.beginTransaction();
            khachhang = session.createQuery("from KhachHang").list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return khachhang;
        

    }

    public Boolean add(KhachHang khachhang) {
        String check = null;
        Transaction transaction = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            session = new hibernateconfig().getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.save(khachhang);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public Boolean Update(KhachHang khachhang) {
        String check = null;
        Transaction transaction = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            
            transaction = session.beginTransaction();
            session.saveOrUpdate(khachhang);
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
            String hql = "delete KhachHang where ma=:ma";
            Query qr = session.createQuery(hql);
            qr.setParameter("ma", ma);
            qr.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;

    }

    public KhachHang checkTrungID(String id) {
        KhachHang khachhang = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        javax.persistence.Query q = session.createQuery("FROM KhachHang WHERE id = :id");
        q.setParameter("id", id);
        try {
            khachhang = (KhachHang) q.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
        return khachhang;
    }
    public KhachHang getOne(String ma) {     
        KhachHang khachHang = new KhachHang();
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            String query = "SELECT sp "
                    + "FROM KhachHang sp "
                    + "WHERE sp.ten LIKE :ten ";
            Query<KhachHang> hth = session.createQuery(query);
            hth.setParameter("ten","%"+ ma+"%");
            khachHang = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return khachHang;
    
    }
}
