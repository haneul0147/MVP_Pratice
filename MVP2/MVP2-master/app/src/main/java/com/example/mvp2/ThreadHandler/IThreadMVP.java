package com.example.mvp2.ThreadHandler;

import android.util.Log;

public interface IThreadMVP {
    public interface IView{
        void sendData(String Data);

    }
    public interface IPresenter{

        void getData(int second);

        void BitmapStreamCompleted(byte[] mStreams);

    }
}
