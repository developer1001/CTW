package com.zgc.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @program: CTW
 * @description: 银行卡，一个用户可以有多张银行卡
 * @author: laoyangtou
 * @create: 2018-08-08 17:51
 **/
@Entity
@Table(name = "bank_card")
public class BankCard {
    private Integer id;
    private String bank;//所属银行
    private Date made_time;//制卡时间
    private Date validity_period;//有效期至
    private Citizen citizens;//关联的公民

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Date getMade_time() {
        return made_time;
    }

    public void setMade_time(Date made_time) {
        this.made_time = made_time;
    }

    public Date getValidity_period() {
        return validity_period;
    }

    public void setValidity_period(Date validity_period) {
        this.validity_period = validity_period;
    }

    public Citizen getCitizens() {
        return citizens;
    }

    public void setCitizens(Citizen citizens) {
        this.citizens = citizens;
    }
}
