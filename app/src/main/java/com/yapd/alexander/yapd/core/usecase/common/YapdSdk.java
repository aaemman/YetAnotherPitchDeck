package com.yapd.alexander.yapd.core.usecase.common;

import com.yapd.alexander.yapd.core.model.Job;
import com.yapd.alexander.yapd.core.model.Venture;
import com.yapd.alexander.yapd.core.usecase.entrepreneurship.GetVentures;
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

    public static class Entrepreneurship {
        public static Observable<List<Venture>> getVentures() {
            return new GetVentures().list();
        }
    }
}
