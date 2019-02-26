package com.schulz.erica.dogbreeds;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericaschulz on 2/4/18.
 */

public class Breed {


    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("breedName")
    @Expose
    private String breedName;

    @SerializedName("subBreedName")
    @Expose
    private String subBreedName;

    @SerializedName("breedImages")
    @Expose
    private List<BreedImage> breedImages;

    @SerializedName("breedList")
    @Expose
    private List<Breed> breedList;

    @SerializedName("subBreeds")
    @Expose
    private List<Breed> subBreeds;


    public Breed() {
        this.breedImages = new ArrayList<>();
    }

    public String addImageForLink(String imageLink) {

        BreedImage breedImage = new BreedImage(imageLink);
        breedImages.add(breedImage);
        return imageLink;
    }

    public List<BreedImage> getBreedImages() {
        return breedImages;
    }

    public  List<Breed> getSubBreeds() {
        return subBreeds;
    }



    public String getBreedName() {

        return breedName;
    }

    public String getSubBreedName(){

        return subBreedName;

    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public void setSubBreedName(String subBreedName) {

        this.subBreedName = subBreedName;
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


    public class BreedImage {


        String imageMessage;
        String imageLink;
        String breedImageName;



        public BreedImage(String imageLink) {

            this.imageLink = imageLink;

        }


        public String getBreedImageName() {
            return breedImageName;
        }

        public void setBreedImageName(String breedImageName) {
            
            this.breedImageName = breedImageName;
        }

        public String getImageMessage() {
            return imageMessage;
        }

        public void setImageMessage(String message) {
            this.imageMessage = message;
        }

        public String getImageLink() {
            return imageLink;
        }


        public void setImageLink(String imageLink) {
            this.imageLink = imageLink;
        }


        @Override
        public String toString() {
            return imageLink;
        }
    }
}










