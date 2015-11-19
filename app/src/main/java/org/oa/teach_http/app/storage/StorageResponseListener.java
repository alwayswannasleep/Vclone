package org.oa.teach_http.app.storage;

import android.support.annotation.Nullable;

import java.util.List;

public interface StorageResponseListener<T> {

    void onResponse(@Nullable List<T> items, int responseType);

}
