package com.yapd.alexander.yapd.core.usecase;

import com.yapd.alexander.yapd.core.model.Job;
import com.yapd.alexander.yapd.core.usecase.jobs.GetJobs;

import java.util.List;

import rx.Observable;

/**
 * Created by alexander on 9/22/16.
 */
public class YapdSdk {
    public static class Jobs {
        public static Observable<List<Job>> getJobs() {
            return new GetJobs().list();
        }
    }
}
