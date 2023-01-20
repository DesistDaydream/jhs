package com.vector.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.webkit.WebView;
import e.t.u.p;
import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroid/webkit/WebView;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class WebViewEx$webView$2 extends Lambda implements a<WebView> {
    public final /* synthetic */ AttributeSet $attrs;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ int $defStyleAttr;
    public final /* synthetic */ int $defStyleRes;
    public final /* synthetic */ WebViewEx this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewEx$webView$2(WebViewEx webViewEx, Context context, AttributeSet attributeSet, int i2, int i3) {
        super(0);
        this.this$0 = webViewEx;
        this.$context = context;
        this.$attrs = attributeSet;
        this.$defStyleAttr = i2;
        this.$defStyleRes = i3;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final WebView invoke() {
        this.this$0.l();
        WebView webView = new WebView(this.$context.createConfigurationContext(new Configuration()), this.$attrs, this.$defStyleAttr, this.$defStyleRes);
        webView.setFocusableInTouchMode(true);
        webView.setLayoutParams(p.p(-1, -1));
        return webView;
    }
}
