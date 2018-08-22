package com.zgc.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @program: CTW
 * @description: 用户实体类
 * @author: laoyangtou
 * @create: 2018-07-10 13:07
 **/
@Entity
@Table(name = "sys_user")
public class User implements Serializable {
    private static final long serialVersionUID = -2980111559097070230L;
    private int id;
    private String userName;
    private String loginName;
    private String password;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", length=10)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="password", length=50)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="user_name", length=50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name="login_name", length=50)
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
