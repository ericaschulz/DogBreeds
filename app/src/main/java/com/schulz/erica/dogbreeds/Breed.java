package com.schulz.erica.dogbreeds;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.List;

/**
 * Created by ericaschulz on 2/4/18.
 */


@Entity (tableName = "breed_table")


public class Breed {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;


    @Nullable
    @ColumnInfo(name = "breed")
    private String breed;

    @Nullable
    @ColumnInfo(name = "status")
    private String status;


    @Nullable
    @ColumnInfo(name = "breedName")
    private String breedName;


    @Nullable
    @ColumnInfo(name = "subBreedName")
    private String subBreedName;

    @Nullable
    @ColumnInfo(name = "breedImages")
    @TypeConverters(com.schulz.erica.dogbreeds.TypeConverters.class)
    private List<BreedImage> breedImages;


    @Nullable
    @ColumnInfo(name = "subBreeds")
    @TypeConverters(com.schulz.erica.dogbreeds.TypeConverters.class)
    private List<Breed> subBreeds;

    public Breed() {

    }


    public int getId(){return this.id;}

    public void setId(int id){
        this.id = id;
    }


    public Breed ( String breed) {
        this.breed = breed;
    }

    @Nullable
    String getStatus() {
        return status;
    }


    void setStatus(String status) {
        this.status = status;
    }


    @NonNull
    public String getBreed() {
        return this.breed;
    }

    @Nullable
    public String addImageForLink(String imageLink) {

        BreedImage breedImage = new BreedImage( imageLink );
        breedImages.add( breedImage );
        return imageLink;
    }

    @Nullable
    List<BreedImage> getBreedImages() {
        return breedImages;
    }

    @Nullable
    List<Breed> getSubBreeds() {
        return subBreeds;
    }


    public void setBreed(@NonNull String breed) {
        this.breed = breed;
    }


    void setBreedImages(@Nullable List<BreedImage> breedImages) {
        this.breedImages = breedImages;
    }


    void setSubBreeds(@Nullable List<Breed> subBreeds) {
        this.subBreeds = subBreeds;
    }


    @Nullable
    String getBreedName() {

        return breedName;
    }

    @Nullable
    String getSubBreedName() {

        return subBreedName;
    }



    public void setBreedName(@Nullable String breedName) {
        this.breedName = breedName;
    }


    void setSubBreedName(@Nullable String subBreedName) {

        this.subBreedName = subBreedName;
    }



    public static class BreedImage {

        String imageLink;


        public BreedImage(String imageLink) {

            this.imageLink = imageLink;

        }


        String getImageLink() {
            return imageLink;
        }


        public void setImageLink(String imageLink) {
            this.imageLink = imageLink;
        }

    }
}










