package com.schulz.erica.dogbreeds.di;

import android.support.annotation.NonNull;

import com.schulz.erica.dogbreeds.Breed;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import timber.log.Timber;

public class DogBreedEnvelopeConverter implements Converter<ResponseBody, List<Breed>> {
    final Converter<ResponseBody, DogBreedEnvelope> delegateConverter;

    public DogBreedEnvelopeConverter(Converter<ResponseBody, DogBreedEnvelope> delegateConverter) {
        this.delegateConverter = delegateConverter;
    }

    @Nullable
    @Override
    public List<Breed> convert(@NonNull ResponseBody responseBody) throws IOException {
        DogBreedEnvelope dogBreedEnvelope = delegateConverter.convert(responseBody);

        List<Breed> breedList = new ArrayList<>();
        assert dogBreedEnvelope != null;
        List<String> breedNames = dogBreedEnvelope.getMessage();


        for (String breedName : breedNames) {
            Breed breed = new Breed();

            try {
                breed.setBreedName(breedName);
                breedList.add(breed);
                Timber.tag("log this").d(breedName);


            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        return breedList;
    }
}







