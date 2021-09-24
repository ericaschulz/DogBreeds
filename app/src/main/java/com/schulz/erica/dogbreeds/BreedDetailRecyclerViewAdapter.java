package com.schulz.erica.dogbreeds;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;


public class BreedDetailRecyclerViewAdapter extends RecyclerView.Adapter<BreedDetailRecyclerViewAdapter.CustomViewHolder> {

    private Context context;
    private Breed breed;
    private SingleImageOnClickListener singleImageOnClickListener;

    public interface SingleImageOnClickListener {

        void onClick(View view, int position);

    }

    public BreedDetailRecyclerViewAdapter(Context context, Breed breed, SingleImageOnClickListener singleImageOnClickListener) {

        this.context = context;
        this.breed = breed;
        this.singleImageOnClickListener = singleImageOnClickListener;

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_photo_detail, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BreedDetailRecyclerViewAdapter.CustomViewHolder holder, final int position) {

        Breed.BreedImage breedImage = this.breed.getBreedImages().get(position);
        ImageView photoDetail1 = holder.photo_detail_1;
        Uri imageUri = Uri.parse(breedImage.imageLink);


        Picasso.with(context)
                .load(imageUri)
                .resize(450, 400)
                .centerCrop()
                .into(photoDetail1);

            }


        public int getItemCount() {

            int itemCount = breed.getBreedImages() != null ? (breed.getBreedImages().size()): 0;

            return (itemCount);

        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {


        ImageView photo_detail_1;


            CustomViewHolder(final View itemDetailView) {


                super(itemDetailView);


            photo_detail_1 = itemDetailView.findViewById(R.id.photo_detail_1);



                itemDetailView.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {

                        singleImageOnClickListener.onClick(view, getLayoutPosition());

                    }
                });



            }
        }
    }

