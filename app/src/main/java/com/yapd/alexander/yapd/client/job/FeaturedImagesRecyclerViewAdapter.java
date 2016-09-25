package com.yapd.alexander.yapd.client.job;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.util.view.recyclerView.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexander on 9/24/16.
 */
public class FeaturedImagesRecyclerViewAdapter extends RecyclerView.Adapter<FeaturedImagesRecyclerViewAdapter.FeaturedImageViewHolder> {
    private static final int CELL_LAYOUT = R.layout.featured_image_cell_layout;
    private List<String> imageUrls = new ArrayList<>();

    @Override
    public FeaturedImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FeaturedImageViewHolder(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
    }

    @Override
    public void onBindViewHolder(FeaturedImageViewHolder holder, int position) {
        holder.bindTo(imageUrls.get(position));
    }

    @Override
    public int getItemCount() {
        return imageUrls.size();
    }

    @Override
    public int getItemViewType(int position) {
        return CELL_LAYOUT;
    }

    public void setContent(List<String> urls) {
        this.imageUrls = urls;
    }

    // ------ VIEW HOLDER ------

    public class FeaturedImageViewHolder extends RecyclerView.ViewHolder implements ViewHolder<String> {
        private ViewBinder viewBinder;

        public FeaturedImageViewHolder(View itemView) {
            super(itemView);
            viewBinder = new ViewBinder(itemView);
        }

        @Override
        public void bindTo(String url) {
            Glide.with(viewBinder.getFeaturedImageView().getContext()).load(url).crossFade().into(viewBinder.getFeaturedImageView());
        }

        // ------ VIEW BINDER ------

        private class ViewBinder extends com.yapd.alexander.yapd.client.util.view.common.ViewBinder {
            private ImageView featuredImageView;

            public ViewBinder(View view) {
                super(view);
            }

            public ImageView getFeaturedImageView() {
                return featuredImageView = getView(featuredImageView, R.id.featured_image_cell_layout_featured_image_view);
            }
        }
    }
}
