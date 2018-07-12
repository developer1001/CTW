package com.base.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao {
    @Autowired
    SessionFactory seesionFactory;

    public SessionFactory getSeesionFactory(){
        return this.seesionFactory;
    }

    public Session getCurrentSession(){
        return seesionFactory.getCurrentSession();
    }
}
