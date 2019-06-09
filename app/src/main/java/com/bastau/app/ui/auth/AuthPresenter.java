package com.bastau.app.ui.auth;

import com.arellomobile.mvp.InjectViewState;
import com.bastau.app.App;
import com.bastau.app.ui.base.BasePresenter;
import com.bastau.app.data.network.ServiceNetwork;
import com.pixplicity.easyprefs.library.Prefs;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class AuthPresenter extends BasePresenter<AuthView> {

    @Inject
    ServiceNetwork serviceNetwork;

    public AuthPresenter() {
        App.getApplicationComponent().inject(this);
    }

    public void singInAuth(String login, String password) {
        Prefs.putString("LOGIN", login);
        Prefs.putString("PASSWORD", password);
        Disposable subscription = serviceNetwork.singInAuth(login, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getViewState()::onLogged,
                        getViewState()::error);
        unsubscribeOnDestroy(subscription);
    }

}
