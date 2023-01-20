package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ik;
import com.xiaomi.push.iu;

/* loaded from: classes3.dex */
public class ib {
    public static short a(Context context, hn hnVar) {
        return a(context, hnVar.f8859f);
    }

    public static short a(Context context, String str) {
        return (short) (gg.a(context, str, false).a() + 0 + (l.b(context) ? 4 : 0) + (l.a(context) ? 8 : 0) + (com.xiaomi.push.service.z.a(context) ? 16 : 0));
    }

    public static <T extends ic<T, ?>> void a(T t, byte[] bArr) {
        if (bArr == null) {
            throw new ih("the message byte is empty.");
        }
        new ig(new iu.a(true, true, bArr.length)).a(t, bArr);
    }

    public static <T extends ic<T, ?>> byte[] a(T t) {
        if (t == null) {
            return null;
        }
        try {
            return new ij(new ik.a()).a(t);
        } catch (ih e2) {
            com.xiaomi.a.a.a.c.a("convertThriftObjectToBytes catch TException.", e2);
            return null;
        }
    }
}
