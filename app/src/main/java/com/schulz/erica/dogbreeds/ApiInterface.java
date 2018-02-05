package com.schulz.erica.dogbreeds;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ericaschulz on 2/4/18.
 */

public interface ApiInterface {

    @GET("message")
    Call<Breed> apiCall();

}




