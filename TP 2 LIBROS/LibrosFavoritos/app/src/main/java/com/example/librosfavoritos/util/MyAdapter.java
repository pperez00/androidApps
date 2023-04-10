package com.example.librosfavoritos.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.librosfavoritos.R;
import com.example.librosfavoritos.base.Libro;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener {
    private ArrayList<Libro> libros;
    private View.OnClickListener listener;


    public MyAdapter(ArrayList<Libro> libros){
        this.libros = libros;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View contentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        contentView.setOnClickListener(this);
        return new MyViewHolder(contentView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ivFoto.setImageResource(libros.get(position).getImagenUri());
        holder.tvTitulo.setText(libros.get(position).getTitulo());
        holder.tvAutor.setText(libros.get(position).getAutor());

        if(libros.get(position).getFavorito().equals("SI")){
              holder.ivEstrella.setImageResource(R.drawable.estrella);
        }else {
            holder.ivEstrella.setImageResource(R.drawable.estrellavacia);
        }
    }

    @Override
    public int getItemCount() {
        return libros.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitulo, tvAutor;
        public ImageView ivFoto, ivEstrella;

        public MyViewHolder(View view){
            super(view);
            ivFoto = view.findViewById(R.id.iv_item_libro);
            tvTitulo = view.findViewById(R.id.detTitulo);
            tvAutor = view.findViewById(R.id.detAutor);
            ivEstrella = view.findViewById(R.id.iv_item_fav);
        }
    }
}
