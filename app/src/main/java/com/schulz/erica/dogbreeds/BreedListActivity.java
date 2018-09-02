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

public class BreedListActivity extends AppCompatActivity implements BreedApiTaskCallBack, BreedImageApiTaskCallBack {


    BreedApiTask breedApiTask;
    BreedApiTask subBreedApiTask;
    Breed breed;
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



        this.startBreedAsyncRequest();

    }


    public void startBreedAsyncRequest() {


        if (this.breedName != null) {

            this.breedApiTask = new BreedApiTask(breedName, this);

        } else {

            this.breedApiTask = new BreedApiTask(this);
        }
        this.breedApiTask.execute();

    }

    //where to put th bundle info!!!




    @Override
    public void breedApiTaskCompleted(List<Breed> breedList) {

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        if (bundle.getString("breedName") != null)

        {
            breedName = bundle.getString("breedName");
            breed = new Breed();
            breed.setBreedName(breedName);



            Log.d("yo", "here");

            subBreedsText.setText("The " + breed + " breed includes " + breedList.size() + " subbreed(s).");

            breedRecyclerView = findViewById(R.id.breed_recycler_view);
            breedRecyclerViewAdapter = new BreedRecyclerViewAdapter(this, breedList, new BreedRecyclerViewAdapter.BreedOnClickListener() {


//            @Override
//            public void onClick(Breed breed, Breed subBreed ) {
//
//                Intent subBreedDetailIntent = new Intent(SubBreedActivity.this, SubBreedDetailActivity.class);
//
//                subBreedDetailIntent.putExtra("subBreedName", subBreed.getBreedName());
//
//                List<Breed.BreedImage> localBreedImages = subBreed.getBreedImages();
//                List<String> imageLinks = new ArrayList<>();
//
//                for (Breed.BreedImage breedImage : localBreedImages) {
//                    String imageLink = breedImage.getImageLink();
//                    imageLinks.add(imageLink);
//                }
//                String[] imageLinkArray = imageLinks.toArray(new String[0]);
//                subBreedDetailIntent.putExtra("imageLinks", imageLinkArray);
//
//                startActivity(subBreedDetailIntent);
//
//
//            }
//        });


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


            for (Breed breed : breedList) {
                String breedName = breed.getBreedName();
                Timber.tag("log this").d(breedName);


                try {

                    BreedImageApiTask breedImageApiTask = new BreedImageApiTask(breed, null, this);

                    breedImageApiTask.execute();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            Timber.tag("log this").d("");
        }
    }


            @Override
            public void breedImageApiTaskCompleted (Breed breed, Breed subBreed){
            //need to give the images to the adapter

            breedRecyclerViewAdapter.breedImagesReadyForBreed(breed);


            Timber.tag("log this").d(breed + " has images.");
        }
        }



