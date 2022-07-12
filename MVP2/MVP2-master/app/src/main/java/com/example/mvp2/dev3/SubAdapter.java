package com.example.mvp2.dev3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp2.R;

import java.util.List;

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.ViewHolder> {

    Context context;
    List<SubData> list;

    public SubAdapter(Context context, List<SubData> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_sub,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SubData data = list.get(position);
        holder.nickname.setText(data.Nickname);


    }

    @Override
    public int getItemCount() {
        int count = 0;

        count = null != list ? list.size() : 0;

        return count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nickname;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nickname = itemView.findViewById(R.id.txt1);
        }
    }

    // 추가 하는 코드
    public void setData(int position, SubData data) {
        if (null != list && list.size() > position) {
            list.set(position, data);
        }
    }

    public SubData getData(int position) {
        if (null != list && list.size() > position) {
            return list.get(position);
        }

        return null;
    }


}
