package e.l.r;

import android.util.Base64;
import com.qiniu.android.common.Constants;
import com.umeng.analytics.pro.cb;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.random.Random;

/* loaded from: classes2.dex */
public final class c0 {
    @k.e.a.d
    private final String a = Constants.UTF_8;
    @k.e.a.d
    private final String b = "8173258697451276";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final String f14266c = "AES/ECB/PKCS5Padding";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final String f14267d = o(16);
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final String f14268e = "HmacSHA256";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private final char[] f14269f = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private final String a(byte[] bArr) {
        int length;
        if (bArr != null && (length = bArr.length) > 0) {
            char[] cArr = new char[length << 1];
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                int i4 = i2 + 1;
                char[] cArr2 = this.f14269f;
                cArr[i2] = cArr2[(bArr[i3] >> 4) & 15];
                i2 = i4 + 1;
                cArr[i4] = cArr2[bArr[i3] & cb.f7124m];
            }
            return new String(cArr);
        }
        return "";
    }

    private final String i(byte[] bArr) {
        return a(m(bArr));
    }

    private final byte[] m(byte[] bArr) {
        return p(bArr, "MD5");
    }

    private final byte[] p(byte[] bArr, String str) {
        if (bArr != null) {
            if (bArr.length == 0) {
                return null;
            }
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(str);
                messageDigest.update(bArr);
                return messageDigest.digest();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @k.e.a.d
    public final byte[] b(@k.e.a.d byte[] bArr) {
        return Base64.decode(bArr, 2);
    }

    @k.e.a.d
    public final String c(@k.e.a.d byte[] bArr) {
        return new String(b(bArr), h.t2.d.a);
    }

    @k.e.a.d
    public final String d(@k.e.a.d String str) throws Exception {
        String str2 = this.f14267d;
        Charset charset = h.t2.d.a;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        return e(str, str2.getBytes(charset));
    }

    @k.e.a.d
    public final String e(@k.e.a.d String str, @k.e.a.d byte[] bArr) throws Exception {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            Cipher cipher = Cipher.getInstance(this.f14266c);
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(Base64.decode(str, 2)), h.t2.d.a);
        } catch (Exception unused) {
            return "";
        }
    }

    @k.e.a.d
    public final String f(@k.e.a.d String str) throws Exception {
        String str2 = this.f14267d;
        Charset charset = h.t2.d.a;
        Objects.requireNonNull(str2, "null cannot be cast to non-null type java.lang.String");
        return g(str, str2.getBytes(charset));
    }

    @k.e.a.d
    public final String g(@k.e.a.d String str, @k.e.a.d byte[] bArr) throws Exception {
        Cipher cipher = Cipher.getInstance(this.f14266c);
        cipher.init(1, new SecretKeySpec(bArr, "AES"));
        return Base64.encodeToString(cipher.doFinal(str.getBytes(Charset.forName(this.a))), 2);
    }

    @k.e.a.d
    public final String h(@k.e.a.e String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return i(str.getBytes(h.t2.d.a));
            }
        }
        return "";
    }

    @k.e.a.d
    public final byte[] j(@k.e.a.d byte[] bArr) {
        return Base64.encode(bArr, 2);
    }

    @k.e.a.d
    public final String k(@k.e.a.d byte[] bArr) {
        return Base64.encodeToString(bArr, 2);
    }

    @k.e.a.d
    public final String l(@k.e.a.d String str, @k.e.a.d String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(Charset.forName("UTF-8")), this.f14268e);
            Mac mac = Mac.getInstance(this.f14268e);
            mac.init(secretKeySpec);
            return a(mac.doFinal(str.getBytes(Charset.forName("UTF-8"))));
        } catch (Exception e2) {
            e.l.h.k.b.a.b("encodeSha256", String.valueOf(e2.getMessage()));
            return "";
        }
    }

    @k.e.a.d
    public final String n() {
        return this.f14267d;
    }

    @k.e.a.d
    public final String o(int i2) {
        StringBuilder sb = new StringBuilder();
        if (i2 > 0) {
            int i3 = 0;
            do {
                i3++;
                sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(Random.Default.nextInt(62)));
            } while (i3 < i2);
            return sb.toString();
        }
        return sb.toString();
    }
}
