package com.yapd.alexander.yapd.client.venture_details;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yapd.alexander.yapd.R;

import java.util.List;

/**
 * Created by alexander on 9/30/16.
 */
public class SlidesPageAdapter extends PagerAdapter {
    private List<String> urls;

    public SlidesPageAdapter(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public int getCount() {
        return urls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (object);
    }

    @Override
    public View instantiateItem(ViewGroup container, int position) {
        View itemView = LayoutInflater.from(container.getContext()).inflate(R.layout.view_venture_details_slide, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.view_venture_details_slide_image_view);
        Glide.with(container.getContext()).load(urls.get(position)).into(imageView);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}