package com.schulz.erica.dogbreeds;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.schulz.erica.dogbreeds.di.DogBreedApplication;
import com.schulz.erica.dogbreeds.di.DogBreedComponent;
import com.schulz.erica.dogbreeds.di.DogBreedManager;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import timber.log.Timber;

import static androidx.recyclerview.widget.LinearLayoutManager.*;
import static com.schulz.erica.dogbreeds.R.layout.activity_breed_list;

public class BreedListActivity extends AppCompatActivity implements BreedListCallBack, BreedImageCallBack {

    @Inject
    DogBreedManager dogBreedManager;

    String[] imageLinks;
    String subBreedName;
    Breed parentBreed;
    String breedName;
    RecyclerView breedRecyclerView;
    BreedRecyclerViewAdapter breedRecyclerViewAdapter;
    TextView subBreedsText;
    ConstraintLayout constraintLayout;
    LinearLayout linearLayout;
    


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getDogBreedComponent().inject(this);


        super.onCreate(savedInstanceState);
        setContentView(activity_breed_list);

        constraintLayout = findViewById(R.id.constraint_layout);
        linearLayout = findViewById(R.id.linear_layout);
        subBreedsText = findViewById(R.id.sub_breeds_text);

        breedRecyclerView = findViewById(R.id.breed_recycler_view);
        breedRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), VERTICAL, false));

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


        this.startLoadingBreeds();
    }




    private DogBreedComponent getDogBreedComponent() {
        return ((DogBreedApplication) getApplication()).getDogBreedComponent();

    }

    public void startLoadingBreeds() {

        if (this.parentBreed != null) {

            dogBreedManager.getSubBreedList(breedName, this);

        } else {

            dogBreedManager.getBreedList(this);

        }
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


        this.breedRecyclerView.setAdapter( breedRecyclerViewAdapter);


//this iterates over the main breedList and returns those images

        for (Breed currentBreed : breedList) {
            String breedName = currentBreed.getBreedName();
            Timber.tag("log this").d(breedName);


            if (this.parentBreed != null) {

                dogBreedManager.getSubBreedImageList(breedName, subBreedName, parentBreed, currentBreed,this);


            } else {

                dogBreedManager.getBreedImageList(breedName, currentBreed, this);

            }

        }
    }




    @Override
    public void breedImagesCompleted(Breed breed) {
        //need to give the images to the adapter


        breedRecyclerViewAdapter.breedImagesReadyForBreed(breed);


        Timber.tag("log this").d(parentBreed + " has images.");
    }
}







