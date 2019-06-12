package com.bastau.app.ui;

import com.arellomobile.mvp.MvpView;
import com.bastau.app.data.models.ResponseAuth;
import com.bastau.app.data.models.ResponseWrites;

public interface MainView extends MvpView {

    void onReceived(ResponseWrites responseWrites);

    void error(Throwable throwable);

    void onReceivedUser(ResponseAuth responseAuth);

    void onLiked(ResponseAuth responseAuth);
}
