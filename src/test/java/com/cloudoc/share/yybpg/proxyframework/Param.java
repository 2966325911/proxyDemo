package com.cloudoc.share.yybpg.proxyframework;

import org.junit.Test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author : Vic
 * time   : 2018/04/24
 * desc   :
 */
public class Param<T1,T2> {
    class A{}
    class B extends A{}

    private Class<T1> entityClass;

    @Test
    public void test(){
        Type type = getClass().getGenericSuperclass();
        System.out.println("getClass()=========" + getClass());
        System.out.println("type ====="  + type);
        Type trueType = ((ParameterizedType)type).getActualTypeArguments()[0];
        System.out.println("trueType1==" + trueType);
        trueType = ((ParameterizedType)type).getActualTypeArguments()[1];
        System.out.println("trueType2==" + trueType);

        this.entityClass = (Class<T1>) trueType;
        System.out.println("entityClass==" + entityClass);


        B t = new B();
        type = t.getClass().getGenericSuperclass();

        System.out.println("B is A's super class :" + ((ParameterizedType)type).getActualTypeArguments().length);
    }
}
