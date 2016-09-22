package com.yapd.alexander.yapd.core.usecase.jobs;

import com.yapd.alexander.yapd.core.data.job.JobsDataSource;
import com.yapd.alexander.yapd.core.data.job.JobsDataStore;
import com.yapd.alexander.yapd.core.model.Job;

import java.util.List;

import rx.Observable;

/**
 * Created by alexander on 9/22/16.
 */
public class GetJobs {
    public Observable<List<Job>> list() {
        return getDataSource().index();
    }

    private JobsDataSource getDataSource() {
        return new JobsDataStore();
    }
}
