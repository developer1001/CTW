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
import javax.annotation.Resource;

/**
 * @program: CTW
 * @description: 用户
 * @author: laoyangtou
 * @create: 2018-07-10 13:13
 **/
@Namespace("/")
@Scope("prototype")
@Action("comSituation")
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
