package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.gq;
import com.xiaomi.push.ha;
import com.xiaomi.push.hn;
import com.xiaomi.push.hq;
import com.xiaomi.push.jc;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class s {
    private static volatile s a;

    /* renamed from: a  reason: collision with other field name */
    private final Context f55a;

    private s(Context context) {
        this.f55a = context.getApplicationContext();
    }

    private static s a(Context context) {
        if (a == null) {
            synchronized (s.class) {
                if (a == null) {
                    a = new s(context);
                }
            }
        }
        return a;
    }

    public static void a(Context context, hn hnVar) {
        a(context).a(hnVar, 0, true);
    }

    public static void a(Context context, hn hnVar, boolean z) {
        a(context).a(hnVar, 1, z);
    }

    private void a(hn hnVar, int i2, boolean z) {
        if (jc.a(this.f55a) || !jc.a() || hnVar == null || hnVar.a != gq.SendMessage || hnVar.m() == null || !z) {
            return;
        }
        com.xiaomi.a.a.a.c.a("click to start activity result:" + String.valueOf(i2));
        hq hqVar = new hq(hnVar.m().b(), false);
        hqVar.c(ha.SDK_START_ACTIVITY.ah);
        hqVar.b(hnVar.h());
        hqVar.d(hnVar.f8859f);
        HashMap hashMap = new HashMap();
        hqVar.f8869h = hashMap;
        hashMap.put("result", String.valueOf(i2));
        ao.a(this.f55a).a(hqVar, gq.Notification, false, false, null, true, hnVar.f8859f, hnVar.f8858e, true, false);
    }

    public static void b(Context context, hn hnVar, boolean z) {
        a(context).a(hnVar, 2, z);
    }

    public static void c(Context context, hn hnVar, boolean z) {
        a(context).a(hnVar, 3, z);
    }

    public static void d(Context context, hn hnVar, boolean z) {
        a(context).a(hnVar, 4, z);
    }

    public static void e(Context context, hn hnVar, boolean z) {
        s a2;
        int i2;
        b m74a = b.m74a(context);
        if (TextUtils.isEmpty(m74a.m82c()) || TextUtils.isEmpty(m74a.d())) {
            a2 = a(context);
            i2 = 6;
        } else {
            boolean m86f = m74a.m86f();
            a2 = a(context);
            i2 = m86f ? 7 : 5;
        }
        a2.a(hnVar, i2, z);
    }
}
