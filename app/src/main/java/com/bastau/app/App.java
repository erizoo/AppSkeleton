package com.bastau.app;

import android.app.Application;
import android.content.ContextWrapper;

import com.bastau.app.di.component.ApplicationComponent;
import com.bastau.app.di.component.DaggerApplicationComponent;
import com.bastau.app.di.module.ApplicationModule;
import com.pixplicity.easyprefs.library.Prefs;

public class App extends Application {

    private static ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);

    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
