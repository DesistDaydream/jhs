package com.huawei.hms.hatool;

import android.util.Pair;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class d1 extends v {

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[y0.values().length];
            a = iArr;
            try {
                iArr[y0.SN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[y0.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[y0.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static e1 a(String str, String str2) {
        e1 a2 = v.a(str, str2);
        x0 c2 = z0.a().c(str, str2);
        a2.g(z0.a().a(c.c(str, str2)));
        a2.f(c.o(str, str2));
        a2.c(z0.a().f(str, str2));
        int i2 = a.a[c2.a().ordinal()];
        if (i2 == 1) {
            a2.d(c2.b());
        } else if (i2 == 2) {
            a2.b(c2.b());
        } else if (i2 == 3) {
            a2.e(c2.b());
        }
        return a2;
    }

    public static f1 a(String str, String str2, String str3, String str4) {
        f1 a2 = v.a(str, str2, str3, str4);
        String a3 = z0.a().a(c.c(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String b = e.k.c.a.a.h.d.d.b(b.f() + a3 + currentTimeMillis);
        a2.f(String.valueOf(currentTimeMillis));
        a2.g(b);
        return a2;
    }

    public static g1 a(String str, String str2, String str3) {
        g1 a2 = v.a(str, str2, str3);
        Pair<String, String> e2 = z0.a().e(str2, str);
        a2.f((String) e2.first);
        a2.g((String) e2.second);
        a2.h(f.b());
        a2.d(z0.a().d(str2, str));
        return a2;
    }

    public static C0510r a(List<q> list, String str, String str2, String str3, String str4) {
        y.c("hmsSdk", "generate UploadData");
        C0510r b = v.b(str, str2);
        if (b == null) {
            return null;
        }
        b.a(a(x.d().a(), str, str2, str3));
        b.a(a(str, str2));
        b.a(a(str2, str, str4));
        b.a(c.g(str, str2));
        b.a(list);
        return b;
    }

    public static Map<String, String> b(String str, String str2, String str3) {
        Map<String, String> c2 = v.c(str, str3);
        Map<String, String> i2 = c.i(str, str2);
        if (i2 == null) {
            return c2;
        }
        c2.putAll(i2);
        return c2;
    }
}
