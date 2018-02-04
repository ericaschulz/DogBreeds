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

public class JSONParser {

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











}
