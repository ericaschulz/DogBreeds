package com.schulz.erica.dogbreeds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericaschulz on 2/4/18.
 */

public class Breed {


    private String message;
    private String breedName;
    private List<BreedImage> breedImages;


    public Breed() {
        this.breedImages =  new ArrayList<>();
    }

    public void addImageForLink(String imageLink) {

        BreedImage breedImage = new BreedImage(imageLink);
        breedImages.add(breedImage);
    }

    public List<BreedImage> getBreedImages() {
        return breedImages;
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

    public class BreedImage {


        String imageMessage;
        String imageLink;
        String breedImageName;



        public BreedImage(String imageLink) {

            this.imageLink = imageLink;

        }

        public String getBreedImageName() {return breedImageName;}

        public void setBreedImageName(String breedImageName) {this.breedImageName = breedImageName;}

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

