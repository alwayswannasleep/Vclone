package org.oa.teach_http.app.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.reflect.TypeToken;

import org.oa.teach_http.app.models.ApiListResponse;
import org.oa.teach_http.app.models.Audio;
import org.oa.teach_http.app.models.Group;
import org.oa.teach_http.app.models.User;
import org.oa.teach_http.app.models.UsersListResponse;
import org.oa.teach_http.app.session.Session;
import org.oa.teach_http.app.session.SessionStore;
import org.oa.teach_http.app.volley.GsonRequest;
import org.oa.teach_http.app.volley.VolleyRequestHelper;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ApiService extends Service {
    private static final String TAG = ApiService.class.getSimpleName();

    public static class ApiWorker extends Binder {

        private static final String VK_FRIENDS_FIELD_VALUE = "uid,first_name,last_name," +
                "photo_100,online";

        private static final String VK_USER_FIELD_VALUE = "sex,bdate,city,country,photo_100," +
                "online,online_mobile,has_mobile,contacts,connections,site,education," +
                "universities,schools,can_post,can_see_all_posts,can_see_audio," +
                "can_write_private_message,status,last_seen,common_count,relation,relatives," +
                "counters,screen_name,maiden_name,occupation,activities,interests,music," +
                "movies,tv,books,games,about,quotes,personal,friend_status,military,career";

        private static final String VK_FRIENDS_ORDER_VALUE = "hints";

        private static final String VK_GROUPS_EXTENDED_VALUE = "1";

        private final Executor mExecutor = Executors.newSingleThreadExecutor();

        private final Session mSession;

        private final Context mContext;

        public ApiWorker(Session session, Context context) {
            mSession = session;
            mContext = context;
        }

        public void getFriends(final ResponseListener<User> listener, final long... uids) {
            mExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    String accessToken = mSession.getAccessToken();

                    ApiRequestBuilder request =
                            new ApiRequestBuilder(ApiRequestBuilder.VK_METHOD_FRIENDS_GET, accessToken);
                    request
                            .addParam(ApiRequestBuilder.VK_USERS_GET_FIELDS, VK_FRIENDS_FIELD_VALUE)
                            .addParam(ApiRequestBuilder.VK_FRIENDS_GET_ORDER, VK_FRIENDS_ORDER_VALUE);

                    if (uids.length > 0) {
                        request.addParam(ApiRequestBuilder.VK_USER_ID, uids[0]);
                    }

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
                    String accessToken = mSession.getAccessToken();

                    ApiRequestBuilder request =
                            new ApiRequestBuilder(ApiRequestBuilder.VK_METHOD_AUDIO_GET, accessToken);

                    if (uids.length > 0) {
                        request.addParam(ApiRequestBuilder.VK_OWNER_ID, uids[0]);
                    }

                    Type fooType = new TypeToken<ApiListResponse<Audio>>() {
                    }.getType();

                    GsonRequest<ApiListResponse<Audio>> gsonRequest =
                            new GsonRequest<ApiListResponse<Audio>>(Request.Method.GET,
                                    request.toUrl(),
                                    fooType,
                                    null,
                                    new Response.Listener<ApiListResponse<Audio>>() {
                                        @Override
                                        public void onResponse(ApiListResponse<Audio> response) {
                                            listener.onResponse(response.getResponse().getItems());
                                        }
                                    },
                                    new Response.ErrorListener() {
                                        @Override
                                        public void onErrorResponse(VolleyError error) {
                                            Log.e(TAG, error.getMessage(), error);
                                        }
                                    }
                            );

                    VolleyRequestHelper.getInstance(mContext).addRequestQueue(gsonRequest);
                }
            });
        }

        public void getUsers(final ResponseListener<User> listener, final long... uids) {
            mExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    String accessToken = mSession.getAccessToken();

                    final ApiRequestBuilder request =
                            new ApiRequestBuilder(ApiRequestBuilder.VK_METHOD_USERS_GET, accessToken);

                    request.addParam(ApiRequestBuilder.VK_USERS_GET_FIELDS, VK_USER_FIELD_VALUE);

                    if (uids.length > 0) {
                        StringBuilder sb = new StringBuilder();

                        for (long uid : uids) {
                            sb.append(uid);
                        }

                        request.addParam(ApiRequestBuilder.VK_USER_IDS, sb.toString());
                    }

                    Type fooType = new TypeToken<UsersListResponse<User>>() {
                    }.getType();

                    GsonRequest<UsersListResponse<User>> gsonRequest =
                            new GsonRequest<UsersListResponse<User>>(Request.Method.GET,
                                    request.toUrl(),
                                    fooType,
                                    null,
                                    new Response.Listener<UsersListResponse<User>>() {
                                        @Override
                                        public void onResponse(UsersListResponse<User> response) {
                                            listener.onResponse(response.getReponse());
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
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new ApiWorker(SessionStore.restore(this), this);
    }
}
