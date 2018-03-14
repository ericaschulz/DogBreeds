package com.schulz.erica.dogbreeds;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ericaschulz on 3/12/18.
 */

public interface BreedApiService {

    @GET("breed_name")
    Call<BreedApiResponse> getbreedName(@Query("breed_name")String breedName);


}
