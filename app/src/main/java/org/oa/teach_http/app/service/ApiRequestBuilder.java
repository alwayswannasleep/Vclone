package org.oa.teach_http.app.service;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApiRequestBuilder {

    public static final String VK_BASE_URL = "https://api.vk.com/method/";

    public static final String VK_METHOD_FRIENDS_GET = "friends.get?";

    public static final String VK_METHOD_GROUPS_GET = "groups.get?";

    public static final String VK_METHOD_USERS_GET = "users.get?";

    public static final String VK_METHOD_AUDIO_GET = "audio.get?";

    public static final String VK_ACCESS_TOKEN = "access_token=";

    public static final String VK_USERS_GET_FIELDS = "fields=";

    public static final String VK_FRIENDS_GET_ORDER = "order=";

    public static final String VK_GROUPS_GET_EXTENDED = "extended=";

    public static final String VK_GROUPS_GET_FILTER = "filter=";

    public static final String VK_API_VERSION_KEY = "v=";

    public static final String VK_API_VERSION_VALUE = "5.37";

    public static final String VK_USER_ID = "user_id=";

    public static final String VK_OWNER_ID = "owner_id=";

    public static final String VK_USER_IDS = "user_ids=";

    private String mApiMethod;

    private Map<String, String> mParams;

    public ApiRequestBuilder(String apiMethod, String accessToken) {
        mApiMethod = apiMethod;
        mParams = new LinkedHashMap<String, String>();

        addParam(VK_ACCESS_TOKEN, accessToken);
        addParam(VK_API_VERSION_KEY, VK_API_VERSION_VALUE);
    }

    public ApiRequestBuilder addParam(String key, Object value) {
        if (value == null) {
            return null;
        }

        mParams.put(key, value.toString());

        return this;
    }

    public String toUrl() {
        StringBuilder builder = new StringBuilder(VK_BASE_URL);
        builder.append(mApiMethod);

        for (String key : mParams.keySet()) {
            builder.append(key)
                    .append(mParams.get(key))
                    .append("&");
        }

        return builder.toString();
    }
}
