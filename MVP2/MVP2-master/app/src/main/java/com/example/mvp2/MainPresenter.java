package com.example.mvp2;

public class MainPresenter implements IPresenter {

    MainActivity mActivity;
    IView mIView;

    public MainPresenter(MainActivity activity, IView view) {
        mActivity = activity;
        mIView = view;
    }

    @Override
    public void move() {
        mIView.moveNextAction();
    }
}
