package com.prince.jsonparsing;

import android.content.Context;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

public final class UILUtils {

    private static DisplayImageOptions options;

    public static void displayImage(Context context, String imgurl,
                                    ImageView imageView) {
        initOptions();
        ImageLoader.getInstance()
                .displayImage(imgurl, imageView, options, null);
    }

    private static void initOptions() {
        if (options == null) {
            options = new DisplayImageOptions.Builder()
                    .showImageOnLoading(R.drawable.building)
                    .showImageForEmptyUri(R.drawable.building)
                    .showImageOnFail(R.drawable.building).cacheInMemory(true)
                    .cacheOnDisk(true).considerExifParams(true)
                    .displayer(new RoundedBitmapDisplayer(20)).build();
        }
    }
    private UILUtils() {
    }
}