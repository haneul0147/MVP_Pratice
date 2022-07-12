package com.example.mvp2.Dev5.reyclerView;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mvp2.Dev5.Fragment.ViewData;
import com.example.mvp2.R;
import com.example.mvp2.dev.DevPresenter;

import java.util.ArrayList;


public class SecondFragment extends Fragment implements IRecylcerMVP.IView {

    private ArrayList<ViewData> mList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ViewAdapter viewAdapter;
    private IRecylcerMVP.IPresenter mPresentr;
    private LinearLayoutManager linearLayoutManager;
    private Button btn;
    ViewGroup rootView;


//    public SecondFragment(IRecylcerMVP.IPresenter mPresentr) {
//        this.mPresentr = mPresentr;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_second,container,false);

        initView();

        initEvent();

        // recyclerView = (RecyclerView) rootView.findViewById(R.id.frag_recycler);
        // btn = (Button)rootView.findViewById(R.id.addbtn);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // recyclerView.setAdapter(adapter);
        return rootView;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresentr = new RecyclerPresenter( this);
        addlist();
    }

    private void addlist() {
        mList = new ArrayList<>();
        mList.add(new ViewData("홍길동",30));
        mList.add(new ViewData("김땡땡",20));
        mList.add(new ViewData("김김",14));
        mList.add(new ViewData("이름없음",27));

    }

    public void initView(){
        recyclerView = (RecyclerView) rootView.findViewById(R.id.frag_recycler);
        btn = (Button)rootView.findViewById(R.id.addbtn);
        // arrayList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(layoutManager);
        viewAdapter = new ViewAdapter(mList);

        recyclerView.setAdapter(viewAdapter);


        // linearLayoutManager = new LinearLayoutManager(this);
        // recyclerView.setLayoutManager(linearLayoutManager);
        // arrayList = new ArrayList<>();
        // viewAdapter = new ViewAdapter(arrayList);
        // recyclerView.setAdapter(viewAdapter);
        // recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // recyclerView.setAdapter(viewAdapter);

    }

    public void initEvent(){
        btn.setOnClickListener(mClickListner);
    }

    View.OnClickListener mClickListner = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //todo 고치기
             mPresentr.getlist();
//            ViewData viewData = new ViewData("홍길동",30);
            // mList.add(viewData);
//             Log.e("viewData =",""+viewData);
          //  viewAdapter.notifyDataSetChanged();
        }
    };

    @Override
    public void sendData(ViewData viewData) {
        if(viewData == null){
            return;
        }
         mList.add(viewData);
        Log.e("viewData =",""+viewData);
        viewAdapter.notifyDataSetChanged();
    }
}