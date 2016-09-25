package com.yapd.alexander.yapd.client.util.view.on_touch_listener;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.yapd.alexander.yapd.client.util.view.animation.LiftAnimation;

/**
 * Created by alexander on 9/24/16.
 */
public class LiftAnimationOnTouchListener implements View.OnTouchListener {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            new LiftAnimation().scaleTo(1.0f).elevateFrom(0f).elevateTo(4f).interpolator(new AccelerateDecelerateInterpolator()).lift(view);
        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP || motionEvent.getAction() == MotionEvent.ACTION_CANCEL) {
            new LiftAnimation().scaleTo(1.0f).elevateTo(0f).elevateFrom(4f).interpolator(new DecelerateInterpolator()).release(view);
        }
        return false;
    }
}
