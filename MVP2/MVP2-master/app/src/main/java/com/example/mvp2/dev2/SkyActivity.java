package com.example.mvp2.dev2;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp2.R;

public class SkyActivity extends AppCompatActivity implements ISkyMVP.ISkyView{

    ISkyMVP.ISkyPresenter mISkyPresenter;
    private String ldata;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_sky);

        mISkyPresenter = new SkyPresenter(this,this);
    }

View.OnClickListener ClickListener = new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        mISkyPresenter.sendData("1");

    }
};

    @Override
    public void showdata(String data) {
      if(data == null){
          return;
      }
        ldata = data;
        Log.e("ldata",ldata);
    }

    View.OnClickListener NetworkClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mISkyPresenter.showNetworkData();
        }
    };
}
