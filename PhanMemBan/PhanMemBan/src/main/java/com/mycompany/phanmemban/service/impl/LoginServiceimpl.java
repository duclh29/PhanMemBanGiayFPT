/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phanmemban.service.impl;

import com.mycompany.phanmemban.model.NhanVien;
import com.mycompany.phanmemban.repostority.LoginRepository;
import com.mycompany.phanmemban.service.LoginService;

/**
 *
 * @author PC
 */
public class LoginServiceimpl implements LoginService{
      private LoginRepository loginRepo = new LoginRepository();

    
//    public Login finLogin(String user, String pass) {
//        Login l = loginRepo.finLogin(user, pass);
//        return l;
//    }
     public NhanVien findLogin(String ma,String pass){
        return loginRepo.findLoginPass(ma, pass);
         
        
 
    

     }
     public String okLUN(){
         return "hehe";
     }
}
