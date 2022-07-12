package com.example.mvp2.Dev5.reyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mvp2.Dev5.Fragment.ViewData;
import com.example.mvp2.R;

public class RecyclerViewActivity extends AppCompatActivity implements IRecylcerMVP.IView{
    private RecyclerPresenter mPresenter;

    // private ArrayList<ViewData> arrayList;
    private ViewAdapter mviewAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private Button recbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mPresenter = new RecyclerPresenter(this);


        recyclerView = (RecyclerView)findViewById(R.id.rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        // arrayList = new ArrayList<>();
        recyclerView.setAdapter(mviewAdapter);

        initView();
        // initEvent();

        recbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewData viewData = new ViewData("홍길동",30);
             //   arrayList.add(viewData);
                mviewAdapter.notifyDataSetChanged();
            }
        });

    }

    public void initView() {
        recbtn = findViewById(R.id.recbtn);
    }

    @Override
    public void sendData(ViewData viewData) {

    }

    // View.OnClickListener mOnClickListner = new View.OnClickListener() {
    //     @Override
    //     public void onClick(View view) {
    //         ViewData viewdata = new ViewData("홍길동",30);
    //         arrayList.add(viewdata);
    //         viewAdapter.notifyDataSetChanged();
    //         // if(null == view){
    //         //     return;
    //         // }
    //         //
    //         // switch (view.getId()){
    //         //     case R.id.recbtn:
    //         //         addbtn();
    //         // }
    //     }
    // };

    // private void addbtn() {
    //     ViewData viewdata = new ViewData("홍길동",30);
    //     arrayList.add(viewdata);
    //     viewAdapter.notifyDataSetChanged();
    //     // ViewAdapter.notifyDataSetChanged();
    // }

    // public void initEvent(){
    //
    //
    //     recbtn.setOnClickListener(mOnClickListner);
    // }
}