
package com.mycompany.phanmemban.service;

import com.mycompany.phanmemban.model.Login;
import com.mycompany.phanmemban.model.NhanVien;

public interface LoginService {
 NhanVien findLogin(String ma,String pass);
}
