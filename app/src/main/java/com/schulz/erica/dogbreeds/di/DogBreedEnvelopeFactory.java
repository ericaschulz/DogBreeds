package com.schulz.erica.dogbreeds.di;

import com.google.gson.reflect.TypeToken;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.annotation.Nullable;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

class DogBreedEnvelopeFactory extends Converter.Factory {

    DogBreedEnvelopeFactory() {}

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {


        java.lang.reflect.Type envelopeType = new TypeToken<DogBreedEnvelope>(){}.getType();
    // then get the next available converter to do the actual conversion (e.g., \ 21 Gson)
        final Converter < ResponseBody, DogBreedEnvelope > delegateConverter = retrofit.nextResponseBodyConverter( this, envelopeType, annotations);
        // let the converter do the work

        return new DogBreedEnvelopeConverter( delegateConverter);



    }
}
