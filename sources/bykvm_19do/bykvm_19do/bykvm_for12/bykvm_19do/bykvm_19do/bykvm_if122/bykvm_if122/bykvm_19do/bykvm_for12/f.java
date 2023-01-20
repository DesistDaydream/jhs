package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import com.qiniu.android.http.request.Request;

/* loaded from: classes.dex */
public final class f {
    public static boolean a(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals(Request.HttpMethodPUT) || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean b(String str) {
        return e(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }

    public static boolean c(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean d(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean e(String str) {
        return str.equals("POST") || str.equals(Request.HttpMethodPUT) || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }
}
