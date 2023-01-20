package com.vector.databinding.adapter;

import android.webkit.WebView;
import androidx.databinding.InverseBindingListener;
import e.t.j.h.r;
import h.k2.u.p;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "web", "Landroid/webkit/WebView;", "url", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class WebViewBinding$setOnLoading$1 extends Lambda implements p<WebView, String, Boolean> {
    public final /* synthetic */ InverseBindingListener $attrChange;
    public final /* synthetic */ r $binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewBinding$setOnLoading$1(InverseBindingListener inverseBindingListener, r rVar) {
        super(2);
        this.$attrChange = inverseBindingListener;
        this.$binding = rVar;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(WebView webView, String str) {
        return Boolean.valueOf(invoke2(webView, str));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d WebView webView, @d String str) {
        p<WebView, String, Boolean> a;
        Boolean invoke;
        InverseBindingListener inverseBindingListener = this.$attrChange;
        if (inverseBindingListener != null) {
            inverseBindingListener.onChange();
        }
        r rVar = this.$binding;
        if (rVar == null || (a = rVar.a()) == null || (invoke = a.invoke(webView, str)) == null) {
            return false;
        }
        return invoke.booleanValue();
    }
}
