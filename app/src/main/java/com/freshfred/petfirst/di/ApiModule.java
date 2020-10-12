package com.freshfred.petfirst.di;

import com.freshfred.petfirst.data.rest.DogsApi;
import com.freshfred.petfirst.data.service.DogsApiService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    private static final String BASE_URL = "https://raw.githubusercontent.com/";

    @Provides
    public DogsApi provideDogApi() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(DogsApi.class);
    }

    @Provides
    public DogsApiService provideDogApiService() {
        return new DogsApiService();
    }
}
