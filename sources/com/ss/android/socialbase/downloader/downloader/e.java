package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import com.caverock.androidsvg.SVG;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class e {
    private static String b = "ResponseHandler";
    private long A;
    private long B;
    private long C;
    private long D;

    /* renamed from: c */
    private final DownloadInfo f5612c;

    /* renamed from: d */
    private final String f5613d;

    /* renamed from: e */
    private final com.ss.android.socialbase.downloader.model.b f5614e;

    /* renamed from: f */
    private final com.ss.android.socialbase.downloader.network.i f5615f;

    /* renamed from: g */
    private j f5616g;

    /* renamed from: h */
    private com.ss.android.socialbase.downloader.impls.k f5617h;

    /* renamed from: i */
    private t f5618i;

    /* renamed from: j */
    private com.ss.android.socialbase.downloader.model.e f5619j;

    /* renamed from: k */
    private BaseException f5620k;

    /* renamed from: l */
    private volatile boolean f5621l;

    /* renamed from: m */
    private volatile boolean f5622m;
    private final com.ss.android.socialbase.downloader.h.f n;
    private long o;
    private long p;
    private volatile long q;
    private volatile long r;
    private final boolean s;
    private final com.ss.android.socialbase.downloader.g.a t;
    private final com.ss.android.socialbase.downloader.a.a u;
    private final boolean v;
    private final long w;
    private final long x;
    private final boolean y;
    private boolean z;
    public boolean a = false;
    private volatile long E = 0;
    private volatile long F = 0;

    public e(DownloadInfo downloadInfo, String str, com.ss.android.socialbase.downloader.network.i iVar, com.ss.android.socialbase.downloader.model.b bVar, com.ss.android.socialbase.downloader.h.f fVar) {
        this.f5612c = downloadInfo;
        this.f5613d = str;
        j x = c.x();
        this.f5616g = x;
        if (x instanceof com.ss.android.socialbase.downloader.impls.d) {
            com.ss.android.socialbase.downloader.impls.d dVar = (com.ss.android.socialbase.downloader.impls.d) x;
            this.f5617h = dVar.a();
            this.f5618i = dVar.f();
        }
        this.f5615f = iVar;
        this.f5614e = bVar;
        this.n = fVar;
        long n = bVar.n();
        this.o = n;
        this.p = n;
        if (bVar.d()) {
            this.r = bVar.q();
        } else {
            this.r = bVar.c(false);
        }
        this.q = bVar.p();
        this.u = com.ss.android.socialbase.downloader.a.a.a();
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.t = a;
        boolean z = a.a("sync_strategy", 0) == 1;
        this.v = z;
        if (z) {
            this.w = Math.max(a.a("sync_interval_ms_fg", 5000), 500L);
            this.x = Math.max(a.a("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.w = 0L;
            this.x = 0L;
        }
        this.y = a.b("monitor_rw") == 1;
        this.s = com.ss.android.socialbase.downloader.i.a.a(65536);
    }

    private boolean b(long j2, long j3) {
        return j2 > SVG.D && j3 > 500;
    }

    private boolean f() {
        return this.f5621l || this.f5622m;
    }

    private void g() {
        ExecutorService l2;
        if (this.f5615f == null || (l2 = c.l()) == null) {
            return;
        }
        l2.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.e.1
            {
                e.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    e.this.f5615f.d();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void h() {
        boolean z;
        long nanoTime = this.y ? System.nanoTime() : 0L;
        try {
            this.f5619j.a();
            z = true;
        } catch (Exception unused) {
            z = false;
        }
        if (z) {
            this.f5612c.updateRealDownloadTime(true);
            boolean z2 = this.f5612c.getChunkCount() > 1;
            m a = com.ss.android.socialbase.downloader.impls.l.a(com.ss.android.socialbase.downloader.i.f.b());
            if (z2) {
                a(this.f5618i);
                if (a != null) {
                    a.c(this.f5612c);
                } else {
                    this.f5618i.a(this.f5612c.getId(), this.f5612c.getCurBytes());
                }
            } else if (a != null) {
                a.c(this.f5612c);
            } else {
                this.f5618i.a(this.f5614e.k(), this.o);
            }
            this.E = this.o;
        }
        if (this.y) {
            this.C += System.nanoTime() - nanoTime;
        }
    }

    public void b() {
        if (this.f5621l) {
            return;
        }
        this.f5621l = true;
        g();
    }

    public void c() {
        if (this.f5622m) {
            return;
        }
        synchronized (this.n) {
            this.f5622m = true;
        }
        g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:538:0x02e3 A[Catch: all -> 0x04dd, TRY_ENTER, TryCatch #27 {all -> 0x04dd, blocks: (B:538:0x02e3, B:539:0x02ea, B:568:0x0363, B:570:0x0369, B:571:0x036c, B:612:0x0458, B:613:0x045a, B:617:0x0461, B:619:0x0481, B:647:0x04d1, B:649:0x04d7, B:650:0x04da, B:651:0x04dc), top: B:697:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:541:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:568:0x0363 A[Catch: all -> 0x04dd, TRY_ENTER, TryCatch #27 {all -> 0x04dd, blocks: (B:538:0x02e3, B:539:0x02ea, B:568:0x0363, B:570:0x0369, B:571:0x036c, B:612:0x0458, B:613:0x045a, B:617:0x0461, B:619:0x0481, B:647:0x04d1, B:649:0x04d7, B:650:0x04da, B:651:0x04dc), top: B:697:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:597:0x03ea A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:598:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x0481 A[Catch: all -> 0x04dd, TRY_LEAVE, TryCatch #27 {all -> 0x04dd, blocks: (B:538:0x02e3, B:539:0x02ea, B:568:0x0363, B:570:0x0369, B:571:0x036c, B:612:0x0458, B:613:0x045a, B:617:0x0461, B:619:0x0481, B:647:0x04d1, B:649:0x04d7, B:650:0x04da, B:651:0x04dc), top: B:697:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:649:0x04d7 A[Catch: all -> 0x04dd, TryCatch #27 {all -> 0x04dd, blocks: (B:538:0x02e3, B:539:0x02ea, B:568:0x0363, B:570:0x0369, B:571:0x036c, B:612:0x0458, B:613:0x045a, B:617:0x0461, B:619:0x0481, B:647:0x04d1, B:649:0x04d7, B:650:0x04da, B:651:0x04dc), top: B:697:0x002b, inners: #28 }] */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v3, types: [int] */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d() throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.e.d():void");
    }

    public long e() {
        return this.E;
    }

    public long a() {
        return this.o;
    }

    public void a(long j2, long j3, long j4) {
        this.o = j2;
        this.p = j2;
        this.q = j3;
        this.r = j4;
    }

    public void a(long j2, long j3) {
        this.q = j2;
        this.r = j3;
    }

    private com.ss.android.socialbase.downloader.e.b a(InputStream inputStream) {
        int H = c.H();
        if (this.t.a("rw_concurrent", 0) == 1 && this.f5612c.getChunkCount() == 1 && this.f5612c.getTotalBytes() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.e.a aVar = new com.ss.android.socialbase.downloader.e.a(inputStream, H, this.t.a("rw_concurrent_max_buffer_count", 4));
                this.z = true;
                return aVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        com.ss.android.socialbase.downloader.e.c cVar = new com.ss.android.socialbase.downloader.e.c(inputStream, H);
        this.z = false;
        return cVar;
    }

    private void a(boolean z) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j2 = uptimeMillis - this.F;
        if (this.v) {
            if (j2 > (this.u.b() ? this.w : this.x)) {
                h();
                this.F = uptimeMillis;
                return;
            }
            return;
        }
        long j3 = this.o - this.E;
        if (z || b(j3, j2)) {
            h();
            this.F = uptimeMillis;
        }
    }

    private void a(j jVar) {
        com.ss.android.socialbase.downloader.model.b bVar;
        com.ss.android.socialbase.downloader.model.b bVar2;
        if (jVar == null) {
            return;
        }
        m mVar = null;
        boolean z = jVar instanceof com.ss.android.socialbase.downloader.b.e;
        if (z && (mVar = com.ss.android.socialbase.downloader.impls.l.a(com.ss.android.socialbase.downloader.i.f.b())) == null) {
            return;
        }
        m mVar2 = mVar;
        if (this.f5614e.d()) {
            bVar = this.f5614e.e();
        } else {
            bVar = this.f5614e;
        }
        com.ss.android.socialbase.downloader.model.b bVar3 = bVar;
        if (bVar3 != null) {
            bVar3.b(this.o);
            if (z && mVar2 != null) {
                mVar2.a(bVar3.k(), bVar3.s(), bVar3.b(), this.o);
                bVar2 = bVar3;
            } else {
                bVar2 = bVar3;
                jVar.a(bVar3.k(), bVar3.s(), bVar3.b(), this.o);
            }
            if (bVar2.h()) {
                boolean z2 = false;
                if (bVar2.i()) {
                    long j2 = bVar2.j();
                    if (j2 > this.o) {
                        if (z && mVar2 != null) {
                            mVar2.a(bVar2.k(), bVar2.b(), j2);
                        } else {
                            jVar.a(bVar2.k(), bVar2.b(), j2);
                        }
                        z2 = true;
                    }
                }
                if (z2) {
                    return;
                }
                if (z && mVar2 != null) {
                    mVar2.a(bVar2.k(), bVar2.b(), this.o);
                } else {
                    jVar.a(bVar2.k(), bVar2.b(), this.o);
                }
            }
        } else if (this.f5614e.d()) {
            if (z && mVar2 != null) {
                mVar2.a(this.f5614e.k(), this.f5614e.s(), this.o);
            } else {
                jVar.a(this.f5614e.k(), this.f5614e.s(), this.o);
            }
        }
    }
}
