package com.bastau.app.ui.auth;

import com.arellomobile.mvp.MvpView;
import com.bastau.app.data.models.ResponseAuth;

public interface AuthView extends MvpView {

    void onLogged(ResponseAuth responseAuth);

    void error(Throwable throwable);
}
