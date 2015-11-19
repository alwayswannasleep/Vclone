package org.oa.teach_http.app.session;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.net.URLDecoder;

public class SessionStore {

    private static final String TAG = "session";

    private static final String KEY = "m-session";
    private static final String UID_KEY = "user_id";
    private static final String ACCESS_TOKEN_KEY = "access_token";
    private static final String EXPIRE_IN_KEY = "expires_in";

    public static Session restore(Context context) {
        Session session = new Session();
        SharedPreferences prefs = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        session.setUserId(prefs.getString(UID_KEY, null));
        session.setAccessToken(prefs.getString(ACCESS_TOKEN_KEY, null));
        session.setExpireIn(prefs.getString(EXPIRE_IN_KEY, null));
        return session;
    }

    public static long getOwnerId(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        return Long.parseLong(prefs.getString(UID_KEY, ""));
    }

    public static boolean isOwner(long userId, Context context) {
        boolean result = false;
        SharedPreferences prefs = context.getSharedPreferences(KEY,
                Context.MODE_PRIVATE);
        String mid = prefs.getString(UID_KEY, null);
        if (mid != null) {
            result = userId == Long.parseLong(mid);
        }
        return result;
    }

    public static void reLogin(Context context) {
        context.getSharedPreferences(KEY, Context.MODE_PRIVATE).edit().clear().commit();
    }

    public static boolean isValidSession(Context context){
        return restore(context).isValid();
    }

    public static void parseSession(String url,Context context) {
        SharedPreferences.Editor editor = context.getSharedPreferences(KEY, Context.MODE_PRIVATE)
                .edit();
        int findIndex = url.indexOf("#");
        String sessionStr = URLDecoder.decode(url.substring(findIndex + 1, url.length()));
        String[] paramStrings = sessionStr.split("&");
        for (String param : paramStrings) {
            String items[] = param.split("=");
            Log.d(TAG, param);
            editor.putString(items[0], items[1]);
        }
        editor.apply();
    }

    public static Bundle parseError(String url) {
        Bundle params = new Bundle();
        int findIndex = url.indexOf("?");
        String errorStr = url.substring(findIndex + 1, url.length());
        String[] paramStrings = errorStr.split("&");
        for (String param : paramStrings) {
            String items[] = param.split("=");
            params.putString(items[0], items[1].replaceAll("+", " "));
        }
        return params;
    }
}
