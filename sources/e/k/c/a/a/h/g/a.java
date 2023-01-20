package e.k.c.a.a.h.g;

import android.annotation.SuppressLint;

/* loaded from: classes2.dex */
public class a {
    private static final String a = "BaseKeyUtil";
    private static final int b = 16;

    /* renamed from: c  reason: collision with root package name */
    private static final int f11885c = 16;

    /* renamed from: d  reason: collision with root package name */
    private static final int f11886d = 10000;

    /* renamed from: e  reason: collision with root package name */
    private static final int f11887e = 32;

    /* renamed from: f  reason: collision with root package name */
    private static final int f11888f = 1;

    private static int a(int i2, int i3, int i4) {
        if (i3 < i2) {
            i2 = i3;
        }
        return i4 < i2 ? i4 : i2;
    }

    private static boolean b(int i2) {
        return i2 >= 16;
    }

    private static boolean c(int i2, byte[] bArr) {
        return b(i2) & d(bArr);
    }

    private static boolean d(byte[] bArr) {
        return bArr.length >= 16;
    }

    public static String e(String str, String str2, String str3, byte[] bArr, int i2, boolean z) {
        return c.b(h(str, str2, str3, bArr, i2, z));
    }

    public static byte[] f(String str, String str2, String str3, String str4, int i2, boolean z) {
        return h(str, str2, str3, c.c(str4), i2, z);
    }

    public static byte[] g(String str, String str2, String str3, byte[] bArr, int i2, int i3, boolean z) {
        byte[] c2 = c.c(str);
        byte[] c3 = c.c(str2);
        byte[] c4 = c.c(str3);
        int a2 = a(c2.length, c3.length, c4.length);
        if (c(a2, bArr)) {
            char[] cArr = new char[a2];
            for (int i4 = 0; i4 < a2; i4++) {
                cArr[i4] = (char) ((c2[i4] ^ c3[i4]) ^ c4[i4]);
            }
            if (!z) {
                g.e(a, "exportRootKey: sha1");
                return e.k.c.a.a.h.d.c.c(cArr, bArr, i2, i3 * 8);
            }
            g.e(a, "exportRootKey: sha256");
            return e.k.c.a.a.h.d.c.j(cArr, bArr, i2, i3 * 8);
        }
        throw new IllegalArgumentException("key length must be more than 128bit.");
    }

    @SuppressLint({"NewApi"})
    public static byte[] h(String str, String str2, String str3, byte[] bArr, int i2, boolean z) {
        return g(str, str2, str3, bArr, 10000, i2, z);
    }

    @SuppressLint({"NewApi"})
    public static byte[] i(String str, String str2, String str3, byte[] bArr, boolean z) {
        return h(str, str2, str3, bArr, 16, z);
    }

    public static byte[] j(String str, String str2, String str3, byte[] bArr, boolean z) {
        return h(str, str2, str3, bArr, 32, z);
    }

    public static byte[] k(String str, String str2, String str3, byte[] bArr, boolean z) {
        return g(str, str2, str3, bArr, 1, 32, z);
    }

    @SuppressLint({"NewApi"})
    public static byte[] l(String str, String str2, String str3, byte[] bArr, boolean z) {
        return g(str, str2, str3, bArr, 1, 16, z);
    }
}
