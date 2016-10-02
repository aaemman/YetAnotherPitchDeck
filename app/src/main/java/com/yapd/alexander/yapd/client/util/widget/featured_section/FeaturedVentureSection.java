package com.yapd.alexander.yapd.client.util.widget.featured_section;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yapd.alexander.yapd.core.model.Venture;

import java.util.List;

/**
 * Created by alexander on 10/1/16.
 */
public class FeaturedVentureSection extends RectangularFeaturedItemsSection<Venture> {

    public FeaturedVentureSection(Context context) {
        this(context, null, 0);
    }

    public FeaturedVentureSection(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FeaturedVentureSection(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setItems(List<Venture> items) {
        super.setItems(items);
        setupItem(getViewBinder().getItemImageView1(), items.get(0));
        setupItem(getViewBinder().getItemImageView2(), items.get(1));
    }

    private void setupItem(ImageView imageView, Venture venture) {
        Glide.with(getContext()).load(venture.getCompany().getFeaturedImageUrls().get(0)).crossFade().into(imageView);
    }
}
