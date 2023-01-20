package com.baidu.mobads.sdk.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.bj;
import com.baidu.mobads.sdk.internal.ch;
import com.baidu.mobads.sdk.internal.dd;
import com.baidu.mobads.sdk.internal.x;

/* loaded from: classes.dex */
public class InterstitialAd {
    public static final String TAG = "InterstitialAd";
    private boolean initialized;
    private InterstitialAdListener listener;
    private final bj mAdLogger;
    private x mXInterstitial;

    public InterstitialAd(Context context, String str) {
        this(context, AdSize.InterstitialGame, str);
    }

    private boolean isInterstitial(AdSize adSize) {
        return adSize.getValue() <= AdSize.InterstitialOther.getValue() && adSize.getValue() >= AdSize.InterstitialGame.getValue();
    }

    private boolean isInterstitialPause(AdSize adSize) {
        return adSize.getValue() >= AdSize.InterstitialForVideoBeforePlay.getValue() && adSize.getValue() <= AdSize.InterstitialForVideoPausePlay.getValue();
    }

    public void destroy() {
        this.mXInterstitial.e();
    }

    public boolean isAdReady() {
        return this.mXInterstitial.c();
    }

    public void loadAd() {
        if (!this.initialized) {
            this.mXInterstitial.f();
            this.initialized = true;
        }
        this.mXInterstitial.b();
    }

    public void loadAdForVideoApp(int i2, int i3) {
        if (!this.initialized) {
            this.mXInterstitial.f();
            this.initialized = true;
        }
        this.mXInterstitial.a(i2, i3);
    }

    public void setAppSid(String str) {
        this.mXInterstitial.a(str);
    }

    public void setListener(InterstitialAdListener interstitialAdListener) {
        if (interstitialAdListener != null) {
            this.listener = interstitialAdListener;
            this.mXInterstitial.a(interstitialAdListener);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void showAd() {
        this.mXInterstitial.a_();
    }

    public void showAdInParentForVideoApp(RelativeLayout relativeLayout) {
        this.mXInterstitial.a(relativeLayout);
    }

    public InterstitialAd(Context context, AdSize adSize, String str) {
        this.initialized = false;
        this.mAdLogger = bj.a();
        this.listener = new InterstitialAdListener() { // from class: com.baidu.mobads.sdk.api.InterstitialAd.1
            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdClick(InterstitialAd interstitialAd) {
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdDismissed() {
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdFailed(String str2) {
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdPresent() {
            }

            @Override // com.baidu.mobads.sdk.api.InterstitialAdListener
            public void onAdReady() {
            }
        };
        ch chVar = new ch(context);
        chVar.a(new ch.a() { // from class: com.baidu.mobads.sdk.api.InterstitialAd.2
            @Override // com.baidu.mobads.sdk.internal.ch.a
            public void onAttachedToWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.ch.a
            @SuppressLint({"MissingSuperCall"})
            public void onDetachedFromWindow() {
            }

            @Override // com.baidu.mobads.sdk.internal.ch.a
            public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                return InterstitialAd.this.mXInterstitial.a(i2, keyEvent);
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
        if (isInterstitial(adSize)) {
            this.mXInterstitial = new dd(context, chVar, this, str);
        } else if (isInterstitialPause(adSize)) {
            this.mXInterstitial = new dd(context, chVar, this, adSize, str);
        }
        this.mXInterstitial.a(this.listener);
    }

    @Deprecated
    public void showAd(Activity activity) {
        this.mXInterstitial.a_();
    }

    @Deprecated
    public void showAdInParentForVideoApp(Activity activity, RelativeLayout relativeLayout) {
        if (activity != null && relativeLayout != null) {
            this.mXInterstitial.a(relativeLayout);
            return;
        }
        throw new IllegalArgumentException();
    }
}
