package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.api.FullScreenVideoAd;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;

/* loaded from: classes.dex */
public class cx extends df {
    private FullScreenVideoAd.FullScreenVideoAdListener a;

    public cx(Context context, String str, boolean z) {
        super(context, str, z, IAdInterListener.AdProdType.PRODUCT_FULLSCREENVIDEO);
    }

    @Override // com.baidu.mobads.sdk.internal.df
    public void a(ScreenVideoAdListener screenVideoAdListener) {
        super.a(screenVideoAdListener);
        if (screenVideoAdListener instanceof FullScreenVideoAd.FullScreenVideoAdListener) {
            this.a = (FullScreenVideoAd.FullScreenVideoAdListener) screenVideoAdListener;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.df, com.baidu.mobads.sdk.internal.ay
    public void f(String str) {
        FullScreenVideoAd.FullScreenVideoAdListener fullScreenVideoAdListener = this.a;
        if (fullScreenVideoAdListener != null) {
            fullScreenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }
}
