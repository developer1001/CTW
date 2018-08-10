package com.zgc.service;

import com.base.service.IBaseService;
import com.zgc.model.BankCard;
import com.zgc.model.Citizen;

import java.util.List;

public interface ICitizenService extends IBaseService<Citizen> {

    /**
     * 获得是建行的银行卡的卡数量
     * @return
     */
     long getTotalSize();

    /**
     * 获取XX银行下的所有银行卡
     * @param bank 银行类别
     * @return
     */
    List<BankCard> findCardsList(String bank);
}
