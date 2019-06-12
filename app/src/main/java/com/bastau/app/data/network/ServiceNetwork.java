package com.bastau.app.data.network;

import com.bastau.app.data.models.ResponseAuth;
import com.bastau.app.data.models.ResponseWrites;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface ServiceNetwork {

    Observable<ResponseAuth> singInAuth(String login, String password);

    Observable<ResponseWrites> getPosts(String login, String password);

    Observable<ResponseAuth> getUser(String login, String password);

    Observable<ResponseAuth> like(String login, String password, String username);

    Observable<ResponseAuth> registration(String phone, String password, String login, String instagram);
}
