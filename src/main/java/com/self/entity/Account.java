package com.self.entity;

/**
 * Created by wacai on 2016/3/11.
 */
public class Account {
    private Long acctNo;
    private Long bal;

    public Account(Long acctNo, Long bal){
        this.acctNo = acctNo;
        this.bal = bal;
    }

    public Long getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(Long acctNo) {
        this.acctNo = acctNo;
    }

    public Long getBal() {
        return bal;
    }

    public void setBal(Long bal) {
        this.bal = bal;
    }

    @Override
    public String toString() {
        return "Account{" +
                "acctNo=" + acctNo +
                ", bal=" + bal +
                '}';
    }
}
