package com.zgc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: CTW
 * @description: 班级
 * @author: laoyangtou
 * @create: 2018-08-10 10:22
 **/
@Entity
@Table(name = "t_group")
public class Group implements Serializable {

    private static final long serialVersionUID = -1171303416428241802L;
    private Integer id;//
    private String name;//班级名称
    private Set<Teacher> teachers = new HashSet<>();//教师集合

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
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

    @ManyToMany(mappedBy = "groups",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
