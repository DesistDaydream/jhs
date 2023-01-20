package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.AdSize;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.InterstitialAd;
import com.baidu.mobads.sdk.api.InterstitialAdListener;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class dd extends ay implements x {
    private static final String a = "preload_end";
    private AdSize q;
    private String r;
    private boolean s;
    private boolean t;
    private RelativeLayout u;
    private InterstitialAd v;
    private InterstitialAdListener w;

    public dd(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, String str) {
        this(context, relativeLayout, interstitialAd, AdSize.InterstitialGame, str);
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void a(String str) {
        super.g(str);
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void a_() {
        boolean z = this.s;
        if (z && !this.t) {
            this.t = true;
            this.s = false;
            IAdInterListener iAdInterListener = this.f1464k;
            if (iAdInterListener != null) {
                iAdInterListener.showAd();
            }
        } else if (this.t) {
            this.f1462i.b("interstitial ad is showing now");
        } else if (z) {
        } else {
            this.f1462i.b("interstitial ad is not ready");
        }
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void b() {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public boolean c() {
        return this.s;
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void f() {
        a();
    }

    public void g() {
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void g(IOAdEvent iOAdEvent) {
        this.t = false;
        InterstitialAdListener interstitialAdListener = this.w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdDismissed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void h(IOAdEvent iOAdEvent) {
        InterstitialAdListener interstitialAdListener = this.w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdClick(this.v);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void q() {
        InterstitialAdListener interstitialAdListener = this.w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdPresent();
        }
    }

    public dd(Context context, RelativeLayout relativeLayout, InterstitialAd interstitialAd, AdSize adSize, String str) {
        super(context);
        this.s = false;
        this.t = false;
        this.v = interstitialAd;
        this.u = relativeLayout;
        this.q = adSize;
        this.r = str;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a() {
        if (this.f1464k == null) {
            this.f1465l = false;
            return;
        }
        this.f1465l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            this.f1464k.createProdHandler(jSONObject3);
            this.f1464k.setAdContainer(this.u);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.r);
            jSONObject.put(IAdInterListener.AdReqParam.AD_TYPE, "2");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "0");
            jSONObject.put("h", "0");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            if (AdSize.InterstitialGame.equals(this.q)) {
                jSONObject2.put("ABILITY", "PAUSE,");
            }
            jSONObject2.put("APT", this.q.getValue());
            jSONObject2.put("onlyLoadAd", true);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f1464k.loadAd(jSONObject, jSONObject2);
    }

    @Deprecated
    public void b(Activity activity) {
        a_();
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b(String str, int i2) {
        InterstitialAdListener interstitialAdListener = this.w;
        if (interstitialAdListener != null) {
            interstitialAdListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void a(int i2, int i3) {
        if (this.f1464k == null || this.s || this.t) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, i2);
            jSONObject.put("h", i3);
        } catch (JSONException unused) {
        }
        a(jSONObject);
        this.f1464k.showAd();
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void a(RelativeLayout relativeLayout) {
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        try {
            jSONObject.putOpt("event_type", "interstitial_set_video_parent");
            hashMap.put("interstitial_video_parent", relativeLayout);
        } catch (JSONException e2) {
            bj.a().a(e2);
        }
        a(jSONObject, hashMap);
        a_();
    }

    @Override // com.baidu.mobads.sdk.internal.x
    public void a(InterstitialAdListener interstitialAdListener) {
        this.w = interstitialAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a(IOAdEvent iOAdEvent) {
        if (a.equals(iOAdEvent.getMessage())) {
            this.s = true;
            InterstitialAdListener interstitialAdListener = this.w;
            if (interstitialAdListener != null) {
                interstitialAdListener.onAdReady();
            }
        }
    }
}
