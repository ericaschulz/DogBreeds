package com.schulz.erica.dogbreeds.di;

import android.support.annotation.NonNull;

import com.schulz.erica.dogbreeds.Breed.BreedImage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import okhttp3.ResponseBody;
import retrofit2.Converter;

public class DogBreedImageEnvelopeConverter implements Converter<ResponseBody, List<String>> {

    final Converter<ResponseBody, DogBreedImageEnvelope> delegateConverter;

    public DogBreedImageEnvelopeConverter(Converter<ResponseBody, DogBreedImageEnvelope> delegateConverter) {
        this.delegateConverter = delegateConverter;
    }

    @Nullable
    @Override
    public List<String> convert(@NonNull ResponseBody responseBody) throws IOException {
        DogBreedImageEnvelope dogBreedImageEnvelope = delegateConverter.convert(responseBody);


        assert dogBreedImageEnvelope != null;
        List<String> imageLinks = dogBreedImageEnvelope.getMessage();

        List<BreedImage> breedImageList = new ArrayList<>();

        for (String imageLink : imageLinks) {


            BreedImage breedImage = new BreedImage(imageLink);
            breedImage.setImageLink(imageLink);
            breedImageList.add(breedImage);


        }

        return imageLinks;
    }

}


