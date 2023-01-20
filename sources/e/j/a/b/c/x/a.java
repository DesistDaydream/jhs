package e.j.a.b.c.x;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class a {
    private static volatile int a = -1;

    @e.j.a.b.c.m.a
    @TargetApi(24)
    @Deprecated
    public static Context a(Context context) {
        return e.j.a.b.f.b.g.b() ? e.j.a.b.f.b.g.a(context) : context;
    }

    @e.j.a.b.c.m.a
    public static byte[] b(Context context, String str) throws PackageManager.NameNotFoundException {
        MessageDigest c2;
        PackageInfo e2 = e.j.a.b.c.y.c.a(context).e(str, 64);
        Signature[] signatureArr = e2.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (c2 = c("SHA1")) == null) {
            return null;
        }
        return c2.digest(e2.signatures[0].toByteArray());
    }

    public static MessageDigest c(String str) {
        MessageDigest messageDigest;
        for (int i2 = 0; i2 < 2; i2++) {
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }
}
