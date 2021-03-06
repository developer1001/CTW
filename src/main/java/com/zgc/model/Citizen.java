package com.zgc.model;

import com.alibaba.fastjson.annotation.JSONField;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: CTW
 * @description: 公民
 * @author: laoyangtou
 * @create: 2018-08-08 15:34
 **/
@Entity
@Table(name = "citizen")
public class Citizen implements Serializable {
    private static final long serialVersionUID = 4521987946419945301L;
    private Integer id;//
    private String name;//姓名
    private String sex;//xx or xy
    private String address;//家庭住址
    private Date birthday;//生日
    private Set<BankCard> bankCards = new HashSet<>();//银行卡
    private IdentityCard identityCard;//身份证

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @JSONField(format="yyyy-MM-dd")
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @OneToMany(mappedBy = "citizen",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    public Set<BankCard> getBankCards() {
        return bankCards;
    }

    public void setBankCards(Set<BankCard> bankCards) {
        this.bankCards = bankCards;
    }

    @OneToOne(mappedBy = "citizen",cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    public IdentityCard getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(IdentityCard identityCard) {
        this.identityCard = identityCard;
    }

    public void addCards(BankCard bankCard){
        bankCards.add(bankCard);
    }
}
