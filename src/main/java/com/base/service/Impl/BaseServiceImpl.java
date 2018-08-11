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
    public T findById(int id) {
        return getBaseDao().findById(id);
    }

    @Override
    public T findById(String id) {
        return getBaseDao().findById(id);
    }

    @Override
    public List<T> findAll() {
        return getBaseDao().findAll();
    }

    @Override
    public int deleteById(Serializable id) {
        return getBaseDao().deleteById(id);
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
    public int deleteByIds(String ids) {
        return getBaseDao().deleteByIds(ids);
    }

    @Override
    public int delete(T t) {
        return getBaseDao().delete(t);
    }
}
