package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import timber.log.Timber;


public class BreedDetailActivity extends AppCompatActivity {


    RecyclerView breedDetailRecyclerView;
    Breed.BreedImage breedImage;
    List<Breed.BreedImage> breedImages;
    BreedDetailRecyclerViewAdapter breedDetailRecyclerViewAdapter;
    ConstraintLayout constraintDetailLayout;
    GridLayoutManager gridLayoutManager;
    String breedName;
    String[] imageLinks;
    Breed breed;
    TextView breedNameText;
    String imageLink;
    String singleImageLink;
    int imageLinkPosition;
    ImageView photo_detail_1;
    Button back2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_detail);

        constraintDetailLayout = findViewById(R.id.constraint_detail_layout);
        breedNameText = (findViewById(R.id.breed_name));
        breedDetailRecyclerView = findViewById(R.id.breed_detail_recycler_view);
        back2 = (findViewById(R.id.back_button_2));

        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        if (bundle.getString("breedName") != null)

        {
            breedName = bundle.getString("breedName");
        }
        if (bundle.getStringArray("imageLinks") != null)

        {
            imageLinks = bundle.getStringArray("imageLinks");
        }

        breed = new Breed();
        breed.setBreedName(breedName);


        if (imageLinks.length > 0)

        {

            for (int i = 0; i < imageLinks.length; i++) {

                imageLink = imageLinks[i];
                singleImageLink = breed.addImageForLink(imageLink);

            }





        }

        breedNameText.setText(breedName + " has " + imageLinks.length + " images.");

        gridLayoutManager = (new GridLayoutManager(this, 2));
        breedDetailRecyclerView.setLayoutManager(gridLayoutManager);

        breedDetailRecyclerViewAdapter = new BreedDetailRecyclerViewAdapter(this, breed, new BreedDetailRecyclerViewAdapter.SingleImageOnClickListener() {


            @Override
            public void onClick(View view, int position) {


                 Breed.BreedImage breedImage = breed.getBreedImages().get(position);

                 singleImageLink = breedImage.getImageLink();

                final Intent singleImageIntent = new Intent(BreedDetailActivity.this, BreedSingleImageActivity.class);

                singleImageIntent.putExtra("singleImageLink", singleImageLink);


                startActivity(singleImageIntent);




                Timber.tag("singleImage activity").d("clicked!");


            }
        });


        final Intent backIntent = new Intent(this, BreedListActivity.class);


        back2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                startActivity(backIntent);

            }
        });

        breedDetailRecyclerView.setAdapter(breedDetailRecyclerViewAdapter);


    }
}













