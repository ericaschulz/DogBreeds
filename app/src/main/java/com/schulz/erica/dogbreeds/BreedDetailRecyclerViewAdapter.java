package com.schulz.erica.dogbreeds;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BreedDetailRecyclerViewAdapter extends RecyclerView.Adapter<BreedDetailRecyclerViewAdapter.CustomViewHolder> {

    //May not need all of these fields
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


//        breed.get(position);
//
//
//
//            for (int i = 0; i < 2 && i < BreedImages.size(); i++) {
//                Breed.BreedImage breedImage = breedImages.get(0);
//                Uri imageUri = Uri.parse(breedImage.getImageLink());

//                holder.photo_detail_1.setImageURI(imageUri);

//                Picasso.with(context)
//                        .load(imageUri)
//                        .resize(300, 300)
//                        .centerCrop()
//                        .into(photo_detail_1);


            }


    public int getItemCount() {
        return breed.getBreedImages().size();

    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

//        ImageView photo_detail_1;
//        ImageView photo_detail_2;
//        ImageView photo_detail_3;



//        List<ImageView> imageLinksView;


        CustomViewHolder(View itemDetailView) {


            super(itemDetailView);


//            photo_detail_1 = itemDetailView.findViewById(R.id.photo_detail_1);
//            photo_detail_2 = itemDetailView.findViewById(R.id.photo_detail_2);
//            photo_detail_3 = itemDetailView.findViewById(R.id.photo_detail_3);

//            imageLinksView = Arrays.asList(this.photo_detail_1);


        }
    }
}
