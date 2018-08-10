package com.zgc.dao;

import com.base.dao.BaseDao;
import com.zgc.model.BankCard;
import com.zgc.model.Citizen;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: CTW
 * @description: 公民
 * @author: laoyangtou
 * @create: 2018-08-08 16:41
 **/
@Repository
public class CitizenDao extends BaseDao<Citizen> {

    /**
     * 获得是建行的银行卡的卡数量
     * @return
     */
    public long getTotalSize(){
        String hql = "select count(1) from BankCard where bank = :bank";
        Map<String,Object> map = new HashMap<>();
        map.put("bank","建设银行");
        return  getTotalSize(hql,map);
    }

    public List<BankCard> getCardsList(String bank){
        String hql = "From BankCard where bank = :bank";
        Map<String,Object> map = new HashMap<>();
        map.put("bank",bank);
        return findByHql(hql,map);
    }
}
