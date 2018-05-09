package com.schulz.erica.dogbreeds;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ericaschulz on 2/27/18.
 */

public class BreedImageApiTask extends AsyncTask<Void, Void, JSONObject> {

    private Breed breed;



    public interface BreedImageApiTaskCallBack {

        void breedImageApiTaskCompleted(Breed breed);

    }

    private BreedImageApiTaskCallBack breedImageApiTaskCallBack;

    public BreedImageApiTask(Breed breed, BreedImageApiTaskCallBack breedImageApiTaskCallBack) throws JSONException {

        this.breed = breed;
        this.breedImageApiTaskCallBack = breedImageApiTaskCallBack;

    }
    @Override
    protected JSONObject doInBackground(Void...voids) {


        return DogApiRetriever.getBreedImage(breed.getBreedName());

    }
    
    
    @Override

    protected void onPostExecute(JSONObject breedImagesList) {

        super.onPostExecute(breedImagesList);

        JSONArray breedImageArray = null;

        try {
            breedImageArray = breedImagesList.getJSONArray("message");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (breedImageArray != null) {

            int length = breedImageArray.length();

            if (length > 0) {

                for (int i = 0; i < length; i++) {
                    try {


                        String imageLink = breedImageArray.getString(i);
                        breed.addImageForLink(imageLink);

                        Log.d("", "here");


                    } catch (Exception e) {
                        e.printStackTrace();


                    }

                }

            }

        }
        breedImageApiTaskCallBack.breedImageApiTaskCompleted(breed);
    }



}





