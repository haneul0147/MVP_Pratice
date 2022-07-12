package com.example.mvp2.ThreadHandler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.example.mvp2.R;

import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.net.URL;

public class ThreadActivity extends AppCompatActivity implements IThreadMVP.IView{
    IThreadMVP.IPresenter mPresenter;
    private Button startbtn;
    private Button stopbtn;
    private Button resetbtn;
    private Button restart;
    private Button camera;
    private String MvpData;
    public  int second = 0;
    public boolean work = true;
    public TextView threadtxt;
    private ThreadHandler mThreadHandler;
    private Thread mThread;

    private Bitmap mFaceBitmap;
    private byte[] mStreams;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        mPresenter = new ThreadPresenter(this,this);
        mThreadHandler = new ThreadHandler(this);
        initView();
        initEvent();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopThread();

    }

    // static class BitmapStreamHandler extends Handler{
    //     private final WeakReference<ThreadActivity> mActivity;
    //
    //     BitmapStreamHandler(ThreadActivity activity) {
    //         mActivity = new WeakReference<ThreadActivity>(activity);
    //     }
    //
    //     @Override
    //     public void handleMessage(@NonNull Message msg) {
    //         ThreadActivity activity =mActivity.get();
    //         if(activity != null){
    //             activity.handBitmapMessage(msg);
    //         }
    //     }
    // }

    public void initView(){
        startbtn = findViewById(R.id.startbtn);
        stopbtn = findViewById(R.id.stopbtn);
        threadtxt = findViewById(R.id.threadtxt);
        restart = findViewById(R.id.restart);
        resetbtn = findViewById(R.id.resetbtn);
        camera = findViewById(R.id.camera);
    }

    public void initEvent(){
        startbtn.setOnClickListener(mClickListenr);
        stopbtn.setOnClickListener(mClickListenr);
         restart.setOnClickListener(mClickListenr);
         resetbtn.setOnClickListener(mClickListenr);
        camera.setOnClickListener(mClickListenr);
    }


    View.OnClickListener mClickListenr = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            OnClickView(view);
        }
    };

    private void OnClickView(View v){
        if(null == v){
            return;
        }

        switch (v.getId()){
            case R.id.startbtn:
                startThread();
                break;
            case R.id.stopbtn:
                stopThread();
                break;
            case R.id.restart:
                restartThread();
                break;
            case R.id.resetbtn:
                resetThread();
                break;
            case R.id.camera:
                camera();
                break;



        }
    }

    private void camera(){

    }

    @Override
    public void sendData(String Data) {
        MvpData = Data ;
    }


    class ThreadStream implements Runnable {

        @Override
        public void run() {

            Log.e("Thread ", String.valueOf(work));
            while (true) {
                if(work == false){
                    threadtxt.setText(MvpData);
                    continue;
                }
                Log.e("while문  : ", Integer.toString(second));
                second++;

            try {

                // 비트맵이 성공할 경우 압축하는 코드

                conversionBitmapStream();
                // if(work == false){
                //     continue;
                // }
                Thread.sleep(1000);

               mThreadHandler.sendEmptyMessage(0);

            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
                // mThread.interrupt();
                threadtxt.setText(Integer.toString(second));
               Log.e("시간 : ", Integer.toString(second));
            }

            // int second = 0;
            // try {
            //     Thread.sleep(5000);
            //
            //     mThreadHandler.sendEmptyMessage(0);
            //     Log.e("시간 : ", Integer.toString(second));
            // } catch (InterruptedException e) {
            //     e.printStackTrace();
            // }
        }

        private void conversionBitmapStream() {
            try {

                Bitmap bitmap = mFaceBitmap;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                mStreams = baos.toByteArray();
                baos.close();

            } catch (Exception e) {
                e.printStackTrace();
                // if (null != mCustomFaceDetectionProcessor) {
                //     mCustomFaceDetectionProcessor.resetAuth();
                }
            }
        }



    private void startThread(){
        stopThread();
        mThread = new Thread(new ThreadStream());
        mThread.start();
    }

    private void stopThread(){
        if(null != mThread){
            boolean state = mThread.isAlive() && !mThread.isInterrupted();
            if(state){
                try {
                    mThread.interrupt();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            mThread = null;
        }
    }
    private void restartThread() {
        Log.e("다시 시작 ", String.valueOf(work));
        if (work == false) {
            work = true;
           // threadtxt.setText(MvpData);
        }else  if(work == true){
            work = false;
            // threadtxt.setText(second);
        }

        Log.e("다시 시작2 ", String.valueOf(work));

        // work = false;
        // // mThread.start();
        // return work;
    }

    private void resetThread(){
        if(null != mThread){
            boolean state = mThread.isAlive() && !mThread.isInterrupted();
            if(state){
                try {
                    mThread.interrupt();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            mThread = null;
            second = 0;
        }
    }


    static class ThreadHandler extends Handler{
        private final WeakReference<ThreadActivity> mActivitiy;

         ThreadHandler(ThreadActivity activity) {
            mActivitiy = new WeakReference<ThreadActivity>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            ThreadActivity activity = mActivitiy.get();
            if(activity != null){
                activity.handBitMessage(msg);
            }
        }
    }
    public void handBitMessage(Message message){
        Log.e("handBitmapMessage = ", "message =" + message);

        if(isFinishingOrDestroyed()){return;}

        mPresenter.getData(second);
        mPresenter.BitmapStreamCompleted(mStreams);
    }

    public boolean isFinishingOrDestroyed() {
        return isFinishing() || isDestroyed();
    }

}

