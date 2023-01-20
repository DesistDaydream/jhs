package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public class m implements Runnable {
    private Thread A;
    private volatile boolean B;
    private int C;
    private int D;
    private int E;
    private long F;
    private int G;
    private boolean H;
    private BaseException I;
    private boolean J;
    private boolean K;
    private com.ss.android.socialbase.downloader.i.e L;
    public volatile i a;
    public q b;

    /* renamed from: c  reason: collision with root package name */
    public final int f5686c;

    /* renamed from: d  reason: collision with root package name */
    public volatile long f5687d;

    /* renamed from: e  reason: collision with root package name */
    public volatile long f5688e;

    /* renamed from: f  reason: collision with root package name */
    public volatile long f5689f;

    /* renamed from: g  reason: collision with root package name */
    public volatile long f5690g;

    /* renamed from: h  reason: collision with root package name */
    public String f5691h;

    /* renamed from: i  reason: collision with root package name */
    public String f5692i;

    /* renamed from: j  reason: collision with root package name */
    public String f5693j;

    /* renamed from: k  reason: collision with root package name */
    private final f f5694k;

    /* renamed from: l  reason: collision with root package name */
    private final c f5695l;

    /* renamed from: m  reason: collision with root package name */
    private final DownloadInfo f5696m;
    private final com.ss.android.socialbase.downloader.g.a n;
    private com.ss.android.socialbase.downloader.network.i o;
    private com.ss.android.socialbase.downloader.model.d p;
    private long r;
    private volatile long s;
    private volatile long t;
    private volatile long v;
    private Future w;
    private volatile boolean x;
    private volatile boolean y;
    private volatile boolean z;
    private final List<i> q = new ArrayList();
    private volatile long u = -1;

    public m(DownloadInfo downloadInfo, k kVar, c cVar, q qVar, int i2) {
        this.f5696m = downloadInfo;
        this.f5694k = kVar;
        this.f5695l = cVar;
        this.n = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId());
        this.b = qVar;
        this.f5686c = i2;
    }

    private boolean a(i iVar) throws BaseException {
        k();
        while (true) {
            try {
                b(iVar);
                d(iVar);
                return true;
            } catch (j e2) {
                this.I = e2;
                throw e2;
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "download: e = " + th + ", threadIndex = " + this.f5686c + ", reconnect = " + this.y + ", closed = " + this.x);
                    if (this.x) {
                        return false;
                    }
                    if (this.y) {
                        this.y = false;
                        Thread.interrupted();
                        if (this.z) {
                            this.z = false;
                            throw new j(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        BaseException e3 = null;
                        if (th instanceof BaseException) {
                            e3 = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.i.f.a((Throwable) th, "download");
                            } catch (BaseException e4) {
                                e3 = e4;
                            }
                        }
                        if (e3 == null || !a(iVar, e3)) {
                            return false;
                        }
                    }
                } finally {
                    i();
                }
            }
        }
        return false;
    }

    private void b(i iVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        c(iVar);
        this.f5694k.a(this, iVar, this.b, this.p);
        this.b.c();
    }

    private void c(i iVar) throws BaseException {
        String str;
        String str2;
        com.ss.android.socialbase.downloader.network.i a;
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.f5688e = 0L;
                this.f5687d = currentTimeMillis;
                this.r = iVar.e();
                this.t = iVar.f();
                if (this.t > 0 && this.r > this.t) {
                    throw new j(6, "createConn, " + iVar);
                }
                this.L = new com.ss.android.socialbase.downloader.i.e();
                List<com.ss.android.socialbase.downloader.model.c> a2 = com.ss.android.socialbase.downloader.i.f.a(this.f5696m.getExtraHeaders(), this.f5696m.geteTag(), this.r, this.t);
                a2.add(new com.ss.android.socialbase.downloader.model.c("Segment-Index", String.valueOf(iVar.g())));
                a2.add(new com.ss.android.socialbase.downloader.model.c("Thread-Index", String.valueOf(this.f5686c)));
                com.ss.android.socialbase.downloader.i.f.a(a2, this.f5696m);
                com.ss.android.socialbase.downloader.i.f.b(a2, this.f5696m);
                str = this.b.a;
                if (this.H && !TextUtils.isEmpty(str) && str.startsWith("https")) {
                    str = str.replaceFirst("https", "http");
                }
                str2 = this.b.b;
                com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + iVar + ", threadIndex = " + this.f5686c);
                this.f5691h = str;
                this.f5692i = str2;
                a = com.ss.android.socialbase.downloader.downloader.c.a(this.f5696m.isNeedDefaultHttpServiceBackUp(), this.f5696m.getMaxBytes(), str, str2, a2, 0, currentTimeMillis - this.F > 3000 && this.n.b("monitor_download_connect") > 0, this.f5696m);
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.i.f.a(th, "createConn");
            }
            if (a != null) {
                this.o = a;
                this.p = new com.ss.android.socialbase.downloader.model.d(str, a);
                if (!this.x) {
                    if (a instanceof com.ss.android.socialbase.downloader.network.a) {
                        this.f5693j = ((com.ss.android.socialbase.downloader.network.a) a).e();
                    }
                    Log.i("SegmentReader", "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.f5693j + ", threadIndex = " + this.f5686c);
                    return;
                }
                throw new p("createConn");
            }
            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
        } finally {
            this.f5688e = System.currentTimeMillis();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x012c, code lost:
        r7 = r11 + 1;
        r11 = r13 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0136, code lost:
        if (r11 <= 0) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0138, code lost:
        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "loopAndRead: redundant = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014e, code lost:
        r31.u = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0151, code lost:
        r13 = r7;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0155, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x015e, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0166, code lost:
        throw new com.ss.android.socialbase.downloader.f.p("loopAndRead");
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01c2, code lost:
        r6 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x03a8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x015c -> B:78:0x015d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(com.ss.android.socialbase.downloader.f.i r32) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 998
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.m.d(com.ss.android.socialbase.downloader.f.i):void");
    }

    private void i() {
        this.F = this.f5687d;
        this.f5687d = -1L;
        this.f5688e = -1L;
        this.f5689f = -1L;
        this.f5690g = -1L;
        j();
    }

    private void j() {
        com.ss.android.socialbase.downloader.network.i iVar = this.o;
        if (iVar != null) {
            try {
                com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "closeConnection: thread = " + this.f5686c);
                iVar.d();
                iVar.c();
            } catch (Throwable unused) {
            }
        }
    }

    private void k() {
        this.H = false;
        l();
    }

    private void l() {
        this.D = this.b.f5698d ? this.f5696m.getRetryCount() : this.f5696m.getBackUpUrlRetryCount();
        this.E = 0;
    }

    private long m() {
        long j2 = this.s;
        this.s = 0L;
        if (j2 <= 0) {
            return Long.MAX_VALUE;
        }
        return j2;
    }

    public void e() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "close: threadIndex = " + this.f5686c);
        synchronized (this) {
            this.x = true;
            this.B = true;
        }
        j();
        Future future = this.w;
        if (future != null) {
            this.w = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void f() {
        a(false);
    }

    public boolean g() {
        return this.J;
    }

    public long h() {
        return this.r;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
        r6.a = null;
        r2 = r6.f5694k;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.m.run():void");
    }

    public long b() {
        long c2;
        synchronized (this.f5694k) {
            c2 = this.v + c();
        }
        return c2;
    }

    public void b(boolean z) {
        this.J = z;
    }

    public void b(long j2) {
        long j3 = this.u;
        com.ss.android.socialbase.downloader.i.e eVar = this.L;
        if (j3 < 0 || eVar == null) {
            return;
        }
        Log.i("SegmentReader", "markProgress: curSegmentReadOffset = " + j3 + ", threadIndex = " + this.f5686c);
        eVar.a(j3, j2);
    }

    public boolean a(q qVar) {
        int i2 = this.G;
        if (i2 >= 30) {
            return false;
        }
        this.G = i2 + 1;
        q qVar2 = this.b;
        if (qVar2 != null) {
            qVar2.b(this);
        }
        qVar.a(this);
        this.b = qVar;
        l();
        return true;
    }

    private boolean a(i iVar, BaseException baseException) {
        com.ss.android.socialbase.downloader.c.a.e("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.E + ", retryCount = " + this.D);
        this.I = baseException;
        this.b.b();
        this.f5694k.a(this, this.b, iVar, baseException, this.E, this.D);
        int i2 = this.E;
        if (i2 < this.D) {
            this.E = i2 + 1;
            return true;
        } else if (a(baseException)) {
            return true;
        } else {
            this.f5694k.a(this, this.b, iVar, baseException);
            return false;
        }
    }

    public long c() {
        synchronized (this.f5694k) {
            long j2 = this.u;
            long j3 = this.r;
            if (j3 < 0 || j2 <= j3) {
                return 0L;
            }
            return j2 - j3;
        }
    }

    private boolean a(BaseException baseException) {
        if (com.ss.android.socialbase.downloader.i.f.c(baseException)) {
            String str = this.b.a;
            if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.f5696m.isNeedHttpsToHttpRetry() || this.H) {
                return false;
            }
            this.H = true;
            l();
            return true;
        }
        return false;
    }

    public void c(boolean z) {
        this.K = z;
    }

    private a a(c cVar, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        int i2;
        a b = cVar.b();
        try {
            i2 = inputStream.read(b.a);
            try {
                if (i2 != -1) {
                    b.f5646c = i2;
                    if (i2 == -1) {
                        cVar.a(b);
                    }
                    return b;
                }
                throw new BaseException(1073, "probe");
            } catch (Throwable th) {
                th = th;
                if (i2 == -1) {
                    cVar.a(b);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i2 = -1;
        }
    }

    public boolean a(long j2) {
        long j3 = this.t;
        if (j2 > 0 || j3 <= 0) {
            if (j2 <= j3 || j3 <= 0) {
                this.s = j2;
                this.B = true;
                return true;
            }
            return false;
        }
        return false;
    }

    public void a() {
        q qVar = this.b;
        try {
            synchronized (this.f5694k) {
                long c2 = c();
                if (c2 > 0) {
                    this.v += c2;
                    qVar.a(c2);
                }
                this.u = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        com.ss.android.socialbase.downloader.c.a.c("SegmentReader", "reconnect: threadIndex = " + this.f5686c);
        synchronized (this) {
            this.z = z;
            this.y = true;
            this.B = true;
        }
        j();
        Thread thread = this.A;
        if (thread != null) {
            try {
                Log.i("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.f5686c);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    public void a(Future future) {
        this.w = future;
    }

    public long a(long j2, long j3) {
        com.ss.android.socialbase.downloader.i.e eVar = this.L;
        if (eVar == null) {
            return -1L;
        }
        return eVar.b(j2, j3);
    }

    public long d() {
        return this.u;
    }
}
