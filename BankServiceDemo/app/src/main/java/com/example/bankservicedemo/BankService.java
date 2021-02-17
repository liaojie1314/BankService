package com.example.bankservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;

import androidx.annotation.Nullable;

import com.example.bankservicedemo.actions.impl.BankBossActionImpl;
import com.example.bankservicedemo.actions.impl.BankWorkerActionImpl;
import com.example.bankservicedemo.actions.impl.NormalUserAIDLActionImpl;

public class BankService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        String action =intent.getAction();
        if (!TextUtils.isEmpty(action)) {
            if ("com.example.ACTION_NORMAL_USER".equals(action)) {
                return new NormalUserAIDLActionImpl();
            }else if ("com.example.ACTION_BANK_WORKER".equals(action)){
                return new BankWorkerActionImpl();
            }else if ("com.example.ACTION_BANK_BOSS".equals(action)){
                return new BankBossActionImpl();
            }
        }
        return null;
    }
}
