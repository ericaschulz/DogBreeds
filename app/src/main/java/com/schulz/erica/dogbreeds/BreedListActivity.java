package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class BreedListActivity extends AppCompatActivity implements BreedApiTask.BreedApiTaskCallBack {

    ListView breedListView;
    BreedListAdapter breedListAdapter;
    BreedApiTask breedApiTask;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_breed_list);

        this.startBreedAsyncRequest();

        final Intent mainIntent = new Intent(BreedListActivity.this, MainActivity.class);
        Button back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                startActivity(mainIntent);
            }
        });


    }

    public void startBreedAsyncRequest() {

        this.breedApiTask = new BreedApiTask(BreedListActivity.this);
        this.breedApiTask.execute();


    }

    @Override
    public void breedApiTaskCompleted(List<Breed> breedList) {

        breedListView = findViewById(R.id.list);
        breedListAdapter = new BreedListAdapter(this, R.layout.text_view, breedList);
        breedListView.setAdapter(breedListAdapter);

        Log.d("log this", "");

    }

}
