package com.schulz.erica.dogbreeds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity implements BreedApiTask.BreedApiTaskCompleted {

    ListView breedListView;
    ArrayAdapter breedListAdapter;
    List<Breed> breedList;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        BreedApiTask breedApiTask = new BreedApiTask(ListActivity.this);
        breedApiTask.execute();





    }

    @Override
    public void breedApiTaskCompleted(List<Breed> breedList) {


        this.breedList = new ArrayList<>();
        breedListView = findViewById(R.id.list);
        breedListView.setAdapter(breedListAdapter);

    }

}
