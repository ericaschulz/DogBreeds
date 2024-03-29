package com.schulz.erica.dogbreeds.di;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DogBreedEnvelope {


    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private List<String> message;


    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }





    }



