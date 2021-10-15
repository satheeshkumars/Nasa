package com.mrm.nasa;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.mrm.nasa.Adapter.NasaAdapter;
import com.mrm.nasa.Api.Controller;
import com.mrm.nasa.Api.NasaApi;
import com.mrm.nasa.Model.Model;
import com.mrm.nasa.Model.Photo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InfoActivity extends AppCompatActivity {
    Button addBtnInInfo;
    RecyclerView rv;

    private List<Photo> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        NasaApi api = Controller.getApi();

        addBtnInInfo = findViewById(R.id.addBtnInfo);

        rv = findViewById(R.id.rv_nasa);
        rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rv.setHasFixedSize(true);

        models = new ArrayList<>();

        NasaAdapter adapter = new NasaAdapter(models, this);
        rv.setAdapter(adapter);

        addBtnInInfo.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        });

        String date = getIntent().getStringExtra("date");

        api.getNasa(date).enqueue(new Callback<Model>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(@NonNull Call<Model> call, @NonNull Response<Model> response) {
                assert response.body() != null;
                // response.body().getPhotos() - have type data List<Photo>
                models.addAll(response.body().getPhotos());
                Objects.requireNonNull(rv.getAdapter()).notifyDataSetChanged();
                getToast("Yeah!!!!!!");
            }

            @Override
            public void onFailure(@NonNull Call<Model> call, @NonNull Throwable t) {
                getToast("Fuck!!!!!!");
            }
        });
    }

    private void getToast(String mess) {
        Toast.makeText(this, mess, Toast.LENGTH_LONG).show();
    }
}