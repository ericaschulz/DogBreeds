package com.schulz.erica.dogbreeds;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ericaschulz on 2/4/18.
 */

public class Breed {

    private String status;
    private String message;
    private String breedName;
    private String subBreedName;
    private List<BreedImage> breedImages;
    private Map<String, List<String>> breedsAndSubBreeds;



    public List<Breed> subBreeds;


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


    public Map<String, List<String>> getBreedsAndSubBreedsMap() {
        return breedsAndSubBreeds;
    }

    public  List<Breed> getSubBreeds() {
        return subBreeds;
    }





    public String getBreedName() {

        return breedName;
    }
//    public String getSubBreedName {
//
//        return subBreedName;}


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


    public static class BreedImage {


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










