package com.example.mvp2.dev3;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp2.R;

public class SubActivity extends AppCompatActivity implements ISubView {
    SubPresenter mPresenter;
    RecyclerView recyclerView;
    SubAdapter adapter;
    LinearLayoutManager mlayoutManager;

    public SubActivity(SubPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        recyclerView = findViewById(R.id.RecylerView);

        mlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mlayoutManager);

        // recyclerView.setAdapter(new);
    }

    View.OnClickListener ClickAdapter = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mPresenter.reqArrayList();
        }
    };
}
