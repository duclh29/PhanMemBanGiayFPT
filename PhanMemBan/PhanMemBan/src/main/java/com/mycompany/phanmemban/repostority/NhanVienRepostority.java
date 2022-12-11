/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

<<<<<<< HEAD
import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.MauSac;
import com.mycompany.phanmemban.model.NhanVien;
=======
import com.mycompany.phanmemban.Untilies.DBConnection;
import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.MauSac;
import com.mycompany.phanmemban.model.NhanVien;
import static com.mycompany.phanmemban.repostority.LoginRepository.session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
>>>>>>> 04b43d346461bf4313d9bb8fc82fcfbd8b8ecab0
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
public class NhanVienRepostority {
<<<<<<< HEAD
     public List<NhanVien> getAll() {
=======
    DBConnection  dbd = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public List<NhanVien> getAll() {
>>>>>>> 04b43d346461bf4313d9bb8fc82fcfbd8b8ecab0
        List<NhanVien> mausac = new ArrayList<>();
        Transaction trns = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            trns = session.beginTransaction();
            mausac = session.createQuery("from NhanVien").list();

        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return mausac;
<<<<<<< HEAD
        
=======
>>>>>>> 04b43d346461bf4313d9bb8fc82fcfbd8b8ecab0

    }

    public Boolean add(NhanVien nhanvien) {
        String check = null;
        Transaction transaction = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            session = hibernateconfig.getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.save(nhanvien);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
<<<<<<< HEAD

    public Boolean Update(NhanVien nhanvien) {
        String check = null;
        Transaction transaction = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            session = hibernateconfig.getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(nhanvien);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
=======
  public boolean getMa(String ma) {
        for (NhanVien size : getAll()) {
            if (ma.equalsIgnoreCase(size.getMa())) {
                return true;
            }
        }
        return false;
    }

    public String update(NhanVien nv) {
        String check;
        Transaction transaction = null;
        try {
            session = hibernateconfig.getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(nv);
            check = "Sửa thành công";
            transaction.commit();
        } catch (Exception e) {
            check = "Sửa thất bại";
        }
        return check;
    }
    
>>>>>>> 04b43d346461bf4313d9bb8fc82fcfbd8b8ecab0

    public Boolean delete(String ma) {
        Session session = hibernateconfig.getFACTORY().openSession();
        session = hibernateconfig.getFACTORY().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            String hql = "delete NhanVien where ma=:ma";
            Query qr = session.createQuery(hql);
            qr.setParameter("ma", ma);
            qr.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;

    }

    public NhanVien checkTrungID(String id) {
        NhanVien nhanvien = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        javax.persistence.Query q = session.createQuery("FROM NhanVien WHERE id = :id");
        q.setParameter("id", id);
        try {
            nhanvien = (NhanVien) q.getSingleResult();
        } catch (NoResultException noResultException) {
            return null;
        }
        return nhanvien;
    }
<<<<<<< HEAD
    public NhanVien getOne(String ma) {     
=======

    public NhanVien getOne(String ma) {
>>>>>>> 04b43d346461bf4313d9bb8fc82fcfbd8b8ecab0
        NhanVien nv = new NhanVien();
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            String query = "SELECT sp "
                    + "FROM NhanVien sp "
                    + "WHERE sp.ten LIKE :ten ";
            Query<NhanVien> hth = session.createQuery(query);
<<<<<<< HEAD
            hth.setParameter("ten","%"+ ma+"%");
=======
            hth.setParameter("ten", ma);
>>>>>>> 04b43d346461bf4313d9bb8fc82fcfbd8b8ecab0
            nv = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;
<<<<<<< HEAD
    
=======

    }

    public List<NhanVien> searchByTen(String ten) {
        List<NhanVien> listNhanViens;
        try ( Session session = hibernateconfig.getFACTORY().openSession()) {
            Query q = session.createQuery("FROM NhanVien nv WHERE nv.ten like :ten");
            q.setParameter("ten", "%" + ten + "%");
            listNhanViens = q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listNhanViens;
    }

    public String updatenmk(String mk, String ma) {

        Session session = null;
        try {
            session = hibernateconfig.getFACTORY().openSession();
            Query q = session.createQuery("update NhanVien set matKhau =: mk  WHERE ma =:ma");
            q.setParameter("mk", mk);
            q.setParameter("ma", ma);
            q.executeUpdate();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
        
    }
    public NhanVien getOnes(String ma) {
        NhanVien nv = new NhanVien();
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            String query = "SELECT sp "
                    + "FROM NhanVien sp "
                    + "WHERE sp.ma LIKE :ma ";
            Query<NhanVien> hth = session.createQuery(query);
            hth.setParameter("ma", ma);
            nv = hth.uniqueResult();
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return nv;

    }
    public static void main(String[] args) {
        System.out.println(new NhanVienRepostority().updatenmk("123456", "NV01"));
    }
     public boolean updateMK (String mk, String ma) {
        String sql = " update NhanVien set  matKhau=? where ma=?";
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, mk);
            ps.setObject(2, ma);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace(System.out);
        }
        return false;
>>>>>>> 04b43d346461bf4313d9bb8fc82fcfbd8b8ecab0
    }
}
