package com.schulz.erica.dogbreeds;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SubBreedImageApiTask extends AsyncTask<Void, Void, JSONObject> {


    private Breed breed;
    private Breed subBreed;
    private SubBreedImageApiTaskCallBack subBreedImageApiTaskCallBack;

    public interface SubBreedImageApiTaskCallBack {

        void subBreedImageApiTaskCompleted(Breed breed, Breed subBreed);

    }

        public SubBreedImageApiTask(Breed breed, Breed subBreed, SubBreedImageApiTaskCallBack subBreedImageApiTaskCallBack) throws JSONException {

            this.breed = breed;
            this.subBreed = subBreed;
            this.subBreedImageApiTaskCallBack = subBreedImageApiTaskCallBack;

        }
        @Override
        protected JSONObject doInBackground(Void...voids) {


            return DogApiRetriever.getSubBreedImages(breed.getBreedName(), subBreed.getBreedName());

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
                            this.subBreed.addImageForLink(imageLink);

                            Log.d("", "here");


                        } catch (Exception e) {
                            e.printStackTrace();


                        }

                    }

                }

            }
            subBreedImageApiTaskCallBack.subBreedImageApiTaskCompleted(breed, subBreed);
        }



    }





