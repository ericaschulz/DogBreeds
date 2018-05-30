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

        List<ImageView> imageLinksView1 = Arrays.asList(holder.photo_detail_1, holder.photo_detail_2, holder.photo_detail_3);
        List<ImageView> imageLinksView2 = Arrays.asList(holder.photo_detail_4, holder.photo_detail_5, holder.photo_detail_6);
        List<ImageView> imageLinksView3 = Arrays.asList(holder.photo_detail_7, holder.photo_detail_8, holder.photo_detail_9);


        if (breed.getBreedImages() != null && !breed.getBreedImages().isEmpty()) {

            for (int i = 0; i < 3 && i < breed.getBreedImages().size(); i++) {


                Uri imageUri = Uri.parse(breed.getBreedImages().get(i).getImageLink());

                Picasso.with(context)
                        .load(imageUri)
                        .resize(85, 85)
                        .centerCrop()
                        .into(imageLinksView1.get(i));


                for (int ij = 0; ij < 3 && ij < breed.getBreedImages().size(); ij++) {


                    Uri imageUri2 = Uri.parse(breed.getBreedImages().get(ij).getImageLink());

                    Picasso.with(context)
                            .load(imageUri2)
                            .resize(85, 85)
                            .centerCrop()
                            .into(imageLinksView2.get(ij));

                    for (int ik = 0; ik < 3 && ik < breed.getBreedImages().size(); ik++) {


                        Uri imageUri3 = Uri.parse(breed.getBreedImages().get(ik).getImageLink());

                        Picasso.with(context)
                                .load(imageUri3)
                                .resize(85, 85)
                                .centerCrop()
                                .into(imageLinksView3.get(ik));


                    }

                }
            }
        }
    }

        public int getItemCount() {


            return (breed.getBreedImages() != null ? breed.getBreedImages().size() : 0);

        }


        class CustomViewHolder extends RecyclerView.ViewHolder {

        ImageView photo_detail_1;
        ImageView photo_detail_2;
        ImageView photo_detail_3;
        ImageView photo_detail_4;
        ImageView photo_detail_5;
        ImageView photo_detail_6;
        ImageView photo_detail_7;
        ImageView photo_detail_8;
        ImageView photo_detail_9;




        List<ImageView> imageLinksView1;

        List<ImageView> imageLinksView2;

        List<ImageView> imageLinksView3;





            CustomViewHolder(View itemDetailView) {


                super(itemDetailView);


            photo_detail_1 = itemDetailView.findViewById(R.id.photo_detail_1);

            photo_detail_2 = itemDetailView.findViewById(R.id.photo_detail_2);

            photo_detail_3 = itemDetailView.findViewById(R.id.photo_detail_3);

            photo_detail_4 = itemDetailView.findViewById(R.id.photo_detail_4);

            photo_detail_5 = itemDetailView.findViewById(R.id.photo_detail_5);

            photo_detail_6 = itemDetailView.findViewById(R.id.photo_detail_6);

            photo_detail_7 = itemDetailView.findViewById(R.id.photo_detail_7);

            photo_detail_8 = itemDetailView.findViewById(R.id.photo_detail_8);

            photo_detail_9 = itemDetailView.findViewById(R.id.photo_detail_9);





            imageLinksView1 = Arrays.asList(photo_detail_1, photo_detail_2,photo_detail_3);

            imageLinksView2 = Arrays.asList(photo_detail_4, photo_detail_5, photo_detail_6);

            imageLinksView3 = Arrays.asList(photo_detail_7, photo_detail_8, photo_detail_9);








            }
        }
    }

