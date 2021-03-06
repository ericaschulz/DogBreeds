package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;


public class BreedDetailActivity extends AppCompatActivity {


    RecyclerView breedDetailRecyclerView;
    BreedDetailRecyclerViewAdapter breedDetailRecyclerViewAdapter;
    ConstraintLayout constraintDetailLayout;
    GridLayoutManager gridLayoutManager;
    String breedName;
    String[] imageLinks;
    Breed breed;
    TextView breedNameText;
    String imageLink;
    String singleImageLink;
    ImageView photo_detail_1;
    Button subBreedButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_detail);

        constraintDetailLayout = findViewById(R.id.constraint_detail_layout);
        breedNameText = (findViewById(R.id.breed_name));
        breedDetailRecyclerView = findViewById(R.id.breed_detail_recycler_view);
        subBreedButton = (findViewById(R.id.sub_breeds_button));

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


        final Intent subBreedIntent = new Intent(this, BreedListActivity.class);
        subBreedIntent.putExtra("breedName", breedName);

        List<Breed.BreedImage> localBreedImages = breed.getBreedImages();
        List<String> imageLinks = new ArrayList<>();

        for (Breed.BreedImage breedImage : localBreedImages) {
            String imageLink = breedImage.getImageLink();
            imageLinks.add(imageLink);
        }
        String[] imageLinkArray = imageLinks.toArray(new String[0]);
        subBreedIntent.putExtra("imageLinks", imageLinkArray);

        subBreedButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                startActivity(subBreedIntent);

            }
        });

        breedNameText.setText(String.format("%s has %s images.", breedName, imageLinks.size()));

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




        breedDetailRecyclerView.setAdapter(breedDetailRecyclerViewAdapter);


    }
}













