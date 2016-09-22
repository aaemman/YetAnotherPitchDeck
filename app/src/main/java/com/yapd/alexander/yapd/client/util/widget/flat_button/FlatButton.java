package com.yapd.alexander.yapd.client.util.widget.flat_button;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by alexander on 9/21/16.
 */
public class FlatButton extends TextView {
    public FlatButton(Context context) {
        super(context);

        if (!isInEditMode()) {
            this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf"));
        }

        this.setClickable(true);
        this.setFocusable(true);
        this.setGravity(Gravity.CENTER);
    }

    public FlatButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf"));
        }

        this.setClickable(true);
        this.setFocusable(true);
        this.setGravity(Gravity.CENTER);
    }

    public FlatButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs);
        if (!isInEditMode()) {
            this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf"));
        }

        this.setClickable(true);
        this.setFocusable(true);
        this.setGravity(Gravity.CENTER);
    }


}
