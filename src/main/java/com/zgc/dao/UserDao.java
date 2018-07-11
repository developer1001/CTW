package com.zgc.dao;

import com.zgc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @program: CTW
 * @description: 用户
 * @author: laoyangtou
 * @create: 2018-07-10 13:12
 **/
@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user ) {
//        Session session = sessionFactory.getCurrentSession();
        Session session = sessionFactory.openSession();
        session.save(user);
    }
}
