package com.bastau.app.ui.auth;

import com.arellomobile.mvp.MvpView;
import com.bastau.app.data.models.ResponseAuth;

public interface RegisterView extends MvpView {

    void onSuccess(ResponseAuth responseAuth);

    void error(Throwable throwable);
}
