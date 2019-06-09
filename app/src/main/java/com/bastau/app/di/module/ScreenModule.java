package com.bastau.app.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.bastau.app.di.ActivityContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ScreenModule {

    private final AppCompatActivity activity;

    public ScreenModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return activity;
    }

}
