package com.coursera.petagramfinish;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterPet extends RecyclerView.Adapter<AdapterPet.ViewHolderPet> {

    private ArrayList<Pet> petList;
    private Activity activity;
    private String valueRate;
    private int increment;
    private boolean like;

    public AdapterPet(ArrayList<Pet> petList, Activity activity) {
        this.petList = petList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolderPet onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_pet_card_view, parent, false);
        return new ViewHolderPet(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderPet holder, int position) {
        final Pet pet = petList.get(position);
        holder.ivPhoto.setImageResource(pet.getPhoto());
        holder.ivWhiteBone.setImageResource(pet.getImgWhiteBone());
        holder.ivYellowBone.setImageResource(pet.getImgYellowBone());
        holder.tvName.setText(pet.getName());
        holder.tvRate.setText(pet.getRate());

        //Listener button like
        holder.ivWhiteBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get values from tvRate
                valueRate = holder.tvRate.getText().toString();
                increment = Integer.parseInt(valueRate);
                like = pet.isLike();

                //Validate like button
                if(!like) {
                    holder.tvRate.setText(String.format("%02d", increment + 1));
                    Toast.makeText(activity.getApplicationContext(), R.string.add_favorite, Toast.LENGTH_SHORT).show();
                } else {
                    holder.tvRate.setText(String.format("%02d", increment - 1));
                    Toast.makeText(activity.getApplicationContext(), R.string.remove_favorite, Toast.LENGTH_SHORT).show();
                }
                like = !like;
                pet.setLike(like);
                //Change image
                holder.ivWhiteBone.setImageResource(pet.changeImage());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.petList.size();
    }

    public class ViewHolderPet extends RecyclerView.ViewHolder {

        private ImageView ivPhoto;
        private ImageView ivWhiteBone;
        private TextView tvName;
        private TextView tvRate;
        private ImageView ivYellowBone;

        public ViewHolderPet(@NonNull View itemView) {
            super(itemView);
            this.ivPhoto = itemView.findViewById(R.id.img_photo);
            this.ivWhiteBone = itemView.findViewById(R.id.img_white_bone);
            this.tvName = itemView.findViewById(R.id.tv_name);
            this.tvRate = itemView.findViewById(R.id.tv_rate);
            this.ivYellowBone = itemView.findViewById(R.id.img_yellow_bone);
        }
    }
}