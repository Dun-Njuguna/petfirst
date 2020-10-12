package com.freshfred.petfirst.di;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;

import com.freshfred.petfirst.util.SharedPreferencesHelper;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PrefsModule {

    public static final String CONTEXT_APP = "application context";
    public static final String CONTEXT_ACTIVITY = "activity context";

    @Provides
    @Singleton
    @Named(CONTEXT_APP)
    SharedPreferencesHelper provideSharePreferences(Application application) {
        return new SharedPreferencesHelper(application);
    }

    @Provides
    @Singleton
    @Named(CONTEXT_ACTIVITY)
    SharedPreferencesHelper provideActivitySharedPrefs(AppCompatActivity activity) {
        return new SharedPreferencesHelper(activity);
    }

}





