package com.example.mvp2.dev4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mvp2.R;

public class ThirdActivity extends AppCompatActivity implements ThirdMVP.IThirdView {

    ThirdMVP.IThirdPrsenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    View.OnClickListener Login = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String ID = "ID";
            String PW = "PW";

            mPresenter.LoginClick(ID,PW);
        }
    };

    @Override
    public void showMyInfo(String id) {

    }
}