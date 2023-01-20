package e.l.r;

import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* loaded from: classes2.dex */
public final class m0 {
    @k.e.a.d
    public static final m0 a = new m0();
    @k.e.a.d
    private static final String b = "RSA/ECB/PKCS1Padding";

    /* renamed from: c  reason: collision with root package name */
    private static final int f14289c = 117;

    /* renamed from: d  reason: collision with root package name */
    private static final int f14290d = 256;

    private m0() {
    }

    @k.e.a.d
    public final String a(@k.e.a.d String str, @k.e.a.d PrivateKey privateKey) {
        byte[] doFinal;
        byte[] decode = Base64.decode(str, 2);
        Cipher cipher = Cipher.getInstance(b);
        cipher.init(2, privateKey);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (decode.length - i2 > 0) {
            int length = decode.length - i2;
            int i3 = f14290d;
            if (length >= i3) {
                doFinal = cipher.doFinal(decode, i2, i3);
                i2 += i3;
            } else {
                doFinal = cipher.doFinal(decode, i2, decode.length - i2);
                i2 = decode.length;
            }
            byteArrayOutputStream.write(doFinal);
        }
        byteArrayOutputStream.close();
        return new String(byteArrayOutputStream.toByteArray(), h.t2.d.a);
    }

    @k.e.a.d
    public final String b(@k.e.a.d String str, @k.e.a.d PublicKey publicKey) {
        byte[] doFinal;
        byte[] decode = Base64.decode(str, 2);
        Cipher cipher = Cipher.getInstance(b);
        cipher.init(2, publicKey);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (decode.length - i2 > 0) {
            int length = decode.length - i2;
            int i3 = f14290d;
            if (length >= i3) {
                doFinal = cipher.doFinal(decode, i2, i3);
                i2 += i3;
            } else {
                doFinal = cipher.doFinal(decode, i2, decode.length - i2);
                i2 = decode.length;
            }
            byteArrayOutputStream.write(doFinal);
        }
        byteArrayOutputStream.close();
        return new String(byteArrayOutputStream.toByteArray(), h.t2.d.a);
    }

    @k.e.a.d
    public final String c(@k.e.a.d String str, @k.e.a.d PrivateKey privateKey) {
        byte[] bytes = str.getBytes(h.t2.d.a);
        Cipher cipher = Cipher.getInstance(b);
        cipher.init(1, privateKey);
        return Base64.encodeToString(cipher.doFinal(bytes), 2);
    }

    @k.e.a.d
    public final String d(@k.e.a.d String str, @k.e.a.e PublicKey publicKey) {
        byte[] bytes = str.getBytes(h.t2.d.a);
        Cipher cipher = Cipher.getInstance(b);
        cipher.init(1, publicKey);
        return Base64.encodeToString(cipher.doFinal(bytes), 2);
    }

    public final int e() {
        return f14290d;
    }

    public final int f() {
        return f14289c;
    }

    @k.e.a.e
    public final PrivateKey g(@k.e.a.d String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePrivate(new X509EncodedKeySpec(Base64.decode(h.t2.u.k2(h.t2.u.k2(h.t2.u.k2(str, "-----BEGIN PUBLIC KEY-----", "", false, 4, null), "-----END PUBLIC KEY-----", "", false, 4, null), "\n", "", false, 4, null), 2)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @k.e.a.e
    public final PublicKey h(@k.e.a.d String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(h.t2.u.k2(h.t2.u.k2(str, "-----BEGIN PUBLIC KEY-----", "", false, 4, null), "-----END PUBLIC KEY-----", "", false, 4, null), 2)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @k.e.a.d
    public final String i() {
        return b;
    }
}
