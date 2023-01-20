package com.jihuanshe.ui.page.web;

import android.content.Intent;
import android.webkit.WebView;
import h.k2.u.p;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CommonWebViewActivity$onLoadSchemeUri$1 extends Lambda implements p<WebView, String, t1> {
    public final /* synthetic */ CommonWebViewActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonWebViewActivity$onLoadSchemeUri$1(CommonWebViewActivity commonWebViewActivity) {
        super(2);
        this.this$0 = commonWebViewActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(WebView webView, String str) {
        invoke2(webView, str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e WebView webView, @e String str) {
        this.this$0.startActivity(Intent.parseUri(str, 1));
    }
}
