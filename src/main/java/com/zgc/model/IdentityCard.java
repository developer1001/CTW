package com.zgc.model;

import com.alibaba.fastjson.annotation.JSONField;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @program: CTW
 * @description: 身份证
 * @author: laoyangtou
 * @create: 2018-08-08 17:38
 **/
@Entity
@Table(name = "identity_card")
public class IdentityCard {
    private String id;
    private Timestamp made_time;//制卡时间
    private Timestamp validity_period;//有效期
    private String made_address;//制卡地点
    private Citizen citizen;//公民，和身份证是一对一关系

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    public Timestamp getMade_time() {
        return made_time;
    }

    public void setMade_time(Timestamp made_time) {
        this.made_time = made_time;
    }
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    public Timestamp getValidity_period() {
        return validity_period;
    }

    public void setValidity_period(Timestamp validity_period) {
        this.validity_period = validity_period;
    }

    public String getMade_address() {
        return made_address;
    }

    public void setMade_address(String made_address) {
        this.made_address = made_address;
    }

    @OneToOne(targetEntity = Citizen.class)
    @JoinColumn(name = "citizen_id")
    @JSONField(serialize = false)
    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }

    public IdentityCard() {
    }

    public IdentityCard(String id,Timestamp made_time, Timestamp validity_period, String made_address, Citizen citizen) {
        this.id = id;
        this.made_time = made_time;
        this.validity_period = validity_period;
        this.made_address = made_address;
        this.citizen = citizen;
    }
}
