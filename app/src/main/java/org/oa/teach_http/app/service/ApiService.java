package org.oa.teach_http.app.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.oa.teach_http.app.models.ApiListResponse;
import org.oa.teach_http.app.models.Audio;
import org.oa.teach_http.app.models.Group;
import org.oa.teach_http.app.models.User;
import org.oa.teach_http.app.session.Session;
import org.oa.teach_http.app.session.SessionStore;
import org.oa.teach_http.app.volley.GsonRequest;
import org.oa.teach_http.app.volley.VolleyRequestHelper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ApiService extends Service {
    private static final String TAG = ApiService.class.getSimpleName();

    public static class ApiWorker extends Binder {

        private static final String VK_FRIENDS_FIELD_VALUE = "uid,first_name,last_name," +
                "photo_100,online";

        private static final String VK_FRIENDS_ORDER_VALUE = "hints";

        private static final String VK_GROUPS_EXTENDED_VALUE = "1";

        private final Executor mExecutor = Executors.newSingleThreadExecutor();

        private final Session mSession;

        private final Context mContext;

        private final Handler mHandler = new Handler(Looper.getMainLooper());

        public ApiWorker(Session session, Context context) {
            mSession = session;
            mContext = context;
        }

        public void getFriends(final ResponseListener<User> listener, long... uids) {
            mExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    String accessToken = mSession.getAccessToken();

                    ApiRequestBuilder request =
                            new ApiRequestBuilder(ApiRequestBuilder.VK_METHOD_FRIENDS_GET, accessToken);
                    request.addParam(ApiRequestBuilder.VK_USERS_GET_FIELDS, VK_FRIENDS_FIELD_VALUE)
                            .addParam(ApiRequestBuilder.VK_FRIENDS_GET_ORDER, VK_FRIENDS_ORDER_VALUE);

                    Type fooType = new TypeToken<ApiListResponse<User>>() {
                    }.getType();

                    GsonRequest<ApiListResponse<User>> gsonRequest =
                            new GsonRequest<ApiListResponse<User>>(Request.Method.GET,
                                    request.toUrl(),
                                    fooType,
                                    null,
                                    new Response.Listener<ApiListResponse<User>>() {
                                        @Override
                                        public void onResponse(final ApiListResponse<User> response) {

                                            List<User> friends = response.getResponse().getItems();

                                            for (int index = 1; index < friends.size() + 1; ++index) {
                                                friends.get(index - 1).setStorageId(index);
                                            }

                                            listener.onResponse(friends);
                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Log.e(TAG, error.getMessage(), error);
                                        }
                                    });

                    VolleyRequestHelper.getInstance(mContext).addRequestQueue(gsonRequest);
                }
            });
        }

        public void getGroups(final ResponseListener<Group> listener, final long... uids) {
            mExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    String accessToken = mSession.getAccessToken();
                    ApiRequestBuilder request =
                            new ApiRequestBuilder(ApiRequestBuilder.VK_METHOD_GROUPS_GET, accessToken);
                    request.addParam(ApiRequestBuilder.VK_GROUPS_GET_EXTENDED,
                            VK_GROUPS_EXTENDED_VALUE);

                    if (uids.length > 0) {
                        request.addParam(ApiRequestBuilder.VK_USER_ID,
                                uids[0]);
                    }

                    Type fooType = new TypeToken<ApiListResponse<Group>>() {
                    }.getType();

                    GsonRequest<ApiListResponse<Group>> gsonRequest =
                            new GsonRequest<ApiListResponse<Group>>(Request.Method.GET,
                                    request.toUrl(),
                                    fooType,
                                    null,
                                    new Response.Listener<ApiListResponse<Group>>() {
                                        @Override
                                        public void onResponse(final ApiListResponse<Group> response) {
                                            listener.onResponse(response
                                                    .getResponse().getItems());
                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Log.e(TAG, error.getMessage(), error);
                                        }
                                    });

                    VolleyRequestHelper.getInstance(mContext).addRequestQueue(gsonRequest);
                }
            });
        }

        public void getAudios(final ResponseListener<Audio> listener, final long... uids) {
            mExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    List<Audio> audios = new ArrayList<Audio>();
                    String accessToken = mSession.getAccessToken();
                    try {
                        Gson gson = new Gson();

                        ApiRequestBuilder request = new ApiRequestBuilder(ApiRequestBuilder.VK_METHOD_AUDIO_GET, accessToken);

                        if (uids.length > 0) {
                            request.addParam(ApiRequestBuilder.VK_OWNER_ID, uids[0]);
                        }

                        Type fooType = new TypeToken<ApiListResponse<Audio>>() {
                        }.getType();
                        ApiListResponse<Audio> audioListResponse = gson.fromJson(
                                getBufferedReaderByMethodURL(new URL(request.toUrl())),
                                fooType
                        );

                        audios = audioListResponse.getResponse().getItems();

                        Log.d(TAG, audios.toString());
                    } catch (Exception e) {
                        Log.e(TAG, e.getMessage(), e);
                    }

                    final List<Audio> finalAudios = audios;
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onResponse(finalAudios);
                        }
                    });
                }
            });
        }

        private BufferedReader getBufferedReaderByMethodURL(URL url) throws Exception {
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            Log.d(TAG, "response code " + responseCode);

            InputStream inputStream = connection.getInputStream();

            return new BufferedReader(new InputStreamReader(inputStream));
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new ApiWorker(SessionStore.restore(this), this);
    }
}
