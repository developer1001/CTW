package com.base.dao;

import com.base.model.PageBean;
import org.hibernate.*;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class BaseDao<T> {
    @Autowired
    SessionFactory seesionFactory;

    Class<T> clazz;

    @SuppressWarnings("unchecked")
    public BaseDao(){
        //获取当前运行的父类的参数化类型
        Type type = this.getClass().getGenericSuperclass();
        //转换为参数化类型
        ParameterizedType pt =(ParameterizedType)type;
        //得到实际类型
        Type[] types = pt.getActualTypeArguments();
        clazz = (Class<T>) types[0];
    }
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
     * 利用map和hql命名参数，获取查询对象的集合
     * @param hql
     * @param map
     * @return
     */
    public List findByHql(String hql,Map<String,Object> map){
         Session session =  seesionFactory.openSession();
         List list = null;
            Query query = session.createQuery(hql);
            if (map != null && map.size() > 0){
                for (String key:map.keySet()){
                    query.setParameter(key,map.get(key));
                }
            }
            try {
                list = query.list();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                session.close();
            }
        return list;
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
            if (map != null && map.size() > 0){
                for (String key:map.keySet()){
                    query.setParameter(key,map.get(key));
                }
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
     * @param id
     * @return
     */
    public T findById(int id){
        Session session =  seesionFactory.openSession();
        T entity = null;
        String hql = "From "+clazz.getSimpleName()+ " where id="+id;
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
     * @param id
     * @return
     */
    public T findById(String id){
        Session session =  seesionFactory.openSession();
        T entity = null;
        String hql = "From "+clazz.getSimpleName()+ " where id='"+id+"'";
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
     * @return
     */
    public List<T> findAll(){
        Session session =  seesionFactory.openSession();
        List<T> entity = null;
        String hql = "From "+clazz.getSimpleName();
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
     * @return
     */
    public int deleteById(Serializable id){
//        Session session =  seesionFactory.openSession();
        String hql = "delete From "+clazz.getSimpleName()+" where id= :id";
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
     * 更新某个对象，局限性在于只能针对 where id 的查询
     * @param entityClass
     * @param id
     * @param map
     * @return
     */
    public int updateSingleObj(Class entityClass,Serializable id,Map<String,Object> map){
        int flag = -1;
       if (map != null && map.size()>0){
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


//    public long getTotalSize(Class entityClass ,Map<String,Object> map){
//        Session session =  seesionFactory.openSession();
//        long total = 0;
//        String hql = "select count(1) from "+entityClass.getSimpleName() + " where 1=1 ";
//        if (map != null && map.size()>0){
//            StringBuilder sb = new StringBuilder();
//            for (String key:map.keySet()){
//                    sb.append(" and " + key + " = :" + key);
//            }
//        hql += sb.toString();
//        Query query = session.createQuery(hql);
//        for (String key:map.keySet()){
//           query.setParameter(key,map.get(key));
//        }
//        try {
//            total = (long)query.uniqueResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        }
//        else{
//            try {
//                total = (long)session.createQuery(hql).uniqueResult();
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                session.close();
//            }
//        }
//        return total;
//    }

    /**
     * 获取限定条件下记录总条数
     * @param hql
     * @param map
     * @return
     */
    public long getTotalSize(String hql,Map<String,Object> map){
        Session session =  seesionFactory.openSession();
        long total = 0;
        Query query = session.createQuery(hql);
        if (map != null && map.size() > 0){
            for (String key:map.keySet()){
                query.setParameter(key,map.get(key));
            }
        }
        try {
            total = (long)query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return total;
    }

    /**
     * 分页查询
     * @param hql
     * @param map
     * @param pageBean
     * @return
     */
    public List findByPage(String hql, Map<String,Object> map, PageBean pageBean){
        if (pageBean == null)
            pageBean = new PageBean();
        List list = null;
        Session session =  seesionFactory.openSession();
        Query query = session.createQuery(hql);
        if (map != null && map.size() > 0){
            for (String key:map.keySet()){
                query.setParameter(key,map.get(key));
            }
        }
        //得到滚动结果集
        ScrollableResults scroll = query.scroll();
        //滚动到最后一行
        scroll.last();
        //总记录条数
        int total = scroll.getRowNumber() + 1;
        //设置分页位置
        int start = (pageBean.getExpectPage()-1) * pageBean.getPerPage();
        query.setFirstResult(start);
        query.setMaxResults(pageBean.getPerPage());
        try {
            list = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    /**
     * 批量删除(只针对id为整型的情况)    23,45,78,54,21
     * @param ids
     * @return
     */
    public int deleteByIds(String ids){
        ids = (ids.charAt(ids.length()-1) == ',' ? ids.substring(0,ids.length()-1) : ids);
        String hql = "delete From "+clazz.getSimpleName()+" where id in (" + ids + ")";
        int flag = 1;
        flag = executeByHql(hql);
        return flag;
    }

    /**
     * 删除一个对象
     * @param t
     * @return
     */
    public int delete(T t){
        Session session = seesionFactory.openSession();
        int flag = 1;
        try {
            session.delete(t);
        } catch (Exception e) {
            e.printStackTrace();
            flag = -1;
        } finally {
            session.close();
        }
        return flag;
    }
}
