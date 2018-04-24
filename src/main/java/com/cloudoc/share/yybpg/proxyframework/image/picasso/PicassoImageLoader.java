package com.cloudoc.share.yybpg.proxyframework.image.picasso;

import android.app.Activity;
import android.widget.ImageView;

import com.cloudoc.share.yybpg.proxyframework.image.ImageLoader;
import com.squareup.picasso.Picasso;

/**
 * @author : Vic
 * time   : 2018/04/24
 * desc   :
 */
public class PicassoImageLoader implements ImageLoader {
    @Override
    public void displayImage(Activity activity, String imageUrl, ImageView imageView) {
        Picasso.get().load(imageUrl).into(imageView);
    }
}
