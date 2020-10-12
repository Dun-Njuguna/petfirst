package com.freshfred.petfirst.data.service;

import com.freshfred.petfirst.data.models.DogBreed;
import com.freshfred.petfirst.data.rest.DogsApi;
import com.freshfred.petfirst.di.DaggerApiComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class DogsApiService {

    @Inject
    protected DogsApi api;

    public DogsApiService(){
        DaggerApiComponent.create().inject(this);
    }

    public Single<List<DogBreed>> getDogs(){
        return api.getDogs();
    }
}
