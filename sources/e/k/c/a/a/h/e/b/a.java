package e.k.c.a.a.h.e.b;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.text.TextUtils;
import android.util.Base64;
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
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.spec.MGF1ParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import org.conscrypt.EvpMdRef;

/* loaded from: classes2.dex */
public abstract class a {
    private static final String a = "RSAEncryptKS";
    private static final String b = "AndroidKeyStore";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11870c = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11871d = "";

    /* renamed from: e  reason: collision with root package name */
    private static final int f11872e = 2048;

    /* renamed from: f  reason: collision with root package name */
    private static final int f11873f = 3072;

    private static synchronized KeyPair a(String str, boolean z) {
        synchronized (a.class) {
            KeyPair keyPair = null;
            if (f(str)) {
                g.d(a, "Key pair exits");
                return null;
            }
            g.e(a, "generate key pair.");
            try {
                try {
                    try {
                        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", b);
                        if (!z) {
                            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("OAEPPadding").setKeySize(2048).build());
                        } else {
                            keyPairGenerator.initialize(new KeyGenParameterSpec.Builder(str, 2).setDigests("SHA-256", "SHA-512").setEncryptionPaddings("OAEPPadding").setKeySize(f11873f).build());
                        }
                        keyPair = keyPairGenerator.generateKeyPair();
                    } catch (NoSuchProviderException e2) {
                        String str2 = a;
                        g.d(str2, "NoSuchProviderException: " + e2.getMessage());
                    } catch (Exception e3) {
                        String str3 = a;
                        g.d(str3, "Exception: " + e3.getMessage());
                    }
                } catch (InvalidAlgorithmParameterException e4) {
                    String str4 = a;
                    g.d(str4, "InvalidAlgorithmParameterException: " + e4.getMessage());
                }
            } catch (NoSuchAlgorithmException e5) {
                String str5 = a;
                g.d(str5, "NoSuchAlgorithmException: " + e5.getMessage());
            }
            return keyPair;
        }
    }

    private static PrivateKey b(String str) {
        if (f(str)) {
            try {
                KeyStore keyStore = KeyStore.getInstance(b);
                keyStore.load(null);
                return (PrivateKey) keyStore.getKey(str, null);
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
            } catch (UnrecoverableKeyException e5) {
                String str5 = a;
                g.d(str5, "UnrecoverableKeyException: " + e5.getMessage());
                return null;
            } catch (CertificateException e6) {
                String str6 = a;
                g.d(str6, "CertificateException: " + e6.getMessage());
                return null;
            } catch (Exception e7) {
                String str7 = a;
                g.d(str7, "Exception: " + e7.getMessage());
                return null;
            }
        }
        return null;
    }

    private static boolean c() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private static byte[] d(String str, byte[] bArr, boolean z) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!c()) {
                g.d(a, "sdk version is too low");
                return bArr2;
            }
            PublicKey e2 = e(str, z);
            if (e2 == null) {
                g.d(a, "Public key is null");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance(f11870c);
                cipher.init(1, e2, new OAEPParameterSpec("SHA-256", EvpMdRef.MGF1_ALGORITHM_NAME, new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e3) {
                String str2 = a;
                g.d(str2, "InvalidAlgorithmParameterException: " + e3.getMessage());
                return bArr2;
            } catch (InvalidKeyException e4) {
                String str3 = a;
                g.d(str3, "InvalidKeyException: " + e4.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e5) {
                String str4 = a;
                g.d(str4, "NoSuchAlgorithmException: " + e5.getMessage());
                return bArr2;
            } catch (BadPaddingException e6) {
                String str5 = a;
                g.d(str5, "BadPaddingException: " + e6.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e7) {
                String str6 = a;
                g.d(str6, "IllegalBlockSizeException: " + e7.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e8) {
                String str7 = a;
                g.d(str7, "NoSuchPaddingException: " + e8.getMessage());
                return bArr2;
            } catch (Exception e9) {
                String str8 = a;
                g.d(str8, "Exception: " + e9.getMessage());
                return bArr2;
            }
        }
        g.d(a, "alias or content is null");
        return bArr2;
    }

    private static PublicKey e(String str, boolean z) {
        if (!f(str)) {
            a(str, z);
        }
        Certificate g2 = g(str);
        if (g2 != null) {
            return g2.getPublicKey();
        }
        return null;
    }

    private static boolean f(String str) {
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
        } catch (Exception e7) {
            String str7 = a;
            g.d(str7, "Exception: " + e7.getMessage());
            return false;
        }
    }

    private static Certificate g(String str) {
        try {
            KeyStore keyStore = KeyStore.getInstance(b);
            keyStore.load(null);
            return keyStore.getCertificate(str);
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
        } catch (CertificateException e5) {
            String str5 = a;
            g.d(str5, "CertificateException: " + e5.getMessage());
            return null;
        } catch (Exception e6) {
            String str6 = a;
            g.d(str6, "Exception: " + e6.getMessage());
            return null;
        }
    }

    @Deprecated
    public static String h(String str, String str2) {
        try {
            return new String(i(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            String str3 = a;
            g.d(str3, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        } catch (Exception e3) {
            String str4 = a;
            g.d(str4, "Exception: " + e3.getMessage());
            return "";
        }
    }

    @Deprecated
    public static byte[] i(String str, byte[] bArr) {
        byte[] bArr2 = new byte[0];
        if (!TextUtils.isEmpty(str) && bArr != null) {
            if (!c()) {
                g.d(a, "sdk version is too low");
                return bArr2;
            }
            PrivateKey b2 = b(str);
            if (b2 == null) {
                g.d(a, "Private key is null");
                return bArr2;
            }
            try {
                Cipher cipher = Cipher.getInstance(f11870c);
                cipher.init(2, b2, new OAEPParameterSpec("SHA-256", EvpMdRef.MGF1_ALGORITHM_NAME, new MGF1ParameterSpec("SHA-1"), PSource.PSpecified.DEFAULT));
                return cipher.doFinal(bArr);
            } catch (InvalidAlgorithmParameterException e2) {
                String str2 = a;
                g.d(str2, "InvalidAlgorithmParameterException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                String str3 = a;
                g.d(str3, "InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e4) {
                String str4 = a;
                g.d(str4, "NoSuchAlgorithmException: " + e4.getMessage());
                return bArr2;
            } catch (BadPaddingException e5) {
                String str5 = a;
                g.d(str5, "BadPaddingException: " + e5.getMessage());
                return bArr2;
            } catch (IllegalBlockSizeException e6) {
                String str6 = a;
                g.d(str6, "IllegalBlockSizeException: " + e6.getMessage());
                return bArr2;
            } catch (NoSuchPaddingException e7) {
                String str7 = a;
                g.d(str7, "NoSuchPaddingException: " + e7.getMessage());
                return bArr2;
            } catch (Exception e8) {
                String str8 = a;
                g.d(str8, "Exception: " + e8.getMessage());
                return bArr2;
            }
        }
        g.d(a, "alias or encrypted content is null");
        return bArr2;
    }

    public static String j(String str, String str2) {
        try {
            return new String(k(str, Base64.decode(str2, 0)), "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            String str3 = a;
            g.d(str3, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        } catch (Exception e3) {
            String str4 = a;
            g.d(str4, "Exception: " + e3.getMessage());
            return "";
        }
    }

    public static byte[] k(String str, byte[] bArr) {
        return i(str, bArr);
    }

    @Deprecated
    public static String l(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(m(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            String str3 = a;
            g.d(str3, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        }
    }

    @Deprecated
    public static byte[] m(String str, byte[] bArr) {
        return d(str, bArr, false);
    }

    public static String n(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            return Base64.encodeToString(o(str, str2.getBytes("UTF-8")), 0);
        } catch (UnsupportedEncodingException e2) {
            String str3 = a;
            g.d(str3, "UnsupportedEncodingException: " + e2.getMessage());
            return "";
        }
    }

    public static byte[] o(String str, byte[] bArr) {
        return d(str, bArr, true);
    }
}
