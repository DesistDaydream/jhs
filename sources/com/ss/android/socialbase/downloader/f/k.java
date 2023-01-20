package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.h.e;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.c;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class k implements f, c.a {
    private int A;
    private final boolean B;
    private final DownloadInfo a;
    private final n b;

    /* renamed from: c */
    private final b f5674c;

    /* renamed from: d */
    private final com.ss.android.socialbase.downloader.h.f f5675d;

    /* renamed from: e */
    private final g f5676e;

    /* renamed from: j */
    private com.ss.android.socialbase.downloader.model.d f5681j;

    /* renamed from: k */
    private com.ss.android.socialbase.downloader.model.d f5682k;

    /* renamed from: m */
    private long f5684m;
    private int p;
    private BaseException q;
    private volatile boolean r;
    private final com.ss.android.socialbase.downloader.i.e t;
    private final com.ss.android.socialbase.downloader.h.e u;
    private long w;
    private long x;
    private long y;
    private float z;

    /* renamed from: f */
    private volatile boolean f5677f = false;

    /* renamed from: g */
    private volatile boolean f5678g = false;

    /* renamed from: h */
    private final List<m> f5679h = new ArrayList();

    /* renamed from: i */
    private final List<q> f5680i = new ArrayList();

    /* renamed from: l */
    private volatile boolean f5683l = true;
    private final LinkedList<i> n = new LinkedList<>();
    private final List<i> o = new ArrayList();
    private final Object s = new Object();
    private volatile boolean v = false;
    private final e.b C = new e.b() { // from class: com.ss.android.socialbase.downloader.f.k.1
        private int b;

        {
            k.this = this;
        }

        @Override // com.ss.android.socialbase.downloader.h.e.b
        public long a() {
            if (k.this.f5677f || k.this.f5678g) {
                return -1L;
            }
            synchronized (k.this) {
                if (k.this.f5681j == null && k.this.f5682k == null) {
                    long j2 = k.this.w;
                    if (j2 <= 0) {
                        return -1L;
                    }
                    this.b++;
                    m a = k.this.a(false, System.currentTimeMillis(), j2);
                    if (a != null) {
                        Log.i("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                        k.this.c(a);
                        a.f();
                        return ((this.b / k.this.f5680i.size()) + 1) * j2;
                    }
                    return j2;
                }
                return -1L;
            }
        }
    };
    private final e.b D = new e.b() { // from class: com.ss.android.socialbase.downloader.f.k.2
        {
            k.this = this;
        }

        @Override // com.ss.android.socialbase.downloader.h.e.b
        public long a() {
            return k.this.r();
        }
    };

    public k(@NonNull DownloadInfo downloadInfo, @NonNull n nVar, com.ss.android.socialbase.downloader.h.f fVar) {
        this.a = downloadInfo;
        this.b = nVar;
        b bVar = new b(nVar.d(), nVar.e());
        this.f5674c = bVar;
        this.f5675d = fVar;
        this.f5676e = new g(downloadInfo, fVar, bVar);
        this.u = new com.ss.android.socialbase.downloader.h.e();
        this.t = new com.ss.android.socialbase.downloader.i.e();
        this.B = com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).b("debug") == 1;
    }

    private void h() {
        if (this.x > 0) {
            this.y = System.currentTimeMillis();
            this.u.a(this.D, 0L);
        }
    }

    private void i() {
        List<String> backUpUrls;
        int l2 = this.b.l();
        if (l2 <= 0) {
            this.f5683l = false;
            e();
            return;
        }
        com.ss.android.socialbase.downloader.network.c a = com.ss.android.socialbase.downloader.network.c.a();
        a.a(this.a.getUrl(), this, 2000L);
        if (l2 <= 2 || (backUpUrls = this.a.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                a.a(str, this, 2000L);
            }
        }
    }

    private q j() {
        q qVar;
        synchronized (this) {
            int size = this.p % this.f5680i.size();
            if (this.b.b()) {
                this.p++;
            }
            qVar = this.f5680i.get(size);
        }
        return qVar;
    }

    private void k() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onComplete");
        this.f5674c.c();
        synchronized (this.s) {
            this.s.notify();
        }
    }

    private boolean l() {
        for (m mVar : this.f5679h) {
            if (!mVar.g()) {
                return false;
            }
        }
        return true;
    }

    private void m() {
        int size;
        if (this.f5684m > 0 && (size = this.o.size()) > 1) {
            ArrayList<i> arrayList = null;
            int i2 = 0;
            for (int i3 = 1; i3 < size; i3++) {
                i iVar = this.o.get(i2);
                i iVar2 = this.o.get(i3);
                if (iVar.e() > iVar2.c() && iVar2.a() <= 0 && iVar2.a == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(iVar2);
                    if (this.B) {
                        Log.w("SegmentDispatcher", "clearCovered, covered = " + iVar2 + ", prev = " + iVar);
                    }
                } else if (iVar2.e() > iVar.e()) {
                    i2++;
                }
            }
            if (arrayList != null) {
                for (i iVar3 : arrayList) {
                    this.o.remove(iVar3);
                    for (m mVar : this.f5679h) {
                        if (mVar.a == iVar3) {
                            if (this.B) {
                                Log.w("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + iVar3 + ", threadIndex = " + mVar.f5686c);
                            }
                            mVar.a(true);
                        }
                    }
                }
            }
        }
    }

    private boolean n() {
        long j2 = this.f5684m;
        if (j2 <= 0) {
            this.r = false;
            return false;
        }
        synchronized (this) {
            long a = o.a(this.o);
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "isAllContentDownloaded: firstOffset = " + a);
            if (a >= j2) {
                this.r = true;
                return true;
            }
            this.r = false;
            return false;
        }
    }

    private long o() {
        long j2 = 0;
        for (m mVar : this.f5679h) {
            j2 += mVar.b();
        }
        return j2;
    }

    private i p() {
        int i2 = 0;
        while (true) {
            i q = q();
            if (q == null) {
                return null;
            }
            m mVar = q.a;
            if (mVar == null) {
                return q;
            }
            if (q.j() >= 2) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            b(currentTimeMillis);
            if (currentTimeMillis - mVar.f5689f > 2000 && a(mVar, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                if (this.B) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + q + ", owner.threadIndex = " + mVar.f5686c);
                }
                return q;
            }
            int i3 = i2 + 1;
            if (i2 > 2) {
                if (this.B) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + q);
                }
                return q;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i2 = i3;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private i q() {
        int j2;
        i iVar = null;
        int i2 = Integer.MAX_VALUE;
        for (i iVar2 : this.o) {
            if (a(iVar2) > 0 && (j2 = iVar2.j()) < i2) {
                iVar = iVar2;
                i2 = j2;
            }
        }
        return iVar;
    }

    public long r() {
        if (this.f5677f || this.f5678g) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            b(currentTimeMillis);
            long k2 = this.b.k();
            if (k2 > 0) {
                long j2 = this.y;
                if (j2 > 0 && currentTimeMillis - j2 > k2 && a(currentTimeMillis, k2)) {
                    this.y = currentTimeMillis;
                    this.A++;
                }
            }
        }
        return 2000L;
    }

    private void b(List<i> list) {
        long totalBytes = this.a.getTotalBytes();
        this.f5684m = totalBytes;
        if (totalBytes <= 0) {
            this.f5684m = this.a.getExpectFileLength();
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.f5684m);
        }
        synchronized (this) {
            this.n.clear();
            if (list != null && !list.isEmpty()) {
                for (i iVar : list) {
                    a((List<i>) this.n, new i(iVar), false);
                }
                d(this.n);
                c(this.n);
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "initSegments: totalLength = " + this.f5684m);
            }
            a((List<i>) this.n, new i(0L, -1L), false);
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "initSegments: totalLength = " + this.f5684m);
        }
    }

    private void c() throws BaseException, InterruptedException {
        BaseException baseException;
        synchronized (this.s) {
            if (this.f5681j == null && this.f5682k == null) {
                this.s.wait();
            }
        }
        if (this.f5681j == null && this.f5682k == null && (baseException = this.q) != null) {
            throw baseException;
        }
    }

    private void d() throws BaseException {
        try {
            this.f5676e.a((d) this.f5674c);
        } catch (p unused) {
        } catch (BaseException e2) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "dispatchSegments: loopAndWrite e = " + e2);
            a(e2);
            throw e2;
        }
        if (this.f5678g || this.f5677f) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.n.isEmpty()) {
                    i poll = this.n.poll();
                    if (poll != null) {
                        a(this.o, poll, true);
                    }
                }
                c(this.o);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.v && this.q != null) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.q);
            throw this.q;
        }
        if (this.a.getCurBytes() != this.a.getTotalBytes()) {
            com.ss.android.socialbase.downloader.d.a.a(this.a, this.o);
        }
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "dispatchSegments::download finished");
    }

    private void e() {
        int i2;
        if (this.f5684m <= 0 || this.f5683l) {
            i2 = 1;
        } else {
            i2 = this.b.a();
            int h2 = (int) (this.f5684m / this.b.h());
            if (i2 > h2) {
                i2 = h2;
            }
        }
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.f5684m + ", threadCount = " + i2);
        int i3 = i2 > 0 ? i2 : 1;
        synchronized (this) {
            do {
                if (this.f5679h.size() >= i3) {
                    break;
                }
                if (!this.f5678g && !this.f5677f) {
                    a(j());
                }
                return;
            } while (!this.b.f());
        }
    }

    private void f() {
        this.f5680i.add(new q(this.a.getUrl(), true));
        List<String> backUpUrls = this.a.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.f5680i.add(new q(str, false));
                }
            }
        }
        this.b.a(this.f5680i.size());
    }

    private void g() {
        n nVar = this.b;
        this.w = nVar.j();
        this.x = nVar.k();
        this.z = nVar.o();
        int i2 = this.A;
        if (i2 > 0) {
            this.u.a(this.C, i2);
        }
    }

    public boolean a(List<i> list) throws BaseException, InterruptedException {
        try {
            f();
            b(list);
            e();
            g();
            i();
            long currentTimeMillis = System.currentTimeMillis();
            c();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            this.a.increaseAllConnectTime(currentTimeMillis2);
            this.a.setFirstSpeedTime(currentTimeMillis2);
            if (!this.f5678g && !this.f5677f) {
                this.f5675d.a(this.f5684m);
                h();
                d();
                return true;
            }
            if (!this.f5678g && !this.f5677f) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                b();
            }
            this.u.b();
            return true;
        } finally {
            if (!this.f5678g && !this.f5677f) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "finally pause");
                b();
            }
            this.u.b();
        }
    }

    private void c(List<i> list) {
        long b = o.b(list);
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.a.getCurBytes() + ", totalBytes = " + this.a.getTotalBytes() + ", downloadedBytes = " + b);
        if (b > this.a.getTotalBytes() && this.a.getTotalBytes() > 0) {
            b = this.a.getTotalBytes();
        }
        if (this.a.getCurBytes() == this.a.getTotalBytes() || this.a.getCurBytes() == b) {
            return;
        }
        this.a.setCurBytes(b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:135:0x00a1, code lost:
        if ((r10.e() - r24.e()) < (r14 / 2)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x01f2, code lost:
        r3 = r3 + 1;
        r6 = r22.o.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x01fa, code lost:
        if (r3 >= r6) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x01fc, code lost:
        r7 = r22.o.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x020c, code lost:
        if (r7.a() > 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0210, code lost:
        if (r7.a == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0213, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0216, code lost:
        r11 = r24.f();
        r15 = r7.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0220, code lost:
        if (r11 <= 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0224, code lost:
        if (r11 < r15) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0226, code lost:
        r8 = r15 - 1;
        r24.c(r8);
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: segment set end:" + r8 + ", later = " + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x0247, code lost:
        android.util.Log.d("SegmentDispatcher", "applySegmentLocked: break 2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x024c, code lost:
        r6 = r24.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0254, code lost:
        if (r6 <= 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0258, code lost:
        if (r20 > r6) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x0260, code lost:
        if (r24.e() > r6) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x0278, code lost:
        throw new com.ss.android.socialbase.downloader.f.j(6, "applySegment: " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x0279, code lost:
        r24.a = r23;
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "applySegment: OK " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x028f, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void e(com.ss.android.socialbase.downloader.f.m r23, com.ss.android.socialbase.downloader.f.i r24) throws com.ss.android.socialbase.downloader.f.j {
        /*
            Method dump skipped, instructions count: 736
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.k.e(com.ss.android.socialbase.downloader.f.m, com.ss.android.socialbase.downloader.f.i):void");
    }

    private void b(String str, List<q> list) {
        int a;
        if (this.B) {
            Iterator<q> it = list.iterator();
            while (it.hasNext()) {
                Log.i("SegmentDispatcher", "addIpListLocked: urlRecord = " + it.next());
            }
        }
        int l2 = this.b.l();
        if ((l2 == 1 || l2 == 3) && (a = a(str)) >= 0 && a < this.f5680i.size()) {
            this.f5680i.addAll(a + 1, list);
        } else {
            this.f5680i.addAll(list);
        }
    }

    private List<q> c(String str, List<InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i2 = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.B) {
                            Log.i("SegmentDispatcher", "onDnsResolved: ip = " + hostAddress);
                        }
                        q qVar = new q(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(qVar.f5697c);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(qVar.f5697c, linkedList);
                        }
                        linkedList.add(qVar);
                        i2++;
                    }
                }
            }
            if (i2 > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    z = false;
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        LinkedList linkedList2 = (LinkedList) entry.getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((q) linkedList2.pollFirst());
                            i2--;
                            z = true;
                        }
                    }
                    if (i2 <= 0) {
                        break;
                    }
                } while (z);
                return arrayList;
            }
        }
        return null;
    }

    private void d(List<i> list) {
        i iVar = list.get(0);
        long c2 = iVar.c();
        if (c2 > 0) {
            i iVar2 = new i(0L, c2 - 1);
            Log.w("SegmentDispatcher", "fixSegmentsLocked: first = " + iVar + ", add new first = " + iVar2);
            a(list, iVar2, true);
        }
        Iterator<i> it = list.iterator();
        if (it.hasNext()) {
            i next = it.next();
            while (it.hasNext()) {
                i next2 = it.next();
                if (next.f() < next2.c() - 1) {
                    com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.c() - 1));
                    next.c(next2.c() - 1);
                }
                next = next2;
            }
        }
        i iVar3 = list.get(list.size() - 1);
        long totalBytes = this.a.getTotalBytes();
        if (totalBytes <= 0 || (iVar3.f() != -1 && iVar3.f() < totalBytes - 1)) {
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "fixSegment: last segment = " + iVar3 + ", new end=-1");
            iVar3.c(-1L);
        }
    }

    private i b(m mVar, q qVar) {
        while (!this.n.isEmpty()) {
            i poll = this.n.poll();
            if (poll != null) {
                a(this.o, poll, true);
                if (a(poll) > 0 || this.f5684m <= 0) {
                    return poll;
                }
            }
        }
        m();
        i c2 = c(mVar, qVar);
        if (c2 != null && a(c2) > 0) {
            a(this.o, c2, true);
            return c2;
        }
        i p = p();
        if (p != null) {
            return p;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar, i iVar) throws BaseException {
        synchronized (this) {
            e(mVar, iVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.c.a
    public void a(String str, List<InetAddress> list) {
        if (this.f5678g || this.f5677f) {
            return;
        }
        List<q> list2 = null;
        try {
            list2 = c(str, list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this) {
            if (list2 != null) {
                b(str, list2);
            }
            this.f5683l = false;
            this.b.a(this.f5680i.size());
            Log.i("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
            e();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void b(m mVar) {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onReaderExit: threadIndex = " + mVar.f5686c);
        synchronized (this) {
            mVar.c(true);
            this.f5679h.remove(mVar);
            m();
            if (this.f5679h.isEmpty()) {
                k();
            } else if (n()) {
                Log.i("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                for (m mVar2 : this.f5679h) {
                    mVar2.e();
                }
                k();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void c(m mVar, i iVar) {
        synchronized (this) {
            if (iVar.a == mVar) {
                com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "unApplySegment " + iVar);
                iVar.d(mVar.d());
                iVar.a = null;
                mVar.a();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public e d(m mVar, i iVar) throws BaseException {
        e a;
        synchronized (this) {
            l lVar = new l(this.a, this.f5674c, iVar);
            this.f5676e.a(lVar);
            a = lVar.a();
        }
        return a;
    }

    private int a(String str) {
        int size = this.f5680i.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (TextUtils.equals(this.f5680i.get(i2).a, str)) {
                return i2;
            }
        }
        return -1;
    }

    public boolean c(m mVar) {
        synchronized (this) {
            q d2 = d(mVar);
            if (d2 == null) {
                return false;
            }
            return mVar.a(d2);
        }
    }

    private q d(m mVar) {
        q qVar;
        Iterator<q> it = this.f5680i.iterator();
        q qVar2 = null;
        while (true) {
            if (!it.hasNext()) {
                qVar = null;
                break;
            }
            qVar = it.next();
            if (qVar != mVar.b && !qVar.d()) {
                if (qVar2 == null) {
                    qVar2 = qVar;
                }
                if (qVar.a() <= 0) {
                    break;
                }
            }
        }
        if (this.b.b()) {
            if (qVar != null) {
                return qVar;
            }
            if (this.b.c()) {
                return null;
            }
        }
        return qVar2;
    }

    private void a(List<i> list, i iVar, boolean z) {
        long c2 = iVar.c();
        int size = list.size();
        int i2 = 0;
        while (i2 < size && c2 >= list.get(i2).c()) {
            i2++;
        }
        list.add(i2, iVar);
        if (z) {
            iVar.a(size);
        }
    }

    private void b(m mVar, i iVar, q qVar, com.ss.android.socialbase.downloader.model.d dVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        m mVar2 = iVar.a;
        if (mVar2 != null && mVar2 != mVar) {
            throw new j(1, "segment already has an owner");
        }
        if (mVar.h() == iVar.e()) {
            if (!dVar.b()) {
                if (iVar.e() <= 0) {
                    com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + iVar.e());
                    if (!dVar.a()) {
                        int i2 = dVar.f5836c;
                        throw new com.ss.android.socialbase.downloader.exception.b(1004, i2, "2: response code error : " + dVar.f5836c + " segment=" + iVar);
                    }
                } else {
                    int i3 = dVar.f5836c;
                    throw new com.ss.android.socialbase.downloader.exception.b(1004, i3, "1: response code error : " + dVar.f5836c + " segment=" + iVar);
                }
            }
            if (qVar.f5698d) {
                if (this.f5681j == null) {
                    this.f5681j = dVar;
                    synchronized (this.s) {
                        this.s.notify();
                    }
                    com.ss.android.socialbase.downloader.h.f fVar = this.f5675d;
                    if (fVar != null) {
                        fVar.a(qVar.a, dVar.b, iVar.e());
                    }
                    long j2 = dVar.j();
                    if (j2 > 0) {
                        for (i iVar2 : this.o) {
                            if (iVar2.f() <= 0 || iVar2.f() > j2 - 1) {
                                iVar2.c(j2 - 1);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            a(dVar);
            if (this.f5682k == null) {
                this.f5682k = dVar;
                if (this.a.getTotalBytes() <= 0) {
                    long j3 = dVar.j();
                    com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "checkSegmentHttpResponse:len=" + j3 + ",url=" + qVar.a);
                    this.a.setTotalBytes(j3);
                }
                synchronized (this.s) {
                    this.s.notify();
                }
                return;
            }
            return;
        }
        throw new j(5, "applySegment");
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.f.i c(com.ss.android.socialbase.downloader.f.m r28, com.ss.android.socialbase.downloader.f.q r29) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.k.c(com.ss.android.socialbase.downloader.f.m, com.ss.android.socialbase.downloader.f.q):com.ss.android.socialbase.downloader.f.i");
    }

    private float d(m mVar, q qVar) {
        long b = mVar.b();
        int size = this.f5679h.size();
        if (size <= 1) {
            size = this.b.a();
        }
        float f2 = 1.0f;
        if (b <= 0) {
            float m2 = this.b.m();
            if (m2 <= 0.0f || m2 >= 1.0f) {
                m2 = 1.0f / size;
            }
            if (mVar.f5686c == 0) {
                return m2;
            }
            if (size > 1) {
                f2 = 1.0f - m2;
                size--;
            }
        } else {
            long o = o();
            if (o > b) {
                return ((float) b) / ((float) o);
            }
        }
        return f2 / size;
    }

    private void a(q qVar) {
        m mVar = new m(this.a, this, this.f5674c, qVar, this.f5679h.size());
        this.f5679h.add(mVar);
        mVar.a(com.ss.android.socialbase.downloader.downloader.c.q().submit(mVar));
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar) {
        if (this.B) {
            com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "onReaderRun, threadIndex = " + mVar.f5686c);
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public i a(m mVar, q qVar) {
        if (this.f5677f || this.f5678g) {
            return null;
        }
        synchronized (this) {
            i b = b(mVar, qVar);
            if (b != null) {
                b.h();
                if (b.j() > 1) {
                    return new i(b);
                }
            }
            return b;
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, i iVar) {
        synchronized (this) {
            iVar.i();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, i iVar, q qVar, com.ss.android.socialbase.downloader.model.d dVar) throws BaseException, com.ss.android.socialbase.downloader.exception.i {
        synchronized (this) {
            if (!this.f5677f && !this.f5678g) {
                b(mVar, iVar, qVar, dVar);
                mVar.b(false);
                if (this.f5684m <= 0) {
                    long totalBytes = this.a.getTotalBytes();
                    this.f5684m = totalBytes;
                    if (totalBytes <= 0) {
                        this.f5684m = dVar.j();
                    }
                    e();
                } else if (this.b.f()) {
                    e();
                }
            } else {
                throw new p("connected");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException, int i2, int i3) {
        com.ss.android.socialbase.downloader.i.f.b(baseException);
        int errorCode = baseException.getErrorCode();
        if (((errorCode == 1047 || errorCode == 1074 || errorCode == 1055) ? true : true) || i2 >= i3) {
            c(mVar);
        }
    }

    public void b() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "pause1");
        this.f5678g = true;
        synchronized (this) {
            for (m mVar : this.f5679h) {
                mVar.e();
            }
        }
        this.f5676e.b();
        this.f5674c.c();
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void a(m mVar, q qVar, i iVar, BaseException baseException) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onSegmentFailed: segment = " + iVar + ", e = " + baseException);
            mVar.b(true);
            if (mVar.f5686c == 0) {
                this.q = baseException;
            }
            if (l()) {
                if (this.q == null) {
                    this.q = baseException;
                }
                this.v = true;
                a(this.q);
            }
        }
    }

    private void b(long j2) {
        this.t.a(this.a.getCurBytes(), j2);
        for (m mVar : this.f5679h) {
            mVar.b(j2);
        }
    }

    private void a(BaseException baseException) {
        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", "onError, e = " + baseException);
        this.q = baseException;
        this.f5674c.c();
        synchronized (this) {
            for (m mVar : this.f5679h) {
                mVar.e();
            }
        }
    }

    private void a(com.ss.android.socialbase.downloader.model.d dVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.d dVar2 = this.f5681j;
        if (dVar2 == null && (dVar2 = this.f5682k) == null) {
            return;
        }
        long j2 = dVar.j();
        long j3 = dVar2.j();
        if (j2 != j3) {
            String str = "total len not equals,len=" + j2 + ",sLen=" + j3 + ",code=" + dVar.f5836c + ",sCode=" + dVar2.f5836c + ",range=" + dVar.e() + ",sRange = " + dVar2.e() + ",url = " + dVar.a + ",sUrl=" + dVar2.a;
            com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", str);
            if (j2 > 0 && j3 > 0) {
                throw new BaseException(1074, str);
            }
        }
        String c2 = dVar.c();
        String c3 = dVar2.c();
        if (TextUtils.equals(c2, c3)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + c2 + ", mainEtag = " + c3;
        com.ss.android.socialbase.downloader.c.a.e("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(c2) && !TextUtils.isEmpty(c3) && !c2.equalsIgnoreCase(c3)) {
            throw new BaseException(1074, str2);
        }
    }

    public void a() {
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "cancel");
        this.f5677f = true;
        synchronized (this) {
            for (m mVar : this.f5679h) {
                mVar.e();
            }
        }
        this.f5676e.a();
        this.f5674c.c();
    }

    private int a(long j2) {
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            i iVar = this.o.get(i2);
            if (iVar.c() == j2) {
                return i2;
            }
            if (iVar.c() > j2) {
                return -1;
            }
        }
        return -1;
    }

    private long a(int i2, int i3) {
        i iVar = this.o.get(i2);
        long a = a(iVar);
        int i4 = i2 + 1;
        i iVar2 = i4 < i3 ? this.o.get(i4) : null;
        if (iVar2 == null) {
            return a;
        }
        long c2 = iVar2.c() - iVar.e();
        return a == -1 ? c2 : Math.min(a, c2);
    }

    private long a(i iVar) {
        long b = iVar.b();
        if (b == -1) {
            long j2 = this.f5684m;
            return j2 > 0 ? j2 - iVar.e() : b;
        }
        return b;
    }

    public m a(boolean z, long j2, long j3) {
        m mVar = null;
        for (m mVar2 : this.f5679h) {
            if (mVar2.f5686c != 0 || z) {
                if (mVar2.f5687d > 0 && mVar2.f5688e <= 0 && j2 - mVar2.f5687d > j3 && (mVar == null || mVar2.f5687d < mVar.f5687d)) {
                    mVar = mVar2;
                }
            }
        }
        return mVar;
    }

    private boolean a(m mVar, long j2, long j3, long j4, double d2) {
        if (mVar.f5689f > 0) {
            long b = this.t.b(j2, j3);
            int size = this.f5679h.size();
            long j5 = size > 0 ? b / size : b;
            long a = mVar.a(j2, j3);
            if (a < j4 || a < j5 * d2) {
                Log.i("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + b + ", threadAvgSpeed = " + j5 + ", poorSpeed = " + j4 + ", speed = " + a + ",threadIndex = " + mVar.f5686c);
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean a(long j2, long j3) {
        long j4 = j2 - j3;
        long b = this.t.b(j4, j2);
        int size = this.f5679h.size();
        if (size > 0) {
            b /= size;
        }
        m a = a(j4, j2, Math.max(10.0f, ((float) b) * this.z), size / 2);
        if (a != null) {
            c(a);
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + a.f5686c);
            a.f();
            return true;
        }
        m a2 = a(true, j2, j3);
        if (a2 != null) {
            c(a2);
            com.ss.android.socialbase.downloader.c.a.d("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + a2.f5686c);
            a2.f();
            return true;
        }
        return false;
    }

    private m a(long j2, long j3, long j4, int i2) {
        long j5;
        long j6 = Long.MAX_VALUE;
        int i3 = 0;
        m mVar = null;
        for (m mVar2 : this.f5679h) {
            if (mVar2.f5689f > 0) {
                i3++;
                long j7 = j6;
                if (mVar2.f5689f < j2) {
                    long a = mVar2.a(j2, j3);
                    if (this.B) {
                        Log.i("SegmentDispatcher", "findPoorReadThread: speed = " + a + ", threadIndex = " + mVar2.f5686c);
                        j5 = 0;
                    } else {
                        j5 = 0;
                    }
                    if (a >= j5 && a < j7) {
                        j6 = a;
                        mVar = mVar2;
                    }
                }
                j6 = j7;
            }
        }
        long j8 = j6;
        if (mVar == null || i3 < i2 || j8 >= j4) {
            return null;
        }
        com.ss.android.socialbase.downloader.c.a.c("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j8 + ", threadIndex = " + mVar.f5686c);
        return mVar;
    }
}
