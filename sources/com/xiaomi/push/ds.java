package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qq.e.comm.constants.ErrorCode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class ds {
    private static a a;
    private static Map<String, ha> b;

    /* loaded from: classes3.dex */
    public interface a {
        void uploader(Context context, gu guVar);
    }

    public static int a(Enum r1) {
        if (r1 != null) {
            if (r1 instanceof gq) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof ha) {
                return r1.ordinal() + ErrorCode.INIT_ERROR;
            }
            if (r1 instanceof ec) {
                return r1.ordinal() + ErrorCode.NETWORK_ERROR;
            }
        }
        return -1;
    }

    public static com.xiaomi.b.a.b a(Context context, String str, String str2, int i2, long j2, String str3) {
        com.xiaomi.b.a.b a2 = a(str);
        a2.a = str2;
        a2.b = i2;
        a2.f8202c = j2;
        a2.f8203d = str3;
        return a2;
    }

    public static com.xiaomi.b.a.b a(String str) {
        com.xiaomi.b.a.b bVar = new com.xiaomi.b.a.b();
        bVar.f8207e = 1000;
        bVar.f8209g = 1001;
        bVar.f8208f = str;
        return bVar;
    }

    public static com.xiaomi.b.a.c a() {
        com.xiaomi.b.a.c cVar = new com.xiaomi.b.a.c();
        cVar.f8207e = 1000;
        cVar.f8209g = 1000;
        cVar.f8208f = "P100000";
        return cVar;
    }

    public static com.xiaomi.b.a.c a(Context context, int i2, long j2, long j3) {
        com.xiaomi.b.a.c a2 = a();
        a2.a = i2;
        a2.b = j2;
        a2.f8204c = j3;
        return a2;
    }

    public static gu a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gu guVar = new gu();
        guVar.d("category_client_report_data");
        guVar.a("push_sdk_channel");
        guVar.a(1L);
        guVar.b(str);
        guVar.c(true);
        guVar.b(System.currentTimeMillis());
        guVar.g(context.getPackageName());
        guVar.e("com.xiaomi.xmsf");
        guVar.f(com.xiaomi.push.service.bc.a());
        guVar.c("quality_support");
        return guVar;
    }

    public static String a(int i2) {
        return i2 == 1000 ? "E100000" : i2 == 3000 ? "E100002" : i2 == 2000 ? "E100001" : i2 == 6000 ? "E100003" : "";
    }

    public static void a(Context context, com.xiaomi.b.a.a aVar) {
        com.xiaomi.b.b.a.a(context, aVar, new dq(context), new dr(context));
    }

    private static void a(Context context, gu guVar) {
        if (a(context.getApplicationContext())) {
            com.xiaomi.push.service.be.a(context.getApplicationContext(), guVar);
            return;
        }
        a aVar = a;
        if (aVar != null) {
            aVar.uploader(context, guVar);
        }
    }

    public static void a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            for (String str : list) {
                gu a2 = a(context, str);
                if (!com.xiaomi.push.service.bc.a(a2, false)) {
                    a(context, a2);
                }
            }
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.d(th.getMessage());
        }
    }

    public static void a(a aVar) {
        a = aVar;
    }

    public static boolean a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }

    public static int b(int i2) {
        if (i2 > 0) {
            return i2 + 1000;
        }
        return -1;
    }

    public static ha b(String str) {
        ha[] values;
        if (b == null) {
            synchronized (ha.class) {
                if (b == null) {
                    b = new HashMap();
                    for (ha haVar : ha.values()) {
                        b.put(haVar.ah.toLowerCase(), haVar);
                    }
                }
            }
        }
        ha haVar2 = b.get(str.toLowerCase());
        return haVar2 != null ? haVar2 : ha.Invalid;
    }

    public static void b(Context context) {
        com.xiaomi.b.b.a.a(context, c(context));
    }

    public static com.xiaomi.b.a.a c(Context context) {
        boolean a2 = com.xiaomi.push.service.ad.a(context).a(gv.PerfUploadSwitch.a(), false);
        boolean a3 = com.xiaomi.push.service.ad.a(context).a(gv.EventUploadNewSwitch.a(), false);
        int a4 = com.xiaomi.push.service.ad.a(context).a(gv.PerfUploadFrequency.a(), RemoteMessageConst.DEFAULT_TTL);
        return com.xiaomi.b.a.a.a().b(a3).b(com.xiaomi.push.service.ad.a(context).a(gv.EventUploadFrequency.a(), RemoteMessageConst.DEFAULT_TTL)).c(a2).c(a4).a(context);
    }
}
