package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bj;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.bq;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cb;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class c implements av<c, e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<e, bh> f7551d;

    /* renamed from: e */
    private static final long f7552e = -5764118265293965743L;

    /* renamed from: f */
    private static final bz f7553f = new bz("IdTracking");

    /* renamed from: g */
    private static final bp f7554g = new bp("snapshots", (byte) 13, 1);

    /* renamed from: h */
    private static final bp f7555h = new bp("journals", cb.f7124m, 2);

    /* renamed from: i */
    private static final bp f7556i = new bp("checksum", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends cc>, cd> f7557j;
    public Map<String, com.umeng.commonsdk.statistics.proto.b> a;
    public List<com.umeng.commonsdk.statistics.proto.a> b;

    /* renamed from: c */
    public String f7558c;

    /* renamed from: k */
    private e[] f7559k;

    /* loaded from: classes3.dex */
    public static class a extends ce<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, c cVar) throws bb {
            buVar.j();
            while (true) {
                bp l2 = buVar.l();
                byte b = l2.b;
                if (b == 0) {
                    buVar.k();
                    cVar.n();
                    return;
                }
                short s = l2.f7102c;
                int i2 = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            bx.a(buVar, b);
                        } else if (b == 11) {
                            cVar.f7558c = buVar.z();
                            cVar.c(true);
                        } else {
                            bx.a(buVar, b);
                        }
                    } else if (b == 15) {
                        bq p = buVar.p();
                        cVar.b = new ArrayList(p.b);
                        while (i2 < p.b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(buVar);
                            cVar.b.add(aVar);
                            i2++;
                        }
                        buVar.q();
                        cVar.b(true);
                    } else {
                        bx.a(buVar, b);
                    }
                } else if (b == 13) {
                    br n = buVar.n();
                    cVar.a = new HashMap(n.f7103c * 2);
                    while (i2 < n.f7103c) {
                        String z = buVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(buVar);
                        cVar.a.put(z, bVar);
                        i2++;
                    }
                    buVar.o();
                    cVar.a(true);
                } else {
                    bx.a(buVar, b);
                }
                buVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, c cVar) throws bb {
            cVar.n();
            buVar.a(c.f7553f);
            if (cVar.a != null) {
                buVar.a(c.f7554g);
                buVar.a(new br((byte) 11, (byte) 12, cVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                    buVar.a(entry.getKey());
                    entry.getValue().write(buVar);
                }
                buVar.e();
                buVar.c();
            }
            if (cVar.b != null && cVar.j()) {
                buVar.a(c.f7555h);
                buVar.a(new bq((byte) 12, cVar.b.size()));
                for (com.umeng.commonsdk.statistics.proto.a aVar : cVar.b) {
                    aVar.write(buVar);
                }
                buVar.f();
                buVar.c();
            }
            if (cVar.f7558c != null && cVar.m()) {
                buVar.a(c.f7556i);
                buVar.a(cVar.f7558c);
                buVar.c();
            }
            buVar.d();
            buVar.b();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements cd {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c */
    /* loaded from: classes3.dex */
    public static class C0291c extends cf<c> {
        private C0291c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, c cVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(cVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                caVar.a(entry.getKey());
                entry.getValue().write(caVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            caVar.a(bitSet, 2);
            if (cVar.j()) {
                caVar.a(cVar.b.size());
                for (com.umeng.commonsdk.statistics.proto.a aVar : cVar.b) {
                    aVar.write(caVar);
                }
            }
            if (cVar.m()) {
                caVar.a(cVar.f7558c);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, c cVar) throws bb {
            ca caVar = (ca) buVar;
            br brVar = new br((byte) 11, (byte) 12, caVar.w());
            cVar.a = new HashMap(brVar.f7103c * 2);
            for (int i2 = 0; i2 < brVar.f7103c; i2++) {
                String z = caVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(caVar);
                cVar.a.put(z, bVar);
            }
            cVar.a(true);
            BitSet b = caVar.b(2);
            if (b.get(0)) {
                bq bqVar = new bq((byte) 12, caVar.w());
                cVar.b = new ArrayList(bqVar.b);
                for (int i3 = 0; i3 < bqVar.b; i3++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(caVar);
                    cVar.b.add(aVar);
                }
                cVar.b(true);
            }
            if (b.get(1)) {
                cVar.f7558c = caVar.z();
                cVar.c(true);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements cd {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a */
        public C0291c b() {
            return new C0291c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f7557j = hashMap;
        hashMap.put(ce.class, new b());
        hashMap.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new bh("snapshots", (byte) 1, new bk((byte) 13, new bi((byte) 11), new bm((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new bh("journals", (byte) 2, new bj(cb.f7124m, new bm((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bh("checksum", (byte) 2, new bi((byte) 11)));
        Map<e, bh> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f7551d = unmodifiableMap;
        bh.a(c.class, unmodifiableMap);
    }

    public c() {
        this.f7559k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.a = null;
        this.b = null;
        this.f7558c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.b;
    }

    public void i() {
        this.b = null;
    }

    public boolean j() {
        return this.b != null;
    }

    public String k() {
        return this.f7558c;
    }

    public void l() {
        this.f7558c = null;
    }

    public boolean m() {
        return this.f7558c != null;
    }

    public void n() throws bb {
        if (this.a != null) {
            return;
        }
        throw new bv("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f7557j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f7558c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f7557j.get(buVar.D()).b().a(buVar, this);
    }

    /* loaded from: classes3.dex */
    public enum e implements bc {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d */
        private static final Map<String, e> f7561d = new HashMap();

        /* renamed from: e */
        private final short f7563e;

        /* renamed from: f */
        private final String f7564f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f7561d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f7563e = s;
            this.f7564f = str;
        }

        public static e a(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return CHECKSUM;
                }
                return JOURNALS;
            }
            return SNAPSHOTS;
        }

        public static e b(int i2) {
            e a = a(i2);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bc
        public String b() {
            return this.f7564f;
        }

        public static e a(String str) {
            return f7561d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f7563e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, bVar);
    }

    public void b(boolean z) {
        if (z) {
            return;
        }
        this.b = null;
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f7558c = null;
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.a = map;
    }

    public c(c cVar) {
        this.f7559k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            for (com.umeng.commonsdk.statistics.proto.a aVar : cVar.b) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(aVar));
            }
            this.b = arrayList;
        }
        if (cVar.m()) {
            this.f7558c = cVar.f7558c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.b == null) {
            this.b = new ArrayList();
        }
        this.b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.b = list;
        return this;
    }

    public c a(String str) {
        this.f7558c = str;
        return this;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
