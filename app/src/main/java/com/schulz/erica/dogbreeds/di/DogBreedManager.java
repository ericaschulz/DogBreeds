package com.schulz.erica.dogbreeds.di;


import android.support.annotation.NonNull;
import android.util.Log;

import com.schulz.erica.dogbreeds.Breed;
import com.schulz.erica.dogbreeds.BreedImageCallBack;
import com.schulz.erica.dogbreeds.BreedListCallBack;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DogBreedManager {

    private Retrofit retrofit;
    private static final String BASE_URL = "https://dog.ceo/api/";
    private DogBreedEnvelope dogBreedEnvelope;


    public DogBreedManager() {

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(new DogBreedEnvelopeFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

    }

    public DogBreedInterface getDogBreedInterface() {

        return retrofit.create(DogBreedInterface.class);
    }

    public void setDogBreedEnvelope(DogBreedEnvelope dogBreedEnvelope) {
        this.dogBreedEnvelope = dogBreedEnvelope;
    }

    public DogBreedEnvelope getDogBreedEnvelope() {
        return dogBreedEnvelope;
    }


    public void getBreedList(final BreedListCallBack breedListCallBack) {


        if (this.hasLocalBreedList()) {

            //callback local database if true


        } else {

            Call<List<Breed>> call = getDogBreedInterface().getBreedList();
            call.enqueue(new Callback<List<Breed>>() {
                @Override
                public void onResponse(@NonNull Call<List<Breed>> call, @NonNull Response<List<Breed>> response) {

                    List<Breed> breedList = response.body();

                    breedListCallBack.breedListAvailable(breedList);

                }

                @Override
                public void onFailure(@NonNull Call<List<Breed>> call, Throwable t) {
                    Log.d("", "");
                }
            });


        }

    }

    public void getSubBreedList(String breedName, final BreedListCallBack breedListCallBack) {

        if (this.hasLocalBreedList()) {

            //callback local database if true


        } else {


            Call<List<Breed>> call = getDogBreedInterface().getSubBreedList(breedName);
            call.enqueue(new Callback<List<Breed>>() {
                @Override
                public void onResponse(@NonNull Call<List<Breed>> call, @NonNull Response<List<Breed>> response) {

                    List<Breed> subBreedList = response.body();

                    breedListCallBack.breedListAvailable(subBreedList);

                }

                @Override
                public void onFailure(@NonNull Call<List<Breed>> call, Throwable t) {
                    Log.d("", "");
                }
            });


        }

    }

    private boolean hasLocalBreedList() {

        return false;
    }


    public void getBreedImageList(final String breedName, final Breed breed, final BreedImageCallBack breedImageCallBack) {


//        Call<List<String>> call = getDogBreedInterface().getBreedImageList(breedName);
//        call.enqueue(new Callback<List<String>>() {
//
//
//                         @Override
//                         public void onResponse(@NonNull Call<List<String>> call, @NonNull Response<List<String>> response) {
//
//                              List<String>>  = response.body();
//
//                             breedImageCallBack.breedImagesCompleted(breed);
//
//
//                         }
//
//                         @Override
//                         public void onFailure(@NonNull Call<List<String>> call, Throwable t) {
//                             Log.d("", "");
//                         }
//                     }
//
//
//        );


    }

    public void getSubBreedImageList(final String breedName, final String subBreedName, final BreedImageCallBack breedImageCallBack) {


    }
}














