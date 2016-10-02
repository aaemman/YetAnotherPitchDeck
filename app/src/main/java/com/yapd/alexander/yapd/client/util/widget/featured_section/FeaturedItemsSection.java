package com.yapd.alexander.yapd.client.util.widget.featured_section;

import android.view.View;

import java.util.List;

/**
 * Created by alexander on 10/1/16.
 */
public interface FeaturedItemsSection<T> {
    void setOnItemClickListener(OnItemClickListener<T> onItemClickListener);

    void setItems(List<T> items);


    interface OnItemClickListener<T> {
        void onItemClicked(T t, View view);
    }
}
