package com.example.mvp2.dev4;

public class ThirdPresenter implements ThirdMVP.IThirdPrsenter {

    ThirdMVP.IThirdView mView;
    ThirdActivity mActivity;
    public String mId;
    public String mPw;


    @Override
    public void LoginClick(String id, String pw) {
        mId = id;
        mPw = pw;
        if(null == id || null == pw){
            return;

        }

    }

}
