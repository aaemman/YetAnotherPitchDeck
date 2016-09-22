package com.yapd.alexander.yapd.client.util.widget.custom_text_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.yapd.alexander.yapd.R;
import com.yapd.alexander.yapd.client.application.Yapd;

/**
 * Created by alexander on 9/21/16.
 */
public class CustomTextView extends TextView {

    private static final Font[] fonts = {Font.NORMAL, Font.BOLD};

    public CustomTextView(Context context) {
        this(context, null);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        apply(context, attrs);
    }

    public void apply(Context context, AttributeSet attrs) {
        if (!isInEditMode()) {
            if (attrs != null) {
                int[] attrsArray = new int[]{R.attr.textStyle};
                TypedArray ta = context.obtainStyledAttributes(attrs, attrsArray);
                int style = ta.getInt(0, 0);
                ta.recycle();
                setFont(fonts[style]);
            }
        }
    }

    public boolean onSetAlpha(float alpha) {
        return onSetAlpha((int) (255 * alpha));
    }

    @Override
    public boolean onSetAlpha(int alpha) {
        setTextColor(getTextColors().withAlpha(alpha));
        setHintTextColor(getHintTextColors().withAlpha(alpha));
        setLinkTextColor(getLinkTextColors().withAlpha(alpha));
        getBackground().setAlpha(alpha);
        return true;
    }

    public void setFont(Font font) {
        setTypeface(font.typeface);
    }

    public enum Font {
        NORMAL(Typeface.createFromAsset(Yapd.getStaticResources().getAssets(), "fonts/Roboto-Light.ttf")),
        BOLD(Typeface.createFromAsset(Yapd.getStaticResources().getAssets(), "fonts/Roboto-Regular.ttf"));

        public Typeface typeface;

        Font(Typeface typeface) {
            this.typeface = typeface;
        }
    }
}

