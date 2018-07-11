package com.zgc.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zgc.model.User;
import com.zgc.service.IUserService;
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
        @Result(name="success",location="/index.jsp"),
//        @Result(name="failure",location="/failure.jsp")
})
@Action
public class UserAction extends ActionSupport {
    @Autowired
    private IUserService userService;
    private User user;
    public void setUser(User user) {
        this.user = user;
    }

    @Action("addUser")
    public String addUser() {
        System.out.print("0000000000000000002222222222");
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("----------------------------------------");
            return "failure";
        }
        System.out.print("++++++++++++++++++++++++++++++++++++++++++++++");
        return "success";
    }
//http://localhost:8080/CTW/user!a.do
    @Action("aa")
    public void a(){
        System.out.print(999999999);
       // return "success";
    }

}
