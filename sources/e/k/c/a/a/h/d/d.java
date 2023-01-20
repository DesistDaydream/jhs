package e.k.c.a.a.h.d;

import android.text.TextUtils;
import e.k.c.a.a.h.g.g;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public final class d {
    private static final String a = "SHA";
    private static final String b = "SHA-256";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11858c = "";

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f11859d = {"SHA-256", "SHA-384", "SHA-512"};

    private d() {
    }

    private static boolean a(String str) {
        for (String str2 : f11859d) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String b(String str) {
        return c(str, "SHA-256");
    }

    public static String c(String str, String str2) {
        byte[] bArr;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (!a(str2)) {
                g.d(a, "algorithm is not safe or legal");
                return "";
            }
            try {
                bArr = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
                bArr = new byte[0];
                g.d(a, "Error in generate SHA UnsupportedEncodingException");
            }
            return e.k.c.a.a.h.g.c.b(d(bArr, str2));
        }
        g.d(a, "content or algorithm is null.");
        return "";
    }

    public static byte[] d(byte[] bArr, String str) {
        if (bArr != null && !TextUtils.isEmpty(str)) {
            if (!a(str)) {
                g.d(a, "algorithm is not safe or legal");
                return new byte[0];
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException unused) {
                g.d(a, "Error in generate SHA NoSuchAlgorithmException");
                return new byte[0];
            }
        }
        g.d(a, "content or algorithm is null.");
        return new byte[0];
    }

    public static boolean e(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        return str2.equals(c(str, str3));
    }

    public static boolean f(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return str2.equals(b(str));
    }
}
