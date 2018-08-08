package com.zgc.action;

import com.base.action.BaseAction;
import com.base.model.Json;
import com.base.util.MD5;
import com.zgc.model.Citizen;
import com.zgc.service.ICitizenService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

/**
 * @program: CTW
 * @description: 公民
 * @author: laoyangtou
 * @create: 2018-08-08 16:48
 **/
@Namespace("/")
@Scope("prototype")
@Results( {
//        @Result(name="success",location="/index.jsp"),
//        @Result(name="failure",location="/index.jsp")
})
public class CitizenAction extends BaseAction<Citizen> {
    @Autowired
    ICitizenService citizenService;
//http://localhost:8080/CTW/Citizen_add.do?baseEntity.name=yang&baseEntity.sex=xy&baseEntity.address=henan&baseEntity.birthday=2018-08-01
    public void add() {
        int result = -1;
        try {
            result =  citizenService.save(getBaseEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == 1)
            writeJson(new Json(true,"操作成功"));
        else
            writeJson(new Json(false,"操作失败"));
    }
}
