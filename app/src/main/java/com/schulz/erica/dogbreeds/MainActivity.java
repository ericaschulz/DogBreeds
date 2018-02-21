package com.schulz.erica.dogbreeds;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {



    BreedApiTask breedApiTask;
    ListView breedListView;
    ListAdapter breedListAdapter;
    List<Breed> breedList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.breedList = new ArrayList<>();
        new BreedApiTask().execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    public static class BreedApiTask extends AsyncTask<Void, Void, JSONObject> {

        //declare interface that returns the result of the async task
        public interface BreedNameList {

            void BreedListResult(List<Breed> breedList);

        }

        public BreedNameList breedNameList = null;
        //declare interface as a field in async task

        List<Breed> breedList = new ArrayList<>();


        @Override
        protected JSONObject doInBackground(Void... voids) {

            JSONObject jsonObjectBreeds = JSONParser.getBreeds();

            return jsonObjectBreeds;

        }

        @Override

        protected void onPostExecute(JSONObject jsonObjectBreeds) {

            super.onPostExecute(jsonObjectBreeds);



            JSONArray breedArray = null;
            try {
                breedArray = jsonObjectBreeds.getJSONArray("message");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (breedArray != null) {

                int length = breedArray.length();

                if (length > 0) {

                    for (int i = 0; i < length; i++) {
                        try {

                            Breed breed = new Breed();

                            String breedName = breedArray.getString(i);

                            breed.setBreedName(breedName);
                            breedList.add(breed);
                            breedNameList.BreedListResult(breedList);
                            setBreedNameList(breedList);


                            Log.d("", "here");


                        } catch (Exception e) {
                            e.printStackTrace();


                        }


                    }


                }



            }
        }

        private void setBreedNameList(List<Breed> breedList) {
        }


    }
}




















