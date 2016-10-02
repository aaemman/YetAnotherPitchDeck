package com.yapd.alexander.yapd.client.job_details;

import java.util.List;

/**
 * Created by alexander on 9/22/16.
 */
public interface JobDetailsView {
    void setHeaderImageViewBackgroundUrl(String url);

    void setCompanyName(String name);

    void setCompanyDescription(String description);

    void setCompanyTags(List<String> tags);

    void setCompanyLocationMapUrl(String location);

    void showFeaturedImages(boolean shouldShow);

    void setFeaturedImageUrls(List<String> imageUrls);

    void setJobTitle(String title);

    void showJobDescription(boolean shouldShow);

    void setJobDuration(String duration);

    void setJobDescription(String description);

    void openWebsiteWithUrl(String url);
}
