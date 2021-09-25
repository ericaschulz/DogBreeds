package com.schulz.erica.dogbreeds.di;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class BreedAndSubBreedEnvelope {



    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("message")
    @Expose
    private Map<String, List<String>> message;


    public Map<String, List<String>> getMessage() {
        return message;
    }



}
