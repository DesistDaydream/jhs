package com.m7.imkfsdk.view.pickerview.utils;

import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class PickerViewAnimateUtil {
    private static final int INVALID = -1;

    public static int getAnimationResource(int i2, boolean z) {
        if (i2 != 80) {
            return -1;
        }
        return z ? R.anim.ykfsdk_slide_in_bottom : R.anim.ykfsdk_slide_out_bottom;
    }
}
