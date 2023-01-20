package com.baidu.mobads.sdk.api;

import com.tencent.android.tpush.common.Constants;

/* loaded from: classes.dex */
public enum CpuLpFontSize {
    SMALL("sml"),
    REGULAR(Constants.SHARED_PREFS_KEY_REGISTER),
    LARGE("lrg"),
    EXTRA_LARGE("xlg"),
    XX_LARGE("xxl");
    
    public String mValue;

    CpuLpFontSize(String str) {
        this.mValue = str;
    }

    public String getValue() {
        return this.mValue;
    }
}
