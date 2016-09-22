package com.yapd.alexander.yapd.client.util.code;

import android.os.Build;

/**
 * Created by alexander on 9/22/16.
 */
public class SDKVersion {

    public static boolean isLollipopAndUp() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }
}
