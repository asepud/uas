package com.asepudin.uas_android.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.asepudin.uas_android.R;
import com.asepudin.uas_android.adapter.bukuAdapter;
import com.asepudin.uas_android.api.api;
import com.asepudin.uas_android.api.retrofitClient;
import com.asepudin.uas_android.model.buku_m;
import com.asepudin.uas_android.model.responseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView = null;
    private List<buku_m> list= null;
    private bukuAdapter adapter = null;
    private buku_m buku = null;
    private com.asepudin.uas_android.api.api api;
    private boolean isNew = false;
    private int position = -1;
    private final MainActivity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        api = retrofitClient.getInstance().getApi();
        loadData();
    }

    private void loadData() {
        api.getlist().enqueue(new Callback<responseModel>() {
            @Override
            public void onResponse(Call<responseModel> call, Response<responseModel> response) {
                list = response.body().getData();
                adapter =  new bukuAdapter(activity, list, activity);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<responseModel> call, Throwable t) {
                list = new ArrayList<>();
                adapter =  new bukuAdapter(activity, list, activity);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}