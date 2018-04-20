package com.schulz.erica.dogbreeds;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreedDetailRecyclerViewAdapter extends RecyclerView.Adapter<BreedDetailRecyclerViewAdapter.CustomViewHolder> {

    //May not need all of these fields
    Context context;
    List<Breed> breedList;
    List<BreedImage> breedDetailImageList;
    Map<String, List<BreedImage>> breedDetailImageListByBreedName;

    public BreedDetailRecyclerViewAdapter(Context context, List<Breed> breedList, List<BreedImage> breedDetailImageList) {

        this.context = context;
        this.breedList = breedList;
        this.breedDetailImageList = breedDetailImageList;
        this.breedDetailImageListByBreedName = new HashMap<>();


    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_photo_detail, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BreedDetailRecyclerViewAdapter.CustomViewHolder holder, final int position) {


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
