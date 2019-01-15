package com.schulz.erica.dogbreeds.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module


public class DogBreedModule {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://dog.ceo/api/";

    @Provides
    @Singleton
    public Retrofit getRetrofitInstance() {

        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }

        return retrofit;
    }


//    @Provides
//    @Singleton
//    DogBreedManager provideDogBreedManager() {
//
//        DogBreedManager dogBreedManager = new DogBreedManager();
//
//        return dogBreedManager;
//    }





}



