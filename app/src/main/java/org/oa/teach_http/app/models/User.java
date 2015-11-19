package org.oa.teach_http.app.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class User implements Parcelable {

    @SerializedName("id")
    private long mUid;

    @SerializedName("first_name")
    private String mFirstName;

    @SerializedName("last_name")
    private String mLastName;

    @SerializedName("online")
    private int mStatusOnline;

    @SerializedName("photo_100")
    private String mPhotoURL;

    private int mStorageId;

    public User() {

    }

    public long getUid() {
        return mUid;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public int getStatusOnline() {
        return mStatusOnline;
    }

    public String getPhotoURL() {
        return mPhotoURL;
    }

    public void setUid(long uid) {
        mUid = uid;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public void setStatusOnline(int statusOnline) {
        mStatusOnline = statusOnline;
    }

    public void setPhotoURL(String photoURL) {
        mPhotoURL = photoURL;
    }

    public int getStorageId() {
        return mStorageId;
    }

    public void setStorageId(int storageId) {
        mStorageId = storageId;
    }

    @Override
    public String toString() {
        return "User{" +
                "mUid=" + mUid +
                ", mFirstName='" + mFirstName + '\'' +
                ", mLastName='" + mLastName + '\'' +
                ", mStatusOnline=" + mStatusOnline +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mUid);
        dest.writeString(mFirstName);
        dest.writeString(mLastName);
        dest.writeString(mPhotoURL);
        dest.writeInt(mStatusOnline);
        dest.writeInt(mStorageId);
    }

    private User(Parcel parcel) {
        mUid = parcel.readLong();
        mFirstName = parcel.readString();
        mLastName = parcel.readString();
        mPhotoURL = parcel.readString();
        mStatusOnline = parcel.readInt();
        mStorageId = parcel.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[0];
        }
    };
}
