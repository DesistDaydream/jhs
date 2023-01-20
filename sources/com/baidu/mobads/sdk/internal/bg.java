package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.ExpressAdData;
import com.baidu.mobads.sdk.api.ExpressResponse;

/* loaded from: classes.dex */
public class bg implements ExpressResponse {
    private Context a;
    private int b = 1;

    /* renamed from: c  reason: collision with root package name */
    private ExpressResponse.ExpressInteractionListener f1487c;

    /* renamed from: d  reason: collision with root package name */
    private ExpressResponse.ExpressAdDownloadWindowListener f1488d;

    /* renamed from: e  reason: collision with root package name */
    private ExpressResponse.ExpressDislikeListener f1489e;

    /* renamed from: f  reason: collision with root package name */
    private final cw f1490f;

    /* renamed from: g  reason: collision with root package name */
    private final a f1491g;

    /* renamed from: h  reason: collision with root package name */
    private ViewGroup f1492h;

    /* renamed from: i  reason: collision with root package name */
    private ExpressAdData f1493i;

    public bg(Context context, cw cwVar, a aVar) {
        this.a = context;
        this.f1490f = cwVar;
        this.f1491g = aVar;
    }

    public void a(int i2) {
        this.b = i2;
    }

    public void b() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f1487c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingFail(String str) {
        cw cwVar;
        a aVar = this.f1491g;
        if (aVar == null || (cwVar = this.f1490f) == null) {
            return;
        }
        cwVar.a(aVar.G(), false, str);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void biddingSuccess(String str) {
        cw cwVar;
        a aVar = this.f1491g;
        if (aVar == null || (cwVar = this.f1490f) == null) {
            return;
        }
        cwVar.a(aVar.G(), true, str);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void bindInteractionActivity(Activity activity) {
        cw cwVar = this.f1490f;
        if (cwVar != null) {
            cwVar.b(activity);
        }
    }

    public void c() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f1487c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdExposed();
        }
    }

    public void d() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f1489e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowShow();
        }
    }

    public void e() {
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f1489e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeWindowClose();
        }
    }

    public void f() {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f1487c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdUnionClick();
        }
    }

    public void g() {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f1488d;
        if (expressAdDownloadWindowListener != null) {
            expressAdDownloadWindowListener.onADPrivacyClick();
        }
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getAdActionType() {
        return this.b;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public ExpressAdData getAdData() {
        return this.f1493i;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public String getECPMLevel() {
        a aVar = this.f1491g;
        return aVar != null ? aVar.z() : "";
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public View getExpressAdView() {
        a aVar;
        if (this.f1492h == null && (aVar = this.f1491g) != null) {
            this.f1492h = this.f1490f.a(aVar);
        }
        return this.f1492h;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public int getStyleType() {
        a aVar = this.f1491g;
        if (aVar != null) {
            return aVar.v();
        }
        return 0;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean isAdAvailable() {
        return this.f1491g != null && System.currentTimeMillis() - this.f1491g.y() <= this.f1491g.E();
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void render() {
        a aVar;
        cw cwVar = this.f1490f;
        if (cwVar == null || (aVar = this.f1491g) == null) {
            return;
        }
        if (this.f1492h == null) {
            this.f1492h = cwVar.a(aVar);
        }
        this.f1490f.a(this.f1492h, this.f1491g);
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdDislikeListener(ExpressResponse.ExpressDislikeListener expressDislikeListener) {
        this.f1489e = expressDislikeListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setAdPrivacyListener(ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener) {
        this.f1488d = expressAdDownloadWindowListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public void setInteractionListener(ExpressResponse.ExpressInteractionListener expressInteractionListener) {
        this.f1487c = expressInteractionListener;
    }

    @Override // com.baidu.mobads.sdk.api.ExpressResponse
    public boolean switchTheme(int i2) {
        cw cwVar = this.f1490f;
        if (cwVar != null) {
            return cwVar.a(this.f1492h, this.f1491g, i2);
        }
        return false;
    }

    public String a() {
        a aVar = this.f1491g;
        return aVar != null ? aVar.G() : "";
    }

    public void b(boolean z) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f1488d;
        if (expressAdDownloadWindowListener != null) {
            if (z) {
                expressAdDownloadWindowListener.adDownloadWindowShow();
            } else {
                expressAdDownloadWindowListener.adDownloadWindowClose();
            }
        }
    }

    public void a(View view, int i2, int i3) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f1487c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderSuccess(view, i2, i3);
        }
    }

    public void a(View view, String str, int i2) {
        ExpressResponse.ExpressInteractionListener expressInteractionListener = this.f1487c;
        if (expressInteractionListener != null) {
            expressInteractionListener.onAdRenderFail(view, str, i2);
        }
    }

    public void a(String str) {
        cw cwVar;
        a aVar = this.f1491g;
        if (aVar != null && (cwVar = this.f1490f) != null) {
            this.f1493i = new ExpressAdData(aVar, cwVar.h());
        }
        ExpressResponse.ExpressDislikeListener expressDislikeListener = this.f1489e;
        if (expressDislikeListener != null) {
            expressDislikeListener.onDislikeItemClick(str);
        }
    }

    public void a(boolean z) {
        ExpressResponse.ExpressAdDownloadWindowListener expressAdDownloadWindowListener = this.f1488d;
        if (expressAdDownloadWindowListener != null) {
            if (z) {
                expressAdDownloadWindowListener.onADPermissionShow();
            } else {
                expressAdDownloadWindowListener.onADPermissionClose();
            }
        }
    }
}
