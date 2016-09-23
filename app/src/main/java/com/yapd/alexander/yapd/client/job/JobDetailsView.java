package com.yapd.alexander.yapd.client.job;

/**
 * Created by alexander on 9/22/16.
 */
public interface JobDetailsView {
    void setHeaderImageViewBackgroundUrl(String url);

    void setCompanyName(String name);

    void setCompanyDescription(String description);

    void setCompanyLocation(String location);

    void expandCompanyDescription();

    void setJobTitle(String title);

    void setJobDuration(String duration);

    void setJobDescription(String description);
}
