package com.perdev.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    demos-git
 * Path       com.perdev.recyclerview
 * Date       2019/11/29 - 18:10
 * Author     Payne.
 * About      类描述：
 */
public class MainDataAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<DataBean> mData;

    public MainDataAdapter2(Context context, List<DataBean> data) {
        mContext = context.getApplicationContext();
        mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main_data, viewGroup, false);

        return new MyVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof MyVH) {
            ((MyVH) viewHolder).setTitle(mData.get(i).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyVH extends RecyclerView.ViewHolder {
        private TextView titleTV;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.tv_imd_title);
        }

        public void setTitle(String title) {
            titleTV.setText(title);
        }
    }
}
