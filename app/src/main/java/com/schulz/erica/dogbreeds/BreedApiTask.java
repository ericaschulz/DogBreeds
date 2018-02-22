package com.schulz.erica.dogbreeds;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericaschulz on 2/22/18.
 */

public class BreedApiTask extends AsyncTask<Void, Void, JSONObject> {


    private List<Breed> breedList = new ArrayList<>();


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
                        setBreedList(breedList);





                        Log.d("", "here");


                    } catch (Exception e) {
                        e.printStackTrace();


                    }


                }
            }

        }
    }

    public void setBreedList(List<Breed> breedList) {
        this.breedList = breedList;
    }
}
