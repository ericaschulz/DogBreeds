package com.schulz.erica.dogbreeds;

//Need to encapsulate the image retrieving within this class, but it needs to happen after we've had the callback for the list of breeds


import org.json.JSONException;

public class DogBreedManager {

    Breed parentBreed;
    Breed subBreed;




    public void getBreedList(BreedListCallBack breedListCallBack) {


        if (this.hasLocalBreedList()) {

            //callback local database if true


        } else {

            BreedApiTask breedApiTask = new BreedApiTask(breedListCallBack);
            breedApiTask.execute();

        }


    }


    public void getSubBreedList(String breedName, BreedListCallBack breedListCallBack) {

        if (this.hasLocalBreedList()) {

            //callback local database if true


        } else {

            BreedApiTask subBreedApiTask = new BreedApiTask(breedName, breedListCallBack);
            subBreedApiTask.execute();


        }


    }


    private void getBreedList() {

    }

    private void getSubBreedList() {

    }


    public void getBreedImages(BreedImageApiTaskCallBack breedImageApiTaskCallBack) throws JSONException {

        try {

            if (this.hasLocalBreedImage()) {

                //callback local database if true

            } else {

                getBreedList();

                // if breedlist is != null, then

                BreedImageApiTask breedImageApiTask = new BreedImageApiTask(null, null, breedImageApiTaskCallBack);
                breedImageApiTask.execute();

            }


        } catch (JSONException e) {

        }


//        public void getSubBreedImages (BreedImageApiTaskCallBack breedImageApiTaskCallBack){
//
//
//            try {
//
//
//                if (this.hasLocalBreedImage()) {
//
//
//                } else {
//
//                    getSubBreedList();
//
//
//                    //if subBreedList != null then
//
//                    BreedImageApiTask subBreedImageApiTask = new BreedImageApiTask(parentBreed, subBreed, breedImageApiTaskCallBack);
//                    subBreedImageApiTask.execute();
//                }
//            } catch (JSONException e) {
//
//
//            }
        }



    private boolean hasLocalBreedList() {

        return false;
    }

    private boolean hasLocalBreedImage() {

        return false;

    }



    }


