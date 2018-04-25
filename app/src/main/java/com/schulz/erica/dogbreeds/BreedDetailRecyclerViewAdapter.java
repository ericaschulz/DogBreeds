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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreedDetailRecyclerViewAdapter extends RecyclerView.Adapter<BreedDetailRecyclerViewAdapter.CustomViewHolder> {

    //May not need all of these fields
    private Context context;
    private List<Breed> breedList;
    private List<BreedImage> breedDetailImageList;
    private Map<String, List<BreedImage>> breedDetailImageListByBreedName;


    public BreedDetailRecyclerViewAdapter(Context context, List<Breed> breedList, List<BreedImage> breedDetailImageList) {

        this.context = context;
        this.breedList = breedList;
        this.breedDetailImageList = breedDetailImageList;
        this.breedDetailImageListByBreedName = new HashMap<>();


    }

    public void injectBreedDetailImages(Breed breed, List<BreedImage> breedImageList) {

        breedDetailImageListByBreedName.put(breed.getBreedName(), breedImageList);
        int indexOfCurrentBreed = this.breedList.indexOf(breed);
        this.notifyItemChanged(indexOfCurrentBreed);


    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_photo_detail, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BreedDetailRecyclerViewAdapter.CustomViewHolder holder, final int position) {

        Breed breed = breedList.get(position);
        holder.breed_name.setText(breed.getBreedName());
        List<BreedImage> breedDetailImageList = breedDetailImageListByBreedName.get(breed.getBreedName());
        List<ImageView> imageViewDetailList = Arrays.asList(holder.photo_detail_1, holder.photo_detail_2, holder.photo_detail_3);


        if (breedDetailImageList != null && !breedDetailImageList.isEmpty()) {
            for (int i = 0; i < 3 && i < breedDetailImageList.size(); i++) {
                BreedImage breedImage = breedDetailImageList.get(i);
                Uri imageDetailUri = Uri.parse(breedImage.getImageLink());


                Picasso.with(context)
                        .load(imageDetailUri)
                        .resize(300, 300)
                        .centerCrop()
                        .into(imageViewDetailList.get(i));


            }
        }
    }


    public int getItemCount() {
        return (breedList != null ? breedList.size() : 0);
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {


        ImageView photo_detail_1;
        ImageView photo_detail_2;
        ImageView photo_detail_3;

        TextView breed_name;
        List<ImageView> imageViewDetailList;




        CustomViewHolder(View itemDetailView) {


            super(itemDetailView);

            breed_name = itemDetailView.findViewById(R.id.breed_name);
            photo_detail_1 = itemDetailView.findViewById(R.id.photo_detail_1);
            photo_detail_2 = itemDetailView.findViewById(R.id.photo_detail_2);
            photo_detail_3 = itemDetailView.findViewById(R.id.photo_detail_3);

            imageViewDetailList = Arrays.asList(this.photo_detail_1, this.photo_detail_2, this.photo_detail_3);


        }
    }
}