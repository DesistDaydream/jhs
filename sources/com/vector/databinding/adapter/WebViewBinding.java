package com.vector.databinding.adapter;

import android.graphics.drawable.Drawable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import com.vector.view.WebViewEx;
import e.t.j.h.b0;
import e.t.j.h.i0;
import e.t.j.h.q;
import e.t.j.h.r;
import e.t.j.h.v;
import e.t.j.h.z;
import h.k2.k;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J$\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u001aH\u0007J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u001cH\u0007J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u001eH\u0007J\u0018\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020 H\u0007J\u0018\u0010!\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0007J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&H\u0007J\u0018\u0010'\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0004H\u0007J\u0018\u0010)\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010*\u001a\u00020&H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/vector/databinding/adapter/WebViewBinding;", "", "()V", "IS_SHOW_PROGRESS", "", "ON_LOADING", "ON_LOAD_SCHEME_URI", "ON_PAGE_END", "ON_PAGE_START", "ON_PROGRESS_CHANGED", "ON_TITLE_CHANGED", "PROGRESS_DRAWABLE", "URL", "ZOOM", "getUrl", "view", "Lcom/vector/view/WebViewEx;", "setOnLoadSchemeUri", "", "binding", "Lcom/vector/databinding/onBind/OnLoadSchemeUriBinding;", "setOnLoading", "Lcom/vector/databinding/onBind/OnLoadingBinding;", "attrChange", "Landroidx/databinding/InverseBindingListener;", "setOnPageEnd", "Lcom/vector/databinding/onBind/OnPageEndBinding;", "setOnPageStart", "Lcom/vector/databinding/onBind/OnPageStartBinding;", "setOnProgressChanged", "Lcom/vector/databinding/onBind/OnProgressChangedBinding;", "setOnTitleChanged", "Lcom/vector/databinding/onBind/OnTitleChangedBinding;", "setProgressDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setShowProgress", "b", "", "setUrl", "url", "setZoom", "zoom", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class WebViewBinding {
    @d
    public static final WebViewBinding a = new WebViewBinding();
    @d
    private static final String b = "android:webView_url";
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final String f7715c = "android:webView_onProgressChanged";
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final String f7716d = "android:webView_onTitleChanged";
    @d

    /* renamed from: e  reason: collision with root package name */
    private static final String f7717e = "android:webView_onLoading";
    @d

    /* renamed from: f  reason: collision with root package name */
    private static final String f7718f = "android:webView_onPageStart";
    @d

    /* renamed from: g  reason: collision with root package name */
    private static final String f7719g = "android:webView_onPageEnd";
    @d

    /* renamed from: h  reason: collision with root package name */
    private static final String f7720h = "android:webView_onLoadSchemeUri";
    @d

    /* renamed from: i  reason: collision with root package name */
    private static final String f7721i = "android:webView_progressDrawable";
    @d

    /* renamed from: j  reason: collision with root package name */
    private static final String f7722j = "android:webView_zoom";
    @d

    /* renamed from: k  reason: collision with root package name */
    private static final String f7723k = "android:webView_isShowProgress";

    private WebViewBinding() {
    }

    @k
    @InverseBindingAdapter(attribute = b)
    @d
    public static final String a(@d WebViewEx webViewEx) {
        String url = webViewEx.getUrl();
        return url == null ? "" : url;
    }

    @BindingAdapter({f7720h})
    @k
    public static final void b(@d WebViewEx webViewEx, @d q qVar) {
        webViewEx.setOnLoadSchemeUri(qVar.a());
    }

    @BindingAdapter(requireAll = false, value = {f7717e, "android:webView_urlAttrChanged"})
    @k
    public static final void c(@d WebViewEx webViewEx, @e r rVar, @e InverseBindingListener inverseBindingListener) {
        webViewEx.setOnLoading(new WebViewBinding$setOnLoading$1(inverseBindingListener, rVar));
    }

    @BindingAdapter({f7719g})
    @k
    public static final void d(@d WebViewEx webViewEx, @d v vVar) {
        webViewEx.setOnPageLoadFinish(vVar.a());
    }

    @BindingAdapter({f7718f})
    @k
    public static final void e(@d WebViewEx webViewEx, @d z zVar) {
        webViewEx.setOnPageLoadStart(zVar.a());
    }

    @BindingAdapter({f7715c})
    @k
    public static final void f(@d WebViewEx webViewEx, @d b0 b0Var) {
        webViewEx.setOnProgressChanged(new WebViewBinding$setOnProgressChanged$1(b0Var));
    }

    @BindingAdapter({f7716d})
    @k
    public static final void g(@d WebViewEx webViewEx, @d i0 i0Var) {
        webViewEx.setOnTitleChanged(new WebViewBinding$setOnTitleChanged$1(i0Var));
    }

    @BindingAdapter({f7721i})
    @k
    public static final void h(@d WebViewEx webViewEx, @d Drawable drawable) {
        webViewEx.setProgressDrawable(drawable);
    }

    @BindingAdapter({f7723k})
    @k
    public static final void i(@d WebViewEx webViewEx, boolean z) {
        webViewEx.m(z);
    }

    @BindingAdapter({b})
    @k
    public static final void j(@d WebViewEx webViewEx, @d String str) {
        webViewEx.o(str);
    }

    @BindingAdapter({f7722j})
    @k
    public static final void k(@d WebViewEx webViewEx, boolean z) {
        webViewEx.setZoom(z);
    }
}
