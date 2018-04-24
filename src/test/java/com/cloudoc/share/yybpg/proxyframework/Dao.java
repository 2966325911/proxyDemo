package com.cloudoc.share.yybpg.proxyframework;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.PreparedStatement;

/**
 * @author : Vic
 * time   : 2018/04/24
 * desc   :
 */
public class Dao<T> {
    private static PreparedStatement st = null;
    public Class clazz;
    public Dao(){
        Type superclass = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = null;
        if(superclass instanceof ParameterizedType) {
            parameterizedType = (ParameterizedType) superclass;
            Type[] typeArray = parameterizedType.getActualTypeArguments();
            if(typeArray != null && typeArray.length > 0) {
                clazz = (Class) typeArray[0];
            }
        }
    }
}
