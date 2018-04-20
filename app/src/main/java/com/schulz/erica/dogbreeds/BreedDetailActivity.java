package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.List;

//implements BreedApiTaskCallBack, BreedImageApiTask.BreedImageApiTaskCallBack

public class BreedDetailActivity extends AppCompatActivity  {


    RecyclerView breedDetailRecyclerView;
    List<BreedImage> breedDetailImageList;
    BreedDetailRecyclerViewAdapter breedDetailRecyclerViewAdapter;

    Button back2;
    Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_detail);




        back2 = (findViewById(R.id.back_button_2));
        home = (findViewById(R.id.home));

        final Intent homeIntent = new Intent(this, MainActivity.class);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(homeIntent);

            }
        });

        final Intent backIntent = new Intent(this, BreedListActivity.class);
        back2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(backIntent);
            }

        });

        breedDetailRecyclerView = findViewById(R.id.breed_detail_recycler_view);
//        breedDetailRecyclerViewAdapter = new BreedDetailRecyclerViewAdapter(this, List<Breed> breedList,List<BreedImage> breedDetailImageList);
}

//    public void startBreedApiImageTaskCompleted() {
//
//        this.breedApiTask = new BreedApiTask(this);
//        this.breedApiTask.execute();
//    }
//


}
