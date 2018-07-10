package com.zgc.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zgc.model.User;
import com.zgc.service.IUserService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
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
@Action("user")
@Results( {
//        @Result(name="success",location="/success.jsp",type=""),
//        @Result(name="failure",location="/failure.jsp")
})
public class UserAction extends ActionSupport {
    @Autowired
    private IUserService userService;
    private User user;
    public void setUser(User user) {
        this.user = user;
    }

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

}
