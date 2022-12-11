package com.mycompany.phanmemban.service.impl;

import com.mycompany.phanmemban.model.Login;
import com.mycompany.phanmemban.model.NhanVien;
import com.mycompany.phanmemban.repostority.LoginRepository;
import com.mycompany.phanmemban.service.LoginService;

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
