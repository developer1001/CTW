package com.zgc.service.impl;

import com.zgc.dao.UserDao;
import com.zgc.model.User;
import com.zgc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: CTW
 * @description: 用户
 * @author: laoyangtou
 * @create: 2018-07-10 13:18
 **/
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserDao userDao;
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
}
