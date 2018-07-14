package com.zgc.action;

import com.base.action.BaseAction;
import com.base.model.Json;
import com.opensymphony.xwork2.ActionSupport;
import com.zgc.model.User;
import com.zgc.service.IUserService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * @program: CTW
 * @description: 用户
 * @author: laoyangtou
 * @create: 2018-07-10 13:13
 **/
@Namespace("/")
@Scope("prototype")
@Results( {
//        @Result(name="success",location="/index.jsp"),
//        @Result(name="failure",location="/index.jsp")
})
public class UserAction extends BaseAction<User> {
    @Autowired
    private IUserService userService;

//    private User user;
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public User getUser() {
//        return user;
//    }

//http://localhost:8080/CTW/User_addUser.do
    /**
     * 添加一个用户
     */
    public void addUser() {
        int result = -1;
        try {
            //早期的自定义的添加方法。baseService、baseDao等被继承后，简单的增删改查不需要自己写
//           result =  userService.addUser(user);
            //save方法是继承过来的
            result =  userService.save(getBaseEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == 1)
            writeJson(new Json(true,"操作成功"));
        else
            writeJson(new Json(false,"操作失败"));
    }

    public void deleteUser(){


    }

//http://localhost:8080/CTW/User_a.do
    public void a(){
        System.out.print(999999999);
        writeJson(new Json(true,"这是一个测试例子，如果你能看到返回的json串值，说明执行正确"));
    }

}
