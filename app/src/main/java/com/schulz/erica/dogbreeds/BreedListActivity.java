package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONException;

import java.util.List;

public class BreedListActivity extends AppCompatActivity implements BreedApiTask.BreedApiTaskCallBack, BreedImageApiTask.BreedImageApiTaskCallBack{




    ListView breedImageListView;
    BreedImageListAdapter breedImageListAdapter;
    ListView breedListView;
    BreedListAdapter breedListAdapter;
    BreedApiTask breedApiTask;
    RecyclerView breedRecyclerView;
    List<Breed> breedList;
    List<BreedImage> breedImageList;
    BreedRecyclerViewAdapter breedRecyclerViewAdapter;
    CardView card_view;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_breed_list);

        this.startBreedAsyncRequest();


        constraintLayout = findViewById(R.id.constraint_layout);

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

    }

    public void startBreedAsyncRequest() {

        this.breedApiTask = new BreedApiTask(BreedListActivity.this);
        this.breedApiTask.execute();


    }

    @Override
    public void breedApiTaskCompleted(List<Breed> breedList) {

//        breedListView = findViewById(R.id.list);
//        breedListAdapter = new BreedListAdapter(this, R.layout.text_view, breedList);
//        breedListView.setAdapter(breedListAdapter);

        for (Breed breed:breedList) {
            String breedName = breed.getBreedName();
            Log.d("log this", breedName);




            try {

                BreedImageApiTask breedImageApiTask = new BreedImageApiTask(this);
                breedImageApiTask.setBreedName(breedName);
                breedImageApiTask.execute();
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        Log.d("log this", "");

    }

    @Override
    public void breedImageApiTaskCompleted(List<BreedImage> breedImageList) {

//        breedListView = findViewById(R.id.image_list);

        breedRecyclerViewAdapter = new BreedRecyclerViewAdapter(this, breedImageList);
        breedRecyclerView.setAdapter(breedRecyclerViewAdapter);


        Log.d("log this", "completed");

    }
}