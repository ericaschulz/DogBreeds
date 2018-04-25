package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;

import java.util.List;

//implements BreedApiTaskCallBack, BreedImageApiTask.BreedImageApiTaskCallBack

public class BreedDetailActivity extends AppCompatActivity implements BreedApiTask.BreedApiTaskCallBack, BreedImageApiTask.BreedImageApiTaskCallBack {


    RecyclerView breedDetailRecyclerView;
    List<Breed> breedList;
    List<BreedImage> breedDetailImageList;
    Breed breed;
    BreedApiTask breedApiTask;
    BreedDetailRecyclerViewAdapter breedDetailRecyclerViewAdapter;


    Button back2;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_detail);
        this.startBreedAsyncRequest();




        back2 = (findViewById(R.id.back_button_2));


        final Intent backIntent = new Intent(this, BreedListActivity.class);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(backIntent);
            }

        });

        breedDetailRecyclerView = findViewById(R.id.breed_detail_recycler_view);
        breedDetailRecyclerViewAdapter = new BreedDetailRecyclerViewAdapter(this, breedList, breedDetailImageList);
    }

    public void startBreedAsyncRequest() {

        this.breedApiTask = new BreedApiTask((BreedApiTask.BreedApiTaskCallBack) BreedDetailActivity.this);
        this.breedApiTask.execute();
    }

    @Override
    public void breedApiTaskCompleted(List<Breed> breedList) {

        this.breedDetailRecyclerView.setAdapter(breedDetailRecyclerViewAdapter);

        for (Breed breed:breedList) {
            String breedName = breed.getBreedName();
            Log.d("log this", breedName);


            try {

                BreedImageApiTask breedImageApiTask = new BreedImageApiTask(breed, this);

                breedImageApiTask.execute();

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        Log.d("log this", "");


    }





    @Override
    public void breedImageApiTaskCompleted(Breed breed, List<BreedImage> breedImageList) {
        //need to give the images to the adapter

        this.breedDetailRecyclerViewAdapter.injectBreedDetailImages(breed, breedImageList);


        Log.d("log this", breed + " has " + breedImageList.size() + " images.");

    }




}
