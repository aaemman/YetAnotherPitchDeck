package com.yapd.alexander.yapd.client.job;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.util.view.common.BaseActivity;
import com.yapd.alexander.yapd.core.model.Job;

public class JobDetailsActivity extends BaseActivity implements JobDetailsView {
    public static final String JOB_EXTRA_KEY = "JOB_EXTRA_KEY";
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
        setContentView(R.layout.activity_job_details);

        viewBinder = new ViewBinder(findViewById(android.R.id.content));
        presenter.attachToView(this);

        this.job = getIntent().getParcelableExtra(JOB_EXTRA_KEY);
        presenter.loadContentForJob(job);
    }

    @Override
    public void setHeaderImageViewBackgroundUrl(String url) {
        Glide.with(this)
                .load(url)
                .asBitmap()
                .into(new BitmapImageViewTarget(viewBinder.getHeaderImageView()) {
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

        public ViewBinder(View view) {
            super(view);
        }

        public ImageView getHeaderImageView() {
            return headerImageView = getView(headerImageView, R.id.view_three_item_featured_section_item_first);
        }

    }
}
