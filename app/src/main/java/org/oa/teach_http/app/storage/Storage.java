package org.oa.teach_http.app.storage;

import android.content.Context;

import org.oa.teach_http.app.models.User;
import org.oa.teach_http.app.service.ApiService;
import org.oa.teach_http.app.service.ResponseListener;
import org.oa.teach_http.app.storage.repository.RepositorySession;

import java.util.List;

public class Storage {

    public static final int DB_RESPONSE = 0;

    public static final int VK_RESPONSE = 1;

    private Context mContext;

    private ApiService.ApiWorker mApiService;

    private RepositorySession mSession;

    public Storage(Context context, ApiService.ApiWorker apiService) {
        mContext = context;
        mApiService = apiService;
        mSession = new RepositorySession(mContext);
    }

    public void getFriends(final StorageResponseListener<User> responseListener) {
        mSession.getUserRepository().getFriends(new ResponseListener<User>() {
            @Override
            public void onResponse(List<User> items) {
                if (items != null) {
                    responseListener.onResponse(items, DB_RESPONSE);
                }
            }
        });

        mApiService.getFriends(new ResponseListener<User>() {
            @Override
            public void onResponse(List<User> items) {
                mSession.getUserRepository().insertOrReplace(items);
                responseListener.onResponse(items, VK_RESPONSE);
            }
        });
    }

    public void closeStorage() {
        mSession.closeDatabase();
    }
}
