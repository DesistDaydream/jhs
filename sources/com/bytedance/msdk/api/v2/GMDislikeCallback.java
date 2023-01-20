package com.bytedance.msdk.api.v2;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public interface GMDislikeCallback {
    void onCancel();

    void onRefuse();

    void onSelected(int i2, @Nullable String str);

    void onShow();
}
