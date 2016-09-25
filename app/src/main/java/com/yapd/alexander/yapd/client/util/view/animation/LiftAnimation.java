package com.yapd.alexander.yapd.client.util.view.animation;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

import com.yapd.alexander.yapd.client.util.code.SDKVersion;

/**
 * Created by alexander on 9/22/16.
 */
public class LiftAnimation {
    private static final float DEFAULT_DECELERATE_INTERPOLATOR_TENSION = 4f;

    private float mElevateFrom = 0f;
    private float mElevateTo = 15f;
    private float mScaleTo = 1.05f;
    private long mDuration = 100l;
    private Interpolator mInterpolator = new DecelerateInterpolator(DEFAULT_DECELERATE_INTERPOLATOR_TENSION);

    public LiftAnimation elevateFrom(float elevateFrom) {
        mElevateFrom = elevateFrom;
        return this;
    }

    public LiftAnimation elevateTo(float elevateTo) {
        mElevateTo = elevateTo;
        return this;
    }

    public LiftAnimation scaleTo(float scaleTo) {
        mScaleTo = scaleTo;
        return this;
    }

    public LiftAnimation duration(long duration) {
        mDuration = duration;
        return this;
    }

    public LiftAnimation interpolator(Interpolator interpolator) {
        mInterpolator = interpolator;
        return this;
    }

    public void lift(View view) {
        if (SDKVersion.isLollipopAndUp()) {
            view.setElevation(mElevateTo);
            view.setTranslationZ(mElevateTo);
        }
        view.animate().scaleX(mScaleTo).scaleY(mScaleTo).setInterpolator(mInterpolator).setDuration(mDuration).start();
    }

    public void release(View view) {
        if (SDKVersion.isLollipopAndUp()) {
            view.setElevation(mElevateTo);
            view.setTranslationZ(mElevateTo);
        }
        view.animate().scaleX(1.0f).scaleY(1.0f).setInterpolator(mInterpolator).setDuration(mDuration).start();
    }
}
