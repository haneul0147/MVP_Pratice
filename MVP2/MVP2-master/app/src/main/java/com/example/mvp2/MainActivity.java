package com.example.mvp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements IView {

    IPresenter mIPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mIPresenter = new MainPresenter(this, this);
    }

    View.OnClickListener mO = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mIPresenter.move();
        }
    };

    @Override
    public void moveNextAction() {

    }
}