package com.base.service.Impl;

import com.base.dao.BaseDao;
import com.base.model.PageBean;
import com.base.service.IBaseService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract  class BaseServiceImpl<T> implements IBaseService<T> {

    public abstract BaseDao<T> getBaseDao();

    @Override
    public int save(T t) {
        return getBaseDao().save(t);
    }

    @Override
    public int saveOrUpdate(T t) {
        return getBaseDao().saveOrUpdate(t);
    }

    @Override
    public List<T> findBySql(String sql) {
        return getBaseDao().findBySql(sql);
    }

    @Override
    public List<T> findByHql(String hql) {
        return getBaseDao().findByHql(hql);
    }

    @Override
    public int executeBySql(String sql) {
        return getBaseDao().executeBySql(sql);
    }

    @Override
    public int executeByhql(String hql) {
        return getBaseDao().executeByHql(hql);
    }

    @Override
    public int updateOrDel(String hql, Map<String, Object> map) {
        return getBaseDao().updateOrDel(hql,map);
    }

    @Override
    public T findById(Class<T> entityClass, int id) {
        return getBaseDao().findById(entityClass,id);
    }

    @Override
    public T findById(Class<T> entityClass, String id) {
        return getBaseDao().findById(entityClass,id);
    }

    @Override
    public List<T> findAll(Class<T> entityClass) {
        return getBaseDao().findAll(entityClass);
    }

    @Override
    public int deleteById(Class<T> entityClass, Serializable id) {
        return getBaseDao().deleteById(entityClass,id);
    }

    @Override
    public int updateSingleObj(Class entityClass, Serializable id, Map<String, Object> map) {
        return getBaseDao().updateSingleObj(entityClass,id,map);
    }

    @Override
    public List findByHql(String hql,Map<String,Object> map) {
        return getBaseDao().findByHql(hql,map);
    }

    @Override
    public long getTotalSize(String hql,Map<String,Object> map) {
        return getBaseDao().getTotalSize(hql,map);
    }

    @Override
    public List findByPage(String hql, Map<String, Object> map, PageBean pageBean) {
        return getBaseDao().findByPage(hql,map,pageBean);
    }

    @Override
    public int deleteByIds(Class entityClass, String ids) {
        return getBaseDao().deleteByIds(entityClass,ids);
    }
}
