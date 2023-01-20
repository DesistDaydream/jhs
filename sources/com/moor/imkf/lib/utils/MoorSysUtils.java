package com.moor.imkf.lib.utils;

import android.content.Context;

/* loaded from: classes2.dex */
public class MoorSysUtils {
    public static boolean isApkInDebug(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
