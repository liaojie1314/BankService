package com.example.bankservicedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
public class NormalUserActivity extends Activity {

    private static final String TAG = "NormalUserActivity";
    private NormalUserConnection mNormalUserConnection;
    private boolean mIsBind;
    private NormalUserAction mINormalUserAction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_user);
        doBindService();
        
    }

    private void doBindService() {
        Log.d(TAG, "doBindService...");
        Intent intent=new Intent();
        intent.setAction("com.example.ACTION_NORMAL_USER");
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setPackage(this.getPackageName());
        mNormalUserConnection = new NormalUserConnection();
        mIsBind = bindService(intent,mNormalUserConnection,BIND_AUTO_CREATE);
    }
    private class NormalUserConnection implements ServiceConnection{

        
        @Override
        public void onServiceConnected(ComponentName name, IBinder iBinder) {

            Log.d(TAG, "onServiceConnected..."+name);
            mINormalUserAction = NormalUserAction.Stub.asInterface(iBinder);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected..."+name);
        }
    }

    public void saveMoneyClick(View view) {
        Log.d(TAG, "saveMoneyClick...");
        try {
            mINormalUserAction.saveMoney(10000);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
    public void getMoneyClick(View view){
        Log.d(TAG, "getMoneyClick...");
        try {
            float money=mINormalUserAction.getMoney();
            Log.d(TAG, "get money is--> "+money);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public void loanMoneyClick(View view){
        Log.d(TAG, "loanMoneyClick...");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mIsBind&&mNormalUserConnection!=null) {
            Log.d(TAG, "unbind service");
            unbindService(mNormalUserConnection);
            mNormalUserConnection=null;
            mIsBind=false;
        }
    }
}
