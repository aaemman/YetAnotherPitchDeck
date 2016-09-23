package com.yapd.alexander.yapd.client.job;

import java.util.List;

/**
 * Created by alexander on 9/22/16.
 */
public interface JobDetailsView {
    void setHeaderImageViewBackgroundUrl(String url);

    void setCompanyName(String name);

    void setCompanyDescription(String description);

    void setCompanyLocation(String location);

    void expandCompanyDescription();

    void setFeaturedImageUrls(List<String> imageUrls);

    void setJobTitle(String title);

    void setJobDuration(String duration);

    void setJobDescription(String description);

    void expandJobDescription();
}
