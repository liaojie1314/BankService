package com.example.bankservicedemo.actions.impl;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.bankservicedemo.NormalUserAction;

public class NormalUserAIDLActionImpl extends NormalUserAction.Stub {
    private static final String TAG = "NormalUserAIDLAction";

    @Override
    public void saveMoney(float money){
        Log.d(TAG, "normal user save money-->"+money);
    }

    @Override
    public float getMoney(){
        return 1000;
    }
}
