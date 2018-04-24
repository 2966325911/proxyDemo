package com.cloudoc.share.yybpg.proxyframework.image;

import android.app.Activity;
import android.widget.ImageView;

/**
 * @author : Vic
 * time   : 2018/04/24
 * desc   :
 */
public class ImageLoaderPresenter implements ImageLoader {
    private ImageLoader imageLoader;

    private static ImageLoaderPresenter instance;

    private ImageLoaderPresenter(ImageLoader imageLoader) {
        this.imageLoader = imageLoader;
    }

    public static ImageLoaderPresenter init(ImageLoader imageLoader) {
        if(instance == null) {
            synchronized (ImageLoaderPresenter.class) {
                if(instance == null) {
                    instance = new ImageLoaderPresenter(imageLoader);
                }
            }
        }
        return instance;
    }


    @Override
    public void displayImage(Activity activity, String imageUrl, ImageView imageView) {
        imageLoader.displayImage(activity,imageUrl,imageView);
    }
}
