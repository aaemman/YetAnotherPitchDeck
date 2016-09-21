package com.yapd.alexander.yapd.util.color;

import android.graphics.Color;

/**
 * Created by alexander on 9/21/16.
 */
public class ColorUtil {
    public static int getPercentAlpha(float percent) {
        return (int) Math.max(0, Math.min(255, 255 * (percent - 0.8) * 5));
    }

    /**
     * Will manipulate a color value to give back that same color with an specific alpha value applied to it
     *
     * @param color which the alpha value is to be applied to
     * @param alpha which will be applied to the base color [0..255]
     * @return An int representing the the base color after the alpha has been provided
     */
    public static int setColorAlpha(int color, int alpha) {
        return Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color));
    }

    /**
     * Blend {@code color1} and {@code color2} using the given ratio.	 *
     *
     * @param ratio of which to blend. 1.0 will return {@code color1}, 0.5 will give an even blend,
     *              0.0 will return {@code color2}.
     * @return The blended color
     */
    public static int blendColors(int color1, int color2, float ratio) {
        final float inverseRation = 1f - ratio;
        float r = (Color.red(color1) * ratio) + (Color.red(color2) * inverseRation);
        float g = (Color.green(color1) * ratio) + (Color.green(color2) * inverseRation);
        float b = (Color.blue(color1) * ratio) + (Color.blue(color2) * inverseRation);
        return Color.rgb((int) r, (int) g, (int) b);
    }

}
