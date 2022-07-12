package com.example.mvp2.Dev5.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvp2.Dev5.reyclerView.RecyclerPresenter;
import com.example.mvp2.R;
import com.example.mvp2.ThreadHandler.IThreadMVP;


public class FirstFragment extends Fragment {

    IThreadMVP.IPresenter mPresenter;
    ViewGroup rootView;

    public FirstFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_first,container,false);

        return rootView;
    }
}