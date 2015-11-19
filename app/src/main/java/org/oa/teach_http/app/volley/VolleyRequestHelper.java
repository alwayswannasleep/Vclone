package org.oa.teach_http.app.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyRequestHelper {
    private static volatile VolleyRequestHelper mInstance;
    private RequestQueue mRequestQueue;
    private static Context mContext;

    private VolleyRequestHelper(Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue();
    }

    public static VolleyRequestHelper getInstance(Context context) {
        VolleyRequestHelper localInstance = mInstance;
        if (localInstance == null) {
            synchronized (VolleyRequestHelper.class) {
                localInstance = mInstance;
                if (localInstance == null) {
                    localInstance = mInstance = new VolleyRequestHelper(context);
                }
            }
        }
        return localInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }

        return mRequestQueue;
    }

    public <T> void addRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }
}
