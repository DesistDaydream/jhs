package e.k.c.a.a.h.d;

import android.os.Build;
import android.text.TextUtils;
import e.k.c.a.a.h.g.g;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/* loaded from: classes2.dex */
public abstract class c {
    private static final String a = "PBKDF2";
    private static final String b = "PBKDF2WithHmacSHA1";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11851c = "PBKDF2WithHmacSHA256";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11852d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final int f11853e = 8;

    /* renamed from: f  reason: collision with root package name */
    private static final int f11854f = 16;

    /* renamed from: g  reason: collision with root package name */
    private static final int f11855g = 32;

    /* renamed from: h  reason: collision with root package name */
    private static final int f11856h = 10000;

    /* renamed from: i  reason: collision with root package name */
    private static final int f11857i = 1000;

    private static boolean a(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        int length = bArr.length ^ bArr2.length;
        for (int i2 = 0; i2 < bArr.length && i2 < bArr2.length; i2++) {
            length |= bArr[i2] ^ bArr2[i2];
        }
        return length == 0;
    }

    private static byte[] b(char[] cArr, byte[] bArr, int i2, int i3, boolean z) {
        SecretKeyFactory secretKeyFactory;
        try {
            PBEKeySpec pBEKeySpec = new PBEKeySpec(cArr, bArr, i2, i3);
            if (z) {
                secretKeyFactory = SecretKeyFactory.getInstance(f11851c);
            } else {
                secretKeyFactory = SecretKeyFactory.getInstance(b);
            }
            return secretKeyFactory.generateSecret(pBEKeySpec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            String str = a;
            g.d(str, "pbkdf exception : " + e2.getMessage());
            return new byte[0];
        }
    }

    public static byte[] c(char[] cArr, byte[] bArr, int i2, int i3) {
        return b(cArr, bArr, i2, i3, false);
    }

    @Deprecated
    public static String d(String str) {
        return e(str, 10000);
    }

    @Deprecated
    public static String e(String str, int i2) {
        return f(str, e.k.c.a.a.h.g.b.d(8), i2, 32);
    }

    @Deprecated
    public static String f(String str, byte[] bArr, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            g.d(a, "pwd is null.");
            return "";
        } else if (i2 < 1000) {
            g.d(a, "iterations times is not enough.");
            return "";
        } else if (bArr == null || bArr.length < 8) {
            g.d(a, "salt parameter is null or length is not enough");
            return "";
        } else if (i3 < 32) {
            g.d(a, "cipherLen length is not enough");
            return "";
        } else {
            byte[] c2 = c(str.toCharArray(), bArr, i2, i3 * 8);
            return e.k.c.a.a.h.g.c.b(bArr) + e.k.c.a.a.h.g.c.b(c2);
        }
    }

    public static String g(String str) {
        return h(str, 10000);
    }

    public static String h(String str, int i2) {
        return i(str, e.k.c.a.a.h.g.b.d(16), i2, 32);
    }

    public static String i(String str, byte[] bArr, int i2, int i3) {
        byte[] j2;
        if (TextUtils.isEmpty(str)) {
            g.d(a, "pwd is null.");
            return "";
        } else if (i2 < 1000) {
            g.d(a, "iterations times is not enough.");
            return "";
        } else if (bArr == null || bArr.length < 16) {
            g.d(a, "salt parameter is null or length is not enough");
            return "";
        } else if (i3 < 32) {
            g.d(a, "cipherLen length is not enough");
            return "";
        } else {
            if (Build.VERSION.SDK_INT < 26) {
                g.e(a, "sha 1");
                j2 = c(str.toCharArray(), bArr, i2, i3 * 8);
            } else {
                g.e(a, "sha 256");
                j2 = j(str.toCharArray(), bArr, i2, i3 * 8);
            }
            return e.k.c.a.a.h.g.c.b(bArr) + e.k.c.a.a.h.g.c.b(j2);
        }
    }

    public static byte[] j(char[] cArr, byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[0];
        if (Build.VERSION.SDK_INT < 26) {
            g.d(a, "system version not high than 26");
            return bArr2;
        }
        return b(cArr, bArr, i2, i3, true);
    }

    @Deprecated
    public static boolean k(String str, String str2) {
        return l(str, str2, 10000);
    }

    @Deprecated
    public static boolean l(String str, String str2, int i2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 16) {
            return false;
        }
        return a(c(str.toCharArray(), e.k.c.a.a.h.g.c.c(str2.substring(0, 16)), i2, 256), e.k.c.a.a.h.g.c.c(str2.substring(16)));
    }

    public static boolean m(String str, String str2) {
        return n(str, str2, 10000);
    }

    public static boolean n(String str, String str2, int i2) {
        byte[] j2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str2.length() < 32) {
            return false;
        }
        String substring = str2.substring(0, 32);
        String substring2 = str2.substring(32);
        if (Build.VERSION.SDK_INT < 26) {
            j2 = c(str.toCharArray(), e.k.c.a.a.h.g.c.c(substring), i2, 256);
        } else {
            j2 = j(str.toCharArray(), e.k.c.a.a.h.g.c.c(substring), i2, 256);
        }
        return a(j2, e.k.c.a.a.h.g.c.c(substring2));
    }
}
