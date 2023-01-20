package e.k.c.a.a.h.e.a;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import e.k.c.a.a.h.g.c;
import e.k.c.a.a.h.g.g;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes2.dex */
public class b {
    private static final String a = "GCMKS";
    private static final String b = "AndroidKeyStore";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11865c = "AES/GCM/NoPadding";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11866d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final int f11867e = 12;

    /* renamed from: f  reason: collision with root package name */
    private static final int f11868f = 256;

    /* renamed from: g  reason: collision with root package name */
    private static Map<String, SecretKey> f11869g = new HashMap();

    private static SecretKey a(String str) {
        g.e(a, "load key");
        SecretKey secretKey = null;
        try {
            KeyStore keyStore = KeyStore.getInstance(b);
            keyStore.load(null);
            Key key = keyStore.getKey(str, null);
            if (key instanceof SecretKey) {
                secretKey = (SecretKey) key;
            } else {
                g.e(a, "generate key");
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", b);
                keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes(e.j.a.b.i.a.M).setEncryptionPaddings("NoPadding").setKeySize(256).build());
                secretKey = keyGenerator.generateKey();
            }
        } catch (IOException e2) {
            g.d(a, "IOException : " + e2.getMessage());
        } catch (InvalidAlgorithmParameterException e3) {
            g.d(a, "InvalidAlgorithmParameterException : " + e3.getMessage());
        } catch (KeyStoreException e4) {
            g.d(a, "KeyStoreException : " + e4.getMessage());
        } catch (NoSuchAlgorithmException e5) {
            g.d(a, "NoSuchAlgorithmException : " + e5.getMessage());
        } catch (NoSuchProviderException e6) {
            g.d(a, "NoSuchProviderException : " + e6.getMessage());
        } catch (UnrecoverableKeyException e7) {
            g.d(a, "UnrecoverableKeyException : " + e7.getMessage());
        } catch (CertificateException e8) {
            g.d(a, "CertificateException : " + e8.getMessage());
        } catch (Exception e9) {
            g.d(a, "Exception: " + e9.getMessage());
        }
        f11869g.put(str, secretKey);
        return secretKey;
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static SecretKey c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f11869g.get(str) == null) {
            a(str);
        }
        return f11869g.get(str);
    }

    public static String d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return new String(e(str, c.c(str2)), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                g.d(a, "decrypt: UnsupportedEncodingException : " + e2.getMessage());
                return "";
            }
        }
        g.d(a, "alias or encrypt content is null");
        return "";
    }

    public static byte[] e(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!b()) {
                g.d(a, "sdk version is too low");
                return bArr2;
            } else if (bArr.length <= 12) {
                g.d(a, "Decrypt source data is invalid.");
                return bArr2;
            } else {
                return f(c(str), bArr);
            }
        }
        g.d(a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] f(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (secretKey == null) {
            g.d(a, "Decrypt secret key is null");
            return bArr2;
        } else if (bArr == null) {
            g.d(a, "content is null");
            return bArr2;
        } else if (!b()) {
            g.d(a, "sdk version is too low");
            return bArr2;
        } else if (bArr.length <= 12) {
            g.d(a, "Decrypt source data is invalid.");
            return bArr2;
        } else {
            byte[] copyOf = Arrays.copyOf(bArr, 12);
            try {
                Cipher cipher = Cipher.getInstance(f11865c);
                cipher.init(2, secretKey, new GCMParameterSpec(128, copyOf));
                return cipher.doFinal(bArr, 12, bArr.length - 12);
            } catch (InvalidAlgorithmParameterException e2) {
                g.d(a, "InvalidAlgorithmParameterException : " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                g.d(a, "InvalidKeyException : " + e3.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e4) {
                g.d(a, "NoSuchAlgorithmException : " + e4.getMessage());
                return bArr2;
            } catch (BadPaddingException e5) {
                g.d(a, "BadPaddingException : " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                g.d(a, "IllegalBlockSizeException : " + e6.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e7) {
                g.d(a, "NoSuchPaddingException : " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                g.d(a, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
    }

    public static String g(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return c.b(h(str, str2.getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                g.d(a, "encrypt: UnsupportedEncodingException : " + e2.getMessage());
                return "";
            }
        }
        g.d(a, "alias or encrypt content is null");
        return "";
    }

    public static byte[] h(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!b()) {
                g.d(a, "sdk version is too low");
                return bArr2;
            }
            return i(c(str), bArr);
        }
        g.d(a, "alias or encrypt content is null");
        return bArr2;
    }

    public static byte[] i(SecretKey secretKey, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (bArr == null) {
            g.d(a, "content is null");
            return bArr2;
        } else if (secretKey == null) {
            g.d(a, "secret key is null");
            return bArr2;
        } else if (!b()) {
            g.d(a, "sdk version is too low");
            return bArr2;
        } else {
            try {
                Cipher cipher = Cipher.getInstance(f11865c);
                cipher.init(1, secretKey);
                byte[] doFinal = cipher.doFinal(bArr);
                byte[] iv = cipher.getIV();
                if (iv != null && iv.length == 12) {
                    byte[] copyOf = Arrays.copyOf(iv, iv.length + doFinal.length);
                    System.arraycopy(doFinal, 0, copyOf, iv.length, doFinal.length);
                    return copyOf;
                }
                g.d(a, "IV is invalid.");
                return bArr2;
            } catch (InvalidKeyException e2) {
                g.d(a, "InvalidKeyException : " + e2.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e3) {
                g.d(a, "NoSuchAlgorithmException : " + e3.getMessage());
                return bArr2;
            } catch (BadPaddingException e4) {
                g.d(a, "BadPaddingException : " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                g.d(a, "IllegalBlockSizeException : " + e5.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e6) {
                g.d(a, "NoSuchPaddingException : " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                g.d(a, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
    }
}
