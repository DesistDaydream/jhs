package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c {
    private int A;
    private double B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i I;
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g J;
    private int K;
    private JSONObject L;
    private String a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f744c;

    /* renamed from: d  reason: collision with root package name */
    private long f745d;

    /* renamed from: e  reason: collision with root package name */
    private long f746e;

    /* renamed from: f  reason: collision with root package name */
    private long f747f;

    /* renamed from: g  reason: collision with root package name */
    private long f748g;

    /* renamed from: h  reason: collision with root package name */
    private String f749h;

    /* renamed from: i  reason: collision with root package name */
    private List<j> f750i = new CopyOnWriteArrayList();

    /* renamed from: j  reason: collision with root package name */
    private Map<Integer, List<j>> f751j = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private List<Integer> f752k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    private double f753l;

    /* renamed from: m  reason: collision with root package name */
    private int f754m;
    private int n;
    private long o;
    private int p;
    private String q;
    private String r;
    private int s;
    private int t;
    private int u;
    private String v;
    private int w;
    private long x;
    private boolean y;
    private boolean z;

    /* JADX WARN: Can't wrap try/catch for region: R(9:(7:27|28|(1:30)(1:78)|31|(5:33|(1:35)|36|(1:38)(1:40)|39)|41|42)|(5:43|44|45|46|47)|(6:59|60|(2:70|71)(3:62|63|(2:65|(1:69)))|52|54|55)(1:49)|50|51|52|54|55|25) */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x03d0, code lost:
        r0 = e;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c b(org.json.JSONObject r28) {
        /*
            Method dump skipped, instructions count: 1015
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c.b(org.json.JSONObject):bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c");
    }

    private static Map<String, String> c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            Iterator<String> keys = jSONObject.keys();
            if (keys == null) {
                return null;
            }
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(optString)) {
                    hashMap.put(next, optString);
                }
            }
            if (hashMap.size() == 0) {
                return null;
            }
            return hashMap;
        } catch (Exception unused) {
            return null;
        }
    }

    private static Long n(int i2) {
        if (i2 != 1) {
            if (i2 != 2 && i2 != 3) {
                if (i2 != 5) {
                    if (i2 != 7) {
                    }
                }
            }
            return 0L;
        }
        return 1000L;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0038 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x002b A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0020 -> B:18:0x0024). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0028 -> B:25:0x0033). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0031 -> B:25:0x0033). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Long o(int r5) {
        /*
        L0:
            r0 = 1
            r1 = 10000(0x2710, double:4.9407E-320)
            if (r5 == r0) goto L3b
            r0 = 2
            if (r5 == r0) goto L3b
            r0 = 3
            r3 = 95
            if (r5 == r0) goto L20
            r0 = 5
            if (r5 == r0) goto L3b
            r0 = 7
            if (r5 == r0) goto L18
            r0 = 8
            if (r5 == r0) goto L18
            goto L33
        L18:
            r0 = 600000(0x927c0, double:2.964394E-318)
        L1b:
            java.lang.Long r5 = java.lang.Long.valueOf(r0)
            goto L3f
        L20:
            r0 = 94
            r4 = 125(0x7d, float:1.75E-43)
        L24:
            switch(r0) {
                case 94: goto L2f;
                case 95: goto L28;
                case 96: goto L2b;
                default: goto L27;
            }
        L27:
            goto L20
        L28:
            switch(r4) {
                case 94: goto L33;
                case 95: goto L3b;
                case 96: goto L33;
                default: goto L2b;
            }
        L2b:
            switch(r4) {
                case 55: goto L0;
                case 56: goto L20;
                case 57: goto L0;
                default: goto L2e;
            }
        L2e:
            goto L38
        L2f:
            r0 = 39
            if (r4 != r0) goto L38
        L33:
            r0 = 95
            r4 = 95
            goto L24
        L38:
            r0 = 5000(0x1388, double:2.4703E-320)
            goto L1b
        L3b:
            java.lang.Long r5 = java.lang.Long.valueOf(r1)
        L3f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c.o(int):java.lang.Long");
    }

    public Map<Integer, List<j>> A() {
        HashMap hashMap = new HashMap();
        Map<Integer, List<j>> map = this.f751j;
        if (map != null) {
            for (Map.Entry<Integer, List<j>> entry : map.entrySet()) {
                hashMap.put(Integer.valueOf(entry.getKey().intValue()), new ArrayList(entry.getValue()));
            }
        }
        return hashMap;
    }

    public List<j> B() {
        return this.f750i;
    }

    public String C() {
        return this.r;
    }

    public String D() {
        return this.v;
    }

    public long E() {
        long j2 = this.o;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return j2;
    }

    public boolean F() {
        boolean z = this.z;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return z;
    }

    public boolean G() {
        boolean z = this.y;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return z;
    }

    public boolean H() {
        return this.H == 1;
    }

    public boolean I() {
        return this.K == 1;
    }

    public boolean J() {
        return this.E == 3;
    }

    public c a() {
        while (true) {
            char c2 = '\n';
            while (true) {
                switch (c2) {
                    case '\n':
                        c2 = 11;
                    case 11:
                        List<String> b = k.b();
                        c cVar = new c();
                        cVar.a = this.a;
                        k.b(b, "mRitId");
                        cVar.b = this.b;
                        k.b(b, "mRitType");
                        cVar.f744c = this.f744c;
                        k.b(b, "mLookType");
                        cVar.f745d = this.f745d;
                        k.b(b, "mMinWaitTime");
                        cVar.f746e = this.f746e;
                        k.b(b, "mLayerTimeOut");
                        cVar.f747f = this.f747f;
                        k.b(b, "mTotalTimeOut");
                        cVar.f748g = this.f748g;
                        k.b(b, "mCacheTimeOut");
                        cVar.f749h = this.f749h;
                        k.b(b, "mVersion");
                        cVar.o = this.o;
                        k.b(b, "mWaterFallId");
                        cVar.u = this.u;
                        k.b(b, "reqType");
                        cVar.r = this.r;
                        k.b(b, "mWaterfallAbTestParam");
                        cVar.p = this.p;
                        k.b(b, "segmentId");
                        cVar.q = this.q;
                        k.b(b, "segmentVersion");
                        cVar.s = this.s;
                        k.b(b, "preLoadSortControl");
                        cVar.t = this.t;
                        k.b(b, "preShowSortControl");
                        cVar.v = this.v;
                        k.b(b, "waterfallExtra");
                        cVar.w = this.w;
                        k.b(b, "mMultilevelAfterP");
                        cVar.x = this.x;
                        k.b(b, "mMultilevelTimeOut");
                        cVar.A = this.A;
                        k.b(b, "mRefreshTime");
                        cVar.B = this.B;
                        k.b(b, "mBidFloor");
                        cVar.E = this.E;
                        k.b(b, "mParallelType");
                        cVar.F = this.F;
                        k.b(b, "mReqParallelNum");
                        cVar.G = this.G;
                        k.b(b, "mAdCount");
                        cVar.C = this.C;
                        k.b(b, "serverSideVerifyPreRequestTime");
                        cVar.D = this.D;
                        k.b(b, "serverSideRewardType");
                        cVar.K = this.K;
                        k.b(b, "mAdPrime");
                        cVar.J = this.J;
                        k.b(b, "mIntervalFreqctlBean");
                        cVar.I = this.I;
                        k.b(b, "mIntervalPacingBean");
                        cVar.H = this.H;
                        k.b(b, "mWaterFallTimingMode");
                        k.a(b, "AdsenseRitConfig");
                        return cVar;
                    case '\f':
                        while (true) {
                        }
                }
            }
        }
    }

    public j a(String str) {
        List<j> list;
        if (TextUtils.isEmpty(str) || (list = this.f750i) == null || list.size() == 0) {
            return null;
        }
        for (j jVar : this.f750i) {
            if (str.equals(jVar.d())) {
                return jVar;
            }
        }
        return null;
    }

    public void a(double d2) {
        this.B = d2;
    }

    public void a(int i2) {
        this.G = i2;
    }

    public void a(long j2) {
        this.f748g = j2;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g gVar) {
        this.J = gVar;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i iVar) {
        this.I = iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> r7) {
        /*
            r6 = this;
            r6.f750i = r7
            if (r7 != 0) goto L6
            goto L8d
        L6:
            r0 = 0
            r6.f754m = r0
            java.util.Map<java.lang.Integer, java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> r1 = r6.f751j
            r1.clear()
            java.util.List<java.lang.Integer> r1 = r6.f752k
            r1.clear()
            java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> r1 = r6.f750i
            int r1 = r1.size()
            r6.n = r1
            r1 = -1000(0xfffffffffffffc18, float:NaN)
        L1d:
            java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j> r2 = r6.f750i
            int r2 = r2.size()
            if (r0 >= r2) goto L82
            java.lang.Object r2 = r7.get(r0)
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r2 = (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j) r2
            if (r2 == 0) goto L7f
            int r3 = r2.f()
            r4 = 100
            if (r3 == r4) goto L5f
            int r3 = r2.f()
            if (r3 != 0) goto L3c
            goto L5f
        L3c:
            int r3 = r2.p()
            if (r3 == r1) goto L52
            int r1 = r6.f754m
            int r1 = r1 + 1
            r6.f754m = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r3 = r2.p()
            goto L6e
        L52:
            java.util.Map<java.lang.Integer, java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> r3 = r6.f751j
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            java.lang.Object r3 = r3.get(r4)
            java.util.List r3 = (java.util.List) r3
            goto L71
        L5f:
            int r1 = r6.f754m
            int r1 = r1 + 1
            r6.f754m = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r3 = r2.y()
        L6e:
            r5 = r3
            r3 = r1
            r1 = r5
        L71:
            if (r3 == 0) goto L7f
            r3.add(r2)
            java.util.Map<java.lang.Integer, java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> r2 = r6.f751j
            java.lang.Integer r4 = java.lang.Integer.valueOf(r1)
            r2.put(r4, r3)
        L7f:
            int r0 = r0 + 1
            goto L1d
        L82:
            java.util.List<java.lang.Integer> r7 = r6.f752k
            java.util.Map<java.lang.Integer, java.util.List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j>> r0 = r6.f751j
            java.util.Set r0 = r0.keySet()
            r7.addAll(r0)
        L8d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c.a(java.util.List):void");
    }

    public void a(JSONObject jSONObject) {
        this.L = jSONObject;
    }

    public void a(boolean z) {
        this.z = z;
    }

    public int b() {
        int i2 = this.G;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                    }
                } else if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = '[';
                }
            }
        }
        return i2;
    }

    public void b(double d2) {
        this.f753l = d2;
    }

    public void b(int i2) {
        this.K = i2;
    }

    public void b(long j2) {
        this.f746e = j2;
    }

    public void b(String str) {
        this.a = str;
    }

    public void b(List<j> list) {
        List<j> list2;
        this.f750i = list;
        if (list != null) {
            this.f754m = 0;
            this.f751j.clear();
            this.f752k.clear();
            this.n = this.f750i.size();
            int i2 = -1000;
            for (int i3 = 0; i3 < this.f750i.size(); i3++) {
                j jVar = list.get(i3);
                if (jVar != null) {
                    if (jVar.p() != i2) {
                        this.f754m++;
                        list2 = new ArrayList();
                        i2 = jVar.p();
                    } else {
                        list2 = this.f751j.get(Integer.valueOf(i2));
                    }
                    if (list2 != null) {
                        list2.add(jVar);
                        this.f751j.put(Integer.valueOf(i2), list2);
                    }
                }
            }
            this.f752k.addAll(this.f751j.keySet());
            return;
        }
        while (true) {
            char c2 = '\'';
            while (true) {
                switch (c2) {
                    case '%':
                    case '&':
                        return;
                    case '\'':
                        c2 = '%';
                }
            }
        }
    }

    public void b(boolean z) {
        this.y = z;
    }

    public double c() {
        double d2 = this.B;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return d2;
    }

    public void c(int i2) {
        this.f744c = i2;
    }

    public void c(long j2) {
        this.f745d = j2;
    }

    public void c(String str) {
        this.q = str;
    }

    public long d() {
        long j2 = this.f748g;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return j2;
    }

    public void d(int i2) {
        this.w = i2;
    }

    public void d(long j2) {
        this.x = j2;
    }

    public void d(String str) {
        this.f749h = str;
    }

    public double e() {
        double d2 = this.f753l;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return d2;
    }

    public void e(int i2) {
        this.E = i2;
    }

    public void e(long j2) {
        this.f747f = j2;
    }

    public void e(String str) {
        this.r = str;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g f() {
        return this.J;
    }

    public void f(int i2) {
        this.A = i2;
    }

    public void f(long j2) {
        this.o = j2;
    }

    public void f(String str) {
        this.v = str;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i g() {
        return this.I;
    }

    public void g(int i2) {
        this.F = i2;
    }

    public long h() {
        long j2 = this.f746e;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return j2;
    }

    public void h(int i2) {
        this.u = i2;
    }

    public List<Integer> i() {
        return this.f752k;
    }

    public void i(int i2) {
        this.b = i2;
    }

    public long j() {
        long j2 = this.f745d;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                    }
                } else if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = '[';
                }
            }
        }
        return j2;
    }

    public void j(int i2) {
        this.p = i2;
    }

    public int k() {
        int i2 = this.w;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i2;
    }

    public void k(int i2) {
        this.D = i2;
    }

    public long l() {
        long j2 = this.x;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                    }
                } else if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = '[';
                }
            }
        }
        return j2;
    }

    public void l(int i2) {
        this.C = i2;
    }

    public int m() {
        int i2 = this.E;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                    }
                } else if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = '[';
                }
            }
        }
        return i2;
    }

    public void m(int i2) {
        this.H = i2;
    }

    public int n() {
        int i2 = this.A;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i2;
    }

    public int o() {
        int i2 = this.F;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i2;
    }

    public int p() {
        int i2 = this.u;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                    }
                } else if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = '[';
                }
            }
        }
        return i2;
    }

    public String q() {
        return this.a;
    }

    public JSONObject r() {
        return this.L;
    }

    public int s() {
        int i2 = this.b;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i2;
    }

    public int t() {
        int i2 = this.p;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                    }
                } else if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = '[';
                }
            }
        }
        return i2;
    }

    public String toString() {
        while (true) {
            char c2 = 18;
            while (true) {
                switch (c2) {
                    case 18:
                    case 20:
                        c2 = 19;
                    case 19:
                        return "AdsenseRitConfig{mRitId='" + this.a + "', mRitType=" + this.b + ", mLookType=" + this.f744c + ", mMinWaitTime=" + this.f745d + ", mLayerTimeOut=" + this.f746e + ", mTotalTimeOut=" + this.f747f + ", mWaterFallConfigList=" + this.f750i + ", mWaterFallConfMap=" + this.f751j + ", mLoadSortLevelList=" + this.f752k + ", mCurrentCommonAdMaxCpm=" + this.f753l + ", mTotalLoadLevelCount=" + this.f754m + ", mTotalWaterFallCount=" + this.n + ", mWaterfallAbTestParam=" + this.r + ", mServerSideVerifyPreRequestTime=" + this.C + ", mServerSideVerifyRewardType=" + this.D + '}';
                }
            }
        }
    }

    public String u() {
        return this.q;
    }

    public int v() {
        int i2 = this.D;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                if (c2 == '\\') {
                    switch (c3) {
                        case 22:
                        case 23:
                            c2 = ']';
                            c3 = ']';
                    }
                } else if (c2 != ']') {
                    c2 = ']';
                    c3 = ']';
                }
            }
            while (true) {
                switch (c3) {
                    case '[':
                        break;
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = '[';
                }
            }
        }
        return i2;
    }

    public int w() {
        int i2 = this.C;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i2;
    }

    public long x() {
        long j2 = this.f747f;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return j2;
    }

    public int y() {
        int i2 = this.n;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i2;
    }

    public String z() {
        return this.f749h;
    }
}
