package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import com.baidu.mobads.sdk.internal.a;
import com.baidu.mobads.sdk.internal.ch;
import com.baidu.mobads.sdk.internal.cu;

/* loaded from: classes.dex */
public class ExpressInterstitialAd {
    private InterstitialAdDislikeListener mAdDislikeListener;
    private String mAdPlaceId;
    private String mAppsid;
    private int mBidFloor;
    private Context mContext;
    private ExpressInterstitialListener mExpressInterstitialListener;
    private int mHeight;
    private InterAdDownloadWindowListener mInterAdDownloadWindowListener;
    private cu mNativeInterstitialAdProd;
    private boolean mUseDialogContainer;
    private boolean mUseDialogFrame;
    private int mWidth;
    private boolean onlyFetchAd;

    /* loaded from: classes.dex */
    public interface InterAdDownloadWindowListener {
        void adDownloadWindowClose();

        void adDownloadWindowShow();

        void onADPermissionClose();

        void onADPermissionShow();

        void onADPrivacyClick();

        void onADPrivacyClose();
    }

    /* loaded from: classes.dex */
    public interface InterstitialAdDislikeListener {
        void interstitialAdDislikeClick();
    }

    public ExpressInterstitialAd(Context context, String str) {
        this(context, str, 500, 600);
    }

    private void initNativeInterstitialAdProd() {
        ch chVar = new ch(this.mContext);
        chVar.a(new ch.a() { // from class: com.baidu.mobads.sdk.api.ExpressInterstitialAd.1
            @Override // com.baidu.mobads.sdk.internal.ch.a
            public void onAttachedToWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.ch.a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
                if (ExpressInterstitialAd.this.mNativeInterstitialAdProd != null) {
                    ExpressInterstitialAd.this.mNativeInterstitialAdProd.p();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.ch.a
            public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                return i2 == 4;
            }

            @Override // com.baidu.mobads.sdk.internal.ch.a
            public void onLayoutComplete(int i2, int i3) {
            }

            @Override // com.baidu.mobads.sdk.internal.ch.a
            public void onWindowFocusChanged(boolean z) {
            }

            @Override // com.baidu.mobads.sdk.internal.ch.a
            public void onWindowVisibilityChanged(int i2) {
            }
        });
        this.mNativeInterstitialAdProd = new cu(this.mContext, chVar, this.mAdPlaceId);
        if (!TextUtils.isEmpty(this.mAppsid)) {
            this.mNativeInterstitialAdProd.o = this.mAppsid;
        }
        cu cuVar = this.mNativeInterstitialAdProd;
        cuVar.p = this.mBidFloor;
        cuVar.q = this.onlyFetchAd;
        cuVar.a(this.mExpressInterstitialListener);
        this.mNativeInterstitialAdProd.a(this.mInterAdDownloadWindowListener);
        this.mNativeInterstitialAdProd.a(this.mAdDislikeListener);
        this.mNativeInterstitialAdProd.c(this.mUseDialogFrame);
        this.mNativeInterstitialAdProd.d(this.mUseDialogContainer);
    }

    private void reallyLoad() {
        initNativeInterstitialAdProd();
        this.mNativeInterstitialAdProd.a();
    }

    public void biddingFail(String str) {
        cu cuVar = this.mNativeInterstitialAdProd;
        if (cuVar != null) {
            cuVar.a(false, str);
        }
    }

    public void biddingSuccess(String str) {
        cu cuVar = this.mNativeInterstitialAdProd;
        if (cuVar != null) {
            cuVar.a(true, str);
        }
    }

    public void destroy() {
        cu cuVar = this.mNativeInterstitialAdProd;
        if (cuVar == null) {
            return;
        }
        cuVar.e();
    }

    public String getBiddingToken() {
        this.onlyFetchAd = true;
        initNativeInterstitialAdProd();
        return this.mNativeInterstitialAdProd.m();
    }

    public String getECPMLevel() {
        a w;
        cu cuVar = this.mNativeInterstitialAdProd;
        return (cuVar == null || (w = cuVar.w()) == null) ? "" : w.z();
    }

    public boolean isReady() {
        IAdInterListener iAdInterListener;
        cu cuVar = this.mNativeInterstitialAdProd;
        if (cuVar == null || (iAdInterListener = cuVar.f1464k) == null) {
            return false;
        }
        return iAdInterListener.isAdReady();
    }

    public void load() {
        if (this.mContext == null) {
            Log.e("ExpressInterstitialAd", "请传一个非空的context再进行load");
            return;
        }
        this.onlyFetchAd = true;
        reallyLoad();
    }

    public void loadBiddingAd(String str) {
        cu cuVar = this.mNativeInterstitialAdProd;
        if (cuVar != null) {
            cuVar.c(str);
        }
    }

    public void setAdDislikeListener(InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.mAdDislikeListener = interstitialAdDislikeListener;
    }

    public void setAppSid(String str) {
        this.mAppsid = str;
    }

    public void setBidFloor(int i2) {
        this.mBidFloor = i2;
    }

    @Deprecated
    public void setBiddingData(String str) {
        cu cuVar = this.mNativeInterstitialAdProd;
        if (cuVar != null) {
            cuVar.b(str);
        }
    }

    public void setDialogFrame(boolean z) {
        this.mUseDialogFrame = z;
    }

    public void setDownloadListener(InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.mInterAdDownloadWindowListener = interAdDownloadWindowListener;
    }

    public void setLoadListener(ExpressInterstitialListener expressInterstitialListener) {
        this.mExpressInterstitialListener = expressInterstitialListener;
    }

    public void show() {
        cu cuVar = this.mNativeInterstitialAdProd;
        if (cuVar == null) {
            return;
        }
        if (cuVar.g()) {
            this.mNativeInterstitialAdProd.h();
        } else {
            this.mNativeInterstitialAdProd.f((IOAdEvent) null);
        }
    }

    public void useUseDialogContainer(boolean z) {
        this.mUseDialogContainer = z;
    }

    public ExpressInterstitialAd(Context context, String str, int i2, int i3) {
        this.mUseDialogFrame = false;
        this.mBidFloor = -1;
        this.mUseDialogContainer = false;
        this.mContext = context;
        this.mAdPlaceId = str;
        this.mWidth = i2;
        this.mHeight = i3;
    }

    public void show(Activity activity) {
        cu cuVar = this.mNativeInterstitialAdProd;
        if (cuVar == null) {
            return;
        }
        cuVar.a(activity);
        show();
    }
}
