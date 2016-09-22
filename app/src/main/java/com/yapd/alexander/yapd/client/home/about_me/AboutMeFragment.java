package com.yapd.alexander.yapd.client.home.about_me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.util.view.common.BaseFragment;

/**
 * Created by alexander on 9/22/16.
 */
public class AboutMeFragment extends BaseFragment {
    public static final int LAYOUT = R.layout.fragment_about_me;
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
        return contentView;
    }

    private void initializeContentView(ViewGroup container) {
        contentView = LayoutInflater.from(getActivity()).inflate(LAYOUT, container, false);
    }
}
