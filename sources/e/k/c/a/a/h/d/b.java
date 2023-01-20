package e.k.c.a.a.h.d;

import android.text.TextUtils;
import e.k.c.a.a.h.g.g;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public abstract class b {
    private static final String a = "HMACSHA256";
    private static final String b = "HmacSHA256";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11849c = "";

    /* renamed from: d  reason: collision with root package name */
    private static final int f11850d = 32;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr2 != null) {
            if (bArr2.length < 32) {
                g.d(a, "hmac key length is not right");
                return new byte[0];
            }
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, b);
                Mac mac = Mac.getInstance(secretKeySpec.getAlgorithm());
                mac.init(secretKeySpec);
                return mac.doFinal(bArr);
            } catch (InvalidKeyException | NoSuchAlgorithmException e2) {
                String str = a;
                g.d(str, "hmacsha256 encrypt exception" + e2.getMessage());
                return new byte[0];
            }
        }
        g.d(a, "content or key is null.");
        return new byte[0];
    }

    public static String b(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : c(str, e.k.c.a.a.h.g.c.c(str2));
    }

    public static String c(String str, byte[] bArr) {
        byte[] bArr2;
        if (TextUtils.isEmpty(str) || bArr == null) {
            return "";
        }
        if (bArr.length < 32) {
            g.d(a, "hmac key length is not right");
            return "";
        }
        try {
            bArr2 = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e2) {
            String str2 = a;
            g.d(str2, "hmacsha256 encrypt exception" + e2.getMessage());
            bArr2 = new byte[0];
        }
        return e.k.c.a.a.h.g.c.b(a(bArr2, bArr));
    }
}
