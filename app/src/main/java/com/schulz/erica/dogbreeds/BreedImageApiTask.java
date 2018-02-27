package com.schulz.erica.dogbreeds;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericaschulz on 2/27/18.
 */

public class BreedImageApiTask extends AsyncTask<Void, Void, JSONObject> {

    private List<BreedImage> breedImageList = new ArrayList<>();

    public interface BreedImageApiTaskCallBack {

        void breedImageApiTaskCompleted(List<BreedImage> breedImageList);
    }

    private BreedImageApiTaskCallBack breedImageApiTaskCallBack;

    public BreedImageApiTask(BreedImageApiTaskCallBack breedImageApiTaskCallBack){

        this.breedImageApiTaskCallBack = breedImageApiTaskCallBack;

    }
    @Override
    protected JSONObject doInBackground(Void... voids) {


        return JSONParser.getBreedImage();

    }
    @Override

    protected void onPostExecute(JSONObject jsonObjectBreedImages) {

        super.onPostExecute(jsonObjectBreedImages);


        JSONArray breedImageArray = null;
        try {
            breedImageArray = jsonObjectBreedImages.getJSONArray("message");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (breedImageArray != null) {

            int length = breedImageArray.length();

            if (length > 0) {

                for (int i = 0; i < length; i++) {
                    try {

                        BreedImage breedImage = new BreedImage();
                        String imageLink = breedImageArray.getString(i);
                        breedImage.setImageLink(imageLink);
                        breedImageList.add(breedImage);
                        setBreedImageList(breedImageList);


                        Log.d("", "here");


                    } catch (Exception e) {
                        e.printStackTrace();


                    }

                }

            }

        } breedImageApiTaskCallBack.breedImageApiTaskCompleted(breedImageList);
    }

    public void setBreedImageList(List<BreedImage> breedImageList) {
        this.breedImageList = breedImageList;
    }
}





