package com.bastau.app.data.network;

import com.bastau.app.data.models.RequestAuth;
import com.bastau.app.data.models.ResponseAuth;
import com.bastau.app.data.models.ResponseWrites;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ServiceNetworkImp implements ServiceNetwork {

    private ApiMethods apiMethods;

    @Inject
    public ServiceNetworkImp(ApiMethods apiMethods) {
        this.apiMethods = apiMethods;
    }

    @Override
    public Observable<ResponseAuth> singInAuth(String login, String password) {
        return apiMethods.singInAuth(login, password);
    }

    @Override
    public Observable<ResponseWrites> getPosts(String login, String password) {
        return apiMethods.getPosts(login, password);
    }

    @Override
    public Observable<ResponseAuth> getUser(String login, String password) {
        return apiMethods.singInAuth(login, password);
    }

    @Override
    public Observable<ResponseAuth> like(String login, String password, String username) {
        return apiMethods.like(login, password, username);
    }

    @Override
    public Observable<ResponseAuth> registration(String phone, String password, String login, String instagram) {
        return apiMethods.registration(phone, password, login, instagram);
    }

    @Override
    public Observable<ResponseAuth> sendToken(String token) {
        return apiMethods.sendToken(token);
    }
}
