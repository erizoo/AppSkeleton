package com.bastau.app.ui;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.bastau.app.App;
import com.bastau.app.data.network.ServiceNetwork;
import com.bastau.app.ui.base.BasePresenter;
import com.pixplicity.easyprefs.library.Prefs;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainPresenter extends BasePresenter<MainView> {

    @Inject
    ServiceNetwork serviceNetwork;

    public MainPresenter() {
        App.getApplicationComponent().inject(this);
    }

    public void getPosts() {
        String login = Prefs.getString("LOGIN", "");
        String password = Prefs.getString("PASSWORD", "");
        Disposable subscription = serviceNetwork.getPosts(login, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getViewState()::onReceived,
                        getViewState()::error);
        unsubscribeOnDestroy(subscription);
    }

    public void getUser() {
        String login = Prefs.getString("LOGIN", "");
        String password = Prefs.getString("PASSWORD", "");
        Disposable subscription = serviceNetwork.getUser(login, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getViewState()::onReceivedUser,
                        getViewState()::error);
        unsubscribeOnDestroy(subscription);
    }
}
