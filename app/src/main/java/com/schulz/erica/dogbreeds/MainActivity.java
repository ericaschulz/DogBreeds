package com.schulz.erica.dogbreeds;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    private class BreedApiTask extends AsyncTask<Void, Void, JSONObject> {


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

                            Log.d("", "here");


                        } catch (Exception e) {
                            e.printStackTrace();


                        }

                    }


                }


            }
        }

    }
}



















