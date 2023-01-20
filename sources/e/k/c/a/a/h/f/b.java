package e.k.c.a.a.h.f;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import e.k.c.a.a.h.g.g;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.Arrays;
import org.conscrypt.EvpMdRef;

/* loaded from: classes2.dex */
public abstract class b {
    private static final String a = "SHA256WithRSA";
    private static final String b = "SHA256WithRSA/PSS";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11882c = "RSASign";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11883d = "UTF-8";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11884e = "";

    private static String a(String str, String str2, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            PrivateKey f2 = e.k.c.a.a.h.g.b.f(str2);
            if (z) {
                return g(str, f2);
            }
            return k(str, f2);
        }
        g.d(f11882c, "sign content or key is null");
        return "";
    }

    private static String b(String str, PrivateKey privateKey, boolean z) {
        try {
            return Base64.encodeToString(m(str.getBytes("UTF-8"), privateKey, z), 0);
        } catch (UnsupportedEncodingException e2) {
            String str2 = f11882c;
            g.d(str2, "sign UnsupportedEncodingException: " + e2.getMessage());
            return "";
        }
    }

    private static boolean c(String str, String str2, String str3, boolean z) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            RSAPublicKey g2 = e.k.c.a.a.h.g.b.g(str3);
            if (z) {
                return i(str, str2, g2);
            }
            return o(str, str2, g2);
        }
        g.d(f11882c, "content or public key or sign value is null");
        return false;
    }

    private static boolean d(String str, String str2, PublicKey publicKey, boolean z) {
        try {
            return q(str.getBytes("UTF-8"), Base64.decode(str2, 0), publicKey, z);
        } catch (UnsupportedEncodingException e2) {
            String str3 = f11882c;
            g.d(str3, "verifySign UnsupportedEncodingException: " + e2.getMessage());
            return false;
        } catch (Exception e3) {
            String str4 = f11882c;
            g.d(str4, "base64 decode Exception : " + e3.getMessage());
            return false;
        }
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static String f(String str, String str2) {
        if (!e()) {
            g.d(f11882c, "sdk version is too low");
            return "";
        }
        return a(str, str2, true);
    }

    public static String g(String str, PrivateKey privateKey) {
        if (!e()) {
            g.d(f11882c, "sdk version is too low");
            return "";
        }
        return b(str, privateKey, true);
    }

    public static boolean h(String str, String str2, String str3) {
        if (!e()) {
            g.d(f11882c, "sdk version is too low");
            return false;
        }
        return c(str, str2, str3, true);
    }

    public static boolean i(String str, String str2, PublicKey publicKey) {
        if (!e()) {
            g.d(f11882c, "sdk version is too low");
            return false;
        }
        return d(str, str2, publicKey, true);
    }

    @Deprecated
    public static String j(String str, String str2) {
        return a(str, str2, false);
    }

    @Deprecated
    public static String k(String str, PrivateKey privateKey) {
        return b(str, privateKey, false);
    }

    public static byte[] l(ByteBuffer byteBuffer, PrivateKey privateKey, boolean z) {
        Signature signature;
        byte[] bArr = new byte[0];
        if (byteBuffer != null && privateKey != null && a.h((RSAPrivateKey) privateKey)) {
            try {
                if (z) {
                    signature = Signature.getInstance(b);
                    signature.setParameter(new PSSParameterSpec("SHA-256", EvpMdRef.MGF1_ALGORITHM_NAME, MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(a);
                }
                signature.initSign(privateKey);
                signature.update(byteBuffer);
                bArr = signature.sign();
                String str = f11882c;
                g.e(str, "result is : " + Arrays.toString(bArr));
                return bArr;
            } catch (InvalidAlgorithmParameterException e2) {
                String str2 = f11882c;
                g.d(str2, "sign InvalidAlgorithmParameterException: " + e2.getMessage());
                return bArr;
            } catch (InvalidKeyException e3) {
                String str3 = f11882c;
                g.d(str3, "sign InvalidKeyException: " + e3.getMessage());
                return bArr;
            } catch (NoSuchAlgorithmException e4) {
                String str4 = f11882c;
                g.d(str4, "sign NoSuchAlgorithmException: " + e4.getMessage());
                return bArr;
            } catch (SignatureException e5) {
                String str5 = f11882c;
                g.d(str5, "sign SignatureException: " + e5.getMessage());
                return bArr;
            } catch (Exception e6) {
                String str6 = f11882c;
                g.d(str6, "sign Exception: " + e6.getMessage());
                return bArr;
            }
        }
        g.d(f11882c, "content or privateKey is null , or length is too short");
        return bArr;
    }

    public static byte[] m(byte[] bArr, PrivateKey privateKey, boolean z) {
        Signature signature;
        byte[] bArr2 = new byte[0];
        if (bArr != null && privateKey != null && a.h((RSAPrivateKey) privateKey)) {
            try {
                if (z) {
                    signature = Signature.getInstance(b);
                    signature.setParameter(new PSSParameterSpec("SHA-256", EvpMdRef.MGF1_ALGORITHM_NAME, MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(a);
                }
                signature.initSign(privateKey);
                signature.update(bArr);
                return signature.sign();
            } catch (InvalidAlgorithmParameterException e2) {
                String str = f11882c;
                g.d(str, "sign InvalidAlgorithmParameterException: " + e2.getMessage());
                return bArr2;
            } catch (InvalidKeyException e3) {
                String str2 = f11882c;
                g.d(str2, "sign InvalidKeyException: " + e3.getMessage());
                return bArr2;
            } catch (NoSuchAlgorithmException e4) {
                String str3 = f11882c;
                g.d(str3, "sign NoSuchAlgorithmException: " + e4.getMessage());
                return bArr2;
            } catch (SignatureException e5) {
                String str4 = f11882c;
                g.d(str4, "sign SignatureException: " + e5.getMessage());
                return bArr2;
            } catch (Exception e6) {
                String str5 = f11882c;
                g.d(str5, "sign Exception: " + e6.getMessage());
                return bArr2;
            }
        }
        g.d(f11882c, "content or privateKey is null , or length is too short");
        return bArr2;
    }

    @Deprecated
    public static boolean n(String str, String str2, String str3) {
        return c(str, str2, str3, false);
    }

    @Deprecated
    public static boolean o(String str, String str2, PublicKey publicKey) {
        return d(str, str2, publicKey, false);
    }

    public static boolean p(ByteBuffer byteBuffer, byte[] bArr, PublicKey publicKey, boolean z) {
        Signature signature;
        if (byteBuffer != null && publicKey != null && bArr != null && a.i((RSAPublicKey) publicKey)) {
            try {
                if (z) {
                    signature = Signature.getInstance(b);
                    signature.setParameter(new PSSParameterSpec("SHA-256", EvpMdRef.MGF1_ALGORITHM_NAME, MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(a);
                }
                signature.initVerify(publicKey);
                signature.update(byteBuffer);
                return signature.verify(bArr);
            } catch (GeneralSecurityException e2) {
                String str = f11882c;
                g.d(str, "check sign exception: " + e2.getMessage());
                return false;
            } catch (Exception e3) {
                String str2 = f11882c;
                g.d(str2, "exception : " + e3.getMessage());
                return false;
            }
        }
        g.d(f11882c, "content or publicKey is null , or length is too short");
        return false;
    }

    public static boolean q(byte[] bArr, byte[] bArr2, PublicKey publicKey, boolean z) {
        Signature signature;
        if (bArr != null && publicKey != null && bArr2 != null && a.i((RSAPublicKey) publicKey)) {
            try {
                if (z) {
                    signature = Signature.getInstance(b);
                    signature.setParameter(new PSSParameterSpec("SHA-256", EvpMdRef.MGF1_ALGORITHM_NAME, MGF1ParameterSpec.SHA256, 32, 1));
                } else {
                    signature = Signature.getInstance(a);
                }
                signature.initVerify(publicKey);
                signature.update(bArr);
                return signature.verify(bArr2);
            } catch (GeneralSecurityException e2) {
                String str = f11882c;
                g.d(str, "check sign exception: " + e2.getMessage());
                return false;
            } catch (Exception e3) {
                String str2 = f11882c;
                g.d(str2, "exception : " + e3.getMessage());
                return false;
            }
        }
        g.d(f11882c, "content or publicKey is null , or length is too short");
        return false;
    }
}
