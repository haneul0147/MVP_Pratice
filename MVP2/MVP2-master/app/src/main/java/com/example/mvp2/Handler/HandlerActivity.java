package com.example.mvp2.Handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp2.R;

import java.lang.ref.WeakReference;

public class HandlerActivity extends AppCompatActivity implements IHanderMVP.IView {

    private static final int MESSAGE_TIMER_START = 100;
    private static final int HANDLER_WHAT_SHUTDOWN = 1;
    private TimeDelayHander mTImeDelayHander;
    private Button Intentbtn;
    private Button Handlerbtn;
    IHanderMVP.IPresenter mIPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        mIPresenter = new HandlerPresenter(this,this);

        mTImeDelayHander = new TimeDelayHander(this);

        initView();
        initEvent();
    }

    protected void onDestroy(){
        super.onDestroy();

        removeShutdownHandelr();

    } public boolean isFinishingOrDestroyed() {
        return isFinishing() || isDestroyed();
    }

    private void removeShutdownHandelr() {
        if(mTImeDelayHander.hasMessages(HANDLER_WHAT_SHUTDOWN)){
            mTImeDelayHander.removeMessages(HANDLER_WHAT_SHUTDOWN);

        }
    }

    public void initView(){
        Intentbtn = findViewById(R.id.Intentbtn);
        Handlerbtn = findViewById(R.id.Handelrbtn);
    }

    public void initEvent(){
        Intentbtn.setOnClickListener(mClickListner);
        Handlerbtn.setOnClickListener(mClickListner);

    }

    View.OnClickListener mClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {onClickEvent(view);}
    };

    private void onClickEvent(View v){
        if(null == v){
            return;
        }

        switch (v.getId()){
            case R.id.Intentbtn:
                mIPresenter.IntentbtnClick();
            case R.id.Handelrbtn:
                mTImeDelayHander.sendEmptyMessageDelayed(MESSAGE_TIMER_START,1000);

        }
    }


    static class TimeDelayHander extends Handler{

        int count = 0;
        // 메모리 누수 방지
        // GC
        private final WeakReference<HandlerActivity> mActivity;
        TimeDelayHander(HandlerActivity activity){
            mActivity = new WeakReference<HandlerActivity>(activity);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            HandlerActivity activity = mActivity.get();
            if(activity != null){
                switch (msg.what){
                    case MESSAGE_TIMER_START:
                        Log.d("TimeHandelr","Time Start :" + count++);
                        break;

                }
                // activity.handleTimeMessage(msg);
            }
        }
    }
}
