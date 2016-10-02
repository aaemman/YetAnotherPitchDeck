package com.yapd.alexander.yapd.client.home.experience;

import android.support.annotation.NonNull;

import com.yapd.alexander.yapd.client.util.code.common.Presenter;
import com.yapd.alexander.yapd.client.util.code.rx.RxUtil;
import com.yapd.alexander.yapd.core.model.Job;
import com.yapd.alexander.yapd.core.model.Venture;
import com.yapd.alexander.yapd.core.usecase.common.YapdSdk;

import java.lang.ref.WeakReference;
import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by alexander on 9/22/16.
 */
public class ExperiencePresenter implements Presenter<ExperienceView> {
    private WeakReference<ExperienceView> experienceViewWeakReference;
    private CompositeSubscription subscriptions;

    @Override
    public void attachToView(ExperienceView experienceView) {
        experienceViewWeakReference = new WeakReference<>(experienceView);
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

    private ExperienceView getView() {
        return experienceViewWeakReference.get();
    }

    public void loadCareerPathSection() {
        subscriptions.add(getJobsObservable().subscribe(new RxUtil.CompactSubscriber<List<Job>>() {
            @Override
            public void onNext(List<Job> jobs) {
                super.onNext(jobs);
                getView().showCareerPathSection(jobs);
            }
        }));
    }

    protected Observable<List<Job>> getJobsObservable() {
        return YapdSdk.Jobs.getJobs()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public void OnJobClicked(Job job) {
        getView().openJobPage(job);
    }

    public void loadVentureSection() {
        subscriptions.add(getventuresObservable().subscribe(new RxUtil.CompactSubscriber<List<Venture>>() {
            @Override
            public void onNext(List<Venture> ventures) {
                super.onNext(ventures);
                getView().showEntrepreneurshipSection(ventures);
            }
        }));
    }

    private Observable<List<Venture>> getventuresObservable() {
        return YapdSdk.Entrepreneurship.getVentures();
    }

    public void onVentureClicked(Venture venture) {
        getView().openVenture(venture);
    }
}