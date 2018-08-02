package com.schulz.erica.dogbreeds;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONException;

import java.util.List;




public class SubBreedActivity extends AppCompatActivity implements BreedApiTaskCallBack, SubBreedImageApiTask.SubBreedImageApiTaskCallBack {


    SubBreedsApiTask subBreedsApiTask;
    SubBreedImageApiTask subBreedImageApiTask;
    RecyclerView breedRecyclerView;
    BreedRecyclerViewAdapter breedRecyclerViewAdapter;
    Breed breed;
    String subBreedName;
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

        breedRecyclerView = findViewById(R.id.breed_recycler_view);
        breedRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        String breedName = null;

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        if (bundle.getString("breedName") != null)

        {
            breedName = bundle.getString("breedName");
            breed = new Breed();
            breed.setBreedName(breedName);


            subBreedsApiTask = new SubBreedsApiTask(breed, this);
            subBreedsApiTask.execute();


            breed.setSubBreedName(subBreedName);


        } else {


        }


    }

    @Override
    public void breedApiTaskCompleted(List<Breed> breedList) {
        //Here, "breedList" is actually the list of subBreeds//

        Log.d("yo", "here");

        subBreedsText.setText("The " + breed + " breed includes " + breedList.size() + " subbreeds.");

        //Set recyclerViewAdapter to present the list of subBreedImages//


        breedRecyclerViewAdapter = new BreedRecyclerViewAdapter(this, breedList, new BreedRecyclerViewAdapter.BreedOnClickListener() {
            @Override
            public void onClick(Breed breed) {

            }
        });

        for (Breed breed : breedList) {
            String breedName = breed.getBreedName();
            Log.d("log this", breedName);

            try {
                subBreedImageApiTask = new SubBreedImageApiTask(breed, this);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            subBreedImageApiTask.execute();


            this.breedRecyclerView.setAdapter(breedRecyclerViewAdapter);

        }



    }@Override
    public void subBreedImageApiTaskCompleted (Breed breed){


        breedRecyclerViewAdapter.breedImagesReadyForBreed(breed);


        Log.d("log this", breed + " has images.");

    }
}




