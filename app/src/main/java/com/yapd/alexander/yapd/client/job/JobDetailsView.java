package com.yapd.alexander.yapd.client.job;

import java.util.List;

/**
 * Created by alexander on 9/22/16.
 */
public interface JobDetailsView {
    void setHeaderImageViewBackgroundUrl(String url);

    void setCompanyName(String name);

    void setCompanyDescription(String description);

    void setCompanyLocationMapUrl(String location);

    void expandCompanyDescription();

    void showFeaturedImages(boolean shouldShow);

    void setFeaturedImageUrls(List<String> imageUrls);

    void setJobTitle(String title);

    void showJobDescription(boolean shouldShow);

    void setJobDuration(String duration);

    void setJobDescription(String description);

    void expandJobDescription();

    void openWebsiteWithUrl(String url);
}
