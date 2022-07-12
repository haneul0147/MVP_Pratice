package com.example.mvp2.dev2;

import android.util.Log;

import com.example.mvp2.dev.DevActivity;
import com.example.mvp2.dev.IDevView;

public class SkyPresenter implements ISkyMVP.ISkyPresenter{

    SkyActivity mActivity;
    ISkyMVP.ISkyView mIView;
    private String mData;

public SkyPresenter(SkyActivity activity , ISkyMVP.ISkyView View ) {
        mActivity = activity;
        mIView = View;
    }



    @Override
    public void sendData(String data) {
        if(data == null){
            return; }
        Log.e("data1",data);
        mData = data + "2";
        mIView.showdata(data);
        Log.e("data2",data);

    }

    @Override
    public void showNetworkData() {


    }
}
