package com.zgc.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: CTW
 * @description: 老师
 * @author: laoyangtou
 * @create: 2018-08-10 10:24
 **/
@Entity
@Table(name = "t_teacher")
public class Teacher implements Serializable {

    private static final long serialVersionUID = -5449716522281834128L;
    private Integer id;
    private String name;//老师姓名
    private Integer age;//年龄
    private Set<Group> groups = new HashSet<>();//班级集合

    public void addGroups(Group group){
        groups.add(group);
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @ManyToMany(targetEntity = Group.class,cascade = {CascadeType.ALL})
    @JoinTable(name = "t_teacher_group",joinColumns = {@JoinColumn(name = "tid")},
            inverseJoinColumns ={@JoinColumn(name = "gid")} )
    @JSONField(serialize = false)
    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
