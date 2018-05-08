package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

//implements BreedApiTaskCallBack, BreedImageApiTask.BreedImageApiTaskCallBack

public class BreedDetailActivity extends AppCompatActivity implements BreedImageApiTask.BreedImageApiTaskCallBack {


    RecyclerView breedDetailRecyclerView;
    List<Breed> breedList;
    List<Breed.BreedImage> breedImageList;
    Breed breed;
    BreedDetailRecyclerViewAdapter breedDetailRecyclerViewAdapter;
    ConstraintLayout constraintDetailLayout;
    LinearLayout linearDetailLayout;
    TextView breedName;



    Button back2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_detail);

        constraintDetailLayout = findViewById(R.id.constraint_detail_layout);
        linearDetailLayout = findViewById(R.id.linear_detail_layout);

        breedDetailRecyclerView = findViewById(R.id.breed_detail_recycler_view);


        back2 = (findViewById(R.id.back_button_2));
        breedName = (findViewById(R.id.breed_name));


        final Intent backIntent = new Intent(this, BreedListActivity.class);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(backIntent);
            }

        });
        breedName.setText(R.string.test);

        breedDetailRecyclerView = findViewById(R.id.breed_detail_recycler_view);
        breedDetailRecyclerViewAdapter = new BreedDetailRecyclerViewAdapter(this, breedList, breedImageList);

        this.breedDetailRecyclerView.setAdapter(breedDetailRecyclerViewAdapter);
    }




//    @Override
//    public void breedImageApiTaskCompleted(List<Breed> breedList) {
//
//        this.breedDetailRecyclerView.setAdapter(breedDetailRecyclerViewAdapter);
//
//        for (Breed breed:breedList) {
//            String breedName = breed.getBreedName();
//            Log.d("log this", breedName);
//
//
//            try {
//
//                BreedImageApiTask breedImageApiTask = new BreedImageApiTask(breed, this);
//
//                breedImageApiTask.execute();
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//
//        }
//
//        Log.d("log this", "");
//
//
//    }





    @Override
    public void breedImageApiTaskCompleted(Breed breed, List<Breed.BreedImage> breedImageList) {
//        need to give the images to the adapter

        this.breedDetailRecyclerViewAdapter.injectBreedDetailImages(breed, breedImageList);


        Log.d("log this", breed + " has " + breedImageList.size() + " images.");

    }




}
