package com.schulz.erica.dogbreeds;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class TypeConverters {

    Gson gson = new Gson();

    @TypeConverter
    public List<Breed.BreedImage> stringToBreedImages(String data) {

        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Breed.BreedImage>>() {
        }.getType();

        return gson.fromJson( data, listType );
    }


    @TypeConverter
    public String BreedImagesToString(List<Breed.BreedImage> breedImages) {
        return gson.toJson(breedImages);
    }

    @TypeConverter
    public List<Breed> stringToSubBreeds(String data) {

        if (data == null) {
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Breed>>() {
        }.getType();

        return gson.fromJson( data, listType );
    }


    @TypeConverter
    public String BreedsToString(List<Breed> subBreeds) {
        return gson.toJson(subBreeds);
    }


    }


