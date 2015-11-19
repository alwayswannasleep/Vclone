package org.oa.teach_http.app.models;

import com.google.gson.annotations.SerializedName;

public class Group {

    @SerializedName("id")
    private long mGroupId;

    @SerializedName("name")
    private String mName;

    @SerializedName("screen_name")
    private String mScreenName;

    @SerializedName("is_closed")
    private int mIsClosed;

    @SerializedName("type")
    private String mType;

    @SerializedName("photo_100")
    private String mPhoto100;

    public long getGroupId() {
        return mGroupId;
    }

    public void setGroupId(long groupId) {
        mGroupId = groupId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getScreenName() {
        return mScreenName;
    }

    public void setScreenName(String screenName) {
        mScreenName = screenName;
    }

    public int getIsClosed() {
        return mIsClosed;
    }

    public void setIsClosed(int isClosed) {
        mIsClosed = isClosed;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public String getPhoto100() {
        return mPhoto100;
    }

    public void setPhoto100(String photo100) {
        mPhoto100 = photo100;
    }

    @Override
    public String toString() {
        return "Group{" +
                "mGroupId=" + mGroupId +
                ", mName='" + mName + '\'' +
                ", mScreenName='" + mScreenName + '\'' +
                ", mIsClosed=" + mIsClosed +
                ", mType='" + mType + '\'' +
                ", mPhoto100='" + mPhoto100 + '\'' +
                '}';
    }
}
