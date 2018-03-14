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

    private String breedName;



    private List<BreedImage> breedImageList = new ArrayList<>();

    public void setBreedName(String breedName) {

        this.breedName = breedName;

    }


    public interface BreedImageApiTaskCallBack {

        void breedImageApiTaskCompleted(String breedName, List<BreedImage> breedImageList);

    }


    private BreedImageApiTaskCallBack breedImageApiTaskCallBack;

    public BreedImageApiTask(BreedImageApiTaskCallBack breedImageApiTaskCallBack) throws JSONException {

        this.breedImageApiTaskCallBack = breedImageApiTaskCallBack;

    }
    @Override
    protected JSONObject doInBackground(Void...voids) {


        return DogApiRetriever.getBreedImage(breedName);

    }
    
    
    @Override

    protected void onPostExecute(JSONObject breedImages) {

        super.onPostExecute(breedImages);

        JSONArray breedImageArray = null;

        try {
            breedImageArray = breedImages.getJSONArray("message");
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

        } breedImageApiTaskCallBack.breedImageApiTaskCompleted(breedName, breedImageList);
    }

    public void setBreedImageList(List<BreedImage> breedImageList) {
        this.breedImageList = breedImageList;
    }
}





