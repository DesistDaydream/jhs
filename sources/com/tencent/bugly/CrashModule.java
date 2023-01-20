package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.y;

/* loaded from: classes3.dex */
public class CrashModule extends a {
    public static final int MODULE_ID = 1004;

    /* renamed from: c  reason: collision with root package name */
    private static int f6486c;

    /* renamed from: e  reason: collision with root package name */
    private static CrashModule f6487e = new CrashModule();
    private long a;
    private BuglyStrategy.a b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6488d = false;

    private synchronized void a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
        if (!TextUtils.isEmpty(libBuglySOFilePath)) {
            com.tencent.bugly.crashreport.common.info.a.a(context).f6528l = libBuglySOFilePath;
            y.a("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (buglyStrategy.getCrashHandleCallback() != null) {
            this.b = buglyStrategy.getCrashHandleCallback();
            y.a("setted CrashHanldeCallback", new Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            long appReportDelay = buglyStrategy.getAppReportDelay();
            this.a = appReportDelay;
            y.a("setted delay: %d", Long.valueOf(appReportDelay));
        }
    }

    public static CrashModule getInstance() {
        CrashModule crashModule = f6487e;
        crashModule.id = 1004;
        return crashModule;
    }

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public synchronized boolean hasInitialized() {
        return this.f6488d;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0096 A[Catch: all -> 0x00c8, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x0009, B:9:0x0039, B:11:0x005a, B:13:0x0060, B:14:0x0063, B:16:0x0068, B:19:0x006f, B:22:0x007f, B:25:0x0086, B:28:0x0096, B:30:0x009e, B:32:0x00a5, B:26:0x0091, B:20:0x007a), top: B:40:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x009e A[Catch: all -> 0x00c8, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x0009, B:9:0x0039, B:11:0x005a, B:13:0x0060, B:14:0x0063, B:16:0x0068, B:19:0x006f, B:22:0x007f, B:25:0x0086, B:28:0x0096, B:30:0x009e, B:32:0x00a5, B:26:0x0091, B:20:0x007a), top: B:40:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3  */
    @Override // com.tencent.bugly.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void init(android.content.Context r12, boolean r13, com.tencent.bugly.BuglyStrategy r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r12 == 0) goto Lcb
            boolean r0 = r11.f6488d     // Catch: java.lang.Throwable -> Lc8
            if (r0 == 0) goto L9
            goto Lcb
        L9:
            java.lang.String r0 = "Initializing crash module."
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lc8
            com.tencent.bugly.proguard.y.a(r0, r2)     // Catch: java.lang.Throwable -> Lc8
            com.tencent.bugly.proguard.m r0 = com.tencent.bugly.proguard.m.a()     // Catch: java.lang.Throwable -> Lc8
            int r2 = com.tencent.bugly.CrashModule.f6486c     // Catch: java.lang.Throwable -> Lc8
            r3 = 1
            int r2 = r2 + r3
            com.tencent.bugly.CrashModule.f6486c = r2     // Catch: java.lang.Throwable -> Lc8
            r4 = 1004(0x3ec, float:1.407E-42)
            r0.a(r4, r2)     // Catch: java.lang.Throwable -> Lc8
            r11.f6488d = r3     // Catch: java.lang.Throwable -> Lc8
            com.tencent.bugly.crashreport.CrashReport.setContext(r12)     // Catch: java.lang.Throwable -> Lc8
            r11.a(r12, r14)     // Catch: java.lang.Throwable -> Lc8
            r5 = 1004(0x3ec, float:1.407E-42)
            com.tencent.bugly.BuglyStrategy$a r8 = r11.b     // Catch: java.lang.Throwable -> Lc8
            r9 = 0
            r10 = 0
            r6 = r12
            r7 = r13
            com.tencent.bugly.crashreport.crash.c r13 = com.tencent.bugly.crashreport.crash.c.a(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lc8
            r13.f()     // Catch: java.lang.Throwable -> Lc8
            if (r14 == 0) goto L58
            int r0 = r14.getCallBackType()     // Catch: java.lang.Throwable -> Lc8
            r13.a(r0)     // Catch: java.lang.Throwable -> Lc8
            boolean r0 = r14.getCloseErrorCallback()     // Catch: java.lang.Throwable -> Lc8
            r13.a(r0)     // Catch: java.lang.Throwable -> Lc8
            boolean r0 = r14.isUploadSpotCrash()     // Catch: java.lang.Throwable -> Lc8
            com.tencent.bugly.crashreport.crash.c.f6607l = r0     // Catch: java.lang.Throwable -> Lc8
            com.tencent.bugly.crashreport.common.info.a r0 = com.tencent.bugly.crashreport.common.info.a.a(r12)     // Catch: java.lang.Throwable -> Lc8
            boolean r2 = r14.isEnableRecordAnrMainStack()     // Catch: java.lang.Throwable -> Lc8
            r0.b(r2)     // Catch: java.lang.Throwable -> Lc8
        L58:
            if (r14 == 0) goto L63
            boolean r0 = r14.isEnableCatchAnrTrace()     // Catch: java.lang.Throwable -> Lc8
            if (r0 == 0) goto L63
            r13.k()     // Catch: java.lang.Throwable -> Lc8
        L63:
            r13.o()     // Catch: java.lang.Throwable -> Lc8
            if (r14 == 0) goto L7a
            boolean r0 = r14.isEnableNativeCrashMonitor()     // Catch: java.lang.Throwable -> Lc8
            if (r0 == 0) goto L6f
            goto L7a
        L6f:
            java.lang.String r0 = "[crash] Closed native crash monitor!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lc8
            com.tencent.bugly.proguard.y.a(r0, r2)     // Catch: java.lang.Throwable -> Lc8
            r13.g()     // Catch: java.lang.Throwable -> Lc8
            goto L7d
        L7a:
            r13.h()     // Catch: java.lang.Throwable -> Lc8
        L7d:
            if (r14 == 0) goto L91
            boolean r0 = r14.isEnableANRCrashMonitor()     // Catch: java.lang.Throwable -> Lc8
            if (r0 == 0) goto L86
            goto L91
        L86:
            java.lang.String r0 = "[crash] Closed ANR monitor!"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lc8
            com.tencent.bugly.proguard.y.a(r0, r1)     // Catch: java.lang.Throwable -> Lc8
            r13.j()     // Catch: java.lang.Throwable -> Lc8
            goto L94
        L91:
            r13.i()     // Catch: java.lang.Throwable -> Lc8
        L94:
            if (r14 == 0) goto L9c
            boolean r0 = r14.isMerged()     // Catch: java.lang.Throwable -> Lc8
            com.tencent.bugly.crashreport.crash.c.f6599d = r0     // Catch: java.lang.Throwable -> Lc8
        L9c:
            if (r14 == 0) goto La3
            long r0 = r14.getAppReportDelay()     // Catch: java.lang.Throwable -> Lc8
            goto La5
        La3:
            r0 = 0
        La5:
            r13.a(r0)     // Catch: java.lang.Throwable -> Lc8
            r13.n()     // Catch: java.lang.Throwable -> Lc8
            com.tencent.bugly.crashreport.crash.d.a(r12)     // Catch: java.lang.Throwable -> Lc8
            com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver r13 = com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.getInstance()     // Catch: java.lang.Throwable -> Lc8
            java.lang.String r14 = "android.net.conn.CONNECTIVITY_CHANGE"
            r13.addFilter(r14)     // Catch: java.lang.Throwable -> Lc8
            r13.register(r12)     // Catch: java.lang.Throwable -> Lc8
            com.tencent.bugly.proguard.m r12 = com.tencent.bugly.proguard.m.a()     // Catch: java.lang.Throwable -> Lc8
            int r13 = com.tencent.bugly.CrashModule.f6486c     // Catch: java.lang.Throwable -> Lc8
            int r13 = r13 - r3
            com.tencent.bugly.CrashModule.f6486c = r13     // Catch: java.lang.Throwable -> Lc8
            r12.a(r4, r13)     // Catch: java.lang.Throwable -> Lc8
            monitor-exit(r11)
            return
        Lc8:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        Lcb:
            monitor-exit(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.init(android.content.Context, boolean, com.tencent.bugly.BuglyStrategy):void");
    }

    @Override // com.tencent.bugly.a
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        c a;
        if (strategyBean == null || (a = c.a()) == null) {
            return;
        }
        a.a(strategyBean);
    }
}
