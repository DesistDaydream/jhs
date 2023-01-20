package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.gq;
import com.xiaomi.push.hf;
import com.xiaomi.push.hg;
import com.xiaomi.push.hh;
import com.xiaomi.push.hi;
import com.xiaomi.push.hm;
import com.xiaomi.push.hn;
import com.xiaomi.push.hq;
import com.xiaomi.push.hs;
import com.xiaomi.push.ht;
import com.xiaomi.push.hu;
import com.xiaomi.push.hw;
import com.xiaomi.push.hy;
import com.xiaomi.push.ia;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class ai {
    public static <T extends ic<T, ?>> hn a(Context context, T t, gq gqVar) {
        return a(context, t, gqVar, !gqVar.equals(gq.Registration), context.getPackageName(), b.m74a(context).m75a());
    }

    public static <T extends ic<T, ?>> hn a(Context context, T t, gq gqVar, boolean z, String str, String str2) {
        return a(context, t, gqVar, z, str, str2, true);
    }

    public static <T extends ic<T, ?>> hn a(Context context, T t, gq gqVar, boolean z, String str, String str2, boolean z2) {
        String str3;
        byte[] a = ib.a(t);
        if (a != null) {
            hn hnVar = new hn();
            if (z) {
                String d2 = b.m74a(context).d();
                if (TextUtils.isEmpty(d2)) {
                    str3 = "regSecret is empty, return null";
                } else {
                    try {
                        a = hh.b(com.xiaomi.push.ao.b(d2), a);
                    } catch (Exception unused) {
                        com.xiaomi.a.a.a.c.d("encryption error. ");
                    }
                }
            }
            hf hfVar = new hf();
            hfVar.a = 5L;
            hfVar.b = "fakeid";
            hnVar.a(hfVar);
            hnVar.a(ByteBuffer.wrap(a));
            hnVar.a(gqVar);
            hnVar.c(z2);
            hnVar.b(str);
            hnVar.a(z);
            hnVar.a(str2);
            return hnVar;
        }
        str3 = "invoke convertThriftObjectToBytes method, return null.";
        com.xiaomi.a.a.a.c.a(str3);
        return null;
    }

    public static ic a(Context context, hn hnVar) {
        byte[] f2;
        if (hnVar.c()) {
            byte[] a = i.a(context, hnVar, e.ASSEMBLE_PUSH_FCM);
            if (a == null) {
                a = com.xiaomi.push.ao.b(b.m74a(context).d());
            }
            try {
                f2 = hh.a(a, hnVar.f());
            } catch (Exception e2) {
                throw new u("the aes decrypt failed.", e2);
            }
        } else {
            f2 = hnVar.f();
        }
        ic a2 = a(hnVar.a(), hnVar.f8856c);
        if (a2 != null) {
            ib.a(a2, f2);
        }
        return a2;
    }

    private static ic a(gq gqVar, boolean z) {
        switch (aj.a[gqVar.ordinal()]) {
            case 1:
                return new hs();
            case 2:
                return new hy();
            case 3:
                return new hw();
            case 4:
                return new ia();
            case 5:
                return new hu();
            case 6:
                return new hg();
            case 7:
                return new hm();
            case 8:
                return new ht();
            case 9:
                if (z) {
                    return new hq();
                }
                hi hiVar = new hi();
                hiVar.a(true);
                return hiVar;
            case 10:
                return new hm();
            default:
                return null;
        }
    }

    public static <T extends ic<T, ?>> hn b(Context context, T t, gq gqVar, boolean z, String str, String str2) {
        return a(context, t, gqVar, z, str, str2, false);
    }
}
