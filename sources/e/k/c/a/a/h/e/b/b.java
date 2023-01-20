package e.k.c.a.a.h.e.b;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import e.k.c.a.a.h.g.g;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableEntryException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

/* loaded from: classes2.dex */
public abstract class b {
    private static final String a = "RSASignKS";
    private static final String b = "AndroidKeyStore";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11874c = "SHA256withRSA/PSS";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11875d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final int f11876e = 2048;

    /* renamed from: f  reason: collision with root package name */
    private static final int f11877f = 3072;

    private static synchronized KeyPair a(String str, boolean z) {
        synchronized (b.class) {
            KeyPair keyPair = null;
            if (b(str)) {
                g.d(a, "Key pair exits");
                return null;
            }
            try {
                try {
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", b);
                    if (!z) {
                        keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests("SHA-256", "SHA-512").setSignaturePaddings("PSS").setKeySize(2048).build());
                    } else {
                        keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 12).setDigests("SHA-256", "SHA-512").setSignaturePaddings("PSS").setKeySize(f11877f).build());
                    }
                    keyPair = keyPairGenerator.generateKeyPair();
                } catch (InvalidAlgorithmParameterException e2) {
                    String str2 = a;
                    g.d(str2, "InvalidAlgorithmParameterException: " + e2.getMessage());
                } catch (NoSuchProviderException e3) {
                    String str3 = a;
                    g.d(str3, "NoSuchProviderException: " + e3.getMessage());
                }
            } catch (NoSuchAlgorithmException e4) {
                String str4 = a;
                g.d(str4, "NoSuchAlgorithmException: " + e4.getMessage());
            }
            return keyPair;
        }
    }

    private static boolean b(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(b);
            keyStore.load(null);
            return keyStore.getKey(str, null) != null;
        } catch (IOException e2) {
            String str2 = a;
            g.d(str2, "IOException: " + e2.getMessage());
            return false;
        } catch (KeyStoreException e3) {
            String str3 = a;
            g.d(str3, "KeyStoreException: " + e3.getMessage());
            return false;
        } catch (NoSuchAlgorithmException e4) {
            String str4 = a;
            g.d(str4, "NoSuchAlgorithmException: " + e4.getMessage());
            return false;
        } catch (UnrecoverableKeyException e5) {
            String str5 = a;
            g.d(str5, "UnrecoverableKeyException: " + e5.getMessage());
            return false;
        } catch (CertificateException e6) {
            String str6 = a;
            g.d(str6, "CertificateException: " + e6.getMessage());
            return false;
        }
    }

    private static boolean c(String str, byte[] bArr, byte[] bArr2, boolean z) {
        if (!TextUtils.isEmpty(str) && bArr != null && bArr2 != null) {
            if (!f()) {
                g.d(a, "sdk version is too low");
                return false;
            }
            KeyStore.Entry e2 = e(str, z);
            if (!(e2 instanceof KeyStore.PrivateKeyEntry)) {
                g.d(a, "Not an instance of a PrivateKeyEntry");
                return false;
            }
            try {
                Signature signature = Signature.getInstance(f11874c);
                signature.initVerify(((KeyStore.PrivateKeyEntry) e2).getCertificate());
                signature.update(bArr);
                return signature.verify(bArr2);
            } catch (InvalidKeyException e3) {
                String str2 = a;
                g.d(str2, "InvalidKeyException: " + e3.getMessage());
                return false;
            } catch (NoSuchAlgorithmException e4) {
                String str3 = a;
                g.d(str3, "NoSuchAlgorithmException: " + e4.getMessage());
                return false;
            } catch (SignatureException e5) {
                String str4 = a;
                g.d(str4, "SignatureException: " + e5.getMessage());
                return false;
            } catch (Exception e6) {
                String str5 = a;
                g.d(str5, "Exception: " + e6.getMessage());
                return false;
            }
        }
        g.d(a, "alias or content or sign value is null");
        return false;
    }

    private static byte[] d(String str, byte[] bArr, boolean z) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!f()) {
                g.d(a, "sdk version is too low");
                return bArr2;
            }
            KeyStore.Entry e2 = e(str, z);
            if (!(e2 instanceof KeyStore.PrivateKeyEntry)) {
                g.d(a, "Not an instance of a PrivateKeyEntry");
                return bArr2;
            }
            try {
                Signature signature = Signature.getInstance(f11874c);
                signature.initSign(((KeyStore.PrivateKeyEntry) e2).getPrivateKey());
                signature.update(bArr);
                return signature.sign();
            } catch (InvalidKeyException e3) {
                String str2 = a;
                g.d(str2, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e4) {
                String str3 = a;
                g.d(str3, "NoSuchAlgorithmException: " + e4.getMessage());
                return bArr2;
            } catch (SignatureException e5) {
                String str4 = a;
                g.d(str4, "SignatureException: " + e5.getMessage());
                return bArr2;
            } catch (Exception e6) {
                String str5 = a;
                g.d(str5, "Exception: " + e6.getMessage());
                return bArr2;
            }
        }
        g.d(a, "alias or content is null");
        return bArr2;
    }

    private static KeyStore.Entry e(String str, boolean z) {
        if (!b(str)) {
            a(str, z);
        }
        try {
            KeyStore keyStore = KeyStore.getInstance(b);
            keyStore.load(null);
            return keyStore.getEntry(str, null);
        } catch (IOException e2) {
            String str2 = a;
            g.d(str2, "IOException: " + e2.getMessage());
            return null;
        } catch (KeyStoreException e3) {
            String str3 = a;
            g.d(str3, "KeyStoreException: " + e3.getMessage());
            return null;
        } catch (NoSuchAlgorithmException e4) {
            String str4 = a;
            g.d(str4, "NoSuchAlgorithmException: " + e4.getMessage());
            return null;
        } catch (UnrecoverableEntryException e5) {
            String str5 = a;
            g.d(str5, "UnrecoverableEntryException: " + e5.getMessage());
            return null;
        } catch (CertificateException e6) {
            String str6 = a;
            g.d(str6, "CertificateException: " + e6.getMessage());
            return null;
        }
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @Deprecated
    public static String g(String str, String str2) {
        try {
            return Base64.encodeToString(h(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            String str3 = a;
            Log.e(str3, "sign UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    @Deprecated
    public static byte[] h(String str, byte[] bArr) {
        return d(str, bArr, false);
    }

    public static String i(String str, String str2) {
        try {
            return Base64.encodeToString(j(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            String str3 = a;
            Log.e(str3, "sign UnsupportedEncodingException : " + e2.getMessage());
            return "";
        }
    }

    public static byte[] j(String str, byte[] bArr) {
        return d(str, bArr, true);
    }

    @Deprecated
    public static boolean k(String str, String str2, String str3) {
        try {
            return l(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e2) {
            String str4 = a;
            Log.e(str4, "verifySign UnsupportedEncodingException: " + e2.getMessage());
            return false;
        } catch (Exception e3) {
            String str5 = a;
            g.d(str5, "base64 decode Exception" + e3.getMessage());
            return false;
        }
    }

    @Deprecated
    public static boolean l(String str, byte[] bArr, byte[] bArr2) {
        return c(str, bArr, bArr2, false);
    }

    public static boolean m(String str, String str2, String str3) {
        try {
            return n(str, str2.getBytes("UTF-8"), Base64.decode(str3, 0));
        } catch (UnsupportedEncodingException e2) {
            String str4 = a;
            Log.e(str4, "verifySign UnsupportedEncodingException: " + e2.getMessage());
            return false;
        } catch (Exception e3) {
            String str5 = a;
            g.d(str5, "base64 decode Exception" + e3.getMessage());
            return false;
        }
    }

    public static boolean n(String str, byte[] bArr, byte[] bArr2) {
        return c(str, bArr, bArr2, true);
    }
}
