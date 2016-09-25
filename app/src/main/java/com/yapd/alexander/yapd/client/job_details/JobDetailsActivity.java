package com.yapd.alexander.yapd.client.job_details;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.util.view.common.BaseActivity;
import com.yapd.alexander.yapd.client.util.view.on_touch_listener.LiftAnimationOnTouchListener;
import com.yapd.alexander.yapd.client.util.widget.expandable_text_view.ExpandableTextView;
import com.yapd.alexander.yapd.client.util.widget.flat_button.FlatButton;
import com.yapd.alexander.yapd.client.util.widget.no_swipe_recycler_view.NoSwipeRecyclerView;
import com.yapd.alexander.yapd.client.util.widget.no_swipe_recycler_view.TagCloudLayoutManager;
import com.yapd.alexander.yapd.core.model.Job;

import java.util.List;

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
        setupJobDesription();
        setupVisitWebsiteButton();
        setupCompanyTagCloud();
        this.job = getIntent().getParcelableExtra(JOB_EXTRA_KEY);
        presenter.loadContentForJob(job);
    }

    private void setupCompanyDesription() {
        viewBinder.getCompanyDescription().setOnClickListener(view -> presenter.onCompanyDescriptionClicked());
    }

    private void setupJobDesription() {
        viewBinder.getJobDescriptionTextView().setOnClickListener(view -> presenter.onJobDescriptionClicked());
    }

    private void setupVisitWebsiteButton() {
        viewBinder.getVisitCompanyWebsiteButton().setOnTouchListener(new LiftAnimationOnTouchListener());
        viewBinder.getVisitCompanyWebsiteButton().setOnClickListener(view -> presenter.onVisitWebsiteButtonClicked());
    }

    private void setupCompanyTagCloud() {
        viewBinder.getCompanyTagCloud().setLayoutManager(new TagCloudLayoutManager());
    }

    @Override
    public void setCompanyName(String name) {
        viewBinder.getCompanyTitleTextView().setText(name);
        viewBinder.getAboutCompanyTitleTextView().setText(getString(R.string.about_company_title, name));
    }

    @Override
    public void setCompanyDescription(String description) {
        viewBinder.getCompanyDescription().setText(description);
    }

    @Override
    public void setCompanyTags(List<String> tags) {
        viewBinder.getCompanyTagCloud().setAdapter(new CompanyTagCloudAdapter(tags));
    }

    @Override
    public void setCompanyLocationMapUrl(String mapUrl) {
        Glide.with(this).load(mapUrl).crossFade().into(viewBinder.getMapImageView());
    }

    @Override
    public void expandCompanyDescription() {
        viewBinder.getCompanyDescription().setExpanded(true);
    }

    @Override
    public void showFeaturedImages(boolean shouldShow) {
        viewBinder.getFeaturedImagesHorizontalScrollView().setVisibility(shouldShow ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setFeaturedImageUrls(List<String> imageUrls) {
        for (String url : imageUrls) {
            ImageView imageView = getNewImageView();
            viewBinder.getFeaturedImagesLayout().addView(imageView);
            Glide.with(this).load(url).crossFade().into(imageView);
        }
    }

    @NonNull
    private ImageView getNewImageView() {
        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        params.setMargins(0, 0, (int) getResources().getDimension(R.dimen.activity_horizontal_margin), 0);
        imageView.setLayoutParams(params);
        return imageView;
    }

    @Override
    public void setJobTitle(String title) {
        viewBinder.getJobTitleTextView().setText(title);
    }

    @Override
    public void showJobDescription(boolean shouldShow) {
        viewBinder.getJobDescriptionTextView().setVisibility(shouldShow ? View.VISIBLE : View.GONE);
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
    public void expandJobDescription() {
        viewBinder.getJobDescriptionTextView().setExpanded(true);
    }

    @Override
    public void openWebsiteWithUrl(String url) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
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
        private FlatButton visitCompanyWebsiteButton;
        private LinearLayout featuredImagesRecyclerView;
        private TextView jobTitleTextView;
        private TextView aboutCompanyTitleTextView;
        private TextView jobDurationTextView;
        private ExpandableTextView jobDescriptionTextView;
        private NoSwipeRecyclerView companyTagCloud;
        private ImageView mapImageView;
        private HorizontalScrollView featuredImagesHorizontalScrollView;

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

        public FlatButton getVisitCompanyWebsiteButton() {
            return visitCompanyWebsiteButton = getView(visitCompanyWebsiteButton, R.id.job_details_visit_company_website_button);
        }

        public LinearLayout getFeaturedImagesLayout() {
            return featuredImagesRecyclerView = getView(featuredImagesRecyclerView, R.id.activity_job_details_featured_images_layout);
        }

        public TextView getJobTitleTextView() {
            return jobTitleTextView = getView(jobTitleTextView, R.id.activity_job_details_job_title);
        }

        public TextView getJobDurationTextView() {
            return jobDurationTextView = getView(jobDurationTextView, R.id.activity_job_details_job_duration);
        }

        public ExpandableTextView getJobDescriptionTextView() {
            return jobDescriptionTextView = getView(jobDescriptionTextView, R.id.activity_job_details_job_description);
        }

        public ImageView getMapImageView() {
            return mapImageView = getView(mapImageView, R.id.activity_job_details_company_location_map_image_view);
        }

        public TextView getAboutCompanyTitleTextView() {
            return aboutCompanyTitleTextView = getView(aboutCompanyTitleTextView, R.id.activity_job_details_about_company_title);
        }

        public HorizontalScrollView getFeaturedImagesHorizontalScrollView() {
            return featuredImagesHorizontalScrollView = getView(featuredImagesHorizontalScrollView, R.id.activity_job_details_featured_images_horizintal_scroll_view);
        }

        public NoSwipeRecyclerView getCompanyTagCloud() {
            return companyTagCloud = getView(companyTagCloud, R.id.job_details_company_tags_cloud);
        }
    }
}
