package com.example.dietideals24.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietideals24.Entities.AstaInglese;
import com.example.dietideals24.R;

import java.util.ArrayList;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.ViewHolder>{

    private final Context context;
    private ArrayList<AstaInglese> aste = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setLista(ArrayList<AstaInglese> aste) {
        this.aste = aste;
        notifyDataSetChanged();
    }

    public ListaAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notifiche_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nome.setText(aste.get(position).getNome());

        //holder.immagineView.setImageResource(Integer.parseInt(aste.get(position).getFoto()));


    }

    @Override
    public int getItemCount() {
        return aste.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final CardView parent;

        private final ImageView immagineView;

        private final TextView nome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.layoutNotifiche);

            immagineView = itemView.findViewById(R.id.immagineView);
            nome = itemView.findViewById(R.id.nomeTxt);


        }
    }
}
