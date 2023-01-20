package com.m7.imkfsdk.utils;

import android.content.Context;
import android.util.TypedValue;
import androidx.annotation.AttrRes;

/* loaded from: classes2.dex */
public class FIleResourceUtil {
    private static int getColorByAttributeId(Context context, @AttrRes int i2) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.data;
    }

    public static int getCurrentColor(Context context, int i2) {
        return getColorByAttributeId(context, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0110, code lost:
        if (r2.equals("bmp") == false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getFile_Icon(android.content.Context r2, java.lang.String r3) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m7.imkfsdk.utils.FIleResourceUtil.getFile_Icon(android.content.Context, java.lang.String):int");
    }
}
