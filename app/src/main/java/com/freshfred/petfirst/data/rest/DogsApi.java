package com.freshfred.petfirst.data.rest;

import com.freshfred.petfirst.data.models.DogBreed;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface DogsApi {

    @GET("DevTides/DogsApi/master/dogs.json")
    Single<List<DogBreed>> getDogs();

}
