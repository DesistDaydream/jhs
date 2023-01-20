package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import java.util.List;

/* loaded from: classes.dex */
public class e {
    private cw a;
    private String b;

    /* loaded from: classes.dex */
    public interface a {
        void a();

        void a(int i2, String str);

        void a(NativeResponse nativeResponse);

        void a(NativeResponse nativeResponse, int i2);

        void a(List<NativeResponse> list);

        void b();

        void b(int i2, String str);

        void b(NativeResponse nativeResponse);

        void c();
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(NativeResponse nativeResponse);
    }

    public e(Context context, String str, a aVar, boolean z, int i2) {
        this(context, aVar, new cw(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z, i2));
    }

    public void a() {
        cw cwVar = this.a;
        if (cwVar != null) {
            cwVar.e();
        }
    }

    public void b() {
        b((RequestParameters) null);
    }

    public e(Context context, String str, BaiduNativeManager.ExpressAdListener expressAdListener, boolean z, int i2) {
        cw cwVar = new cw(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z, i2);
        this.a = cwVar;
        cwVar.a(expressAdListener);
        this.a.a(1);
    }

    public void b(RequestParameters requestParameters) {
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        cw cwVar = this.a;
        if (cwVar != null) {
            cwVar.g(this.b);
        }
        this.a.a(requestParameters);
        this.a.a();
    }

    public void a(b bVar) {
        cw cwVar = this.a;
        if (cwVar != null) {
            cwVar.a(bVar);
        }
    }

    public void a(int i2) {
        cw cwVar = this.a;
        if (cwVar != null) {
            cwVar.p = i2;
        }
    }

    public e(Context context, String str, a aVar, boolean z, int i2, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INSITE)) {
                this.a = new cw(context, str, IAdInterListener.AdProdType.PRODUCT_INSITE, z, i2);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_SUG)) {
                this.a = new cw(context, str, IAdInterListener.AdProdType.PRODUCT_SUG, z, i2);
            } else if (str2.equals(IAdInterListener.AdProdType.PRODUCT_PREROLL)) {
                this.a = new cw(context, str, "video", z, i2);
            } else {
                this.a = new cw(context, str, IAdInterListener.AdProdType.PRODUCT_FEEDS, z, i2);
            }
        }
        this.a.a(aVar);
    }

    public void a(boolean z) {
        cw cwVar = this.a;
        if (cwVar != null) {
            cwVar.c(z);
        }
    }

    public void b(String str) {
        this.b = str;
    }

    public String a(RequestParameters requestParameters) {
        if (this.a != null) {
            if (requestParameters == null) {
                requestParameters = new RequestParameters.Builder().build();
            }
            this.a.g(this.b);
            this.a.a(requestParameters);
            return this.a.m();
        }
        return null;
    }

    public void a(String str) {
        cw cwVar = this.a;
        if (cwVar != null) {
            cwVar.b(str);
        }
    }

    public e(Context context, a aVar, cw cwVar) {
        this.a = cwVar;
        cwVar.a(aVar);
    }
}
