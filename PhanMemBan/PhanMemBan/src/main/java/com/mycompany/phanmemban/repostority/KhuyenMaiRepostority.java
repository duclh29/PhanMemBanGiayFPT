/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.DoiTra;
import com.mycompany.phanmemban.model.KhuyenMai;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class KhuyenMaiRepostority {

    public List<KhuyenMai> getAll() {
        List<KhuyenMai> khuyenMai = new ArrayList<>();
        Transaction trns = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            trns = session.beginTransaction();
            khuyenMai = session.createQuery("from KhuyenMai").list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return khuyenMai;
    }
    public List<String> listcbbkm() {
        ArrayList<String> list = new ArrayList<>();
        try (Session s = hibernateconfig.getFACTORY().openSession()) {
            String hql = "Select km.maKM from KhuyenMai km";
            TypedQuery<String> query = s.createQuery(hql, String.class);
            list = (ArrayList<String>) query.getResultList();
        }
        return list;
    }
//    public Khuy findByIdKM(String maKM) {
//        UUID uuid;
//        try ( Session session = hibernateconfig.getFACTORY().openSession()) {
//            String statement = "select km.id from KhuyenMai km where km.maKM = :maKM";
//            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
//            query.setParameter("ten", maKM);
//            uuid = query.getSingleResult();
//        }
//        return uuid;
//    }
    public KhuyenMai getOne(String ma) {
        KhuyenMai khuyenMai = new KhuyenMai();
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            String query = "SELECT sp "
                    + "FROM KhuyenMai sp "
                    + "WHERE sp.maKM LIKE :ma ";
            Query<KhuyenMai> hth = session.createQuery(query);
            hth.setParameter("ma", "%" + ma + "%");
            khuyenMai = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return khuyenMai;

    }
    public static void main(String[] args) {
        System.out.println(new KhuyenMaiRepostority().getOne("K909NKEJHF33"));
    }
}
