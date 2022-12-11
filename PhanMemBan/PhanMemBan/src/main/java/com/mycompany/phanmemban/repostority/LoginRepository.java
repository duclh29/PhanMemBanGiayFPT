/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.NhanVien;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author PC
 */
public class LoginRepository {
     public static Session session = hibernateconfig.getFACTORY().openSession();

    public NhanVien findLoginPass(String ma,String pass){
        try {
            Query query=session.createQuery("from NhanVien where ma=:ma and matkhau=:pass");
                query.setParameter("ma",ma);
                query.setParameter("pass",pass);
                NhanVien nv=(NhanVien) query.getSingleResult();
                return nv;
        } catch (Exception e) {
        }
        return null;
    }
    public static void main(String[] args) {
        NhanVien nv= new LoginRepository().findLoginPass("NV01","12345");
        System.out.println(nv);
    }
}
