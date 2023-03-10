package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.downloader.t;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.vector.view.pager.ViewPager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class d implements com.ss.android.socialbase.downloader.downloader.j {
    private t b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f5770c;

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f5771d;

    /* renamed from: f  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.h.h f5773f;

    /* renamed from: e  reason: collision with root package name */
    private h.a f5772e = new h.a() { // from class: com.ss.android.socialbase.downloader.impls.d.1
        @Override // com.ss.android.socialbase.downloader.h.h.a
        public void a(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.c.l().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.d.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            d.this.i();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
            }
        }
    };
    private final k a = new k();

    public d() {
        this.f5773f = null;
        if (com.ss.android.socialbase.downloader.g.a.c().a("fix_sigbus_downloader_db")) {
            if (!com.ss.android.socialbase.downloader.i.f.a() && com.ss.android.socialbase.downloader.downloader.c.S()) {
                this.b = com.ss.android.socialbase.downloader.downloader.c.T().a(new c.a.InterfaceC0207a() { // from class: com.ss.android.socialbase.downloader.impls.d.2
                    @Override // com.ss.android.socialbase.downloader.downloader.c.a.InterfaceC0207a
                    public void a() {
                        d.this.b = new com.ss.android.socialbase.downloader.b.e();
                        Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                    }
                });
            } else {
                this.b = new com.ss.android.socialbase.downloader.b.e();
            }
        } else {
            this.b = new com.ss.android.socialbase.downloader.b.e();
        }
        this.f5770c = false;
        this.f5773f = new com.ss.android.socialbase.downloader.h.h(Looper.getMainLooper(), this.f5772e);
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        synchronized (this) {
            this.f5770c = true;
            notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> c(String str) {
        return this.a.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean d() {
        return this.f5770c;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e() {
        if (this.f5770c) {
            return true;
        }
        synchronized (this) {
            if (!this.f5770c) {
                com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
                com.ss.android.socialbase.downloader.c.a.d("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.f5770c;
    }

    public t f() {
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo g(int i2) {
        DownloadInfo g2 = this.a.g(i2);
        c(g2);
        return g2;
    }

    public void h() {
        long j2;
        if (com.ss.android.socialbase.downloader.g.a.c().a("task_resume_delay")) {
            j2 = ViewPager.DEFAULT_INTERVAL;
        } else {
            j2 = Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L;
        }
        this.f5773f.sendMessageDelayed(this.f5773f.obtainMessage(1), j2);
    }

    public void i() {
        List<String> list;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.f5770c) {
            if (this.f5771d) {
                com.ss.android.socialbase.downloader.c.a.b("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.f5771d = true;
            if (com.ss.android.socialbase.downloader.i.f.a()) {
                com.ss.android.socialbase.downloader.downloader.l w = com.ss.android.socialbase.downloader.downloader.c.w();
                if (w != null) {
                    list = w.a();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> a = this.a.a();
                    for (int i2 = 0; i2 < a.size(); i2++) {
                        int keyAt = a.keyAt(i2);
                        if (keyAt != 0 && (downloadInfo2 = a.get(keyAt)) != null) {
                            sparseArray.put(keyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                    int keyAt2 = sparseArray.keyAt(i3);
                    if (keyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(keyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit >= 1 && statusAtDbInit <= 11) {
                            com.ss.android.socialbase.downloader.d.a.a(com.ss.android.socialbase.downloader.downloader.c.g(), downloadInfo, (BaseException) null, -5);
                        }
                        if (list != null && arrayList != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (w == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                w.a(arrayList, 1);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public Map<Long, com.ss.android.socialbase.downloader.f.i> l(int i2) {
        Map<Long, com.ss.android.socialbase.downloader.f.i> l2 = this.a.l(i2);
        if (l2 == null || l2.isEmpty()) {
            Map<Long, com.ss.android.socialbase.downloader.f.i> l3 = this.b.l(i2);
            this.a.a(i2, l3);
            return l3;
        }
        return l2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void m(int i2) {
        this.a.m(i2);
        this.b.m(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.f.i> n(int i2) {
        List<com.ss.android.socialbase.downloader.f.i> n = this.a.n(i2);
        return (n == null || n.size() == 0) ? this.b.n(i2) : n;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2) {
        return this.a.b(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        return this.a.c(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> d(String str) {
        return this.a.d(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean f(int i2) {
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.p(i2);
            } else {
                this.b.f(i2);
            }
        } else {
            this.b.f(i2);
        }
        return this.a.f(i2);
    }

    public k a() {
        return this.a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b(String str) {
        return this.a.b(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void c() {
        try {
            this.a.c();
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.f();
                return;
            } else {
                this.b.c();
                return;
            }
        }
        this.b.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void d(int i2) {
        this.a.d(i2);
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.o(i2);
                return;
            } else {
                this.b.d(i2);
                return;
            }
        }
        this.b.d(i2);
    }

    public void g() {
        List<com.ss.android.socialbase.downloader.model.b> list;
        DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.downloader.c.a(com.ss.android.socialbase.downloader.constants.d.SYNC_START);
        final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> sparseArray2 = new SparseArray<>();
        synchronized (this.a) {
            SparseArray<DownloadInfo> a = this.a.a();
            for (int i2 = 0; i2 < a.size(); i2++) {
                int keyAt = a.keyAt(i2);
                if (keyAt != 0 && (downloadInfo = a.get(keyAt)) != null) {
                    sparseArray.put(keyAt, downloadInfo);
                }
            }
            SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f2 = this.a.f();
            for (int i3 = 0; i3 < f2.size(); i3++) {
                int keyAt2 = f2.keyAt(i3);
                if (keyAt2 != 0 && (list = f2.get(keyAt2)) != null) {
                    sparseArray2.put(keyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.b.a(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.b.d() { // from class: com.ss.android.socialbase.downloader.impls.d.3
            @Override // com.ss.android.socialbase.downloader.b.d
            public void a() {
                synchronized (d.this.a) {
                    SparseArray<DownloadInfo> a2 = d.this.a.a();
                    if (sparseArray != null) {
                        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                            int keyAt3 = sparseArray.keyAt(i4);
                            if (keyAt3 != 0) {
                                a2.put(keyAt3, (DownloadInfo) sparseArray.get(keyAt3));
                            }
                        }
                    }
                    SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f3 = d.this.a.f();
                    if (sparseArray2 != null) {
                        for (int i5 = 0; i5 < sparseArray2.size(); i5++) {
                            int keyAt4 = sparseArray2.keyAt(i5);
                            if (keyAt4 != 0) {
                                f3.put(keyAt4, (List) sparseArray2.get(keyAt4));
                            }
                        }
                    }
                }
                d.this.j();
                d.this.h();
                com.ss.android.socialbase.downloader.downloader.c.a(com.ss.android.socialbase.downloader.constants.d.SYNC_SUCCESS);
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> a(String str) {
        return this.a.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<DownloadInfo> b() {
        return this.a.b();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        synchronized (this.a) {
            this.a.a(bVar);
        }
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.a(bVar);
                return;
            } else {
                this.b.a(bVar);
                return;
            }
        }
        this.b.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.a(bVar);
                return;
            } else {
                this.b.a(bVar);
                return;
            }
        }
        this.b.a(bVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo h(int i2) {
        DownloadInfo h2 = this.a.h(i2);
        c(h2);
        return h2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo j(int i2) {
        DownloadInfo j2 = this.a.j(i2);
        c(j2);
        return j2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo d(int i2, long j2) {
        DownloadInfo d2 = this.a.d(i2, j2);
        b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return d2;
    }

    private void c(DownloadInfo downloadInfo) {
        a(downloadInfo, true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2, long j2) {
        DownloadInfo b = this.a.b(i2, j2);
        b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo c(int i2, long j2) {
        DownloadInfo c2 = this.a.c(i2, j2);
        b(i2, (List<com.ss.android.socialbase.downloader.model.b>) null);
        return c2;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e(int i2) {
        try {
            if (com.ss.android.socialbase.downloader.i.f.b()) {
                com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                if (a != null) {
                    a.n(i2);
                } else {
                    this.b.e(i2);
                }
            } else {
                this.b.e(i2);
            }
        } catch (SQLiteException e2) {
            e2.printStackTrace();
        }
        return this.a.e(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.a.a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        try {
            a(this.a.b(i2));
            if (list == null) {
                list = this.a.c(i2);
            }
            if (com.ss.android.socialbase.downloader.i.f.b()) {
                com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
                if (a != null) {
                    a.b(i2, list);
                    return;
                } else {
                    this.b.b(i2, list);
                    return;
                }
            }
            this.b.b(i2, list);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, long j2) {
        this.a.a(i2, i3, j2);
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.a(i2, i3, j2);
                return;
            } else {
                this.b.a(i2, i3, j2);
                return;
            }
        }
        this.b.a(i2, i3, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, long j2) {
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.a(i2, i3, i4, j2);
                return;
            } else {
                this.b.a(i2, i3, i4, j2);
                return;
            }
        }
        this.b.a(i2, i3, i4, j2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, int i5) {
        if (com.ss.android.socialbase.downloader.i.f.b()) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.a(i2, i3, i4, i5);
                return;
            } else {
                this.b.a(i2, i3, i4, i5);
                return;
            }
        }
        this.b.a(i2, i3, i4, i5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, int i3) {
        DownloadInfo a = this.a.a(i2, i3);
        c(a);
        return a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean a = this.a.a(downloadInfo);
        c(downloadInfo);
        return a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        DownloadInfo a = this.a.a(i2, j2, str, str2);
        c(a);
        return a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo i(int i2) {
        DownloadInfo i3 = this.a.i(i2);
        c(i3);
        return i3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2) {
        DownloadInfo a = this.a.a(i2, j2);
        a(a, false);
        return a;
    }

    private void a(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.i.f.b()) {
            this.b.a(downloadInfo);
        } else if (z) {
            com.ss.android.socialbase.downloader.downloader.m a = l.a(true);
            if (a != null) {
                a.c(downloadInfo);
            } else {
                this.b.a(downloadInfo);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.a.a(i2, list);
        if (com.ss.android.socialbase.downloader.i.f.c()) {
            this.b.b(i2, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean a(int i2, Map<Long, com.ss.android.socialbase.downloader.f.i> map) {
        this.a.a(i2, map);
        this.b.a(i2, map);
        return false;
    }
}
