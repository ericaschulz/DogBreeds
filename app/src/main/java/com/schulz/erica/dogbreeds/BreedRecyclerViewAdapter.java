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
import java.util.List;

import timber.log.Timber;

/**
 * Created by ericaschulz on 3/12/18.
 */

public class BreedRecyclerViewAdapter extends RecyclerView.Adapter<BreedRecyclerViewAdapter.CustomViewHolder>  {


    private Context context;
    private List<Breed> breedList;
    private BreedOnClickListener breedOnClickListener;



    public interface BreedOnClickListener {

        void onClick(Breed parentBreed, Breed subBreed);

    }

    public BreedRecyclerViewAdapter(Context context, List<Breed> breedList, BreedOnClickListener breedOnClickListener) {

        this.context = context;
        this.breedList = breedList;
        this.breedOnClickListener = breedOnClickListener;

        }

    public void breedImagesReadyForBreed(Breed currentBreed) {


        int indexOfCurrentBreed = this.breedList.indexOf(currentBreed);
        this.notifyItemChanged(indexOfCurrentBreed);

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_photo, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {


        Breed parentBreed = breedList.get(position);
        holder.breed_name.setText(parentBreed.getBreedName());
        holder.parentBreed = parentBreed;


        List<Breed.BreedImage> breedImages = parentBreed.getBreedImages();
        List<ImageView> imageViewList = Arrays.asList(holder.photo1, holder.photo2, holder.photo3);

        if (breedImages != null && !breedImages.isEmpty()) {
            for (int i = 0; i < 3 && i < breedImages.size(); i++) {
                Breed.BreedImage breedImage = breedImages.get(i);
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
        TextView details;

        List<ImageView> imageViewList;

        Breed parentBreed;
        Breed subBreed;


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


                    breedOnClickListener.onClick(parentBreed, subBreed);


                    Timber.tag("breed detail activity").d("clicked!");



                }
            });
        }




        }




}










