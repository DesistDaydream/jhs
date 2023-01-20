package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.caverock.androidsvg.SVG;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.w;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.k;
import com.ss.android.socialbase.downloader.f.n;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.b;
import com.ss.android.socialbase.downloader.network.i;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class c implements f, Runnable {
    private static final String a = c.class.getSimpleName();
    private r A;
    private String E;
    private long G;
    private long H;
    private final com.ss.android.socialbase.downloader.g.a I;
    private Future b;

    /* renamed from: c  reason: collision with root package name */
    private final DownloadTask f5725c;

    /* renamed from: e  reason: collision with root package name */
    private AtomicInteger f5727e;

    /* renamed from: g  reason: collision with root package name */
    private volatile com.ss.android.socialbase.downloader.downloader.e f5729g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5730h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5731i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5732j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5733k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5734l;

    /* renamed from: m  reason: collision with root package name */
    private final AtomicBoolean f5735m;
    private final j o;
    private DownloadInfo p;
    private com.ss.android.socialbase.downloader.downloader.h q;
    private final com.ss.android.socialbase.downloader.downloader.h r;
    private com.ss.android.socialbase.downloader.downloader.g s;
    private final com.ss.android.socialbase.downloader.downloader.g t;
    private s u;
    private final com.ss.android.socialbase.downloader.downloader.f v;
    private volatile BaseException w;
    private i x;
    private com.ss.android.socialbase.downloader.network.g y;
    private w z;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f5726d = false;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<b> f5728f = new ArrayList<>();
    private volatile com.ss.android.socialbase.downloader.constants.h n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_NONE;
    private volatile int B = 5;
    private boolean C = false;
    private boolean D = false;
    private boolean F = false;
    private int J = 0;
    private volatile k K = null;

    public c(DownloadTask downloadTask, Handler handler) {
        this.f5725c = downloadTask;
        if (downloadTask != null) {
            this.p = downloadTask.getDownloadInfo();
            this.q = downloadTask.getChunkStrategy();
            this.s = downloadTask.getChunkAdjustCalculator();
            this.z = downloadTask.getForbiddenHandler();
            this.A = downloadTask.getDiskSpaceHandler();
            this.u = a(downloadTask);
            this.I = com.ss.android.socialbase.downloader.g.a.a(this.p.getId());
        } else {
            this.I = com.ss.android.socialbase.downloader.g.a.c();
        }
        h();
        this.o = com.ss.android.socialbase.downloader.downloader.c.x();
        this.r = com.ss.android.socialbase.downloader.downloader.c.I();
        this.t = com.ss.android.socialbase.downloader.downloader.c.K();
        this.v = new com.ss.android.socialbase.downloader.downloader.f(downloadTask, handler);
        this.f5735m = new AtomicBoolean(true);
    }

    private long A() {
        return this.u.a(this.p.getCurRetryTimeInTotal(), this.p.getTotalRetryCount());
    }

    private void B() throws com.ss.android.socialbase.downloader.exception.i, BaseException {
        com.ss.android.socialbase.downloader.impls.a C;
        int id = this.p.getId();
        int a2 = com.ss.android.socialbase.downloader.downloader.c.a(this.p);
        if (this.p.isDownloaded() && !this.p.isExpiredRedownload() && !this.F) {
            throw new BaseException(1009, "file has downloaded");
        }
        DownloadInfo b = this.o.b(a2);
        if (b == null || (C = com.ss.android.socialbase.downloader.downloader.c.C()) == null || b.getId() == id || !b.equalsTask(this.p)) {
            return;
        }
        if (!C.a(b.getId())) {
            List<com.ss.android.socialbase.downloader.model.b> c2 = this.o.c(a2);
            com.ss.android.socialbase.downloader.i.f.a(this.p);
            this.o.f(a2);
            if (b == null || !b.isBreakpointAvailable()) {
                return;
            }
            this.p.copyFromCacheData(b, false);
            this.o.a(this.p);
            if (c2 != null) {
                for (com.ss.android.socialbase.downloader.model.b bVar : c2) {
                    bVar.b(id);
                    this.o.a(bVar);
                }
            }
            throw new com.ss.android.socialbase.downloader.exception.i("retry task because id generator changed");
        }
        this.o.f(id);
        throw new BaseException(1025, "another same task is downloading");
    }

    private boolean C() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo == null || downloadInfo.isExpiredRedownload()) {
            return false;
        }
        return (!this.f5731i || this.p.getChunkCount() > 1) && !this.p.isChunkDowngradeRetryUsed() && this.f5732j && !this.f5734l;
    }

    private void D() throws BaseException {
        long j2;
        int a2;
        try {
            j2 = com.ss.android.socialbase.downloader.i.f.d(this.p.getTempPath());
        } catch (BaseException unused) {
            j2 = 0;
        }
        String str = a;
        com.ss.android.socialbase.downloader.c.a.c(str, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.i.f.a(j2) + "MB");
        if (j2 > 0) {
            long totalBytes = this.p.getTotalBytes() - this.p.getCurBytes();
            if (j2 < totalBytes && (a2 = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("space_fill_min_keep_mb", 100)) > 0) {
                long j3 = j2 - (a2 * SVG.H);
                com.ss.android.socialbase.downloader.c.a.c(str, "checkSpaceOverflowInProgress: minKeep  = " + a2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.i.f.a(j3) + "MB");
                if (j3 > 0) {
                    this.G = this.p.getCurBytes() + j3 + SVG.H;
                    return;
                } else {
                    this.G = 0L;
                    throw new com.ss.android.socialbase.downloader.exception.d(j2, totalBytes);
                }
            }
        }
        this.G = 0L;
    }

    private void E() throws com.ss.android.socialbase.downloader.exception.f {
        if (this.p.isOnlyWifi() && !com.ss.android.socialbase.downloader.i.f.a(com.ss.android.socialbase.downloader.downloader.c.N(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.ss.android.socialbase.downloader.exception.f(PointerIconCompat.TYPE_ZOOM_OUT, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.p.isDownloadWithWifiValid()) {
            if (!this.p.isPauseReserveWithWifiValid()) {
                throw new com.ss.android.socialbase.downloader.exception.e();
            }
            return;
        }
        throw new com.ss.android.socialbase.downloader.exception.c();
    }

    private void F() throws BaseException {
        if (!TextUtils.isEmpty(this.p.getSavePath())) {
            if (!TextUtils.isEmpty(this.p.getName())) {
                File file = new File(this.p.getSavePath());
                if (!file.exists()) {
                    boolean mkdirs = file.mkdirs();
                    if (mkdirs || file.exists()) {
                        return;
                    }
                    int i2 = 0;
                    if (com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("opt_mkdir_failed", 0) == 1) {
                        while (!mkdirs) {
                            int i3 = i2 + 1;
                            if (i2 >= 3) {
                                break;
                            }
                            try {
                                Thread.sleep(10L);
                                mkdirs = file.mkdirs();
                                i2 = i3;
                            } catch (InterruptedException unused) {
                            }
                        }
                        if (mkdirs || file.exists()) {
                            return;
                        }
                        if (com.ss.android.socialbase.downloader.i.f.d(this.p.getSavePath()) < 16384) {
                            throw new BaseException(1006, "download savePath directory can not created:" + this.p.getSavePath());
                        }
                        throw new BaseException(1030, "download savePath directory can not created:" + this.p.getSavePath());
                    }
                    throw new BaseException(1030, "download savePath directory can not created:" + this.p.getSavePath());
                } else if (file.isDirectory()) {
                    return;
                } else {
                    if (com.ss.android.socialbase.downloader.i.d.b(this.p)) {
                        file.delete();
                        if (file.mkdirs() || file.exists()) {
                            return;
                        }
                        throw new BaseException(1031, "download savePath is not directory:path=" + this.p.getSavePath());
                    }
                    throw new BaseException(1031, "download savePath is not a directory:" + this.p.getSavePath());
                }
            }
            throw new BaseException(1029, "download name can not be empty");
        }
        throw new BaseException(1028, "download savePath can not be empty");
    }

    private void G() {
        long f2 = com.ss.android.socialbase.downloader.i.f.f(this.p);
        long curBytes = this.p.getCurBytes();
        if (f2 != curBytes) {
            String str = a;
            com.ss.android.socialbase.downloader.c.a.d(str, "checkTaskCanResume: offset = " + f2 + ", curBytes = " + curBytes);
        }
        this.p.setCurBytes(f2);
        boolean z = f2 > 0;
        this.f5731i = z;
        if (z || this.F) {
            return;
        }
        com.ss.android.socialbase.downloader.c.a.c(a, "checkTaskCanResume: deleteAllDownloadFiles");
        this.o.d(this.p.getId());
        this.o.m(this.p.getId());
        com.ss.android.socialbase.downloader.i.f.a(this.p);
    }

    private void H() {
        String str = a;
        com.ss.android.socialbase.downloader.c.a.d(str, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.o.d(this.p.getId());
            this.o.m(this.p.getId());
            com.ss.android.socialbase.downloader.i.f.a(this.p);
            this.f5731i = false;
            this.p.resetDataForEtagEndure("");
            this.o.a(this.p);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void I() {
        try {
            Iterator it = ((ArrayList) this.f5728f.clone()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null) {
                    bVar.b();
                }
            }
        } catch (Throwable th) {
            String str = a;
            com.ss.android.socialbase.downloader.c.a.c(str, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        com.ss.android.socialbase.downloader.impls.a C;
        if (v() || (C = com.ss.android.socialbase.downloader.downloader.c.C()) == null) {
            return;
        }
        C.l(this.p.getId());
    }

    private boolean K() {
        return false;
    }

    private void h() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.p.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.f5727e;
        if (atomicInteger == null) {
            this.f5727e = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    private boolean i() {
        int status = this.p.getStatus();
        if (status == 1 || this.p.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        b(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x00f3, code lost:
        if (r9.I.a("fix_file_exist_update_download_info") != false) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab A[Catch: all -> 0x00e8, TryCatch #6 {all -> 0x00e8, blocks: (B:56:0x00a7, B:58:0x00ab, B:60:0x00af, B:73:0x00e7), top: B:84:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j() throws com.ss.android.socialbase.downloader.exception.a {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.j():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058 A[LOOP:0: B:24:0x0058->B:55:0x0058, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k() {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.k():void");
    }

    private void l() {
        boolean z;
        List<com.ss.android.socialbase.downloader.model.b> c2;
        try {
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_NONE;
            this.p.updateStartDownloadTime();
            this.p.resetRealStartDownloadTime();
            long currentTimeMillis = System.currentTimeMillis();
            this.p.setFirstSpeedTime(-1L);
            try {
                j();
                z = false;
            } catch (com.ss.android.socialbase.downloader.exception.a e2) {
                String str = a;
                com.ss.android.socialbase.downloader.c.a.b(str, "file exist " + e2.a());
                this.E = e2.a();
                z = true;
            }
            if (!this.C) {
                this.v.b();
            }
            this.C = false;
            if (v()) {
                return;
            }
            if (!TextUtils.isEmpty(this.E) && z) {
                if (this.p.isExpiredRedownload()) {
                    this.F = com.ss.android.socialbase.downloader.i.f.d(this.p);
                }
                if (!this.F) {
                    m();
                    return;
                }
            }
            while (!v()) {
                try {
                    try {
                        try {
                            F();
                            B();
                            E();
                            c2 = this.o.c(this.p.getId());
                            G();
                        } catch (BaseException e3) {
                            String str2 = a;
                            com.ss.android.socialbase.downloader.c.a.d(str2, "downloadInner: baseException = " + e3);
                            if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                                if (e3.getErrorCode() != 1025 && e3.getErrorCode() != 1009) {
                                    if (a(e3)) {
                                        if (com.ss.android.socialbase.downloader.i.f.a(e3)) {
                                            H();
                                        }
                                        if (a(e3, 0L) != com.ss.android.socialbase.downloader.exception.h.RETURN) {
                                            s();
                                        } else {
                                            s();
                                            return;
                                        }
                                    } else {
                                        b(e3);
                                    }
                                }
                                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW;
                                s();
                                return;
                            }
                        }
                    } catch (com.ss.android.socialbase.downloader.exception.a unused) {
                        m();
                    }
                } catch (com.ss.android.socialbase.downloader.exception.i e4) {
                    String str3 = a;
                    com.ss.android.socialbase.downloader.c.a.d(str3, "downloadInner: retry throwable for " + e4.a());
                    if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                        AtomicInteger atomicInteger = this.f5727e;
                        if (atomicInteger != null && atomicInteger.get() > 0) {
                            this.p.updateCurRetryTime(this.f5727e.decrementAndGet());
                            this.p.setStatus(5);
                        } else if (this.f5727e != null) {
                            if (this.p.trySwitchToNextBackupUrl()) {
                                this.p.setStatus(5);
                                this.f5727e.set(this.p.getRetryCount());
                                this.p.updateCurRetryTime(this.f5727e.get());
                            } else {
                                b(new BaseException((int) PointerIconCompat.TYPE_ZOOM_IN, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.p.getRetryCount()), e4.a())));
                            }
                        } else {
                            b(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e4.a()));
                        }
                        s();
                    }
                }
                if (n()) {
                    com.ss.android.socialbase.downloader.c.a.c(a, "downloadSegments return");
                    s();
                    return;
                }
                String connectionUrl = this.p.getConnectionUrl();
                if (v()) {
                    s();
                    return;
                }
                long e5 = this.f5731i ? com.ss.android.socialbase.downloader.i.f.e(this.p) : 0L;
                com.ss.android.socialbase.downloader.model.b a2 = a(this.p, e5);
                List<com.ss.android.socialbase.downloader.model.c> a3 = a(a2);
                com.ss.android.socialbase.downloader.i.f.a(a3, this.p);
                com.ss.android.socialbase.downloader.i.f.b(a3, this.p);
                this.p.setPreconnectLevel(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    a(connectionUrl, a3, e5);
                    this.p.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                    if (v()) {
                        s();
                        return;
                    }
                    long totalBytes = this.p.getTotalBytes();
                    a(totalBytes);
                    int a4 = a(totalBytes, c2);
                    if (v()) {
                        s();
                        return;
                    } else if (a4 > 0) {
                        boolean z2 = a4 == 1;
                        this.f5730h = z2;
                        if (z2) {
                            if (this.x == null) {
                                try {
                                    currentTimeMillis2 = System.currentTimeMillis();
                                    a(connectionUrl, a3);
                                    this.p.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                                } finally {
                                }
                            }
                            if (v()) {
                                s();
                                return;
                            }
                            this.p.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            o();
                            a(a2, connectionUrl, this.x);
                        } else {
                            if (!this.p.isNeedReuseFirstConnection()) {
                                r();
                            }
                            if (v()) {
                                s();
                                return;
                            }
                            o();
                            this.p.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            if (this.f5731i) {
                                a(a4, c2);
                            } else {
                                a(totalBytes, a4);
                            }
                        }
                        s();
                        return;
                    } else {
                        throw new BaseException(1032, "chunkCount is 0");
                    }
                } finally {
                }
            }
        } finally {
            p();
        }
    }

    private void m() {
        com.ss.android.socialbase.downloader.c.a.b(a, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.g.a.c().b("fix_end_for_file_exist_error", true)) {
            if (this.E.equals(this.p.getName())) {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW;
            } else {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_FOR_FILE_EXIST;
            }
        } else if (this.E.equals(this.p.getTargetFilePath())) {
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private boolean n() throws BaseException, InterruptedException {
        if (!this.p.isExpiredRedownload() && this.p.getChunkCount() == 1 && this.p.getThrottleNetSpeed() <= 0) {
            JSONObject d2 = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).d("segment_config");
            List<com.ss.android.socialbase.downloader.f.i> n = this.o.n(this.p.getId());
            if (this.p.getCurBytes() > 0) {
                if (n == null || n.isEmpty()) {
                    return false;
                }
                if (d2 == null) {
                    d2 = new JSONObject();
                }
            }
            if (d2 == null) {
                return false;
            }
            this.K = new k(this.p, n.a(d2), this);
            if (v()) {
                com.ss.android.socialbase.downloader.c.a.c(a, "downloadSegments: is stopped by user");
                if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                    this.K.a();
                } else {
                    this.K.b();
                }
                return true;
            }
            return this.K.a(n);
        }
        return false;
    }

    private void o() {
        if (com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("reset_retain_retry_times", 0) != 1 || this.J >= 3) {
            return;
        }
        this.f5727e.set(this.p.isBackUpUrlUsed() ? this.p.getBackUpUrlRetryCount() : this.p.getRetryCount());
        this.J++;
    }

    private void p() {
        boolean z;
        boolean z2;
        String str = a;
        com.ss.android.socialbase.downloader.c.a.b(str, "endDownloadRunnable::runStatus=" + this.n);
        boolean z3 = (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE || this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) ? false : true;
        try {
            z = w();
            z2 = false;
        } catch (Exception e2) {
            if (e2 instanceof BaseException) {
                this.v.a((BaseException) e2);
            } else {
                this.v.a(new BaseException(1046, e2));
            }
            z = true;
            z2 = true;
        }
        if (!z && !z2) {
            this.C = true;
            com.ss.android.socialbase.downloader.c.a.b(a, "jump to restart");
            return;
        }
        this.f5735m.set(false);
        if (z3) {
            try {
                com.ss.android.socialbase.downloader.impls.a C = com.ss.android.socialbase.downloader.downloader.c.C();
                if (C != null) {
                    C.a(this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                x monitorDepend = this.f5725c.getMonitorDepend();
                DownloadInfo downloadInfo = this.p;
                BaseException baseException = new BaseException(1014, com.ss.android.socialbase.downloader.i.f.b(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.p;
                com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            }
        }
    }

    private void q() {
        com.ss.android.socialbase.downloader.network.g gVar = this.y;
        if (gVar != null) {
            gVar.c();
            this.y = null;
        }
    }

    private void r() {
        i iVar = this.x;
        if (iVar != null) {
            iVar.d();
            this.x = null;
        }
    }

    private void s() {
        q();
        r();
    }

    private void t() throws BaseException {
        if (this.f5729g != null) {
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                this.p.setStatus(-4);
                this.f5729g.c();
            } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                this.p.setStatus(-2);
                this.f5729g.b();
            } else {
                this.f5729g.d();
            }
        }
    }

    private boolean u() {
        return this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED || this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE;
    }

    private boolean v() {
        if (u() || this.p.getStatus() == -2) {
            if (u()) {
                return true;
            }
            if (this.p.getStatus() == -2) {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE;
                return true;
            } else if (this.p.getStatus() == -4) {
                this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED;
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean w() {
        if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ERROR) {
            this.v.a(this.w);
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
            this.v.c();
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
            this.v.d();
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.v.g();
            } catch (BaseException e2) {
                this.v.a(e2);
            }
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.v.a(this.E);
            } catch (BaseException e3) {
                this.v.a(e3);
            }
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.v.a(this.w, false);
            return false;
        } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            return true;
        } else {
            com.ss.android.socialbase.downloader.constants.h hVar = this.n;
            com.ss.android.socialbase.downloader.constants.h hVar2 = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY;
            if (hVar == hVar2 && !x()) {
                com.ss.android.socialbase.downloader.c.a.b(a, "doTaskStatusHandle retryDelay");
                z();
                return this.n == hVar2;
            }
            try {
                if (!y()) {
                    return false;
                }
                this.v.f();
                com.ss.android.socialbase.downloader.impls.r.a().d();
            } catch (Throwable th) {
                b(new BaseException(1008, com.ss.android.socialbase.downloader.i.f.b(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean x() {
        /*
            r7 = this;
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.p
            int r0 = r0.getChunkCount()
            r1 = 0
            r2 = 1
            if (r0 > r2) goto L28
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.p
            long r3 = r0.getCurBytes()
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L27
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.p
            long r3 = r0.getCurBytes()
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.p
            long r5 = r0.getTotalBytes()
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L27
            return r2
        L27:
            return r1
        L28:
            com.ss.android.socialbase.downloader.downloader.j r0 = r7.o
            com.ss.android.socialbase.downloader.model.DownloadInfo r3 = r7.p
            int r3 = r3.getId()
            java.util.List r0 = r0.c(r3)
            if (r0 == 0) goto L57
            int r3 = r0.size()
            if (r3 > r2) goto L3d
            goto L57
        L3d:
            java.util.Iterator r0 = r0.iterator()
        L41:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L56
            java.lang.Object r3 = r0.next()
            com.ss.android.socialbase.downloader.model.b r3 = (com.ss.android.socialbase.downloader.model.b) r3
            if (r3 == 0) goto L55
            boolean r3 = r3.i()
            if (r3 != 0) goto L41
        L55:
            return r1
        L56:
            return r2
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.x():boolean");
    }

    private boolean y() {
        if (this.p.isChunked()) {
            DownloadInfo downloadInfo = this.p;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        String str = a;
        com.ss.android.socialbase.downloader.c.a.c(str, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.p.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.p.getTotalBytes());
        if (this.p.getCurBytes() > 0) {
            if (this.p.isIgnoreDataVerify()) {
                return true;
            }
            if (this.p.getTotalBytes() > 0 && this.p.getCurBytes() == this.p.getTotalBytes()) {
                return true;
            }
        }
        this.p.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.p.reset();
        this.o.a(this.p);
        this.o.d(this.p.getId());
        this.o.m(this.p.getId());
        com.ss.android.socialbase.downloader.i.f.a(this.p);
        return false;
    }

    private void z() {
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_NONE;
    }

    public void b() {
        com.ss.android.socialbase.downloader.constants.h hVar = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED;
        this.n = hVar;
        if (this.K != null) {
            this.K.a();
        }
        if (this.f5729g != null) {
            this.f5729g.c();
        }
        if (this.K == null && this.f5729g == null) {
            s();
            this.n = hVar;
            p();
        }
        I();
    }

    public DownloadTask c() {
        return this.f5725c;
    }

    public boolean d() {
        return this.f5735m.get();
    }

    public int e() {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    public void f() {
        this.H = System.currentTimeMillis();
        this.v.a();
    }

    public Future g() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.c.a(this.f5725c, 3);
        try {
            com.ss.android.socialbase.downloader.network.b.a().b();
            k();
            com.ss.android.socialbase.downloader.network.b.a().c();
            com.ss.android.socialbase.downloader.downloader.c.b(this.f5725c, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.network.b.a().c();
            throw th;
        }
    }

    private boolean d(BaseException baseException) {
        AtomicInteger atomicInteger = this.f5727e;
        boolean z = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                if (this.p.trySwitchToNextBackupUrl()) {
                    this.f5727e.set(this.p.getBackUpUrlRetryCount());
                    this.p.updateCurRetryTime(this.f5727e.get());
                } else if (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.p.canReplaceHttpForRetry())) {
                    this.f5727e.set(this.p.getRetryCount());
                    this.p.updateCurRetryTime(this.f5727e.get());
                    this.p.setHttpsToHttpRetryUsed(true);
                } else {
                    b(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.f5727e), String.valueOf(this.p.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                z = false;
            }
            if (this.n != com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY && z) {
                this.p.updateCurRetryTime(this.f5727e.decrementAndGet());
            }
            return false;
        }
        b(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void c(BaseException baseException) {
        DownloadInfo downloadInfo = this.p;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        a(baseException, false);
    }

    public void a() {
        com.ss.android.socialbase.downloader.constants.h hVar = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE;
        this.n = hVar;
        if (this.K != null) {
            this.K.b();
        }
        if (this.f5729g != null) {
            this.f5729g.b();
        }
        if (this.K == null && this.f5729g == null) {
            s();
            this.n = hVar;
            p();
        }
        try {
            Iterator it = ((ArrayList) this.f5728f.clone()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar != null) {
                    bVar.a();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(long j2) {
        i iVar = this.x;
        if (iVar != null && (iVar instanceof com.ss.android.socialbase.downloader.network.a)) {
            try {
                ((com.ss.android.socialbase.downloader.network.a) iVar).a(j2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void b(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        com.ss.android.socialbase.downloader.network.a.c a2;
        boolean z = true;
        if (this.p.getChunkCount() == 1 && (a2 = com.ss.android.socialbase.downloader.network.a.a.a().a(str, list)) != null) {
            this.y = a2;
            this.p.setPreconnectLevel(1);
        }
        if (this.y == null && !this.D && this.p.isHeadConnectionAvailable()) {
            try {
                int b = this.I.b("net_lib_strategy");
                if (this.I.a("monitor_download_connect", 0) <= 0) {
                    z = false;
                }
                this.y = com.ss.android.socialbase.downloader.downloader.c.a(str, list, b, z, this.p);
            } catch (Throwable th) {
                this.p.setHeadConnectionException(com.ss.android.socialbase.downloader.i.f.j(th));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (r9 <= 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(long r7, java.util.List<com.ss.android.socialbase.downloader.model.b> r9) {
        /*
            r6 = this;
            boolean r0 = r6.C()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5e
            boolean r0 = r6.f5731i
            if (r0 == 0) goto L1a
            if (r9 == 0) goto L13
            int r9 = r9.size()
            goto L5c
        L13:
            com.ss.android.socialbase.downloader.model.DownloadInfo r9 = r6.p
            int r9 = r9.getChunkCount()
            goto L5c
        L1a:
            com.ss.android.socialbase.downloader.downloader.h r9 = r6.q
            if (r9 == 0) goto L23
            int r9 = r9.a(r7)
            goto L29
        L23:
            com.ss.android.socialbase.downloader.downloader.h r9 = r6.r
            int r9 = r9.a(r7)
        L29:
            com.ss.android.socialbase.downloader.network.k r0 = com.ss.android.socialbase.downloader.network.k.a()
            com.ss.android.socialbase.downloader.network.l r0 = r0.b()
            java.lang.String r3 = com.ss.android.socialbase.downloader.h.c.a
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = r0.name()
            r4[r1] = r5
            java.lang.String r5 = "NetworkQuality is : %s"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            com.ss.android.socialbase.downloader.c.a.b(r3, r4)
            com.ss.android.socialbase.downloader.model.DownloadInfo r3 = r6.p
            java.lang.String r4 = r0.name()
            r3.setNetworkQuality(r4)
            com.ss.android.socialbase.downloader.downloader.g r3 = r6.s
            if (r3 == 0) goto L56
            int r9 = r3.a(r9, r0)
            goto L5c
        L56:
            com.ss.android.socialbase.downloader.downloader.g r3 = r6.t
            int r9 = r3.a(r9, r0)
        L5c:
            if (r9 > 0) goto L5f
        L5e:
            r9 = 1
        L5f:
            boolean r0 = com.ss.android.socialbase.downloader.c.a.a()
            if (r0 == 0) goto L88
            java.lang.String r0 = com.ss.android.socialbase.downloader.h.c.a
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = java.lang.String.valueOf(r9)
            r3[r1] = r4
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r6.p
            java.lang.String r1 = r1.getName()
            r3[r2] = r1
            r1 = 2
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r3[r1] = r7
            java.lang.String r7 = "chunk count : %s for %s contentLen:%s"
            java.lang.String r7 = java.lang.String.format(r7, r3)
            com.ss.android.socialbase.downloader.c.a.b(r0, r7)
        L88:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.a(long, java.util.List):int");
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public boolean b(long j2) throws BaseException {
        if (this.G > 0 && this.p.getCurBytes() > this.G) {
            D();
        }
        return this.v.a(j2);
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void b(BaseException baseException) {
        String str = a;
        com.ss.android.socialbase.downloader.c.a.b(str, "onError:" + baseException.getMessage());
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ERROR;
        this.w = baseException;
        I();
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.c> list, long j2) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        b(str, list, j2);
        com.ss.android.socialbase.downloader.network.g gVar = this.y;
        if (gVar != null) {
            try {
                a(str, gVar, j2);
            } catch (Throwable unused) {
                this.D = true;
            }
        }
        if (this.y == null || this.D) {
            a(str, list);
            a(str, this.x, j2);
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.c> list) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        i iVar;
        if (this.x != null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.a.d b = this.p.getChunkCount() == 1 ? com.ss.android.socialbase.downloader.network.a.a.a().b(str, list) : null;
        try {
            if (b != null) {
                a(this.x);
                this.p.setPreconnectLevel(2);
                this.x = b;
            } else {
                try {
                    iVar = com.ss.android.socialbase.downloader.downloader.c.a(this.p.isNeedDefaultHttpServiceBackUp(), this.p.getMaxBytes(), str, null, list, this.I.b("net_lib_strategy"), this.I.a("monitor_download_connect", 0) > 0, this.p);
                    this.x = iVar;
                } catch (BaseException e2) {
                    throw e2;
                } catch (Throwable th) {
                    if (this.p.isExpiredRedownload() && com.ss.android.socialbase.downloader.i.f.g(th) && com.ss.android.socialbase.downloader.i.f.c(list)) {
                        com.ss.android.socialbase.downloader.c.a.b(a, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.p.getCacheControl());
                        long i2 = com.ss.android.socialbase.downloader.i.f.i(this.p.getCacheControl());
                        if (i2 <= 0) {
                            i2 = com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).a("default_304_max_age", 300);
                        }
                        this.p.setCacheExpiredTime(System.currentTimeMillis() + (i2 * 1000));
                        throw new com.ss.android.socialbase.downloader.exception.a(this.E);
                    }
                    if (com.ss.android.socialbase.downloader.i.f.f(th)) {
                        a("", "http code 416");
                    } else if (com.ss.android.socialbase.downloader.i.f.e(th)) {
                        a("", "http code 412");
                    } else {
                        com.ss.android.socialbase.downloader.i.f.a(th, "CreateFirstConnection");
                    }
                    iVar = this.x;
                }
                a(iVar);
            }
            if (this.x == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            a(this.x);
            throw th2;
        }
    }

    public static com.ss.android.socialbase.downloader.model.b a(DownloadInfo downloadInfo, long j2) {
        return new b.a(downloadInfo.getId()).a(-1).a(0L).e(j2).b(j2).c(0L).d(downloadInfo.getTotalBytes() - j2).a();
    }

    private List<com.ss.android.socialbase.downloader.model.c> a(com.ss.android.socialbase.downloader.model.b bVar) {
        List<com.ss.android.socialbase.downloader.model.c> a2 = com.ss.android.socialbase.downloader.i.f.a(this.p.getExtraHeaders(), this.p.geteTag(), bVar);
        if (this.p.isExpiredRedownload() && this.F && this.p.getLastModified() != null) {
            a2.add(new com.ss.android.socialbase.downloader.model.c("if-modified-since", this.p.getLastModified()));
            a2.add(new com.ss.android.socialbase.downloader.model.c("download-tc21-1-15", "download-tc21-1-15"));
            String str = a;
            com.ss.android.socialbase.downloader.c.a.b(str, "dcache::add head IF_MODIFIED_SINCE=" + this.p.getLastModified());
        }
        return a2;
    }

    private void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) throws BaseException {
        if (list.size() == i2) {
            a(list, this.p.getTotalBytes());
            return;
        }
        throw new BaseException(1033, new IllegalArgumentException());
    }

    private void a(long j2, int i2) throws BaseException {
        long j3 = j2 / i2;
        int id = this.p.getId();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        long j4 = 0;
        while (i3 < i2) {
            com.ss.android.socialbase.downloader.model.b a2 = new b.a(id).a(i3).a(j4).e(j4).b(j4).c(i3 == i2 + (-1) ? 0L : (j4 + j3) - 1).a();
            arrayList.add(a2);
            this.o.a(a2);
            j4 += j3;
            i3++;
        }
        this.p.setChunkCount(i2);
        this.o.a(id, i2);
        a(arrayList, j2);
    }

    private void a(List<com.ss.android.socialbase.downloader.model.b> list, long j2) throws BaseException {
        long p;
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                if (bVar.p() == 0) {
                    p = j2 - bVar.n();
                } else {
                    p = (bVar.p() - bVar.n()) + 1;
                }
                if (p > 0) {
                    bVar.a(p);
                    if (this.p.isNeedReuseFirstConnection() && this.x != null && (!this.p.isHeadConnectionAvailable() || this.D)) {
                        if (bVar.s() == 0) {
                            this.f5728f.add(new b(bVar, this.f5725c, this.x, this));
                        } else if (bVar.s() > 0) {
                            this.f5728f.add(new b(bVar, this.f5725c, this));
                        }
                    } else {
                        this.f5728f.add(new b(bVar, this.f5725c, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.i.a.a(64)) {
            ArrayList arrayList = new ArrayList(this.f5728f.size());
            Iterator<b> it = this.f5728f.iterator();
            while (it.hasNext()) {
                b next = it.next();
                if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                    next.b();
                } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                    next.a();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> d2 = com.ss.android.socialbase.downloader.impls.e.d(arrayList);
                for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = com.ss.android.socialbase.downloader.impls.e.e(d2)) {
                    if (v()) {
                        return;
                    }
                    runnable.run();
                }
                if (d2 == null || d2.isEmpty()) {
                    return;
                }
                for (Future future : d2) {
                    if (future != null && !future.isDone()) {
                        try {
                            future.get();
                        } catch (Throwable unused) {
                        }
                    }
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.f5728f.size());
        Iterator<b> it2 = this.f5728f.iterator();
        while (it2.hasNext()) {
            b next2 = it2.next();
            if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_CANCELED) {
                next2.b();
            } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_PAUSE) {
                next2.a();
            } else {
                arrayList2.add(Executors.callable(next2));
            }
        }
        if (v()) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.impls.e.c(arrayList2);
        } catch (InterruptedException e2) {
            throw new BaseException((int) PointerIconCompat.TYPE_GRAB, e2);
        }
    }

    private void a(com.ss.android.socialbase.downloader.model.b bVar, String str, i iVar) throws BaseException {
        bVar.a(this.p.getTotalBytes() - bVar.n());
        this.p.setChunkCount(1);
        this.o.a(this.p.getId(), 1);
        this.f5729g = new com.ss.android.socialbase.downloader.downloader.e(this.p, str, iVar, bVar, this);
        t();
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(long j2) throws BaseException {
        long j3;
        String tempPath = this.p.getTempPath();
        String tempName = this.p.getTempName();
        if (com.ss.android.socialbase.downloader.i.f.b(j2)) {
            return;
        }
        com.ss.android.socialbase.downloader.model.e a2 = com.ss.android.socialbase.downloader.i.f.a(this.p, tempPath, tempName, -1);
        try {
            long length = new File(tempPath, tempName).length();
            long j4 = j2 - length;
            long d2 = com.ss.android.socialbase.downloader.i.f.d(tempPath);
            com.ss.android.socialbase.downloader.g.a a3 = com.ss.android.socialbase.downloader.g.a.a(this.p.getId());
            if (a3.a("space_fill_part_download", 0) == 1) {
                this.G = 0L;
                if (j4 <= 0) {
                    j4 = this.p.getTotalBytes() - this.p.getCurBytes();
                }
                if (d2 < j4) {
                    String str = a;
                    com.ss.android.socialbase.downloader.c.a.d(str, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.i.f.a(j2) + "MB, downloaded = " + com.ss.android.socialbase.downloader.i.f.a(length) + "MB, required = " + com.ss.android.socialbase.downloader.i.f.a(j4) + "MB, available = " + com.ss.android.socialbase.downloader.i.f.a(d2) + "MB");
                    int i2 = (d2 > 0L ? 1 : (d2 == 0L ? 0 : -1));
                    if (i2 > 0) {
                        int a4 = a3.a("space_fill_min_keep_mb", 100);
                        if (a4 > 0) {
                            long j5 = d2 - (a4 * SVG.H);
                            com.ss.android.socialbase.downloader.c.a.d(str, "checkSpaceOverflow: minKeep = " + a4 + "MB, canDownload = " + com.ss.android.socialbase.downloader.i.f.a(j5) + "MB");
                            if (j5 > 0) {
                                this.G = this.p.getCurBytes() + j5;
                                j3 = j5;
                            } else {
                                throw new com.ss.android.socialbase.downloader.exception.d(d2, j4);
                            }
                        } else {
                            j3 = d2;
                        }
                        if (length < j2) {
                            if (j3 + length > j2) {
                            }
                            a2.b(j2);
                            com.ss.android.socialbase.downloader.i.f.a(a2);
                        }
                    } else if (a3.a("download_when_space_negative", 0) != 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("availableSpace ");
                        sb.append(i2 == 0 ? "=" : SimpleComparison.LESS_THAN_OPERATION);
                        sb.append(" 0");
                        throw new BaseException(1052, sb.toString());
                    } else {
                        a2.b(j2);
                        com.ss.android.socialbase.downloader.i.f.a(a2);
                    }
                }
            } else {
                int i3 = (d2 > 0L ? 1 : (d2 == 0L ? 0 : -1));
                if (i3 <= 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("availableSpace ");
                    sb2.append(i3 == 0 ? "=" : SimpleComparison.LESS_THAN_OPERATION);
                    sb2.append(" 0");
                    throw new BaseException(1052, sb2.toString());
                } else if (d2 < j4) {
                    throw new com.ss.android.socialbase.downloader.exception.d(d2, j4);
                }
            }
            a2.b(j2);
            com.ss.android.socialbase.downloader.i.f.a(a2);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.i.f.a(a2);
            throw th;
        }
    }

    private boolean a(int i2, String str, String str2) {
        if (i2 == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.f5733k || this.f5732j)) {
            return (i2 == 201 || i2 == 416) && this.p.getCurBytes() > 0;
        }
        return true;
    }

    private void a(String str, String str2) throws com.ss.android.socialbase.downloader.exception.i {
        this.o.d(this.p.getId());
        this.o.m(this.p.getId());
        com.ss.android.socialbase.downloader.i.f.a(this.p);
        this.f5731i = false;
        this.p.resetDataForEtagEndure(str);
        this.o.a(this.p);
        throw new com.ss.android.socialbase.downloader.exception.i(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0251, code lost:
        r2 = com.ss.android.socialbase.downloader.i.f.b(r11, "Content-Range");
        com.ss.android.socialbase.downloader.c.a.c(r14, "firstConnection: contentRange = " + r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x026f, code lost:
        if (android.text.TextUtils.isEmpty(r2) != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0279, code lost:
        if (r19.I.b("fix_get_total_bytes", true) == false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x027b, code lost:
        r8 = com.ss.android.socialbase.downloader.i.f.b(r2);
        com.ss.android.socialbase.downloader.c.a.c(r14, "firstConnection: 1 totalLength = " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0294, code lost:
        r11 = r22 + r9;
        com.ss.android.socialbase.downloader.c.a.e(r14, "firstConnection: 2 totalLength = " + r11 + ", contentLength = " + r9);
        r8 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x013b, code lost:
        com.ss.android.socialbase.downloader.i.f.a(r19.p);
     */
    @Override // com.ss.android.socialbase.downloader.h.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r20, com.ss.android.socialbase.downloader.network.g r21, long r22) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.i {
        /*
            Method dump skipped, instructions count: 799
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.a(java.lang.String, com.ss.android.socialbase.downloader.network.g, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(b bVar) {
        if (this.f5730h) {
            return;
        }
        synchronized (this) {
            this.f5728f.remove(bVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public boolean a(BaseException baseException) {
        if (this.K == null || !com.ss.android.socialbase.downloader.i.f.i(baseException) || this.f5727e.get() >= this.p.getRetryCount()) {
            if (com.ss.android.socialbase.downloader.i.f.b(baseException)) {
                if (this.f5730h && !this.f5726d) {
                    com.ss.android.socialbase.downloader.i.f.a(this.p);
                    this.f5726d = true;
                }
                return true;
            }
            AtomicInteger atomicInteger = this.f5727e;
            if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.p.hasNextBackupUrl()) {
                if (baseException == null) {
                    return false;
                }
                if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.p.canReplaceHttpForRetry()) {
                    return false;
                }
            }
            return !(baseException instanceof com.ss.android.socialbase.downloader.exception.f);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public void a(BaseException baseException, boolean z) {
        com.ss.android.socialbase.downloader.c.a.b(a, "onAllChunkRetryWithReset");
        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.w = baseException;
        I();
        if (z ? d(baseException) : false) {
            return;
        }
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.p.setForbiddenBackupUrls(list, this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.ss.android.socialbase.downloader.impls.a C = com.ss.android.socialbase.downloader.downloader.c.C();
        if (C != null) {
            C.l(this.p.getId());
        }
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public com.ss.android.socialbase.downloader.exception.h a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, long j2) {
        if (u()) {
            return com.ss.android.socialbase.downloader.exception.h.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.ss.android.socialbase.downloader.i.f.h(baseException))) {
            return a(baseException, j2);
        }
        this.w = baseException;
        this.p.increaseCurBytes(-j2);
        this.o.a(this.p);
        if (d(baseException)) {
            return com.ss.android.socialbase.downloader.exception.h.RETURN;
        }
        com.ss.android.socialbase.downloader.downloader.f fVar = this.v;
        com.ss.android.socialbase.downloader.constants.h hVar = this.n;
        com.ss.android.socialbase.downloader.constants.h hVar2 = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY;
        fVar.a(bVar, baseException, hVar == hVar2);
        if (this.n != hVar2 && this.p.isNeedRetryDelay()) {
            long A = A();
            if (A > 0) {
                String str = a;
                com.ss.android.socialbase.downloader.c.a.c(str, "onSingleChunkRetry with delay time " + A);
                try {
                    Thread.sleep(A);
                } catch (Throwable th) {
                    String str2 = a;
                    com.ss.android.socialbase.downloader.c.a.d(str2, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.exception.h.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public com.ss.android.socialbase.downloader.exception.h a(BaseException baseException, long j2) {
        long totalBytes;
        long j3;
        boolean z;
        this.w = baseException;
        this.p.increaseCurBytes(-j2);
        this.o.a(this.p);
        if (u()) {
            return com.ss.android.socialbase.downloader.exception.h.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.z != null && !this.p.isForbiddenRetryed()) {
                com.ss.android.socialbase.downloader.depend.b bVar = new com.ss.android.socialbase.downloader.depend.b() { // from class: com.ss.android.socialbase.downloader.h.c.1
                    @Override // com.ss.android.socialbase.downloader.depend.b, com.ss.android.socialbase.downloader.depend.v
                    public void a(List<String> list) {
                        super.a(list);
                        c.this.a(list);
                    }
                };
                boolean a2 = this.z.a(bVar);
                this.p.setForbiddenRetryed();
                if (a2) {
                    if (!bVar.a()) {
                        I();
                        this.v.h();
                        this.n = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.exception.h.RETURN;
                    }
                    z = true;
                }
            } else if (d(baseException)) {
                return com.ss.android.socialbase.downloader.exception.h.RETURN;
            }
            z = false;
        } else if (com.ss.android.socialbase.downloader.i.f.h(baseException)) {
            if (this.A == null) {
                b(baseException);
                return com.ss.android.socialbase.downloader.exception.h.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            q qVar = new q() { // from class: com.ss.android.socialbase.downloader.h.c.2
                @Override // com.ss.android.socialbase.downloader.depend.q
                public void a() {
                    synchronized (c.this) {
                        atomicBoolean.set(true);
                        c.this.J();
                    }
                }
            };
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.d) {
                com.ss.android.socialbase.downloader.exception.d dVar = (com.ss.android.socialbase.downloader.exception.d) baseException;
                j3 = dVar.a();
                totalBytes = dVar.b();
            } else {
                totalBytes = this.p.getTotalBytes();
                j3 = -1;
            }
            synchronized (this) {
                if (this.A.a(j3, totalBytes, qVar)) {
                    if (!com.ss.android.socialbase.downloader.g.a.a(this.p.getId()).b("not_delete_when_clean_space", false)) {
                        y();
                    }
                    if (!atomicBoolean.get()) {
                        com.ss.android.socialbase.downloader.constants.h hVar = this.n;
                        com.ss.android.socialbase.downloader.constants.h hVar2 = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        if (hVar != hVar2) {
                            this.n = hVar2;
                            I();
                            this.v.h();
                        }
                        return com.ss.android.socialbase.downloader.exception.h.RETURN;
                    }
                    if (d(baseException)) {
                        return com.ss.android.socialbase.downloader.exception.h.RETURN;
                    }
                    z = true;
                } else if (this.n == com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                    return com.ss.android.socialbase.downloader.exception.h.RETURN;
                } else {
                    b(baseException);
                    return com.ss.android.socialbase.downloader.exception.h.RETURN;
                }
            }
        } else {
            if (d(baseException)) {
                return com.ss.android.socialbase.downloader.exception.h.RETURN;
            }
            z = false;
        }
        if (!z && K()) {
            I();
        }
        com.ss.android.socialbase.downloader.downloader.f fVar = this.v;
        com.ss.android.socialbase.downloader.constants.h hVar3 = this.n;
        com.ss.android.socialbase.downloader.constants.h hVar4 = com.ss.android.socialbase.downloader.constants.h.RUN_STATUS_RETRY_DELAY;
        fVar.a(baseException, hVar3 == hVar4);
        return this.n == hVar4 ? com.ss.android.socialbase.downloader.exception.h.RETURN : com.ss.android.socialbase.downloader.exception.h.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.h.f
    public synchronized com.ss.android.socialbase.downloader.model.b a(int i2) {
        com.ss.android.socialbase.downloader.model.b a2;
        if (this.p.getChunkCount() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.model.b> c2 = this.o.c(this.p.getId());
        if (c2 != null && !c2.isEmpty()) {
            for (int i3 = 0; i3 < c2.size(); i3++) {
                com.ss.android.socialbase.downloader.model.b bVar = c2.get(i3);
                if (bVar != null && (a2 = a(bVar, i2)) != null) {
                    return a2;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    @Override // com.ss.android.socialbase.downloader.h.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.ss.android.socialbase.downloader.network.g r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L1a
            int r2 = r2.b()     // Catch: java.lang.Throwable -> L16
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r1.p     // Catch: java.lang.Throwable -> L16
            r0.setHttpStatusCode(r2)     // Catch: java.lang.Throwable -> L16
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r1.p     // Catch: java.lang.Throwable -> L16
            java.lang.String r2 = com.ss.android.socialbase.downloader.i.b.a(r2)     // Catch: java.lang.Throwable -> L16
            r0.setHttpStatusMessage(r2)     // Catch: java.lang.Throwable -> L16
            r2 = 1
            goto L1b
        L16:
            r2 = move-exception
            r2.printStackTrace()
        L1a:
            r2 = 0
        L1b:
            if (r2 != 0) goto L2a
            com.ss.android.socialbase.downloader.model.DownloadInfo r2 = r1.p
            r0 = -1
            r2.setHttpStatusCode(r0)
            com.ss.android.socialbase.downloader.model.DownloadInfo r2 = r1.p
            java.lang.String r0 = ""
            r2.setHttpStatusMessage(r0)
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.a(com.ss.android.socialbase.downloader.network.g):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r9.f() != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.model.b a(com.ss.android.socialbase.downloader.model.b r9, int r10) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.h.c.a(com.ss.android.socialbase.downloader.model.b, int):com.ss.android.socialbase.downloader.model.b");
    }

    private s a(DownloadTask downloadTask) {
        s retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new com.ss.android.socialbase.downloader.impls.q(retryDelayTimeArray);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.c.L();
    }

    public void a(Future future) {
        this.b = future;
    }
}
