package com.schulz.erica.dogbreeds.di;


import android.util.Log;

import androidx.annotation.NonNull;

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

    private Retrofit dogBreedListRetrofit;
    private Retrofit dogBreedImageListRetrofit;
    private static final String BASE_URL = "https://dog.ceo/api/";
    private DogBreedEnvelope dogBreedEnvelope;
    private DogBreedImageEnvelope dogBreedImageEnvelope;




    public DogBreedManager() {

        if (dogBreedListRetrofit == null) {
            dogBreedListRetrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(new DogBreedEnvelopeFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();



        }



        if (dogBreedImageListRetrofit == null) {
                dogBreedImageListRetrofit = new retrofit2.Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(new DogBreedImageEnvelopeFactory())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
        }


    }

    public DogBreedInterface getDogBreedInterface() {

        return dogBreedListRetrofit.create(DogBreedInterface.class);

    }

    public DogBreedInterface getDogBreedImagesInterface() {

        return dogBreedImageListRetrofit.create(DogBreedInterface.class);
    }

    public void setDogBreedEnvelope(DogBreedEnvelope dogBreedEnvelope) {
        this.dogBreedEnvelope = dogBreedEnvelope;
    }
    public void setDogBreedImageEnvelope(DogBreedImageEnvelope dogBreedImageEnvelope) {
        this.dogBreedImageEnvelope = dogBreedImageEnvelope;
    }


    public DogBreedEnvelope getDogBreedEnvelope() {
        return dogBreedEnvelope;
    }

    public DogBreedImageEnvelope getDogBreedImageEnvelope() {
        return dogBreedImageEnvelope;
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

    public void getBreedImageList(final String breedName, final Breed parentBreed, final BreedImageCallBack breedImageCallBack) {


        Call<List<String>> call = getDogBreedImagesInterface().getBreedImageList(breedName);
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {


                List<String> imageLinks = response.body();


                if (imageLinks != null) {
                    parentBreed.setBreedName(breedName);

                    int size = imageLinks.size();


                    for (int i = 0; i < size; i++) {

                        try {
                            String imageLink = imageLinks.get(i);
                            parentBreed.addImageForLink(imageLink);
                            breedImageCallBack.breedImagesCompleted(parentBreed);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable throwable) {

            }
        });


    }

    public void getSubBreedImageList(final String breedName, final String subBreedName, final Breed parentBreed, final Breed currentBreed, final BreedImageCallBack breedImageCallBack) {

        Call<List<String>> call = getDogBreedImagesInterface().getSubBreedImageList(breedName, subBreedName);
        call.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {


                    List<String> imageLinks = response.body();
                    assert imageLinks != null;
                    for (String imageLink : imageLinks) {


                        currentBreed.addImageForLink(imageLink);
                    }

                    breedImageCallBack.breedImagesCompleted(currentBreed);

                }




            @Override
            public void onFailure(Call<List<String>> call, Throwable throwable) {

            }

        });
    }





    private boolean hasLocalBreedList() {

        return false;
    }



}














