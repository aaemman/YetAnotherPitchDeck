package com.yapd.alexander.yapd.util.view.common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander on 9/21/16.
 */
public class TabbedNavigationFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> mPageFragmentList;
    private List<String> mPageTitleList;

    public TabbedNavigationFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mPageFragmentList = new ArrayList();
        mPageTitleList = new ArrayList();
    }

    @Override
    public Fragment getItem(int position) {
        if (pageIsAvailableForPosition(position)) {
            return getPageFragmentList().get(position);
        }
        throw new IllegalArgumentException("TabbedNavigationToolbarFragmentPagerAdapter - The page fragment for the position " + position + " does not exist; make sure that the position you are requesting is greater than or equal to 0 and less than " + getPageTitleList().size());
    }

    @Override
    public int getCount() {
        return mPageFragmentList.size();
    }

    @Override
    public String getPageTitle(int position) {
        if (pageTitleIsAvailableForPosition(position)) {
            return getPageTitleList().get(position);
        }
        throw new IllegalArgumentException("TabbedNavigationToolbarFragmentPagerAdapter - The page title for the position " + position + " does not exist; make sure that the position you are requesting is greater than or equal to 0 and less than " + getPageTitleList().size());
    }

    public void addPage(Fragment pageFragment, String pageTitle) {
        mPageFragmentList.add(pageFragment);
        mPageTitleList.add(pageTitle);
    }

    public void addPage(Fragment pageFragment) {
        addPage(pageFragment, "page " + mPageFragmentList.size());
    }

    public List<Fragment> getPageFragmentList() {
        return mPageFragmentList;
    }

    public void setPageFragmentList(List<Fragment> pageFragmentList) {
        mPageFragmentList = pageFragmentList;
    }

    public List<String> getPageTitleList() {
        return mPageTitleList;
    }

    // ------ HELPERS ------

    private boolean pageIsAvailableForPosition(int position) {
        return position >= 0 && position < getPageFragmentList().size();
    }

    private boolean pageTitleIsAvailableForPosition(int position) {
        return position >= 0 && position < getPageTitleList().size();
    }
}