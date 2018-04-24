package com.cloudoc.share.yybpg.proxyframework.net;

import com.cloudoc.share.yybpg.proxyframework.net.async.AsyncHttpRequest;

import java.util.Map;

/**
 * @author : Vic
 * time   : 2018/04/24
 * desc   :
 */
public class HttRequestPresenter implements HttpRequest{
    private HttpRequest httpRequest;

    private HttRequestPresenter(HttpRequest httpRequest){
        this.httpRequest = httpRequest;
    }


    private static volatile HttRequestPresenter instance;

    public static HttRequestPresenter getInstance(HttpRequest httpRequest) {
        if(instance == null) {
            synchronized (HttRequestPresenter.class) {
                if(instance == null) {
                    instance = new HttRequestPresenter(httpRequest);
                }
            }
        }
        return instance;
    }

    @Override
    public void get(String url, Map<String, String> params, ICallback iCallback) {
        httpRequest.get(url,params,iCallback);
    }

    @Override
    public void post(String url, Map<String, String> params, ICallback iCallback) {
        httpRequest.post(url,params,iCallback);
    }
}
