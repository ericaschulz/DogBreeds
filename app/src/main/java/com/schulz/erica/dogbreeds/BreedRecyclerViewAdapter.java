package com.schulz.erica.dogbreeds;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ericaschulz on 3/12/18.
 */

public class BreedRecyclerViewAdapter extends RecyclerView.Adapter<BreedRecyclerViewAdapter.CustomViewHolder> {

    private Context context;
    private List<Breed> breedList;
    public Map<String, List<BreedImage>> breedImageListByBreedName;


    public BreedRecyclerViewAdapter(Context context, List<Breed> breedList) {

        this.context = context;
        this.breedList = breedList;
        this.breedImageListByBreedName = new HashMap<>();
    }

    public void injectBreedImages (String breedName, List<BreedImage> breedImageList){
        
        breedImageListByBreedName.put(breedName,breedImageList);
        
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_photo, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }
    @Override
    public void onBindViewHolder(BreedRecyclerViewAdapter.CustomViewHolder holder, int position) {



        Breed breed = breedList.get(position);

        holder.breed_name.setText(breed.getBreedName());

        List<BreedImage> breedImageList = breedImageListByBreedName.get(breed.getBreedName());
        List<ImageView> imageViewList = null;



        if (breedImageList != null && !breedImageList.isEmpty()) {
            for (int i = 0; i < 3 && i < breedImageList.size(); i++) {
                BreedImage breedImage = breedImageList.get(i);
                Uri imageUri = Uri.parse(breedImage.getImageLink());


                if (imageViewList != null && !imageViewList.isEmpty()) {

                for (int j = 0; j < 3 && j < imageViewList.size(); j++) {

                }

                Picasso.with(context)
                        .load(imageUri)
                        .resize(300, 300)
                        .centerCrop()
                        .into(holder.photo1);


            }
        }

    }
    }


    public int getItemCount() {
        return (breedList !=null ? breedList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView photo1;
        ImageView photo2;
        ImageView photo3;



        TextView breed_name;


        CustomViewHolder(View itemView) {

            super(itemView);

            breed_name = itemView.findViewById(R.id.breed_name);
            photo1 = itemView.findViewById(R.id.photo1);
            photo2 = itemView.findViewById(R.id.photo2);
            photo3 = itemView.findViewById(R.id.photo3);






        }

    }
}
