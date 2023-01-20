package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;

/* loaded from: classes3.dex */
public class b {
    public static com.tencent.bugly.crashreport.biz.a a = null;
    private static boolean b = false;

    /* renamed from: c */
    private static int f6507c = 10;

    /* renamed from: d */
    private static long f6508d = 300000;

    /* renamed from: e */
    private static long f6509e = 30000;

    /* renamed from: f */
    private static long f6510f = 0;

    /* renamed from: g */
    private static int f6511g = 0;

    /* renamed from: h */
    private static long f6512h = 0;

    /* renamed from: i */
    private static long f6513i = 0;

    /* renamed from: j */
    private static long f6514j = 0;

    /* renamed from: k */
    private static Application.ActivityLifecycleCallbacks f6515k = null;

    /* renamed from: l */
    private static Class<?> f6516l = null;

    /* renamed from: m */
    private static boolean f6517m = true;

    /* loaded from: classes3.dex */
    public static class a implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            String name = activity.getClass().getName();
            if (b.f6516l == null || b.f6516l.getName().equals(name)) {
                y.c(">>> %s onCreated <<<", name);
                com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                if (b != null) {
                    b.B.add(b.a(name, "onCreated"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            String name = activity.getClass().getName();
            if (b.f6516l == null || b.f6516l.getName().equals(name)) {
                y.c(">>> %s onDestroyed <<<", name);
                com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                if (b != null) {
                    b.B.add(b.a(name, "onDestroyed"));
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            String name = activity.getClass().getName();
            if (b.f6516l == null || b.f6516l.getName().equals(name)) {
                y.c(">>> %s onPaused <<<", name);
                com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                if (b == null) {
                    return;
                }
                b.B.add(b.a(name, "onPaused"));
                long currentTimeMillis = System.currentTimeMillis();
                b.q = currentTimeMillis;
                b.r = currentTimeMillis - b.p;
                long unused = b.f6512h = currentTimeMillis;
                if (b.r < 0) {
                    b.r = 0L;
                }
                b.o = "background";
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            String name = activity.getClass().getName();
            if (b.f6516l == null || b.f6516l.getName().equals(name)) {
                y.c(">>> %s onResumed <<<", name);
                com.tencent.bugly.crashreport.common.info.a b = com.tencent.bugly.crashreport.common.info.a.b();
                if (b == null) {
                    return;
                }
                b.B.add(b.a(name, "onResumed"));
                b.o = name;
                long currentTimeMillis = System.currentTimeMillis();
                b.p = currentTimeMillis;
                b.s = currentTimeMillis - b.f6513i;
                long j2 = b.p - b.f6512h;
                if (j2 > (b.f6510f > 0 ? b.f6510f : b.f6509e)) {
                    b.d();
                    b.g();
                    y.a("[session] launch app one times (app in background %d seconds and over %d seconds)", Long.valueOf(j2 / 1000), Long.valueOf(b.f6509e / 1000));
                    if (b.f6511g % b.f6507c == 0) {
                        b.a.a(4, b.f6517m, 0L);
                        return;
                    }
                    b.a.a(4, false, 0L);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 - b.f6514j > b.f6508d) {
                        long unused = b.f6514j = currentTimeMillis2;
                        y.a("add a timer to upload hot start user info", new Object[0]);
                        if (b.f6517m) {
                            x.a().a(new a.RunnableC0232a(null, true), b.f6508d);
                        }
                    }
                }
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            y.c(">>> %s onStart <<<", activity.getClass().getName());
            com.tencent.bugly.crashreport.common.info.a.b().a(activity.hashCode(), true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            y.c(">>> %s onStop <<<", activity.getClass().getName());
            com.tencent.bugly.crashreport.common.info.a.b().a(activity.hashCode(), false);
        }
    }

    public static /* synthetic */ String a(String str, String str2) {
        return ab.a() + "  " + str + "  " + str2 + "\n";
    }

    public static /* synthetic */ int g() {
        int i2 = f6511g;
        f6511g = i2 + 1;
        return i2;
    }

    public static void a(final Context context, final BuglyStrategy buglyStrategy) {
        long j2;
        if (b) {
            return;
        }
        boolean z = com.tencent.bugly.crashreport.common.info.a.a(context).f6521e;
        f6517m = z;
        a = new com.tencent.bugly.crashreport.biz.a(context, z);
        b = true;
        if (buglyStrategy != null) {
            f6516l = buglyStrategy.getUserInfoActivity();
            j2 = buglyStrategy.getAppReportDelay();
        } else {
            j2 = 0;
        }
        if (j2 <= 0) {
            c(context, buglyStrategy);
        } else {
            x.a().a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.c(context, buglyStrategy);
                }
            }, j2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:96:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(android.content.Context r12, com.tencent.bugly.BuglyStrategy r13) {
        /*
            r0 = 1
            r1 = 0
            if (r13 == 0) goto Ld
            boolean r2 = r13.recordUserInfoOnceADay()
            boolean r13 = r13.isEnableUserInfo()
            goto Lf
        Ld:
            r13 = 1
            r2 = 0
        Lf:
            r3 = 0
            if (r2 == 0) goto L6a
            com.tencent.bugly.crashreport.common.info.a r13 = com.tencent.bugly.crashreport.common.info.a.a(r12)
            java.lang.String r2 = r13.f6520d
            com.tencent.bugly.crashreport.biz.a r5 = com.tencent.bugly.crashreport.biz.b.a
            java.util.List r2 = r5.a(r2)
            if (r2 == 0) goto L65
            r5 = 0
        L22:
            int r6 = r2.size()
            if (r5 >= r6) goto L65
            java.lang.Object r6 = r2.get(r5)
            com.tencent.bugly.crashreport.biz.UserInfoBean r6 = (com.tencent.bugly.crashreport.biz.UserInfoBean) r6
            java.lang.String r7 = r6.n
            java.lang.String r8 = r13.f6525i
            boolean r7 = r7.equals(r8)
            if (r7 == 0) goto L62
            int r7 = r6.b
            if (r7 != r0) goto L62
            long r7 = com.tencent.bugly.proguard.ab.b()
            int r9 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r9 <= 0) goto L65
            long r9 = r6.f6495e
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 < 0) goto L62
            long r5 = r6.f6496f
            int r13 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r13 > 0) goto L60
            com.tencent.bugly.crashreport.biz.a r13 = com.tencent.bugly.crashreport.biz.b.a
            com.tencent.bugly.proguard.x r2 = com.tencent.bugly.proguard.x.a()
            if (r2 == 0) goto L60
            com.tencent.bugly.crashreport.biz.a$2 r5 = new com.tencent.bugly.crashreport.biz.a$2
            r5.<init>()
            r2.a(r5)
        L60:
            r13 = 0
            goto L66
        L62:
            int r5 = r5 + 1
            goto L22
        L65:
            r13 = 1
        L66:
            if (r13 != 0) goto L69
            return
        L69:
            r13 = 0
        L6a:
            com.tencent.bugly.crashreport.common.info.a r2 = com.tencent.bugly.crashreport.common.info.a.b()
            if (r2 == 0) goto L79
            boolean r5 = b(r12)
            if (r5 == 0) goto L79
            r2.a(r1, r0)
        L79:
            if (r13 == 0) goto Lae
            r13 = 0
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 14
            if (r2 < r5) goto Lae
            android.content.Context r2 = r12.getApplicationContext()
            boolean r2 = r2 instanceof android.app.Application
            if (r2 == 0) goto L91
            android.content.Context r12 = r12.getApplicationContext()
            r13 = r12
            android.app.Application r13 = (android.app.Application) r13
        L91:
            if (r13 == 0) goto Lae
            android.app.Application$ActivityLifecycleCallbacks r12 = com.tencent.bugly.crashreport.biz.b.f6515k     // Catch: java.lang.Exception -> La4
            if (r12 != 0) goto L9e
            com.tencent.bugly.crashreport.biz.b$a r12 = new com.tencent.bugly.crashreport.biz.b$a     // Catch: java.lang.Exception -> La4
            r12.<init>()     // Catch: java.lang.Exception -> La4
            com.tencent.bugly.crashreport.biz.b.f6515k = r12     // Catch: java.lang.Exception -> La4
        L9e:
            android.app.Application$ActivityLifecycleCallbacks r12 = com.tencent.bugly.crashreport.biz.b.f6515k     // Catch: java.lang.Exception -> La4
            r13.registerActivityLifecycleCallbacks(r12)     // Catch: java.lang.Exception -> La4
            goto Lae
        La4:
            r12 = move-exception
            boolean r13 = com.tencent.bugly.proguard.y.a(r12)
            if (r13 != 0) goto Lae
            r12.printStackTrace()
        Lae:
            boolean r12 = com.tencent.bugly.crashreport.biz.b.f6517m
            if (r12 == 0) goto Lda
            long r12 = java.lang.System.currentTimeMillis()
            com.tencent.bugly.crashreport.biz.b.f6513i = r12
            com.tencent.bugly.crashreport.biz.a r12 = com.tencent.bugly.crashreport.biz.b.a
            r12.a(r0, r1, r3)
            java.lang.Object[] r12 = new java.lang.Object[r1]
            java.lang.String r13 = "[session] launch app, new start"
            com.tencent.bugly.proguard.y.a(r13, r12)
            com.tencent.bugly.crashreport.biz.a r12 = com.tencent.bugly.crashreport.biz.b.a
            r12.a()
            com.tencent.bugly.crashreport.biz.a r12 = com.tencent.bugly.crashreport.biz.b.a
            r0 = 21600000(0x1499700, double:1.0671818E-316)
            com.tencent.bugly.proguard.x r13 = com.tencent.bugly.proguard.x.a()
            com.tencent.bugly.crashreport.biz.a$c r2 = new com.tencent.bugly.crashreport.biz.a$c
            r2.<init>(r0)
            r13.a(r2, r0)
        Lda:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.b.c(android.content.Context, com.tencent.bugly.BuglyStrategy):void");
    }

    private static boolean b(Context context) {
        try {
            int myPid = Process.myPid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == myPid && runningAppProcessInfo.importance == 100) {
                    return true;
                }
            }
        } catch (Throwable th) {
            y.b(th);
        }
        return false;
    }

    public static void a(long j2) {
        if (j2 < 0) {
            j2 = com.tencent.bugly.crashreport.common.strategy.a.a().c().o;
        }
        f6510f = j2;
    }

    public static void a(StrategyBean strategyBean, boolean z) {
        x a2;
        com.tencent.bugly.crashreport.biz.a aVar = a;
        if (aVar != null && !z && (a2 = x.a()) != null) {
            a2.a(new a.AnonymousClass2());
        }
        if (strategyBean == null) {
            return;
        }
        long j2 = strategyBean.o;
        if (j2 > 0) {
            f6509e = j2;
        }
        int i2 = strategyBean.t;
        if (i2 > 0) {
            f6507c = i2;
        }
        long j3 = strategyBean.u;
        if (j3 > 0) {
            f6508d = j3;
        }
    }

    public static void a() {
        com.tencent.bugly.crashreport.biz.a aVar = a;
        if (aVar != null) {
            aVar.a(2, false, 0L);
        }
    }

    public static void a(Context context) {
        if (!b || context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = f6515k;
                    if (activityLifecycleCallbacks != null) {
                        application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
                    }
                } catch (Exception e2) {
                    if (!y.a(e2)) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        b = false;
    }
}
