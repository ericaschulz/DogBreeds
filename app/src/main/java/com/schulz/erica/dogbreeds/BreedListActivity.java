package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class BreedListActivity extends AppCompatActivity implements BreedApiTaskCallBack, BreedImageApiTask.BreedImageApiTaskCallBack {


    BreedApiTask breedApiTask;
    RecyclerView breedRecyclerView;
    BreedRecyclerViewAdapter breedRecyclerViewAdapter;
    ConstraintLayout constraintLayout;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_breed_list);
        this.startBreedAsyncRequest();


        constraintLayout = findViewById(R.id.constraint_layout);
        linearLayout = findViewById(R.id.linear_layout);

        breedRecyclerView = findViewById(R.id.breed_recycler_view);
        breedRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


    }

    public void startBreedAsyncRequest() {

        this.breedApiTask = new BreedApiTask(this);
        this.breedApiTask.execute();

    }



    @Override
    public void breedApiTaskCompleted(List<Breed> breedList) {
// create another interface for breed selected listener & add to breedRecyclerViewAdapter constructor

        breedRecyclerView = findViewById(R.id.breed_recycler_view);
        breedRecyclerViewAdapter = new BreedRecyclerViewAdapter(this, breedList, new BreedRecyclerViewAdapter.BreedOnClickListener() {

            @Override
            public void onClick(Breed breed, Breed subBreed) {

                Intent intent = new Intent(BreedListActivity.this, BreedDetailActivity.class);

                intent.putExtra("breedName", breed.getBreedName());

                List<Breed.BreedImage> localBreedImages = breed.getBreedImages();
                List<String> imageLinks = new ArrayList<>();

                for (Breed.BreedImage breedImage: localBreedImages) {
                    String imageLink = breedImage.getImageLink();
                    imageLinks.add(imageLink);
                }
                String[] imageLinkArray = imageLinks.toArray(new String[0]);
                intent.putExtra("imageLinks", imageLinkArray);

                startActivity(intent);

            }
        });


        this.breedRecyclerView.setAdapter(breedRecyclerViewAdapter);


        for (Breed breed:breedList) {
            String breedName = breed.getBreedName();
            Log.d("log this", breedName);


            try {

                BreedImageApiTask breedImageApiTask = new BreedImageApiTask(breed, null,this);

                breedImageApiTask.execute();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        Log.d("log this", "");

    }

    @Override
    public void breedImageApiTaskCompleted(Breed breed, Breed subBreed) {
        //need to give the images to the adapter

        breedRecyclerViewAdapter.breedImagesReadyForBreed(breed);


        Log.d("log this", breed + " has images.");

    }

}
