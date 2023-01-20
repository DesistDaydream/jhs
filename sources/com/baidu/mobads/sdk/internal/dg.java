package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.SplashAdListener;
import com.baidu.mobads.sdk.api.SplashInteractionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class dg extends ay {
    private static int E;
    private static dg J;
    private boolean A;
    private boolean B;
    private boolean C;
    private int D;
    private SplashAdListener F;
    private SplashAd.OnFinishListener G;
    private SplashAd.SplashFocusAdListener H;
    private RequestParameters I;
    private a K;
    private SplashAd.SplashAdDownloadDialogListener L;
    public boolean a;
    public boolean q;
    public boolean r;
    public boolean s;
    private RelativeLayout t;
    private String u;
    private int v;
    private int w;
    private int x;
    private int y;
    private boolean z;

    public dg(Context context, String str, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4) {
        super(context);
        this.D = 60;
        this.q = false;
        this.r = false;
        this.s = false;
        this.u = str;
        this.v = i2;
        this.w = i3;
        this.x = i4;
        this.y = i5;
        this.z = z;
        this.A = z2;
        this.B = z4;
        this.C = z3;
    }

    private void b(Intent intent, SplashAd.OnFinishListener onFinishListener) {
        Context context = this.f1461h;
        if (context == null || intent == null) {
            return;
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        this.f1461h.startActivity(intent);
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            return;
        }
        Context context2 = this.f1461h;
        if (context2 instanceof Activity) {
            ((Activity) context2).finish();
        }
    }

    public static void c(int i2) {
        E = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b_() {
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheSuccess();
        }
        super.b_();
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void c_() {
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdCacheFailed();
        }
        super.c_();
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void d() {
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onLpClosed();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.H;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onLpClosed();
        }
        super.d();
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void e(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        if (this.H == null || data == null || !data.containsKey("splash_show_reason")) {
            return;
        }
        this.H.onAdIconShow();
    }

    public void f() {
        IAdInterListener iAdInterListener;
        if (this.a || (iAdInterListener = this.f1464k) == null) {
            return;
        }
        iAdInterListener.setAdContainer(this.t);
        this.f1464k.showAd();
    }

    public a g() {
        return this.K;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void h(IOAdEvent iOAdEvent) {
        this.q = true;
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
            ((SplashInteractionListener) splashAdListener).onAdClick();
        }
        SplashAd.SplashFocusAdListener splashFocusAdListener = this.H;
        if (splashFocusAdListener != null) {
            splashFocusAdListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public JSONObject k() {
        String str = "1";
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            this.f1464k.createProdHandler(jSONObject2);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_SPLASH);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.u);
            jSONObject.put(IAdInterListener.AdReqParam.FET, "ANTI,HTML,MSSP,VIDEO,RSPLASHHTML");
            jSONObject.put("n", "1");
            jSONObject.put(IAdInterListener.AdReqParam.AD_TYPE, "26");
            jSONObject.put("mimetype", "video/mp4,image/jpg,image/gif,image/png");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.v);
            jSONObject.put("h", "" + this.w);
            jSONObject.put("msa", 399);
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            String a = a(SplashAd.KEY_USE_ADAPTIVE_AD);
            if (!TextUtils.isEmpty(a)) {
                if (!Boolean.parseBoolean(a)) {
                    str = "0";
                }
                jSONObject.put("adtv", str);
            }
            b(jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", this.y);
            jSONObject.put("splashTipStyle", this.x);
            jSONObject.put("bitmapDisplayMode", E);
            jSONObject.put("countDownNew", "true");
            jSONObject.put("Display_Down_Info", "" + this.z);
            jSONObject.put("popDialogIfDl", "" + this.A);
            jSONObject.put("limitRegionClick", "" + this.B);
            jSONObject.put("displayClickButton", "" + this.C);
            jSONObject.put("needCache", true);
            jSONObject.put("onlyLoadAd", this.a);
            jSONObject.put("cacheVideoOnlyWifi", true);
            jSONObject.put("shakeLogoSize", this.D);
            RequestParameters requestParameters = this.I;
            if (requestParameters != null) {
                a(requestParameters.getExtras());
            }
            return j.a(jSONObject, b(this.f1466m));
        } catch (Exception e2) {
            e2.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void q() {
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener == null || !(splashAdListener instanceof SplashInteractionListener)) {
            return;
        }
        ((SplashInteractionListener) splashAdListener).onAdPresent();
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void t() {
        SplashAd.OnFinishListener onFinishListener = this.G;
        if (onFinishListener != null) {
            onFinishListener.onFinishActivity();
            this.G = null;
        } else {
            Context context = this.f1461h;
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
        }
        this.f1461h = null;
        this.t = null;
        super.t();
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void u() {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.L;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpClose();
    }

    public void a(RelativeLayout relativeLayout) {
        this.t = relativeLayout;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void g(IOAdEvent iOAdEvent) {
        Map<String, Object> data = iOAdEvent.getData();
        if (this.H != null && data != null && data.containsKey("splash_close_reason")) {
            this.H.onAdClose();
        } else if (this.r) {
        } else {
            super.g(iOAdEvent);
            SplashAdListener splashAdListener = this.F;
            if (splashAdListener != null && (splashAdListener instanceof SplashInteractionListener)) {
                ((SplashInteractionListener) splashAdListener).onAdDismissed();
            }
            this.r = true;
        }
    }

    public void a(int i2) {
        this.D = i2;
    }

    public void a(SplashAdListener splashAdListener) {
        this.F = splashAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void e(String str) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.L;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        splashAdDownloadDialogListener.onADPrivacyLpShow();
    }

    public void a(SplashAd.SplashFocusAdListener splashFocusAdListener) {
        this.H = splashFocusAdListener;
    }

    public void a(RequestParameters requestParameters) {
        this.I = requestParameters;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a() {
        IAdInterListener iAdInterListener = this.f1464k;
        if (iAdInterListener == null) {
            this.f1465l = false;
            return;
        }
        this.f1465l = true;
        if (!this.a) {
            iAdInterListener.setAdContainer(this.t);
        }
        this.f1464k.loadAd(k(), l());
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b(String str, int i2) {
        this.s = true;
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed(str);
        }
        super.b(str, i2);
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b(String str, boolean z) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.L;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z) {
            splashAdDownloadDialogListener.adDownloadWindowShow();
        } else {
            splashAdDownloadDialogListener.adDownloadWindowClose();
        }
    }

    public void a(@NonNull Intent intent, @Nullable SplashAd.OnFinishListener onFinishListener) {
        try {
            if (!this.q && intent != null && this.f1464k != null && !this.s && (this.f1461h instanceof Activity)) {
                this.G = onFinishListener;
                JSONObject jSONObject = new JSONObject();
                HashMap hashMap = new HashMap();
                try {
                    jSONObject.putOpt("event_type", "splash_focus_start_activity");
                    hashMap.put("splash_focus_user_intent", intent);
                } catch (JSONException e2) {
                    bj.a().a(e2);
                }
                this.f1464k.removeAllListeners();
                this.f1464k.addEventListener(v.X, this.f1463j);
                this.f1464k.addEventListener(v.L, this.f1463j);
                this.f1464k.addEventListener(v.F, this.f1463j);
                this.f1464k.addEventListener(v.U, this.f1463j);
                this.f1464k.addEventListener(v.V, this.f1463j);
                a(jSONObject, hashMap);
                this.F = null;
                J = this;
                at.a().a(new dh(this), 3L, TimeUnit.SECONDS);
                return;
            }
            b(intent, onFinishListener);
        } catch (Throwable th) {
            th.printStackTrace();
            b(intent, onFinishListener);
        }
    }

    public static void a(Activity activity, JSONObject jSONObject, SplashAd.SplashFocusAdListener splashFocusAdListener) {
        dg dgVar = J;
        if (dgVar != null) {
            dgVar.a(splashFocusAdListener);
            HashMap hashMap = new HashMap();
            JSONObject jSONObject2 = new JSONObject();
            try {
                try {
                    jSONObject2.putOpt("event_type", "splash_focus_register_transition");
                    jSONObject2.putOpt("splash_focus_params", jSONObject);
                    hashMap.put("splash_focus_activity", activity);
                    J.a(jSONObject2, hashMap);
                } catch (JSONException e2) {
                    bj.a().c(e2);
                } catch (Throwable th) {
                    bj.a().c(th);
                }
            } finally {
                J = null;
            }
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a(IOAdEvent iOAdEvent) {
        List<a> a;
        if (iOAdEvent != null && (a = b.a(iOAdEvent.getMessage()).a()) != null && a.size() > 0) {
            this.K = a.get(0);
        }
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null) {
            splashAdListener.onADLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a(int i2, String str) {
        this.s = true;
        SplashAdListener splashAdListener = this.F;
        if (splashAdListener != null) {
            splashAdListener.onAdFailed("广告无填充");
        }
        super.a(i2, str);
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a(String str, boolean z) {
        SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener = this.L;
        if (splashAdDownloadDialogListener == null || !(splashAdDownloadDialogListener instanceof SplashAd.SplashAdDownloadDialogListener)) {
            return;
        }
        if (z) {
            splashAdDownloadDialogListener.onADPermissionShow();
        } else {
            splashAdDownloadDialogListener.onADPermissionClose();
        }
    }

    public void a(SplashAd.SplashAdDownloadDialogListener splashAdDownloadDialogListener) {
        this.L = splashAdDownloadDialogListener;
    }

    private String a(String str) {
        if (this.I == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Map<String, String> extras = this.I.getExtras();
            if (extras != null) {
                return extras.get(str);
            }
            return null;
        } catch (Throwable th) {
            this.f1462i.d(ay.b, th);
            return null;
        }
    }

    public void a(boolean z, String str) {
        a aVar = this.K;
        if (aVar != null) {
            a(aVar.G(), z, str);
        }
    }
}
