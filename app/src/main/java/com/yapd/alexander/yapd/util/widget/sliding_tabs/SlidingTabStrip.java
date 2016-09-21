package com.yapd.alexander.yapd.util.widget.sliding_tabs;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.util.color.ColorUtil;

/**
 * Created by alexander on 9/21/16.
 */
class SlidingTabStrip extends LinearLayout {

    private final int mBottomBorderHeight;
    private final int mDividerHeight;
    private final int mSelectedIndicatorHeight;

    private final Paint mBottomBorderPaint;
    private final Paint mSelectedIndicatorPaint;
    private final Paint mDividerPaint;

    private final boolean mShowBottomBorder;
    private final boolean mShowDividers;
    private final boolean mShowSelectedIndicator;

    private final SimpleTabColorizer mDefaultTabColorizer;

    private int mSelectedPosition;

    private float mSelectionOffset;

    private SlidingTabLayout.TabColorizer mCustomTabColorizer;

    SlidingTabStrip(Context context, AttributeSet attrs) {
        super(context, attrs);
        Resources resources = context.getResources();
        setGravity(Gravity.LEFT);
        setWillNotDraw(false);
        mDefaultTabColorizer = new SimpleTabColorizer();

        int DEFAULT_BOTTOM_BORDER_HEIGHT_DIPS = resources.getDimensionPixelSize(R.dimen.sliding_tab_strip_default_bottom_border_height);
        int DEFAULT_DIVIDER_HEIGHT_DIPS = resources.getDimensionPixelSize(R.dimen.sliding_tab_strip_default_divider_height);
        int DEFAULT_DIVIDER_THICKNESS_DIPS = resources.getDimensionPixelSize(R.dimen.sliding_tab_strip_default_divider_thickness);
        int DEFAULT_SELECTED_INDICATOR_HEIGHT_DIPS = resources.getDimensionPixelSize(R.dimen.sliding_tab_strip_default_selected_indicator_height);

        int DEFAULT_BOTTOM_BORDER_ALPHA = 255;
        int DEFAULT_SELECTED_INDICATOR_ALPHA = 255;
        int DEFAULT_DIVIDER_ALPHA = 255;

        boolean DEFAULT_SHOW_BOTTOM_BORDER = true;
        boolean DEFAULT_SHOW_DIVIDERS = true;
        boolean DEFAULT_SHOW_SELECTED_INDICATOR = true;

        int DEFAULT_BOTTOM_BORDER_COLOR = Color.WHITE;
        int DEFAULT_DIVIDER_COLOR = Color.WHITE;
        int DEFAULT_SELECTED_INDICATOR_COLOR = Color.WHITE;


        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.SlidingTabLayout);

        mSelectedIndicatorHeight = attributes.getDimensionPixelOffset(R.styleable.SlidingTabLayout_selectedIndicatorHeight, DEFAULT_SELECTED_INDICATOR_HEIGHT_DIPS);
        mDividerHeight = attributes.getDimensionPixelOffset(R.styleable.SlidingTabLayout_dividerHeight, DEFAULT_DIVIDER_HEIGHT_DIPS);
        mBottomBorderHeight = attributes.getDimensionPixelOffset(R.styleable.SlidingTabLayout_bottomBorderHeight, DEFAULT_BOTTOM_BORDER_HEIGHT_DIPS);

        int bottomBorderAlpha = attributes.getInt(R.styleable.SlidingTabLayout_bottomBorderAlpha, DEFAULT_BOTTOM_BORDER_ALPHA);
        int dividerAlpha = attributes.getInt(R.styleable.SlidingTabLayout_dividerAlpha, DEFAULT_DIVIDER_ALPHA);
        int selectedIndicatorAlpha = attributes.getInt(R.styleable.SlidingTabLayout_selectedIndicatorAlpha, DEFAULT_SELECTED_INDICATOR_ALPHA);

        mShowBottomBorder = attributes.getBoolean(R.styleable.SlidingTabLayout_showBottomBorder, DEFAULT_SHOW_BOTTOM_BORDER);
        mShowDividers = attributes.getBoolean(R.styleable.SlidingTabLayout_showTabDividers, DEFAULT_SHOW_DIVIDERS);
        mShowSelectedIndicator = attributes.getBoolean(R.styleable.SlidingTabLayout_showSelectedIndicator, DEFAULT_SHOW_SELECTED_INDICATOR);

        int dividerColor = attributes.getColor(R.styleable.SlidingTabLayout_dividerColor, DEFAULT_DIVIDER_COLOR);
        int selectedIndicatorColor = attributes.getColor(R.styleable.SlidingTabLayout_selectedIndicatorColor, DEFAULT_SELECTED_INDICATOR_COLOR);
        int bottomBorderColor = attributes.getColor(R.styleable.SlidingTabLayout_bottomBorderColor, DEFAULT_BOTTOM_BORDER_COLOR);

        attributes.recycle();

        if (mShowBottomBorder) {
            mBottomBorderPaint = new Paint();
            mBottomBorderPaint.setColor(bottomBorderColor);
            mBottomBorderPaint.setAlpha(bottomBorderAlpha);
        } else {
            mBottomBorderPaint = null;
        }

        if (mShowDividers) {
            mDefaultTabColorizer.setDividerColors(ColorUtil.setColorAlpha(dividerColor, dividerAlpha));
            mDividerPaint = new Paint();
            mDividerPaint.setStrokeWidth(DEFAULT_DIVIDER_THICKNESS_DIPS);
            mDividerPaint.setColor(dividerColor);
            mDividerPaint.setAlpha(dividerAlpha);
        } else {
            mDefaultTabColorizer.setDividerColors(ColorUtil.setColorAlpha(Color.TRANSPARENT, dividerAlpha));
            mDividerPaint = null;
        }

        if (mShowSelectedIndicator) {
            mSelectedIndicatorPaint = new Paint();
            mSelectedIndicatorPaint.setColor(selectedIndicatorColor);
            mSelectedIndicatorPaint.setAlpha(selectedIndicatorAlpha);
            mDefaultTabColorizer.setIndicatorColors(ColorUtil.setColorAlpha(selectedIndicatorColor, selectedIndicatorAlpha));
        } else {
            mDefaultTabColorizer.setIndicatorColors(ColorUtil.setColorAlpha(Color.TRANSPARENT, selectedIndicatorAlpha));
            mSelectedIndicatorPaint = null;
        }
    }

    public void setCustomTabColorizer(SlidingTabLayout.TabColorizer customTabColorizer) {
        mCustomTabColorizer = customTabColorizer;
        invalidate();
    }

    public void setSelectedIndicatorColors(int... colors) {
        mCustomTabColorizer = null;
        mDefaultTabColorizer.setIndicatorColors(colors);
        invalidate();
    }

    public void setDividerColors(int... colors) {
        mCustomTabColorizer = null;
        mDefaultTabColorizer.setDividerColors(colors);
        invalidate();
    }

    public void onViewPagerPageChanged(int position, float positionOffset) {
        mSelectedPosition = position;
        mSelectionOffset = positionOffset;

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        final int height = getHeight();
        final int childCount = getChildCount();
        final int dividerHeightPx = (int) (Math.min(Math.max(0f, mDividerHeight), 1f) * height);
        final SlidingTabLayout.TabColorizer tabColorizer = mCustomTabColorizer != null
                ? mCustomTabColorizer
                : mDefaultTabColorizer;

        if (mShowSelectedIndicator) {
            if (childCount > 0) {
                View selectedTitle = getChildAt(mSelectedPosition);
                int left = selectedTitle.getLeft();
                int right = selectedTitle.getRight();
                int color = tabColorizer.getIndicatorColor(mSelectedPosition);

                if (mSelectionOffset > 0f && mSelectedPosition < (getChildCount() - 1)) {
                    int nextColor = tabColorizer.getIndicatorColor(mSelectedPosition + 1);
                    if (color != nextColor) {
                        color = ColorUtil.blendColors(nextColor, color, mSelectionOffset);
                    }

                    View nextTitle = getChildAt(mSelectedPosition + 1);
                    left = (int) (mSelectionOffset * nextTitle.getLeft() +
                            (1.0f - mSelectionOffset) * left);
                    right = (int) (mSelectionOffset * nextTitle.getRight() +
                            (1.0f - mSelectionOffset) * right);
                }

                mSelectedIndicatorPaint.setColor(color);

                canvas.drawRect(left, height - mSelectedIndicatorHeight, right,
                        height, mSelectedIndicatorPaint);
            }
        }

        if (mShowBottomBorder) {
            canvas.drawRect(0, height - mBottomBorderHeight, getWidth(), height, mBottomBorderPaint);
        }

        if (mShowDividers) {
            int separatorTop = (height - dividerHeightPx) / 2;
            for (int i = 0; i < childCount - 1; i++) {
                View child = getChildAt(i);
                mDividerPaint.setColor(tabColorizer.getDividerColor(i));
                canvas.drawLine(child.getRight(), separatorTop, child.getRight(),
                        separatorTop + dividerHeightPx, mDividerPaint);
            }
        }
    }

    // STATIC INNER CLASSES

    private static class SimpleTabColorizer implements SlidingTabLayout.TabColorizer {
        private int[] mIndicatorColors;
        private int[] mDividerColors;

        @Override
        public final int getIndicatorColor(int position) {
            return mIndicatorColors[position % mIndicatorColors.length];
        }

        @Override
        public final int getDividerColor(int position) {
            return mDividerColors[position % mDividerColors.length];
        }

        void setIndicatorColors(int... colors) {
            mIndicatorColors = colors;
        }

        void setDividerColors(int... colors) {
            mDividerColors = colors;
        }
    }
}