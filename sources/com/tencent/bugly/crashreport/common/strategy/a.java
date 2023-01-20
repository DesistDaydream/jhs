package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.crashreport.biz.b;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ap;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.n;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class a {
    public static int a = 1000;
    private static a b;

    /* renamed from: h */
    private static String f6542h;

    /* renamed from: c */
    private final List<com.tencent.bugly.a> f6543c;

    /* renamed from: d */
    private final x f6544d;

    /* renamed from: e */
    private final StrategyBean f6545e;

    /* renamed from: f */
    private StrategyBean f6546f = null;

    /* renamed from: g */
    private Context f6547g;

    private a(Context context, List<com.tencent.bugly.a> list) {
        String str;
        this.f6547g = context;
        if (com.tencent.bugly.crashreport.common.info.a.a(context) != null) {
            String str2 = com.tencent.bugly.crashreport.common.info.a.a(context).x;
            if ("oversea".equals(str2)) {
                str = "https://astat.bugly.qcloud.com/rqd/async";
            } else {
                str = "na_https".equals(str2) ? "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async" : "https://astat.bugly.cros.wr.pvp.net/:8180/rqd/async";
            }
            StrategyBean.a = str;
            StrategyBean.b = str;
        }
        this.f6545e = new StrategyBean();
        this.f6543c = list;
        this.f6544d = x.a();
    }

    public static StrategyBean d() {
        byte[] bArr;
        List<q> a2 = o.a().a(2);
        if (a2 == null || a2.size() <= 0 || (bArr = a2.get(0).f6786g) == null) {
            return null;
        }
        return (StrategyBean) ab.a(bArr, StrategyBean.CREATOR);
    }

    public final StrategyBean c() {
        StrategyBean strategyBean = this.f6546f;
        if (strategyBean != null) {
            if (!ab.c(strategyBean.p)) {
                this.f6546f.p = StrategyBean.a;
            }
            if (!ab.c(this.f6546f.q)) {
                this.f6546f.q = StrategyBean.b;
            }
            return this.f6546f;
        }
        if (!ab.a(f6542h) && ab.c(f6542h)) {
            StrategyBean strategyBean2 = this.f6545e;
            String str = f6542h;
            strategyBean2.p = str;
            strategyBean2.q = str;
        }
        return this.f6545e;
    }

    public final synchronized boolean b() {
        return this.f6546f != null;
    }

    public static synchronized a a(Context context, List<com.tencent.bugly.a> list) {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a(context, list);
            }
            aVar = b;
        }
        return aVar;
    }

    public final void a(long j2) {
        this.f6544d.a(new Thread() { // from class: com.tencent.bugly.crashreport.common.strategy.a.1
            {
                a.this = this;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    Map<String, byte[]> a2 = o.a().a(a.a, (n) null, true);
                    if (a2 != null) {
                        byte[] bArr = a2.get("device");
                        byte[] bArr2 = a2.get("gateway");
                        if (bArr != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.f6547g).f(new String(bArr));
                        }
                        if (bArr2 != null) {
                            com.tencent.bugly.crashreport.common.info.a.a(a.this.f6547g).e(new String(bArr2));
                        }
                    }
                    a.this.f6546f = a.d();
                    if (a.this.f6546f != null) {
                        if (ab.a(a.f6542h) || !ab.c(a.f6542h)) {
                            a.this.f6546f.p = StrategyBean.a;
                            a.this.f6546f.q = StrategyBean.b;
                        } else {
                            a.this.f6546f.p = a.f6542h;
                            a.this.f6546f.q = a.f6542h;
                        }
                    }
                } catch (Throwable th) {
                    if (!y.a(th)) {
                        th.printStackTrace();
                    }
                }
                a aVar = a.this;
                aVar.a(aVar.f6546f, false);
            }
        }, j2);
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            aVar = b;
        }
        return aVar;
    }

    public final void a(StrategyBean strategyBean, boolean z) {
        y.c("[Strategy] Notify %s", b.class.getName());
        b.a(strategyBean, z);
        for (com.tencent.bugly.a aVar : this.f6543c) {
            try {
                y.c("[Strategy] Notify %s", aVar.getClass().getName());
                aVar.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static void a(String str) {
        if (!ab.a(str) && ab.c(str)) {
            f6542h = str;
        } else {
            y.d("URL user set is invalid.", new Object[0]);
        }
    }

    public final void a(aq aqVar) {
        Map<String, String> map;
        if (aqVar == null) {
            return;
        }
        StrategyBean strategyBean = this.f6546f;
        if (strategyBean == null || aqVar.f6724h != strategyBean.n) {
            StrategyBean strategyBean2 = new StrategyBean();
            strategyBean2.f6533e = aqVar.a;
            strategyBean2.f6535g = aqVar.f6719c;
            strategyBean2.f6534f = aqVar.b;
            if (ab.a(f6542h) || !ab.c(f6542h)) {
                if (ab.c(aqVar.f6720d)) {
                    y.c("[Strategy] Upload url changes to %s", aqVar.f6720d);
                    strategyBean2.p = aqVar.f6720d;
                }
                if (ab.c(aqVar.f6721e)) {
                    y.c("[Strategy] Exception upload url changes to %s", aqVar.f6721e);
                    strategyBean2.q = aqVar.f6721e;
                }
            }
            ap apVar = aqVar.f6722f;
            if (apVar != null && !ab.a(apVar.a)) {
                strategyBean2.r = aqVar.f6722f.a;
            }
            long j2 = aqVar.f6724h;
            if (j2 != 0) {
                strategyBean2.n = j2;
            }
            if (aqVar != null && (map = aqVar.f6723g) != null && map.size() > 0) {
                Map<String, String> map2 = aqVar.f6723g;
                strategyBean2.s = map2;
                String str = map2.get("B11");
                strategyBean2.f6536h = str != null && str.equals("1");
                String str2 = aqVar.f6723g.get("B3");
                if (str2 != null) {
                    strategyBean2.v = Long.parseLong(str2);
                }
                int i2 = aqVar.f6725i;
                strategyBean2.o = i2;
                strategyBean2.u = i2;
                String str3 = aqVar.f6723g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean2.t = parseInt;
                        }
                    } catch (Exception e2) {
                        if (!y.a(e2)) {
                            e2.printStackTrace();
                        }
                    }
                }
                String str4 = aqVar.f6723g.get("B25");
                strategyBean2.f6538j = str4 != null && str4.equals("1");
            }
            y.a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean2.f6533e), Boolean.valueOf(strategyBean2.f6535g), Boolean.valueOf(strategyBean2.f6534f), Boolean.valueOf(strategyBean2.f6536h), Boolean.valueOf(strategyBean2.f6537i), Boolean.valueOf(strategyBean2.f6540l), Boolean.valueOf(strategyBean2.f6541m), Long.valueOf(strategyBean2.o), Boolean.valueOf(strategyBean2.f6538j), Long.valueOf(strategyBean2.n));
            this.f6546f = strategyBean2;
            if (!ab.c(aqVar.f6720d)) {
                y.c("[Strategy] download url is null", new Object[0]);
                this.f6546f.p = "";
            }
            if (!ab.c(aqVar.f6721e)) {
                y.c("[Strategy] download crashurl is null", new Object[0]);
                this.f6546f.q = "";
            }
            o.a().b(2);
            q qVar = new q();
            qVar.b = 2;
            qVar.a = strategyBean2.f6531c;
            qVar.f6784e = strategyBean2.f6532d;
            qVar.f6786g = ab.a(strategyBean2);
            o.a().a(qVar);
            a(strategyBean2, true);
        }
    }
}
