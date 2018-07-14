package com.base.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public  class BaseDao<T> {
    @Autowired
    SessionFactory seesionFactory;

    /**
     *
     * @return SessionFactory
     */
    public SessionFactory getSeesionFactory(){
        return this.seesionFactory;
    }

    /**
     * 不建议调用，目前存在问题
     * @return 当前线程绑定的session
     */
    public Session getCurrentSession(){
        return seesionFactory.getCurrentSession();
    }

    /**
     * 保存一个对象，成功返回1，失败返回-1
     * @param t
     */
    public int save(T t){
      Session session =  seesionFactory.openSession();
      session.beginTransaction();
      int result = -1;
        try {
            session.save(t);
            session.getTransaction().commit();
            result = 1;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    /**
     * 保存或更新一个对象,成功返回1，失败返回-1
     * @param t
     */
    public int saveOrUpdate(T t){
        Session session =  seesionFactory.openSession();
        int result = -1;
        session.beginTransaction();
        try {
            session.saveOrUpdate(t);
            session.getTransaction().commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
            return result;
        }
    }

    /**
     * 通过sql语句,根据sql去查询一个对象的集合
     * @param sql
     * @return
     */
    public List<T> findBySql(String sql){
        Session session =  seesionFactory.openSession();
        List<T> entityList = null;
        try {
            entityList = session.createSQLQuery(sql).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return entityList;
    }

    /**
     * 通过hql语句去查询一个对象的集合
     * @param hql
     * @return
     */
    public List<T> findByHql(String hql){
        Session session =  seesionFactory.openSession();
        List<T> entityList = null;
        try {
            entityList = session.createQuery(hql).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return entityList;
    }

    /**
     * 通过sql语句执行更新、删除、添加操作
     * @param sql
     */
    public int executeBySql(String sql){
        Session session =  seesionFactory.openSession();
        session.beginTransaction();
        //执行前，赋值-1，操作成功的话，数据库返回值是1;
        int result = -1;
        try {
            result =  session.createSQLQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return result;
    }

    /**
     * 利用hql语句进行删除和更新
     * @param hql
     * @return
     */
    public int executeByHql(String hql){
        Session session = seesionFactory.openSession();
        session.beginTransaction();
        int result = -1;
        try {
            result = session.createQuery(hql).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }
}
