package com.vector.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewConfiguration;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.view.GravityCompat;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.vector.ext.AnyKt;
import com.vector.ext.view.ViewKt;
import com.vector.view.WebViewEx;
import h.k2.h;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 |2\u00020\u0001:\u0001|B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010Q\u001a\u00020\u00102\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u001aH\u0007J\u0006\u0010U\u001a\u00020#J\u0006\u0010V\u001a\u00020#J\u0006\u0010W\u001a\u00020\u0010J\u0006\u0010X\u001a\u00020\u0010J\u0014\u0010Y\u001a\u0004\u0018\u00010\u001a2\b\u0010Z\u001a\u0004\u0018\u00010FH\u0002J\u0006\u0010[\u001a\u00020\u0010J\u0006\u0010\\\u001a\u00020\u001aJ\u0006\u0010]\u001a\u00020\u0010J\u0006\u0010^\u001a\u00020\u0010J\b\u0010_\u001a\u00020\u0010H\u0003J\u000e\u0010`\u001a\u00020\u00102\u0006\u0010a\u001a\u00020#J\u0010\u0010b\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010c\u001a\u00020\u0010H\u0014J\b\u0010d\u001a\u00020\u0010H\u0014J\u0016\u0010e\u001a\u00020\u00102\f\u0010f\u001a\b\u0012\u0004\u0012\u00020F0EH\u0007J \u0010g\u001a\u00020\u00102\u0006\u0010h\u001a\u00020\u00072\u0006\u0010i\u001a\u00020\u00072\b\u0010j\u001a\u0004\u0018\u00010\fJ$\u0010k\u001a\u00020\u00102\u0012\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0H0E2\u0006\u0010\u000f\u001a\u00020\fH\u0007J\u0006\u0010l\u001a\u00020\u0010J\b\u0010m\u001a\u00020\u0010H\u0002J\b\u0010n\u001a\u00020\u0010H\u0002J\u000e\u0010o\u001a\u00020\u00102\u0006\u0010p\u001a\u00020qJ\b\u0010r\u001a\u00020\u0010H\u0003J\u000e\u0010s\u001a\u00020\u00102\u0006\u0010t\u001a\u00020\u001aJ\b\u0010u\u001a\u00020\u0010H\u0002J\u000e\u0010v\u001a\u00020\u00102\u0006\u0010w\u001a\u00020#J2\u0010x\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u001a2\"\u0010y\u001a\u001e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0zj\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a`{R?\u0010\n\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015RR\u0010\u0016\u001a:\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017j\u0004\u0018\u0001`\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 RR\u0010!\u001a:\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020#\u0018\u00010\u0017j\u0004\u0018\u0001`$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 RV\u0010'\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017j\u0004\u0018\u0001`(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001e\"\u0004\b*\u0010 RV\u0010+\u001a>\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0019\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017j\u0004\u0018\u0001`,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001e\"\u0004\b.\u0010 R=\u0010/\u001a%\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(0\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`1X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0013\"\u0004\b3\u0010\u0015R=\u00104\u001a%\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(5\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`6X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0013\"\u0004\b8\u0010\u0015R\u001b\u00109\u001a\u00020:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b;\u0010<R\u001a\u0010?\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0016\u0010D\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010G\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0H\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001b\u0010M\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bP\u0010>\u001a\u0004\bN\u0010O¨\u0006}"}, d2 = {"Lcom/vector/view/WebViewEx;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onClickChoosePhoto", "Lkotlin/Function1;", "Landroid/content/Intent;", "Lkotlin/ParameterName;", "name", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "", "Lcom/vector/view/OnClickChoosePhoto;", "getOnClickChoosePhoto", "()Lkotlin/jvm/functions/Function1;", "setOnClickChoosePhoto", "(Lkotlin/jvm/functions/Function1;)V", "onLoadSchemeUri", "Lkotlin/Function2;", "Landroid/webkit/WebView;", "web", "", "uriStr", "Lcom/vector/view/OnLoadSchemeUri;", "getOnLoadSchemeUri", "()Lkotlin/jvm/functions/Function2;", "setOnLoadSchemeUri", "(Lkotlin/jvm/functions/Function2;)V", "onLoading", "url", "", "Lcom/vector/view/OnLoading;", "getOnLoading", "setOnLoading", "onPageLoadFinish", "Lcom/vector/view/OnPageLoadFinish;", "getOnPageLoadFinish", "setOnPageLoadFinish", "onPageLoadStart", "Lcom/vector/view/OnPageLoadStart;", "getOnPageLoadStart", "setOnPageLoadStart", "onProgressChanged", "progress", "Lcom/vector/view/OnProgressChanged;", "getOnProgressChanged", "setOnProgressChanged", "onTitleChanged", "text", "Lcom/vector/view/OnTitleChanged;", "getOnTitleChanged", "setOnTitleChanged", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "progressBar$delegate", "Lkotlin/Lazy;", "showProgress", "getShowProgress", "()Z", "setShowProgress", "(Z)V", "uploadMessage", "Landroid/webkit/ValueCallback;", "Landroid/net/Uri;", "uploadMessages", "", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "webView", "getWebView", "()Landroid/webkit/WebView;", "webView$delegate", "addJavascriptInterface", IconCompat.EXTRA_OBJ, "", "interfaceName", "canGoBack", "canGoForward", "clearCache", "clearCookie", "decodePicUri", "uri", "destroy", "getUserAgentString", "goBack", "goForward", "hookWebView", "isShowProgress", "b", "loadUrl", "onAttachedToWindow", "onDetachedFromWindow", "onOpenFileChooser", "uploadMsg", "onResultData", "requestCode", "resultCode", "data", "onShowFileChooser", "reloadUrl", "setChromeClient", "setDownloadListener", "setProgressDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setSettings", "setUserAgentString", "userAgentString", "setWebClient", "setZoom", "enable", "syncCookie", "cookieValue", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class WebViewEx extends RelativeLayout {
    @d
    public static final a n = new a(null);
    public static final int o = 1;
    public static final int p = 2;
    @e
    private ValueCallback<Uri> a;
    @e
    private ValueCallback<Uri[]> b;
    @e

    /* renamed from: c */
    private p<? super WebView, ? super String, t1> f7962c;
    @e

    /* renamed from: d */
    private l<? super Integer, t1> f7963d;
    @e

    /* renamed from: e */
    private l<? super String, t1> f7964e;
    @e

    /* renamed from: f */
    private p<? super WebView, ? super String, t1> f7965f;
    @e

    /* renamed from: g */
    private p<? super WebView, ? super String, t1> f7966g;
    @e

    /* renamed from: h */
    private l<? super Intent, t1> f7967h;
    @e

    /* renamed from: i */
    private String f7968i;
    @e

    /* renamed from: j */
    private p<? super WebView, ? super String, Boolean> f7969j;

    /* renamed from: k */
    private boolean f7970k;
    @d

    /* renamed from: l */
    private final w f7971l;
    @d

    /* renamed from: m */
    private final w f7972m;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/vector/view/WebViewEx$Companion;", "", "()V", "UPLOAD_CODE", "", "UPLOAD_CODE_LOLLIPOP", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J,\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fH\u0007J\u001e\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u000f2\u0006\u0010\u0016\u001a\u00020\nH\u0007J&\u0010\u0014\u001a\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u000f2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\nH\u0007¨\u0006\u0018"}, d2 = {"com/vector/view/WebViewEx$setChromeClient$1", "Landroid/webkit/WebChromeClient;", "onProgressChanged", "", "view", "Landroid/webkit/WebView;", "newProgress", "", "onReceivedTitle", "title", "", "onShowFileChooser", "", "webView", "filePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "fileChooserParams", "Landroid/webkit/WebChromeClient$FileChooserParams;", "openFileChooser", "uploadMsg", "acceptType", "capture", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b extends WebChromeClient {
        public b() {
            WebViewEx.this = r1;
        }

        @Override // android.webkit.WebChromeClient
        public void onProgressChanged(@d WebView webView, int i2) {
            super.onProgressChanged(webView, i2);
            if (!WebViewEx.this.getShowProgress()) {
                ViewKt.n(WebViewEx.this.getProgressBar());
            } else if (i2 == 100) {
                ViewKt.n(WebViewEx.this.getProgressBar());
            } else {
                ViewKt.I(WebViewEx.this.getProgressBar());
                WebViewEx.this.getProgressBar().setProgress(i2);
            }
            l<Integer, t1> onProgressChanged = WebViewEx.this.getOnProgressChanged();
            if (onProgressChanged == null) {
                return;
            }
            onProgressChanged.invoke(Integer.valueOf(i2));
        }

        @Override // android.webkit.WebChromeClient
        public void onReceivedTitle(@d WebView webView, @d String str) {
            super.onReceivedTitle(webView, str);
            l<String, t1> onTitleChanged = WebViewEx.this.getOnTitleChanged();
            if (onTitleChanged == null) {
                return;
            }
            onTitleChanged.invoke(str);
        }

        @Override // android.webkit.WebChromeClient
        public boolean onShowFileChooser(@d WebView webView, @d ValueCallback<Uri[]> valueCallback, @d WebChromeClient.FileChooserParams fileChooserParams) {
            WebViewEx.this.onShowFileChooser(valueCallback, fileChooserParams.createIntent());
            return true;
        }

        @JavascriptInterface
        public final void openFileChooser(@d ValueCallback<Uri> valueCallback, @d String str, @d String str2) {
            WebViewEx.this.onOpenFileChooser(valueCallback);
        }

        @JavascriptInterface
        public final void openFileChooser(@d ValueCallback<Uri> valueCallback, @d String str) {
            WebViewEx.this.onOpenFileChooser(valueCallback);
        }

        @JavascriptInterface
        public final void openFileChooser(@d ValueCallback<Uri> valueCallback) {
            WebViewEx.this.onOpenFileChooser(valueCallback);
        }
    }

    @h
    public WebViewEx(@d Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @h
    public WebViewEx(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @h
    public WebViewEx(@d Context context, @e AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0, 8, null);
    }

    public /* synthetic */ WebViewEx(Context context, AttributeSet attributeSet, int i2, int i3, int i4, u uVar) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }

    public final ProgressBar getProgressBar() {
        return (ProgressBar) this.f7972m.getValue();
    }

    private final String h(Uri uri) {
        if (uri == null) {
            return null;
        }
        String[] strArr = {"_data"};
        Cursor query = getContext().getContentResolver().query(uri, strArr, null, null, null);
        if (query != null) {
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex(strArr[0]));
            query.close();
            return string;
        }
        return uri.getPath();
    }

    @SuppressLint({"PrivateApi"})
    public final void l() {
        Method declaredMethod;
        int i2 = Build.VERSION.SDK_INT;
        try {
            Class<?> cls = Class.forName("android.webkit.WebViewFactory");
            Field declaredField = cls.getDeclaredField("sProviderInstance");
            declaredField.setAccessible(true);
            if (declaredField.get(null) != null) {
                return;
            }
            if (i2 > 22) {
                declaredMethod = cls.getDeclaredMethod("getProviderClass", new Class[0]);
            } else if (i2 != 22) {
                return;
            } else {
                declaredMethod = cls.getDeclaredMethod("getFactoryClass", new Class[0]);
            }
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(cls, new Object[0]);
            if (invoke != null) {
                Class<?> cls2 = Class.forName("android.webkit.WebViewDelegate");
                Constructor constructor = ((Class) invoke).getConstructor(cls2);
                if (constructor != null) {
                    constructor.setAccessible(true);
                    Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    declaredField.set("sProviderInstance", constructor.newInstance(declaredConstructor.newInstance(new Object[0])));
                    return;
                }
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
        } catch (Throwable unused) {
        }
    }

    public static /* synthetic */ void n(WebViewEx webViewEx, String str, String str2, String str3, String str4, long j2) {
        t(webViewEx, str, str2, str3, str4, j2);
    }

    private final void r() {
        getWebView().setWebChromeClient(new b());
    }

    private final void s() {
        getWebView().setDownloadListener(new DownloadListener() { // from class: e.t.v.d
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j2) {
                WebViewEx.n(WebViewEx.this, str, str2, str3, str4, j2);
            }
        });
    }

    public static final void t(WebViewEx webViewEx, String str, String str2, String str3, String str4, long j2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(str));
        webViewEx.getContext().startActivity(intent);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void u() {
        WebSettings settings = getWebView().getSettings();
        settings.setCacheMode(-1);
        settings.setJavaScriptEnabled(true);
        settings.setMixedContentMode(0);
        settings.setLoadWithOverviewMode(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 29) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
        settings.setBuiltInZoomControls(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setTextZoom(100);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setDomStorageEnabled(true);
        if (i2 >= 21) {
            settings.setMixedContentMode(0);
        }
        getWebView().setScrollBarStyle(0);
    }

    private final void v() {
        getWebView().setWebViewClient(new c());
    }

    @SuppressLint({"JavascriptInterface"})
    public final void c(@d Object obj, @d String str) {
        getWebView().addJavascriptInterface(obj, str);
    }

    public final boolean d() {
        return getWebView().canGoBack();
    }

    public final boolean e() {
        return getWebView().canGoForward();
    }

    public final void f() {
        getWebView().clearCache(true);
    }

    public final void g() {
        try {
            CookieManager.getInstance().removeAllCookie();
            WebStorage.getInstance().deleteAllData();
        } catch (Exception unused) {
        }
    }

    @e
    public final l<Intent, t1> getOnClickChoosePhoto() {
        return this.f7967h;
    }

    @e
    public final p<WebView, String, t1> getOnLoadSchemeUri() {
        return this.f7962c;
    }

    @e
    public final p<WebView, String, Boolean> getOnLoading() {
        return this.f7969j;
    }

    @e
    public final p<WebView, String, t1> getOnPageLoadFinish() {
        return this.f7966g;
    }

    @e
    public final p<WebView, String, t1> getOnPageLoadStart() {
        return this.f7965f;
    }

    @e
    public final l<Integer, t1> getOnProgressChanged() {
        return this.f7963d;
    }

    @e
    public final l<String, t1> getOnTitleChanged() {
        return this.f7964e;
    }

    public final boolean getShowProgress() {
        return this.f7970k;
    }

    @e
    public final String getUrl() {
        return this.f7968i;
    }

    @d
    public final String getUserAgentString() {
        return getWebView().getSettings().getUserAgentString();
    }

    @d
    public final WebView getWebView() {
        return (WebView) this.f7971l.getValue();
    }

    public final void i() {
        ViewKt.n(getWebView());
        removeAllViews();
        if (getWebView().getSettings().getBuiltInZoomControls()) {
            AnyKt.A(ViewConfiguration.getZoomControlsTimeout(), TimeUnit.MILLISECONDS, null, new WebViewEx$destroy$1(this), 4, null);
        } else {
            getWebView().destroy();
        }
    }

    public final void j() {
        getWebView().goBack();
    }

    public final void k() {
        getWebView().goForward();
    }

    public final void m(boolean z) {
        this.f7970k = z;
    }

    public void o(@d String str) {
        getWebView().loadUrl(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewKt.I(getWebView());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewKt.n(getWebView());
    }

    @JavascriptInterface
    public final void onOpenFileChooser(@d ValueCallback<Uri> valueCallback) {
        this.a = valueCallback;
        l<? super Intent, t1> lVar = this.f7967h;
        if (lVar == null) {
            return;
        }
        lVar.invoke(null);
    }

    @JavascriptInterface
    public final void onShowFileChooser(@d ValueCallback<Uri[]> valueCallback, @d Intent intent) {
        this.b = valueCallback;
        l<? super Intent, t1> lVar = this.f7967h;
        if (lVar == null) {
            return;
        }
        lVar.invoke(intent);
    }

    public final void p(int i2, int i3, @e Intent intent) {
        if (intent == null) {
            ValueCallback<Uri> valueCallback = this.a;
            if (valueCallback != null) {
                valueCallback.onReceiveValue(null);
            }
            ValueCallback<Uri[]> valueCallback2 = this.b;
            if (valueCallback2 == null) {
                return;
            }
            valueCallback2.onReceiveValue(null);
        } else if (i2 != 1) {
            if (i2 == 2 && this.b != null) {
                String dataString = intent.getDataString();
                Uri[] uriArr = e.t.l.w.q(dataString) ? new Uri[]{Uri.parse(dataString)} : null;
                ValueCallback<Uri[]> valueCallback3 = this.b;
                if (valueCallback3 != null) {
                    valueCallback3.onReceiveValue(uriArr);
                }
                this.b = null;
            }
        } else if (this.a != null) {
            Uri fromFile = i3 != -1 ? null : Uri.fromFile(new File(h(intent.getData())));
            ValueCallback<Uri> valueCallback4 = this.a;
            if (valueCallback4 != null) {
                valueCallback4.onReceiveValue(fromFile);
            }
            this.a = null;
        }
    }

    public final void q() {
        getWebView().reload();
    }

    public final void setOnClickChoosePhoto(@e l<? super Intent, t1> lVar) {
        this.f7967h = lVar;
    }

    public final void setOnLoadSchemeUri(@e p<? super WebView, ? super String, t1> pVar) {
        this.f7962c = pVar;
    }

    public final void setOnLoading(@e p<? super WebView, ? super String, Boolean> pVar) {
        this.f7969j = pVar;
    }

    public final void setOnPageLoadFinish(@e p<? super WebView, ? super String, t1> pVar) {
        this.f7966g = pVar;
    }

    public final void setOnPageLoadStart(@e p<? super WebView, ? super String, t1> pVar) {
        this.f7965f = pVar;
    }

    public final void setOnProgressChanged(@e l<? super Integer, t1> lVar) {
        this.f7963d = lVar;
    }

    public final void setOnTitleChanged(@e l<? super String, t1> lVar) {
        this.f7964e = lVar;
    }

    public final void setProgressDrawable(@d Drawable drawable) {
        getProgressBar().setProgressDrawable(new ClipDrawable(drawable, GravityCompat.START, 1));
    }

    public final void setShowProgress(boolean z) {
        this.f7970k = z;
    }

    public final void setUrl(@e String str) {
        this.f7968i = str;
    }

    public final void setUserAgentString(@d String str) {
        getWebView().getSettings().setUserAgentString(str);
    }

    public final void setZoom(boolean z) {
        WebSettings settings = getWebView().getSettings();
        settings.setSupportZoom(z);
        settings.setBuiltInZoomControls(z);
        settings.setUseWideViewPort(z);
        settings.setLoadWithOverviewMode(z);
    }

    public final void w(@d String str, @d HashMap<String, String> hashMap) {
        try {
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.removeAllCookie();
            cookieManager.removeSessionCookie();
            cookieManager.setAcceptThirdPartyCookies(getWebView(), true);
            CookieManager.setAcceptFileSchemeCookies(true);
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                cookieManager.setCookie(str, entry.getKey() + '=' + entry.getValue());
            }
            cookieManager.flush();
        } catch (Exception unused) {
        }
    }

    @h
    public WebViewEx(@d Context context, @e AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        this.f7970k = true;
        this.f7971l = z.c(new WebViewEx$webView$2(this, context, attributeSet, i2, i3));
        this.f7972m = z.c(new WebViewEx$progressBar$2(context));
        addView(getWebView());
        addView(getProgressBar());
        u();
        v();
        r();
        s();
    }

    @Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u0016"}, d2 = {"com/vector/view/WebViewEx$setWebClient$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", com.umeng.analytics.pro.d.O, "Landroid/webkit/WebResourceError;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "shouldOverrideUrlLoading", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class c extends WebViewClient {
        public c() {
            WebViewEx.this = r1;
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(@e WebView webView, @e String str) {
            super.onPageFinished(webView, str);
            p<WebView, String, t1> onPageLoadFinish = WebViewEx.this.getOnPageLoadFinish();
            if (onPageLoadFinish == null) {
                return;
            }
            onPageLoadFinish.invoke(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(@e WebView webView, @e String str, @e Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            p<WebView, String, t1> onPageLoadStart = WebViewEx.this.getOnPageLoadStart();
            if (onPageLoadStart == null) {
                return;
            }
            onPageLoadStart.invoke(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(@e WebView webView, @e WebResourceRequest webResourceRequest, @e WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(@e WebView webView, @e SslErrorHandler sslErrorHandler, @e SslError sslError) {
            if (sslErrorHandler == null) {
                return;
            }
            sslErrorHandler.cancel();
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@d WebView webView, @d String str) {
            Boolean invoke;
            if (URLUtil.isNetworkUrl(str)) {
                p<WebView, String, Boolean> onLoading = WebViewEx.this.getOnLoading();
                boolean z = false;
                if (onLoading != null && (invoke = onLoading.invoke(webView, str)) != null) {
                    z = invoke.booleanValue();
                }
                if (z) {
                    webView.loadUrl(str);
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }
            try {
                p<WebView, String, t1> onLoadSchemeUri = WebViewEx.this.getOnLoadSchemeUri();
                if (onLoadSchemeUri == null) {
                    return true;
                }
                onLoadSchemeUri.invoke(webView, str);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return true;
            }
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(@e WebView webView, @e WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }
}
