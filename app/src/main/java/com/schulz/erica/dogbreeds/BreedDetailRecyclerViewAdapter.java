package com.schulz.erica.dogbreeds;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;


public class BreedDetailRecyclerViewAdapter extends RecyclerView.Adapter<BreedDetailRecyclerViewAdapter.CustomViewHolder> {


    private Context context;
    private Breed breed;


    public BreedDetailRecyclerViewAdapter(Context context, Breed breed) {

        this.context = context;
        this.breed = breed;
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_photo_detail, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BreedDetailRecyclerViewAdapter.CustomViewHolder holder, final int position) {


        this.breed.getBreedImages().get(position);

        List<ImageView> imageViewList = Arrays.asList(holder.photo_detail_1, holder.photo_detail_2, holder.photo_detail_3);


        if (breed.getBreedImages() != null && !breed.getBreedImages().isEmpty()) {

            for (int i = 0; i < 3 && i < breed.getBreedImages().size(); i++) {

                int imageIndex = (position * imageViewList.size() + i);

                Uri imageUri = Uri.parse(breed.getBreedImages().get(imageIndex).getImageLink());

                Picasso.with(context)
                        .load(imageUri)
                        .resize(300, 300)
                        .centerCrop()
                        .into(imageViewList.get(i));



            }
        }
    }

        public int getItemCount() {

            View view = LayoutInflater.from(this.context).inflate(R.layout.fragment_photo_detail, null);
            CustomViewHolder viewHolder = new CustomViewHolder(view);

            return (breed.getBreedImages() != null ? breed.getBreedImages().size()/viewHolder.imageViewList.size() : 0);

        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView photo_detail_1;
        ImageView photo_detail_2;
        ImageView photo_detail_3;

        List<ImageView> imageViewList;


            CustomViewHolder(View itemDetailView) {


                super(itemDetailView);


            photo_detail_1 = itemDetailView.findViewById(R.id.photo_detail_1);

            photo_detail_2 = itemDetailView.findViewById(R.id.photo_detail_2);

            photo_detail_3 = itemDetailView.findViewById(R.id.photo_detail_3);


            imageViewList = Arrays.asList(photo_detail_1, photo_detail_2,photo_detail_3);










            }
        }
    }

