package com.yapd.alexander.yapd.client.job;

import android.support.annotation.NonNull;

import com.yapd.alexander.yapd.client.util.code.common.Presenter;
import com.yapd.alexander.yapd.core.model.Job;

import java.lang.ref.WeakReference;

import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by alexander on 9/22/16.
 */
public class JobDetailsPresenter implements Presenter<JobDetailsView> {
    private WeakReference<JobDetailsView> jobDetailsViewWeakReference;
    private CompositeSubscription subscriptions;
    private Job job;

    @Override
    public void attachToView(JobDetailsView jobDetailsView) {
        jobDetailsViewWeakReference = new WeakReference<>(jobDetailsView);
        subscriptions = new CompositeSubscription();
    }

    @Override
    public void detachFromView() {
        clearSubscriptions();
    }

    protected void clearSubscriptions() {
        if (subscriptions.hasSubscriptions()) {
            getUnsubscribeFromCompositeSubscriptionObservable()
                    .subscribeOn(Schedulers.computation())
                    .subscribe();
        }
    }

    @NonNull
    private Observable<Object> getUnsubscribeFromCompositeSubscriptionObservable() {
        return Observable.create(subscriber -> subscriptions.unsubscribe());
    }

    private JobDetailsView getView() {
        return jobDetailsViewWeakReference.get();
    }

    public void loadContentForJob(Job job) {
        this.job = job;
        getView().setHeaderImageViewBackgroundUrl(job.getCompany().getLogoUrl());

    }
}
