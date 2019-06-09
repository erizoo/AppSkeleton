package com.bastau.app.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseAuth {

    @SerializedName("ok")
    @Expose
    private Boolean ok;
    @SerializedName("profile_pic_url_hd")
    @Expose
    private String profilePicUrlHd;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("instausername")
    @Expose
    private String instausername;
    @SerializedName("was_liked")
    @Expose
    private Integer wasLiked;
    @SerializedName("put_likes")
    @Expose
    private Integer putLikes;
    @SerializedName("points")
    @Expose
    private Integer points;
    @SerializedName("status")
    @Expose
    private Integer status;

    public Boolean getOk() {
        return ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public String getProfilePicUrlHd() {
        return profilePicUrlHd;
    }

    public void setProfilePicUrlHd(String profilePicUrlHd) {
        this.profilePicUrlHd = profilePicUrlHd;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getInstausername() {
        return instausername;
    }

    public void setInstausername(String instausername) {
        this.instausername = instausername;
    }

    public Integer getWasLiked() {
        return wasLiked;
    }

    public void setWasLiked(Integer wasLiked) {
        this.wasLiked = wasLiked;
    }

    public Integer getPutLikes() {
        return putLikes;
    }

    public void setPutLikes(Integer putLikes) {
        this.putLikes = putLikes;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
