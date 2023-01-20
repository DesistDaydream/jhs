package com.bytedance.msdk.api.v2.ad.custom.base;

import android.app.Activity;

/* loaded from: classes.dex */
public abstract class GMCustomVideoAdapter extends GMCustomBaseAdapter implements IGMCustomLoadAdCall {
    @Deprecated
    public boolean isReady() {
        return true;
    }

    public abstract void showAd(Activity activity);

    public final void showAdInner(Activity activity) {
        try {
            this.a = true;
            showAd(activity);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
