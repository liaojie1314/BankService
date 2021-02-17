package com.example.bankservicedemo.actions.impl;

import android.os.Binder;
import android.util.Log;

import com.example.bankservicedemo.actions.interfaces.IBankWorkerAction;

public class BankWorkerActionImpl extends Binder implements IBankWorkerAction {
    private static final String TAG = "BankWorkerimpl";

    @Override
    public void checkUserCredit() {
        Log.d(TAG, "checkUserCredit-->790");
    }

    @Override
    public void freezeUserAccount() {
        Log.d(TAG, "freezeUserAccount-->0");

    }

    @Override
    public void saveMoney(float money) {
        Log.d(TAG, "saveMoney-->" + money);
    }

    @Override
    public float getMoney() {
        Log.d(TAG, "getMoney-->100.00");
        return 100.00f;
    }

    @Override
    public float loanMoney() {
        Log.d(TAG, "loanMoney-->100.00");
        return 100.00f;
    }
}
