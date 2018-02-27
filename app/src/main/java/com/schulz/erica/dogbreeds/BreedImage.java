package com.schulz.erica.dogbreeds;

/**
 * Created by ericaschulz on 2/27/18.
 */

public class BreedImage {


    String message;
    String imageLink;



    public BreedImage() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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


