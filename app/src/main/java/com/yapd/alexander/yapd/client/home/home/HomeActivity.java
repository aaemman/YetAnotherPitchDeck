package com.yapd.alexander.yapd.client.home.home;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.util.widget.sliding_tabs.SlidingTabLayout;

public class HomeActivity extends AppCompatActivity {
    public static final int LAYOUT = R.layout.activity_home;

    private ViewBinder viewBinder;
    private HomeViewPagerAdapter homeViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        setContentView(LAYOUT);

        viewBinder = new ViewBinder(findViewById(android.R.id.content));

        setupProfilePicImageView();
        setupContentViewPager();
        setupTabLayoutForViewPager(viewBinder.getViewPager());


    }

    private void setupProfilePicImageView() {
        Glide.with(this).load(R.mipmap.profile_pic).crossFade().into(viewBinder.getProfilePicImageView());
    }

    private void setupContentViewPager() {
        homeViewPagerAdapter = homeViewPagerAdapter == null ? new HomeViewPagerAdapter(getSupportFragmentManager()) : homeViewPagerAdapter;
        viewBinder.getViewPager().setAdapter(homeViewPagerAdapter);
    }

    private void setupTabLayoutForViewPager(ViewPager viewPager) {
        viewBinder.getSlidingTabLayout().setViewPager(viewPager);
    }

    // ------ VIEW BINDER ------

    private class ViewBinder extends com.yapd.alexander.yapd.client.util.view.common.ViewBinder {
        private ImageView profilePicImageView;
        private SlidingTabLayout slidingTabLayout;
        private ViewPager viewPager;

        public ViewBinder(View view) {
            super(view);
        }

        public ImageView getProfilePicImageView() {
            return profilePicImageView = getView(profilePicImageView, R.id.activity_home_profile_image_view);
        }

        public SlidingTabLayout getSlidingTabLayout() {
            return slidingTabLayout = getView(slidingTabLayout, R.id.activity_home_sliding_tab_layout);
        }

        public ViewPager getViewPager() {
            return viewPager = getView(viewPager, R.id.activity_home_view_pager);
        }
    }
}
