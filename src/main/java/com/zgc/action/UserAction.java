package com.zgc.action;

import com.base.action.BaseAction;
import com.base.model.Json;
import com.base.util.MD5;
import com.zgc.model.User;
import com.zgc.service.IUserService;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            getBaseEntity().setPassword(MD5.MD5Encrypt(getBaseEntity().getPassword()));
            result =  userService.save(getBaseEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == 1)
            writeJson(new Json(true,"操作成功"));
        else
            writeJson(new Json(false,"操作失败"));
    }

    /**
     * 查找所有的用户
     */
    public void findAllUser(){
        //hql语句本不该出现在Action这里的,这里为了省事，暂时这样处理。service和dao继承base类之后，
        //没必要再自己重写最基本业务。后期有特殊业务需求下的service方法和Dao方法后，最好是把相应的hql语句定义在dao层，符合
        //开发的规范
        List<User> userList = userService.findByHql("from User");
        writeJson(new Json(true,userList));
    }

    /**
     * 根据id删除一个用户
     */
    public void deleteUser(){
        int result = userService.executeByhql("delete from User where id = "+getId());
        writeJson(new Json(true,"删除成功"));
    }

    /**
     * 更新用户名
     */
    public void updateUserName(){
        String hql = "update User set userName = '"+getBaseEntity().getUserName() +
                "' where id =" +getBaseEntity().getId();
        try {
            userService.executeByhql(hql);
            writeJson(new Json(true,"更新成功"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 利用hql和Map<String,Object>做更新或删除
     */
    public void updateUserPassword(){
        String hql = "update User set password = :password where" +
                " id = :id";
        Map<String,Object> param = new HashMap<>();
        param.put("password",getBaseEntity().getPassword());
        param.put("id",getBaseEntity().getId());
        userService.updateOrDel(hql,param);
        writeJson(new Json(true,"占位符形式的更新已处理成功"));

    }

//http://localhost:8080/CTW/User_a.do
    public void a(){
        System.out.print(999999999);
        writeJson(new Json(true,"这是一个测试例子，如果你能看到返回的json串值，说明执行正确"));
    }

}
