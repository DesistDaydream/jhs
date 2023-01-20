package com.ss.android.socialbase.downloader.f;

import com.caverock.androidsvg.SVG;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    private final DownloadInfo f5657c;

    /* renamed from: e  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.g.a f5659e;

    /* renamed from: f  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.h.f f5660f;

    /* renamed from: g  reason: collision with root package name */
    private final c f5661g;

    /* renamed from: h  reason: collision with root package name */
    private BaseException f5662h;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f5667m;
    private final long n;
    private final long o;
    private final boolean p;
    private long q;
    private final List<l> a = new LinkedList();
    private final List<l> b = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private volatile boolean f5663i = false;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f5664j = false;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f5665k = false;
    private volatile long r = 0;
    private volatile long s = 0;

    /* renamed from: d  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.j f5658d = com.ss.android.socialbase.downloader.downloader.c.x();

    /* renamed from: l  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.a.a f5666l = com.ss.android.socialbase.downloader.a.a.a();

    public g(DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.h.f fVar, c cVar) {
        this.f5657c = downloadInfo;
        this.f5660f = fVar;
        this.f5661g = cVar;
        com.ss.android.socialbase.downloader.g.a a = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.f5659e = a;
        boolean z = a.a("sync_strategy", 0) == 1;
        this.f5667m = z;
        if (z) {
            this.n = Math.max(a.a("sync_interval_ms_fg", 5000), 500L);
            this.o = Math.max(a.a("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.n = 0L;
            this.o = 0L;
        }
        this.p = a.b("monitor_rw") == 1;
    }

    private boolean a(long j2, long j3) {
        return j2 > SVG.D && j3 > 500;
    }

    private void b(List<l> list) throws IOException {
        for (l lVar : list) {
            lVar.c();
        }
    }

    private void c() throws IOException {
        boolean z = this.p;
        long nanoTime = z ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.f5657c;
        com.ss.android.socialbase.downloader.downloader.j jVar = this.f5658d;
        List<l> list = this.a;
        List<l> list2 = this.b;
        Map<Long, i> l2 = jVar.l(downloadInfo.getId());
        if (l2 == null) {
            l2 = new HashMap<>(4);
        }
        synchronized (this) {
            a(list);
            b(list);
            a(list, l2);
            if (list2.size() > 0) {
                c(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (1 != 0) {
            downloadInfo.updateRealDownloadTime(true);
            jVar.a(downloadInfo.getId(), l2);
            jVar.a(downloadInfo);
            this.r = downloadInfo.getCurBytes();
        }
        if (z) {
            this.q += System.nanoTime() - nanoTime;
        }
    }

    public void a(l lVar) {
        synchronized (this) {
            this.a.add(lVar);
        }
    }

    public void b() {
        this.f5664j = true;
        this.f5663i = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:208:0x02a2, code lost:
        r3.b(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b8, code lost:
        if (r13 <= 0) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bb, code lost:
        r3.b(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f3 A[Catch: all -> 0x03d7, TryCatch #27 {all -> 0x03d7, blocks: (B:158:0x01ef, B:160:0x01f3, B:163:0x01f9, B:165:0x01ff, B:166:0x0202, B:167:0x0218, B:204:0x029c, B:205:0x029e, B:244:0x0325, B:246:0x032f, B:248:0x0333, B:285:0x03b5, B:287:0x03bb, B:288:0x03be, B:289:0x03d6), top: B:361:0x0027, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ff A[Catch: all -> 0x03d7, TryCatch #27 {all -> 0x03d7, blocks: (B:158:0x01ef, B:160:0x01f3, B:163:0x01f9, B:165:0x01ff, B:166:0x0202, B:167:0x0218, B:204:0x029c, B:205:0x029e, B:244:0x0325, B:246:0x032f, B:248:0x0333, B:285:0x03b5, B:287:0x03bb, B:288:0x03be, B:289:0x03d6), top: B:361:0x0027, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x032f A[Catch: all -> 0x03d7, TryCatch #27 {all -> 0x03d7, blocks: (B:158:0x01ef, B:160:0x01f3, B:163:0x01f9, B:165:0x01ff, B:166:0x0202, B:167:0x0218, B:204:0x029c, B:205:0x029e, B:244:0x0325, B:246:0x032f, B:248:0x0333, B:285:0x03b5, B:287:0x03bb, B:288:0x03be, B:289:0x03d6), top: B:361:0x0027, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03bb A[Catch: all -> 0x03d7, TryCatch #27 {all -> 0x03d7, blocks: (B:158:0x01ef, B:160:0x01f3, B:163:0x01f9, B:165:0x01ff, B:166:0x0202, B:167:0x0218, B:204:0x029c, B:205:0x029e, B:244:0x0325, B:246:0x032f, B:248:0x0333, B:285:0x03b5, B:287:0x03bb, B:288:0x03be, B:289:0x03d6), top: B:361:0x0027, inners: #29 }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0229 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x02ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0362 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:347:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0415 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x03f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0248 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x02ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.ss.android.socialbase.downloader.f.d r31) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1131
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.g.a(com.ss.android.socialbase.downloader.f.d):void");
    }

    private void c(List<l> list) {
        for (l lVar : list) {
            lVar.d();
        }
    }

    private void a(long j2, boolean z) throws IOException {
        long j3 = j2 - this.s;
        if (this.f5667m) {
            if (j3 > (this.f5666l.b() ? this.n : this.o)) {
                c();
                this.s = j2;
                return;
            }
            return;
        }
        long curBytes = this.f5657c.getCurBytes() - this.r;
        if (z || a(curBytes, j3)) {
            c();
            this.s = j2;
        }
    }

    private void a(e eVar) {
        synchronized (this) {
            this.b.add((l) eVar);
        }
    }

    private void a(List<l> list) throws IOException {
        for (l lVar : list) {
            lVar.b();
        }
    }

    private void a(List<l> list, Map<Long, i> map) {
        for (l lVar : list) {
            i e2 = lVar.e();
            i iVar = map.get(Long.valueOf(e2.c()));
            if (iVar == null) {
                map.put(Long.valueOf(e2.c()), new i(e2));
            } else {
                iVar.a(e2.d());
                iVar.c(e2.f());
            }
        }
    }

    public void a() {
        this.f5665k = true;
        this.f5663i = true;
    }
}
