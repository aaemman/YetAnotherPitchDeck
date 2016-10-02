package com.yapd.alexander.yapd.client.home.about_me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.util.view.common.BaseFragment;
import com.yapd.alexander.yapd.client.util.view.on_touch_listener.BounceAnimationOnTouchListener;

/**
 * Created by alexander on 9/22/16.
 */
public class AboutMeFragment extends BaseFragment {
    public static final int LAYOUT = R.layout.fragment_about_me;
    private ViewBinder viewBinder;
    private View contentView;

    public static AboutMeFragment getInstance() {
        return new AboutMeFragment();
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
        setupWhyMe();
        setupWhyCornelTech();
        setupCoreValues();
        return contentView;
    }

    private void setupWhyMe() {
        viewBinder.getWhyMe().setOnTouchListener(new BounceAnimationOnTouchListener());
        viewBinder.getWhyMe().setOnClickListener(view -> getActivity().startActivity(WhyMeActivity.getLaunchIntent(getContext())));
    }

    private void setupWhyCornelTech() {
        viewBinder.getWhyCornellTechLayout().setOnTouchListener(new BounceAnimationOnTouchListener());
        viewBinder.getWhyCornellTechLayout().setOnClickListener(view -> getActivity().startActivity(WhyCornellTechActivity.getLaunchIntent(getContext())));
    }

    private void setupCoreValues() {
        viewBinder.getCoreValuesLayout().setOnTouchListener(new BounceAnimationOnTouchListener());
        viewBinder.getCoreValuesLayout().setOnClickListener(view -> getActivity().startActivity(CoreValuesActivity.getLaunchIntent(getContext())));
    }

    private void initializeContentView(ViewGroup container) {
        contentView = LayoutInflater.from(getActivity()).inflate(LAYOUT, container, false);
    }

    // ------ VIEW BINDER ------

    private class ViewBinder extends com.yapd.alexander.yapd.client.util.view.common.ViewBinder {
        private ViewGroup whyMe;
        private ViewGroup whyCornellTechLayout;
        private ViewGroup coreValuesLayout;

        public ViewBinder(View view) {
            super(view);
        }

        public ViewGroup getWhyMe() {
            return whyMe = getView(whyMe, R.id.fragment_about_me_why_me);
        }

        public ViewGroup getWhyCornellTechLayout() {
            return whyCornellTechLayout = getView(whyCornellTechLayout, R.id.fragment_about_me_why_cornell_tech);
        }

        public ViewGroup getCoreValuesLayout() {
            return coreValuesLayout = getView(coreValuesLayout, R.id.fragment_about_me_core_values);
        }
    }
}
