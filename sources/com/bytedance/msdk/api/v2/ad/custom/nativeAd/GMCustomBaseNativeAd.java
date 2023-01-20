package com.bytedance.msdk.api.v2.ad.custom.nativeAd;

import android.view.View;
import com.bytedance.msdk.api.v2.GMReceiveBidResultCallback;
import com.bytedance.msdk.api.v2.ad.custom.GMCustomTTBaseAd;
import com.bytedance.msdk.api.v2.ad.custom.base.GMCustomAd;
import com.bytedance.msdk.api.v2.ad.nativeAd.GMNativeAdAppInfo;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class GMCustomBaseNativeAd extends GMCustomAd {
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f2078c;

    /* renamed from: d  reason: collision with root package name */
    private String f2079d;

    /* renamed from: e  reason: collision with root package name */
    private String f2080e;

    /* renamed from: f  reason: collision with root package name */
    private int f2081f;

    /* renamed from: g  reason: collision with root package name */
    private int f2082g;

    /* renamed from: h  reason: collision with root package name */
    private String f2083h;

    /* renamed from: i  reason: collision with root package name */
    private int f2084i;

    /* renamed from: j  reason: collision with root package name */
    private int f2085j;

    /* renamed from: k  reason: collision with root package name */
    private String f2086k;

    /* renamed from: l  reason: collision with root package name */
    private double f2087l;

    /* renamed from: m  reason: collision with root package name */
    private List<String> f2088m;
    private String n;
    private int o;
    private int p;
    private GMNativeAdAppInfo q;
    private double r;
    private GMReceiveBidResultCallback s;

    public GMCustomBaseNativeAd() {
        GMReceiveBidResultCallback gMReceiveBidResultCallback = new GMReceiveBidResultCallback() { // from class: com.bytedance.msdk.api.v2.ad.custom.nativeAd.GMCustomBaseNativeAd.1
            @Override // com.bytedance.msdk.api.v2.GMReceiveBidResultCallback
            public void bidResult(boolean z, double d2, int i2, Map<String, Object> map) {
                GMCustomBaseNativeAd.this.receiveBidResult(z, d2, i2, map);
            }
        };
        this.s = gMReceiveBidResultCallback;
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd != null) {
            gMCustomTTBaseAd.setGmReceiveBidResultCallback(gMReceiveBidResultCallback);
        }
    }

    public String getActionText() {
        return this.f2083h;
    }

    public int getAdImageMode() {
        return this.o;
    }

    public double getBiddingPrice() {
        return this.r;
    }

    public String getDescription() {
        return this.f2078c;
    }

    public View getExpressView() {
        return null;
    }

    public String getIconUrl() {
        return this.f2079d;
    }

    public int getImageHeight() {
        return this.f2082g;
    }

    public List<String> getImageList() {
        return this.f2088m;
    }

    public String getImageUrl() {
        return this.f2080e;
    }

    public int getImageWidth() {
        return this.f2081f;
    }

    public int getInteractionType() {
        return this.p;
    }

    public GMNativeAdAppInfo getNativeAdAppInfo() {
        return this.q;
    }

    public String getPackageName() {
        return this.f2086k;
    }

    public String getSource() {
        return this.n;
    }

    public double getStarRating() {
        return this.f2087l;
    }

    public String getTitle() {
        return this.b;
    }

    public int getVideoHeight() {
        return this.f2085j;
    }

    public String getVideoUrl() {
        return null;
    }

    public final String getVideoUrlInner() {
        try {
            return getVideoUrl();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public int getVideoWidth() {
        return this.f2084i;
    }

    public boolean isServerBidding() {
        return this.a.getAdNetworkSlotType() == 2;
    }

    public final boolean isUseCustomVideo() {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd != null) {
            return gMCustomTTBaseAd.isUseCustomVideo();
        }
        return false;
    }

    public void receiveBidResult(boolean z, double d2, int i2, Map<String, Object> map) {
    }

    public void setActionText(String str) {
        this.f2083h = str;
    }

    public void setAdImageMode(int i2) {
        this.o = i2;
    }

    public void setBiddingPrice(double d2) {
        this.r = d2;
    }

    public void setDescription(String str) {
        this.f2078c = str;
    }

    public final void setDislikeDialogCallBack(IGMCustomNativeDislikeDialog iGMCustomNativeDislikeDialog) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd == null || iGMCustomNativeDislikeDialog == null) {
            return;
        }
        gMCustomTTBaseAd.setDislikeDialogCallBack(iGMCustomNativeDislikeDialog);
    }

    public void setExpressAd(boolean z) {
        GMCustomTTBaseAd gMCustomTTBaseAd = this.a;
        if (gMCustomTTBaseAd != null) {
            gMCustomTTBaseAd.setExpressAd(z);
        }
    }

    public void setIconUrl(String str) {
        this.f2079d = str;
    }

    public void setImageHeight(int i2) {
        this.f2082g = i2;
    }

    public void setImageList(List<String> list) {
        this.f2088m = list;
    }

    public void setImageUrl(String str) {
        this.f2080e = str;
    }

    public void setImageWidth(int i2) {
        this.f2081f = i2;
    }

    public void setInteractionType(int i2) {
        this.p = i2;
    }

    public void setNativeAdAppInfo(GMNativeAdAppInfo gMNativeAdAppInfo) {
        this.q = gMNativeAdAppInfo;
    }

    public void setPackageName(String str) {
        this.f2086k = str;
    }

    public void setSource(String str) {
        this.n = str;
    }

    public void setStarRating(double d2) {
        this.f2087l = d2;
    }

    public void setTitle(String str) {
        this.b = str;
    }

    public void setVideoHeight(int i2) {
        this.f2085j = i2;
    }

    public void setVideoWidth(int i2) {
        this.f2084i = i2;
    }
}
