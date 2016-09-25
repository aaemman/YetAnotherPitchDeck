package com.yapd.alexander.yapd.client.job;

import android.support.annotation.NonNull;

import com.mypopsy.maps.StaticMap;
import com.yapd.alexander.yapd.client.util.code.common.Presenter;
import com.yapd.alexander.yapd.core.model.Job;

import java.lang.ref.WeakReference;
import java.net.MalformedURLException;

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
        getView().setCompanyName(job.getCompany().getName());
        getView().setCompanyDescription(job.getCompany().getDescription());
        getView().setCompanyLocationMapUrl(getMapUrlForLocation(job.getCompany().getLocation()));
        getView().setJobTitle(job.getTitle());
        getView().showJobDescription(job.getDescription() != null);
        getView().setJobDuration(job.getDuration());
        getView().setJobDescription(job.getDescription());
        getView().showFeaturedImages(job.getCompany().getFeaturedImageUrls().size() > 0);
        getView().setFeaturedImageUrls(job.getCompany().getFeaturedImageUrls());

    }

    private String getMapUrlForLocation(String location) {
        try {
            return new StaticMap().size(480, 270).marker(StaticMap.Marker.Style.DEFAULT, new StaticMap.GeoPoint(location)).toURL().toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void onCompanyDescriptionClicked() {
        getView().expandCompanyDescription();
    }

    public void onJobDescriptionClicked() {
        getView().expandJobDescription();
    }

    public void onVisitWebsiteButtonClicked() {
        getView().openWebsiteWithUrl(job.getCompany().getWebsiteUrl());
    }
}
