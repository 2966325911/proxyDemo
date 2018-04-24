package com.cloudoc.share.yybpg.proxyframework.net;

import java.util.Map;

/**
 * @author : Vic
 * time   : 2018/04/24
 * desc   :
 */
public interface HttpRequest {
    void get(String url,Map<String,String> params,ICallback iCallback);

    void post(String url,Map<String,String> params,ICallback iCallback);
}
