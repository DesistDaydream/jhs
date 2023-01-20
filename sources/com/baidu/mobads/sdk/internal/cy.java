package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.BaiduHybridAdViewListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXHybridAdRenderer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cy extends ay {
    private WebView a;
    private BaiduHybridAdViewListener q;
    private IXHybridAdRenderer r;

    public cy(WebView webView) {
        super(webView.getContext());
        this.a = webView;
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        this.a.removeJavascriptInterface("accessibility");
        this.a.removeJavascriptInterface("accessibilityTraversal");
        this.a.getSettings().setAllowContentAccess(false);
        this.a.getSettings().setSavePassword(false);
        this.a.getSettings().setAllowFileAccess(false);
    }

    public void a(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.q = baiduHybridAdViewListener;
    }

    public boolean b(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.r;
        if (iXHybridAdRenderer == null) {
            return false;
        }
        return iXHybridAdRenderer.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void h(IOAdEvent iOAdEvent) {
        super.h(iOAdEvent);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdClick(0, null);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void i() {
        IXHybridAdRenderer iXHybridAdRenderer = (IXHybridAdRenderer) ap.a(v.f1625j, bi.a(this.f1461h), new Class[]{Context.class}, this.f1461h);
        this.r = iXHybridAdRenderer;
        this.f1464k = iXHybridAdRenderer;
        if (this.f1465l) {
            return;
        }
        a();
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void q() {
        super.q();
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdShow(0, null);
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        IXHybridAdRenderer iXHybridAdRenderer = this.r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void b(String str, int i2) {
        super.b(str, i2);
        BaiduHybridAdViewListener baiduHybridAdViewListener = this.q;
        if (baiduHybridAdViewListener != null) {
            baiduHybridAdViewListener.onAdFailed(0, "", str);
        }
    }

    public void a(WebView webView, String str) {
        IXHybridAdRenderer iXHybridAdRenderer = this.r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onPageFinished(webView, str);
        }
    }

    public void a(WebView webView, int i2, String str, String str2) {
        IXHybridAdRenderer iXHybridAdRenderer = this.r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedError(webView, i2, str, str2);
        }
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IXHybridAdRenderer iXHybridAdRenderer = this.r;
        if (iXHybridAdRenderer != null) {
            iXHybridAdRenderer.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a() {
        if (this.r == null) {
            this.f1465l = false;
            return;
        }
        this.f1465l = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            this.r.createProdHandler(jSONObject3);
            n();
            if (!TextUtils.isEmpty(this.o)) {
                jSONObject.put("appid", this.o);
            }
            jSONObject.put(IAdInterListener.AdReqParam.PROD, IAdInterListener.AdProdType.PRODUCT_JSSDK);
            jSONObject2.put("timeout", 10000);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.r.loadAd(jSONObject, jSONObject2);
    }

    @Override // com.baidu.mobads.sdk.internal.ay
    public void a(IOAdEvent iOAdEvent) {
        this.r.setCustomerWebView(this.a);
    }
}
