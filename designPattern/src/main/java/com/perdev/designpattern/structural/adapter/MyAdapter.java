package com.perdev.designpattern.structural.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Project    demos-git
 * Path       com.perdev.designpattern.structural.adapter
 * Date       2021/06/15 - 16:39
 * Author     Payne.
 * About      类描述：
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyVH> {

    List<String> data;

    public MyAdapter(List<String> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public MyVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView tv = new TextView(parent.getContext());
        return new MyVH(tv);
    }

    @Override
    public void onBindViewHolder(@NonNull MyVH holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyVH extends RecyclerView.ViewHolder {
        TextView textView;

        public MyVH(@NonNull View itemView) {
            super(itemView);
            if (itemView instanceof TextView) {
                textView = (TextView) itemView;
            }
        }
    }
}