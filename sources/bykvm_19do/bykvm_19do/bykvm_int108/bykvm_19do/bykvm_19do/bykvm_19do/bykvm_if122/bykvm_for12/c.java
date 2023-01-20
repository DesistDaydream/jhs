package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c extends HandlerThread implements e, d, Handler.Callback {
    private volatile boolean a;
    private final Object b;

    /* renamed from: c */
    public bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.d f1100c;

    /* renamed from: d */
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c f1101d;

    /* renamed from: e */
    private final PriorityBlockingQueue<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> f1102e;

    /* renamed from: f */
    private volatile int f1103f;

    /* renamed from: g */
    private volatile long f1104g;

    /* renamed from: h */
    private volatile long f1105h;

    /* renamed from: i */
    private final AtomicInteger f1106i;

    /* renamed from: j */
    private final AtomicInteger f1107j;

    /* renamed from: k */
    private volatile Handler f1108k;

    /* renamed from: l */
    private final List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> f1109l;

    /* renamed from: m */
    private final AtomicInteger f1110m;
    private final AtomicInteger n;
    private int o;

    /* loaded from: classes.dex */
    public class a extends bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c {
        public final /* synthetic */ List b;

        /* renamed from: c */
        public final /* synthetic */ boolean f1111c;

        /* renamed from: d */
        public final /* synthetic */ long f1112d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, List list, boolean z, long j2) {
            super(str);
            c.this = r1;
            this.b = list;
            this.f1111c = z;
            this.f1112d = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar = c.this;
            cVar.a(this.b, this.f1111c, this.f1112d, cVar.f1103f);
        }
    }

    /* loaded from: classes.dex */
    public class b implements bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ long b;

        public b(boolean z, long j2) {
            c.this = r1;
            this.a = z;
            this.b = j2;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.b
        public void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a> list) {
            try {
                c.this.f1107j.decrementAndGet();
                if (list == null || list.size() == 0) {
                    return;
                }
                int size = list.size();
                for (int i2 = 0; i2 < size; i2++) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a aVar = list.get(i2);
                    if (aVar != null) {
                        c.this.a(this.a, aVar.b(), aVar.a(), this.b);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public c(PriorityBlockingQueue<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> priorityBlockingQueue) {
        super("csj_log");
        this.a = true;
        this.b = new Object();
        this.f1104g = 0L;
        this.f1105h = 0L;
        this.f1106i = new AtomicInteger(0);
        this.f1107j = new AtomicInteger(0);
        this.f1109l = new ArrayList();
        this.f1110m = new AtomicInteger(0);
        this.n = new AtomicInteger(0);
        this.o = 10;
        this.f1102e = priorityBlockingQueue;
        this.f1100c = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b();
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0112 A[Catch: all -> 0x014e, TryCatch #0 {, blocks: (B:71:0x0005, B:74:0x000b, B:76:0x001d, B:78:0x0023, B:120:0x010e, B:122:0x0112, B:123:0x011c, B:89:0x003c, B:91:0x004f, B:92:0x0056, B:94:0x0063, B:95:0x006a, B:97:0x007d, B:98:0x0082, B:99:0x0087, B:101:0x008d, B:103:0x0091, B:105:0x009d, B:106:0x00a2, B:108:0x00aa, B:109:0x00af, B:110:0x00d1, B:112:0x00df, B:113:0x00e5, B:115:0x00f2, B:116:0x00f8, B:118:0x0106, B:119:0x010b, B:125:0x014c), top: B:130:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(int r6, java.util.List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> r7, long r8) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(int, java.util.List, long):void");
    }

    private void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b bVar, List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list) {
        if (bVar == null || !bVar.a) {
            return;
        }
        List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.e> b2 = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.b.b();
        if (list == null || b2 == null || b2.size() == 0) {
            return;
        }
        for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar : list) {
            if (aVar.e() == 1) {
                String c2 = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.c(aVar);
                String e2 = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.e(aVar);
                for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.e eVar : b2) {
                    if (eVar != null) {
                        eVar.a(c2, e2);
                    }
                }
            }
        }
    }

    private void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        this.f1106i.set(0);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d dVar = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1115g;
        this.f1103f = dVar.b ? 5 : dVar.f1119c ? 7 : 4;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.n(), 1);
        this.f1100c.a(aVar, this.f1103f);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.k(aVar);
    }

    private void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, int i2) {
        this.f1106i.set(0);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("handleThreadMessage()");
        if (i2 == 0) {
            this.f1103f = ((bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b) aVar).j();
            if (this.f1103f == 6) {
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.d0(), 1);
        } else {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b bVar = (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b) aVar;
            if (bVar.j() == 1) {
                this.f1103f = 1;
            } else if (bVar.j() != 2) {
                return;
            } else {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("before size:" + i2);
                f();
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("after size :" + i2);
                this.f1103f = 2;
            }
        }
        b(aVar);
    }

    private void a(String str) {
        if (this.f1108k.hasMessages(11)) {
            this.f1108k.removeMessages(11);
        }
        if (this.f1109l.size() == 0) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("ensureUploadOptBatch empty：" + str);
            return;
        }
        ArrayList arrayList = new ArrayList(this.f1109l);
        this.f1109l.clear();
        a((List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a>) arrayList, false, "before_" + str);
        b();
    }

    private void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list) {
        this.f1109l.addAll(list);
        g b2 = j.l().b();
        if (b2 != null && b2.h() != null) {
            this.o = b2.h().c();
        }
        if (this.f1109l.size() >= this.o) {
            if (this.f1108k.hasMessages(11)) {
                this.f1108k.removeMessages(11);
            }
            ArrayList arrayList = new ArrayList(this.f1109l);
            this.f1109l.clear();
            a((List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a>) arrayList, false, "max_size_dispatch");
            b();
        } else if (this.f1102e.size() != 0) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("uploadBatchOptimize nothing：" + this.f1102e.size() + "  " + this.a);
        } else {
            a(false);
            if (this.f1108k.hasMessages(11)) {
                this.f1108k.removeMessages(11);
            }
            if (this.f1108k.hasMessages(1)) {
                this.f1108k.removeMessages(1);
            }
            long j2 = 200;
            if (b2 != null && b2.h() != null) {
                j2 = b2.h().b();
            }
            this.f1108k.sendEmptyMessageDelayed(11, j2);
        }
    }

    private void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, String str) {
        a(str);
        a(list, false, str);
        b();
    }

    private void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, boolean z, long j2) {
        g b2 = j.l().b();
        if (b2 != null) {
            Executor b3 = b2.b();
            if (list.get(0).e() == 1) {
                b3 = b2.a();
            }
            if (b3 == null) {
                return;
            }
            this.f1107j.incrementAndGet();
            b3.execute(new a("csj_log_upload", list, z, j2));
        }
    }

    public void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, boolean z, long j2, int i2) {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b a2;
        try {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.K(), 1);
            if (list.get(0).b() == 0) {
                a2 = j.m().a(list);
                a(a2, list);
                if (a2 != null) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(list, a2.f1098c);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar : list) {
                        jSONArray.put(aVar.d());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e2) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("json exception:" + e2.getMessage());
                }
                a2 = j.m().a(jSONObject);
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b bVar = a2;
            this.f1107j.decrementAndGet();
            a(z, bVar, list, j2);
        } catch (Throwable th) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("inner exception:" + th.getMessage());
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.I(), 1);
            this.f1107j.decrementAndGet();
        }
    }

    private void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, boolean z, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(list, this.f1103f, str);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.c i2 = j.l().i();
        this.f1101d = i2;
        if (i2 != null) {
            b(list, z, currentTimeMillis);
        } else {
            a(list, z, currentTimeMillis);
        }
    }

    public void a(boolean z, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.b bVar, List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, long j2) {
        if (z || bVar == null) {
            return;
        }
        int i2 = bVar.b;
        if (bVar.f1099d) {
            i2 = -1;
        }
        i2 = (i2 == 510 || i2 == 511) ? -2 : -2;
        if (list != null) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("preprocessResult code is " + i2 + " sz:" + list.size() + "  count:" + this.f1107j.get());
        }
        a(i2, list, j2);
    }

    private void b() {
        long nanoTime;
        StringBuilder sb;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d dVar;
        boolean z;
        if (this.f1108k.hasMessages(11)) {
            d();
        } else {
            b(1);
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("afterUpload message:" + this.f1103f);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a aVar = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h;
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(aVar.h(), 1);
        if (this.f1103f == 2) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(aVar.e(), 1);
            synchronized (this.b) {
                try {
                    long nanoTime2 = System.nanoTime();
                    this.b.wait(5000L);
                    nanoTime = System.nanoTime() - nanoTime2;
                    sb = new StringBuilder();
                    sb.append("afterUpload delta:");
                    sb.append(nanoTime);
                    sb.append(" start:");
                    sb.append(nanoTime2);
                    sb.append(" condition:");
                    dVar = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1115g;
                } catch (InterruptedException e2) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("wait exception:" + e2.getMessage());
                    e2.printStackTrace();
                }
                if (!dVar.b && !dVar.f1119c) {
                    z = false;
                    sb.append(z);
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a(sb.toString());
                    if (nanoTime < 5000000000L && 5000000000L - nanoTime >= 50000000) {
                        if (!dVar.b && !dVar.f1119c) {
                            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("afterUpload meet notifyRunOnce again");
                            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(aVar.g(), 1);
                            a(2);
                        }
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(aVar.U(), 1);
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("afterUpload wait serverBusy");
                    }
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("afterUpload wait timeout");
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(aVar.e0(), 1);
                }
                z = true;
                sb.append(z);
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a(sb.toString());
                if (nanoTime < 5000000000L) {
                    if (!dVar.b) {
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("afterUpload meet notifyRunOnce again");
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(aVar.g(), 1);
                        a(2);
                    }
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(aVar.U(), 1);
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("afterUpload wait serverBusy");
                }
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("afterUpload wait timeout");
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(aVar.e0(), 1);
            }
        }
    }

    private void b(int i2) {
        AtomicLong H;
        if (a()) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.w(), 1);
        } else if (this.f1108k == null) {
        } else {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a aVar = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h;
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(aVar.N(), 1);
            if (this.f1108k.hasMessages(1)) {
                return;
            }
            if (i2 == 1) {
                H = aVar.f();
            } else if (i2 != 2) {
                if (i2 == 3) {
                    H = aVar.H();
                }
                this.f1108k.sendEmptyMessage(1);
            } else {
                H = aVar.v();
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(H, 1);
            this.f1108k.sendEmptyMessage(1);
        }
    }

    private void b(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (g()) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("upload cancel:" + bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(this.f1103f));
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.q(), 1);
            if (this.f1102e.size() != 0) {
                return;
            }
            if (this.f1108k.hasMessages(2)) {
                a(false);
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1115g.b = false;
            this.f1105h = 0L;
            this.f1104g = 0L;
            this.f1110m.set(0);
            this.n.set(0);
        }
        boolean a2 = a(this.f1103f, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1115g.b);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(a2, this.f1103f, aVar);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.p(), 1);
        if (a2) {
            List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> a3 = this.f1100c.a(this.f1103f, -1);
            if (a3 != null) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("upload size:" + a3.size());
                b(a3);
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.c("no need upload");
        }
        d();
    }

    private void b(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list) {
        String str;
        String str2;
        if (list.size() != 0) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.a(list, this.f1102e.size());
            if (list.size() > 1 || bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.d()) {
                str2 = "batchRead";
            } else {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar = list.get(0);
                if (aVar == null) {
                    str = "upload adLogEvent is null";
                } else if (aVar.e() == 1) {
                    str2 = "highPriority";
                } else if (aVar.b() == 0 && aVar.e() == 2) {
                    if (aVar.c() != 3) {
                        a(list);
                        return;
                    }
                    str2 = "version_v3";
                } else if (aVar.b() == 1) {
                    str2 = "stats";
                } else if (aVar.b() == 3) {
                    str2 = "adType_v3";
                } else if (aVar.b() == 2) {
                    str2 = "other";
                } else {
                    str = "upload adLogEvent adType error";
                }
            }
            a(list, str2);
            return;
        }
        d();
        str = "upload list is empty";
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a(str);
    }

    private void b(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, boolean z, long j2) {
        this.f1107j.incrementAndGet();
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.K(), 1);
        try {
            this.f1101d.a(list, new b(z, j2));
        } catch (Exception e2) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("outer exception：" + e2.getMessage());
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.I(), 1);
            this.f1107j.decrementAndGet();
        }
    }

    private void c() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.Z(), 1);
        a(false);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1115g.e();
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("exit log thread");
    }

    private boolean c(int i2) {
        if (i2 >= 4 && this.f1107j.get() == 0) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d dVar = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1115g;
            if (!dVar.b && !dVar.f1119c) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        try {
            if (this.f1102e.size() == 0 && this.f1108k.hasMessages(11) && a()) {
                a(false);
            }
        } catch (Exception e2) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b(e2.getMessage());
        }
    }

    private void e() {
        while (a()) {
            try {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a aVar = bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h;
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(aVar.F(), 1);
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a poll = this.f1102e.poll(com.heytap.mcssdk.constant.a.f3314d, TimeUnit.MILLISECONDS);
                int size = this.f1102e.size();
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("poll size:" + size);
                if (poll instanceof bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b) {
                    a(poll, size);
                } else if (poll == null) {
                    int incrementAndGet = this.f1106i.incrementAndGet();
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(aVar.o(), 1);
                    if (c(incrementAndGet)) {
                        c();
                        return;
                    } else if (incrementAndGet < 4) {
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("timeoutCount:" + incrementAndGet);
                        this.f1103f = 1;
                        b((bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a) null);
                    }
                } else {
                    a(poll);
                    b(poll);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("run exception:" + th.getMessage());
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.I(), 1);
            }
        }
    }

    private void f() {
        if (this.f1102e.size() >= 100) {
            for (int i2 = 0; i2 < 100; i2++) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a poll = this.f1102e.poll();
                if (poll instanceof bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b) {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("ignore tm");
                } else if (poll != null) {
                    a(poll);
                } else {
                    bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("event == null");
                }
            }
        }
    }

    private boolean g() {
        return bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1115g.b && (this.f1103f == 4 || this.f1103f == 7 || this.f1103f == 6 || this.f1103f == 5 || this.f1103f == 2);
    }

    private void h() {
        if (!isAlive()) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("th dead");
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1115g.a();
        } else if (a()) {
        } else {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("monitor  mLogThread ");
            a(6);
        }
    }

    private void i() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("sendServerBusyOrRoutineErrorRetryMessage");
        h();
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.G(), 1);
        a(1);
    }

    public void a(int i2) {
        try {
            boolean a2 = a(i2, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1115g.b);
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("notify flush : " + a2 + ExpandableTextView.N + i2);
            if (i2 == 6 || a2) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b bVar = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.b();
                bVar.a(i2);
                this.f1102e.add(bVar);
                b(3);
            }
        } catch (Throwable th) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b(th.getMessage());
        }
    }

    public void a(int i2, long j2) {
        String str;
        if (this.f1108k == null) {
            str = "mHandler == null";
        } else {
            Message obtain = Message.obtain();
            obtain.what = i2;
            if (i2 == 2) {
                int incrementAndGet = this.f1110m.incrementAndGet();
                long j3 = (((incrementAndGet - 1) % 4) + 1) * j2;
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("sendMonitorMessage:" + i2 + "  busy:" + incrementAndGet + "  l:" + j3);
                this.f1108k.sendMessageDelayed(obtain, j3);
                return;
            } else if (i2 == 3) {
                int incrementAndGet2 = this.n.incrementAndGet();
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("sendMonitorMessage:" + i2 + "  error:" + incrementAndGet2);
                this.f1108k.sendMessageDelayed(obtain, ((long) (((incrementAndGet2 + (-1)) % 4) + 1)) * j2);
                return;
            } else {
                str = "sendMonitorMessage error state";
            }
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b(str);
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, boolean z) {
        if (aVar == null) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("ignore result : " + z + Constants.COLON_SEPARATOR + this.a + " adType: " + ((int) aVar.b()));
        if (!z) {
            this.f1102e.add(aVar);
            b(2);
        } else if (this.f1108k == null) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("handler is null，ignore is true");
        } else {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(aVar);
            a((List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a>) arrayList, true, "ignore_result_dispatch");
        }
    }

    public void a(boolean z) {
        this.a = z;
    }

    public boolean a() {
        return this.a;
    }

    public boolean a(int i2, boolean z) {
        g b2 = j.l().b();
        if (b2 == null || !b2.a(j.l().d())) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b("AdThread NET IS NOT AVAILABLE!!!");
            return false;
        }
        return this.f1100c.a(i2, z);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("HANDLER_MESSAGE_INIT");
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1116h.u(), 1);
            a(true);
            e();
        } else if (i2 == 2 || i2 == 3) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("-----------------server busy handleMessage---------------- ");
            i();
        } else if (i2 == 11) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("opt upload");
            ArrayList arrayList = new ArrayList(this.f1109l);
            this.f1109l.clear();
            a((List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a>) arrayList, false, "timeout_dispatch");
            b();
        }
        return true;
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        this.f1108k = new Handler(getLooper(), this);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d.f1115g.a(this.f1108k);
        this.f1108k.sendEmptyMessage(1);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("onLooperPrepared");
    }
}
