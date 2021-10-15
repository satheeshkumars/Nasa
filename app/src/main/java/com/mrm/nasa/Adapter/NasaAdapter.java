package com.mrm.nasa.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrm.nasa.Model.Model;
import com.mrm.nasa.Model.Photo;
import com.mrm.nasa.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NasaAdapter extends RecyclerView.Adapter<NasaAdapter.NasaViewHolder>{
    private final List<Photo> models;
    private final Context context;

    public NasaAdapter(List<Photo> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @NonNull
    @Override
    public NasaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NasaAdapter.NasaViewHolder(LayoutInflater.from(context).inflate(R.layout.photos_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NasaViewHolder holder, int position) {

        Picasso.with(context).load(models.get(position).getImgSrc()).into(holder.photo);

        holder.dateField.setText(models.get(position).getEarthDate());

    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public static class NasaViewHolder extends RecyclerView.ViewHolder {
        ImageView photo;
        TextView dateField;

        public NasaViewHolder(@NonNull View itemView) {
            super(itemView);

            photo = itemView.findViewById(R.id.photo);
            dateField = itemView.findViewById(R.id.dateField);
        }
    }
}