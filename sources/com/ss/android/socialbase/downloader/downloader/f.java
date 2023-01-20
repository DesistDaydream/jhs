package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ai;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import org.conscrypt.NativeConstants;

/* loaded from: classes3.dex */
public class f {
    private static final String a = "f";
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private DownloadInfo f5623c;

    /* renamed from: d  reason: collision with root package name */
    private final j f5624d;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f5625e;

    /* renamed from: f  reason: collision with root package name */
    private DownloadTask f5626f;

    /* renamed from: g  reason: collision with root package name */
    private SparseArray<IDownloadListener> f5627g;

    /* renamed from: h  reason: collision with root package name */
    private SparseArray<IDownloadListener> f5628h;

    /* renamed from: i  reason: collision with root package name */
    private SparseArray<IDownloadListener> f5629i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5630j = false;

    /* renamed from: k  reason: collision with root package name */
    private volatile long f5631k = 0;

    /* renamed from: l  reason: collision with root package name */
    private final AtomicLong f5632l = new AtomicLong();

    /* renamed from: m  reason: collision with root package name */
    private boolean f5633m = false;
    private int n;
    private long o;
    private com.ss.android.socialbase.downloader.depend.n p;
    private x q;

    public f(DownloadTask downloadTask, Handler handler) {
        this.f5626f = downloadTask;
        j();
        this.f5625e = handler;
        this.f5624d = c.x();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.b = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("fix_start_with_file_exist_update_error");
        } else {
            this.b = false;
        }
    }

    private void j() {
        DownloadTask downloadTask = this.f5626f;
        if (downloadTask != null) {
            this.f5623c = downloadTask.getDownloadInfo();
            this.f5627g = this.f5626f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            this.f5629i = this.f5626f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            this.f5628h = this.f5626f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
            this.p = this.f5626f.getDepend();
            this.q = this.f5626f.getMonitorDepend();
        }
    }

    private void k() {
        ExecutorService l2 = c.l();
        if (l2 != null) {
            l2.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.f5624d.i(f.this.f5623c.getId());
                    f.this.a(1, (BaseException) null);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            com.ss.android.socialbase.downloader.c.a.b(a, "saveFileAsTargetName onSuccess");
            try {
                m();
                this.f5623c.setFirstSuccess(false);
                this.f5623c.setSuccessByCache(false);
                a(-3, (BaseException) null);
                this.f5624d.c(this.f5623c.getId(), this.f5623c.getTotalBytes());
                this.f5624d.d(this.f5623c.getId());
                this.f5624d.m(this.f5623c.getId());
            } catch (BaseException e2) {
                a(e2);
            }
        } catch (Throwable th) {
            a(new BaseException(1008, com.ss.android.socialbase.downloader.i.f.b(th, "onCompleted")));
        }
    }

    private void m() throws BaseException {
        List<com.ss.android.socialbase.downloader.depend.m> downloadCompleteHandlers = this.f5626f.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.f5623c;
        a(11, (BaseException) null);
        this.f5624d.a(downloadInfo);
        for (com.ss.android.socialbase.downloader.depend.m mVar : downloadCompleteHandlers) {
            try {
                if (mVar.b(downloadInfo)) {
                    mVar.a(downloadInfo);
                    this.f5624d.a(downloadInfo);
                }
            } catch (BaseException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    public void d() {
        this.f5623c.setStatus(-2);
        try {
            this.f5624d.d(this.f5623c.getId(), this.f5623c.getCurBytes());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(-2, (BaseException) null);
    }

    public void e() {
        this.f5623c.setStatus(-7);
        try {
            this.f5624d.j(this.f5623c.getId());
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(-7, (BaseException) null);
    }

    public void f() {
        this.f5623c.setFirstDownload(false);
        if (!this.f5623c.isIgnoreDataVerify() && this.f5623c.getCurBytes() != this.f5623c.getTotalBytes()) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f5623c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(NativeConstants.SSL_SIGN_ECDSA_SECP256R1_SHA256, "current bytes is not equals to total bytes, bytes changed with process : " + this.f5623c.getByteInvalidRetryStatus()));
        } else if (this.f5623c.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f5623c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes changed with process : " + this.f5623c.getByteInvalidRetryStatus()));
        } else if (!this.f5623c.isIgnoreDataVerify() && this.f5623c.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.c.a.b(a, this.f5623c.getErrorBytesLog());
            a(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes changed with process : " + this.f5623c.getByteInvalidRetryStatus()));
        } else {
            String str = a;
            com.ss.android.socialbase.downloader.c.a.b(str, "" + this.f5623c.getName() + " onCompleted start save file as target name");
            x xVar = this.q;
            DownloadTask downloadTask = this.f5626f;
            if (downloadTask != null) {
                xVar = downloadTask.getMonitorDepend();
            }
            com.ss.android.socialbase.downloader.i.f.a(this.f5623c, xVar, new ai() { // from class: com.ss.android.socialbase.downloader.downloader.f.2
                @Override // com.ss.android.socialbase.downloader.depend.ai
                public void a() {
                    f.this.l();
                }

                @Override // com.ss.android.socialbase.downloader.depend.ai
                public void a(BaseException baseException) {
                    String str2 = f.a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("saveFileAsTargetName onFailed : ");
                    sb.append(baseException != null ? baseException.getErrorMessage() : "");
                    com.ss.android.socialbase.downloader.c.a.b(str2, sb.toString());
                    f.this.a(baseException);
                }
            });
        }
    }

    public void g() throws BaseException {
        if (this.b) {
            m();
            com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
            this.f5623c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.f5624d.c(this.f5623c.getId(), this.f5623c.getTotalBytes());
            this.f5624d.d(this.f5623c.getId());
            this.f5624d.a(this.f5623c);
            this.f5624d.m(this.f5623c.getId());
            return;
        }
        m();
        com.ss.android.socialbase.downloader.c.a.b(a, "onCompleteForFileExist");
        this.f5623c.setSuccessByCache(true);
        a(-3, (BaseException) null);
        this.f5624d.c(this.f5623c.getId(), this.f5623c.getTotalBytes());
        this.f5624d.d(this.f5623c.getId());
        this.f5624d.m(this.f5623c.getId());
    }

    public void h() {
        this.f5623c.setStatus(8);
        this.f5623c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.a C = c.C();
        if (C != null) {
            C.a(this.f5623c.getId(), this.f5626f.getHashCodeForSameTask(), 8);
        }
    }

    public void b() {
        if (this.f5623c.canSkipStatusHandler()) {
            this.f5623c.changeSkipStatus();
            return;
        }
        this.f5624d.g(this.f5623c.getId());
        if (this.f5623c.isFirstDownload()) {
            a(6, (BaseException) null);
        }
        a(2, (BaseException) null);
    }

    public void c() {
        a(-4, (BaseException) null);
    }

    private BaseException c(BaseException baseException) {
        Context N;
        if (com.ss.android.socialbase.downloader.g.a.a(this.f5623c.getId()).a("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.i.f.i(baseException) || (N = c.N()) == null || com.ss.android.socialbase.downloader.i.f.c(N)) {
            return baseException;
        }
        return new BaseException(this.f5623c.isOnlyWifi() ? 1013 : 1049, baseException.getErrorMessage());
    }

    public void a() {
        if (this.f5623c.canSkipStatusHandler()) {
            return;
        }
        this.f5623c.setStatus(1);
        k();
    }

    public void a(long j2, String str, String str2) {
        this.f5623c.setTotalBytes(j2);
        this.f5623c.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.f5623c.getName())) {
            this.f5623c.setName(str2);
        }
        try {
            this.f5624d.a(this.f5623c.getId(), j2, str, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(3, (BaseException) null);
        this.o = this.f5623c.getMinByteIntervalForPostToMainThread(j2);
        this.n = this.f5623c.getMinProgressTimeMsInterval();
        this.f5630j = true;
        com.ss.android.socialbase.downloader.impls.r.a().e();
    }

    private void b(BaseException baseException) {
        String str = a;
        Log.d(str, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.f5624d.f(this.f5623c.getId());
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
        } else {
            try {
                try {
                    this.f5624d.b(this.f5623c.getId(), this.f5623c.getCurBytes());
                } catch (SQLiteException e3) {
                    e3.printStackTrace();
                }
            } catch (SQLiteException unused) {
                this.f5624d.f(this.f5623c.getId());
            }
        }
        BaseException c2 = c(baseException);
        this.f5623c.setFailedException(c2);
        a(c2 instanceof com.ss.android.socialbase.downloader.exception.e ? -2 : -1, c2);
        if (com.ss.android.socialbase.downloader.g.a.a(this.f5623c.getId()).a("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.r.a().a(this.f5623c);
        }
    }

    public boolean a(long j2) {
        this.f5632l.addAndGet(j2);
        this.f5623c.increaseCurBytes(j2);
        long uptimeMillis = SystemClock.uptimeMillis();
        return a(uptimeMillis, b(uptimeMillis));
    }

    private boolean b(long j2) {
        boolean z = true;
        if (!this.f5633m) {
            this.f5633m = true;
            return true;
        }
        long j3 = j2 - this.f5631k;
        if (this.f5632l.get() < this.o && j3 < this.n) {
            z = false;
        }
        if (z) {
            this.f5631k = j2;
            this.f5632l.set(0L);
        }
        return z;
    }

    public void a(BaseException baseException, boolean z) {
        this.f5623c.setFirstDownload(false);
        this.f5632l.set(0L);
        b(baseException, z);
    }

    public void a(com.ss.android.socialbase.downloader.model.b bVar, BaseException baseException, boolean z) {
        this.f5623c.setFirstDownload(false);
        this.f5632l.set(0L);
        this.f5624d.h(this.f5623c.getId());
        a(z ? 10 : 9, baseException, true);
    }

    private void b(BaseException baseException, boolean z) {
        this.f5624d.h(this.f5623c.getId());
        a(z ? 7 : 5, baseException);
    }

    public void a(BaseException baseException) {
        this.f5623c.setFirstDownload(false);
        b(baseException);
    }

    public void a(String str) throws BaseException {
        String str2 = a;
        com.ss.android.socialbase.downloader.c.a.b(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.f5623c.getName());
        if (this.b) {
            com.ss.android.socialbase.downloader.i.f.a(this.f5623c, str);
            m();
            this.f5623c.setSuccessByCache(true);
            a(-3, (BaseException) null);
            this.f5624d.a(this.f5623c);
            return;
        }
        this.f5624d.a(this.f5623c);
        com.ss.android.socialbase.downloader.i.f.a(this.f5623c, str);
        this.f5623c.setSuccessByCache(true);
        m();
        a(-3, (BaseException) null);
    }

    private boolean a(long j2, boolean z) {
        boolean z2 = false;
        if (this.f5623c.getCurBytes() == this.f5623c.getTotalBytes()) {
            try {
                this.f5624d.a(this.f5623c.getId(), this.f5623c.getCurBytes());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return false;
        }
        if (this.f5630j) {
            this.f5630j = false;
            this.f5623c.setStatus(4);
        }
        if (this.f5623c.isNeedPostProgress() && z) {
            z2 = true;
        }
        a(4, (BaseException) null, z2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, BaseException baseException) {
        a(i2, baseException, true);
    }

    private void a(int i2, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.f5623c.getStatus();
        if (status == -3 && i2 == 4) {
            return;
        }
        j();
        if (i2 != 4 && DownloadStatus.isRealTimeUploadStatus(i2)) {
            this.f5623c.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i2)) {
                this.f5623c.updateDownloadTime();
            }
        }
        if (!this.f5623c.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.d.a.a(this.f5626f, baseException, i2);
        }
        if (i2 == 6) {
            this.f5623c.setStatus(2);
        } else if (i2 == -6) {
            this.f5623c.setStatus(-3);
        } else {
            this.f5623c.setStatus(i2);
        }
        if (status == -3 || status == -1) {
            if (this.f5623c.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADING) {
                this.f5623c.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_DOWNLOADED);
            }
            if (this.f5623c.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADING) {
                this.f5623c.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.f5623c.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.f5623c.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.b.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.i.c.a(i2, this.f5628h, true, this.f5623c, baseException);
        if (i2 == -4) {
            return;
        }
        if (z && this.f5625e != null && (((sparseArray = this.f5627g) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f5629i) != null && sparseArray2.size() > 0 && (this.f5623c.canShowNotification() || this.f5623c.isAutoInstallWithoutNotification())))) {
            this.f5625e.obtainMessage(i2, this.f5623c.getId(), this.f5626f.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.a C = c.C();
        if (C != null) {
            C.a(this.f5623c.getId(), this.f5626f.getHashCodeForSameTask(), i2);
        }
    }
}
