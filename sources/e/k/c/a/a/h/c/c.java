package e.k.c.a.a.h.c;

import e.k.c.a.a.h.g.g;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class c {
    private static final String a = "CipherUtil";
    private static final String b = "AES/GCM/NoPadding";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11840c = "AES/CBC/PKCS5Padding";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11841d = "AES";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11842e = "";

    /* renamed from: f  reason: collision with root package name */
    private static final int f11843f = 16;

    /* renamed from: g  reason: collision with root package name */
    private static final int f11844g = 12;

    /* renamed from: h  reason: collision with root package name */
    private static final int f11845h = 16;

    private static int a(Cipher cipher, byte[] bArr) {
        if (cipher == null || bArr == null) {
            return -1;
        }
        return cipher.getOutputSize(bArr.length);
    }

    private static Cipher b(byte[] bArr, byte[] bArr2, int i2) {
        return c(bArr, bArr2, i2, f11840c);
    }

    private static Cipher c(byte[] bArr, byte[] bArr2, int i2, String str) {
        AlgorithmParameterSpec ivParameterSpec;
        if (bArr != null && bArr.length >= 16 && bArr2 != null && bArr2.length >= 12 && b.x()) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, f11841d);
                Cipher cipher = Cipher.getInstance(str);
                if (b.equals(str)) {
                    ivParameterSpec = b.w(bArr2);
                } else {
                    ivParameterSpec = new IvParameterSpec(bArr2);
                }
                cipher.init(i2, secretKeySpec, ivParameterSpec);
                return cipher;
            } catch (GeneralSecurityException e2) {
                g.d(a, "GCM encrypt data error" + e2.getMessage());
                return null;
            }
        }
        g.d(a, "gcm encrypt param is not right");
        return null;
    }

    private static Cipher d(byte[] bArr, byte[] bArr2, int i2) {
        return c(bArr, bArr2, i2, b);
    }

    public static Cipher e(byte[] bArr, Cipher cipher) {
        return f(bArr, cipher.getIV());
    }

    public static Cipher f(byte[] bArr, byte[] bArr2) {
        return b(bArr, bArr2, 2);
    }

    public static Cipher g(byte[] bArr) {
        return h(bArr, e.k.c.a.a.h.g.b.d(16));
    }

    public static Cipher h(byte[] bArr, byte[] bArr2) {
        return b(bArr, bArr2, 1);
    }

    public static int i(byte[] bArr, byte[] bArr2) {
        return j(bArr, bArr2, e.k.c.a.a.h.g.b.d(16));
    }

    public static int j(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(h(bArr2, bArr3), bArr);
    }

    public static Cipher k(byte[] bArr, Cipher cipher) {
        return l(bArr, cipher.getIV());
    }

    public static Cipher l(byte[] bArr, byte[] bArr2) {
        return d(bArr, bArr2, 2);
    }

    public static Cipher m(byte[] bArr) {
        byte[] d2 = e.k.c.a.a.h.g.b.d(12);
        g.b(a, "getEncryptCipher: iv is : " + e.k.c.a.a.h.g.c.b(d2));
        return n(bArr, d2);
    }

    public static Cipher n(byte[] bArr, byte[] bArr2) {
        return d(bArr, bArr2, 1);
    }

    public static int o(byte[] bArr, byte[] bArr2) {
        return p(bArr, bArr2, e.k.c.a.a.h.g.b.d(12));
    }

    public static int p(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(n(bArr2, bArr3), bArr);
    }

    public static int q(Cipher cipher, byte[] bArr, int i2, int i3, byte[] bArr2, int i4) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        if (cipher != null && bArr != null) {
            return cipher.doFinal(bArr, i2, i3, bArr2, i4);
        }
        g.d(a, "getEncryptCOntent: cipher is null or content is null");
        return -1;
    }

    public static int r(Cipher cipher, byte[] bArr, byte[] bArr2) {
        if (cipher != null && bArr != null) {
            try {
                return cipher.doFinal(bArr, 0, bArr.length, bArr2);
            } catch (BadPaddingException unused) {
                g.d(a, "getContent: BadPaddingException");
                return -1;
            } catch (IllegalBlockSizeException unused2) {
                g.d(a, "getContent: IllegalBlockSizeException");
                return -1;
            } catch (ShortBufferException unused3) {
                g.d(a, "getContent: ShortBufferException");
                return -1;
            }
        }
        g.d(a, "getEncryptCOntent: cipher is null or content is null");
        return -1;
    }

    public static byte[] s(Cipher cipher, byte[] bArr) {
        if (cipher != null && bArr != null) {
            try {
                return cipher.doFinal(bArr, 0, bArr.length);
            } catch (BadPaddingException unused) {
                g.d(a, "getContent: BadPaddingException");
                return new byte[0];
            } catch (IllegalBlockSizeException unused2) {
                g.d(a, "getContent: IllegalBlockSizeException");
                return new byte[0];
            }
        }
        g.d(a, "getEncryptCOntent: cipher is null or content is null");
        return new byte[0];
    }
}
