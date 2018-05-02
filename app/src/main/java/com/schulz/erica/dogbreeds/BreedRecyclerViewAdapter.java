package com.schulz.erica.dogbreeds;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ericaschulz on 3/12/18.
 */

public class BreedRecyclerViewAdapter extends RecyclerView.Adapter<BreedRecyclerViewAdapter.CustomViewHolder>  {


    private Context context;
    private List<Breed> breedList;
    private Map<String, List<BreedImage>> breedImageListByBreedName;
    private BreedOnClickListener breedOnClickListener;


    public interface BreedOnClickListener {

        void onClick(Breed breed);

    }

    public BreedRecyclerViewAdapter(Context context, List<Breed> breedList, BreedOnClickListener breedOnClickListener) {

        this.context = context;
        this.breedList = breedList;
        this.breedImageListByBreedName = new HashMap<>();
        this.breedOnClickListener = breedOnClickListener;

        }

    public void injectBreedImages(Breed breed, List<BreedImage> breedImageList) {

        breedImageListByBreedName.put(breed.getBreedName(), breedImageList);
        int indexOfCurrentBreed = this.breedList.indexOf(breed);
        this.notifyItemChanged(indexOfCurrentBreed);


    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_photo, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final BreedRecyclerViewAdapter.CustomViewHolder holder, final int position) {


        Breed breed = breedList.get(position);
        holder.breed_name.setText(breed.getBreedName());
        holder.breed = breed;


        List<BreedImage> breedImageList = breedImageListByBreedName.get(breed.getBreedName());
        List<ImageView> imageViewList = Arrays.asList(holder.photo1, holder.photo2, holder.photo3);

        if (breedImageList != null && !breedImageList.isEmpty()) {
            for (int i = 0; i < 3 && i < breedImageList.size(); i++) {
                BreedImage breedImage = breedImageList.get(i);
                Uri imageUri = Uri.parse(breedImage.getImageLink());


                Picasso.with(context)
                        .load(imageUri)
                        .resize(300, 300)
                        .centerCrop()
                        .into(imageViewList.get(i));

            }
        }

    }

    public int getItemCount() {
        return (breedList != null ? breedList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {


        ImageView photo1;
        ImageView photo2;
        ImageView photo3;

        TextView breed_name;

        List<ImageView> imageViewList;

        Breed breed;


        CustomViewHolder(View itemView) {



            super(itemView);

            breed_name = itemView.findViewById(R.id.breed_name);
            photo1 = itemView.findViewById(R.id.photo1);
            photo2 = itemView.findViewById(R.id.photo2);
            photo3 = itemView.findViewById(R.id.photo3);

            imageViewList = Arrays.asList(this.photo1, this.photo2, this.photo3);






            itemView.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {


//                    breedOnClickListener.onClick(breed,breedImageListByBreedName.get(breed.getBreedName()));
//                   this is wrong! Combine breed & breedImage classes!

                    Log.d("breed detail activity", "clicked!");



                }
            });
        }




        }




}










