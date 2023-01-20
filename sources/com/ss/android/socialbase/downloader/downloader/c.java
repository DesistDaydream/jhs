package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import com.ss.android.socialbase.downloader.depend.aa;
import com.ss.android.socialbase.downloader.depend.ab;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.ak;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c {
    private static volatile com.ss.android.socialbase.downloader.d.b A;
    private static volatile aa B;
    private static volatile com.ss.android.socialbase.downloader.network.f F;
    private static volatile com.ss.android.socialbase.downloader.network.f G;
    private static volatile u H;
    private static int K;
    private static final int L;
    private static final int M;
    private static final int N;
    private static final int O;
    private static int P;
    private static boolean Q;
    private static final List<com.ss.android.socialbase.downloader.depend.k> R;
    private static final List<ab> S;
    private static int T;
    private static boolean U;
    private static boolean V;
    private static r W;
    private static com.ss.android.socialbase.downloader.d.c X;
    private static volatile boolean Y;
    private static volatile Context a;
    private static volatile j b;

    /* renamed from: c */
    private static volatile k f5598c;

    /* renamed from: d */
    private static volatile h f5599d;

    /* renamed from: e */
    private static volatile af f5600e;

    /* renamed from: f */
    private static volatile com.ss.android.socialbase.downloader.impls.a f5601f;

    /* renamed from: g */
    private static volatile o f5602g;

    /* renamed from: h */
    private static volatile o f5603h;

    /* renamed from: i */
    private static volatile a f5604i;

    /* renamed from: j */
    private static volatile IDownloadHttpService f5605j;

    /* renamed from: k */
    private static volatile com.ss.android.socialbase.downloader.network.h f5606k;

    /* renamed from: l */
    private static volatile IDownloadHttpService f5607l;

    /* renamed from: m */
    private static volatile com.ss.android.socialbase.downloader.network.h f5608m;
    private static volatile l n;
    private static volatile ExecutorService o;
    private static volatile ExecutorService p;
    private static volatile ExecutorService q;
    private static volatile ExecutorService r;
    private static volatile ExecutorService s;
    private static volatile ExecutorService t;
    private static volatile ExecutorService u;
    private static volatile ExecutorService v;
    private static volatile g w;
    private static volatile DownloadReceiver x;
    private static volatile s y;
    private static volatile q z;
    private static volatile List<ak> C = new ArrayList();
    private static volatile boolean D = false;
    private static volatile OkHttpClient E = null;
    private static final List<com.ss.android.socialbase.downloader.depend.m> I = new ArrayList();
    private static boolean J = false;

    /* loaded from: classes3.dex */
    public interface a {

        /* renamed from: com.ss.android.socialbase.downloader.downloader.c$a$a */
        /* loaded from: classes3.dex */
        public interface InterfaceC0207a {
            void a();
        }

        o a();

        t a(InterfaceC0207a interfaceC0207a);

        m b();
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        L = availableProcessors;
        M = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        N = availableProcessors;
        O = availableProcessors;
        P = 8192;
        R = new ArrayList();
        S = new ArrayList();
        U = true;
        V = false;
        Y = false;
    }

    private c() {
    }

    public static List<com.ss.android.socialbase.downloader.depend.m> A() {
        return I;
    }

    public static k B() {
        if (f5598c == null) {
            synchronized (c.class) {
                if (f5598c == null) {
                    f5598c = new com.ss.android.socialbase.downloader.impls.i();
                }
            }
        }
        return f5598c;
    }

    public static com.ss.android.socialbase.downloader.impls.a C() {
        if (f5601f == null) {
            synchronized (c.class) {
                if (f5601f == null) {
                    f5601f = new com.ss.android.socialbase.downloader.impls.e();
                }
            }
        }
        return f5601f;
    }

    public static int D() {
        return T;
    }

    @NonNull
    public static JSONObject E() {
        return (B == null || B.a() == null) ? com.ss.android.socialbase.downloader.constants.e.f5575i : B.a();
    }

    public static void F() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.e.f5569c)) {
            com.ss.android.socialbase.downloader.constants.e.f5569c = "oppo";
            com.ss.android.socialbase.downloader.constants.e.b = com.ss.android.socialbase.downloader.constants.e.f5569c.toUpperCase();
        }
    }

    public static boolean G() {
        return U;
    }

    public static synchronized int H() {
        int i2;
        synchronized (c.class) {
            i2 = P;
        }
        return i2;
    }

    public static h I() {
        if (f5599d == null) {
            synchronized (c.class) {
                if (f5599d == null) {
                    f5599d = new com.ss.android.socialbase.downloader.impls.c();
                }
            }
        }
        return f5599d;
    }

    public static af J() {
        return f5600e;
    }

    public static g K() {
        if (w == null) {
            synchronized (c.class) {
                if (w == null) {
                    w = new com.ss.android.socialbase.downloader.impls.b();
                }
            }
        }
        return w;
    }

    public static s L() {
        if (y == null) {
            synchronized (c.class) {
                if (y == null) {
                    y = new com.ss.android.socialbase.downloader.impls.j();
                }
            }
        }
        return y;
    }

    public static u M() {
        if (H == null) {
            synchronized (c.class) {
                if (H == null) {
                    H = new u.a();
                }
            }
        }
        return H;
    }

    public static synchronized Context N() {
        Context context;
        synchronized (c.class) {
            context = a;
        }
        return context;
    }

    public static synchronized boolean O() {
        boolean z2;
        synchronized (c.class) {
            z2 = Q;
        }
        return z2;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.d.c P() {
        if (X == null) {
            X = new com.ss.android.socialbase.downloader.d.c() { // from class: com.ss.android.socialbase.downloader.downloader.c.3
                @Override // com.ss.android.socialbase.downloader.d.c
                public void a(int i2, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.d.c
                public void b(int i2, String str, JSONObject jSONObject) {
                }
            };
        }
        return X;
    }

    public static r Q() {
        return W;
    }

    public static boolean R() {
        return Y;
    }

    public static boolean S() {
        StringBuilder sb = new StringBuilder();
        sb.append("supportMultiProc::=");
        sb.append(f5604i != null);
        com.ss.android.socialbase.downloader.c.a.a("wjd", sb.toString());
        return f5604i != null;
    }

    public static a T() {
        return f5604i;
    }

    private static void U() {
        if (x == null) {
            x = new DownloadReceiver();
        }
        if (J) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            a.registerReceiver(x, intentFilter);
            J = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        return a(downloadInfo.getUrl(), downloadInfo.getSavePath());
    }

    public static int a(String str, String str2) {
        k B2 = B();
        if (B2 == null) {
            return 0;
        }
        return B2.a(str, str2);
    }

    public static com.ss.android.socialbase.downloader.network.g a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        return a(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.g a(String str, List<com.ss.android.socialbase.downloader.model.c> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        com.ss.android.socialbase.downloader.network.g b2;
        Exception e2 = null;
        for (int i3 : a(i2)) {
            try {
                b2 = b(str, list, i3, z2, downloadInfo);
            } catch (Exception e3) {
                e2 = e3;
            }
            if (b2 != null) {
                return b2;
            }
        }
        if (e2 == null) {
            return null;
        }
        throw e2;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.network.i a(int r11, java.lang.String r12, java.lang.String r13, java.util.List<com.ss.android.socialbase.downloader.model.c> r14, int r15, boolean r16, com.ss.android.socialbase.downloader.model.DownloadInfo r17) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r7 = r15
            r0 = 1
            if (r7 != r0) goto L9
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = d()
            goto Ld
        L9:
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = h()
        Ld:
            if (r0 == 0) goto L57
            r1 = 0
            r2 = 0
            r3 = 0
            if (r16 == 0) goto L20
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1d
            goto L20
        L1a:
            r0 = move-exception
            r6 = r12
            goto L3e
        L1d:
            r0 = move-exception
            r6 = r12
            goto L41
        L20:
            r5 = r11
            r6 = r12
            r8 = r14
            com.ss.android.socialbase.downloader.network.i r0 = r0.downloadWithConnection(r11, r12, r14)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L40
            if (r16 == 0) goto L3c
            long r1 = java.lang.System.currentTimeMillis()
            long r4 = r1 - r3
            r8 = 0
            java.lang.String r9 = "get"
            r1 = r0
            r2 = r12
            r3 = r13
            r6 = r9
            r7 = r15
            r9 = r17
            com.ss.android.socialbase.downloader.d.a.a(r1, r2, r3, r4, r6, r7, r8, r9)
        L3c:
            return r0
        L3d:
            r0 = move-exception
        L3e:
            r8 = r2
            goto L43
        L40:
            r0 = move-exception
        L41:
            r2 = r0
            throw r2     // Catch: java.lang.Throwable -> L3d
        L43:
            if (r16 == 0) goto L56
            long r9 = java.lang.System.currentTimeMillis()
            long r4 = r9 - r3
            java.lang.String r9 = "get"
            r2 = r12
            r3 = r13
            r6 = r9
            r7 = r15
            r9 = r17
            com.ss.android.socialbase.downloader.d.a.a(r1, r2, r3, r4, r6, r7, r8, r9)
        L56:
            throw r0
        L57:
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            r1 = 1022(0x3fe, float:1.432E-42)
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "httpService not exist, netLib = "
            r3.append(r4)
            r3.append(r15)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.c.a(int, java.lang.String, java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.i");
    }

    public static com.ss.android.socialbase.downloader.network.i a(boolean z2, int i2, String str, String str2, List<com.ss.android.socialbase.downloader.model.c> list, int i3, boolean z3, DownloadInfo downloadInfo) throws Exception {
        List<com.ss.android.socialbase.downloader.model.c> list2;
        int i4;
        com.ss.android.socialbase.downloader.network.i a2;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.model.c> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.model.c("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i4 = 1;
        } else if (z2) {
            list2 = list;
            i4 = i3;
        } else {
            i4 = 2;
            list2 = list;
        }
        int[] a3 = a(i4);
        Exception exc = null;
        for (int i5 : a3) {
            try {
                a2 = a(i2, str, str2, list2, i5, z3, downloadInfo);
            } catch (Exception e2) {
                if (downloadInfo.isExpiredRedownload() && com.ss.android.socialbase.downloader.i.f.g(e2) && com.ss.android.socialbase.downloader.i.f.c(list2)) {
                    com.ss.android.socialbase.downloader.c.a.a("dcach::http exception 304, throw excepiton, not retry " + e2);
                    throw e2;
                }
                exc = e2;
            }
            if (a2 != null) {
                return a2;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    public static com.ss.android.socialbase.downloader.network.i a(boolean z2, int i2, String str, List<com.ss.android.socialbase.downloader.model.c> list) throws Exception {
        return a(z2, i2, str, null, list, 0, false, null);
    }

    public static synchronized void a() {
        synchronized (c.class) {
            try {
                if (J && x != null && a != null) {
                    a.unregisterReceiver(x);
                    J = false;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static synchronized void a(Context context) {
        synchronized (c.class) {
            if (context != null) {
                if (a == null) {
                    a = context.getApplicationContext();
                    com.ss.android.socialbase.downloader.a.a.a().a(a);
                }
            }
        }
    }

    public static void a(com.ss.android.socialbase.downloader.constants.d dVar) {
        List<com.ss.android.socialbase.downloader.depend.k> list = R;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.depend.k kVar : list) {
                if (kVar != null) {
                    if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_START) {
                        kVar.a();
                    } else if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                        kVar.b();
                    }
                }
            }
            if (dVar == com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS) {
                R.clear();
            }
        }
    }

    private static void a(com.ss.android.socialbase.downloader.d.b bVar) {
        if (bVar != null) {
            A = bVar;
        }
    }

    public static void a(com.ss.android.socialbase.downloader.d.c cVar) {
        X = cVar;
    }

    public static void a(aa aaVar) {
        B = aaVar;
        com.ss.android.socialbase.downloader.g.a.a();
    }

    public static void a(af afVar) {
        if (afVar != null) {
            f5600e = afVar;
        }
    }

    public static void a(ak akVar) {
        if (akVar == null) {
            return;
        }
        synchronized (C) {
            C.add(akVar);
        }
    }

    public static void a(com.ss.android.socialbase.downloader.depend.k kVar) {
        List<com.ss.android.socialbase.downloader.depend.k> list = R;
        synchronized (list) {
            if (kVar != null) {
                if (!list.contains(kVar)) {
                    list.add(kVar);
                }
            }
        }
    }

    public static synchronized void a(DownloaderBuilder downloaderBuilder) {
        synchronized (c.class) {
            if (Y) {
                com.ss.android.socialbase.downloader.c.a.e("DownloadComponentManager", "component has init");
                return;
            }
            boolean z2 = D;
            c(downloaderBuilder);
            if (b == null) {
                b = new com.ss.android.socialbase.downloader.impls.d();
            }
            if (f5602g == null) {
                f5602g = new com.ss.android.socialbase.downloader.impls.h();
            }
            if (f5603h == null && f5604i != null) {
                f5603h = f5604i.a();
            }
            if (f5598c == null) {
                f5598c = new com.ss.android.socialbase.downloader.impls.i();
            }
            if (f5601f == null) {
                f5601f = new com.ss.android.socialbase.downloader.impls.e();
            }
            if (f5599d == null) {
                f5599d = new com.ss.android.socialbase.downloader.impls.c();
            }
            if (w == null) {
                w = new com.ss.android.socialbase.downloader.impls.b();
            }
            if (y == null) {
                y = new com.ss.android.socialbase.downloader.impls.j();
            }
            int i2 = K;
            if (i2 <= 0 || i2 > L) {
                K = L;
            }
            U();
            if (D && !z2 && !com.ss.android.socialbase.downloader.i.f.c()) {
                com.ss.android.socialbase.downloader.impls.l.a(true).startService();
            } else if (com.ss.android.socialbase.downloader.i.f.d()) {
                ExecutorService m2 = m();
                if (m2 != null) {
                    m2.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Context N2 = c.N();
                            if (N2 != null) {
                                com.ss.android.socialbase.downloader.i.f.d(N2);
                            }
                        }
                    });
                }
            } else {
                Context N2 = N();
                if (N2 != null) {
                    com.ss.android.socialbase.downloader.i.f.d(N2);
                }
            }
            F();
            Y = true;
        }
    }

    public static void a(a aVar) {
        com.ss.android.socialbase.downloader.c.a.a("wjd", "setIndependentServiceCreator::creator=" + aVar);
        f5604i = aVar;
    }

    private static void a(g gVar) {
        if (gVar != null) {
            w = gVar;
        }
    }

    private static void a(h hVar) {
        if (hVar != null) {
            f5599d = hVar;
        }
    }

    private static void a(j jVar) {
        if (jVar != null) {
            b = jVar;
        }
    }

    private static void a(k kVar) {
        if (kVar != null) {
            f5598c = kVar;
        }
    }

    public static synchronized void a(l lVar) {
        synchronized (c.class) {
            if (lVar != null) {
                n = lVar;
                if (b instanceof com.ss.android.socialbase.downloader.impls.d) {
                    ((com.ss.android.socialbase.downloader.impls.d) b).h();
                }
            }
        }
    }

    public static void a(r rVar) {
    }

    public static void a(DownloadTask downloadTask, int i2) {
        List<ab> list = S;
        synchronized (list) {
            for (ab abVar : list) {
                if (abVar != null) {
                    abVar.a(downloadTask, i2);
                }
            }
        }
    }

    public static void a(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            f5605j = iDownloadHttpService;
        }
        Q = f5605j != null;
    }

    public static void a(com.ss.android.socialbase.downloader.network.h hVar) {
        if (hVar != null) {
            f5606k = hVar;
        }
    }

    public static void a(Runnable runnable) {
        b(runnable, false);
    }

    public static void a(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (!z2 || com.ss.android.socialbase.downloader.i.f.d()) {
            l().execute(runnable);
        } else {
            runnable.run();
        }
    }

    private static void a(List<com.ss.android.socialbase.downloader.depend.m> list) {
        List<com.ss.android.socialbase.downloader.depend.m> list2 = I;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void a(ExecutorService executorService) {
        if (executorService != null) {
            u = executorService;
        }
    }

    public static void a(boolean z2) {
        V = z2;
    }

    private static int[] a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.network.g b(java.lang.String r12, java.util.List<com.ss.android.socialbase.downloader.model.c> r13, int r14, boolean r15, com.ss.android.socialbase.downloader.model.DownloadInfo r16) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r7 = r14
            r0 = 1
            if (r7 != r0) goto L9
            com.ss.android.socialbase.downloader.network.h r0 = f()
            goto Ld
        L9:
            com.ss.android.socialbase.downloader.network.h r0 = i()
        Ld:
            if (r0 == 0) goto L5a
            r1 = 0
            r2 = 0
            r3 = 0
            if (r15 == 0) goto L20
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1d
            goto L20
        L1a:
            r0 = move-exception
            r5 = r12
            goto L40
        L1d:
            r0 = move-exception
            r5 = r12
            goto L43
        L20:
            r5 = r12
            r6 = r13
            com.ss.android.socialbase.downloader.network.g r0 = r0.a(r12, r13)     // Catch: java.lang.Throwable -> L3f java.io.IOException -> L42
            if (r15 == 0) goto L3e
            r6 = 0
            long r1 = java.lang.System.currentTimeMillis()
            long r8 = r1 - r3
            r10 = 0
            java.lang.String r11 = "head"
            r1 = r0
            r2 = r12
            r3 = r6
            r4 = r8
            r6 = r11
            r7 = r14
            r8 = r10
            r9 = r16
            com.ss.android.socialbase.downloader.d.a.a(r1, r2, r3, r4, r6, r7, r8, r9)
        L3e:
            return r0
        L3f:
            r0 = move-exception
        L40:
            r8 = r2
            goto L45
        L42:
            r0 = move-exception
        L43:
            r2 = r0
            throw r2     // Catch: java.lang.Throwable -> L3f
        L45:
            if (r15 == 0) goto L59
            r6 = 0
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r3
            java.lang.String r11 = "head"
            r2 = r12
            r3 = r6
            r4 = r9
            r6 = r11
            r7 = r14
            r9 = r16
            com.ss.android.socialbase.downloader.d.a.a(r1, r2, r3, r4, r6, r7, r8, r9)
        L59:
            throw r0
        L5a:
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            r1 = 1022(0x3fe, float:1.432E-42)
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "httpService not exist, netLib = "
            r3.append(r4)
            r3.append(r14)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.c.b(java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.g");
    }

    public static synchronized void b() {
        synchronized (c.class) {
            if (D) {
                return;
            }
            D = true;
            Intent intent = new Intent(N(), DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            N().startService(intent);
            if (!com.ss.android.socialbase.downloader.i.f.c()) {
                com.ss.android.socialbase.downloader.impls.l.a(true).startService();
            }
        }
    }

    private static void b(int i2) {
        if (i2 > 0) {
            K = i2;
        }
    }

    public static void b(com.ss.android.socialbase.downloader.depend.k kVar) {
        List<com.ss.android.socialbase.downloader.depend.k> list = R;
        synchronized (list) {
            if (kVar != null) {
                if (list.contains(kVar)) {
                    list.remove(kVar);
                }
            }
        }
    }

    public static synchronized void b(DownloaderBuilder downloaderBuilder) {
        synchronized (c.class) {
            c(downloaderBuilder);
        }
    }

    public static void b(DownloadTask downloadTask, int i2) {
        List<ab> list = S;
        synchronized (list) {
            for (ab abVar : list) {
                if (abVar != null) {
                    abVar.b(downloadTask, i2);
                }
            }
        }
    }

    public static void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (com.ss.android.socialbase.downloader.i.f.d()) {
            r().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void b(Runnable runnable, boolean z2) {
        if (runnable == null) {
            return;
        }
        if (!z2 || com.ss.android.socialbase.downloader.i.f.d()) {
            m().execute(runnable);
        } else {
            runnable.run();
        }
    }

    public static void b(ExecutorService executorService) {
        if (executorService != null) {
            v = executorService;
        }
    }

    private static void b(boolean z2) {
        U = z2;
    }

    private static void c(DownloaderBuilder downloaderBuilder) {
        com.ss.android.socialbase.downloader.network.h i2;
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                a(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                a(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                a(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                a(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                a(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                b(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                a(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                a(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                a(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                c(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                d(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                e(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                f(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                g(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                h(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                a(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                b(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                a(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                z = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                P = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                a(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                D = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                T = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                a(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                F = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                H = downloaderBuilder.getTTNetHandler();
                if (H.a()) {
                    a(H.b());
                    i2 = H.c();
                } else {
                    a(h());
                    i2 = i();
                }
                a(i2);
            }
            b(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                a(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    private static void c(ExecutorService executorService) {
        if (executorService != null) {
            o = executorService;
        }
    }

    public static synchronized boolean c() {
        boolean z2;
        synchronized (c.class) {
            z2 = D;
        }
        return z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c1663646904304dc(java.lang.String r2) {
        /*
        L0:
            r0 = 74
            r1 = 55
        L4:
            switch(r0) {
                case 72: goto L0;
                case 73: goto L8;
                case 74: goto Lb;
                default: goto L7;
            }
        L7:
            goto L2b
        L8:
            switch(r1) {
                case 94: goto L26;
                case 95: goto Lf;
                case 96: goto Lf;
                default: goto Lb;
            }
        Lb:
            switch(r1) {
                case 55: goto L26;
                case 56: goto L26;
                case 57: goto Lf;
                default: goto Le;
            }
        Le:
            goto L26
        Lf:
            char[] r2 = r2.toCharArray()
            r0 = 0
        L14:
            int r1 = r2.length
            if (r0 >= r1) goto L20
            char r1 = r2[r0]
            r1 = r1 ^ r0
            char r1 = (char) r1
            r2[r0] = r1
            int r0 = r0 + 1
            goto L14
        L20:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            return r0
        L26:
            r0 = 73
            r1 = 96
            goto L4
        L2b:
            r0 = 72
            goto L4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.c.c1663646904304dc(java.lang.String):java.lang.String");
    }

    public static IDownloadHttpService d() {
        return f5605j;
    }

    private static void d(ExecutorService executorService) {
        if (executorService != null) {
            p = executorService;
        }
    }

    public static List<ak> e() {
        List<ak> list;
        synchronized (C) {
            list = C;
        }
        return list;
    }

    private static void e(ExecutorService executorService) {
        if (executorService != null) {
            q = executorService;
        }
    }

    public static com.ss.android.socialbase.downloader.network.h f() {
        return f5606k;
    }

    private static void f(ExecutorService executorService) {
        if (executorService != null) {
            r = executorService;
        }
    }

    public static com.ss.android.socialbase.downloader.d.b g() {
        return A;
    }

    private static void g(ExecutorService executorService) {
        if (executorService != null) {
            s = executorService;
        }
    }

    public static IDownloadHttpService h() {
        if (f5607l == null) {
            synchronized (c.class) {
                if (f5607l == null) {
                    f5607l = new com.ss.android.socialbase.downloader.impls.g();
                }
            }
        }
        return f5607l;
    }

    private static void h(ExecutorService executorService) {
        if (executorService != null) {
            t = executorService;
        }
    }

    public static com.ss.android.socialbase.downloader.network.h i() {
        if (f5608m == null) {
            synchronized (c.class) {
                if (f5608m == null) {
                    f5608m = new com.ss.android.socialbase.downloader.impls.f();
                }
            }
        }
        return f5608m;
    }

    public static boolean j() {
        return com.ss.android.socialbase.downloader.g.a.c().a("switch_not_auto_boot_service", V ? 1 : 0) > 0;
    }

    public static synchronized q k() {
        q qVar;
        synchronized (c.class) {
            qVar = z;
        }
        return qVar;
    }

    public static ExecutorService l() {
        if (o == null) {
            synchronized (c.class) {
                if (o == null) {
                    int i2 = L;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-cpu-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    o = threadPoolExecutor;
                }
            }
        }
        return o;
    }

    public static ExecutorService m() {
        return p != null ? p : l();
    }

    public static ExecutorService n() {
        return r != null ? r : p();
    }

    public static ExecutorService o() {
        return s != null ? s : p();
    }

    public static ExecutorService p() {
        if (q == null) {
            synchronized (c.class) {
                if (q == null) {
                    int i2 = N;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-mix-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    q = threadPoolExecutor;
                }
            }
        }
        return q;
    }

    public static ExecutorService q() {
        if (u == null) {
            synchronized (c.class) {
                if (u == null) {
                    int i2 = M;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-chunk-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    u = threadPoolExecutor;
                }
            }
        }
        return u;
    }

    public static ExecutorService r() {
        if (t == null) {
            synchronized (c.class) {
                if (t == null) {
                    int i2 = O;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i2, i2, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.h.a("DownloadThreadPool-db-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    t = threadPoolExecutor;
                }
            }
        }
        return t;
    }

    public static OkHttpClient s() {
        if (E == null) {
            synchronized (c.class) {
                if (E == null) {
                    E = t().build();
                }
            }
        }
        return E;
    }

    public static OkHttpClient.Builder t() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS, timeUnit).readTimeout(JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS, timeUnit).writeTimeout(JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS, timeUnit).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (v != null) {
            builder.dispatcher(new Dispatcher(v));
        }
        return builder;
    }

    public static com.ss.android.socialbase.downloader.network.f u() {
        return F;
    }

    public static com.ss.android.socialbase.downloader.network.f v() {
        if (G == null) {
            synchronized (c.class) {
                if (G == null) {
                    G = new com.ss.android.socialbase.downloader.network.f() { // from class: com.ss.android.socialbase.downloader.downloader.c.2
                        @Override // com.ss.android.socialbase.downloader.network.f
                        public List<InetAddress> a(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return G;
    }

    public static synchronized l w() {
        l lVar;
        synchronized (c.class) {
            lVar = n;
        }
        return lVar;
    }

    public static j x() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new com.ss.android.socialbase.downloader.impls.d();
                }
            }
        }
        return b;
    }

    public static o y() {
        if (f5602g == null) {
            synchronized (c.class) {
                if (f5602g == null) {
                    f5602g = new com.ss.android.socialbase.downloader.impls.h();
                }
            }
        }
        return f5602g;
    }

    public static o z() {
        if (f5603h == null) {
            synchronized (c.class) {
                if (f5603h == null) {
                    f5603h = f5604i.a();
                }
            }
        }
        return f5603h;
    }
}
