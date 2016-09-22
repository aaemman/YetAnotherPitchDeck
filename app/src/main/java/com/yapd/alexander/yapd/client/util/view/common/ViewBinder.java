package com.yapd.alexander.yapd.client.util.view.common;

import android.view.View;

/**
 * Created by alexander on 9/21/16.
 */
public class ViewBinder {
    private View view;

    public ViewBinder(View view) {
        this.view = view;
    }

    private View findViewById(int id) {
        return view.findViewById(id);
    }

    protected <T extends View> T getView(T localView, int id) {
        return localView == null ? (T) findViewById(id) : localView;
    }

}
