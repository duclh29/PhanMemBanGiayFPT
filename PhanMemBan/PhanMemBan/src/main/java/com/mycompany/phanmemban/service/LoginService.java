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
}
