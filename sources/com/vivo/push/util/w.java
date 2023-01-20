package com.vivo.push.util;

import android.content.Context;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes3.dex */
public final class w extends b {
    private static w b;

    public static synchronized w b() {
        w wVar;
        synchronized (w.class) {
            if (b == null) {
                b = new w();
            }
            wVar = b;
        }
        return wVar;
    }

    public final synchronized void a(Context context) {
        if (this.a == null) {
            this.a = context;
            a(context, "com.vivo.push_preferences");
        }
    }

    public final byte[] c() {
        byte[] c2 = c(b("com.vivo.push.secure_cache_iv", ""));
        return (c2 == null || c2.length <= 0) ? new byte[]{34, 32, 33, k.b.a.a.o.f.b, 33, 34, 32, 33, 33, 33, 34, 41, 35, 32, 32, 32} : c2;
    }

    public final byte[] d() {
        byte[] c2 = c(b("com.vivo.push.secure_cache_key", ""));
        return (c2 == null || c2.length <= 0) ? new byte[]{33, 34, 35, 36, k.b.a.a.o.f.b, 38, 39, 40, 41, 32, 38, k.b.a.a.o.f.b, 36, 35, 34, 33} : c2;
    }

    private static byte[] c(String str) {
        int i2;
        byte[] bArr = null;
        try {
            String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length > 0) {
                bArr = new byte[split.length];
                i2 = split.length;
            } else {
                i2 = 0;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = Byte.parseByte(split[i3].trim());
            }
        } catch (Exception e2) {
            p.a("SharePreferenceManager", "getCodeBytes error:" + e2.getMessage());
        }
        return bArr;
    }
}
