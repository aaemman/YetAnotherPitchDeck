package com.yapd.alexander.yapd.client.util.code;

/**
 * Created by alexander on 10/1/16.
 */
public class StringUtil {
    public static boolean isEmpty(String string) {
        return string == null || string.trim().equals("") || string.equals("null");
    }
}
