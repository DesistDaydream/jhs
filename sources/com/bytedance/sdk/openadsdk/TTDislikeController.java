package com.bytedance.sdk.openadsdk;

import android.content.Context;

/* loaded from: classes.dex */
public interface TTDislikeController {
    void onDislikeEvent(Context context, boolean z);

    void onDislikeSelected(FilterWord filterWord);

    void openWebPage(Context context, boolean z);
}
