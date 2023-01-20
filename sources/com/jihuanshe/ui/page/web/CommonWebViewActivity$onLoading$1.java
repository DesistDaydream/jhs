package com.jihuanshe.ui.page.web;

import android.webkit.WebView;
import h.k2.u.p;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CommonWebViewActivity$onLoading$1 extends Lambda implements p<WebView, String, Boolean> {
    public final /* synthetic */ CommonWebViewActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonWebViewActivity$onLoading$1(CommonWebViewActivity commonWebViewActivity) {
        super(2);
        this.this$0 = commonWebViewActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(WebView webView, String str) {
        return Boolean.valueOf(invoke2(webView, str));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d WebView webView, @d String str) {
        this.this$0.r0();
        return false;
    }
}
