package com.cloudoc.share.yybpg.proxyframework.image;

import android.app.Activity;
import android.widget.ImageView;

/**
 * @author : Vic
 * time   : 2018/04/24
 * desc   :
 */
public interface ImageLoader {
    void displayImage(Activity activity, String imageUrl, ImageView imageView);
}
