package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.m;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import com.qiniu.android.http.request.Request;
import java.util.List;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class e {
    static {
        Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");
    }

    public static int a(String str, int i2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static int a(String str, int i2, String str2) {
        while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            i2++;
        }
        return i2;
    }

    public static long a(a0 a0Var) {
        return a(a0Var.m());
    }

    public static long a(r rVar) {
        return a(rVar.a("Content-Length"));
    }

    private static long a(String str) {
        if (str != null) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException unused) {
                return -1L;
            }
        }
        return -1L;
    }

    public static void a(m mVar, s sVar, r rVar) {
        if (mVar == m.a) {
            return;
        }
        List<l> a = l.a(sVar, rVar);
        if (a.isEmpty()) {
            return;
        }
        mVar.a(sVar, a);
    }

    public static int b(String str, int i2) {
        char charAt;
        while (i2 < str.length() && ((charAt = str.charAt(i2)) == ' ' || charAt == '\t')) {
            i2++;
        }
        return i2;
    }

    public static boolean b(a0 a0Var) {
        int k2;
        return (a0Var.s().e().equals(Request.HttpMethodHEAD) || ((((k2 = a0Var.k()) >= 100 && k2 < 200) || k2 == 204 || k2 == 304) && a(a0Var) == -1 && !"chunked".equalsIgnoreCase(a0Var.b("Transfer-Encoding")))) ? false : true;
    }
}
