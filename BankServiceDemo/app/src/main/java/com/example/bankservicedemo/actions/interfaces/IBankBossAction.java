package com.example.bankservicedemo.actions.interfaces;

public interface IBankBossAction extends IBankWorkerAction {
//修改用户账号金额
    void modifyUserAccountMoney(float money);
}
