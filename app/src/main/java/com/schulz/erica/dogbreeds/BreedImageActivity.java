package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class BreedImageActivity extends AppCompatActivity implements BreedImageApiTask.BreedImageApiTaskCallBack {


    BreedImageApiTask breedImageApiTask;
    ListView breedImageListView;
    BreedImageListAdapter breedImageListAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_image);

//        this.startBreedAsyncRequest();
        this.startBreedImageAsyncRequest();

        final Intent mainIntent2 = new Intent(BreedImageActivity.this, MainActivity.class);
        Button back = findViewById(R.id.back_button_2);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                startActivity(mainIntent2);
            }
        });
    }

//    public void startBreedAsyncRequest() {
//
//        this.breedApiTask = new BreedApiTask(BreedImageActivity.this);
//        this.breedApiTask.execute();
//
//
//    }

    public void startBreedImageAsyncRequest() {

        this.breedImageApiTask = new BreedImageApiTask(BreedImageActivity.this);
        this.breedImageApiTask.execute();
    }

    @Override
    public void breedImageApiTaskCompleted(List<BreedImage> breedImageList) {



        breedImageListView = findViewById(R.id.image_list);
        breedImageListAdapter = new BreedImageListAdapter(this, R.layout.text_view_2, breedImageList);
        breedImageListView.setAdapter(breedImageListAdapter);

        Log.d("log this", "");

    }
}
