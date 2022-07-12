package com.example.mvp2.dev;

import com.example.mvp2.IView;
import com.example.mvp2.MainActivity;

public class DevPresenter implements IDevPresenter {

    DevActivity mActivity;
    IDevView mIView;

    private String mName;

    public DevPresenter(DevActivity activity, IDevView view) {
        mActivity = activity;
        mIView = view;
    }

    @Override
    public void updateName(String name) {
        mName = name;
        mIView.showName(name);
    }

    @Override
    public void send() {
        String name = mName;

        // req.setName(name);
    }
}
