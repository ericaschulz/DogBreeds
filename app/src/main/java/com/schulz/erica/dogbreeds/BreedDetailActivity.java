package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

//implements BreedApiTaskCallBack, BreedImageApiTask.BreedImageApiTaskCallBack

public class BreedDetailActivity extends AppCompatActivity {


    RecyclerView breedDetailRecyclerView;
    List<Breed.BreedImage> breedImageList;
    List<Breed>breedList;
    BreedDetailRecyclerViewAdapter breedDetailRecyclerViewAdapter;
    ConstraintLayout constraintDetailLayout;
    GridLayout gridLayout;
    LinearLayout linearDetailLayout;
    String breedName;
    Breed breed;
    TextView test;



    Button back2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_detail);

        constraintDetailLayout = findViewById(R.id.constraint_detail_layout);
        linearDetailLayout = findViewById(R.id.linear_detail);
        test = (findViewById(R.id.test));
        breedDetailRecyclerView = findViewById(R.id.breed_detail_recycler_view);
        breedDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        back2 = (findViewById(R.id.back_button_2));

        Bundle bundle = getIntent().getExtras();
        if(bundle.getString("breedName") !=null)
            breedName = bundle.getString("breedName");
        test.setText(breedName);


        final Intent backIntent = new Intent(this, BreedListActivity.class);
        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(backIntent);
            }

        });


        breedDetailRecyclerView = findViewById(R.id.breed_detail_recycler_view);
        breedDetailRecyclerViewAdapter = new BreedDetailRecyclerViewAdapter(this, (breedList), breedImageList);

        this.breedDetailRecyclerView.setAdapter(breedDetailRecyclerViewAdapter);
    }

}





