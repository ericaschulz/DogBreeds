package com.schulz.erica.dogbreeds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.List;




public class SubBreedActivity extends AppCompatActivity implements BreedApiTaskCallBack{

    SubBreedRecyclerViewAdapter subBreedRecyclerViewAdapter;
    SubBreedsApiTask subBreedsApiTask;
    Breed breed;
    String subBreedName;
    TextView subBreedsText;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_breed);

        subBreedsText = findViewById(R.id.sub_breeds_text);

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
        Log.d("yo","here");

        subBreedsText.setText("The " + breed + " breed includes " + breedList.size() + " subbreeds.");


    }




}




//    Need to check for existence of subBreeds for a breed & load this data. Then retrieve images for the subBreeds)

