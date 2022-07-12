package com.example.mvp2.Dev5.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mvp2.R;
import com.example.mvp2.ThreadHandler.IThreadMVP;
import com.example.mvp2.ThreadHandler.ThreadActivity;
import com.example.mvp2.ThreadHandler.ThreadPresenter;

import java.lang.ref.WeakReference;


public class ThirdFragment extends Fragment implements IThreadMVP.IView {
    IThreadMVP.IPresenter mPresenter;
    ThreadHandler mThreadHandler;
    ThreadActivity mActivitiy;
    IThreadMVP.IView mView;
    private Thread mThread;
    ViewGroup rootView;
    public TextView third_txt;
    private Button third_Threadstart_btn;
    private Button third_ThreadPause_btn;
    private Button third_ThreadReset_btn;
    private String MvpData;

    public  int second = 0;
    public boolean work = true;


    public ThirdFragment(ThreadActivity mActivitiy, IThreadMVP.IView mView) {
        this.mActivitiy = mActivitiy;
        this.mView = mView;
    }


    public ThirdFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_third,container,false);
        initView();
        initEvent();
        mThreadHandler = new ThreadHandler(this);
        mPresenter = new ThreadPresenter(this,this);
        return rootView;

    }

    public void initView(){
        third_txt = (TextView) rootView.findViewById(R.id.third_txt);
        third_Threadstart_btn = (Button) rootView.findViewById(R.id.third_ThreadStart_btn);
        third_ThreadPause_btn = (Button)rootView.findViewById(R.id.third_ThreadPause_btn);
        third_ThreadReset_btn = (Button) rootView.findViewById(R.id.third_ThreadReset_btn);
    }

    public void initEvent() {
        third_Threadstart_btn.setOnClickListener(mClickListenr);
        third_ThreadPause_btn.setOnClickListener(mClickListenr);
        third_ThreadReset_btn.setOnClickListener(mClickListenr);

    }

    View.OnClickListener mClickListenr = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ThirdOnClickView(view);
        }
    };

    private void ThirdOnClickView(View v){
        if(null == v){
            return;
        }
        switch (v.getId()){
            case R.id.third_ThreadStart_btn:
                StartThread();
                break;
            case R.id.third_ThreadPause_btn:
                PauseThread();
                break;
            case R.id.third_ThreadReset_btn:
                ResetThread();
                break;

        }
    }


    private void StartThread() {
        stopThread();
        WorkIsFalse();
        mThread = new Thread(new ThreadStream());
        mThread.start();

    }

    private void stopThread() {
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
            WorkIsFalse();
        }
    }

    private void PauseThread() {
        Log.e("다시 시작 ", String.valueOf(work));
        if (work == false) {
            work = true;
            // threadtxt.setText(MvpData);
        }else if(work == true){
            work = false;
            // threadtxt.setText(second);
        }
        Log.e("다시 시작2 ", String.valueOf(work));


    }
    private void ResetThread() {
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
            WorkIsFalse();
            Log.e("Second + ",""+second);
        }
    }

    private void WorkIsFalse(){
        if(work == false)
        {work = true;}
    }

    class ThreadStream implements Runnable {

        @Override
        public void run() {
            Log.e("Thread Start ", String.valueOf(work));
            while (true) {

                if (work == false) {
                    third_txt.setText(MvpData);
                    Log.e("Thread MVP 데이터 ", MvpData);
                    continue;}

                // Log.e("while문  : ", Integer.toString(second));
                second++;
                Log.e("while문  : ", Integer.toString(second));

                try {
                    // 비트맵이 성공할 경우 압축하는 코드
                    //conversionBitmapStream();
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
                third_txt.setText(Integer.toString(second));
                Log.e("while문 last : ", Integer.toString(second));
            }

        }
        }
    @Override
    public void sendData(String Data) {
        MvpData = Data ;
    }

    public class ThreadHandler extends Handler {
        private final WeakReference<ThirdFragment> mActivitiy;

        ThreadHandler(ThirdFragment activity) {
            mActivitiy = new WeakReference<ThirdFragment>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            ThirdFragment activity = mActivitiy.get();
            if (activity != null) {
                activity.handBitMessage(msg);
            }
        }
    }
        public void handBitMessage(Message message){
            Log.e("handBitmapMessage = ", "message =" + message);

            mPresenter.getData(second);
            // mPresenter.BitmapStreamCompleted(mStreams);
        }
    }
