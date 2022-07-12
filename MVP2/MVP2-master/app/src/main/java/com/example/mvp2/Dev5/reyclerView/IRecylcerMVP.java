package com.example.mvp2.Dev5.reyclerView;

import com.example.mvp2.Dev5.Fragment.ViewData;

public interface IRecylcerMVP {

    public interface IView{

        void sendData(ViewData viewData);
    }
    public interface IPresenter{

        void getlist();
    }
}
