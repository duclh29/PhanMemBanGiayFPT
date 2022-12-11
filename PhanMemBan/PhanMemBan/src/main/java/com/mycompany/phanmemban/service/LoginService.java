<<<<<<< HEAD

package com.mycompany.phanmemban.service;

import com.mycompany.phanmemban.model.Login;
import com.mycompany.phanmemban.model.NhanVien;

public interface LoginService {
 NhanVien findLogin(String ma,String pass);
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.phanmemban.service;

import com.mycompany.phanmemban.model.NhanVien;

/**
 *
 * @author PC
 */
public interface LoginService {
     NhanVien findLogin(String ma,String pass);
>>>>>>> 9174aa3783a5d7c366fa1c20cbc17bd3043fa336
}
