package com.schulz.erica.dogbreeds.di;

import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class DogBreedImageEnvelopeFactory extends Converter.Factory {

    DogBreedImageEnvelopeFactory() {
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {


        java.lang.reflect.Type envelopeType = new TypeToken<DogBreedImageEnvelope>() {
        }.getType();
        // then get the next available converter to do the actual conversion (e.g., \ 21 Gson)
        final Converter<ResponseBody, DogBreedImageEnvelope> delegateConverter = retrofit.nextResponseBodyConverter(this, envelopeType, annotations);
        // let the converter do the work

        return new DogBreedImageEnvelopeConverter(delegateConverter);


    }
}
