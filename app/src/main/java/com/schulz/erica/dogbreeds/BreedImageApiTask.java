package com.schulz.erica.dogbreeds;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ericaschulz on 2/27/18.
 */

public class BreedImageApiTask extends AsyncTask<Void, Void, JSONObject> {


     private Breed parentBreed;
     private Breed subBreed;


    public BreedImageApiTaskCallBack breedImageApiTaskCallBack;

    public BreedImageApiTask(Breed parentBreed, Breed subBreed, BreedImageApiTaskCallBack breedImageApiTaskCallBack) throws JSONException {

        super();
        this.parentBreed = parentBreed;
        this.subBreed = subBreed;
        this.breedImageApiTaskCallBack = breedImageApiTaskCallBack;

    }


    @Override
    protected JSONObject doInBackground(Void... voids) {


        if (subBreed != null) {

            return DogApiRetriever.getSubBreedImages(parentBreed.getBreedName(), subBreed.getBreedName());

        } else {

            return DogApiRetriever.getBreedImage(parentBreed.getBreedName());
        }
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

        Breed breed = null;
        if (subBreed != null) {
            breed = this.subBreed;
        } else {
            breed = this.parentBreed;
        }

        if (breedImageArray != null) {

            int length = breedImageArray.length();

            if (length > 0) {

                for (int i = 0; i < length; i++) {
                    try {
                        String imageLink = breedImageArray.getString(i);
                        breed.addImageForLink(imageLink);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

            }

        }
        breedImageApiTaskCallBack.breedImageApiTaskCompleted(breed);
    }



}





