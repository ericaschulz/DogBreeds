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




public class SubBreedActivity extends AppCompatActivity implements BreedApiTaskCallBack, BreedImageApiTaskCallBack {


    BreedApiTask subBreedsApiTask;
    RecyclerView subBreedRecyclerView;
    BreedRecyclerViewAdapter subBreedRecyclerViewAdapter;
    Breed breed;
    TextView subBreedsText;
    ConstraintLayout constraintLayout;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_list);

        subBreedsText = findViewById(R.id.sub_breeds_text);
        constraintLayout = findViewById(R.id.constraint_layout);
        linearLayout = findViewById(R.id.linear_layout);

        subBreedRecyclerView = findViewById(R.id.breed_recycler_view);
        subBreedRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        String breedName = null;

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        if (bundle.getString("breedName") != null)

        {
            breedName = bundle.getString("breedName");
            breed = new Breed();
            breed.setBreedName(breedName);

            subBreedsApiTask = new BreedApiTask(breedName, this);
            subBreedsApiTask.execute();


        } else {


        }

    }

    @Override
    public void breedApiTaskCompleted(List<Breed> subBreedList) {


        Log.d("yo", "here");

        subBreedsText.setText("The " + breed + " breed includes " + subBreedList.size() + " subbreed(s).");

        //Set recyclerViewAdapter to present the list of subBreedImages//


        this.subBreedRecyclerViewAdapter = new BreedRecyclerViewAdapter(this, subBreedList, new BreedRecyclerViewAdapter.BreedOnClickListener() {


            @Override
            public void onClick(Breed breed, Breed subBreed ) {

                Intent subBreedDetailIntent = new Intent(SubBreedActivity.this, SubBreedDetailActivity.class);

                subBreedDetailIntent.putExtra("subBreedName", subBreed.getBreedName());

                List<Breed.BreedImage> localBreedImages = subBreed.getBreedImages();
                List<String> imageLinks = new ArrayList<>();

                for (Breed.BreedImage breedImage : localBreedImages) {
                    String imageLink = breedImage.getImageLink();
                    imageLinks.add(imageLink);
                }
                String[] imageLinkArray = imageLinks.toArray(new String[0]);
                subBreedDetailIntent.putExtra("imageLinks", imageLinkArray);

                startActivity(subBreedDetailIntent);


            }
        });

        this.subBreedRecyclerView.setAdapter(this.subBreedRecyclerViewAdapter);

//ITERATE OVER SUBBREEDS LIST

        for (Breed subBreed : subBreedList) {
            String subBreedName = subBreed.getBreedName();


            try {

                BreedImageApiTask subBreedImageApiTask = new BreedImageApiTask(breed, subBreed, this);

                subBreedImageApiTask.execute();

            } catch (JSONException e) {

                e.printStackTrace();

            }
            Log.d("log this", subBreedName);

        }
    }


    @Override
    public void breedImageApiTaskCompleted(Breed breed, Breed subBreed ) {


        this.subBreedRecyclerViewAdapter.breedImagesReadyForBreed(subBreed);


        Log.d("log this", breed + " has images.");

    }



    }










