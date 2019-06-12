package com.bastau.app.ui.auth;

import com.arellomobile.mvp.InjectViewState;
import com.bastau.app.Bastau;
import com.bastau.app.data.network.ServiceNetwork;
import com.bastau.app.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class RegisterPresenter extends BasePresenter<RegisterView> {

    @Inject
    ServiceNetwork serviceNetwork;

    public RegisterPresenter() {
        Bastau.getApplicationComponent().inject(this);
    }

    public void registration(String phone, String password, String repeatPassword, String login, String instagram) {
        Disposable subscription = serviceNetwork.registration(phone, password,repeatPassword,login,instagram)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getViewState()::onLogged,
                        getViewState()::error);
        unsubscribeOnDestroy(subscription);
    }
}
