package com.yapd.alexander.yapd.client.util.view.on_touch_listener;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import com.yapd.alexander.yapd.client.util.view.animation.LiftAnimation;

/**
 * Created by alexander on 9/22/16.
 */
public class BounceAnimationOnTouchListener implements View.OnTouchListener {
    public static final float SCALE_TO = 0.8f;
    public static final float OVERSHOOT_TENSION = 5f;

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            new LiftAnimation().scaleTo(SCALE_TO).interpolator(new AccelerateDecelerateInterpolator()).lift(view);
        } else if (motionEvent.getAction() == MotionEvent.ACTION_UP || motionEvent.getAction() == MotionEvent.ACTION_CANCEL) {
            new LiftAnimation().interpolator(new AnticipateOvershootInterpolator(OVERSHOOT_TENSION)).release(view);
        }
        return false;
    }
}