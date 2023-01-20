package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.service.XMJobService;

/* loaded from: classes3.dex */
public final class dy {
    private static a a;
    private static final String b = XMJobService.class.getCanonicalName();

    /* renamed from: c  reason: collision with root package name */
    private static int f8476c = 0;

    /* loaded from: classes3.dex */
    public interface a {
        void a();

        void a(boolean z);

        boolean b();
    }

    public static synchronized void a() {
        synchronized (dy.class) {
            if (a == null) {
                return;
            }
            com.xiaomi.a.a.a.c.a("[Alarm] stop alarm.");
            a.a();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
        if (r7.equals(com.xiaomi.push.jl.a(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r9) {
        /*
            java.lang.String r0 = "android.permission.BIND_JOB_SERVICE"
            android.content.Context r9 = r9.getApplicationContext()
            java.lang.String r1 = r9.getPackageName()
            java.lang.String r2 = "com.xiaomi.xmsf"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L1b
            com.xiaomi.push.dz r0 = new com.xiaomi.push.dz
            r0.<init>(r9)
        L17:
            com.xiaomi.push.dy.a = r0
            goto Ld0
        L1b:
            android.content.pm.PackageManager r1 = r9.getPackageManager()
            r2 = 0
            java.lang.String r3 = r9.getPackageName()     // Catch: java.lang.Exception -> L7d
            r4 = 4
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r3, r4)     // Catch: java.lang.Exception -> L7d
            android.content.pm.ServiceInfo[] r1 = r1.services     // Catch: java.lang.Exception -> L7d
            r3 = 1
            if (r1 == 0) goto L96
            int r4 = r1.length     // Catch: java.lang.Exception -> L7d
            r5 = 0
        L30:
            if (r2 >= r4) goto L7b
            r6 = r1[r2]     // Catch: java.lang.Exception -> L78
            java.lang.String r7 = r6.permission     // Catch: java.lang.Exception -> L78
            boolean r7 = r0.equals(r7)     // Catch: java.lang.Exception -> L78
            if (r7 == 0) goto L61
            java.lang.String r7 = com.xiaomi.push.dy.b     // Catch: java.lang.Exception -> L78
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L78
            boolean r8 = r7.equals(r8)     // Catch: java.lang.Exception -> L78
            if (r8 == 0) goto L48
        L46:
            r5 = 1
            goto L5e
        L48:
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L5d
            java.lang.Class r8 = com.xiaomi.push.jl.a(r9, r8)     // Catch: java.lang.Exception -> L5d
            java.lang.Class r8 = r8.getSuperclass()     // Catch: java.lang.Exception -> L5d
            java.lang.String r8 = r8.getCanonicalName()     // Catch: java.lang.Exception -> L5d
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Exception -> L5d
            if (r7 == 0) goto L5e
            goto L46
        L5d:
        L5e:
            if (r5 != r3) goto L61
            goto L7b
        L61:
            java.lang.String r7 = com.xiaomi.push.dy.b     // Catch: java.lang.Exception -> L78
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L78
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Exception -> L78
            if (r7 == 0) goto L75
            java.lang.String r6 = r6.permission     // Catch: java.lang.Exception -> L78
            boolean r6 = r0.equals(r6)     // Catch: java.lang.Exception -> L78
            if (r6 == 0) goto L75
            r2 = 1
            goto L96
        L75:
            int r2 = r2 + 1
            goto L30
        L78:
            r1 = move-exception
            r2 = r5
            goto L7e
        L7b:
            r2 = r5
            goto L96
        L7d:
            r1 = move-exception
        L7e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "check service err : "
            r3.append(r4)
            java.lang.String r1 = r1.getMessage()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.xiaomi.a.a.a.c.a(r1)
        L96:
            if (r2 != 0) goto Lc5
            boolean r1 = com.xiaomi.push.jl.b(r9)
            if (r1 != 0) goto L9f
            goto Lc5
        L9f:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Should export service: "
            r1.append(r2)
            java.lang.String r2 = com.xiaomi.push.dy.b
            r1.append(r2)
            java.lang.String r2 = " with permission "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " in AndroidManifest.xml file"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r9.<init>(r0)
            throw r9
        Lc5:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            com.xiaomi.push.dz r0 = new com.xiaomi.push.dz
            r0.<init>(r9)
            goto L17
        Ld0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dy.a(android.content.Context):void");
    }

    public static synchronized void a(Context context, int i2) {
        synchronized (dy.class) {
            int i3 = f8476c;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i2 == 2) {
                    f8476c = 2;
                } else {
                    f8476c = 0;
                }
            }
            int i4 = f8476c;
            if (i3 != i4 && i4 == 2) {
                a();
                a = new eb(context);
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (dy.class) {
            if (a == null) {
                com.xiaomi.a.a.a.c.a("timer is not initialized");
                return;
            }
            com.xiaomi.a.a.a.c.a("[Alarm] register alarm. (" + z + ")");
            a.a(z);
        }
    }

    public static synchronized boolean b() {
        synchronized (dy.class) {
            a aVar = a;
            if (aVar == null) {
                return false;
            }
            return aVar.b();
        }
    }
}
