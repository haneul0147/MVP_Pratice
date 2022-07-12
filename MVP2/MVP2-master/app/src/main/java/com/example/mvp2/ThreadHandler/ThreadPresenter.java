package com.example.mvp2.ThreadHandler;

import android.util.Log;

import com.example.mvp2.Dev5.Fragment.ThirdFragment;

public class ThreadPresenter implements IThreadMVP.IPresenter{
    ThreadActivity mActivitiy;
    ThirdFragment mFragment;
    IThreadMVP.IView mView;
    private String Data;

    private byte[] mStreams;

    public ThreadPresenter(ThirdFragment mFragment, IThreadMVP.IView mView) {
        this.mFragment = mFragment;
        this.mView = mView;
    }

    public ThreadPresenter(ThreadActivity mActivitiy, IThreadMVP.IView mView) {
        this.mActivitiy = mActivitiy;
        this.mView = mView;
    }

    @Override
    public void getData(int second) {
        Log.e("Presenter sencond =",String.valueOf(second));
        //todo activitiy가 죽어있으면 리턴
        // if (!isAliveActivity()) {return;}
        Data = "MVP 성공 : " +second + "초";
        mView.sendData(Data);

    }

    @Override
    public void BitmapStreamCompleted(byte[] Streams) {
        Log.e("Completed :", " "+Streams);
        //todo activitiy가 죽어있으면 리턴
        // if (!isAliveActivity()) {return;}
        mStreams = Streams;
        if(Streams == null){
            return;
        }
        reqRegister();


    }

    private void reqRegister() {
        //todo
        // Network / RequestBody / HashMap
    }
}
