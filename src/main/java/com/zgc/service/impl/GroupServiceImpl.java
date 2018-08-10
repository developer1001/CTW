package com.zgc.service.impl;

import com.base.dao.BaseDao;
import com.base.service.Impl.BaseServiceImpl;
import com.zgc.dao.GroupDao;
import com.zgc.model.Group;
import com.zgc.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: CTW
 * @description: 班级
 * @author: laoyangtou
 * @create: 2018-08-10 10:47
 **/
@Service
public class GroupServiceImpl extends BaseServiceImpl<Group> implements IGroupService {
    @Autowired
    GroupDao groupDao;

    @Override
    public BaseDao<Group> getBaseDao() {
        return groupDao;
    }
}
