package com.example.mvp2.Handler;

import android.content.Intent;

import com.example.mvp2.MainActivity;

public class HandlerPresenter implements IHanderMVP.IPresenter{

    HandlerActivity mActivity;
    IHanderMVP.IView mView;

    public HandlerPresenter(HandlerActivity mActivity, IHanderMVP.IView mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }

    @Override
    public void IntentbtnClick() {
        Intent intent = new Intent(mActivity, IntentActivity.class);

        mActivity.startActivity(intent);
        mActivity.overridePendingTransition(0,0);
    }

    protected void onDestory(){
    }

}
