package com.yapd.alexander.yapd.client.home.home;

import android.support.v4.app.FragmentManager;

import com.yapd.alexander.yapd.client.home.about_me.AboutMeFragment;
import com.yapd.alexander.yapd.client.home.experience.ExperienceFragment;
import com.yapd.alexander.yapd.client.home.growth_plan.GrowthPlanFragment;
import com.yapd.alexander.yapd.client.util.view.common.TabbedNavigationFragmentPagerAdapter;

/**
 * Created by alexander on 9/21/16.
 */
public class HomeViewPagerAdapter extends TabbedNavigationFragmentPagerAdapter {
    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
        addPage(AboutMeFragment.getInstance(), "About Me");
        addPage(ExperienceFragment.getInstance(), "Experience");
        addPage(new GrowthPlanFragment(), "Growth Plan");
    }
}
