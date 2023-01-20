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
import javax.crypto.spec.IvParameterSpec;

/* loaded from: classes2.dex */
public class a {
    private static final String a = "CBCKS";
    private static final String b = "AndroidKeyStore";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11860c = "AES/CBC/PKCS7Padding";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11861d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final int f11862e = 16;

    /* renamed from: f  reason: collision with root package name */
    private static final int f11863f = 256;

    /* renamed from: g  reason: collision with root package name */
    private static Map<String, SecretKey> f11864g = new HashMap();

    private static synchronized SecretKey a(String str) {
        SecretKey secretKey;
        synchronized (a.class) {
            g.e(a, "load key");
            secretKey = null;
            try {
                try {
                    try {
                        try {
                            try {
                                try {
                                    KeyStore keyStore = KeyStore.getInstance(b);
                                    keyStore.load(null);
                                    Key key = keyStore.getKey(str, null);
                                    if (key != null && (key instanceof SecretKey)) {
                                        secretKey = (SecretKey) key;
                                    } else {
                                        g.e(a, "generate key");
                                        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", b);
                                        keyGenerator.init(new KeyGenParameterSpec.Builder(str, 3).setBlockModes("CBC").setEncryptionPaddings("PKCS7Padding").setKeySize(256).build());
                                        secretKey = keyGenerator.generateKey();
                                    }
                                } catch (KeyStoreException e2) {
                                    g.d(a, "KeyStoreException: " + e2.getMessage());
                                } catch (NoSuchAlgorithmException e3) {
                                    g.d(a, "NoSuchAlgorithmException: " + e3.getMessage());
                                }
                            } catch (IOException e4) {
                                g.d(a, "IOException: " + e4.getMessage());
                            } catch (Exception e5) {
                                g.d(a, "Exception: " + e5.getMessage());
                            }
                        } catch (UnrecoverableKeyException e6) {
                            g.d(a, "UnrecoverableKeyException: " + e6.getMessage());
                        }
                    } catch (NoSuchProviderException e7) {
                        g.d(a, "NoSuchProviderException: " + e7.getMessage());
                    }
                } catch (InvalidAlgorithmParameterException e8) {
                    g.d(a, "InvalidAlgorithmParameterException: " + e8.getMessage());
                }
            } catch (CertificateException e9) {
                g.d(a, "CertificateException: " + e9.getMessage());
            }
            f11864g.put(str, secretKey);
        }
        return secretKey;
    }

    private static boolean b() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static SecretKey c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f11864g.get(str) == null) {
            a(str);
        }
        return f11864g.get(str);
    }

    public static String d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                return new String(e(str, c.c(str2)), "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                g.d(a, "encrypt: UnsupportedEncodingException");
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
            } else if (bArr.length <= 16) {
                g.d(a, "Decrypt source data is invalid.");
                return bArr2;
            } else {
                SecretKey c2 = c(str);
                if (c2 == null) {
                    g.d(a, "decrypt secret key is null");
                    return bArr2;
                }
                byte[] copyOf = Arrays.copyOf(bArr, 16);
                try {
                    Cipher cipher = Cipher.getInstance(f11860c);
                    cipher.init(2, c2, new IvParameterSpec(copyOf));
                    return cipher.doFinal(bArr, 16, bArr.length - 16);
                } catch (InvalidAlgorithmParameterException e2) {
                    g.d(a, "InvalidAlgorithmParameterException: " + e2.getMessage());
                    return bArr2;
                } catch (InvalidKeyException e3) {
                    g.d(a, "InvalidKeyException: " + e3.getMessage());
                    return bArr2;
                } catch (NoSuchAlgorithmException e4) {
                    g.d(a, "NoSuchAlgorithmException: " + e4.getMessage());
                    return bArr2;
                } catch (BadPaddingException e5) {
                    g.d(a, "BadPaddingException: " + e5.getMessage());
                    return bArr2;
                } catch (IllegalBlockSizeException e6) {
                    g.d(a, "IllegalBlockSizeException: " + e6.getMessage());
                    return bArr2;
                } catch (NoSuchPaddingException e7) {
                    g.d(a, "NoSuchPaddingException: " + e7.getMessage());
                    return bArr2;
                } catch (Exception e8) {
                    g.d(a, "Exception: " + e8.getMessage());
                    return bArr2;
                }
            }
        }
        g.d(a, "alias or encrypt content is null");
        return bArr2;
    }

    public static String f(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            g.d(a, "encrypt 1 content is null");
            return "";
        }
        try {
            return c.b(g(str, str2.getBytes("UTF-8")));
        } catch (UnsupportedEncodingException unused) {
            g.d(a, "encrypt: UnsupportedEncodingException");
            return "";
        }
    }

    public static byte[] g(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!b()) {
                g.d(a, "sdk version is too low");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance(f11860c);
                SecretKey c2 = c(str);
                if (c2 == null) {
                    g.d(a, "encrypt secret key is null");
                    return bArr2;
                }
                cipher.init(1, c2);
                byte[] doFinal = cipher.doFinal(bArr);
                byte[] iv = cipher.getIV();
                if (iv != null && iv.length == 16) {
                    byte[] copyOf = Arrays.copyOf(iv, iv.length + doFinal.length);
                    System.arraycopy(doFinal, 0, copyOf, iv.length, doFinal.length);
                    return copyOf;
                }
                g.d(a, "IV is invalid.");
                return bArr2;
            } catch (InvalidKeyException e2) {
                g.d(a, "InvalidKeyException: " + e2.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e3) {
                g.d(a, "NoSuchAlgorithmException: " + e3.getMessage());
                return bArr2;
            } catch (BadPaddingException e4) {
                g.d(a, "BadPaddingException: " + e4.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e5) {
                g.d(a, "IllegalBlockSizeException: " + e5.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e6) {
                g.d(a, "NoSuchPaddingException: " + e6.getMessage());
                return bArr2;
            } catch (Exception e7) {
                g.d(a, "Exception: " + e7.getMessage());
                return bArr2;
            }
        }
        g.d(a, "alias or encrypt content is null");
        return bArr2;
    }
}
