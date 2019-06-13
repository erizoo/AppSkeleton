package com.bastau.app;

import com.arellomobile.mvp.MvpView;
import com.bastau.app.data.models.ResponseAuth;

public interface SplashView extends MvpView {
    
    void onSended(ResponseAuth responseAuth);

    void error(Throwable throwable);
}
