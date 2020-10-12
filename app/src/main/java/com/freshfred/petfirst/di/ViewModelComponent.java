package com.freshfred.petfirst.di;

import com.freshfred.petfirst.viewmodel.ListViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class, PrefsModule.class, AppModule.class})
public interface ViewModelComponent {
    void inject(ListViewModel listViewModel);
}
