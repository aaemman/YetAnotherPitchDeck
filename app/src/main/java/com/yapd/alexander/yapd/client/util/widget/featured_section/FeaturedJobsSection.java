package com.yapd.alexander.yapd.client.util.widget.featured_section;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yapd.alexander.yapd.core.model.Job;

import java.util.List;

/**
 * Created by alexander on 9/22/16.
 */
public class FeaturedJobsSection extends CircularFeaturedItemsSection<Job> {
    public FeaturedJobsSection(Context context) {
        this(context, null, 0);
    }

    public FeaturedJobsSection(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeaturedJobsSection(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setItems(List<Job> items) {
        super.setItems(items);
        setItemsForView(getViewBinder().getFirstFeaturedItem(), items, 0);
        setItemsForView(getViewBinder().getSecondFeaturedItem(), items, 1);
        setItemsForView(getViewBinder().getThirdFeaturedItem(), items, 2);
        setItemsForView(getViewBinder().getFourthFeaturedItem(), items, 3);
        setItemsForView(getViewBinder().getFifthFeaturedItem(), items, 4);
    }

    private void setItemsForView(ImageView imageView, List<Job> items, int minNumberOfItems) {
        imageView.setVisibility(items.size() > minNumberOfItems ? VISIBLE : INVISIBLE);
        if (items.size() > minNumberOfItems) {
            Glide.with(getContext()).load(items.get(minNumberOfItems).getCompany().getLogoUrl()).crossFade().into(imageView);
        }
    }
}
