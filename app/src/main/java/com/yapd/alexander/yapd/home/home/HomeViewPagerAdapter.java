package com.yapd.alexander.yapd.home.home;

import android.support.v4.app.FragmentManager;

import com.yapd.alexander.yapd.home.entrepreneurship.SampleFragment;
import com.yapd.alexander.yapd.util.view.common.TabbedNavigationFragmentPagerAdapter;

/**
 * Created by alexander on 9/21/16.
 */
public class HomeViewPagerAdapter extends TabbedNavigationFragmentPagerAdapter {
    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
        addPage(new SampleFragment(), "Experience");
        addPage(new SampleFragment(), "Growth Plan");
        addPage(new SampleFragment(), "About Me");
    }
}
