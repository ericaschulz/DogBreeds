package com.schulz.erica.dogbreeds;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ericaschulz on 2/4/18.
 */

public class Breed {

    @SerializedName("message")

    private String message;


    @SerializedName("breed_name")


     private String breedName;


    public Breed() {
    }

    public String getBreedName() {

        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public String toString() {


        return breedName;
    }







}
