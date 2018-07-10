package com.zgc.model;

import javax.persistence.*;

/**
 * @program: CTW
 * @description: 用户实体类
 * @author: laoyangtou
 * @create: 2018-07-10 13:07
 **/
@Entity
@Table(name = "sys_user")
public class User {
    private int id;
    private String name;
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
    @Column(name="user_name", length=50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name="password", length=50)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
