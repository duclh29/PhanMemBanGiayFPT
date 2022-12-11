/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.ChiTietSP;
import com.mycompany.phanmemban.model.HoaDon;
import com.mycompany.phanmemban.viewmodel.ChiTietSPReponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.persistence.TypedQuery;
import jdk.javadoc.doclet.Reporter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class ChiTietSPRepostority {

    /**
     * @param args the command line arguments
     */
    Session session = hibernateconfig.getFACTORY().openSession();

    public List<ChiTietSP> getAllData() {
        String hql = "from ChiTietSP";
        try {
            session = new hibernateconfig().getFACTORY().openSession();
            javax.persistence.Query query = session.createQuery(hql);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public List<ChiTietSPReponse> getAll() {
        Transaction transaction = null;
        List<ChiTietSPReponse> list = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            String query = " SELECT new com.mycompany.phanmemban.viewmodel.ChiTietSPReponse "
                    + " ( ct.chiTietSanPhamId AS idChiTiet ,"
                    + " ct.sanPham.ma  AS maSanPham , "
                    + " ct.sanPham.ten AS tenSanPham ,"
                    + " ct.namBH AS namBaoHanh ,"
                    + " ct.moTa AS moTa ,"
                    + " ct.soLuongTon AS soLuongSanPham ,"
                    + " ct.giaNhap AS giaNhap ,"
                    + " ct.giaBan AS giaBan "
                    + " )"
                    + " FROM ChiTietSP ct "
                    + " JOIN SanPham sp ON sp.idSP = ct.sanPham.idSP";
            list = session.createQuery(query).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }

    public Boolean add(ChiTietSP chiTietSP) {
        Transaction transaction = null;

        try ( Session se = hibernateconfig.getFACTORY().openSession()) {
            transaction = se.beginTransaction();
            se.save(chiTietSP);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public UUID delete(UUID id) {
        try ( Session s = hibernateconfig.getFACTORY().openSession()) {
            Transaction t = s.getTransaction();
            t.begin();
            try {
                String hql = "delete ChiTietSP where id = :id";
                Query q = s.createQuery(hql);
                q.setParameter("id", id);
                int result = q.executeUpdate();
                t.commit();
            } catch (Exception e) {
            }
        }
        return id;
    }

    public void update(ChiTietSP chiTietSp) {
        String check = null;
        Transaction transaction = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            session = hibernateconfig.getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(chiTietSp);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
    public List<ChiTietSPReponse> searchByNameTenSp(String tenSanPham) {
        Transaction transaction = null;
        List<ChiTietSPReponse> list = new ArrayList<>();
        try {
            transaction = session.beginTransaction();
            String query = " SELECT new com.mycompany.phanmemban.viewmodel.ChiTietSPReponse "
                    + " ( ct.chiTietSanPhamId AS idChiTiet ,"
                    + " ct.sanPham.ma  AS maSanPham , "
                    + " ct.sanPham.ten AS tenSanPham ,"
                    + " ct.namBH AS namBaoHanh ,"
                    + " ct.moTa AS moTa ,"
                    + " ct.soLuongTon AS soLuongSanPham ,"
                    + " ct.giaNhap AS giaNhap ,"
                    + " ct.giaBan AS giaBan "
                    + " )"
                    + " FROM ChiTietSP ct "
                    + " JOIN SanPham sp ON sp.idSP = ct.sanPham.idSP"
                    + " WHERE sp.ten LIKE :tenSanPham ";
            list = session.createQuery(query).setParameter("tenSanPham", "%" + tenSanPham + "%").list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return list;
    }
//
//    public UUID findByIdloaisp(String ten) {
//        UUID uuid;
//        try ( Session session = hibernateconfig.getFACTORY().openSession()) {
//            String statement = "select loaiSP.id from LoaiSP loaiSP where loaiSP.ten = :Ten";
//            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
//            query.setParameter("Ten", ten);
//            uuid = query.getSingleResult();
//        }
//        return uuid;
////        return null;
//    }
//
//    public UUID findByIdmauSac(String ten) {
//        UUID uuid;
//        try ( Session session = hibernateconfig.getFACTORY().openSession()) {
//            String statement = "select mauSac.id from MauSac mauSac where mauSac.ten = :Ten";
//            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
//            query.setParameter("Ten", ten);
//            uuid = query.getSingleResult();
//        }
//        return uuid;
//    }
//
//    public UUID findByIdsize(String ten) {
//        UUID uuid;
//        try ( Session session = hibernateconfig.getFACTORY().openSession()) {
//            String statement = "select size.id from Size size where size.size = :ten";
//            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
//            query.setParameter("ten", ten);
//            uuid = query.getSingleResult();
//        }
//        return uuid;
//    }
//
//    public UUID findByIdsanpham(String ten) {
//        UUID uuid;
//        try ( Session session = hibernateconfig.getFACTORY().openSession()) {
//            String statement = "select sanp.id from MauSac sanp where sanp.ten = :ten";
//            TypedQuery<UUID> query = session.createQuery(statement, UUID.class);
//            query.setParameter("ten", ten);
//            uuid = query.getSingleResult();
//        }
//        return uuid;
//    }

    public List<String> listcbbctsp() {
        ArrayList<String> list = new ArrayList<>();
        try ( Session s = hibernateconfig.getFACTORY().openSession()) {
            String hql = "Select ctsp.sanPham.ma from ChiTietSP ctsp";
            TypedQuery<String> query = s.createQuery(hql, String.class);
            list = (ArrayList<String>) query.getResultList();
        }
        return list;
    }

//    public UUID finByIdctsp(String ma) {
//        UUID id = null ;
//        try ( Session s = hibernateconfig.getFACTORY().openSession()) {
//            String query = "select ctsp.id from ChiTietSP ctsp where ctsp.sanPham.ma = :ma";
//            TypedQuery<UUID> q = s.createQuery(query, UUID.class);
//            q.setParameter("ma", ma);
//            id = q.getSingleResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return id;
//    }
//
//    public UUID findByIdhd(String ma) {
//        UUID id = null;
//        try ( Session s = hibernateconfig.getFACTORY().openSession()) {
//            String query = "select hd.id from HoaDon hd where hd.ma = :ma";
//            TypedQuery<UUID> q = s.createQuery(query, UUID.class);
//            q.setParameter("ma", ma);
//            id = q.getSingleResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return id;
//    }
    public static void main(String[] args) {
        // TODO code application logic here
//        UUID iu = new ChiTietSPRepostority().finByIdctsp("dientu");
//        System.err.println("" + iu);
        System.out.println(new ChiTietSPRepostority().searchByNameTenSp("AdidasKK9"));
    }

}
