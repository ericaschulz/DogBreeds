package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

//implements BreedApiTaskCallBack, BreedImageApiTask.BreedImageApiTaskCallBack

public class BreedDetailActivity extends AppCompatActivity {


    RecyclerView breedDetailRecyclerView;
    Breed.BreedImage breedImage;
    List<Breed.BreedImage> breedImageList;
    List<Breed> breedList;
    BreedDetailRecyclerViewAdapter breedDetailRecyclerViewAdapter;
    ConstraintLayout constraintDetailLayout;
    GridLayout gridLayout;
    LinearLayout linearDetailLayout;
    String breedName;
    String[] imageLinks;
    Breed breed;
    TextView breedNameText;
    ImageView photo_detail_1;


    Button back2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_detail);

        constraintDetailLayout = findViewById(R.id.constraint_detail_layout);
        linearDetailLayout = findViewById(R.id.linear_detail);
        breedNameText = (findViewById(R.id.breed_name));
//        breedDetailRecyclerView = findViewById(R.id.breed_detail_recycler_view);
//        breedDetailRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        back2 = (findViewById(R.id.back_button_2));
        breedDetailRecyclerViewAdapter = new BreedDetailRecyclerViewAdapter(this, breed);
        photo_detail_1 = findViewById(R.id.photo_detail_1);




        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("breedName") != null)

        {
            breedName = bundle.getString("breedName");
        }
        if (bundle.getStringArray("imageLinks") != null)

        {
            imageLinks = bundle.getStringArray("imageLinks");
        }

        breed = new

                Breed();
        breed.setBreedName(breedName);


        String imageLink = null;

        if (imageLinks.length > 0)

        {

            for (int i = 0; i < imageLinks.length; i++) {

                imageLink = imageLinks[i];
                breed.addImageForLink(imageLink);
            }

                Uri imageUri = Uri.parse(breed.getBreedImages().get(3).getImageLink());

                Picasso.with(this)
                        .load(imageUri)
                        .resize(400, 400)
                        .centerCrop()
                        .into(photo_detail_1);


        }

        breedNameText.setText(breedName + " has " + imageLinks.length + " images.");




        final Intent backIntent = new Intent(this, BreedListActivity.class);
        back2.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View v) {
                startActivity(backIntent);
            }

        });

//        this.breedDetailRecyclerView.setAdapter(breedDetailRecyclerViewAdapter);


    }



}








