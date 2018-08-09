package com.zgc.action;

import com.base.action.BaseAction;
import com.base.model.Json;
import com.zgc.model.BankCard;
import com.zgc.model.Citizen;
import com.zgc.model.IdentityCard;
import com.zgc.service.ICitizenService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //测试级联保存
        Citizen citizen = new Citizen();
        citizen.setAddress("测试地址");
        citizen.setName("laoyangtou");
        citizen.setSex("xy");
        citizen.setBirthday(new Date());
        citizen.addCards(new BankCard("建设银行",new Date(),new Date(new Date().getTime()+10*365*24*60*60*10000),citizen));
        citizen.addCards(new BankCard("工商银行",new Date(),new Date(new Date().getTime()+10*365*24*60*60*10000),citizen));
        citizen.addCards(new BankCard("人民银行",new Date(),new Date(new Date().getTime()+10*365*24*60*60*10000),citizen));
        citizen.setIdentityCard(new IdentityCard(""+(int)((Math.random()*564893548)),new Timestamp(new Date().getTime()),
                new Timestamp(new Date().getTime()+10*365*24*60*60*10000),"西虹市公安局",citizen));
        int result = -1;
        try {
//            result =  citizenService.save(getBaseEntity());
            result =  citizenService.save(citizen);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result == 1)
            writeJson(new Json(true,"操作成功"));
        else
            writeJson(new Json(false,"操作失败"));
    }

    /**
     * 级联删除
     */
    public void delete(){
//        String hql = "delete from Citizen where id =:id";
//        Map<String,Object> map = new HashMap<>();
//        map.put("id",id);
        try {
//            citizenService.updateOrDel(hql,map);
            citizenService.deleteById(Citizen.class,id);
            writeJson(new Json(true,"操作成功"));
        } catch (Exception e) {
            e.printStackTrace();
            writeJson(new Json(false,"操作失败"));
        }
    }

    /**
     *z查找
     */
    public void find(){
        try {
           Citizen citizen = citizenService.findById(Citizen.class,id);
            writeJson(new Json(true,citizen));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *z查找所有
     */
    public void findAll(){
        try {
            List<Citizen> citizens = citizenService.findAll(Citizen.class);
            writeJsonNofer(new Json(true,citizens));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新一个对象，测试
     */

    public void updateSingleObj(){
        //写一个测试的map集合
        Map<String,Object> map = new HashMap<>();
        map.put("bank",""+((int)(Math.random()*4654164)));
        try {
            citizenService.updateSingleObj(BankCard.class,id,map);
            writeJson(new Json(true,"操作成功"));
        } catch (Exception e) {
            e.printStackTrace();
            writeJson(new Json(false,"操作失败"));
        }
    }
}