package org.oa.teach_http.app.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UsersListResponse<T> {

    @SerializedName("response")
    private List<T> mReponse;

    public List<T> getReponse() {
        return mReponse;
    }
}
