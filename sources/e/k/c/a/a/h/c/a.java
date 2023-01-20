package e.k.c.a.a.h.c;

import android.text.TextUtils;
import e.k.c.a.a.h.g.g;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class a {
    private static final String a = "security:";
    private static final String b = "AES/CBC/PKCS5Padding";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11829c = "AES";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11830d = "CBC";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11831e = "";

    /* renamed from: f  reason: collision with root package name */
    private static final int f11832f = 16;

    /* renamed from: g  reason: collision with root package name */
    private static final int f11833g = 16;

    private a() {
    }

    private static int a(byte[] bArr) {
        return bArr[16] == 58 ? 16 : -1;
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + str.substring(12, 16) + str.substring(26, 32) + str.substring(48);
        } catch (Exception e2) {
            g.d(f11830d, "get encryptword exception : " + e2.getMessage());
            return "";
        }
    }

    private static String c(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return str2.substring(0, 6) + str.substring(0, 6) + str2.substring(6, 10) + str.substring(6, 16) + str2.substring(10, 16) + str.substring(16) + str2.substring(16);
            } catch (Exception e2) {
                g.d(f11830d, "mix exception: " + e2.getMessage());
            }
        }
        return "";
    }

    private static byte[] d(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f11830d, "encrypt 5 content is null");
            return new byte[0];
        } else if (bArr == null) {
            g.d(f11830d, "encrypt 5 key is null");
            return new byte[0];
        } else if (bArr.length < 16) {
            g.d(f11830d, "encrypt 5 key lengh is not right");
            return new byte[0];
        } else if (bArr2 == null) {
            g.d(f11830d, "encrypt 5 iv is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            g.d(f11830d, "encrypt 5 iv lengh is not right");
            return new byte[0];
        } else {
            try {
                return y(str.getBytes("UTF-8"), bArr, bArr2);
            } catch (UnsupportedEncodingException e2) {
                g.d(f11830d, " cbc encrypt data error" + e2.getMessage());
                return new byte[0];
            }
        }
    }

    private static byte[] e(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    private static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(6, 12) + str.substring(16, 26) + str.substring(32, 48);
        } catch (Exception e2) {
            g.d(f11830d, "getIv exception : " + e2.getMessage());
            return "";
        }
    }

    private static byte[] g(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length - 16];
        System.arraycopy(bArr, 16, bArr2, 0, bArr.length - 16);
        return bArr2;
    }

    public static String h(String str) {
        return (TextUtils.isEmpty(str) || str.indexOf(a) == -1) ? "" : str.substring(9);
    }

    private static byte[] i(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 0, bArr2, 0, 16);
        return bArr2;
    }

    public static byte[] j(byte[] bArr) {
        String str;
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            g.d(f11830d, "stripCryptHead: exception : " + e2.getMessage());
            str = "";
        }
        if (str.startsWith(a)) {
            if (bArr.length > 9) {
                int length = bArr.length - 9;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 9, bArr2, 0, length);
                return bArr2;
            }
            return new byte[0];
        }
        return new byte[0];
    }

    public static String k(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f11830d, "decrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            g.d(f11830d, "decrypt 1 key is null");
            return "";
        } else {
            byte[] c2 = e.k.c.a.a.h.g.c.c(str2);
            if (c2.length < 16) {
                g.d(f11830d, "decrypt 1 key length is not right");
                return "";
            }
            return m(str, c2);
        }
    }

    public static String l(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            g.d(f11830d, "decrypt 3 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            g.d(f11830d, "decrypt 3 key is null");
            return "";
        } else if (TextUtils.isEmpty(str3)) {
            g.d(f11830d, "decrypt 3 iv is null");
            return "";
        } else {
            byte[] c2 = e.k.c.a.a.h.g.c.c(str2);
            byte[] c3 = e.k.c.a.a.h.g.c.c(str3);
            if (c2.length < 16) {
                g.d(f11830d, "decrypt 3 key length is not right");
                return "";
            } else if (c3.length < 16) {
                g.d(f11830d, "decrypt 3 iv length is not right");
                return "";
            } else {
                return n(str, c2, c3);
            }
        }
    }

    public static String m(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            g.d(f11830d, "decrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            g.d(f11830d, "decrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            g.d(f11830d, "decrypt 2 key lengh is not right");
            return "";
        } else {
            String f2 = f(str);
            String b2 = b(str);
            if (TextUtils.isEmpty(f2)) {
                g.d(f11830d, "decrypt 2 iv is null");
                return "";
            } else if (TextUtils.isEmpty(b2)) {
                g.d(f11830d, "decrypt 2 encrypt content is null");
                return "";
            } else {
                return n(b2, bArr, e.k.c.a.a.h.g.c.c(f2));
            }
        }
    }

    public static String n(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f11830d, "decrypt 4 content is null");
            return "";
        } else if (bArr == null) {
            g.d(f11830d, "decrypt 4 key is null");
            return "";
        } else if (bArr.length < 16) {
            g.d(f11830d, "decrypt 4 key lengh is not right");
            return "";
        } else if (bArr2 == null) {
            g.d(f11830d, "decrypt 4 iv is null");
            return "";
        } else if (bArr2.length < 16) {
            g.d(f11830d, "decrypt 4 iv lengh is not right");
            return "";
        } else {
            try {
                return new String(p(e.k.c.a.a.h.g.c.c(str), bArr, bArr2), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                g.d(f11830d, " cbc decrypt data error" + e2.getMessage());
                return "";
            }
        }
    }

    public static byte[] o(byte[] bArr, byte[] bArr2) {
        return p(g(bArr), bArr2, i(bArr));
    }

    public static byte[] p(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            g.d(f11830d, "decrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            g.d(f11830d, "decrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            g.d(f11830d, "decrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            g.d(f11830d, "decrypt 6 key length is error");
            return new byte[0];
        } else if (bArr3 == null) {
            g.d(f11830d, "decrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 16) {
            g.d(f11830d, "decrypt 6 iv length is error");
            return new byte[0];
        } else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f11829c);
            try {
                Cipher cipher = Cipher.getInstance(b);
                cipher.init(2, secretKeySpec, new IvParameterSpec(bArr3));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e2) {
                g.d(f11830d, "InvalidAlgorithmParameterException: " + e2.getMessage());
                return new byte[0];
            } catch (InvalidKeyException e3) {
                g.d(f11830d, "InvalidKeyException: " + e3.getMessage());
                return new byte[0];
            } catch (NoSuchAlgorithmException e4) {
                g.d(f11830d, "NoSuchAlgorithmException: " + e4.getMessage());
                return new byte[0];
            } catch (BadPaddingException e5) {
                g.d(f11830d, "BadPaddingException: " + e5.getMessage());
                g.d(f11830d, "key is not right");
                return new byte[0];
            } catch (IllegalBlockSizeException e6) {
                g.d(f11830d, "IllegalBlockSizeException: " + e6.getMessage());
                return new byte[0];
            } catch (NoSuchPaddingException e7) {
                g.d(f11830d, "NoSuchPaddingException: " + e7.getMessage());
                return new byte[0];
            }
        }
    }

    public static String q(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr.length >= 16) {
            String h2 = h(str);
            if ("".equals(h2)) {
                return "";
            }
            int indexOf = h2.indexOf(58);
            if (indexOf >= 0) {
                return n(e.k.c.a.a.h.g.c.b(e.k.c.a.a.h.g.c.c(h2.substring(indexOf + 1))), bArr, e.k.c.a.a.h.g.c.c(h2.substring(0, indexOf)));
            }
            g.d(f11830d, " cbc cipherText data missing colon");
        }
        return "";
    }

    public static String r(byte[] bArr, byte[] bArr2) {
        try {
            return new String(s(bArr, bArr2), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            g.d(f11830d, "decryptWithCryptHead UnsupportedEncodingException ");
            return "";
        }
    }

    public static byte[] s(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr2.length < 16) {
            return new byte[0];
        }
        byte[] j2 = j(bArr);
        if (j2.length == 0) {
            return new byte[0];
        }
        int a2 = a(j2);
        if (a2 >= 0) {
            byte[] copyOf = Arrays.copyOf(j2, a2);
            int length = (j2.length - copyOf.length) - 1;
            byte[] bArr3 = new byte[length];
            System.arraycopy(j2, a2 + 1, bArr3, 0, length);
            return p(bArr3, bArr2, copyOf);
        }
        g.d(f11830d, " cbc cipherText data missing colon");
        return new byte[0];
    }

    public static String t(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f11830d, "encrypt 1 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            g.d(f11830d, "encrypt 1 key is null");
            return "";
        } else {
            byte[] c2 = e.k.c.a.a.h.g.c.c(str2);
            if (c2.length < 16) {
                g.d(f11830d, "encrypt 1 key length is not right");
                return "";
            }
            return v(str, c2);
        }
    }

    public static String u(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            g.d(f11830d, "encrypt 3 content is null");
            return "";
        } else if (TextUtils.isEmpty(str2)) {
            g.d(f11830d, "encrypt 3 key is null");
            return "";
        } else if (TextUtils.isEmpty(str3)) {
            g.d(f11830d, "encrypt 3 iv is null");
            return "";
        } else {
            byte[] c2 = e.k.c.a.a.h.g.c.c(str2);
            byte[] c3 = e.k.c.a.a.h.g.c.c(str3);
            if (c2.length < 16) {
                g.d(f11830d, "encrypt 3 key length is not right");
                return "";
            } else if (c3.length < 16) {
                g.d(f11830d, "encrypt 3 iv length is not right");
                return "";
            } else {
                return w(str, c2, c3);
            }
        }
    }

    public static String v(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            g.d(f11830d, "encrypt 2 content is null");
            return "";
        } else if (bArr == null) {
            g.d(f11830d, "encrypt 2 key is null");
            return "";
        } else if (bArr.length < 16) {
            g.d(f11830d, "encrypt 2 key lengh is not right");
            return "";
        } else {
            byte[] d2 = e.k.c.a.a.h.g.b.d(16);
            byte[] d3 = d(str, bArr, d2);
            return (d3 == null || d3.length == 0) ? "" : c(e.k.c.a.a.h.g.c.b(d2), e.k.c.a.a.h.g.c.b(d3));
        }
    }

    public static String w(String str, byte[] bArr, byte[] bArr2) {
        if (TextUtils.isEmpty(str)) {
            g.d(f11830d, "encrypt 4 content is null");
            return "";
        } else if (bArr == null) {
            g.d(f11830d, "encrypt 4 key is null");
            return "";
        } else if (bArr.length < 16) {
            g.d(f11830d, "encrypt 4 key lengh is not right");
            return "";
        } else if (bArr2 == null) {
            g.d(f11830d, "encrypt 4 iv is null");
            return "";
        } else if (bArr2.length < 16) {
            g.d(f11830d, "encrypt 4 iv lengh is not right");
            return "";
        } else {
            return e.k.c.a.a.h.g.c.b(d(str, bArr, bArr2));
        }
    }

    public static byte[] x(byte[] bArr, byte[] bArr2) {
        byte[] d2 = e.k.c.a.a.h.g.b.d(16);
        return e(d2, y(bArr, bArr2, d2));
    }

    public static byte[] y(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            g.d(f11830d, "encrypt 6 content is null");
            return new byte[0];
        } else if (bArr.length == 0) {
            g.d(f11830d, "encrypt 6 content length is 0");
            return new byte[0];
        } else if (bArr2 == null) {
            g.d(f11830d, "encrypt 6 key is null");
            return new byte[0];
        } else if (bArr2.length < 16) {
            g.d(f11830d, "encrypt 6 key length is error");
            return new byte[0];
        } else if (bArr3 == null) {
            g.d(f11830d, "encrypt 6 iv is null");
            return new byte[0];
        } else if (bArr3.length < 16) {
            g.d(f11830d, "encrypt 6 iv length is error");
            return new byte[0];
        } else {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, f11829c);
            try {
                Cipher cipher = Cipher.getInstance(b);
                cipher.init(1, secretKeySpec, new IvParameterSpec(bArr3));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e2) {
                g.d(f11830d, "InvalidAlgorithmParameterException: " + e2.getMessage());
                return new byte[0];
            } catch (InvalidKeyException e3) {
                g.d(f11830d, "InvalidKeyException: " + e3.getMessage());
                return new byte[0];
            } catch (NoSuchAlgorithmException e4) {
                g.d(f11830d, "NoSuchAlgorithmException: " + e4.getMessage());
                return new byte[0];
            } catch (BadPaddingException e5) {
                g.d(f11830d, "BadPaddingException: " + e5.getMessage());
                return new byte[0];
            } catch (IllegalBlockSizeException e6) {
                g.d(f11830d, "IllegalBlockSizeException: " + e6.getMessage());
                return new byte[0];
            } catch (NoSuchPaddingException e7) {
                g.d(f11830d, "NoSuchPaddingException: " + e7.getMessage());
                return new byte[0];
            }
        }
    }
}
