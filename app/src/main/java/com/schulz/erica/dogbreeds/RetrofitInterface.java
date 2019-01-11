package com.schulz.erica.dogbreeds;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitInterface {



    @GET("breeds/list")
    Call<List<Breed>> getBreedList();

    @GET("breed/{breedName}/list")
    Call<List<Breed>> getSubBreedList (@Path ("breedName") String breedName);

    @GET("breed/{breedName}/images")
    Call<List<Breed.BreedImage>> getBreedImageList (@Path ("breedName") String breedName);

    @GET("breed/{breedName}/{subBreedName}/images")
    Call<List<Breed.BreedImage>> getSubBreedImageList (@Path("breedName") String breedName, @Path ("subBreedName") String subBreedName);


}
