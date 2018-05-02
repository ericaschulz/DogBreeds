package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import org.json.JSONException;

import java.util.List;

import static com.schulz.erica.dogbreeds.BreedApiTask.BreedApiTaskCallBack;

public class BreedListActivity extends AppCompatActivity implements BreedApiTaskCallBack, BreedImageApiTask.BreedImageApiTaskCallBack {


    BreedApiTask breedApiTask;
    RecyclerView breedRecyclerView;
    List<Breed> breedList;
    List<BreedImage> breedImageList;
    String breedName;
    BreedRecyclerViewAdapter breedRecyclerViewAdapter;
    ConstraintLayout constraintLayout;
    LinearLayout linearLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_breed_list);
        this.startBreedAsyncRequest();

        Button refresh = findViewById(R.id.refresh);

        constraintLayout = findViewById(R.id.constraint_layout);
        linearLayout = findViewById(R.id.linear_layout);

        breedRecyclerView = findViewById(R.id.breed_recycler_view);
        breedRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        final Intent mainIntent = new Intent(BreedListActivity.this, MainActivity.class);

        Button back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                startActivity(mainIntent);
            }
        });

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startBreedAsyncRequest();
            }
        });

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
            public void onClick(Breed breed) {

//                if breed != null


                final Intent detailIntent2 = new Intent(BreedListActivity.this, BreedDetailActivity.class);

//                detailIntent2.putExtra("breed",breed.getBreedName());
//                detailIntent2.putExtr

                startActivity(detailIntent2);

            }
        });


        this.breedRecyclerView.setAdapter(breedRecyclerViewAdapter);


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
        
        this.breedRecyclerViewAdapter.injectBreedImages(breed, breedImageList);


        Log.d("log this", breedName + " has " + breedImageList.size() + " images.");

    }

}
