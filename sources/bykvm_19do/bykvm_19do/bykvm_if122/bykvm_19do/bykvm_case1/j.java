package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.k;
import com.bytedance.msdk.adapter.util.Logger;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class j implements Comparable<j> {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f777c;

    /* renamed from: d  reason: collision with root package name */
    private String f778d = "1";

    /* renamed from: e  reason: collision with root package name */
    private String f779e = "0";

    /* renamed from: f  reason: collision with root package name */
    private int f780f;

    /* renamed from: g  reason: collision with root package name */
    private int f781g;

    /* renamed from: h  reason: collision with root package name */
    private int f782h;

    /* renamed from: i  reason: collision with root package name */
    private int f783i;

    /* renamed from: j  reason: collision with root package name */
    private String f784j;

    /* renamed from: k  reason: collision with root package name */
    private String f785k;

    /* renamed from: l  reason: collision with root package name */
    private String f786l;

    /* renamed from: m  reason: collision with root package name */
    private int f787m;
    private int n;
    private int o;
    private int p;
    private int q;
    private h r;
    private Map<String, String> s;
    private int t;
    private String u;
    private int v;
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i w;
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g x;

    public String A() {
        return this.f785k;
    }

    public boolean B() {
        return this.f780f == 1;
    }

    public boolean C() {
        return bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f().g(this.a);
    }

    public boolean D() {
        return this.v == 1;
    }

    public boolean E() {
        return this.f780f == 3;
    }

    public boolean F() {
        return this.f780f == 100;
    }

    public boolean G() {
        return this.f780f == 2;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(j jVar) {
        if (jVar != null && this.f781g <= jVar.p()) {
            return this.f781g < jVar.p() ? -1 : 0;
        }
        return 1;
    }

    public void a(int i2) {
        this.f787m = i2;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g gVar) {
        this.x = gVar;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i iVar) {
        this.w = iVar;
    }

    public void a(h hVar) {
        this.r = hVar;
    }

    public void a(String str) {
        this.f777c = str;
    }

    public void a(Map<String, String> map) {
        this.s = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0023 A[PHI: r0 r2 
      PHI: (r0v6 int) = (r0v3 int), (r0v0 int) binds: [B:7:0x000f, B:4:0x0004] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r2v2 char) = (r2v1 char), (r2v3 char) binds: [B:7:0x000f, B:4:0x0004] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:6:0x000b -> B:7:0x000f). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x000f -> B:18:0x0023). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a() {
        /*
            r3 = this;
            int r0 = r3.f780f
            if (r0 == 0) goto L9
            r1 = 92
            r2 = 92
            goto L23
        L9:
            r0 = 20
        Lb:
            r1 = 15
            r2 = 95
        Lf:
            switch(r1) {
                case 13: goto L20;
                case 14: goto L19;
                case 15: goto L13;
                default: goto L12;
            }
        L12:
            goto L23
        L13:
            switch(r2) {
                case 94: goto Lb;
                case 95: goto L17;
                case 96: goto Lb;
                default: goto L16;
            }
        L16:
            goto Lb
        L17:
            r0 = 1
            goto L1f
        L19:
            r1 = 100
            if (r0 != r1) goto L1e
            goto Lb
        L1e:
            r0 = 0
        L1f:
            return r0
        L20:
            r1 = 72
            goto Lb
        L23:
            r1 = 14
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j.a():boolean");
    }

    public j b() {
        List<String> c2 = k.c();
        j jVar = new j();
        jVar.a = this.a;
        k.b(c2, "mAdnetworkName");
        jVar.f777c = this.f777c;
        k.b(c2, "mAdnetwokrSlotId");
        jVar.f778d = this.f778d;
        k.b(c2, "mExchangeRate");
        jVar.f779e = this.f779e;
        k.b(c2, "mEcpm");
        jVar.f780f = this.f780f;
        k.b(c2, "mAdnetworkSlotType");
        jVar.f781g = this.f781g;
        k.b(c2, "mLoadSort");
        jVar.f782h = this.f782h;
        k.b(c2, "mShowSort");
        jVar.f783i = this.f783i;
        k.b(c2, "mRitType");
        jVar.o = this.o;
        k.b(c2, "originType");
        jVar.t = this.t;
        k.b(c2, "mSubAdType");
        jVar.f784j = this.f784j;
        k.b(c2, "mLoaderAdapterName");
        jVar.f785k = this.f785k;
        k.b(c2, "mWaterfallAbTestParam");
        jVar.f786l = this.f786l;
        k.b(c2, "mServerBiddingExtra");
        jVar.f787m = this.f787m;
        k.b(c2, "adExpiredTime");
        jVar.n = this.n;
        k.b(c2, "ifReuseAds");
        jVar.p = this.p;
        k.b(c2, "ifPreRequest");
        jVar.q = this.q;
        k.b(c2, "ifIsReady");
        jVar.b = this.b;
        k.b(c2, "mCustomAdnetworkName");
        ConcurrentHashMap concurrentHashMap = null;
        Map<String, String> map = this.s;
        if (map != null && map.size() > 0) {
            concurrentHashMap = new ConcurrentHashMap();
            concurrentHashMap.putAll(this.s);
        }
        jVar.s = concurrentHashMap;
        k.b(c2, "mMultilevelSlotCpm");
        jVar.u = this.u;
        k.b(c2, "mCustomAdapterJson");
        jVar.v = this.v;
        k.b(c2, "mAdnRitTimingMode");
        jVar.x = this.x;
        k.b(c2, "mIntervalFreqctlBean");
        jVar.w = this.w;
        k.b(c2, "mIntervalPacingBean");
        k.a(c2, "WaterFallConfig");
        return jVar;
    }

    public void b(int i2) {
        this.v = i2;
    }

    public void b(String str) {
        this.a = str;
    }

    public int c() {
        int i2 = this.f787m;
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

    public void c(int i2) {
        this.f780f = i2;
    }

    public void c(String str) {
        this.u = str;
    }

    public String d() {
        return this.f777c;
    }

    public void d(int i2) {
        this.q = i2;
    }

    public void d(String str) {
        this.b = str;
    }

    public String e() {
        return this.a;
    }

    public void e(int i2) {
        this.p = i2;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        this.f779e = str;
    }

    public int f() {
        int i2 = this.f780f;
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

    public void f(int i2) {
        this.n = i2;
    }

    public void f(String str) {
        this.f778d = str;
    }

    public String g() {
        return this.u;
    }

    public void g(int i2) {
        this.f781g = i2;
    }

    public void g(String str) {
        this.f784j = str;
    }

    public String h() {
        return this.b;
    }

    public void h(int i2) {
        this.o = i2;
    }

    public void h(String str) {
        this.f786l = str;
    }

    public double i() {
        try {
            return Double.valueOf(this.f779e).doubleValue() * Double.valueOf(this.f778d).doubleValue();
        } catch (Exception e2) {
            Logger.e("WaterFallConfig", "getEcpm error " + e2.toString());
            return 0.0d;
        }
    }

    public void i(int i2) {
        this.f783i = i2;
    }

    public void i(String str) {
        this.f785k = str;
    }

    public String j() {
        return this.f778d;
    }

    public void j(int i2) {
        this.f782h = i2;
    }

    public int k() {
        int i2 = this.q;
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

    public void k(int i2) {
        this.t = i2;
    }

    public int l() {
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

    public int m() {
        int i2 = this.n;
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

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.g n() {
        return this.x;
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i o() {
        return this.w;
    }

    public int p() {
        int i2 = this.f781g;
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
        return this.f784j;
    }

    public Map<String, String> r() {
        return this.s;
    }

    public int s() {
        int i2 = this.o;
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
        int i2 = this.f783i;
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
        return "WaterFallConfig{mAdnetworkName='" + this.a + "', mCustomAdnetworkName='" + this.b + "', mAdnetwokrSlotId='" + this.f777c + "', mExchangeRate=" + this.f778d + ", mSlotEcpm=" + this.f779e + ", mAdnetworkSlotType=" + this.f780f + ", mLoadSort=" + this.f781g + ", mShowSort=" + this.f782h + '}';
    }

    public String u() {
        return this.f786l;
    }

    public double v() {
        h hVar = this.r;
        if (hVar != null && !TextUtils.isEmpty(hVar.f())) {
            try {
                return Double.valueOf(this.r.f()).doubleValue();
            } catch (Exception e2) {
                Logger.e("WaterFallConfig", "getServerBiddingLoadEcpm error " + e2.toString());
            }
        }
        return -1.0d;
    }

    public double w() {
        h hVar = this.r;
        if (hVar != null && !TextUtils.isEmpty(hVar.g())) {
            try {
                return Double.valueOf(this.r.g()).doubleValue();
            } catch (Exception e2) {
                Logger.e("WaterFallConfig", "getServerBiddingShowEcpm error " + e2.toString());
            }
        }
        return -1.0d;
    }

    public h x() {
        return this.r;
    }

    public int y() {
        int i2 = this.f782h;
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

    public int z() {
        int i2 = this.t;
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
}
