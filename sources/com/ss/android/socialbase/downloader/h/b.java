package com.ss.android.socialbase.downloader.h;

import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.i;

/* loaded from: classes3.dex */
public class b implements Runnable {
    private static final String a = b.class.getSimpleName();
    private com.ss.android.socialbase.downloader.model.b b;

    /* renamed from: c  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.b f5715c;

    /* renamed from: d  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.e f5716d;

    /* renamed from: e  reason: collision with root package name */
    private final DownloadTask f5717e;

    /* renamed from: f  reason: collision with root package name */
    private DownloadInfo f5718f;

    /* renamed from: g  reason: collision with root package name */
    private final f f5719g;

    /* renamed from: h  reason: collision with root package name */
    private i f5720h;

    /* renamed from: i  reason: collision with root package name */
    private j f5721i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f5722j;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f5723k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5724l;

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, f fVar) {
        this.f5724l = false;
        this.f5715c = bVar;
        this.f5717e = downloadTask;
        if (downloadTask != null) {
            this.f5718f = downloadTask.getDownloadInfo();
        }
        this.f5719g = fVar;
        this.f5721i = com.ss.android.socialbase.downloader.downloader.c.x();
        this.f5715c.a(this);
    }

    private String c() {
        return this.f5718f.getConnectionUrl();
    }

    private void d() {
        i iVar = this.f5720h;
        if (iVar != null) {
            iVar.d();
            this.f5720h = null;
        }
    }

    private boolean e() {
        return this.f5722j || this.f5723k;
    }

    public void a(long j2, long j3) {
        com.ss.android.socialbase.downloader.downloader.e eVar = this.f5716d;
        if (eVar == null) {
            return;
        }
        eVar.a(j2, j3);
    }

    public void b() {
        this.f5723k = true;
        com.ss.android.socialbase.downloader.downloader.e eVar = this.f5716d;
        if (eVar != null) {
            eVar.c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
        r3.b.a(false);
     */
    @Override // java.lang.Runnable
    @android.annotation.SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r3 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.ss.android.socialbase.downloader.model.b r0 = r3.f5715c
            r3.b = r0
        L9:
            r0 = 0
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L5d
            r1.a(r3)     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.a(r1)     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L1d
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L5d
            r1.a(r0)     // Catch: java.lang.Throwable -> L5d
            goto L4d
        L1d:
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L5d
            r1.a(r0)     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.e()     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L29
            goto L4d
        L29:
            com.ss.android.socialbase.downloader.h.f r1 = r3.f5719g     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.b r2 = r3.b     // Catch: java.lang.Throwable -> L5d
            int r2 = r2.s()     // Catch: java.lang.Throwable -> L5d
            com.ss.android.socialbase.downloader.model.b r1 = r1.a(r2)     // Catch: java.lang.Throwable -> L5d
            r3.b = r1     // Catch: java.lang.Throwable -> L5d
            boolean r1 = r3.e()     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L4d
            com.ss.android.socialbase.downloader.model.b r1 = r3.b     // Catch: java.lang.Throwable -> L5d
            if (r1 != 0) goto L42
            goto L4d
        L42:
            r1 = 50
            java.lang.Thread.sleep(r1)     // Catch: java.lang.Throwable -> L48
            goto L9
        L48:
            r1 = move-exception
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L5d
            goto L9
        L4d:
            com.ss.android.socialbase.downloader.model.b r1 = r3.b
            if (r1 == 0) goto L54
            r1.a(r0)
        L54:
            r3.d()
            com.ss.android.socialbase.downloader.h.f r0 = r3.f5719g
            r0.a(r3)
            return
        L5d:
            r1 = move-exception
            com.ss.android.socialbase.downloader.model.b r2 = r3.b
            if (r2 == 0) goto L65
            r2.a(r0)
        L65:
            r3.d()
            com.ss.android.socialbase.downloader.h.f r0 = r3.f5719g
            r0.a(r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.b.run():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x01dc A[Catch: all -> 0x029f, TRY_ENTER, TryCatch #16 {all -> 0x029f, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:167:0x0247, B:169:0x024d, B:171:0x025a, B:175:0x0262, B:170:0x0254, B:161:0x022e, B:162:0x023a, B:177:0x026d, B:179:0x0275, B:181:0x027d, B:183:0x0285, B:185:0x028d, B:188:0x0296, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:214:0x01d2, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x024d A[Catch: all -> 0x029f, TryCatch #16 {all -> 0x029f, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:167:0x0247, B:169:0x024d, B:171:0x025a, B:175:0x0262, B:170:0x0254, B:161:0x022e, B:162:0x023a, B:177:0x026d, B:179:0x0275, B:181:0x027d, B:183:0x0285, B:185:0x028d, B:188:0x0296, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:214:0x01d2, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0254 A[Catch: all -> 0x029f, TryCatch #16 {all -> 0x029f, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:167:0x0247, B:169:0x024d, B:171:0x025a, B:175:0x0262, B:170:0x0254, B:161:0x022e, B:162:0x023a, B:177:0x026d, B:179:0x0275, B:181:0x027d, B:183:0x0285, B:185:0x028d, B:188:0x0296, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:214:0x01d2, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0262 A[Catch: all -> 0x029f, TRY_ENTER, TRY_LEAVE, TryCatch #16 {all -> 0x029f, blocks: (B:135:0x01d2, B:139:0x01dc, B:141:0x01e2, B:144:0x01eb, B:146:0x01f3, B:148:0x01f9, B:152:0x0204, B:154:0x0208, B:156:0x0210, B:158:0x0221, B:167:0x0247, B:169:0x024d, B:171:0x025a, B:175:0x0262, B:170:0x0254, B:161:0x022e, B:162:0x023a, B:177:0x026d, B:179:0x0275, B:181:0x027d, B:183:0x0285, B:185:0x028d, B:188:0x0296, B:122:0x01b4, B:126:0x01be, B:129:0x01c5), top: B:214:0x01d2, inners: #10 }] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x025e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x01d8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x00fb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ff A[Catch: all -> 0x01b2, BaseException -> 0x01ce, TRY_ENTER, TryCatch #3 {BaseException -> 0x01ce, blocks: (B:22:0x004f, B:26:0x0059, B:30:0x0064, B:62:0x00f5, B:66:0x00ff, B:68:0x0103, B:79:0x0131, B:51:0x00db), top: B:198:0x004f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(com.ss.android.socialbase.downloader.model.b r31) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.b.a(com.ss.android.socialbase.downloader.model.b):boolean");
    }

    public b(com.ss.android.socialbase.downloader.model.b bVar, DownloadTask downloadTask, i iVar, f fVar) {
        this(bVar, downloadTask, fVar);
        this.f5720h = iVar;
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, long j2) {
        com.ss.android.socialbase.downloader.model.b e2 = bVar.d() ? bVar.e() : bVar;
        if (e2 != null) {
            if (e2.h()) {
                this.f5721i.a(e2.k(), e2.b(), j2);
            }
            e2.b(j2);
            this.f5721i.a(e2.k(), e2.s(), e2.b(), j2);
        } else if (bVar.d()) {
            this.f5721i.a(bVar.k(), bVar.s(), j2);
        }
    }

    public void a() {
        this.f5722j = true;
        com.ss.android.socialbase.downloader.downloader.e eVar = this.f5716d;
        if (eVar != null) {
            eVar.b();
        }
    }
}
