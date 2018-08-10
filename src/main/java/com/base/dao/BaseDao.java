package com.base.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            result =1;
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

    /**
     * map集合和hql语句结合起来，用占位符形式传参，处理更新或删除
     * @param hql
     * @param map
     * @return
     */
    public int updateOrDel(String hql, Map<String,Object> map){
        Session session = seesionFactory.openSession();
        session.beginTransaction();
        int result = -1;
        try {
            Query query = session.createQuery(hql);
            for (String key:map.keySet()){
                query.setParameter(key,map.get(key));
            }
            result = query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return result;
    }

    /**
     * 根据id查询一个对象
     * @param entityClass
     * @param id
     * @return
     */
    public T findById(Class<T> entityClass,int id){
        Session session =  seesionFactory.openSession();
        T entity = null;
        String hql = "From "+entityClass.getSimpleName()+ " where id="+id;
        try {
            entity = (T) session.createQuery(hql).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return entity;
    }

    /**
     * 根据id查询一个对象
     * @param entityClass
     * @param id
     * @return
     */
    public T findById(Class<T> entityClass,String id){
        Session session =  seesionFactory.openSession();
        T entity = null;
        String hql = "From "+entityClass.getSimpleName()+ " where id='"+id+"'";
        try {
            entity = (T) session.createQuery(hql).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return entity;
    }

    /**
     * 查询所有的对象
     * @param entityClass 实体对象所属类
     * @return
     */
    public List<T> findAll(Class<T> entityClass){
        Session session =  seesionFactory.openSession();
        List<T> entity = null;
        String hql = "From "+entityClass.getSimpleName();
        try {
            entity = session.createQuery(hql).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return entity;
    }


    /**
     * 根据id删除一个对象
     * @param entityClass
     * @return
     */
    public int deleteById(Class<T> entityClass,Serializable id){
//        Session session =  seesionFactory.openSession();
        String hql = "delete From "+entityClass.getSimpleName()+" where id= :id";
        Map<String,Object> map = new HashMap<>();
        map.put("id",id);
        int flag = 1;
//        try {
//            flag = session.createQuery(hql).executeUpdate();
            flag = updateOrDel(hql,map);
//        } catch (Exception e) {
//            e.printStackTrace();
//            flag = -1;
//        }
//        finally {
//            session.close();
//        }
        return flag;
    }

    /**
     * 更新某个对象
     * @param entityClass
     * @param id
     * @param map
     * @return
     */
    public int updateSingleObj(Class entityClass,Serializable id,Map<String,Object> map){
        int flag = -1;
       if (map.size()>0){
           StringBuilder sb = new StringBuilder();
           for (String key:map.keySet()){
               if (!key.equals("id"))//过滤掉ID
                   sb.append(key+"= :"+key+",");
           }
           String str = sb.toString().substring(0,sb.toString().length()-1);
           String hql = "update "+entityClass.getSimpleName() + " set " + str + " where id= :id";
           map.put("id",id);
           flag = updateOrDel(hql,map);
       }
        return flag;
    }
}
