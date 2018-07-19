package com.schulz.erica.dogbreeds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SubBreedActivity extends AppCompatActivity {

    SubBreedRecyclerViewAdapter subBreedRecyclerViewAdapter;
    SubBreedsApiTask subBreedsApiTask;
    Breed breed;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_breed);

        String breedName = null;


        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        if (bundle.getString("breedName") != null)

        {
            breedName = bundle.getString("breedName");
            breed = new Breed();
            breed.setBreedName(breedName);
            subBreedsApiTask = new SubBreedsApiTask(breed);

            subBreedsApiTask.execute();
        } else {


        }

    }
    }




//    Need to check for existence of subBreeds for a breed & load this data. Then retrieve images for the subBreeds)

