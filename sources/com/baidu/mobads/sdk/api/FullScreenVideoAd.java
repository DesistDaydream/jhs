package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.cx;
import com.baidu.mobads.sdk.internal.df;

/* loaded from: classes.dex */
public class FullScreenVideoAd {
    private static final String TAG = "FullScreenVideoAd";
    private df mAdProd;
    private final Context mContext;

    /* loaded from: classes.dex */
    public interface FullScreenVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f2);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f2);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener) {
        this(context, str, fullScreenVideoAdListener, false);
    }

    public void biddingFail(String str) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.a(false, str);
        }
    }

    public void biddingSuccess(String str) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.a(true, str);
        }
    }

    public String getBiddingToken() {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            return dfVar.m();
        }
        return null;
    }

    public String getECPMLevel() {
        df dfVar = this.mAdProd;
        return dfVar != null ? dfVar.h() : "";
    }

    public boolean isReady() {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            return dfVar.g();
        }
        return false;
    }

    public synchronized void load() {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.a();
        }
    }

    public void loadBiddingAd(String str) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.c(str);
        }
    }

    public void setAppSid(String str) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.g(str);
        }
    }

    public void setBidFloor(int i2) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.p = i2;
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.b(str);
        }
    }

    public synchronized void show() {
        df dfVar = this.mAdProd;
        if (dfVar != null) {
            dfVar.f();
        }
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, boolean z) {
        this.mContext = context;
        cx cxVar = new cx(context, str, z);
        this.mAdProd = cxVar;
        cxVar.a(fullScreenVideoAdListener);
    }
}
