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
    private Breed subBreed;


    private BreedImageApiTaskCallBack breedImageApiTaskCallBack;

    public BreedImageApiTask(Breed breed, Breed subBreed, BreedImageApiTaskCallBack breedImageApiTaskCallBack) throws JSONException {

        super();
        this.breed = breed;
        this.subBreed = subBreed;
        this.breedImageApiTaskCallBack = breedImageApiTaskCallBack;

    }


    @Override
    protected JSONObject doInBackground(Void... voids) {


        if (subBreed != null) {

            return DogApiRetriever.getSubBreedImages(breed.getBreedName(), subBreed.getBreedName());

        } else {

            return DogApiRetriever.getBreedImage(breed.getBreedName());
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

        if (breedImageArray != null) {

            int length = breedImageArray.length();

            if (length > 0) {

                for (int i = 0; i < length; i++) {
                    try {


                        String imageLink = breedImageArray.getString(i);

                      if (subBreed != null) {


                          this.subBreed.addImageForLink(imageLink);


                          Log.d("", "here");

                      } else {

                          this.breed.addImageForLink(imageLink);
                      }

                          }

                     catch (Exception e) {
                        e.printStackTrace();


                    }

                }

            }

        }
        breedImageApiTaskCallBack.breedImageApiTaskCompleted(breed, subBreed);
    }



}





