package com.yapd.alexander.yapd.client.util.widget.featured_section;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.util.code.common.Callback;
import com.yapd.alexander.yapd.client.util.view.on_touch_listener.BounceAnimationOnTouchListener;

import java.util.List;

/**
 * Created by alexander on 9/22/16.
 */
public abstract class CircularFeaturedItemsSection<T> extends FrameLayout {
    public static final int LAYOUT = R.layout.view_circular_featured_items_section;
    private ViewBinder viewBinder;
    private Callback<T> onItemClickListener;
    private List<T> items;

    public CircularFeaturedItemsSection(Context context) {
        this(context, null, 0);
    }

    public CircularFeaturedItemsSection(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircularFeaturedItemsSection(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = inflateView();
        viewBinder = new ViewBinder(view);

        setupItem(viewBinder.getFirstFeaturedItem(), 0);
        setupItem(viewBinder.getSecondFeaturedItem(), 1);
        setupItem(viewBinder.getThirdFeaturedItem(), 2);
        setupItem(viewBinder.getFourthFeaturedItem(), 3);
        setupItem(viewBinder.getFifthFeaturedItem(), 4);
    }

    private View inflateView() {
        return LayoutInflater.from(getContext()).inflate(LAYOUT, this, true);
    }

    private void setupItem(View itemView, int minNumberOfItems) {
        if (viewBinder != null) {
            itemView.setOnClickListener(clickedView -> {
                if (this.items != null && items.size() > minNumberOfItems) {
                    onItemClickListener.onCallback(items.get(minNumberOfItems));
                }
            });

            itemView.setOnTouchListener(new BounceAnimationOnTouchListener());
        }
    }

    public void setOnItemClickListener(final Callback<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    protected ViewBinder getViewBinder() {
        return viewBinder;
    }

    // ------ VIEW BINDER ------

    protected class ViewBinder extends com.yapd.alexander.yapd.client.util.view.common.ViewBinder {
        private ImageView firstFeaturedItem;
        private ImageView secondFeaturedItem;
        private ImageView thirdFeaturedItem;
        private ImageView fourthFeaturedItem;
        private ImageView fifthFeaturedItem;

        public ViewBinder(View view) {
            super(view);
        }

        public ImageView getFirstFeaturedItem() {
            return firstFeaturedItem = getView(firstFeaturedItem, R.id.view_three_item_featured_section_item_first);
        }

        public ImageView getSecondFeaturedItem() {
            return secondFeaturedItem = getView(secondFeaturedItem, R.id.view_three_item_featured_section_item_second);
        }

        public ImageView getThirdFeaturedItem() {
            return thirdFeaturedItem = getView(thirdFeaturedItem, R.id.view_three_item_featured_section_item_third);
        }

        public ImageView getFourthFeaturedItem() {
            return fourthFeaturedItem = getView(fourthFeaturedItem, R.id.view_three_item_featured_section_item_fourth);
        }

        public ImageView getFifthFeaturedItem() {
            return fifthFeaturedItem = getView(fifthFeaturedItem, R.id.view_three_item_featured_section_item_fifth);
        }
    }
}
