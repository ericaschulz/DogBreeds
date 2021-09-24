package com.schulz.erica.dogbreeds;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class BreedSingleImageActivity extends AppCompatActivity {

    ImageView photoSingle;

    String singleImageLink;

    Breed breed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_single_image);

        photoSingle = findViewById(R.id.photo_single);


        Bundle bundle = getIntent().getExtras();

        assert bundle != null;


        singleImageLink = bundle.getString("singleImageLink");


        Picasso.with(this)
                .load(singleImageLink)
                .resize(650, 700)
                .centerCrop()
                .into(photoSingle);


    }
}
