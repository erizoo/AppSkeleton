package com.bastau.app.di.component;

import com.bastau.app.di.PerScreen;
import com.bastau.app.di.module.ScreenModule;

import dagger.Component;

@PerScreen
@Component(modules = ScreenModule.class, dependencies = ApplicationComponent.class)
public interface ScreenComponent {

}
