package com.schulz.erica.dogbreeds;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by ericaschulz on 3/12/18.
 */

public class BreedRecyclerViewAdapter extends RecyclerView.Adapter<BreedRecyclerViewAdapter.CustomViewHolder> {

    private Context context;
    private List<BreedImage> breedImageList;

    public BreedRecyclerViewAdapter(Context context, List<BreedImage> breedImageList) {

        this.context = context;
        this.breedImageList = breedImageList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_photo, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(BreedRecyclerViewAdapter.CustomViewHolder holder, int position) {

        BreedImage breedImage = breedImageList.get(position);

        Picasso.with(context)
                .load(breedImage.getBreedName())
                .into(holder.photo1);

        holder.breed_name.setText(breedImage.getBreedName());



    }

    public int getItemCount() {
        return (breedImageList!=null ? breedImageList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView photo1;
        ImageView photo2;
        ImageView photo3;

        TextView breed_name;
        CardView card_view;

        CustomViewHolder(View itemView) {

            super(itemView);

            breed_name = itemView.findViewById(R.id.breed_name);
            card_view = itemView.findViewById(R.id.card_view);
            photo1 = itemView.findViewById(R.id.photo1);
            photo2 = itemView.findViewById(R.id.photo2);
            photo3 = itemView.findViewById(R.id.photo3);



        }

    }
}
