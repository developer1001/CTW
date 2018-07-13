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
public class UserAction extends BaseAction {
    @Autowired
    private IUserService userService;

    private User user;
    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

//http://localhost:8080/CTW/User_addUser.do
    public void addUser() {
        int result = -1;
        try {
           result =  userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == 1)
            writeJson(new Json(true,"添加用户成功"));
    }
//http://localhost:8080/CTW/User_a.do
    public void a(){
        System.out.print(999999999);
        writeJson(new Json(true,"这是一个测试例子，如果你能看到返回的json串值，说明执行正确"));
    }

}
