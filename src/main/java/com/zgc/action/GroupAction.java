package com.zgc.action;

import com.base.action.BaseAction;
import com.base.model.Json;
import com.zgc.model.*;
import com.zgc.service.IGroupService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.awt.event.TextEvent;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @program: CTW
 * @description: 班级
 * @author: laoyangtou
 * @create: 2018-08-10 10:41
 **/
@Namespace("/")
@Scope("prototype")
@Results( {
//        @Result(name="success",location="/index.jsp"),
//        @Result(name="failure",location="/index.jsp")
})
public class GroupAction extends BaseAction<Group> {
    @Autowired
    IGroupService groupService;

    public void add() {
        //测试级联保存
        Group group1 = new Group();
        group1.setName((int)(Math.random()*5+1)+"-"+(int)(Math.random()*100)+"班");
        Group group2 = new Group();
        group2.setName((int)(Math.random()*5+1)+"-"+(int)(Math.random()*100)+"班");
        Group group3 = new Group();
        group3.setName((int)(Math.random()*5+1)+"-"+(int)(Math.random()*100)+"班");
        Set<Group> groups = new HashSet<>();
        groups.add(group1);
        groups.add(group2);
        groups.add(group3);
        Teacher teacher1  = new Teacher();
        teacher1.setAge((int)(Math.random()*40+20));
        teacher1.setName("xxxxx");
        Teacher teacher2  = new Teacher();
        teacher2.setAge((int)(Math.random()*40+20));
        teacher2.setName("xxxxx");
        Teacher teacher3  = new Teacher();
        teacher3.setAge((int)(Math.random()*40+20));
        teacher3.setName("xxxxx");
        Set<Teacher> teachers = new HashSet<>();
        teachers.add(teacher1);
        teachers.add(teacher2);
        teachers.add(teacher3);

        group1.setTeachers(teachers);
        teacher1.setGroups(groups);
        group2.setTeachers(teachers);
        teacher2.setGroups(groups);
        group3.setTeachers(teachers);
        teacher3.setGroups(groups);
        int result = -1;
        try {
            result =  groupService.saveOrUpdate(group1);
            result =  groupService.saveOrUpdate(group2);
            result =  groupService.saveOrUpdate(group3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == 1)
            writeJson(new Json(true,"操作成功"));
        else
            writeJson(new Json(false,"操作失败"));
    }

    /**
     * 级联删除
     */
    public void delete(){
        try {
            groupService.deleteById(Group.class,id);
            writeJson(new Json(true,"操作成功"));
        } catch (Exception e) {
            e.printStackTrace();
            writeJson(new Json(false,"操作失败"));
        }
    }

    /**
     *z查找
     */
    public void find(){
        try {
            Group group = groupService.findById(Group.class,id);
            writeJsonNofer(new Json(true,group));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *z查找所有
     */
    public void findAll(){
        try {
            List<Group> groups = groupService.findAll();
            writeJsonNofer(new Json(true,groups));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新一个对象，测试
     */

    public void update(){
        //写一个测试的map集合
        Map<String,Object> map = new HashMap<>();
        map.put("age",18);
            int flag =  groupService.updateSingleObj(Teacher.class,id,map);
            if(flag == 1)
                writeJson(new Json(true,"操作成功"));
            else
                writeJson(new Json(false,"操作失败"));
    }
}
