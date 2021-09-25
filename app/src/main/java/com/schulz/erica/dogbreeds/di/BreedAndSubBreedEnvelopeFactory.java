//package com.schulz.erica.dogbreeds.di;
//
//import com.google.gson.reflect.TypeToken;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Type;
//
//import javax.annotation.Nullable;
//
//import okhttp3.ResponseBody;
//import retrofit2.Converter;
//import retrofit2.Retrofit;
//
//public class BreedAndSubBreedEnvelopeFactory extends Converter.Factory {
//
//
//    BreedAndSubBreedEnvelopeFactory() {}
//
//
//    @Nullable
//    @Override
//
//    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
//
//
//        java.lang.reflect.Type envelopeType = new TypeToken<BreedAndSubBreedEnvelope>(){}.getType();
//
//        final Converter < ResponseBody, BreedAndSubBreedEnvelope > delegateConverter = retrofit.nextResponseBodyConverter( this, envelopeType, annotations);
//
//
//        return new BreedAndSubBreedEnvelopeConverter(delegateConverter);
//
//
//
//    }
//}
