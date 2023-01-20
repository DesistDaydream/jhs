package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class k implements com.ss.android.socialbase.downloader.downloader.j {
    private final SparseArray<DownloadInfo> a = new SparseArray<>();
    private final SparseArray<List<com.ss.android.socialbase.downloader.model.b>> b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<Map<Long, com.ss.android.socialbase.downloader.f.i>> f5781c = new SparseArray<>();

    public SparseArray<DownloadInfo> a() {
        return this.a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(int i2, int i3, int i4, int i5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized DownloadInfo b(int i2) {
        DownloadInfo downloadInfo;
        try {
            downloadInfo = this.a.get(i2);
        } catch (Exception e2) {
            e2.printStackTrace();
            downloadInfo = null;
        }
        return downloadInfo;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(com.ss.android.socialbase.downloader.model.b bVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i2));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && downloadInfo.getStatus() == -3) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> d(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i2));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isUnCompletedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean d() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean e() {
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean e(int i2) {
        this.a.remove(i2);
        return true;
    }

    public SparseArray<List<com.ss.android.socialbase.downloader.model.b>> f() {
        return this.b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo g(int i2) {
        DownloadInfo b = b(i2);
        if (b != null) {
            b.setStatus(2);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo h(int i2) {
        DownloadInfo b = b(i2);
        if (b != null) {
            b.setStatus(5);
            b.setFirstDownload(false);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo i(int i2) {
        DownloadInfo b = b(i2);
        if (b != null) {
            b.setStatus(1);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo j(int i2) {
        DownloadInfo b = b(i2);
        if (b != null) {
            b.setStatus(-7);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized Map<Long, com.ss.android.socialbase.downloader.f.i> l(int i2) {
        return this.f5781c.get(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void m(int i2) {
        this.f5781c.remove(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<com.ss.android.socialbase.downloader.f.i> n(int i2) {
        Map<Long, com.ss.android.socialbase.downloader.f.i> map = this.f5781c.get(i2);
        if (map != null && !map.isEmpty()) {
            return new ArrayList(map.values());
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        try {
            int size = this.a.size();
            for (int i2 = 0; i2 < size; i2++) {
                DownloadInfo valueAt = this.a.valueAt(i2);
                if (str != null && str.equals(valueAt.getUrl())) {
                    arrayList.add(valueAt);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public boolean f(int i2) {
        e(i2);
        d(i2);
        m(i2);
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            DownloadInfo downloadInfo = this.a.get(this.a.keyAt(i2));
            if (downloadInfo != null && !TextUtils.isEmpty(downloadInfo.getMimeType()) && downloadInfo.getMimeType().equals(str) && DownloadStatus.isFailedStatus(downloadInfo.getStatus())) {
                arrayList.add(downloadInfo);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void a(com.ss.android.socialbase.downloader.model.b bVar) {
        int k2 = bVar.k();
        List<com.ss.android.socialbase.downloader.model.b> list = this.b.get(k2);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(k2, list);
        }
        list.add(bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
        r0.b(r5);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(int r3, int r4, long r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.c(r3)     // Catch: java.lang.Throwable -> L26
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L26
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto L24
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L26
            com.ss.android.socialbase.downloader.model.b r0 = (com.ss.android.socialbase.downloader.model.b) r0     // Catch: java.lang.Throwable -> L26
            if (r0 == 0) goto Ld
            int r1 = r0.s()     // Catch: java.lang.Throwable -> L26
            if (r1 != r4) goto Ld
            r0.b(r5)     // Catch: java.lang.Throwable -> L26
        L24:
            monitor-exit(r2)
            return
        L26:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.k.a(int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<com.ss.android.socialbase.downloader.model.b> c(int i2) {
        return this.b.get(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void d(int i2) {
        this.b.remove(i2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void c() {
        this.a.clear();
        this.b.clear();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo d(int i2, long j2) {
        DownloadInfo b = b(i2);
        if (b != null) {
            b.setCurBytes(j2, false);
            b.setStatus(-2);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized List<DownloadInfo> b() {
        if (this.a.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.a.size());
        for (int i2 = 0; i2 < this.a.size(); i2++) {
            DownloadInfo valueAt = this.a.valueAt(i2);
            if (valueAt != null) {
                arrayList.add(valueAt);
            }
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo c(int i2, long j2) {
        DownloadInfo b = b(i2);
        if (b != null) {
            b.setCurBytes(j2, false);
            b.setStatus(-3);
            b.setFirstDownload(false);
            b.setFirstSuccess(false);
        }
        return b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
        if (r0.g() != null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002e, code lost:
        r3 = r0.g().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
        if (r3.hasNext() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
        r5 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
        if (r5 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r5.s() != r4) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
        r5.b(r6);
     */
    @Override // com.ss.android.socialbase.downloader.downloader.j
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(int r3, int r4, int r5, long r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.List r3 = r2.c(r3)     // Catch: java.lang.Throwable -> L4f
            if (r3 != 0) goto L9
            monitor-exit(r2)
            return
        L9:
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4f
        Ld:
            boolean r0 = r3.hasNext()     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto L4d
            java.lang.Object r0 = r3.next()     // Catch: java.lang.Throwable -> L4f
            com.ss.android.socialbase.downloader.model.b r0 = (com.ss.android.socialbase.downloader.model.b) r0     // Catch: java.lang.Throwable -> L4f
            if (r0 == 0) goto Ld
            int r1 = r0.s()     // Catch: java.lang.Throwable -> L4f
            if (r1 != r5) goto Ld
            boolean r1 = r0.f()     // Catch: java.lang.Throwable -> L4f
            if (r1 != 0) goto Ld
            java.util.List r3 = r0.g()     // Catch: java.lang.Throwable -> L4f
            if (r3 != 0) goto L2e
            goto L4d
        L2e:
            java.util.List r3 = r0.g()     // Catch: java.lang.Throwable -> L4f
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L4f
        L36:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L4d
            java.lang.Object r5 = r3.next()     // Catch: java.lang.Throwable -> L4f
            com.ss.android.socialbase.downloader.model.b r5 = (com.ss.android.socialbase.downloader.model.b) r5     // Catch: java.lang.Throwable -> L4f
            if (r5 == 0) goto L36
            int r0 = r5.s()     // Catch: java.lang.Throwable -> L4f
            if (r0 != r4) goto L36
            r5.b(r6)     // Catch: java.lang.Throwable -> L4f
        L4d:
            monitor-exit(r2)
            return
        L4f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.k.a(int, int, int, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo b(int i2, long j2) {
        DownloadInfo b = b(i2);
        if (b != null) {
            b.setCurBytes(j2, false);
            b.setStatus(-1);
            b.setFirstDownload(false);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void b(DownloadInfo downloadInfo) {
        a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized DownloadInfo a(int i2, int i3) {
        DownloadInfo b;
        b = b(i2);
        if (b != null) {
            b.setChunkCount(i3);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean a(DownloadInfo downloadInfo) {
        boolean z = true;
        if (downloadInfo == null) {
            return true;
        }
        if (this.a.get(downloadInfo.getId()) == null) {
            z = false;
        }
        this.a.put(downloadInfo.getId(), downloadInfo);
        return z;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2, String str, String str2) {
        DownloadInfo b = b(i2);
        if (b != null) {
            b.setTotalBytes(j2);
            b.seteTag(str);
            if (TextUtils.isEmpty(b.getName()) && !TextUtils.isEmpty(str2)) {
                b.setName(str2);
            }
            b.setStatus(3);
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public DownloadInfo a(int i2, long j2) {
        DownloadInfo b = b(i2);
        if (b != null) {
            b.setCurBytes(j2, false);
            if (b.getStatus() != -3 && b.getStatus() != -2 && !DownloadStatus.isFailedStatus(b.getStatus()) && b.getStatus() != -4) {
                b.setStatus(4);
            }
        }
        return b;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized void a(int i2, List<com.ss.android.socialbase.downloader.model.b> list) {
        if (list == null) {
            return;
        }
        d(i2);
        for (com.ss.android.socialbase.downloader.model.b bVar : list) {
            if (bVar != null) {
                a(bVar);
                if (bVar.f()) {
                    for (com.ss.android.socialbase.downloader.model.b bVar2 : bVar.g()) {
                        a(bVar2);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public synchronized boolean a(int i2, Map<Long, com.ss.android.socialbase.downloader.f.i> map) {
        this.f5781c.put(i2, map);
        return false;
    }
}
