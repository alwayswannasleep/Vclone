package org.oa.teach_http.app.utils;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.oa.teach_http.app.R;

public class ImageUtils {

    private static final boolean CACHING_IN_MEMORY = true;

    private ImageUtils() {
    }

    public static void init(Context context) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .defaultDisplayImageOptions(
                        new DisplayImageOptions.Builder()
                                .showImageOnLoading(R.mipmap.ic_launcher)
                                .cacheInMemory(CACHING_IN_MEMORY)
                                .build())
                .build();
        ImageLoader.getInstance().init(config);
    }

    public static void loadImage(ImageView imageView, String url) {
        ImageLoader.getInstance().displayImage(url, imageView);
    }
}
