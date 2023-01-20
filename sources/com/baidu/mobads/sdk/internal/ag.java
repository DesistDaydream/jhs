package com.baidu.mobads.sdk.internal;

import android.webkit.WebView;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ag implements Runnable {
    public final /* synthetic */ JSONObject a;
    public final /* synthetic */ WebView b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ac f1420c;

    public ag(ac acVar, JSONObject jSONObject, WebView webView) {
        this.f1420c = acVar;
        this.a = jSONObject;
        this.b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.a == null || this.b == null) {
            return;
        }
        this.b.loadUrl("javascript:window.sdkCallback.userInteractCb(\"" + this.a.toString().replace("\"", "\\\"") + "\")");
    }
}
