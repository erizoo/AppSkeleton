package com.bastau.app.di.module;

import android.content.Context;

import com.bastau.app.App;
import com.bastau.app.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final App application;

    public ApplicationModule(App application) {
        this.application = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return application;
    }

    @Provides
    App provideApplication() {
        return application;
    }

}

