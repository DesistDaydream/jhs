package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.af;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes3.dex */
public abstract class a implements h.a {
    private final SparseArray<DownloadTask> b = new SparseArray<>();

    /* renamed from: c */
    private final SparseArray<DownloadTask> f5756c = new SparseArray<>();

    /* renamed from: d */
    private final SparseArray<DownloadTask> f5757d = new SparseArray<>();

    /* renamed from: e */
    private final SparseArray<DownloadTask> f5758e = new SparseArray<>();

    /* renamed from: f */
    private final SparseArray<DownloadTask> f5759f = new SparseArray<>();

    /* renamed from: g */
    private final SparseArray<SparseArray<DownloadTask>> f5760g = new SparseArray<>();

    /* renamed from: h */
    private final com.ss.android.socialbase.downloader.i.h<Integer, DownloadTask> f5761h = new com.ss.android.socialbase.downloader.i.h<>();

    /* renamed from: i */
    private final SparseArray<Long> f5762i = new SparseArray<>();

    /* renamed from: j */
    private final LinkedBlockingDeque<DownloadTask> f5763j = new LinkedBlockingDeque<>();
    public final com.ss.android.socialbase.downloader.h.h a = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this);

    /* renamed from: k */
    private final com.ss.android.socialbase.downloader.downloader.j f5764k = com.ss.android.socialbase.downloader.downloader.c.x();

    private void c(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.f5763j.isEmpty()) {
                a(downloadTask, true);
                this.f5763j.put(downloadTask);
            } else if (downloadInfo.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) {
                if (this.f5763j.getFirst().getDownloadId() == downloadTask.getDownloadId() && a(downloadTask.getDownloadId())) {
                    return;
                }
                Iterator<DownloadTask> it = this.f5763j.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DownloadTask next = it.next();
                    if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                        it.remove();
                        break;
                    }
                }
                this.f5763j.put(downloadTask);
                new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.a).a();
            } else {
                DownloadTask first = this.f5763j.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && a(downloadTask.getDownloadId())) {
                    return;
                }
                e(first.getDownloadId());
                a(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.f5763j.putFirst(downloadTask);
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    public DownloadTask o(int i2) {
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask == null) {
            DownloadTask downloadTask2 = this.f5757d.get(i2);
            if (downloadTask2 == null) {
                DownloadTask downloadTask3 = this.f5756c.get(i2);
                if (downloadTask3 == null) {
                    DownloadTask downloadTask4 = this.f5758e.get(i2);
                    return downloadTask4 == null ? this.f5759f.get(i2) : downloadTask4;
                }
                return downloadTask3;
            }
            return downloadTask2;
        }
        return downloadTask;
    }

    private void p(int i2) {
        DownloadTask first;
        if (this.f5763j.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.f5763j.getFirst();
        if (first2 != null && first2.getDownloadId() == i2) {
            this.f5763j.poll();
        }
        if (this.f5763j.isEmpty() || (first = this.f5763j.getFirst()) == null) {
            return;
        }
        a(first, true);
    }

    public abstract List<Integer> a();

    public abstract void a(int i2, long j2);

    public abstract void a(int i2, DownloadTask downloadTask);

    public abstract void a(com.ss.android.socialbase.downloader.h.c cVar);

    public abstract boolean a(int i2);

    public abstract void b(int i2);

    public abstract com.ss.android.socialbase.downloader.h.c c(int i2);

    public synchronized DownloadInfo d(int i2) {
        DownloadInfo b;
        DownloadTask downloadTask;
        b = this.f5764k.b(i2);
        if (b == null && (downloadTask = this.b.get(i2)) != null) {
            b = downloadTask.getDownloadInfo();
        }
        return b;
    }

    public synchronized boolean e(int i2) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "pause id=" + i2);
        DownloadInfo b = this.f5764k.b(i2);
        if (b == null || b.getStatus() != 11) {
            synchronized (this.b) {
                b(i2);
            }
            if (b == null) {
                DownloadTask downloadTask = this.b.get(i2);
                if (downloadTask != null) {
                    new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.a).d();
                    return true;
                }
            } else {
                a(b);
                if (b.getStatus() == 1) {
                    DownloadTask downloadTask2 = this.b.get(i2);
                    if (downloadTask2 != null) {
                        new com.ss.android.socialbase.downloader.downloader.f(downloadTask2, this.a).d();
                        return true;
                    }
                } else if (DownloadStatus.isDownloading(b.getStatus())) {
                    b.setStatus(-2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public synchronized boolean f(int i2) {
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            a(downloadTask);
        } else {
            g(i2);
        }
        return true;
    }

    public synchronized boolean g(int i2) {
        DownloadTask downloadTask = this.f5757d.get(i2);
        if (downloadTask == null) {
            downloadTask = this.f5758e.get(i2);
        }
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            a(downloadTask);
            return true;
        }
        return false;
    }

    public synchronized af h(int i2) {
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.f5756c.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.f5757d.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.f5758e.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.f5759f.get(i2);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationClickCallback();
        }
        return null;
    }

    public synchronized z i(int i2) {
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.f5756c.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.f5757d.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.f5758e.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.f5759f.get(i2);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationEventListener();
        }
        return null;
    }

    public synchronized IDownloadFileUriProvider j(int i2) {
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.f5756c.get(i2);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.f5757d.get(i2);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.f5758e.get(i2);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.f5759f.get(i2);
        if (downloadTask5 != null) {
            return downloadTask5.getFileUriProvider();
        }
        return null;
    }

    public synchronized boolean k(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f5758e.get(i2);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                a(downloadTask, false);
            }
            return true;
        }
        DownloadInfo b = this.f5764k.b(i2);
        if (b != null && b.canStartRetryDelayTask()) {
            a(new DownloadTask(b), false);
        }
        return false;
    }

    public synchronized boolean l(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f5759f.get(i2);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            a(downloadTask);
        }
        return true;
    }

    public synchronized void m(int i2) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            a(downloadTask);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0011, code lost:
        if (r1.f5757d.get(r2) != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean n(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L18
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.b     // Catch: java.lang.Throwable -> L15
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L15
            if (r0 != 0) goto L13
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f5757d     // Catch: java.lang.Throwable -> L15
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> L15
            if (r2 == 0) goto L18
        L13:
            r2 = 1
            goto L19
        L15:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L18:
            r2 = 0
        L19:
            monitor-exit(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.a.n(int):boolean");
    }

    private void b(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f5760g.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f5760g.put(downloadTask.getDownloadId(), sparseArray);
        }
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void a(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int i2;
        DownloadInfo downloadInfo2;
        DownloadTask remove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            x monitorDepend = downloadTask.getMonitorDepend();
            com.ss.android.socialbase.downloader.d.a.a(monitorDepend, downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).a("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.i.f.c(com.ss.android.socialbase.downloader.downloader.c.N()) && !downloadInfo.isFirstDownload()) {
            new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.a).a(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            a(downloadInfo);
        }
        if (this.f5757d.get(id) != null) {
            this.f5757d.remove(id);
        }
        if (this.f5756c.get(id) != null) {
            this.f5756c.remove(id);
        }
        if (this.f5758e.get(id) != null) {
            this.f5758e.remove(id);
        }
        if (this.f5759f.get(id) != null) {
            this.f5759f.remove(id);
        }
        if (a(id) && !downloadInfo.canReStartAsyncTask()) {
            com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.ss.android.socialbase.downloader.d.a.a(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "no downloading task :" + id);
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.a.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.i.a.a(32768) && (remove = this.f5761h.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.b.get(id);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            i2 = 0;
        } else {
            i2 = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(i2)) {
                z2 = true;
            }
        }
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + i2);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        b(downloadTask);
        this.b.put(id, downloadTask);
        this.f5762i.put(id, Long.valueOf(uptimeMillis));
        a(id, downloadTask);
    }

    public synchronized void d(int i2, boolean z) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i2 + " deleteTargetFile=" + z);
        DownloadInfo b = this.f5764k.b(i2);
        if (b != null) {
            if (z) {
                com.ss.android.socialbase.downloader.i.f.a(b);
            } else {
                com.ss.android.socialbase.downloader.i.f.c(b.getTempPath(), b.getTempName());
            }
            b.erase();
        }
        try {
            this.f5764k.f(i2);
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        a(i2, 0, -4);
        if (this.f5757d.get(i2) != null) {
            this.f5757d.remove(i2);
        }
        if (this.f5756c.get(i2) != null) {
            this.f5756c.remove(i2);
        }
        this.f5761h.remove(Integer.valueOf(i2));
        com.ss.android.socialbase.downloader.g.a.b(i2);
    }

    public synchronized void b(List<String> list) {
        DownloadInfo downloadInfo;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N())) {
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                DownloadTask downloadTask = this.b.get(this.b.keyAt(i2));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && b(downloadInfo)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    a(downloadTask);
                    downloadInfo.setDownloadFromReserveWifi(true);
                    com.ss.android.socialbase.downloader.downloader.r reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.c.N()).getReserveWifiStatusListener();
                    if (reserveWifiStatusListener != null) {
                        reserveWifiStatusListener.a(downloadInfo, 5, 2);
                    }
                }
            }
        }
    }

    public void c(final int i2, final boolean z) {
        DownloadInfo b = this.f5764k.b(i2);
        if (b != null) {
            a(b);
        }
        this.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.4
            {
                a.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.a().f(i2);
            }
        });
        com.ss.android.socialbase.downloader.downloader.c.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.5
            {
                a.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(i2);
                a.this.e(i2, z);
            }
        }, false);
    }

    public void e(int i2, boolean z) {
        try {
            DownloadInfo b = this.f5764k.b(i2);
            if (b != null) {
                com.ss.android.socialbase.downloader.i.f.a(b, z);
                b.erase();
            }
            try {
                this.f5764k.d(i2);
                this.f5764k.a(b);
            } catch (SQLiteException e2) {
                e2.printStackTrace();
            }
            if (this.f5757d.get(i2) != null) {
                this.f5757d.remove(i2);
            }
            if (this.f5756c.get(i2) != null) {
                this.f5756c.remove(i2);
            }
            this.f5761h.remove(Integer.valueOf(i2));
            com.ss.android.socialbase.downloader.g.a.b(i2);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean b(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void b() {
        List<Integer> a = a();
        if (a == null) {
            return;
        }
        for (Integer num : a) {
            e(num.intValue());
        }
    }

    public void b(final int i2, final boolean z) {
        DownloadInfo b = this.f5764k.b(i2);
        if (b != null) {
            a(b);
        }
        this.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.2
            {
                a.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.b.a().f(i2);
            }
        });
        com.ss.android.socialbase.downloader.downloader.c.a(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.3
            {
                a.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                DownloadTask o;
                if (a.this.c(i2) == null && (o = a.this.o(i2)) != null) {
                    DownloadInfo downloadInfo = o.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = o.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i3 = 0; i3 < downloadListeners.size(); i3++) {
                                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i3));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                }
                a.this.d(i2, z);
            }
        }, false);
    }

    public synchronized void b(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        a(i2, i3, iDownloadListener, fVar, z, true);
    }

    public List<DownloadInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : a()) {
            DownloadInfo d2 = d(num.intValue());
            if (d2 != null && str.equals(d2.getMimeType())) {
                arrayList.add(d2);
            }
        }
        return arrayList;
    }

    public synchronized void a(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            c(downloadTask);
        } else {
            a(downloadTask, true);
        }
    }

    public void b(int i2, long j2) {
        DownloadInfo b = this.f5764k.b(i2);
        if (b != null) {
            b.setThrottleNetSpeed(j2);
        }
        a(i2, j2);
    }

    public synchronized List<DownloadInfo> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> a = this.f5764k.a(str);
        if (a == null || a.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = this.b.size();
            for (int i2 = 0; i2 < size; i2++) {
                DownloadTask valueAt = this.b.valueAt(i2);
                if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                    arrayList.add(valueAt.getDownloadInfo());
                }
            }
            return arrayList;
        }
        return a;
    }

    public synchronized boolean a(int i2, boolean z) {
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask == null && com.ss.android.socialbase.downloader.i.a.a(65536)) {
            downloadTask = o(i2);
        }
        if (downloadTask != null) {
            if (!com.ss.android.socialbase.downloader.g.a.a(i2).b("fix_on_cancel_call_twice", true)) {
                new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.a).c();
            }
            final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            final SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            final SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            this.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.1
                {
                    a.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    SparseArray sparseArray;
                    SparseArray sparseArray2 = downloadListeners;
                    if (sparseArray2 != null) {
                        synchronized (sparseArray2) {
                            for (int i3 = 0; i3 < downloadListeners.size(); i3++) {
                                IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i3));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                    DownloadInfo downloadInfo2 = downloadInfo;
                    if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                        return;
                    }
                    synchronized (sparseArray) {
                        for (int i4 = 0; i4 < downloadListeners2.size(); i4++) {
                            IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i4));
                            if (iDownloadListener2 != null) {
                                iDownloadListener2.onCanceled(downloadInfo);
                            }
                        }
                    }
                }
            });
        }
        DownloadInfo b = this.f5764k.b(i2);
        if (com.ss.android.socialbase.downloader.i.a.a(65536)) {
            if (b != null) {
                b.setStatus(-4);
            }
        } else if (b != null && DownloadStatus.isDownloading(b.getStatus())) {
            b.setStatus(-4);
        }
        b(i2, z);
        return true;
    }

    private void a(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.g.DELAY_RETRY_NONE);
                    com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void a(int i2, z zVar) {
        DownloadTask downloadTask = this.b.get(i2);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(zVar);
        }
    }

    public synchronized void a(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean b = com.ss.android.socialbase.downloader.i.a.a(1048576) ? com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N()) : true;
            for (int i2 = 0; i2 < this.f5757d.size(); i2++) {
                DownloadTask downloadTask = this.f5757d.get(this.f5757d.keyAt(i2));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || b)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    a(downloadTask);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public synchronized void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z) {
        DownloadTask o = o(i2);
        if (o == null) {
            o = this.f5761h.get(Integer.valueOf(i2));
        }
        if (o != null) {
            o.removeDownloadListener(i3, iDownloadListener, fVar, z);
        }
    }

    public synchronized void a(int i2, int i3, final IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z, boolean z2) {
        DownloadInfo b;
        DownloadTask o = o(i2);
        if (o != null) {
            o.addDownloadListener(i3, iDownloadListener, fVar, z);
            final DownloadInfo downloadInfo = o.getDownloadInfo();
            if (z2 && downloadInfo != null && !a(i2) && (fVar == com.ss.android.socialbase.downloader.constants.f.MAIN || fVar == com.ss.android.socialbase.downloader.constants.f.NOTIFICATION)) {
                boolean z3 = true;
                if (fVar == com.ss.android.socialbase.downloader.constants.f.NOTIFICATION && !downloadInfo.canShowNotification()) {
                    z3 = false;
                }
                if (z3) {
                    this.a.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.a.6
                        {
                            a.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (iDownloadListener != null) {
                                if (downloadInfo.getStatus() == -3) {
                                    iDownloadListener.onSuccessed(downloadInfo);
                                } else if (downloadInfo.getStatus() == -1) {
                                    iDownloadListener.onFailed(downloadInfo, new BaseException(1000, "try add listener for failed task"));
                                }
                            }
                        }
                    });
                }
            }
        } else if (com.ss.android.socialbase.downloader.i.a.a(32768) && (b = this.f5764k.b(i2)) != null && b.getStatus() != -3) {
            DownloadTask downloadTask = this.f5761h.get(Integer.valueOf(i2));
            if (downloadTask == null) {
                downloadTask = new DownloadTask(b);
                this.f5761h.put(Integer.valueOf(i2), downloadTask);
            }
            downloadTask.addDownloadListener(i3, iDownloadListener, fVar, z);
        }
    }

    private void a(int i2, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.ss.android.socialbase.downloader.i.c.a(i2, downloadListeners, true, downloadInfo, baseException);
            com.ss.android.socialbase.downloader.i.c.a(i2, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    private void a(int i2, int i3) {
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "removeTask id: " + i2 + " listener hasCode: " + i3);
        if (i3 == 0) {
            this.b.remove(i2);
            this.f5760g.remove(i2);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f5760g.get(i2);
        if (sparseArray != null) {
            sparseArray.remove(i3);
            com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.b.remove(i2);
                this.f5760g.remove(i2);
                return;
            }
            return;
        }
        this.b.remove(i2);
    }

    public synchronized void a(int i2, int i3, int i4) {
        if (i4 != -7) {
            if (i4 == -6) {
                this.f5756c.put(i2, this.b.get(i2));
                a(i2, i3);
            } else if (i4 == -4) {
                a(i2, i3);
                p(i2);
            } else if (i4 == -3) {
                this.f5756c.put(i2, this.b.get(i2));
                a(i2, i3);
                p(i2);
            } else if (i4 != -1) {
                if (i4 == 7) {
                    DownloadTask downloadTask = this.b.get(i2);
                    if (downloadTask != null) {
                        if (this.f5758e.get(i2) == null) {
                            this.f5758e.put(i2, downloadTask);
                        }
                        a(i2, i3);
                    }
                    p(i2);
                } else if (i4 == 8) {
                    DownloadTask downloadTask2 = this.b.get(i2);
                    if (downloadTask2 != null && this.f5759f.get(i2) == null) {
                        this.f5759f.put(i2, downloadTask2);
                    }
                    p(i2);
                }
            }
        }
        DownloadTask downloadTask3 = this.b.get(i2);
        if (downloadTask3 != null) {
            if (this.f5757d.get(i2) == null) {
                this.f5757d.put(i2, downloadTask3);
            }
            a(i2, i3);
        }
        p(i2);
    }

    @Override // com.ss.android.socialbase.downloader.h.h.a
    public void a(Message message) {
        int i2 = message.arg1;
        int i3 = message.arg2;
        com.ss.android.socialbase.downloader.c.a.b("AbsDownloadEngine", "handleMsg id: " + i2 + " listener hasCode: " + i3);
        Object obj = message.obj;
        DownloadTask downloadTask = null;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (this) {
            if (i3 == 0) {
                downloadTask = this.b.get(i2);
            } else {
                SparseArray<DownloadTask> sparseArray = this.f5760g.get(i2);
                if (sparseArray != null) {
                    downloadTask = sparseArray.get(i3);
                }
            }
            if (downloadTask == null) {
                return;
            }
            a(message.what, baseException, downloadTask);
            a(i2, i3, message.what);
        }
    }
}
