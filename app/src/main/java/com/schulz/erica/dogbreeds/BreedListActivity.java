package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.schulz.erica.dogbreeds.di.DogBreedApplication;
import com.schulz.erica.dogbreeds.di.DogBreedComponent;
import com.schulz.erica.dogbreeds.di.DogBreedManager;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class BreedListActivity extends AppCompatActivity implements BreedListCallBack, BreedImageApiTaskCallBack {

    @Inject
    DogBreedManager dogBreedManager;

    List<Breed> breedList;
    String[] imageLinks;
    Breed parentBreed;
    String breedName;
    RecyclerView breedRecyclerView;
    BreedRecyclerViewAdapter breedRecyclerViewAdapter;
    TextView subBreedsText;

    ConstraintLayout constraintLayout;
    LinearLayout linearLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getDogBreedComponent().inject(this);

        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_breed_list);

        constraintLayout = findViewById(R.id.constraint_layout);
        linearLayout = findViewById(R.id.linear_layout);
        subBreedsText = findViewById(R.id.sub_breeds_text);


        breedRecyclerView = findViewById(R.id.breed_recycler_view);
        breedRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        DogBreedManager.getInstance()
                .getDogBreedInterface()
                .getBreedList()
                .enqueue(new Callback<List<Breed>>() {

                    @Override
                    public void onResponse(@NonNull Call<List<Breed>> call, @NonNull Response<List<Breed>> response) {

                        List<Breed> breedList = response.body();

                        subBreedsText.append(breedList.toString());

                        breedListAvailable(breedList);

                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Breed>> call, @NonNull Throwable t) {


                        t.printStackTrace();



                    }
                });



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







