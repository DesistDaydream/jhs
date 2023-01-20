package com.vivo.push.c;

import android.content.Context;
import android.os.Build;
import android.security.KeyPairGeneratorSpec;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.util.p;
import java.math.BigInteger;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Calendar;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes3.dex */
public final class e implements b {
    private static PrivateKey a;
    private static PublicKey b;

    /* renamed from: c  reason: collision with root package name */
    private static KeyStore f8102c;

    /* renamed from: d  reason: collision with root package name */
    private static X500Principal f8103d;

    /* renamed from: e  reason: collision with root package name */
    private Context f8104e;

    public e(Context context) {
        this.f8104e = context;
        try {
            b();
            a(context);
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "init error" + e2.getMessage());
        }
    }

    private static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (f8102c == null) {
                b();
            }
            return f8102c.containsAlias(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
            return false;
        }
    }

    @Override // com.vivo.push.c.b
    public final String a(String str) {
        try {
            if (TextUtils.isEmpty(str) || b(this.f8104e) == null) {
                return null;
            }
            byte[] bytes = str.getBytes("UTF-8");
            PrivateKey b2 = b(this.f8104e);
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(b2);
            signature.update(bytes);
            String encodeToString = Base64.encodeToString(signature.sign(), 2);
            p.d("RsaSecurity", str.hashCode() + " = " + encodeToString);
            return encodeToString;
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "signClientSDK error" + e2.getMessage());
            return null;
        }
    }

    private static void b() {
        try {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            f8102c = keyStore;
            keyStore.load(null);
            f8103d = new X500Principal("CN=Push SDK, OU=VIVO, O=VIVO PUSH, C=CN");
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "initKeyStore error" + e2.getMessage());
        }
    }

    @Override // com.vivo.push.c.b
    public final boolean a(byte[] bArr, PublicKey publicKey, byte[] bArr2) {
        try {
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(bArr);
            return signature.verify(bArr2);
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "verifyClientSDK error" + e2.getMessage());
            return false;
        }
    }

    private static PrivateKey b(Context context) {
        PrivateKey privateKey;
        try {
            privateKey = a;
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "getPrivateKeySigin error" + e2.getMessage());
        }
        if (privateKey != null) {
            return privateKey;
        }
        if (context == null) {
            p.d("RsaSecurity", " getPrivateKeySigin context == null ");
            return null;
        }
        if (!b("PushRsaKeyAlias")) {
            a(context);
        }
        KeyStore.Entry entry = f8102c.getEntry("PushRsaKeyAlias", null);
        if (entry instanceof KeyStore.PrivateKeyEntry) {
            PrivateKey privateKey2 = ((KeyStore.PrivateKeyEntry) entry).getPrivateKey();
            a = privateKey2;
            return privateKey2;
        }
        return null;
    }

    private static void a(Context context) {
        try {
            if (context == null) {
                p.d("RsaSecurity", " generateRSAKeyPairSign context == null ");
            } else if (!b("PushRsaKeyAlias")) {
                Calendar calendar = Calendar.getInstance();
                Calendar calendar2 = Calendar.getInstance();
                calendar2.add(1, 999);
                if (Build.VERSION.SDK_INT >= 18) {
                    KeyPairGeneratorSpec build = new KeyPairGeneratorSpec.Builder(context.getApplicationContext()).setAlias("PushRsaKeyAlias").setSubject(f8103d).setSerialNumber(BigInteger.valueOf(1337L)).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
                    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", "AndroidKeyStore");
                    keyPairGenerator.initialize(build);
                    keyPairGenerator.generateKeyPair();
                }
            } else {
                p.d("RsaSecurity", " generateRSAKeyPairSign this keyAlias PushRsaKeyAlias is Created ");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "generateRSAKeyPairSign error" + e2.getMessage());
        }
    }

    @Override // com.vivo.push.c.b
    public final PublicKey a() {
        PublicKey publicKey;
        try {
            publicKey = b;
        } catch (Exception e2) {
            e2.printStackTrace();
            p.a("RsaSecurity", "getPublicKeySign error" + e2.getMessage());
        }
        if (publicKey != null) {
            return publicKey;
        }
        if (!b("PushRsaKeyAlias")) {
            a(this.f8104e);
        }
        KeyStore.Entry entry = f8102c.getEntry("PushRsaKeyAlias", null);
        if (entry instanceof KeyStore.PrivateKeyEntry) {
            PublicKey publicKey2 = ((KeyStore.PrivateKeyEntry) entry).getCertificate().getPublicKey();
            b = publicKey2;
            return publicKey2;
        }
        return null;
    }
}
