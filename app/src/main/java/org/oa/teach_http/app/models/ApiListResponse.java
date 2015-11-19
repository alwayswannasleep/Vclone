package org.oa.teach_http.app.models;

import com.google.gson.annotations.SerializedName;

public class ApiListResponse<T> {

    @SerializedName("response")
    private ListResponse<T> mResponse;

    public ListResponse<T> getResponse() {
        return mResponse;
    }
}
