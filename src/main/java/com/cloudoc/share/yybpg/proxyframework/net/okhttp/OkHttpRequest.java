package com.cloudoc.share.yybpg.proxyframework.net.okhttp;

import com.cloudoc.share.yybpg.proxyframework.net.HttpRequest;
import com.cloudoc.share.yybpg.proxyframework.net.ICallback;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author : Vic
 * time   : 2018/04/24
 * desc   :
 */
public class OkHttpRequest implements HttpRequest {
    private OkHttpClient okHttpClient;

    public OkHttpRequest() {
        okHttpClient = new OkHttpClient();
    }

    @Override
    public void get(String url, Map<String, String> params, final ICallback callback) {
        StringBuffer sb = new StringBuffer("?");

        if(params != null) {
            for(Map.Entry<String,String> entry : params.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        url += sb.toString();

        final Request request = new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.toString());
            }
        });
    }

    @Override
    public void post(String url, Map<String, String> params, ICallback callback) {

    }
}
