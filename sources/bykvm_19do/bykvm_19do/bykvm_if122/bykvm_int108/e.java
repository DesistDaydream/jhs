package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.v;
import com.bytedance.msdk.adapter.util.Logger;

/* loaded from: classes.dex */
public class e {
    private static Context a;
    private static a b;

    /* renamed from: c */
    private static a f987c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: c */
        private final String f988c;

        /* renamed from: d */
        private final long f989d;

        /* renamed from: e */
        private final int f990e;

        /* renamed from: f */
        private final int f991f;
        private volatile boolean b = false;

        /* renamed from: h */
        private int f993h = 0;

        /* renamed from: g */
        private final long f992g = System.currentTimeMillis();
        private final Handler a = new Handler(Looper.getMainLooper());

        /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e$a$a */
        /* loaded from: classes.dex */
        public class RunnableC0047a implements Runnable {
            public RunnableC0047a() {
                a.this = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.b(v.d(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()));
                a.d(a.this);
                if (a.this.f993h >= 5 || e.d()) {
                    a.this.a(1);
                    return;
                }
                Logger.d("TMe", "--==-- 重试一次 eventType:" + a.this.f988c + ", 重试次数：" + a.this.f993h);
                a.this.a();
            }
        }

        public a(String str, long j2, int i2, int i3) {
            this.f988c = str;
            this.f989d = j2;
            this.f990e = i2;
            this.f991f = i3;
        }

        public void a() {
            this.a.postDelayed(new RunnableC0047a(), 500L);
        }

        /* JADX WARN: Code restructure failed: missing block: B:59:0x008d, code lost:
            if (r1 != 1) goto L6;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x008f, code lost:
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(r8.f989d, r8.f990e, r8.f991f, r8.f992g);
         */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0082 A[Catch: all -> 0x00a2, TryCatch #0 {, blocks: (B:37:0x0001, B:40:0x000d, B:42:0x0012, B:43:0x003d, B:47:0x0066, B:60:0x008f, B:61:0x009b, B:52:0x0078, B:55:0x0082, B:46:0x0044), top: B:67:0x0001 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(int r9) {
            /*
                r8 = this;
                monitor-enter(r8)
                android.os.Handler r0 = r8.a     // Catch: java.lang.Throwable -> La2
                r1 = 0
                r0.removeCallbacksAndMessages(r1)     // Catch: java.lang.Throwable -> La2
                boolean r0 = r8.b     // Catch: java.lang.Throwable -> La2
                if (r0 == 0) goto Ld
                goto La0
            Ld:
                r0 = 1
                r8.b = r0     // Catch: java.lang.Throwable -> La2
                if (r9 != r0) goto L41
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La2
                r9.<init>()     // Catch: java.lang.Throwable -> La2
                java.lang.String r1 = "TMe"
                java.lang.String r2 = "--==-- 最终上报：eventType:"
                r9.append(r2)     // Catch: java.lang.Throwable -> La2
                java.lang.String r2 = r8.f988c     // Catch: java.lang.Throwable -> La2
                r9.append(r2)     // Catch: java.lang.Throwable -> La2
                java.lang.String r2 = ", 重试次数："
                r9.append(r2)     // Catch: java.lang.Throwable -> La2
                int r2 = r8.f993h     // Catch: java.lang.Throwable -> La2
                r9.append(r2)     // Catch: java.lang.Throwable -> La2
                java.lang.String r2 = ", did: "
                r9.append(r2)     // Catch: java.lang.Throwable -> La2
                java.lang.String r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.a()     // Catch: java.lang.Throwable -> La2
                r9.append(r2)     // Catch: java.lang.Throwable -> La2
                java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> La2
            L3d:
                com.bytedance.msdk.adapter.util.Logger.d(r1, r9)     // Catch: java.lang.Throwable -> La2
                goto L66
            L41:
                r1 = 2
                if (r9 != r1) goto L66
                java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La2
                r9.<init>()     // Catch: java.lang.Throwable -> La2
                java.lang.String r1 = "TMe"
                java.lang.String r2 = "--==-- 最终上报：eventType:"
                r9.append(r2)     // Catch: java.lang.Throwable -> La2
                java.lang.String r2 = r8.f988c     // Catch: java.lang.Throwable -> La2
                r9.append(r2)     // Catch: java.lang.Throwable -> La2
                java.lang.String r2 = ", 从applog回调中上报, did: "
                r9.append(r2)     // Catch: java.lang.Throwable -> La2
                java.lang.String r2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.a()     // Catch: java.lang.Throwable -> La2
                r9.append(r2)     // Catch: java.lang.Throwable -> La2
                java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> La2
                goto L3d
            L66:
                java.lang.String r9 = r8.f988c     // Catch: java.lang.Throwable -> La2
                r1 = -1
                int r2 = r9.hashCode()     // Catch: java.lang.Throwable -> La2
                r3 = -834688111(0xffffffffce3fab91, float:-8.0392301E8)
                if (r2 == r3) goto L82
                r3 = 270071285(0x1018f5f5, float:3.0166193E-29)
                if (r2 == r3) goto L78
                goto L8b
            L78:
                java.lang.String r2 = "sdk_init"
                boolean r9 = r9.equals(r2)     // Catch: java.lang.Throwable -> La2
                if (r9 == 0) goto L8b
                r1 = 0
                goto L8b
            L82:
                java.lang.String r2 = "sdk_init_end"
                boolean r9 = r9.equals(r2)     // Catch: java.lang.Throwable -> La2
                if (r9 == 0) goto L8b
                r1 = 1
            L8b:
                if (r1 == 0) goto L9b
                if (r1 != r0) goto La0
                long r2 = r8.f989d     // Catch: java.lang.Throwable -> La2
                int r4 = r8.f990e     // Catch: java.lang.Throwable -> La2
                int r5 = r8.f991f     // Catch: java.lang.Throwable -> La2
                long r6 = r8.f992g     // Catch: java.lang.Throwable -> La2
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.a(r2, r4, r5, r6)     // Catch: java.lang.Throwable -> La2
                goto La0
            L9b:
                long r0 = r8.f992g     // Catch: java.lang.Throwable -> La2
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.h.b(r0)     // Catch: java.lang.Throwable -> La2
            La0:
                monitor-exit(r8)
                return
            La2:
                r9 = move-exception
                monitor-exit(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_int108.e.a.a(int):void");
        }

        public static /* synthetic */ int d(a aVar) {
            int i2 = aVar.f993h;
            aVar.f993h = i2 + 1;
            return i2;
        }
    }

    public static void a(long j2, int i2, int i3) {
        a aVar = new a("sdk_init_end", j2, i2, i3);
        f987c = aVar;
        aVar.a();
    }

    public static void a(Context context) {
        a = context;
    }

    private static Context b() {
        Context context = a;
        return context != null ? context : bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c0.a("tt_device_info", b()).b("did", str);
    }

    public static String c() {
        return c0.a("tt_device_info", b()).a("did", (String) null);
    }

    public static boolean d() {
        return !TextUtils.isEmpty(c0.a("tt_device_info", b()).a("did", (String) null));
    }

    public static void e() {
        a aVar = new a("sdk_init", 0L, 0, 0);
        b = aVar;
        aVar.a();
    }

    public static void f() {
        a aVar = b;
        if (aVar == null) {
            Logger.d("TMe", "--==-- sdkInit埋点还未产生，applog回调已触发，直接return");
            return;
        }
        if (aVar.b) {
            Logger.d("TMe", "--==-- applog回调触发时，sdkInit埋点已经上报，直接return");
        } else {
            b.a(2);
        }
        b = null;
    }

    public static void g() {
        a aVar = f987c;
        if (aVar == null) {
            Logger.d("TMe", "--==-- sdkInitEnd埋点还未产生，applog回调已触发，直接return");
            return;
        }
        if (aVar.b) {
            Logger.d("TMe", "--==-- applog回调触发时，sdkInitEnd埋点已经上报，直接return");
        } else {
            f987c.a(2);
        }
        f987c = null;
    }
}
