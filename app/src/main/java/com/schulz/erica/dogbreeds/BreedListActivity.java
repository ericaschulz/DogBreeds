package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.schulz.erica.dogbreeds.di.DogBreedApplication;
import com.schulz.erica.dogbreeds.di.DogBreedComponent;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import timber.log.Timber;

public class BreedListActivity extends AppCompatActivity implements BreedListCallBack, BreedImageApiTaskCallBack {

    @Inject
    Retrofit retrofit;

    String[] imageLinks;
    Breed parentBreed;
    String breedName;
    RecyclerView breedRecyclerView;
    BreedRecyclerViewAdapter breedRecyclerViewAdapter;
    TextView subBreedsText;
    ConstraintLayout constraintLayout;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getDogBreedComponent().inject(this);

        RetrofitInterface service = RetrofitInstance.getRetrofitInstance().create(RetrofitInterface.class);

        Call<List<Breed>> call = service.getBreedList();
        call.enqueue(new Callback<List<Breed>>() {

            @Override

            public void onResponse(Call<List<Breed>> call, Response<List<Breed>> response) {
                loadBreedList(response.body());
            }

            @Override

            public void onFailure(Call<List<Breed>> call, Throwable throwable) {

                Toast.makeText(BreedListActivity.this, "Unable to load users", Toast.LENGTH_SHORT).show();
            }

        });


        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_breed_list);

        constraintLayout = findViewById(R.id.constraint_layout);
        linearLayout = findViewById(R.id.linear_layout);
        subBreedsText = findViewById(R.id.sub_breeds_text);

        breedRecyclerView = findViewById(R.id.breed_recycler_view);
        breedRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.getString("breedName") != null) {
            breedName = bundle.getString("breedName");
            parentBreed = new Breed();
            parentBreed.setBreedName(breedName);

            if (bundle.getStringArray("imageLinks") != null)

            {
                imageLinks = bundle.getStringArray("imageLinks");
            }

        }


//        this.loadBreedList(breedList);
    }

    private void loadBreedList(List<Breed> breedList) {

//        myRecyclerView = findViewById(R.id.myRecyclerView);
//        myAdapter = new MyAdapter(usersList);
//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//        myRecyclerView.setLayoutManager(layoutManager);
//
//        myRecyclerView.setAdapter(myAdapter);
    }





    private DogBreedComponent getDogBreedComponent() {
        return ((DogBreedApplication) getApplication()).getDogBreedComponent();

    }

//    public void startLoadingBreeds() {
//
//
//        if (this.parentBreed != null) {
//
//            dogBreedManager.getSubBreedList(breedName, this);
//
//        } else {
//
//            dogBreedManager.getBreedList(this);
//
//        }


    

    @Override
    public void breedListAvailable(List<Breed> breedList) {


        Log.d("yo", "here");

        subBreedsText.setText("The " + parentBreed + " breed includes " + breedList.size() + " subbreed(s).");

        breedRecyclerView = findViewById(R.id.breed_recycler_view);
        breedRecyclerViewAdapter = new BreedRecyclerViewAdapter(this, breedList, new BreedRecyclerViewAdapter.BreedOnClickListener() {


            //OnClick with Intent to display BreedDetailActivity
            @Override
            public void onClick(Breed breed, Breed subBreed) {

                Intent intent = new Intent(BreedListActivity.this, BreedDetailActivity.class);

                intent.putExtra("breedName", breed.getBreedName());

                List<Breed.BreedImage> localBreedImages = breed.getBreedImages();
                List<String> imageLinks = new ArrayList<>();

                for (Breed.BreedImage breedImage : localBreedImages) {
                    String imageLink = breedImage.getImageLink();
                    imageLinks.add(imageLink);
                }
                String[] imageLinkArray = imageLinks.toArray(new String[0]);
                intent.putExtra("imageLinks", imageLinkArray);

                startActivity(intent);

            }
        });


        this.breedRecyclerView.setAdapter(breedRecyclerViewAdapter);


//this iterates over the main breedList and returns those images

        for (Breed currentBreed : breedList) {
            String breedName = currentBreed.getBreedName();
            Timber.tag("log this").d(breedName);

            try {


                if (this.parentBreed != null) {

                    BreedImageApiTask subBreedImageApiTask = new BreedImageApiTask(this.parentBreed, currentBreed, this);

                    subBreedImageApiTask.execute();


                } else {

                    BreedImageApiTask breedImageApiTask = new BreedImageApiTask(currentBreed, null, this);

                    breedImageApiTask.execute();

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }




    @Override
    public void breedImageApiTaskCompleted(Breed breed) {
        //need to give the images to the adapter


        breedRecyclerViewAdapter.breedImagesReadyForBreed(breed);


        Timber.tag("log this").d(parentBreed + " has images.");
    }
}







