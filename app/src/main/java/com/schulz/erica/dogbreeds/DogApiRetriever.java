package com.schulz.erica.dogbreeds;

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

    private static Response response;

    public static JSONObject getBreeds() {

        try {
            OkHttpClient client = new OkHttpClient();
            String BreedNames_url = "https://dog.ceo/api/breeds/list";
            Request request = new Request.Builder()
                    .url(BreedNames_url).build();
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static JSONObject getBreedImage(String breedName) {

        try {
            OkHttpClient client = new OkHttpClient();
            String BreedImages_url = String.format("https://dog.ceo/api/breed/%s/images", breedName);
            Request request = new Request.Builder()
                    .url(BreedImages_url).build();
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONObject getSubBreeds(String breedName) {

        try {
            OkHttpClient client = new OkHttpClient();
            String SubBreeds_url = String.format("https://dog.ceo/api/breed/%s/list", breedName);
            Request request = new Request.Builder()
                    .url(SubBreeds_url).build();
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONObject getSubBreedImages(String breedName, String subBreedName) {

        try {
            OkHttpClient client = new OkHttpClient();
            String SubBreedImages_url = String.format("https://dog.ceo/api/breed/%s/%s/images", breedName, subBreedName);
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







//"https://dog.ceo/api/%s/%s/%s/%s"


















