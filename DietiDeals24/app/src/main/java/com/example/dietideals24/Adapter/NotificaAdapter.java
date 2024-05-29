package com.example.dietideals24.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dietideals24.Entities.Notifica;
import com.example.dietideals24.R;

import java.util.ArrayList;

public class NotificaAdapter extends RecyclerView.Adapter<NotificaAdapter.ViewHolder>{

    private final Context context;
    private ArrayList<Notifica> notifiche = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setNotifiche(ArrayList<Notifica> notifiche) {
        this.notifiche = notifiche;
        notifyDataSetChanged();
    }

    public NotificaAdapter(Context context) {
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

        holder.Txt.setText("Si aggiudica l'asta "+notifiche.get(position).getCompratore());

        holder.astaTxt.setText("Asta: "+notifiche.get(position).getAsta());

        holder.immagineView.setImageResource(R.drawable.notifiche);

    }

    @Override
    public int getItemCount() {
        return notifiche.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final CardView parent;

        private final TextView nomeTxt;
        private final TextView astaTxt;
        private final TextView Txt;

        private final ImageView immagineView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parent = itemView.findViewById(R.id.layoutNotifiche);

            immagineView = itemView.findViewById(R.id.immagineView);
            nomeTxt = itemView.findViewById(R.id.nomeTxt);
            Txt = itemView.findViewById(R.id.Txt);
            astaTxt = itemView.findViewById(R.id.astaTxt);

        }
    }
}
