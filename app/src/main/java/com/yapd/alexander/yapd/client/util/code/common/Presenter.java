package com.yapd.alexander.yapd.client.util.code.common;

/**
 * Created by alexander on 9/22/16.
 */
public interface Presenter<T> {
    void attachToView(T t);

    void detachFromView();
}
