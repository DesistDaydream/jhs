package e.k.c.a.a.k;

import android.webkit.URLUtil;

/* loaded from: classes2.dex */
public class j {
    public static final String a = "file:///android_res/";

    public static boolean a(String str) {
        return URLUtil.isAboutUrl(str);
    }

    public static boolean b(String str) {
        return URLUtil.isAssetUrl(str);
    }

    public static boolean c(String str) {
        return URLUtil.isContentUrl(str);
    }

    public static boolean d(String str) {
        return URLUtil.isDataUrl(str);
    }

    public static boolean e(String str) {
        return URLUtil.isFileUrl(str);
    }

    public static boolean f(String str) {
        return URLUtil.isHttpUrl(str);
    }

    public static boolean g(String str) {
        return URLUtil.isHttpsUrl(str);
    }

    public static boolean h(String str) {
        return URLUtil.isJavaScriptUrl(str);
    }

    public static boolean i(String str) {
        return URLUtil.isNetworkUrl(str);
    }

    public static boolean j(String str) {
        return str != null && str.startsWith(a);
    }

    public static boolean k(String str) {
        return URLUtil.isValidUrl(str);
    }
}
