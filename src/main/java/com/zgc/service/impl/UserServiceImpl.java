package com.zgc.service.impl;

import com.base.dao.BaseDao;
import com.base.service.Impl.BaseServiceImpl;
import com.base.util.MD5;
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
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    @Autowired
    UserDao userDao;
//    @Override
//    public int addUser(User user) {
//        user.setPassword(MD5.MD5Encrypt(user.getPassword()));
//       return userDao.addUser(user);
//    }


    @Override
    public BaseDao<User> getBaseDao() {
        return userDao;
    }
}
