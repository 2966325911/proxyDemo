package com.cloudoc.share.yybpg.proxyframework.net.async;

import com.cloudoc.share.yybpg.proxyframework.net.HttpRequest;
import com.cloudoc.share.yybpg.proxyframework.net.ICallback;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.Map;

import cz.msebera.android.httpclient.Header;

/**
 * @author : Vic
 * time   : 2018/04/24
 * desc   :
 */
public class AsyncHttpRequest implements HttpRequest {
    private AsyncHttpClient asyncHttpClient;
    public AsyncHttpRequest(){
        asyncHttpClient = new AsyncHttpClient();
    }


    @Override
    public void get(String url, Map<String, String> params, final ICallback iCallback) {
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
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                iCallback.onSuccess(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                iCallback.onFialure(statusCode,error);
            }
        });
    }

    @Override
    public void post(String url, Map<String, String> params, ICallback iCallback) {

    }
}
