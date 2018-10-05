package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

public class BreedListActivity extends AppCompatActivity implements BreedListCallBack, BreedImageApiTaskCallBack {


    BreedApiTask breedApiTask;
    String[] imageLinks;
    String imageLink;
    Breed subBreed;
    Breed parentBreed;
    String breedName;
    RecyclerView breedRecyclerView;
    BreedRecyclerViewAdapter breedRecyclerViewAdapter;
    TextView subBreedsText;
    ConstraintLayout constraintLayout;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_breed_list);


        constraintLayout = findViewById(R.id.constraint_layout);
        linearLayout = findViewById(R.id.linear_layout);
        subBreedsText = findViewById(R.id.sub_breeds_text);

        breedRecyclerView = findViewById(R.id.breed_recycler_view);
        breedRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.getString("breedName") != null) {
            breedName = bundle.getString("breedName");
            parentBreed = new Breed();
            parentBreed.setBreedName(breedName);

            if (bundle.getStringArray("imageLinks") != null)

            {
                imageLinks = bundle.getStringArray("imageLinks");
            }


        }

        this.startBreedAsyncRequest();

    }


    public void startBreedAsyncRequest() {


        if (this.parentBreed != null) {

            this.breedApiTask = new BreedApiTask(this.parentBreed.getBreedName(), this);

        } else {

            this.breedApiTask = new BreedApiTask(this);
        }
        this.breedApiTask.execute();

    }


    @Override
    public void breedListAvailable(List<Breed> breedList) {


        Log.d("yo", "here");

        subBreedsText.setText("The " + parentBreed + " breed includes " + breedList.size() + " subbreed(s).");

        breedRecyclerView = findViewById(R.id.breed_recycler_view);
        breedRecyclerViewAdapter = new BreedRecyclerViewAdapter(this, breedList, new BreedRecyclerViewAdapter.BreedOnClickListener() {


            //OnClick with Intent to display BreedDetailActivity
            @Override
            public void onClick(Breed breed, Breed subBreed) {

                Intent intent = new Intent(BreedListActivity.this, BreedDetailActivity.class);

                intent.putExtra("breedName", breed.getBreedName());

                List<Breed.BreedImage> localBreedImages = breed.getBreedImages();
                List<String> imageLinks = new ArrayList<>();

                for (Breed.BreedImage breedImage : localBreedImages) {
                    String imageLink = breedImage.getImageLink();
                    imageLinks.add(imageLink);
                }
                String[] imageLinkArray = imageLinks.toArray(new String[0]);
                intent.putExtra("imageLinks", imageLinkArray);

                startActivity(intent);

            }
        });


        this.breedRecyclerView.setAdapter(breedRecyclerViewAdapter);


//this iterates over the main breedList and returns those images

        for (Breed currentBreed : breedList) {
            String breedName = currentBreed.getBreedName();
            Timber.tag("log this").d(breedName);


            try {

                if (this.parentBreed != null) {

                    BreedImageApiTask subBreedImageApiTask = new BreedImageApiTask(this.parentBreed, currentBreed, this);

                    subBreedImageApiTask.execute();


                } else {

                    BreedImageApiTask breedImageApiTask = new BreedImageApiTask(currentBreed, null, this);

                    breedImageApiTask.execute();

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }




    @Override
    public void breedImageApiTaskCompleted(Breed breed) {
        //need to give the images to the adapter



            breedRecyclerViewAdapter.breedImagesReadyForBreed(breed);


            Timber.tag("log this").d(parentBreed + " has images.");
        }
    }





