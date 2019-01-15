package com.schulz.erica.dogbreeds;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericaschulz on 2/4/18.
 */

public class Breed {

//    public class QuestionSchema {
//
//        @SerializedName("title")
//        private final String mTitle;
//
//        @SerializedName("question_id")
//        private final String mId;
//
//        @SerializedName("body")
//        private final String mBody;
//
//        @SerializedName("owner")
//        private final UserSchema mOwner;
//
//        public QuestionSchema(String title, String id, String body, UserSchema owner) {
//            mTitle = title;
//            mId = id;
//            mBody = body;
//            mOwner = owner;
//        }
//
//        public String getTitle() {
//            return mTitle;
//        }
//
//        public String getId() {
//            return mId;
//        }
//
//        public String getBody() {
//            return mBody;
//        }
//
//        public UserSchema getOwner() {
//            return mOwner;
//        }
//    }



    private String message;
    private String breedName;
    private String subBreedName;
    private List<BreedImage> breedImages;


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










