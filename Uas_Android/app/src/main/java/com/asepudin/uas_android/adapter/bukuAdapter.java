package com.asepudin.uas_android.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asepudin.uas_android.R;
import com.asepudin.uas_android.activity.MainActivity;
import com.asepudin.uas_android.model.buku_m;

import java.util.ArrayList;
import java.util.List;

public class bukuAdapter extends RecyclerView.Adapter<bukuAdapter.bukuviewHolder>{
    private Context context;
    private List<buku_m> list = new ArrayList<>();
    private View.OnClickListener listener;

    public bukuAdapter(Context context, List<buku_m> list, MainActivity listener) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public bukuviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false);
        view.setOnClickListener(listener);
        bukuviewHolder holder = new bukuviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull bukuviewHolder holder, int position) {
        buku_m buku = list.get(position);
        holder.tv_judul.setText(buku.getJudul());
        holder.tv_penulis.setText(buku.getPenulis());
        holder.tv_jenis.setText(buku.getJenis());
        holder.tv_tahun.setText(buku.getTahun());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class bukuviewHolder extends RecyclerView.ViewHolder{
        LinearLayout viewInitial = null;
        TextView tv_judul, tv_penulis, tv_jenis, tv_tahun;
        View viewStatus = null;

        public bukuviewHolder(@NonNull View view) {
            super(view);
            tv_judul = view.findViewById(R.id.tv_judul);
            tv_penulis = view.findViewById(R.id.tv_penulis);
            tv_tahun = view.findViewById(R.id.tv_tahun);
            tv_jenis = view.findViewById(R.id.tv_jenis);
        }
    }
}
