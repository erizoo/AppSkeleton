package com.bastau.app.di.module;

import android.content.Context;

import com.bastau.app.Bastau;
import com.bastau.app.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Bastau application;

    public ApplicationModule(Bastau application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    Bastau provideApplication() {
        return application;
    }

}

