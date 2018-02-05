package com.schulz.erica.dogbreeds;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ericaschulz on 2/4/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.BreedViewHolder> {

    private Context context;
    private List<Breed> breedList;



    public RecyclerViewAdapter(Context context, List<Breed> breedList) {
        this.context = context;
        this.breedList = breedList;
    }


    @Override
    public BreedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_card, null);
        BreedViewHolder breedViewHolder = new BreedViewHolder(view);

        return breedViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.BreedViewHolder holder, int position) {

        Breed breed = breedList.get(position);
    }

//        Picasso.with(context)
//                .load(breed.getImage())
//                .into(holder.fullImage);
//
//        holder.nameTextView.setText(breed.getTitle());
//
//        Picasso.with(context)
//                .load(breed.getNameImage())
//                .into(holder.profileImage);
//
//        holder.profileName.setText(breed.getName());


    @Override
    public int getItemCount() {
        return (breedList!=null ? breedList.size() : 0);
    }

    class BreedViewHolder extends RecyclerView.ViewHolder {

        ImageView breedImage1;
        ImageView breedImage2;
        ImageView breedImage3;
        TextView breedTextView;
        CardView cardView;

        public BreedViewHolder(View itemView) {

            super(itemView);

            breedImage1 = itemView.findViewById(R.id.photo1);
            breedImage2 = itemView.findViewById(R.id.photo2);
            breedImage3 = itemView.findViewById(R.id.photo3);
            breedTextView = itemView.findViewById(R.id.breed_name);
            cardView = itemView.findViewById(R.id.card_view);

        }
        }


}



