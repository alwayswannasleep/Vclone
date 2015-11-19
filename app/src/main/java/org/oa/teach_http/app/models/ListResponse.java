package org.oa.teach_http.app.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListResponse<T> {

    @SerializedName("count")
    private int mCount;

    @SerializedName("items")
    private List<T> mItems;

    public int getCount() {
        return mCount;
    }

    public List<T> getItems() {
        return mItems;
    }
}
