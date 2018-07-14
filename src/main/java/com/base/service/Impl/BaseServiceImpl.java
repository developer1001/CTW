package com.base.service.Impl;

import com.base.dao.BaseDao;
import com.base.service.IBaseService;

import java.util.List;

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
}
