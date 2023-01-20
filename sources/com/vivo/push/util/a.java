package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import com.qiniu.android.common.Constants;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f8154c;
    private byte[] a;
    private byte[] b;

    private a(Context context) {
        w.b().a(ContextDelegate.getContext(context));
        w b = w.b();
        this.a = b.c();
        this.b = b.d();
    }

    public static a a(Context context) {
        if (f8154c == null) {
            synchronized (a.class) {
                if (f8154c == null) {
                    f8154c = new a(context.getApplicationContext());
                }
            }
        }
        return f8154c;
    }

    public final String b(String str) {
        return new String(f.a(f.a(a()), f.a(b()), Base64.decode(str, 2)), Constants.UTF_8);
    }

    private byte[] b() {
        byte[] bArr = this.b;
        return (bArr == null || bArr.length <= 0) ? w.b().d() : bArr;
    }

    public final String a(String str) {
        String a = f.a(a());
        String a2 = f.a(b());
        byte[] bytes = str.getBytes(Constants.UTF_8);
        SecretKeySpec secretKeySpec = new SecretKeySpec(a2.getBytes(Constants.UTF_8), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(a.getBytes(Constants.UTF_8)));
        return Base64.encodeToString(cipher.doFinal(bytes), 2);
    }

    private byte[] a() {
        byte[] bArr = this.a;
        return (bArr == null || bArr.length <= 0) ? w.b().c() : bArr;
    }
}
