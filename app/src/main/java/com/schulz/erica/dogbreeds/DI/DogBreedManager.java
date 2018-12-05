package com.schulz.erica.dogbreeds.DI;

//Need to encapsulate the image retrieving within this class, but it needs to happen after we've had the callback for the list of breeds


import android.annotation.SuppressLint;

import com.schulz.erica.dogbreeds.Breed;
import com.schulz.erica.dogbreeds.BreedApiTask;
import com.schulz.erica.dogbreeds.BreedImageApiTask;
import com.schulz.erica.dogbreeds.BreedImageApiTaskCallBack;
import com.schulz.erica.dogbreeds.BreedListCallBack;
import com.schulz.erica.dogbreeds.BreedRecyclerViewAdapter;

import org.json.JSONException;

import java.util.List;

import timber.log.Timber;

public class DogBreedManager {

    Breed parentBreed;
    Breed currentBreed;
    BreedRecyclerViewAdapter breedRecyclerViewAdapter;




    public void getBreedList(BreedListCallBack breedListCallBack) {


        if (this.hasLocalBreedList()) {

            //callback local database if true


        } else {

            BreedApiTask breedApiTask = new BreedApiTask(new BreedListCallBack() {
                @Override
                public void breedListAvailable(List<Breed> breedList) {

                    //we need to get the images

                    for (Breed currentBreed : breedList) {
                        String breedName = currentBreed.getBreedName();
                        Timber.tag("log this").d(breedName);

                    }

                    try {

                        if (parentBreed != null){

                        BreedImageApiTask subBreedImageApiTask = new BreedImageApiTask(parentBreed, currentBreed, new BreedImageApiTaskCallBack() {
                            @Override
                            public void breedImageApiTaskCompleted(Breed breed) {


                                breedRecyclerViewAdapter.breedImagesReadyForBreed(breed);


                                Timber.tag("log this").d(parentBreed + " has images.");

                            }
                        });

                        subBreedImageApiTask.execute();


                    } else {

                        @SuppressLint("StaticFieldLeak") BreedImageApiTask breedImageApiTask = new BreedImageApiTask(currentBreed, null, new BreedImageApiTaskCallBack() {
                            @Override
                            public void breedImageApiTaskCompleted(Breed breed) {

                                breedRecyclerViewAdapter.breedImagesReadyForBreed(breed);

                            }
                        }){

                        };

                        breedImageApiTask.execute();

                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }




            });

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


    public void getBreedImages(BreedListCallBack breedListCallBack, BreedImageApiTaskCallBack breedImageApiTaskCallBack) throws JSONException {

        try {

            if (this.hasLocalBreedImage()) {

                //callback local database if true

            } else {

                getBreedList();

                // if breedList is != null, then

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
//        }



    }
    private boolean hasLocalBreedList() {
        return false;
    }
    private boolean hasLocalBreedImage() {
        return false;
    }


}



