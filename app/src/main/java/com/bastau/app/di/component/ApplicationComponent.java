package com.bastau.app.di.component;

import android.content.Context;

import com.bastau.app.App;
import com.bastau.app.ui.MainPresenter;
import com.bastau.app.ui.auth.AuthPresenter;
import com.bastau.app.data.network.ServiceNetwork;
import com.bastau.app.di.ApplicationContext;
import com.bastau.app.di.module.ApiModule;
import com.bastau.app.di.module.ApplicationModule;
import com.bastau.app.di.module.ScreenModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class, ApplicationModule.class, ScreenModule.class})
public interface ApplicationComponent {

    void inject(App application);

    @ApplicationContext
    Context context();

    ServiceNetwork serviceNewrok();

    void inject(AuthPresenter presenter);

    void inject(MainPresenter presenter);
}

