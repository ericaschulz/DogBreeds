package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class BreedSingleImageActivity extends AppCompatActivity {

    ImageView photoSingle;

    String singleImageLink;

    Button button;

    Breed subBreeds;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_single_image);

        button = findViewById(R.id.button);

        final Intent subBreedIntent = new Intent(BreedSingleImageActivity.this, SubBreedActivity.class);
        subBreedIntent.putExtra("breedName", "hound");

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {



                startActivity(subBreedIntent);
            }
        });





        photoSingle = findViewById(R.id.photo_single);


        Bundle bundle = getIntent().getExtras();

        assert bundle != null;


        singleImageLink = bundle.getString("singleImageLink");


        Picasso.with(this)
                .load(singleImageLink)
                .resize(600, 700)
                .centerCrop()
                .into(photoSingle);


    }
}
