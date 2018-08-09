package com.zgc.service.impl;

import com.base.dao.BaseDao;
import com.base.service.Impl.BaseServiceImpl;
import com.zgc.dao.CitizenDao;
import com.zgc.model.Citizen;
import com.zgc.service.ICitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: CTW
 * @description: 公民
 * @author: laoyangtou
 * @create: 2018-08-08 16:44
 **/
@Service
public class CitizenServiceImpl extends BaseServiceImpl<Citizen> implements ICitizenService {

    @Autowired
    CitizenDao citizenDao;

    @Override
    public BaseDao<Citizen> getBaseDao() {
        return citizenDao;
    }
}