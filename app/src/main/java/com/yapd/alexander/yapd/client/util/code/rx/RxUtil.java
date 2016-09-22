package com.yapd.alexander.yapd.client.util.code.rx;

import rx.Subscriber;

/**
 * Created by alexander on 9/22/16.
 */
public class RxUtil {
    public static class CompactSubscriber<T> extends Subscriber<T> {

        @Override
        public void onCompleted() {
            //
        }

        @Override
        public void onError(Throwable e) {
            e.printStackTrace();
        }

        @Override
        public void onNext(T t) {
            //
        }
    }
}
