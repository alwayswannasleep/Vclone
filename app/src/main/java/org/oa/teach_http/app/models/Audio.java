package org.oa.teach_http.app.models;

import com.google.gson.annotations.SerializedName;

public class Audio {

    @SerializedName("aid")
    private long mAid;

    @SerializedName("owner_id")
    private long mOwnerId;

    @SerializedName("artist")
    private String mArtist;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("duration")
    private int mDuration;

    @SerializedName("url")
    private String mUrl;

    public long getAid() {
        return mAid;
    }

    public void setAid(long aid) {
        mAid = aid;
    }

    public long getOwnerId() {
        return mOwnerId;
    }

    public void setOwnerId(long ownerId) {
        mOwnerId = ownerId;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public int getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "mAid=" + mAid +
                ", mOwnerId=" + mOwnerId +
                ", mArtist='" + mArtist + '\'' +
                ", mTitle='" + mTitle + '\'' +
                ", mDuration=" + mDuration +
                ", mUrl='" + mUrl + '\'' +
                '}';
    }
}
