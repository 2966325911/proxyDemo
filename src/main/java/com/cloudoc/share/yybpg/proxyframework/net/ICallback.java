package com.cloudoc.share.yybpg.proxyframework.net;

/**
 * @author : Vic
 * time   : 2018/04/24
 * desc   :
 */
public interface ICallback {
    void onSuccess(String result);
    void onFialure(int code,Throwable t);
}
