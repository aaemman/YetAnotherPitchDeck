package com.yapd.alexander.yapd.client.util.widget.featured_section;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.util.view.on_touch_listener.BounceAnimationOnTouchListener;

import java.util.List;

/**
 * Created by alexander on 10/1/16.
 */
public abstract class RectangularFeaturedItemsSection<T> extends FrameLayout implements FeaturedItemsSection<T> {
    public static final int LAYOUT = R.layout.view_rectangular_featured_items_section;
    private CircularFeaturedItemsSection.OnItemClickListener<T> ventureOnItemClickListener;
    private ViewBinder viewBinder;

    private List<T> items;

    public RectangularFeaturedItemsSection(Context context) {
        this(context, null, 0);
    }

    public RectangularFeaturedItemsSection(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RectangularFeaturedItemsSection(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = inflateView();
        viewBinder = new ViewBinder(view);
        setupItem(viewBinder.getItemImageView1(), 0);
        setupItem(viewBinder.getItemImageView2(), 1);
    }

    private View inflateView() {
        return LayoutInflater.from(getContext()).inflate(LAYOUT, this, true);
    }

    protected void setupItem(ImageView itemLayout, int index) {
        itemLayout.setOnTouchListener(new BounceAnimationOnTouchListener());
        itemLayout.setOnClickListener(view -> {
            if (ventureOnItemClickListener != null && items != null && items.size() > index) {
                ventureOnItemClickListener.onItemClicked(items.get(index), view);
            }
        });
    }

    @Override
    public void setOnItemClickListener(FeaturedItemsSection.OnItemClickListener<T> onItemClickListener) {
        this.ventureOnItemClickListener = onItemClickListener;
    }

    @Override
    public void setItems(List<T> items) {
        this.items = items;
    }

    protected ViewBinder getViewBinder() {
        return viewBinder;
    }

    // ------ VIEW BINDER ------

    protected class ViewBinder extends com.yapd.alexander.yapd.client.util.view.common.ViewBinder {
        private ImageView itemImageView1;
        private ImageView itemImageView2;

        public ViewBinder(View view) {
            super(view);
        }

        public ImageView getItemImageView1() {
            return itemImageView1 = getView(itemImageView1, R.id.view_rectangular_featured_items_image_view_1);
        }

        public ImageView getItemImageView2() {
            return itemImageView2 = getView(itemImageView2, R.id.view_rectangular_featured_items_image_view_2);
        }
    }

}
