package com.qq.e.mediation.interfaces;

import android.app.Activity;
import android.view.View;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADListener;

/* loaded from: classes3.dex */
public abstract class BaseBannerAd implements IBaseAd {
    public BaseBannerAd(Activity activity, String str, String str2, String str3) {
    }

    public abstract void destroy();

    public abstract View getAdView();

    public abstract boolean isValid();

    public abstract void loadAD();

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendLossNotification(int i2, int i3, String str) {
    }

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void sendWinNotification(int i2) {
    }

    public abstract void setAdListener(ADListener aDListener);

    public abstract void setAdSize(int i2, int i3);

    @Override // com.qq.e.mediation.interfaces.IBaseAd
    public void setBidECPM(int i2) {
    }

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);
}
