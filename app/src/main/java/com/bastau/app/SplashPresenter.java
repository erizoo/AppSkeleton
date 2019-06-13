package com.bastau.app;

import com.arellomobile.mvp.InjectViewState;
import com.bastau.app.data.network.ServiceNetwork;
import com.bastau.app.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class SplashPresenter extends BasePresenter<SplashView> {

    @Inject
    ServiceNetwork serviceNetwork;

    public SplashPresenter() {
        Bastau.getApplicationComponent().inject(this);
    }

    public void sendToken(String token) {
        Disposable subscription = serviceNetwork.sendToken(token)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getViewState()::onSended,
                        getViewState()::error);
        unsubscribeOnDestroy(subscription);
    }
}
