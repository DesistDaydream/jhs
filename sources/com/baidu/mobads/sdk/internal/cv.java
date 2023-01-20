package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeAdPlacement;
import com.baidu.mobads.sdk.api.BaiduNativeH5AdView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cv extends ay {
    private boolean A;
    private BaiduNativeAdPlacement B;
    public a a;
    private String q;
    private String r;
    private int s;
    private int t;
    private BaiduNativeH5AdView u;
    private int v;
    private int w;
    private int x;
    private BaiduNativeH5AdView.BaiduNativeH5EventListner y;
    private boolean z;

    public cv(Context context, String str, BaiduNativeH5AdView baiduNativeH5AdView) {
        super(context);
        this.v = 1;
        this.w = 1;
        this.x = 1;
        this.z = false;
        this.a = null;
        this.A = false;
        this.u = baiduNativeH5AdView;
        this.r = baiduNativeH5AdView.getAdPlacement().getApId();
        this.q = str;
        this.f1460g = baiduNativeH5AdView.getAdPlacement().getAdView();
    }

    public void a(BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner) {
        this.y = baiduNativeH5EventListner;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b(String str, int i2) {
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }

    public void c(boolean z) {
        this.z = z;
    }

    public void d(int i2) {
        this.x = i2;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void e(IOAdEvent iOAdEvent) {
        this.B.setWinSended(true);
    }

    public boolean f() {
        return this.z;
    }

    public boolean g() {
        return this.A;
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void h(IOAdEvent iOAdEvent) {
        this.B.setClicked(true);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void q() {
        this.z = true;
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdShow();
        }
    }

    public void a(RequestParameters requestParameters) {
        int width = requestParameters.getWidth();
        int height = requestParameters.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.s = width;
        this.t = height;
    }

    public void c(int i2) {
        this.w = i2;
    }

    public void a(int i2) {
        this.v = i2;
    }

    public void a(BaiduNativeAdPlacement baiduNativeAdPlacement) {
        this.B = baiduNativeAdPlacement;
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
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, this.q);
            this.f1464k.createProdHandler(jSONObject3);
            this.f1464k.setAdContainer(this.f1460g);
            n();
            jSONObject.put(IAdInterListener.AdReqParam.PROD, this.q);
            jSONObject.put(IAdInterListener.AdReqParam.APID, this.r);
            jSONObject.put("n", "1");
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            jSONObject.put(IAdInterListener.AdReqParam.AD_TYPE, "2");
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, "" + this.s);
            jSONObject.put("h", "" + this.t);
            jSONObject = j.a(jSONObject, b(this.f1466m));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.f1464k.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a(IOAdEvent iOAdEvent) {
        this.A = true;
        this.u.getAdPlacement().setAdResponse(b.a(iOAdEvent.getMessage()).a().get(0));
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdDataLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a(int i2, String str) {
        r();
        this.B.setRequestStarted(false);
        BaiduNativeH5AdView.BaiduNativeH5EventListner baiduNativeH5EventListner = this.y;
        if (baiduNativeH5EventListner != null) {
            baiduNativeH5EventListner.onAdFail(str);
        }
    }
}
