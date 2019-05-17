package com.schulz.erica.dogbreeds;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by ericaschulz on 2/4/18.
 */

public class DogApiRetriever {


    public static JSONObject getBreedImage(String breedName) {

        return DogApiRetriever.getEverything("breed", breedName,"images");

    }
    public static JSONObject getSubBreedImages(String breedName, String subBreedName) {

        return DogApiRetriever.getEverything("breed", breedName, subBreedName, "images");

    }

    public static JSONObject getEverything(String... pathComponents) {

        Response response;

        try {
            OkHttpClient client = new OkHttpClient();
            String path = TextUtils.join("/",pathComponents);
            String SubBreedImages_url = String.format("https://dog.ceo/api/%s",path);
            Request request = new Request.Builder()
                    .url(SubBreedImages_url).build();
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

























