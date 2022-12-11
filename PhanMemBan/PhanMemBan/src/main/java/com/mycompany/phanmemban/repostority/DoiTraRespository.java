/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.DoiTra;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DoiTraRespository {
    public List <DoiTra> getAll(){
        List<DoiTra> doitra = new ArrayList<>();
        Transaction trns = null;
        Session session = hibernateconfig.getFACTORY().openSession();
        try{
            trns = session.beginTransaction();
            doitra = session.createQuery("from DoiTra").list();
            
        }catch(RuntimeException e){
            e.printStackTrace();
        }finally{
//            session.flush();
            session.close();
        }
        return doitra;
    }
    public List<String> listcbbdt() {
        ArrayList<String> list = new ArrayList<>();
        try (Session s = hibernateconfig.getFACTORY().openSession()) {
            String hql = "Select dt.maDT from DoiTra dt";
            TypedQuery<String> query = s.createQuery(hql, String.class);
            list = (ArrayList<String>) query.getResultList();
        }
        return list;
    }
    public DoiTra getOne(String ma) {
        DoiTra doiTra = new DoiTra();
        Session session = hibernateconfig.getFACTORY().openSession();
        try {
            String query = "SELECT sp "
                    + "FROM DoiTra sp "
                    + "WHERE sp.maDT LIKE :ma ";
            Query<DoiTra> hth = session.createQuery(query);
            hth.setParameter("ma", "%" + ma + "%");
            doiTra = hth.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return doiTra;

    }
    public static void main(String[] args) {
        System.out.println(new DoiTraRespository().getOne("KL0LJ0"));
    }
    
}
