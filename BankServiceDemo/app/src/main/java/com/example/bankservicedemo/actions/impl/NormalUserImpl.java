package com.example.bankservicedemo.actions.impl;

import android.os.Binder;
import android.util.Log;

import com.example.bankservicedemo.actions.interfaces.INormalUserAction;

public class NormalUserImpl extends Binder implements INormalUserAction {
    private static final String TAG = "NormalUserimpl";

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
