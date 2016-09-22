package com.yapd.alexander.yapd.core.data.job;

import com.yapd.alexander.yapd.core.model.Job;

import java.util.List;

import rx.Observable;

/**
 * Created by alexander on 9/22/16.
 */
public interface JobsDataSource {
    Observable<List<Job>> index();
}
