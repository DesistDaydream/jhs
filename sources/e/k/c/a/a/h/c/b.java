package e.k.c.a.a.h.c;

import android.os.Build;
import android.text.TextUtils;
import e.k.c.a.a.h.g.g;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class b {
    private static final String a = "security:";
    private static final String b = "AES/GCM/NoPadding";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11834c = "AES";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11835d = "GCM";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11836e = "";

    /* renamed from: f  reason: collision with root package name */
    private static final int f11837f = 16;

    /* renamed from: g  reason: collision with root package name */
    private static final int f11838g = 12;

    /* renamed from: h  reason: collision with root package name */
    private static final int f11839h = 2;

    private b() {
    }

    private static int a(byte[] bArr) {
        return bArr[12] == 58 ? 12 : -1;
    }

    private static String b(String str) {
        return (TextUtils.isEmpty(str) || str.length() < 24) ? "" : str.substring(24);
    }

    private static byte[] c(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g.d("GCM", "encrypt 5 content is null");
            return new byte[0];
        } else if (bArr == null) {
            g.d("GCM", "encrypt 5 key is null");
            return new byte[0];
        } else if (bArr.length < 16) {
            g.d("GCM", "encrypt 5 key lengh is not right");
            return new byte[0];
        } else if (bArr2 == null) {
            g.d("GCM", "encrypt 5 iv is null");
            return new byte[0];
        } else if (bArr2.length < 12) {
            g.d("GCM", "encrypt 5 iv lengh is not right");
            return new byte[0];
        } else if (!x()) {
            g.d("GCM", "encrypt 5 build version not higher than 19");
            return new byte[0];
        } else {
            try {
                return v(str.getBytes("UTF-8"), bArr, bArr2);
            } catch (UnsupportedEncodingException e2) {
                g.d("GCM", "GCM encrypt data error" + e2.getMessage());
                return new byte[0];
            }
        }
    }

    private static byte[] d(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static String e(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 24) {
            return str.substring(0, 24);
        }
        g.d("GCM", "IV is invalid.");
        return "";
    }

    private static byte[] f(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 12];
        System.arraycopy(bArr, 12, bArr2, 0, bArr.length - 12);
        return bArr2;
    }

    private static byte[] g(byte[] bArr) {
        byte[] bArr2 = new byte[12];
        System.arraycopy(bArr, 0, bArr2, 0, 12);
        return bArr2;
    }

    public static String h(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g.d("GCM", "decrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            g.d("GCM", "decrypt 1 key is null");
            return "";
        } else if (!x()) {
            g.d("GCM", "decrypt 1 build version not higher than 19");
            return "";
        } else {
            byte[] c2 = e.k.c.a.a.h.g.c.c(str2);
            if (c2.length < 16) {
                g.d("GCM", "decrypt 1 key length is not right");
                return "";
            }
            return j(str, c2);
        }
    }

    public static String i(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            g.d("GCM", "decrypt 3 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            g.d("GCM", "decrypt 3 key is null");
            return "";
        } else if (TextUtils.isEmpty(str3)) {
            g.d("GCM", "decrypt 3 iv is null");
            return "";
        } else if (!x()) {
            g.d("GCM", "decrypt 3 build version not higher than 19");
            return "";
        } else {
            byte[] c2 = e.k.c.a.a.h.g.c.c(str2);
            byte[] c3 = e.k.c.a.a.h.g.c.c(str3);
            if (c2.length < 16) {
                g.d("GCM", "decrypt 3 key length is not right");
                return "";
            } else if (c3.length < 12) {
                g.d("GCM", "decrypt 3 iv length is not right");
                return "";
            } else {
                return k(str, c2, c3);
            }
        }
    }

    public static String j(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            g.d("GCM", "decrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            g.d("GCM", "decrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            g.d("GCM", "decrypt 2 key lengh is not right");
            return "";
        } else if (!x()) {
            g.d("GCM", "decrypt 2 build version not higher than 19");
            return "";
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f11834c);
                Cipher cipher = Cipher.getInstance(b);
                String e2 = e(str);
                String b2 = b(str);
                if (TextUtils.isEmpty(e2)) {
                    g.d("GCM", "decrypt 2 iv is null");
                    return "";
                } else if (TextUtils.isEmpty(b2)) {
                    g.d("GCM", "decrypt 2 encrypt content is null");
                    return "";
                } else {
                    cipher.init(2, secretKeySpec, w(e.k.c.a.a.h.g.c.c(e2)));
                    return new String(cipher.doFinal(e.k.c.a.a.h.g.c.c(b2)), "UTF-8");
                }
            } catch (UnsupportedEncodingException | GeneralSecurityException e3) {
                g.d("GCM", "GCM decrypt data exception: " + e3.getMessage());
                return "";
            }
        }
    }

    public static String k(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g.d("GCM", "decrypt 4 content is null");
            return "";
        } else if (bArr == null) {
            g.d("GCM", "decrypt 4 key is null");
            return "";
        } else if (bArr.length < 16) {
            g.d("GCM", "decrypt 4 key lengh is not right");
            return "";
        } else if (bArr2 == null) {
            g.d("GCM", "decrypt 4 iv is null");
            return "";
        } else if (bArr2.length < 12) {
            g.d("GCM", "decrypt 4 iv lengh is not right");
            return "";
        } else if (!x()) {
            g.d("GCM", "decrypt 4 build version not higher than 19");
            return "";
        } else {
            try {
                return new String(m(e.k.c.a.a.h.g.c.c(str), bArr, bArr2), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                g.d("GCM", "GCM decrypt data exception: " + e2.getMessage());
                return "";
            }
        }
    }

    public static byte[] l(byte[] bArr, byte[] bArr2) {
        return m(f(bArr), bArr2, g(bArr));
    }

    public static byte[] m(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            g.d("GCM", "decrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            g.d("GCM", "decrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            g.d("GCM", "decrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            g.d("GCM", "decrypt 6 key length is error");
            return new byte[0];
        } else if (bArr3 == null) {
            g.d("GCM", "decrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 12) {
            g.d("GCM", "decrypt 6 iv length is error");
            return new byte[0];
        } else if (!x()) {
            g.d("GCM", "decrypt 6 build version not higher than 19");
            return new byte[0];
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f11834c);
                Cipher cipher = Cipher.getInstance(b);
                cipher.init(2, secretKeySpec, w(bArr3));
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e2) {
                g.d("GCM", "GCM decrypt data exception: " + e2.getMessage());
                return new byte[0];
            }
        }
    }

    public static String n(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String h2 = a.h(str);
            if ("".equals(h2)) {
                return "";
            }
            int indexOf = h2.indexOf(58);
            if (indexOf >= 0) {
                return k(e.k.c.a.a.h.g.c.b(e.k.c.a.a.h.g.c.c(h2.substring(indexOf + 1))), bArr, e.k.c.a.a.h.g.c.c(h2.substring(0, indexOf)));
            }
            g.d("GCM", " gcm cipherText data missing colon");
        }
        return "";
    }

    public static String o(byte[] bArr, byte[] bArr2) {
        try {
            return new String(p(bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            g.d("GCM", "UnsupportedEncodingException");
            return "";
        }
    }

    public static byte[] p(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] j2 = a.j(bArr);
        if (j2.length == 0) {
            return new byte[0];
        }
        int a2 = a(j2);
        if (a2 >= 0) {
            byte[] copyOf = Arrays.copyOf(j2, a2);
            int length = (j2.length - copyOf.length) - 1;
            byte[] bArr3 = new byte[length];
            System.arraycopy(j2, a2 + 1, bArr3, 0, length);
            return m(bArr3, bArr2, copyOf);
        }
        g.d("GCM", " gcm cipherText data missing colon");
        return new byte[0];
    }

    public static String q(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g.d("GCM", "encrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            g.d("GCM", "encrypt 1 key is null");
            return "";
        } else if (!x()) {
            g.d("GCM", "encrypt 1 build version not higher than 19");
            return "";
        } else {
            byte[] c2 = e.k.c.a.a.h.g.c.c(str2);
            if (c2.length < 16) {
                g.d("GCM", "encrypt 1 key length is not right");
                return "";
            }
            return s(str, c2);
        }
    }

    public static String r(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            g.d("GCM", "encrypt 3 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            g.d("GCM", "encrypt 3 key is null");
            return "";
        } else if (TextUtils.isEmpty(str3)) {
            g.d("GCM", "encrypt 3 iv is null");
            return "";
        } else if (!x()) {
            g.d("GCM", "encrypt 3 build version not higher than 19");
            return "";
        } else {
            byte[] c2 = e.k.c.a.a.h.g.c.c(str2);
            byte[] c3 = e.k.c.a.a.h.g.c.c(str3);
            if (c2.length < 16) {
                g.d("GCM", "encrypt 3 key length is not right");
                return "";
            } else if (c3.length < 12) {
                g.d("GCM", "encrypt 3 iv length is not right");
                return "";
            } else {
                return t(str, c2, c3);
            }
        }
    }

    public static String s(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            g.d("GCM", "encrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            g.d("GCM", "encrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            g.d("GCM", "encrypt 2 key lengh is not right");
            return "";
        } else if (!x()) {
            g.d("GCM", "encrypt 2 build version not higher than 19");
            return "";
        } else {
            byte[] d2 = e.k.c.a.a.h.g.b.d(12);
            byte[] c2 = c(str, bArr, d2);
            if (c2 == null || c2.length == 0) {
                return "";
            }
            String b2 = e.k.c.a.a.h.g.c.b(d2);
            String b3 = e.k.c.a.a.h.g.c.b(c2);
            return b2 + b3;
        }
    }

    public static String t(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g.d("GCM", "encrypt 4 content is null");
            return "";
        } else if (bArr == null) {
            g.d("GCM", "encrypt 4 key is null");
            return "";
        } else if (bArr.length < 16) {
            g.d("GCM", "encrypt 4 key lengh is not right");
            return "";
        } else if (bArr2 == null) {
            g.d("GCM", "encrypt 4 iv is null");
            return "";
        } else if (bArr2.length < 12) {
            g.d("GCM", "encrypt 4 iv lengh is not right");
            return "";
        } else if (!x()) {
            g.d("GCM", "encrypt 4 build version not higher than 19");
            return "";
        } else {
            return e.k.c.a.a.h.g.c.b(c(str, bArr, bArr2));
        }
    }

    public static byte[] u(byte[] bArr, byte[] bArr2) {
        byte[] d2 = e.k.c.a.a.h.g.b.d(12);
        return d(d2, v(bArr, bArr2, d2));
    }

    public static byte[] v(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            g.d("GCM", "encrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            g.d("GCM", "encrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            g.d("GCM", "encrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            g.d("GCM", "encrypt 6 key length is error");
            return new byte[0];
        } else if (bArr3 == null) {
            g.d("GCM", "encrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 12) {
            g.d("GCM", "encrypt 6 iv length is error");
            return new byte[0];
        } else if (!x()) {
            g.d("GCM", "encrypt 6 build version not higher than 19");
            return new byte[0];
        } else {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f11834c);
                Cipher cipher = Cipher.getInstance(b);
                cipher.init(1, secretKeySpec, w(bArr3));
                return cipher.doFinal(bArr);
            } catch (GeneralSecurityException e2) {
                g.d("GCM", "GCM encrypt data error" + e2.getMessage());
                return new byte[0];
            }
        }
    }

    public static AlgorithmParameterSpec w(byte[] bArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return new IvParameterSpec(bArr);
        }
        return new GCMParameterSpec(128, bArr);
    }

    public static boolean x() {
        return Build.VERSION.SDK_INT >= 19;
    }
}
