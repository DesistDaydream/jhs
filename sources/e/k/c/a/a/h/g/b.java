package e.k.c.a.a.h.g;

import android.os.Build;
import android.util.Base64;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/* loaded from: classes2.dex */
public class b {
    private static final String a = "EncryptUtil";
    private static final String b = "RSA";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f11889c = false;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f11890d = true;

    /* JADX WARN: Removed duplicated region for block: B:23:0x001b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.security.SecureRandom a() {
        /*
            java.lang.String r0 = "EncryptUtil"
            java.lang.String r1 = "generateSecureRandomNew "
            e.k.c.a.a.h.g.g.b(r0, r1)
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.security.NoSuchAlgorithmException -> L12
            r2 = 26
            if (r1 < r2) goto L17
            java.security.SecureRandom r1 = java.security.SecureRandom.getInstanceStrong()     // Catch: java.security.NoSuchAlgorithmException -> L12
            goto L18
        L12:
            java.lang.String r1 = "getSecureRandomBytes: NoSuchAlgorithmException"
            e.k.c.a.a.h.g.g.d(r0, r1)
        L17:
            r1 = 0
        L18:
            r2 = 0
            if (r1 != 0) goto L24
            java.lang.String r3 = "SHA1PRNG"
            java.security.SecureRandom r1 = java.security.SecureRandom.getInstance(r3)     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            goto L24
        L22:
            r3 = move-exception
            goto L43
        L24:
            r3 = 1
            org.bouncycastle.crypto.engines.AESEngine r4 = new org.bouncycastle.crypto.engines.AESEngine     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            r4.<init>()     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            r5 = 256(0x100, float:3.59E-43)
            r6 = 384(0x180, float:5.38E-43)
            r7 = 32
            byte[] r7 = new byte[r7]     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            r1.nextBytes(r7)     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            org.bouncycastle.crypto.prng.SP800SecureRandomBuilder r8 = new org.bouncycastle.crypto.prng.SP800SecureRandomBuilder     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            r8.<init>(r1, r3)     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            org.bouncycastle.crypto.prng.SP800SecureRandomBuilder r3 = r8.setEntropyBitsRequired(r6)     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            org.bouncycastle.crypto.prng.SP800SecureRandom r0 = r3.buildCTR(r4, r5, r7, r2)     // Catch: java.lang.Throwable -> L22 java.security.NoSuchAlgorithmException -> L67
            return r0
        L43:
            boolean r4 = e.k.c.a.a.h.g.b.f11890d
            if (r4 == 0) goto L6c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "exception : "
            r4.append(r5)
            java.lang.String r3 = r3.getMessage()
            r4.append(r3)
            java.lang.String r3 = " , you should implementation bcprov-jdk15on library"
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            e.k.c.a.a.h.g.g.d(r0, r3)
            e.k.c.a.a.h.g.b.f11890d = r2
            goto L6c
        L67:
            java.lang.String r2 = "NoSuchAlgorithmException"
            e.k.c.a.a.h.g.g.d(r0, r2)
        L6c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.k.c.a.a.h.g.b.a():java.security.SecureRandom");
    }

    private static byte[] b(int i2) {
        SecureRandom a2 = a();
        if (a2 == null) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        a2.nextBytes(bArr);
        return bArr;
    }

    public static SecureRandom c() {
        if (!f11889c) {
            SecureRandom secureRandom = null;
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    secureRandom = SecureRandom.getInstanceStrong();
                } else {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                }
            } catch (NoSuchAlgorithmException unused) {
                g.d(a, "genSecureRandom: NoSuchAlgorithmException");
            }
            return secureRandom;
        }
        return a();
    }

    public static byte[] d(int i2) {
        if (!f11889c) {
            byte[] bArr = new byte[i2];
            SecureRandom secureRandom = null;
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    secureRandom = SecureRandom.getInstanceStrong();
                }
            } catch (NoSuchAlgorithmException unused) {
                g.d(a, "getSecureRandomBytes: NoSuchAlgorithmException");
            }
            if (secureRandom == null) {
                try {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                } catch (NoSuchAlgorithmException unused2) {
                    g.d(a, "getSecureRandomBytes getInstance: NoSuchAlgorithmException");
                    return new byte[0];
                } catch (Exception e2) {
                    g.d(a, "getSecureRandomBytes getInstance: exception : " + e2.getMessage());
                    return new byte[0];
                }
            }
            secureRandom.nextBytes(bArr);
            return bArr;
        }
        return b(i2);
    }

    public static String e(int i2) {
        return c.b(d(i2));
    }

    public static PrivateKey f(String str) {
        try {
            try {
                return KeyFactory.getInstance(b).generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e2) {
                g.d(a, "load Key Exception:" + e2.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            g.d(a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e3) {
            g.d(a, "base64 decode Exception" + e3.getMessage());
            return null;
        }
    }

    public static RSAPublicKey g(String str) {
        try {
            try {
                return (RSAPublicKey) KeyFactory.getInstance(b).generatePublic(new X509EncodedKeySpec(Base64.decode(str, 0)));
            } catch (GeneralSecurityException e2) {
                g.d(a, "load Key Exception:" + e2.getMessage());
                return null;
            }
        } catch (IllegalArgumentException unused) {
            g.d(a, "base64 decode IllegalArgumentException");
            return null;
        } catch (Exception e3) {
            g.d(a, "base64 decode Exception" + e3.getMessage());
            return null;
        }
    }

    public static boolean h() {
        return f11889c;
    }

    public static void i(boolean z) {
        g.e(a, "setBouncycastleFlag: " + z);
        f11889c = z;
    }
}
