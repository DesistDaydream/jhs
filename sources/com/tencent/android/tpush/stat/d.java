package com.tencent.android.tpush.stat;

import android.content.Context;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.service.XGVipPushService;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: d */
    private static com.tencent.android.tpush.stat.b.c f6438d = com.tencent.android.tpush.stat.b.b.b();
    public static a a = new a(2);
    public static a b = new a(1);

    /* renamed from: e */
    private static StatReportStrategy f6439e = StatReportStrategy.APP_LAUNCH;

    /* renamed from: f */
    private static boolean f6440f = true;

    /* renamed from: g */
    private static boolean f6441g = true;

    /* renamed from: c */
    public static String f6437c = "__HIBERNATE__";

    /* renamed from: h */
    private static boolean f6442h = false;

    /* renamed from: i */
    private static short f6443i = 6;

    /* renamed from: j */
    private static int f6444j = 1024;

    /* renamed from: k */
    private static int f6445k = 30000;

    /* renamed from: l */
    private static int f6446l = 0;

    /* renamed from: m */
    private static int f6447m = 20;

    /* loaded from: classes3.dex */
    public static class a {
        public int a;
        public JSONObject b = new JSONObject();

        /* renamed from: c */
        public String f6448c = "";

        /* renamed from: d */
        public int f6449d = 0;

        public a(int i2) {
            this.a = i2;
        }
    }

    public static StatReportStrategy a() {
        return f6439e;
    }

    public static boolean b() {
        return f6440f;
    }

    public static boolean c() {
        Context context = XGPushManager.getContext();
        if (context == null) {
            if (XGVipPushService.b() == null) {
                return false;
            }
            context = XGVipPushService.b().getApplicationContext();
        }
        if (context != null) {
            return f6441g && com.tencent.android.tpush.service.a.a.a(context.getApplicationContext()).B == 1;
        }
        return f6441g;
    }

    public static boolean d() {
        return f6442h;
    }

    public static short e() {
        return f6443i;
    }

    public static int f() {
        return f6444j;
    }

    public static void a(StatReportStrategy statReportStrategy) {
        f6439e = statReportStrategy;
        if (b()) {
            com.tencent.android.tpush.stat.b.c cVar = f6438d;
            cVar.h("Change to statSendStrategy: " + statReportStrategy);
        }
    }

    public static void b(boolean z) {
        f6441g = z;
        if (z) {
            return;
        }
        f6438d.c("!!!!!!MTA StatService has been disabled!!!!!!");
    }

    public static void b(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        try {
            String string = jSONObject.getString(f6437c);
            if (b()) {
                com.tencent.android.tpush.stat.b.c cVar = f6438d;
                cVar.h("hibernateVer:" + string + ", current version:2.0.6");
            }
            long b2 = com.tencent.android.tpush.stat.b.b.b(string);
            if (com.tencent.android.tpush.stat.b.b.b("2.0.6") <= b2) {
                a(b2);
            }
        } catch (JSONException unused) {
            f6438d.h("__HIBERNATE__ not found.");
        }
    }

    public static void a(boolean z) {
        f6440f = z;
        com.tencent.android.tpush.stat.b.b.b().a(z);
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase(Integer.toString(b.a))) {
                    a(context, b, jSONObject.getJSONObject(next));
                } else if (next.equalsIgnoreCase(Integer.toString(a.a))) {
                    a(context, a, jSONObject.getJSONObject(next));
                }
            }
        } catch (JSONException e2) {
            f6438d.b((Throwable) e2);
        }
    }

    public static void c(boolean z) {
        f6442h = z;
    }

    public static void a(Context context, a aVar, JSONObject jSONObject) {
        boolean z = false;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase("v")) {
                    int i2 = jSONObject.getInt(next);
                    if (aVar.f6449d != i2) {
                        z = true;
                    }
                    aVar.f6449d = i2;
                } else if (next.equalsIgnoreCase("c")) {
                    String string = jSONObject.getString("c");
                    if (string.length() > 0) {
                        aVar.b = new JSONObject(string);
                    }
                } else if (next.equalsIgnoreCase("m")) {
                    aVar.f6448c = jSONObject.getString("m");
                }
            }
            if (z && aVar.a == b.a) {
                a(aVar.b);
                b(aVar.b);
            }
            a(context, aVar);
        } catch (JSONException e2) {
            f6438d.b((Throwable) e2);
        } catch (Throwable th) {
            f6438d.b(th);
        }
    }

    public static void a(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt("rs"));
            if (statReportStrategy != null) {
                a(statReportStrategy);
            }
        } catch (JSONException unused) {
            if (b()) {
                f6438d.b("rs not found.");
            }
        }
    }

    public static void a(Context context, a aVar) {
        int i2 = aVar.a;
        if (i2 == b.a) {
            b = aVar;
            a(aVar.b);
        } else if (i2 == a.a) {
            a = aVar;
        }
    }

    public static void a(long j2) {
        com.tencent.android.tpush.stat.b.d.b(f.a(), f6437c, j2);
        b(false);
        f6438d.c("MTA is disable for current SDK version");
    }
}
