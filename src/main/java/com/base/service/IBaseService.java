package com.base.service;

import java.util.List;
import java.util.Map;

public interface IBaseService<T> {

    /**
     * 利用hibernate的save()保存一个对象
     * @param t
     * @return
     */
    public int save(T t);

    /**
     * 利用hibernate的saveOrUpdate()保存或者更新一个对象
     * @param t
     * @return
     */
    public int saveOrUpdate(T t);

    /**
     * 通过sql语句查询获得某实体对象的集合
     * @param sql
     * @return
     */
    public List<T> findBySql(String sql);

    /**
     * 利用hql语句获得某实体对象的集合
     * @param hql
     * @return
     */
    public List<T> findByHql(String hql);

    /**
     * 通过sql语句执行增加、删除、修改
     * @param sql
     * @return
     */
    public int executeBySql(String sql);

    /**
     * 利用hql语句执行增加、删除、修改
     * @param hql
     * @return
     */
    public int executeByhql(String hql);

    /**
     * map集合和hql语句结合起来，用占位符形式传参，处理更新或删除
     * @param hql
     * @param map
     * @return
     */
    public int updateOrDel(String hql, Map<String,Object> map);
}
