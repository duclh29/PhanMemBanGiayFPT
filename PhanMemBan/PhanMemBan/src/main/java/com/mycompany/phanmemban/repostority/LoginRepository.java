/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.repostority;

<<<<<<< HEAD

import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.Login;
import com.mycompany.phanmemban.model.NhanVien;
import javax.persistence.NoResultException;
=======
import com.mycompany.phanmemban.Untilies.hibernateconfig;
import com.mycompany.phanmemban.model.NhanVien;
>>>>>>> 9174aa3783a5d7c366fa1c20cbc17bd3043fa336
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
<<<<<<< HEAD
 * @author ASUS
 */
public class LoginRepository {
    
    public static Session session = hibernateconfig.getFACTORY().openSession();
=======
 * @author PC
 */
public class LoginRepository {
     public static Session session = hibernateconfig.getFACTORY().openSession();
>>>>>>> 9174aa3783a5d7c366fa1c20cbc17bd3043fa336

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
