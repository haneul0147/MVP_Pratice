package com.example.mvp2.dev2;

public interface ISkyMVP {



    interface ISkyView{
        void showdata(String data);

    }



    interface ISkyPresenter{
        void sendData(String data);

        void showNetworkData();
    }

}
