package com.coursera.petagramfinish;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFavoritePet extends RecyclerView.Adapter<AdapterFavoritePet.ViewHolderFavoritePet> {

    private ArrayList<Pet> petList;
    private Activity activity;

    public AdapterFavoritePet(ArrayList<Pet> petList, Activity activity) {
        this.petList = petList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolderFavoritePet onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_pet_card_view, parent, false);
        return new ViewHolderFavoritePet(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFavoritePet holder, int position) {
        Pet pet = petList.get(position);
        holder.ivPhoto.setImageResource(pet.getPhoto());
        holder.ivName.setText(pet.getName());
        holder.ivStar.setImageResource(pet.getIconStar());
        holder.tvRate.setText(pet.getRate());
    }

    @Override
    public int getItemCount() {
        return this.petList.size();
    }

    public class ViewHolderFavoritePet extends RecyclerView.ViewHolder {

        private ImageView ivPhoto;
        private TextView ivName;
        private ImageView ivStar;
        private TextView tvRate;

        public ViewHolderFavoritePet(@NonNull View itemView) {
            super(itemView);
            this.ivPhoto = itemView.findViewById(R.id.img_photo_fav);
            this.ivName = itemView.findViewById(R.id.tv_name_fav);
            this.ivStar = itemView.findViewById(R.id.img_star);
            this.tvRate = itemView.findViewById(R.id.tv_rate_fav);
        }
    }
}