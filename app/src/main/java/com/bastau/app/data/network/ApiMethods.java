package com.bastau.app.data.network;


import com.bastau.app.data.models.ResponseAuth;
import com.bastau.app.data.models.ResponseWrites;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiMethods {

    @GET("news/get_user/")
    Observable<ResponseAuth> singInAuth(@Query("login") String login,
                                        @Query("password") String password);
    @GET("news/get_posts_for_user")
    Observable<ResponseWrites> getPosts(@Query("login") String login,
                                        @Query("password") String password);
}
