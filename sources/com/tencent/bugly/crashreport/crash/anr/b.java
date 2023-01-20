package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.text.TextUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.aa;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ad;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: m  reason: collision with root package name */
    private static b f6574m;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final ActivityManager f6575c;

    /* renamed from: d  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.common.info.a f6576d;

    /* renamed from: e  reason: collision with root package name */
    private final x f6577e;

    /* renamed from: f  reason: collision with root package name */
    private final com.tencent.bugly.crashreport.crash.b f6578f;

    /* renamed from: h  reason: collision with root package name */
    private String f6580h;

    /* renamed from: i  reason: collision with root package name */
    private FileObserver f6581i;

    /* renamed from: k  reason: collision with root package name */
    private ad f6583k;

    /* renamed from: l  reason: collision with root package name */
    private int f6584l;
    private final AtomicBoolean a = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    private final Object f6579g = new Object();

    /* renamed from: j  reason: collision with root package name */
    private boolean f6582j = true;
    private long n = 0;

    private b(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2, x xVar, com.tencent.bugly.crashreport.crash.b bVar) {
        Context a = ab.a(context);
        this.b = a;
        this.f6575c = (ActivityManager) a.getSystemService("activity");
        this.f6580h = context.getDir("bugly", 0).getAbsolutePath();
        this.f6576d = aVar2;
        this.f6577e = xVar;
        this.f6578f = bVar;
    }

    public static /* synthetic */ void b(b bVar) {
        long currentTimeMillis = (com.tencent.bugly.crashreport.crash.c.f6602g + System.currentTimeMillis()) - ab.b();
        z.a(bVar.f6580h, "bugly_trace_", ".txt", currentTimeMillis);
        z.a(bVar.f6580h, "manual_bugly_trace_", ".txt", currentTimeMillis);
        z.a(bVar.f6580h, "main_stack_record_", ".txt", currentTimeMillis);
        z.a(bVar.f6580h, "main_stack_record_", ".txt.merged", currentTimeMillis);
    }

    private synchronized boolean e() {
        return this.f6581i != null;
    }

    private synchronized boolean f() {
        return this.f6582j;
    }

    private synchronized void g() {
        if (e()) {
            y.d("start when started!", new Object[0]);
        } else if (TextUtils.isEmpty(this.f6580h)) {
        } else {
            synchronized (this.f6579g) {
                ad adVar = this.f6583k;
                if (adVar == null || !adVar.isAlive()) {
                    ad adVar2 = new ad();
                    this.f6583k = adVar2;
                    adVar2.a(this.f6576d.j());
                    this.f6583k.a(new ad.a() { // from class: com.tencent.bugly.crashreport.crash.anr.b.3
                        @Override // com.tencent.bugly.proguard.ad.a
                        public final void a(boolean z, long j2) {
                            if (z) {
                                if (!b.this.a()) {
                                    y.c("main thread blocked overdue, blockTime:%s", Long.valueOf(j2));
                                    if (!com.tencent.bugly.proguard.a.a(b.this.f6575c)) {
                                        y.c("proc is not in anr, wait next check", new Object[0]);
                                        return;
                                    }
                                    long currentTimeMillis = System.currentTimeMillis();
                                    if (!b.this.a(currentTimeMillis) && b.this.b(true)) {
                                        y.c("found anr", new Object[0]);
                                        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
                                        if (nativeCrashHandler != null && nativeCrashHandler.isEnableCatchAnrTrace()) {
                                            y.c("anr trace enable, do dump trace", new Object[0]);
                                            nativeCrashHandler.dumpAnrNativeStack();
                                            return;
                                        }
                                        y.c("anr trace not enable", new Object[0]);
                                        String str = b.this.f6580h;
                                        File file = new File(str, "manual_bugly_trace_" + currentTimeMillis + ".txt");
                                        y.a("create new trace file:%s", file.getAbsoluteFile());
                                        z.a(file, "android trace not enable\n", 101376L, true);
                                        return;
                                    }
                                    return;
                                }
                                y.c("anr is processing, return", new Object[0]);
                            }
                        }
                    });
                    ad adVar3 = this.f6583k;
                    StringBuilder sb = new StringBuilder("Bugly-ThreadMonitor");
                    int i2 = this.f6584l;
                    this.f6584l = i2 + 1;
                    sb.append(i2);
                    adVar3.setName(sb.toString());
                    this.f6583k.b();
                }
            }
            FileObserver fileObserver = new FileObserver(this.f6580h, 8) { // from class: com.tencent.bugly.crashreport.crash.anr.b.4
                @Override // android.os.FileObserver
                public final void onEvent(int i3, String str) {
                    if (str == null) {
                        return;
                    }
                    y.d("observe file, dir:%s fileName:%s", b.this.f6580h, str);
                    if (!b.a(str)) {
                        y.c("not manual trace file, ignore.", new Object[0]);
                    } else if (!b.this.a()) {
                        y.c("proc is not in anr, just ignore", new Object[0]);
                    } else {
                        long a = z.a(str, "manual_bugly_trace_", ".txt");
                        b bVar = b.this;
                        bVar.a(a, b.this.f6580h + MqttTopic.TOPIC_LEVEL_SEPARATOR + str);
                        y.c("Finish handling one anr.", new Object[0]);
                    }
                }
            };
            this.f6581i = fileObserver;
            fileObserver.startWatching();
            y.a("startWatchingPrivateAnrDir! dumFilePath is %s", this.f6580h);
            this.f6577e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.5
                @Override // java.lang.Runnable
                public final void run() {
                    b.b(b.this);
                }
            });
        }
    }

    private synchronized void h() {
        if (!e()) {
            y.d("close when closed!", new Object[0]);
            return;
        }
        synchronized (this.f6579g) {
            ad adVar = this.f6583k;
            if (adVar != null) {
                adVar.a();
                this.f6583k = null;
            }
        }
        y.a("stopWatchingPrivateAnrDir", new Object[0]);
        this.f6581i.stopWatching();
        this.f6581i = null;
        y.d("close anr monitor!", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(boolean z) {
        boolean compareAndSet = this.a.compareAndSet(!z, z);
        y.c("tryChangeAnrState to %s, success:%s", Boolean.valueOf(z), Boolean.valueOf(compareAndSet));
        return compareAndSet;
    }

    private synchronized void c() {
        if (e()) {
            y.d("start when started!", new Object[0]);
            return;
        }
        FileObserver fileObserver = new FileObserver("/data/anr/", 8) { // from class: com.tencent.bugly.crashreport.crash.anr.b.1
            @Override // android.os.FileObserver
            public final void onEvent(int i2, String str) {
                if (str == null) {
                    return;
                }
                final String str2 = "/data/anr/" + str;
                y.d("watching file %s", str2);
                if (str2.contains("trace")) {
                    b.this.f6577e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.a(b.this, str2);
                        }
                    });
                } else {
                    y.d("not anr file %s", str2);
                }
            }
        };
        this.f6581i = fileObserver;
        fileObserver.startWatching();
        y.a("start anr monitor!", new Object[0]);
        this.f6577e.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.2
            @Override // java.lang.Runnable
            public final void run() {
                b.b(b.this);
            }
        });
    }

    private synchronized void d() {
        if (!e()) {
            y.d("close when closed!", new Object[0]);
            return;
        }
        this.f6581i.stopWatching();
        this.f6581i = null;
        y.d("close anr monitor!", new Object[0]);
    }

    public static /* synthetic */ void a(b bVar, String str) {
        if (bVar.b(true)) {
            try {
                y.c("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                long j2 = readFirstDumpInfo != null ? readFirstDumpInfo.f6567c : -1L;
                if (j2 == -1) {
                    y.d("trace dump fail could not get time!", new Object[0]);
                    j2 = System.currentTimeMillis();
                }
                if (bVar.a(j2)) {
                    return;
                }
                bVar.a(j2, str);
            } catch (Throwable th) {
                if (!y.a(th)) {
                    th.printStackTrace();
                }
                y.e("handle anr error %s", th.getClass().toString());
            }
        }
    }

    public final synchronized void b() {
        y.d("customer decides whether to open or close.", new Object[0]);
    }

    public static /* synthetic */ boolean a(String str) {
        return str.startsWith("manual_bugly_trace_") && str.endsWith(".txt");
    }

    public static b a(Context context, com.tencent.bugly.crashreport.common.strategy.a aVar, com.tencent.bugly.crashreport.common.info.a aVar2, x xVar, o oVar, com.tencent.bugly.crashreport.crash.b bVar, BuglyStrategy.a aVar3) {
        if (f6574m == null) {
            f6574m = new b(context, aVar, aVar2, xVar, bVar);
        }
        return f6574m;
    }

    private CrashDetailBean a(a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.j();
            crashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.e();
            crashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.l();
            crashDetailBean.F = this.f6576d.o();
            crashDetailBean.G = this.f6576d.n();
            crashDetailBean.H = this.f6576d.p();
            crashDetailBean.I = com.tencent.bugly.crashreport.common.info.b.f();
            crashDetailBean.J = com.tencent.bugly.crashreport.common.info.b.g();
            crashDetailBean.K = com.tencent.bugly.crashreport.common.info.b.h();
            if (!com.tencent.bugly.crashreport.common.info.b.o()) {
                crashDetailBean.w = ab.a(com.tencent.bugly.crashreport.crash.c.f6600e, (String) null);
            }
            crashDetailBean.b = 3;
            crashDetailBean.f6553e = this.f6576d.k();
            com.tencent.bugly.crashreport.common.info.a aVar2 = this.f6576d;
            crashDetailBean.f6554f = aVar2.f6525i;
            crashDetailBean.f6555g = aVar2.u();
            crashDetailBean.f6561m = this.f6576d.g();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f6572f;
            crashDetailBean.q = aVar.f6573g;
            HashMap hashMap = new HashMap();
            crashDetailBean.S = hashMap;
            hashMap.put("BUGLY_CR_01", aVar.f6571e);
            String str = crashDetailBean.q;
            int indexOf = str != null ? str.indexOf("\n") : -1;
            crashDetailBean.p = indexOf > 0 ? crashDetailBean.q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.r = aVar.f6569c;
            String str2 = crashDetailBean.q;
            if (str2 != null) {
                crashDetailBean.u = ab.a(str2.getBytes());
            }
            crashDetailBean.z = aVar.b;
            crashDetailBean.A = aVar.a;
            crashDetailBean.B = "main(1)";
            crashDetailBean.L = this.f6576d.w();
            crashDetailBean.f6556h = this.f6576d.t();
            crashDetailBean.f6557i = this.f6576d.F();
            crashDetailBean.v = aVar.f6570d;
            com.tencent.bugly.crashreport.common.info.a aVar3 = this.f6576d;
            crashDetailBean.O = aVar3.f6529m;
            crashDetailBean.P = aVar3.a;
            crashDetailBean.Q = aVar3.a();
            if (!com.tencent.bugly.crashreport.common.info.b.o()) {
                this.f6578f.d(crashDetailBean);
            }
            crashDetailBean.T = this.f6576d.D();
            crashDetailBean.U = this.f6576d.E();
            crashDetailBean.V = this.f6576d.x();
            crashDetailBean.W = this.f6576d.C();
            crashDetailBean.y = aa.a();
        } catch (Throwable th) {
            if (!y.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    private synchronized void d(boolean z) {
        if (this.f6582j != z) {
            y.a("user change anr %b", Boolean.valueOf(z));
            this.f6582j = z;
        }
    }

    private synchronized void c(boolean z) {
        if (Build.VERSION.SDK_INT <= 19) {
            if (z) {
                c();
            } else {
                d();
            }
        } else if (z) {
            g();
        } else {
            h();
        }
    }

    private static boolean a(String str, String str2, String str3) {
        Map<String, String[]> map;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo != null && (map = readTargetDumpInfo.f6568d) != null && !map.isEmpty()) {
            StringBuilder sb = new StringBuilder(1024);
            String[] strArr = readTargetDumpInfo.f6568d.get("main");
            if (strArr != null && strArr.length >= 3) {
                sb.append("\"main\" tid=");
                sb.append(strArr[2]);
                sb.append(" :\n");
                sb.append(strArr[0]);
                sb.append("\n");
                sb.append(strArr[1]);
                sb.append("\n\n");
            }
            for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f6568d.entrySet()) {
                if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                    sb.append("\"");
                    sb.append(entry.getKey());
                    sb.append("\" tid=");
                    sb.append(entry.getValue()[2]);
                    sb.append(" :\n");
                    sb.append(entry.getValue()[0]);
                    sb.append("\n");
                    sb.append(entry.getValue()[1]);
                    sb.append("\n\n");
                }
            }
            return z.a(str2, sb.toString(), sb.length() * 2);
        }
        y.e("not found trace dump for %s", str3);
        return false;
    }

    public final boolean a() {
        return this.a.get();
    }

    private static String a(List<c> list, long j2) {
        if (list == null || list.isEmpty()) {
            return "main thread stack not enable";
        }
        StringBuilder sb = new StringBuilder(4096);
        sb.append("\n>>>>> 以下为anr过程中主线程堆栈记录，可根据堆栈出现次数推测在该堆栈阻塞的时间，出现次数越多对anr贡献越大，越可能是造成anr的原因 >>>>>\n");
        sb.append("\n>>>>> Thread Stack Traces Records Start >>>>>\n");
        for (int i2 = 0; i2 < list.size(); i2++) {
            c cVar = list.get(i2);
            sb.append("Thread name:");
            sb.append(cVar.b());
            sb.append("\n");
            long c2 = cVar.c() - j2;
            String str = c2 <= 0 ? "before " : "after ";
            sb.append("Got ");
            sb.append(str);
            sb.append("anr:");
            sb.append(Math.abs(c2));
            sb.append("ms\n");
            sb.append(cVar.a());
            sb.append("\n");
            if ((sb.length() << 1) >= 101376) {
                break;
            }
        }
        sb.append("\n<<<<< Thread Stack Traces Records End <<<<<\n");
        return sb.toString();
    }

    public final void a(boolean z) {
        d(z);
        boolean f2 = f();
        com.tencent.bugly.crashreport.common.strategy.a a = com.tencent.bugly.crashreport.common.strategy.a.a();
        if (a != null) {
            f2 = f2 && a.c().f6533e;
        }
        if (f2 != e()) {
            y.a("anr changed to %b", Boolean.valueOf(f2));
            c(f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0064 A[Catch: all -> 0x0209, TryCatch #4 {all -> 0x0209, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:16:0x0053, B:18:0x0064, B:21:0x0075, B:24:0x0080, B:26:0x0089, B:28:0x0094, B:30:0x0098, B:32:0x009d, B:34:0x00a1, B:36:0x00a6, B:38:0x00b2, B:39:0x00b6, B:43:0x00e6, B:45:0x0105, B:48:0x0112, B:50:0x013b, B:52:0x0169, B:53:0x016c, B:59:0x0178, B:60:0x0189, B:65:0x019a, B:67:0x01a0, B:76:0x01eb, B:77:0x01ed, B:68:0x01a8, B:70:0x01b5, B:72:0x01c4, B:74:0x01df, B:75:0x01e6, B:71:0x01bd, B:51:0x0153, B:64:0x0193, B:42:0x00e2, B:27:0x008c, B:19:0x006b, B:54:0x016d, B:56:0x0171, B:57:0x0175, B:78:0x01ee, B:80:0x01f2, B:81:0x01fe, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:99:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b A[Catch: all -> 0x0209, TryCatch #4 {all -> 0x0209, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:16:0x0053, B:18:0x0064, B:21:0x0075, B:24:0x0080, B:26:0x0089, B:28:0x0094, B:30:0x0098, B:32:0x009d, B:34:0x00a1, B:36:0x00a6, B:38:0x00b2, B:39:0x00b6, B:43:0x00e6, B:45:0x0105, B:48:0x0112, B:50:0x013b, B:52:0x0169, B:53:0x016c, B:59:0x0178, B:60:0x0189, B:65:0x019a, B:67:0x01a0, B:76:0x01eb, B:77:0x01ed, B:68:0x01a8, B:70:0x01b5, B:72:0x01c4, B:74:0x01df, B:75:0x01e6, B:71:0x01bd, B:51:0x0153, B:64:0x0193, B:42:0x00e2, B:27:0x008c, B:19:0x006b, B:54:0x016d, B:56:0x0171, B:57:0x0175, B:78:0x01ee, B:80:0x01f2, B:81:0x01fe, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:99:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0075 A[Catch: all -> 0x0209, TRY_LEAVE, TryCatch #4 {all -> 0x0209, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:16:0x0053, B:18:0x0064, B:21:0x0075, B:24:0x0080, B:26:0x0089, B:28:0x0094, B:30:0x0098, B:32:0x009d, B:34:0x00a1, B:36:0x00a6, B:38:0x00b2, B:39:0x00b6, B:43:0x00e6, B:45:0x0105, B:48:0x0112, B:50:0x013b, B:52:0x0169, B:53:0x016c, B:59:0x0178, B:60:0x0189, B:65:0x019a, B:67:0x01a0, B:76:0x01eb, B:77:0x01ed, B:68:0x01a8, B:70:0x01b5, B:72:0x01c4, B:74:0x01df, B:75:0x01e6, B:71:0x01bd, B:51:0x0153, B:64:0x0193, B:42:0x00e2, B:27:0x008c, B:19:0x006b, B:54:0x016d, B:56:0x0171, B:57:0x0175, B:78:0x01ee, B:80:0x01f2, B:81:0x01fe, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:99:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080 A[Catch: all -> 0x0209, TRY_ENTER, TryCatch #4 {all -> 0x0209, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:16:0x0053, B:18:0x0064, B:21:0x0075, B:24:0x0080, B:26:0x0089, B:28:0x0094, B:30:0x0098, B:32:0x009d, B:34:0x00a1, B:36:0x00a6, B:38:0x00b2, B:39:0x00b6, B:43:0x00e6, B:45:0x0105, B:48:0x0112, B:50:0x013b, B:52:0x0169, B:53:0x016c, B:59:0x0178, B:60:0x0189, B:65:0x019a, B:67:0x01a0, B:76:0x01eb, B:77:0x01ed, B:68:0x01a8, B:70:0x01b5, B:72:0x01c4, B:74:0x01df, B:75:0x01e6, B:71:0x01bd, B:51:0x0153, B:64:0x0193, B:42:0x00e2, B:27:0x008c, B:19:0x006b, B:54:0x016d, B:56:0x0171, B:57:0x0175, B:78:0x01ee, B:80:0x01f2, B:81:0x01fe, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:99:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a0 A[Catch: all -> 0x0209, TryCatch #4 {all -> 0x0209, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:16:0x0053, B:18:0x0064, B:21:0x0075, B:24:0x0080, B:26:0x0089, B:28:0x0094, B:30:0x0098, B:32:0x009d, B:34:0x00a1, B:36:0x00a6, B:38:0x00b2, B:39:0x00b6, B:43:0x00e6, B:45:0x0105, B:48:0x0112, B:50:0x013b, B:52:0x0169, B:53:0x016c, B:59:0x0178, B:60:0x0189, B:65:0x019a, B:67:0x01a0, B:76:0x01eb, B:77:0x01ed, B:68:0x01a8, B:70:0x01b5, B:72:0x01c4, B:74:0x01df, B:75:0x01e6, B:71:0x01bd, B:51:0x0153, B:64:0x0193, B:42:0x00e2, B:27:0x008c, B:19:0x006b, B:54:0x016d, B:56:0x0171, B:57:0x0175, B:78:0x01ee, B:80:0x01f2, B:81:0x01fe, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:99:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a8 A[Catch: all -> 0x0209, TryCatch #4 {all -> 0x0209, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:16:0x0053, B:18:0x0064, B:21:0x0075, B:24:0x0080, B:26:0x0089, B:28:0x0094, B:30:0x0098, B:32:0x009d, B:34:0x00a1, B:36:0x00a6, B:38:0x00b2, B:39:0x00b6, B:43:0x00e6, B:45:0x0105, B:48:0x0112, B:50:0x013b, B:52:0x0169, B:53:0x016c, B:59:0x0178, B:60:0x0189, B:65:0x019a, B:67:0x01a0, B:76:0x01eb, B:77:0x01ed, B:68:0x01a8, B:70:0x01b5, B:72:0x01c4, B:74:0x01df, B:75:0x01e6, B:71:0x01bd, B:51:0x0153, B:64:0x0193, B:42:0x00e2, B:27:0x008c, B:19:0x006b, B:54:0x016d, B:56:0x0171, B:57:0x0175, B:78:0x01ee, B:80:0x01f2, B:81:0x01fe, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:99:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ee A[Catch: all -> 0x0203, TRY_ENTER, TryCatch #4 {all -> 0x0209, blocks: (B:3:0x0007, B:4:0x0017, B:9:0x0029, B:11:0x0049, B:16:0x0053, B:18:0x0064, B:21:0x0075, B:24:0x0080, B:26:0x0089, B:28:0x0094, B:30:0x0098, B:32:0x009d, B:34:0x00a1, B:36:0x00a6, B:38:0x00b2, B:39:0x00b6, B:43:0x00e6, B:45:0x0105, B:48:0x0112, B:50:0x013b, B:52:0x0169, B:53:0x016c, B:59:0x0178, B:60:0x0189, B:65:0x019a, B:67:0x01a0, B:76:0x01eb, B:77:0x01ed, B:68:0x01a8, B:70:0x01b5, B:72:0x01c4, B:74:0x01df, B:75:0x01e6, B:71:0x01bd, B:51:0x0153, B:64:0x0193, B:42:0x00e2, B:27:0x008c, B:19:0x006b, B:54:0x016d, B:56:0x0171, B:57:0x0175, B:78:0x01ee, B:80:0x01f2, B:81:0x01fe, B:5:0x0018, B:7:0x001c, B:8:0x0028), top: B:99:0x0007 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(long r19, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.b.a(long, java.lang.String):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(long j2) {
        if (Math.abs(j2 - this.n) < com.heytap.mcssdk.constant.a.q) {
            y.d("should not process ANR too Fre in %dms", 10000);
            return true;
        }
        this.n = j2;
        return false;
    }
}
