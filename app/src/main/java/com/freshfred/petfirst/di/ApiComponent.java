package com.freshfred.petfirst.di;

import com.freshfred.petfirst.data.service.DogsApiService;

import javax.inject.Singleton;
import dagger.Component;

@Component(modules = {ApiModule.class})
public interface ApiComponent {
    void inject(DogsApiService dogsApiService);
}
