package com.example.mvp2.Dev5.reyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvp2.Dev5.Fragment.ViewData;
import com.example.mvp2.R;

import java.util.ArrayList;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHodler> {

    private  ArrayList<ViewData> mlist ;


    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        // return new ItemViewHolder(view,viewType);
        // todo
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_row,parent,false);
        ViewHodler holder = new ViewHodler(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler holder, int position) {

         holder.nametxt.setText(mlist.get(position).getName());
         holder.agetxt.setText(String.valueOf(mlist.get(position).getAge()));

         holder.itemView.setTag(position);
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 // position을 가져올때 이걸 사용한다.
                 //holder.getAdapterPosition();
                 Log.e("holder 는?"," "+ holder.getAdapterPosition());
                 String name = mlist.get(holder.getAdapterPosition()).getName ();
                 Toast.makeText(view.getContext(),"아이템 선택 " + name, Toast.LENGTH_SHORT).show();

                 return ;
             }
         });
    }

    public ViewAdapter(ArrayList<ViewData> arrayList) {
        this.mlist = arrayList;
    }

    public class ViewHodler extends RecyclerView.ViewHolder{
        public TextView nametxt;
        public TextView agetxt;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            nametxt = (TextView) itemView.findViewById(R.id.nametxt);
            agetxt = (TextView) itemView.findViewById(R.id.agetxt);
        }
    }


    @Override
    public int getItemCount() {
        return (null != mlist? mlist.size() : 0);
    }


}
