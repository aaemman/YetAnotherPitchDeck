package com.yapd.alexander.yapd.client.home.experience;

import com.yapd.alexander.yapd.core.model.Job;

import java.util.List;

/**
 * Created by alexander on 9/22/16.
 */
public interface ExperienceView {
    void openJobPage(Job job);

    void showCareerPathSection(List<Job> jobs);
}
