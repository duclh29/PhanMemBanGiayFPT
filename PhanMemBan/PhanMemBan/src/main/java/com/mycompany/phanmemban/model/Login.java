
package com.mycompany.phanmemban.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Login")
public class Login implements Serializable{
    
    @Id
    @Column(name = "Ma_UserName", length = 255)
    private String UserName;
    @Column(name = "Mk_PassWord", length = 255)
    private String PassWord;

    public Login() {
    }

    public Login(String UserName, String PassWord) {
        this.UserName = UserName;
        this.PassWord = PassWord;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }
    
    
}
