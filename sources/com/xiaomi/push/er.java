package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.eu;

/* loaded from: classes3.dex */
public class er {
    private static final boolean a = Log.isLoggable("BCompressed", 3);

    public static byte[] a(eq eqVar, byte[] bArr) {
        try {
            byte[] a2 = eu.a.a(bArr);
            if (a) {
                com.xiaomi.a.a.a.c.a("BCompressed", "decompress " + bArr.length + " to " + a2.length + " for " + eqVar);
                if (eqVar.b == 1) {
                    com.xiaomi.a.a.a.c.a("BCompressed", "decompress not support upStream");
                }
            }
            return a2;
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("BCompressed", "decompress error " + e2);
            return bArr;
        }
    }
}
