package com.zgc.service.impl;

import com.base.dao.BaseDao;
import com.base.service.IBaseService;
import com.base.service.Impl.BaseServiceImpl;
import com.zgc.dao.SysLogDao;
import com.zgc.model.SysLog;
import com.zgc.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: CTW
 * @description: 系统日志
 * @author: laoyangtou
 * @create: 2018-08-13 14:33
 **/
@Service
public class SysLogServiceImpl extends BaseServiceImpl<SysLog> implements ISysLogService {

    @Autowired
    SysLogDao sysLogDao;
    @Override
    public BaseDao<SysLog> getBaseDao() {
        return sysLogDao;
    }
}
