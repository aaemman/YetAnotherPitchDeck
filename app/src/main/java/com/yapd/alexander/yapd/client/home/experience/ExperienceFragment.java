package com.yapd.alexander.yapd.client.home.experience;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.job_details.JobDetailsActivity;
import com.yapd.alexander.yapd.client.util.code.SDKVersion;
import com.yapd.alexander.yapd.client.util.view.common.BaseFragment;
import com.yapd.alexander.yapd.client.util.widget.featured_section.FeaturedJobsSection;
import com.yapd.alexander.yapd.client.util.widget.featured_section.FeaturedVentureSection;
import com.yapd.alexander.yapd.client.venture_details.VentureDetailsActivity;
import com.yapd.alexander.yapd.core.model.Job;
import com.yapd.alexander.yapd.core.model.Venture;

import java.util.List;

/**
 * Created by alexander on 9/21/16.
 */
public class ExperienceFragment extends BaseFragment implements ExperienceView {
    public static final int LAYOUT = R.layout.fragment_experience;
    private View contentView;
    private ViewBinder viewBinder;
    private ExperiencePresenter presenter = new ExperiencePresenter();
    private View lastClickedJobImageView;

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
        setupEnrepreneurshipSection();
        setupCareerPathSection();

        presenter.loadCareerPathSection();
        presenter.loadVentureSection();
        return contentView;
    }

    private void setupEnrepreneurshipSection() {
        viewBinder.getFeaturedVentureSectionRow1().setOnItemClickListener((venture, view) -> {
            presenter.onVentureClicked(venture);
        });
        viewBinder.getFeaturedVentureSectionRow2().setOnItemClickListener((venture, view) -> {
            presenter.onVentureClicked(venture);
        });
    }

    private void setupCareerPathSection() {
        viewBinder.getJobsItemFeaturedSection().setOnItemClickListener((job, view) -> {
            lastClickedJobImageView = view;
            presenter.OnJobClicked(job);
        });
    }

    private void initializeContentView(ViewGroup container) {
        contentView = LayoutInflater.from(getActivity()).inflate(LAYOUT, container, false);
    }

    @Override
    public void openJobPage(Job job) {
        if (SDKVersion.isJellyBeanAndUp()) {
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), lastClickedJobImageView, "job_details_logo");
            getActivity().startActivity(JobDetailsActivity.getLaunchIntent(getContext(), job), options.toBundle());
        } else {
            getActivity().startActivity(JobDetailsActivity.getLaunchIntent(getContext(), job));
        }
    }

    @Override
    public void showCareerPathSection(List<Job> jobs) {
        viewBinder.getJobsItemFeaturedSection().setItems(jobs);
    }

    @Override
    public void showEntrepreneurshipSection(List<Venture> ventures) {
        viewBinder.getFeaturedVentureSectionRow1().setItems(ventures);
        viewBinder.getFeaturedVentureSectionRow2().setItems(ventures.subList(2, ventures.size()));
    }

    @Override
    public void openVenture(Venture venture) {
        getActivity().startActivity(VentureDetailsActivity.getLaunchIntent(getContext(), venture));
    }

    // ------ VIEW BINDER ------

    private class ViewBinder extends com.yapd.alexander.yapd.client.util.view.common.ViewBinder {
        private FeaturedVentureSection featuredVentureSectionRow1;
        private FeaturedVentureSection featuredVentureSectionRow2;
        private FeaturedJobsSection featuredJobsSection;

        public ViewBinder(View view) {
            super(view);
        }

        public FeaturedVentureSection getFeaturedVentureSectionRow1() {
            return featuredVentureSectionRow1 = getView(featuredVentureSectionRow1, R.id.fragment_experience_ventures_row_1);
        }

        public FeaturedVentureSection getFeaturedVentureSectionRow2() {
            return featuredVentureSectionRow2 = getView(featuredVentureSectionRow2, R.id.fragment_experience_ventures_row_2);
        }

        public FeaturedJobsSection getJobsItemFeaturedSection() {
            return featuredJobsSection = getView(featuredJobsSection, R.id.fragment_experience_career_path_featured_jobs_section);
        }
    }
}
