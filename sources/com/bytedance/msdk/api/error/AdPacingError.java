package com.bytedance.msdk.api.error;

import com.bytedance.msdk.api.AdError;

/* loaded from: classes.dex */
public class AdPacingError extends AdError {
    private String a;
    private String b;

    public AdPacingError(int i2, String str, String str2, String str3) {
        super(i2, str);
        this.a = str2;
        this.b = str3;
    }

    public String getBlockPacing() {
        return this.a;
    }

    public String getRuleId() {
        return this.b;
    }
}
