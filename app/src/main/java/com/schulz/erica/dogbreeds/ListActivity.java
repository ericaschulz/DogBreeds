package com.schulz.erica.dogbreeds;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class ListActivity extends AppCompatActivity implements BreedApiTask.BreedApiTaskCallBack {

    ListView breedListView;
    BreedListAdapter breedListAdapter;
    List<Breed> breedList;
    BreedApiTask breedApiTask;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        breedApiTask = new BreedApiTask(ListActivity.this);
        breedApiTask.execute();

        final Intent mainIntent = new Intent(ListActivity.this, MainActivity.class);
        Button back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                startActivity(mainIntent);
            }
        });


    }

    @Override
    public void breedApiTaskCompleted(List<Breed> breedList) {

        breedListView = findViewById(R.id.list);
        breedListAdapter = new BreedListAdapter(this, R.layout.text_view, breedList);
        breedListView.setAdapter(breedListAdapter);

        Log.d("log this", "");

    }

}
