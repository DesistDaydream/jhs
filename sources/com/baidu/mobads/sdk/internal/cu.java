package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.ExpressInterstitialAd;
import com.baidu.mobads.sdk.api.ExpressInterstitialListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cu extends ay {
    private a A;
    private boolean B;
    private boolean C;
    public RelativeLayout a;
    public boolean q;
    public boolean r;
    private int s;
    private String t;
    private String u;
    private int v;
    private int w;
    private ExpressInterstitialListener x;
    private ExpressInterstitialAd.InterAdDownloadWindowListener y;
    private ExpressInterstitialAd.InterstitialAdDislikeListener z;

    public cu(Context context, RelativeLayout relativeLayout, String str) {
        super(context);
        this.s = JosStatusCodes.RTN_CODE_COMMON_ERROR;
        this.t = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
        this.v = 600;
        this.w = 500;
        this.B = false;
        this.a = relativeLayout;
        this.u = str;
    }

    public void a(ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener) {
        this.y = interAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b(String str, int i2) {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdFailed(i2, str);
        }
        super.b(str, i2);
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b_() {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheSuccess();
            this.x.onVideoDownloadSuccess();
        }
    }

    public void c(boolean z) {
        this.B = z;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void c_() {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdCacheFailed();
            this.x.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void d(String str) {
    }

    public void d(boolean z) {
        this.C = z;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void e(IOAdEvent iOAdEvent) {
        this.r = false;
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposed();
        }
    }

    public String f() {
        return this.t;
    }

    public boolean g() {
        return this.r;
    }

    public void h() {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener != null) {
            iAdInterListener.showAd();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, this.t);
            jSONObject2.put("isNewInterstitial", true);
            this.f1464k.createProdHandler(jSONObject2);
            this.f1464k.setAdContainer(this.a);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.t);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.u);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            if (cg.a().b()) {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML");
            } else {
                jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,MSSP,VIDEO,NMON,HTML,CLICK2VIDEO");
            }
            jSONObject.put(IAdInterListener.AdReqParam.AD_TYPE, "10");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + aq.b(this.f1461h));
            jSONObject.put("h", "" + aq.c(this.f1461h));
            jSONObject.put("msa", 151);
            jSONObject.put("opt", 1);
            b(jSONObject);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("onlyLoadAd", this.q);
            jSONObject.put("isNewInterstitial", true);
            jSONObject.put(SplashAd.KEY_POPDIALOG_DOWNLOAD, this.B);
            jSONObject.put("use_dialog_container", this.C);
            jSONObject.put("timeout", this.s);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void u() {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.y;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClose();
        }
    }

    public a w() {
        return this.A;
    }

    public void a(ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener) {
        this.z = interstitialAdDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void c(IOAdEvent iOAdEvent) {
        Log.e("ExpressInterstitial ", "dislike click");
        ExpressInterstitialAd.InterstitialAdDislikeListener interstitialAdDislikeListener = this.z;
        if (interstitialAdDislikeListener == null || iOAdEvent == null) {
            return;
        }
        interstitialAdDislikeListener.interstitialAdDislikeClick();
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void d() {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onLpClosed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void f(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADExposureFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClose();
        }
    }

    public void a(int i2) {
        this.s = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void h(IOAdEvent iOAdEvent) {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onAdClick();
        }
    }

    public void a(ExpressInterstitialListener expressInterstitialListener) {
        this.x = expressInterstitialListener;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b(String str, boolean z) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.y;
        if (interAdDownloadWindowListener != null) {
            if (z) {
                interAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                interAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void e(String str) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.y;
        if (interAdDownloadWindowListener != null) {
            interAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a() {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener == null) {
            this.f1465l = false;
            return;
        }
        this.r = false;
        this.f1465l = true;
        iAdInterListener.loadAd(k(), l());
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width > 0 && height > 0) {
            this.v = width;
            this.w = height;
        }
        a(requestParameters.getExtras());
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a(int i2, String str) {
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onNoAd(i2, str);
        }
        super.a(i2, str);
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a(String str, boolean z) {
        ExpressInterstitialAd.InterAdDownloadWindowListener interAdDownloadWindowListener = this.y;
        if (interAdDownloadWindowListener != null) {
            if (z) {
                interAdDownloadWindowListener.onADPermissionShow();
            } else {
                interAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a(IOAdEvent iOAdEvent) {
        List<a> a;
        if (iOAdEvent != null && (a = b.a(iOAdEvent.getMessage()).a()) != null && a.size() > 0) {
            this.A = a.get(0);
        }
        this.r = true;
        ExpressInterstitialListener expressInterstitialListener = this.x;
        if (expressInterstitialListener != null) {
            expressInterstitialListener.onADLoaded();
        }
    }

    public void a(boolean z, String str) {
        a aVar = this.A;
        if (aVar != null) {
            a(aVar.G(), z, str);
        }
    }
}
