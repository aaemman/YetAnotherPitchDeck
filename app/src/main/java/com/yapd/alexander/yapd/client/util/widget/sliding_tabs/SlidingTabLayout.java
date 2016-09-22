package com.yapd.alexander.yapd.client.util.widget.sliding_tabs;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.util.color.ColorUtil;
import com.yapd.alexander.yapd.client.util.widget.custom_text_view.CustomTextView;

import java.util.Map;

/**
 * Created by alexander on 9/21/16.
 */
public class SlidingTabLayout extends FrameLayout {
    private static final int LAYOUT = R.layout.view_sliding_tab_layout;
    private final int DEFAULT_SELECTED_TAB_TEXT_COLOR;
    private final int DEFAULT_SELECTED_TAB_TEXT_ALPHA;
    private final int DEFAULT_UN_SELECTED_TAB_TEXT_COLOR;
    private final int DEFAULT_UN_SELECTED_TAB_TEXT_ALPHA;
    private final int DEFAULT_INITIAL_TAB_INDEX;
    private static final boolean DEFAULT_IS_CUSTOM_TAB_SET = false;
    private static final boolean DEFAULT_SMOOTH_SCROLL_ON_PAGE_CHANGE = true;

    private final float titleOffset;
    private final float tabViewLeftRightPadding;
    private final float tabViewTopBottomPadding;
    private final float tabViewTextSize;

    private final int selectedTabTextColor;
    private final int selectedTabTextAlpha;
    private final int unSelectedTabTextColor;
    private final int unSelectedTabTextAlpha;

    private final boolean highlightSelectedTabTitle;
    private final SparseArray<String> mContentDescriptions = new SparseArray<>();
    private final SlidingTabStrip tabStrip;
    private final Resources mResources;
    private final ViewBinder viewBinder;
    private TabAdapater tabAdapater = new DefaultTabAdapter();

    private boolean distributeEvenly;

    private boolean mIsCustomTabSet = DEFAULT_IS_CUSTOM_TAB_SET;
    private boolean mSmoothScrollOnPageChange = DEFAULT_SMOOTH_SCROLL_ON_PAGE_CHANGE;

    private ViewPager viewPager;
    private ViewPager.OnPageChangeListener mViewPagerOnPageChangeListener;
    private View tabView;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        View view = inflateView();
        viewBinder = new ViewBinder(view);
        viewBinder.getHorizontalScrollView().setHorizontalScrollBarEnabled(false);
        viewBinder.getHorizontalScrollView().setFillViewport(true);
        viewBinder.getHorizontalScrollView().setOverScrollMode(HorizontalScrollView.OVER_SCROLL_NEVER);

        mResources = context.getResources();

        int DEFAULT_TITLE_OFFSET_DIPS = mResources.getDimensionPixelSize(R.dimen.sliding_tab_layout_default_title_offset);
        int DEFAULT_TAB_VIEW_LEFT_RIGHT_PADDING_DIPS = mResources.getDimensionPixelSize(R.dimen.sliding_tab_layout_default_tab_view_left_right_padding);
        int DEFAULT_TAB_VIEW_TOP_BOTTOM_PADDING_DIPS = mResources.getDimensionPixelSize(R.dimen.sliding_tab_layout_default_tab_view_top_bottom_padding);
        int DEFAULT_TAB_VIEW_TEXT_SIZE_SP = mResources.getDimensionPixelSize(R.dimen.sliding_tab_layout_default_tab_view_text_size);
        DEFAULT_SELECTED_TAB_TEXT_ALPHA = 255;
        DEFAULT_UN_SELECTED_TAB_TEXT_ALPHA = 255;
        DEFAULT_INITIAL_TAB_INDEX = 0;

        boolean DEFAULT_HIGHLIGHT_SELECTED_TAB_TITLE = true;
        boolean DEFAULT_DISTRIBUTE_EVENLY = true;

        DEFAULT_SELECTED_TAB_TEXT_COLOR = Color.WHITE;
        DEFAULT_UN_SELECTED_TAB_TEXT_COLOR = Color.WHITE;


        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SlidingTabLayout);

        titleOffset = attributes.getDimensionPixelSize(R.styleable.SlidingTabLayout_titleOffset, DEFAULT_TITLE_OFFSET_DIPS);
        tabViewLeftRightPadding = attributes.getDimensionPixelSize(R.styleable.SlidingTabLayout_tabViewLeftRightPadding, DEFAULT_TAB_VIEW_LEFT_RIGHT_PADDING_DIPS);
        tabViewTopBottomPadding = attributes.getDimensionPixelSize(R.styleable.SlidingTabLayout_tabViewTopBottomPadding, DEFAULT_TAB_VIEW_TOP_BOTTOM_PADDING_DIPS);
        tabViewTextSize = attributes.getDimensionPixelSize(R.styleable.SlidingTabLayout_tabTitleTextSize, DEFAULT_TAB_VIEW_TEXT_SIZE_SP);

        selectedTabTextAlpha = attributes.getInt(R.styleable.SlidingTabLayout_selectedTabTextAlpha, DEFAULT_SELECTED_TAB_TEXT_ALPHA);
        unSelectedTabTextAlpha = attributes.getInt(R.styleable.SlidingTabLayout_unSelectedTabTextAlpha, DEFAULT_UN_SELECTED_TAB_TEXT_ALPHA);

        highlightSelectedTabTitle = attributes.getBoolean(R.styleable.SlidingTabLayout_highlightSelectedTabTitle, DEFAULT_HIGHLIGHT_SELECTED_TAB_TITLE);
        distributeEvenly = attributes.getBoolean(R.styleable.SlidingTabLayout_distributeEvenly, DEFAULT_DISTRIBUTE_EVENLY);

        selectedTabTextColor = attributes.getColor(R.styleable.SlidingTabLayout_selectedTabTextColor, DEFAULT_SELECTED_TAB_TEXT_COLOR);
        unSelectedTabTextColor = attributes.getColor(R.styleable.SlidingTabLayout_unSelectedTabTextColor, DEFAULT_UN_SELECTED_TAB_TEXT_COLOR);

        attributes.recycle();

        tabStrip = new SlidingTabStrip(context, attrs);
        viewBinder.getHorizontalScrollView().addView(tabStrip, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    private View inflateView() {
        return LayoutInflater.from(getContext()).inflate(LAYOUT, this, true);
    }

    public void setCustomTabColorizer(TabColorizer tabColorizer) {
        tabStrip.setCustomTabColorizer(tabColorizer);
    }

    public void setDistributeEvenly(boolean distributeEvenly) {
        this.distributeEvenly = distributeEvenly;
    }

    public void setSelectedIndicatorColors(int... colors) {
        tabStrip.setSelectedIndicatorColors(colors);
    }

    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        mViewPagerOnPageChangeListener = listener;
    }

    public ViewPager.OnPageChangeListener getOnPageChangeListener() {
        return mViewPagerOnPageChangeListener;
    }

    protected ViewPager getViewPager() {
        return viewPager;
    }

    protected SlidingTabStrip getTabStrip() {
        return tabStrip;
    }

    public boolean shouldSmoothScrollOnPageChange() {
        return mSmoothScrollOnPageChange;
    }

    public void setSmoothScrollOnPageChange(boolean smoothScrollOnPageChange) {
        if (viewPager != null) {
            throw new IllegalArgumentException("SlidingTabLayout - You must first set isSmoothScrollOnPageChange before setting the ViewPager in order for it to take effect");
        }
        mSmoothScrollOnPageChange = smoothScrollOnPageChange;
    }

    public void setCustomTabAdapter(TabAdapater customTabView) {
        if (viewPager != null) {
            throw new IllegalArgumentException("SlidingTabLayout - You must set the customTabView BEFORE setting the viewpager in order for it to take effect");
        }
        mIsCustomTabSet = true;
        tabAdapater = customTabView;
    }

    public void setTextViewsForPositionsFromMap(int textViewLayoutId, Map<Integer, String> map) {
        if (textViewLayoutId > 0) {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                Integer key = Integer.valueOf(entry.getKey());
                String value = entry.getValue();
                if (key != null) {
                    setTextForPositionInCustomLayout(value, key, textViewLayoutId);
                }
            }
        } else {
            throw new IllegalArgumentException("SlidingTabLayout - You must provide this method with teh id of the textView you would like to setText on");
        }
    }

    public void setTextViewsForPositionsFromArray(int textViewLayoutId, String[] textArray) {
        if (textViewLayoutId > 0) {
            for (int i = 0; i < textArray.length; i++) {
                setTextForPositionInCustomLayout(textArray[i], i, textViewLayoutId);
            }
        } else {
            throw new IllegalArgumentException("SlidingTabLayout - You must provide this method with teh id of the textView you would like to setText on");
        }
    }

    public void setTextViewsForPositions(int textViewLayoutId, String... textArray) {
        if (textViewLayoutId != 0) {
            for (int i = 0; i < textArray.length; i++) {
                setTextForPositionInCustomLayout(textArray[i], i, textViewLayoutId);
            }
        } else {
            throw new IllegalArgumentException("SlidingTabLayout - You must provide this method with the id of the textView you would like to setText on");
        }
    }

    private boolean setTextForPositionInCustomLayout(String textViewText, int position, int textViewLayoutId) {

        // find layout at position
        View parentView = tabStrip.getChildAt(position);
        if (mIsCustomTabSet && parentView != null) {

            View childView = parentView.findViewById(textViewLayoutId);

            if (childView == null) {
                throw new IllegalArgumentException("SlidingTabLayout - YOU ARE TRYING TO SET TEXT ON A NULL TEXTVIEW, PLEASE ENSURE THAT THE VIEWS HAVE BEEN INFLATED BEFORE SETTING TEXT ON THEM");
            }

            if (childView instanceof TextView) {
                ((TextView) childView).setText(textViewText);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public void setContentDescription(int i, String desc) {
        mContentDescriptions.put(i, desc);
    }

    public ViewPager.OnPageChangeListener getViewPagerOnPageChangeListener() {
        return mViewPagerOnPageChangeListener;
    }

    public void setViewPager(final ViewPager viewPager) {
        tabStrip.removeAllViews();
        this.viewPager = viewPager;
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new SlidingTabLayoutOnPageChangeListener());
            populateTabStrip();
        }
    }

    private void populateTabStrip() {
        final PagerAdapter adapter = viewPager.getAdapter();
        final OnClickListener tabClickListener = getTabClickListener();
        CustomTextView tabTitleTextView = null;

        for (int i = 0; i < adapter.getCount(); i++) {
            tabView = tabAdapater.getTabView();
            tabAdapater.bindTabView(tabView, i);
            tabStrip.addView(tabView);

            if (distributeEvenly) {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                lp.width = 0;
                lp.weight = 1;
            }

            if (tabView instanceof CustomTextView) {
                tabTitleTextView = (CustomTextView) tabView;
                tabTitleTextView.setText(adapter.getPageTitle(i));

                if (mViewPagerOnPageChangeListener == null && areCustomTextColorsSet()) {
                    if (i == DEFAULT_INITIAL_TAB_INDEX && highlightSelectedTabTitle) {
                        tabTitleTextView.setTextColor(ColorUtil.setColorAlpha(selectedTabTextColor, selectedTabTextAlpha));
                        tabTitleTextView.setFont(CustomTextView.Font.BOLD);
                    } else {
                        tabTitleTextView.setTextColor(ColorUtil.setColorAlpha(unSelectedTabTextColor, unSelectedTabTextAlpha));
                        tabTitleTextView.setFont(CustomTextView.Font.NORMAL);
                    }
                }
            }

            tabView.setOnClickListener(tabClickListener);
            String desc = mContentDescriptions.get(i, null);
            if (desc != null) {
                tabView.setContentDescription(desc);
            }

            if (i == viewPager.getCurrentItem()) {
                tabView.setSelected(true);
            }
        }
    }

    public OnClickListener getTabClickListener() {
        return new TabClickListener();
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        if (viewPager != null) {
            scrollToTab(viewPager.getCurrentItem(), DEFAULT_INITIAL_TAB_INDEX);
        }
    }

    protected void scrollToTab(int tabIndex, int positionOffset) {
        final int tabStripChildCount = tabStrip.getChildCount();
        if (tabStripChildCount == 0 || tabIndex < 0 || tabIndex >= tabStripChildCount) {
            return;
        }

        View selectedChild = tabStrip.getChildAt(tabIndex);
        if (selectedChild != null && selectedChild.getMeasuredWidth() != 0) {
            int targetScrollX = selectedChild.getLeft() + positionOffset;
            if (tabIndex > 0 || positionOffset > 0) {
                // If we're not at the first child and are mid-scroll, make sure we obey the offset
                targetScrollX -= titleOffset * mResources.getDisplayMetrics().density;
            }

            viewBinder.getHorizontalScrollView().scrollTo(targetScrollX, 0);
        }
    }

    private CustomTextView getTitleTextViewAt(int position) {
        if (!mIsCustomTabSet) {
            return (CustomTextView) tabStrip.getChildAt(position);
        } else {
            return null;
        }
    }

    private boolean areCustomTextColorsSet() {
        return selectedTabTextColor != DEFAULT_SELECTED_TAB_TEXT_COLOR ||
                selectedTabTextAlpha != DEFAULT_SELECTED_TAB_TEXT_ALPHA ||
                unSelectedTabTextColor != DEFAULT_UN_SELECTED_TAB_TEXT_COLOR ||
                unSelectedTabTextAlpha != DEFAULT_UN_SELECTED_TAB_TEXT_ALPHA;
    }

// ------ PUBLIC INTERFACES ------

    public interface TabColorizer {
        int getIndicatorColor(int position);

        int getDividerColor(int position);
    }

// ------ INNER CLASSES ------

    public class TabClickListener implements OnClickListener {

        @Override
        public final void onClick(View v) {
            for (int i = 0; i < tabStrip.getChildCount(); i++) {
                if (v == tabStrip.getChildAt(i)) {
                    viewPager.setCurrentItem(i, mSmoothScrollOnPageChange);
                    onTabClicked(i, v);
                    return;
                }
            }
        }

        public void onTabClicked(int position, View view) {
            //
        }
    }

    // ------ VIEW BINDER ------

    private class ViewBinder extends com.yapd.alexander.yapd.client.util.view.common.ViewBinder {
        private HorizontalScrollView horizontalScrollView;

        public ViewBinder(View view) {
            super(view);
        }

        public HorizontalScrollView getHorizontalScrollView() {
            return horizontalScrollView = getView(horizontalScrollView, R.id.view_sliding_tab_layout_horizontal_scroll_view);
        }
    }

// ------ HELPER CLASSES ------

    public class SlidingTabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {

        private int mScrollState;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int tabStripChildCount = tabStrip.getChildCount();
            if ((tabStripChildCount == 0) || (position < 0) || (position >= tabStripChildCount)) {
                return;
            }

            tabStrip.onViewPagerPageChanged(position, positionOffset);

            View selectedTab = tabStrip.getChildAt(position);
            int extraOffset = (selectedTab != null) ? (int) (positionOffset * (selectedTab.getWidth() + ((MarginLayoutParams) selectedTab.getLayoutParams()).leftMargin + ((MarginLayoutParams) selectedTab.getLayoutParams()).rightMargin)) : 0;
            if (positionOffset >= 0.1f) {
                scrollToTab(position, extraOffset);
            }
            if (getViewPagerOnPageChangeListener() != null) {
                getViewPagerOnPageChangeListener().onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
        }

        @Override
        public void onPageSelected(int position) {
            if (mScrollState == ViewPager.SCROLL_STATE_IDLE) {
                tabStrip.onViewPagerPageChanged(position, 0f);
                scrollToTab(position, 0);
            }
            for (int i = 0; i < tabStrip.getChildCount(); i++) {
                View tab = tabStrip.getChildAt(i);
                tab.setSelected(position == i);

                CustomTextView tabTitleTextView = getTitleTextViewAt(i);

                if (areCustomTextColorsSet() && tabTitleTextView != null) {
                    if (i == position && highlightSelectedTabTitle) {
                        tabTitleTextView.setTextColor(ColorUtil.setColorAlpha(selectedTabTextColor, selectedTabTextAlpha));
                        tabTitleTextView.setFont(CustomTextView.Font.BOLD);
                    } else {
                        tabTitleTextView.setTextColor(ColorUtil.setColorAlpha(unSelectedTabTextColor, unSelectedTabTextAlpha));
                        tabTitleTextView.setFont(CustomTextView.Font.NORMAL);
                    }
                }
            }

            if (mViewPagerOnPageChangeListener != null) {
                mViewPagerOnPageChangeListener.onPageSelected(position);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            mScrollState = state;

            if (mViewPagerOnPageChangeListener != null) {
                mViewPagerOnPageChangeListener.onPageScrollStateChanged(state);
            }
        }
    }

    public static abstract class TabAdapater {
        public abstract View getTabView();

        public abstract void bindTabView(View tabView, int position);
    }

    public class DefaultTabAdapter extends TabAdapater {

        @Override
        public View getTabView() {
            return createDefaultTabView(getContext());
        }

        protected CustomTextView createDefaultTabView(Context context) {
            CustomTextView textView = new CustomTextView(context);
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, tabViewTextSize);
            textView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            TypedValue outValue = new TypedValue();
            getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
            textView.setBackgroundResource(outValue.resourceId);
            textView.setAllCaps(false);

            int leftRightPadding = (int) (tabViewLeftRightPadding * mResources.getDisplayMetrics().density);
            int topBottomPadding = (int) (tabViewTopBottomPadding * mResources.getDisplayMetrics().density);
            textView.setPadding(leftRightPadding, topBottomPadding, leftRightPadding, topBottomPadding);

            return textView;
        }

        @Override
        public void bindTabView(View tabView, int position) {
            final PagerAdapter adapter = viewPager.getAdapter();
            ((CustomTextView) tabView).setText(adapter.getPageTitle(position));
        }
    }
}
