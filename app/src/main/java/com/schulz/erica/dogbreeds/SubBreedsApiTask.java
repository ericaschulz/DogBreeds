package com.schulz.erica.dogbreeds;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class SubBreedsApiTask extends AsyncTask<Void, Void, JSONObject> {

    Breed breed;

    private List<Breed> subBreeds = new ArrayList<>();
    private BreedApiTaskCallBack breedApiTaskCallBack;

    public SubBreedsApiTask(Breed breed, BreedApiTaskCallBack breedApiTaskCallBack) {
        this.breed = breed;
        this.breedApiTaskCallBack = breedApiTaskCallBack;
    }



    @Override
    protected JSONObject doInBackground(Void... voids) {

        return DogApiRetriever.getSubBreeds(breed.getBreedName());

    }

    @Override

    protected void onPostExecute(JSONObject jsonObjectBreeds) {

        super.onPostExecute(jsonObjectBreeds);




        JSONArray subBreedArray = null;


        try {
            subBreedArray = jsonObjectBreeds.getJSONArray("message");

        } catch (JSONException e) {

            e.printStackTrace();
        }


        if (subBreedArray != null) {

            int length = subBreedArray.length();

            if (length > 0) {

                for (int i = 0; i < length; i++) {
                    try {

                        Breed subBreed = new Breed();

                        String breedName = subBreedArray.getString(i);
                        subBreed.setBreedName(breedName);
                        subBreeds.add(subBreed);
                        setSubBreeds(subBreeds);



                        Log.d("", "here");


                    } catch (Exception e) {
                        e.printStackTrace();


                    }


                }




            }
        }

        breedApiTaskCallBack.breedApiTaskCompleted(subBreeds);
    }


    public void setSubBreeds(List<Breed> subBreeds) {
        this.subBreeds = subBreeds;
    }
}

