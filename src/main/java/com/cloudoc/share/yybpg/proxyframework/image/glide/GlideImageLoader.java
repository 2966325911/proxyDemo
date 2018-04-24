package com.cloudoc.share.yybpg.proxyframework.image.glide;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cloudoc.share.yybpg.proxyframework.image.ImageLoader;

/**
 * @author : Vic
 * time   : 2018/04/24
 * desc   :
 */
public class GlideImageLoader implements ImageLoader{
    @Override
    public void displayImage(Activity activity, String imageUrl, ImageView imageView) {
        Glide.with(activity).load(imageUrl).into(imageView);
    }

}
