package com.zgc.action;

import com.base.action.BaseAction;
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
//        @Result(name="success",location="/index.jsp"),
//        @Result(name="failure",location="/index.jsp")
})
public class UserAction extends BaseAction {
    @Autowired
    private IUserService userService;

    private User user;
    public void setUser(User user) {
        this.user = user;
    }

    public String addUser() {
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }
//http://localhost:8080/CTW/ctw_a.do
    public void a(){
        System.out.print(999999999);
    }

}
