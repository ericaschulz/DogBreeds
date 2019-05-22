package com.schulz.erica.dogbreeds.di;

import java.io.IOException;
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
    public List<String> convert(ResponseBody responseBody) throws IOException {
        DogBreedImageEnvelope dogBreedImageEnvelope = delegateConverter.convert(responseBody);


        List<String> imageLinks = dogBreedImageEnvelope.getMessage();


        return imageLinks;
    }

}


