package com.schulz.erica.dogbreeds;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericaschulz on 2/4/18.
 */


@Entity (tableName = "breed_table")


public class Breed {

    @PrimaryKey
    @NonNull

    @ColumnInfo(name = "breed")
    private String breed;

    @ColumnInfo(name= "status")
    private String status;

    @ColumnInfo(name= "message")
    private String message;

    @ColumnInfo(name = "breedName")
    private String breedName;

    @ColumnInfo(name = "subBreedName")
    private String subBreedName;






    @ColumnInfo(name = "breedImages")
    @TypeConverters(com.schulz.erica.dogbreeds.TypeConverters.class)
    private List<BreedImage> breedImages;

    @ColumnInfo(name = "subBreeds")
    @TypeConverters(com.schulz.erica.dogbreeds.TypeConverters.class)
    private List<Breed> subBreeds;





    public Breed(@NonNull String breed) {
        this.breed = breed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBreed() {
        return this.breed;
    }


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


    public void setBreed(@NonNull String breed) {
        this.breed = breed;
    }

    public void setBreedImages(List<BreedImage> breedImages) {
        this.breedImages = breedImages;
    }

    public void setSubBreeds(List<Breed> subBreeds) {
        this.subBreeds = subBreeds;
    }

    public String getBreedName() {

        return breedName;
    }

    public String getSubBreedName() {

        return subBreedName;}


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










