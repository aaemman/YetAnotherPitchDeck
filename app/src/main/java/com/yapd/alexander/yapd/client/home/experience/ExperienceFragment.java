package com.yapd.alexander.yapd.client.home.experience;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.util.view.common.BaseFragment;
import com.yapd.alexander.yapd.client.util.widget.featured_section.FeaturedJobsSection;
import com.yapd.alexander.yapd.core.model.Job;

import java.util.List;

/**
 * Created by alexander on 9/21/16.
 */
public class ExperienceFragment extends BaseFragment implements ExperienceView {
    public static final int LAYOUT = R.layout.fragment_experience;
    private View contentView;
    private ViewBinder viewBinder;
    private ExperiencePresenter presenter = new ExperiencePresenter();

    public static ExperienceFragment getInstance() {
        return new ExperienceFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (contentView != null) {
            ViewParent parent = contentView.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(contentView);
            }
            return contentView;
        }

        initializeContentView(container);
        viewBinder = new ViewBinder(contentView);
        presenter.attachToView(this);
        setupCareerPathSection();

        presenter.loadCareerPathSection();
        return contentView;
    }

    private void setupCareerPathSection() {
        viewBinder.getJobsItemFeaturedSection().setOnItemClickListener(job -> presenter.OnJobClicked(job));
    }

    private void initializeContentView(ViewGroup container) {
        contentView = LayoutInflater.from(getActivity()).inflate(LAYOUT, container, false);
    }

    @Override
    public void openJobPage(Job job) {
        // TODO: 9/22/16
    }

    @Override
    public void showCareerPathSection(List<Job> jobs) {
        viewBinder.getJobsItemFeaturedSection().setItems(jobs);
    }

    // ------ VIEW BINDER ------

    private class ViewBinder extends com.yapd.alexander.yapd.client.util.view.common.ViewBinder {
        private FeaturedJobsSection threeItemFeaturedSection;

        public ViewBinder(View view) {
            super(view);
        }

        public FeaturedJobsSection getJobsItemFeaturedSection() {
            return threeItemFeaturedSection = getView(threeItemFeaturedSection, R.id.fragment_experience_career_path_featured_jobs_section);
        }
    }
}
