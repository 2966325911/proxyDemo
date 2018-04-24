package com.cloudoc.share.yybpg.proxyframework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.cloudoc.share.yybpg.proxyframework.image.ImageLoader;
import com.cloudoc.share.yybpg.proxyframework.image.ImageLoaderPresenter;
import com.cloudoc.share.yybpg.proxyframework.image.glide.GlideImageLoader;
import com.cloudoc.share.yybpg.proxyframework.image.picasso.PicassoImageLoader;
import com.cloudoc.share.yybpg.proxyframework.model.WeatherInfo;
import com.cloudoc.share.yybpg.proxyframework.net.HttRequestPresenter;
import com.cloudoc.share.yybpg.proxyframework.net.ModelCallback;
import com.cloudoc.share.yybpg.proxyframework.net.async.AsyncHttpRequest;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static String TAG = MainActivity.class.getSimpleName();
    private String url = "http://restapi.amap.com/v3/weather/weatherInfo";
    private String imgUrl = "http://e.hiphotos.baidu.com/image/pic/item/ae51f3deb48f8c54c8a5db4236292df5e0fe7f6c.jpg";
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 //      http://restapi.amap.com/v3/weather/weatherInfo
//        city=长沙
//        key=13cb58f5884f9749287abbead9c658f2
        imageView = getView(R.id.iv);

        Map<String,String> params = new HashMap<>();
        params.put("city","长沙");
        params.put("key","13cb58f5884f9749287abbead9c658f2");
        HttRequestPresenter.getInstance(new AsyncHttpRequest())
                .get(url, params,
                new ModelCallback<WeatherInfo>() {
                    @Override
                    public void onFialure(int code, Throwable t) {
                        Log.d(TAG,"error =======" + code + t.toString());
                    }

                    @Override
                    public void onSuccess(WeatherInfo weatherInfo) {
                        Log.d(TAG,"weantherInfo =======" + weatherInfo.toString());
                    }
                });

        ImageLoaderPresenter.init(new PicassoImageLoader()).displayImage(this,imgUrl,imageView);
    }

    public <T  extends View> T getView(int id) {
        View view = this.findViewById(id);
        return (T) view;
    }
}
