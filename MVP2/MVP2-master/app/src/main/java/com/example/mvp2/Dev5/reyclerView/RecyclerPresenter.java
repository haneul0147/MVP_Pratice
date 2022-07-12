package com.example.mvp2.Dev5.reyclerView;

import com.example.mvp2.Dev5.Fragment.ViewData;

import java.util.ArrayList;

public class RecyclerPresenter implements IRecylcerMVP.IPresenter{
    ArrayList<ViewData> mList = new ArrayList<>();
    IRecylcerMVP.IView mIView;

    public RecyclerPresenter(IRecylcerMVP.IView mIView) {
        this.mIView = mIView;
    }
    @Override
    public void getlist() {
        ViewData viewData = new ViewData("Presenter 성공",30);
        mIView.sendData(viewData);
    }
}
