package com.schulz.erica.dogbreeds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

public class ListActivity extends AppCompatActivity  {

    ListView breedListView;
    ListAdapter breedListAdapter;
    List<Breed> breedList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ListView breedListView = findViewById(R.id.list);
        breedListView.setAdapter(breedListAdapter);





    }
}
