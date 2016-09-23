package com.yapd.alexander.yapd.client.job;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.mypopsy.maps.StaticMap;
import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.util.view.common.BaseActivity;
import com.yapd.alexander.yapd.client.util.widget.expandable_text_view.ExpandableTextView;
import com.yapd.alexander.yapd.core.model.Job;

import java.net.MalformedURLException;

public class JobDetailsActivity extends BaseActivity implements JobDetailsView {
    public static final String JOB_EXTRA_KEY = "JOB_EXTRA_KEY";
    public static final int LAYOUT = R.layout.activity_job_details;
    private ViewBinder viewBinder;
    private JobDetailsPresenter presenter = new JobDetailsPresenter();
    private Job job;

    public static Intent getLaunchIntent(Context context, Job job) {
        Intent intent = new Intent(context, JobDetailsActivity.class);
        intent.putExtra(JOB_EXTRA_KEY, job);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        viewBinder = new ViewBinder(findViewById(android.R.id.content));
        presenter.attachToView(this);

        setupCompanyDesription();
        this.job = getIntent().getParcelableExtra(JOB_EXTRA_KEY);
        presenter.loadContentForJob(job);
    }

    private void setupCompanyDesription() {
        viewBinder.getCompanyDescription().setOnClickListener(view -> presenter.onCompanyDescriptionClicked());
    }

    @Override
    public void setCompanyName(String name) {
        viewBinder.getCompanyTitleTextView().setText(name);
    }

    @Override
    public void setCompanyDescription(String description) {
        viewBinder.getCompanyDescription().setText(description);
    }

    @Override
    public void setCompanyLocation(String location) {
        try {
            String mapUrl = new StaticMap().size(480, 270).marker(StaticMap.Marker.Style.DEFAULT, new StaticMap.GeoPoint(location)).toURL().toString();
            Glide.with(this).load(mapUrl).crossFade().into(viewBinder.getMapImageView());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void expandCompanyDescription() {
        viewBinder.getCompanyDescription().setExpanded(true);
    }

    @Override
    public void setJobTitle(String title) {
        viewBinder.getJobTitleTextView().setText(title);
    }

    @Override
    public void setJobDuration(String duration) {
        viewBinder.getJobDurationTextView().setText(duration);
    }

    @Override
    public void setJobDescription(String description) {
        viewBinder.getJobDescriptionTextView().setText(description);
    }

    @Override
    public void setHeaderImageViewBackgroundUrl(String url) {
        Glide.with(this).load(url).asBitmap().into(new BitmapImageViewTarget(viewBinder.getHeaderImageView()) {
            @Override
            public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {
                super.onResourceReady(bitmap, anim);
                Palette.generateAsync(bitmap, palette -> {
                    setStatusBarColor(palette.getVibrantColor(getResourceColor(R.color.gray7)));
                });
            }
        });
    }

    // ------ VIEW BINDER ------

    private class ViewBinder extends com.yapd.alexander.yapd.client.util.view.common.ViewBinder {
        private ImageView headerImageView;
        private TextView companyTitleTextView;
        private ExpandableTextView companyDescription;
        private ImageView mapImageView;
        private TextView jobTitleTextView;
        private TextView jobDurationTextView;
        private TextView jobDescriptionTextView;

        public ViewBinder(View view) {
            super(view);
        }

        public ImageView getHeaderImageView() {
            return headerImageView = getView(headerImageView, R.id.view_three_item_featured_section_item_first);
        }

        public TextView getCompanyTitleTextView() {
            return companyTitleTextView = getView(companyTitleTextView, R.id.activity_job_details_company_title);
        }

        public ExpandableTextView getCompanyDescription() {
            return companyDescription = getView(companyDescription, R.id.activity_job_details_company_description);
        }

        public ImageView getMapImageView() {
            return mapImageView = getView(mapImageView, R.id.activity_job_details_company_location_map_image_view);
        }

        public TextView getJobTitleTextView() {
            return jobTitleTextView = getView(jobTitleTextView, R.id.activity_job_details_job_title);
        }

        public TextView getJobDurationTextView() {
            return jobDurationTextView = getView(jobDurationTextView, R.id.activity_job_details_job_duration);
        }

        public TextView getJobDescriptionTextView() {
            return jobDescriptionTextView = getView(jobDescriptionTextView, R.id.activity_job_details_job_description);
        }
    }
}
