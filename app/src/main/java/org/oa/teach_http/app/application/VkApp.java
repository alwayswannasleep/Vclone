package org.oa.teach_http.app.application;

import android.app.Application;
import org.oa.teach_http.app.utils.ImageUtils;

public class VkApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ImageUtils.init(this);
    }
}
