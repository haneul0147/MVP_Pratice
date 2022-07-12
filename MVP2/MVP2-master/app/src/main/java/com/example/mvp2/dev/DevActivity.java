package com.example.mvp2.dev;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mvp2.IPresenter;
import com.example.mvp2.MainPresenter;
import com.example.mvp2.R;

public class DevActivity extends AppCompatActivity implements IDevView {

    IDevPresenter mIPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIPresenter = new DevPresenter(this, this);
    }

    View.OnClickListener mO = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mIPresenter.updateName("aaaa");
        }
    };

    View.OnClickListener mO1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mIPresenter.send();
        }
    };

    @Override
    public void ss() {

    }

    @Override
    public void showName(String name) {
        // text.setText(name);
    }
}
