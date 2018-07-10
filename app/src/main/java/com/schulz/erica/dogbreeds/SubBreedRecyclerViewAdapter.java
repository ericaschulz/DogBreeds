package com.schulz.erica.dogbreeds;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class SubBreedRecyclerViewAdapter extends RecyclerView.Adapter<SubBreedRecyclerViewAdapter.CustomViewHolder> {


    private Context context;
    private List<Breed> subBreeds;


    @Override
    public SubBreedRecyclerViewAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_sub_breed, null);
        SubBreedRecyclerViewAdapter.CustomViewHolder viewHolder = new SubBreedRecyclerViewAdapter.CustomViewHolder(view);

        return viewHolder;
    }

    public void onBindViewHolder(final CustomViewHolder holder, final int position) {

//        Breed subBreeds = Breed.subBreeds.get(position);
//
//        holder.subBreed_name.setText(Breed.getSubBreeds());
    }

    public int getItemCount() {
        return (subBreeds != null ? subBreeds.size() : 0);
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {


        ImageView photo1sub;
        ImageView photo2sub;
        ImageView photo3sub;

        TextView subBreed_name;
        TextView details;

        List<ImageView> imageViewList;

        Breed subBreed;



        CustomViewHolder(View itemView) {


            super(itemView);

            subBreed_name = itemView.findViewById(R.id.sub_breed_name);
            photo1sub = itemView.findViewById(R.id.photo1sub);
            photo2sub = itemView.findViewById(R.id.photo2sub);
            photo3sub = itemView.findViewById(R.id.photo3sub);

            imageViewList = Arrays.asList(this.photo1sub, this.photo2sub, this.photo3sub);


        }





    }
}
