package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class d {
    private static d a;
    private com.tencent.bugly.crashreport.common.strategy.a b;

    /* renamed from: c  reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.info.a f6615c;

    /* renamed from: d  reason: collision with root package name */
    private b f6616d;

    /* renamed from: e  reason: collision with root package name */
    private Context f6617e;

    private d(Context context) {
        c a2 = c.a();
        if (a2 == null) {
            return;
        }
        this.b = com.tencent.bugly.crashreport.common.strategy.a.a();
        this.f6615c = com.tencent.bugly.crashreport.common.info.a.a(context);
        this.f6616d = a2.p;
        this.f6617e = context;
        x.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.1
            @Override // java.lang.Runnable
            public final void run() {
                d.a(d.this);
            }
        });
    }

    public static /* synthetic */ void a(d dVar) {
        y.c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            dVar.f6615c.getClass();
            ab.a(cls, "sdkPackageName", "com.tencent.bugly", null);
            y.c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            y.a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    public static /* synthetic */ void a(d dVar, Thread thread, int i2, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        String str6;
        Thread currentThread = thread == null ? Thread.currentThread() : thread;
        if (i2 == 4) {
            str4 = "Unity";
        } else if (i2 == 5 || i2 == 6) {
            str4 = "Cocos";
        } else if (i2 != 8) {
            y.d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i2));
            return;
        } else {
            str4 = "H5";
        }
        y.e("[ExtraCrashManager] %s Crash Happen", str4);
        try {
            if (!dVar.b.b()) {
                y.d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean c2 = dVar.b.c();
            if (!c2.f6533e && dVar.b.b()) {
                y.e("[ExtraCrashManager] Crash report was closed by remote. Will not upload to Bugly , print local for helpful!", new Object[0]);
                String a2 = ab.a();
                String str7 = dVar.f6615c.f6520d;
                String name = currentThread.getName();
                b.a(str4, a2, str7, name, str + "\n" + str2 + "\n" + str3, (CrashDetailBean) null);
                y.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            if (i2 == 5 || i2 == 6) {
                if (!c2.f6538j) {
                    y.e("[ExtraCrashManager] %s report is disabled.", str4);
                    y.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                    return;
                }
            } else if (i2 == 8 && !c2.f6539k) {
                y.e("[ExtraCrashManager] %s report is disabled.", str4);
                y.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            int i3 = i2 != 8 ? i2 : 5;
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.j();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.l();
            crashDetailBean.F = dVar.f6615c.o();
            crashDetailBean.G = dVar.f6615c.n();
            crashDetailBean.H = dVar.f6615c.p();
            crashDetailBean.I = com.tencent.bugly.crashreport.common.info.b.f();
            crashDetailBean.J = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.K = com.tencent.bugly.crashreport.common.info.b.h();
            Context context = dVar.f6617e;
            crashDetailBean.w = ab.a(c.f6600e, (String) null);
            crashDetailBean.b = i3;
            crashDetailBean.f6553e = dVar.f6615c.k();
            com.tencent.bugly.crashreport.common.info.a aVar = dVar.f6615c;
            crashDetailBean.f6554f = aVar.f6525i;
            crashDetailBean.f6555g = aVar.u();
            crashDetailBean.f6561m = dVar.f6615c.g();
            crashDetailBean.n = str;
            crashDetailBean.o = str2;
            str5 = "";
            if (str3 != null) {
                String[] split = str3.split("\n");
                str5 = split.length > 0 ? split[0] : "";
                str6 = str3;
            } else {
                str6 = "";
            }
            crashDetailBean.p = str5;
            crashDetailBean.q = str6;
            crashDetailBean.r = System.currentTimeMillis();
            crashDetailBean.u = ab.a(crashDetailBean.q.getBytes());
            crashDetailBean.z = ab.a(dVar.f6615c.h(), c.f6601f, false);
            crashDetailBean.A = dVar.f6615c.f6520d;
            crashDetailBean.B = currentThread.getName() + "(" + currentThread.getId() + ")";
            crashDetailBean.L = dVar.f6615c.w();
            crashDetailBean.f6556h = dVar.f6615c.t();
            com.tencent.bugly.crashreport.common.info.a aVar2 = dVar.f6615c;
            crashDetailBean.P = aVar2.a;
            crashDetailBean.Q = aVar2.a();
            if (!c.a().p()) {
                dVar.f6616d.d(crashDetailBean);
            }
            crashDetailBean.T = dVar.f6615c.D();
            crashDetailBean.U = dVar.f6615c.E();
            crashDetailBean.V = dVar.f6615c.x();
            crashDetailBean.W = dVar.f6615c.C();
            crashDetailBean.y = aa.a();
            if (crashDetailBean.R == null) {
                crashDetailBean.R = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.R.putAll(map);
            }
            String a3 = ab.a();
            String str8 = dVar.f6615c.f6520d;
            String name2 = currentThread.getName();
            b.a(str4, a3, str8, name2, str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!dVar.f6616d.a(crashDetailBean)) {
                dVar.f6616d.a(crashDetailBean, 3000L, false);
            }
            y.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
                y.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                y.e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }

    public static d a(Context context) {
        if (a == null) {
            a = new d(context);
        }
        return a;
    }

    public static void a(final Thread thread, final int i2, final String str, final String str2, final String str3, final Map<String, String> map) {
        x.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (d.a != null) {
                        d.a(d.a, thread, i2, str, str2, str3, map);
                    } else {
                        y.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    }
                } catch (Throwable th) {
                    if (!y.b(th)) {
                        th.printStackTrace();
                    }
                    y.e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }
}
