package com.bastau.app.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponsePosts {

    @SerializedName("img_url")
    @Expose
    private String imgUrl;
    @SerializedName("post_url")
    @Expose
    private String postUrl;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("date")
    @Expose
    private Integer date;
    @SerializedName("owner")
    @Expose
    private ResponseOwner owner;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getPostUrl() {
        return postUrl;
    }

    public void setPostUrl(String postUrl) {
        this.postUrl = postUrl;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public ResponseOwner getOwner() {
        return owner;
    }

    public void setOwner(ResponseOwner owner) {
        this.owner = owner;
    }
}
