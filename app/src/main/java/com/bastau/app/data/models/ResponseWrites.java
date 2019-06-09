package com.bastau.app.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseWrites {

    @SerializedName("ok")
    @Expose
    private boolean isOk;
    @SerializedName("posts")
    @Expose
    private List<ResponsePosts> posts;
    @SerializedName("user")
    @Expose
    private ResponseUser user;

    public boolean isOk() {
        return isOk;
    }

    public void setOk(boolean ok) {
        isOk = ok;
    }

    public List<ResponsePosts> getPosts() {
        return posts;
    }

    public void setPosts(List<ResponsePosts> posts) {
        this.posts = posts;
    }

    public ResponseUser getUser() {
        return user;
    }

    public void setUser(ResponseUser user) {
        this.user = user;
    }
}
