package com.example.mvp2.dev3;

import java.util.ArrayList;

public class SubPresenter implements ISubPresenter{

    private ArrayList<SubData> mData;
    private SubAdapter mAdapter;
    SubActivity mActivity;
    ISubView mSubView;



    public SubPresenter(SubActivity mActivity, ISubView mSubView) {
        this.mActivity = mActivity;
        this.mSubView = mSubView;
    }

    @Override
    public void reqArrayList() {
        // 네크워크에서 보내서 데이터 요청해서 받기

        // ------- res 상태
        if(null == mData){
            return;
        }

    }

    @Override
    public void showList(ArrayList<SubData> list) {
        if(null == mAdapter){

        }

    }


}
