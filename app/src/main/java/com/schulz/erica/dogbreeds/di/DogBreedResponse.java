package com.schulz.erica.dogbreeds.di;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.schulz.erica.dogbreeds.Breed;
import com.schulz.erica.dogbreeds.BreedListCallBack;

import java.util.ArrayList;
import java.util.List;

public class DogBreedResponse {


    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private String message;

    private List<Breed> breedList = new ArrayList<>();
    private String breedName;
    private BreedListCallBack breedListCallBack;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Breed> getBreedList() {
        return breedList;
    }

    public void setBreedList(List<Breed> breedList) {
        this.breedList = breedList;
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public BreedListCallBack getBreedListCallBack() {
        return breedListCallBack;
    }

    public void setBreedListCallBack(BreedListCallBack breedListCallBack) {
        this.breedListCallBack = breedListCallBack;
    }
}


