package com.example.mvp2.Dev5.ViewPage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mvp2.R;
import com.example.mvp2.Dev5.Fragment.FirstFragment;
import com.example.mvp2.Dev5.reyclerView.SecondFragment;
import com.example.mvp2.Dev5.Fragment.ThirdFragment;

public class ViewActivity extends AppCompatActivity {

    private ViewPager2 ViewPager;
    private TextView ViewPagertxt;
    private FragmentStateAdapter pagerAdapter;
    private static final int NUM_PAGES=3;
    private long backKeyPressedTime = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        initView();
        pagerAdapter=new ScreeSlidePagerAdapter(this);
        ViewPager.setAdapter(pagerAdapter);

    }

    public void initView(){
        ViewPager = findViewById(R.id.ViewPager);
        ViewPagertxt = findViewById(R.id.Viewpagertxt);
    }

    public class ScreeSlidePagerAdapter extends FragmentStateAdapter{

        public ScreeSlidePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }


        @NonNull
        @Override
        public Fragment createFragment(int position) {
            // switch (position){
            //     case 0:
            //         return new Ex01Fragment();
            //         break;
            //     case 1:
            //             new Ex02Fragment();
            //         break;
            //     case 2:
            //         return new Ex03Fragment();
            //         break;
            // }

            if(position==0) return new FirstFragment();
            else if(position==1) return new SecondFragment();
            else return new ThirdFragment();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }

    @Override
    public void onBackPressed() {
        if(ViewPager.getCurrentItem()==0){
            Toast.makeText(this,"한번 더 누름 종료",Toast.LENGTH_SHORT).show();
            // if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            //     backKeyPressedTime = System.currentTimeMillis();
            //     super.onBackPressed();
            // }
    }else {
            ViewPager.setCurrentItem(ViewPager.getCurrentItem()-1);
        }
}
}
