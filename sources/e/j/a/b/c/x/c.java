package e.j.a.b.c.x;

import android.util.Base64;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class c {
    @e.j.a.b.c.m.a
    public static byte[] a(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    @e.j.a.b.c.m.a
    public static byte[] b(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 10);
    }

    @e.j.a.b.c.m.a
    public static byte[] c(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 11);
    }

    @e.j.a.b.c.m.a
    public static String d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 0);
    }

    @e.j.a.b.c.m.a
    public static String e(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 10);
    }

    @e.j.a.b.c.m.a
    public static String f(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 11);
    }
}
