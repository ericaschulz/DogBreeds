package com.schulz.erica.dogbreeds;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;

//    ArrayList<Breed> listBreeds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


//        new BreedApiTask().execute();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
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


//    private class BreedApiTask extends AsyncTask<Void, Void, JSONObject> {
//
//
//        @Override
//        protected JSONObject doInBackground(Void... voids) {
//
//            JSONObject jsonObjectBreeds = JSONParser.getBreeds();
//
//            return jsonObjectBreeds;
//
//
//        }
//
//        @Override
//
//        protected void onPostExecute(JSONObject jsonObjectBreeds) {
//
//            super.onPostExecute(jsonObjectBreeds);
//
//
//            //"jsonObjectBreeds.names()" does not return the breed names listed after "messages"!
//
//            JSONArray jsonArray = jsonObjectBreeds.names(); //<---THIS IS WRONG!!!
//
//            if (jsonArray != null) {
//
//                int length = jsonArray.length();
//
//                if (length > 0) {
//
//                    for (int i = 0; i < length; i++)
//                        try {
//
//                            Message message = new Message();
//                            listMessages.add(message);//<----SO THIS IS USELESS!
//                        } catch (Exception e) {
//                            e.printStackTrace();
//
//
//                        }
//
//                }
//
//
//            }
//
//
//        }
    }



















