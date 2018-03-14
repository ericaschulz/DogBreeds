package com.schulz.erica.dogbreeds;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ericaschulz on 3/12/18.
 */

public class BreedApiResponse {

    @SerializedName("message")

    private String message;


    @SerializedName("breed_name")

    private String breedName;


    @SerializedName("breed_list")

    private List<Breed> breedList;



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }
}



