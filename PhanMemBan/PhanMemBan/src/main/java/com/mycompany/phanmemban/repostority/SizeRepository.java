/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.Size;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author PC
 */
public class SizeRepository {
     Session session = hibernateconfig.getFACTORY().openSession();
 List<Size> listSize=null;
   public List<Size> getAllSize(){
        listSize=new ArrayList<>();
        Query qe=session.createQuery("from Size");
        return qe.getResultList();

    }

    public String add(Size sz) {
        String check;
        Transaction transaction = null;
        try {
            session = hibernateconfig.getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.save(sz);
            check = "Add thành công";
            transaction.commit();
        } catch (Exception e) {
            check = "Add thất bại";
        }
        return check;
    }

    public boolean getMa(String ma) {
        for (Size size : getAllSize()) {
            if (ma.equalsIgnoreCase(size.getMa())) {
                return true;
            }
        }
        return false;
    }

    public String update(Size sz) {
        String check;
        Transaction transaction = null;
        try {
            session = hibernateconfig.getFACTORY().openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(sz);
            check = "Sửa thành công";
            transaction.commit();
        } catch (Exception e) {
            check = "Sửa thất bại";
        }
        return check;
    }

    public String delete(String ma) {

        session = hibernateconfig.getFACTORY().openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        try {
            String hql = "delete Size where ma=:ma";
            Query qr = session.createQuery(hql);
            qr.setParameter("ma", ma);
            qr.executeUpdate();
//                   if (serult==0) {
//                       
//                   }
            transaction.commit();
            return "Xóa thành công";
        } catch (Exception e) {

        }
        return "Xóa thất bại";

    }

    public List<String> listcbbsize() {
        ArrayList<String> list = new ArrayList<>();
        try ( Session s = hibernateconfig.getFACTORY().openSession()) {
            String hql = "Select Size.size from Size Size";
            TypedQuery<String> query = s.createQuery(hql, String.class);
            list = (ArrayList<String>) query.getResultList();
        }
        return list;
    }
    public static void main(String[] args) {
        System.out.println(new SizeRepository().listSize);
    }
}
