package com.base.service;

import java.io.Serializable;
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

    /**
     * 查询一个对象
     * @param entityClass
     * @param id
     * @return
     */
    T findById(Class<T> entityClass,int id);

    /**
     * 查询一个对象
     * @param entityClass
     * @param id
     * @return
     */
    T findById(Class<T> entityClass,String id);

    /**
     * 查询所有对象
     * @param entityClass
     * @return
     */
    List<T> findAll(Class<T> entityClass);

    /**
     * 删除一个对象
     * @param entityClass
     * @param id
     * @return
     */
    int deleteById(Class<T> entityClass,Serializable id);

    /**
     * 更新一个对象
     * @param entityClass
     * @param id
     * @param map
     * @return
     */
    int updateSingleObj(Class entityClass,Serializable id,Map<String,Object> map);

    /**
     * 利用map占位符参数，获取查询对象的集合
     * @param entityClass
     * @param map
     * @return
     */
    List<T> findByMap(Class<T> entityClass ,Map<String,Object> map);

    /**
     * 获取总的数据记录条数
     * @param entityClass
     * @param map
     * @return
     */
    long getTotalSize(Class entityClass ,Map<String,Object> map);
}
