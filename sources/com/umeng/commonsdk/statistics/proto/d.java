package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bk;
import com.umeng.analytics.pro.bm;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bu;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.bz;
import com.umeng.analytics.pro.ca;
import com.umeng.analytics.pro.cc;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class d implements av<d, e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<e, bh> f7565d;

    /* renamed from: e */
    private static final long f7566e = 2846460275012375038L;

    /* renamed from: f */
    private static final bz f7567f = new bz("Imprint");

    /* renamed from: g */
    private static final bp f7568g = new bp("property", (byte) 13, 1);

    /* renamed from: h */
    private static final bp f7569h = new bp("version", (byte) 8, 2);

    /* renamed from: i */
    private static final bp f7570i = new bp("checksum", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends cc>, cd> f7571j;

    /* renamed from: k */
    private static final int f7572k = 0;
    public Map<String, com.umeng.commonsdk.statistics.proto.e> a;
    public int b;

    /* renamed from: c */
    public String f7573c;

    /* renamed from: l */
    private byte f7574l;

    /* loaded from: classes3.dex */
    public static class a extends ce<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, d dVar) throws bb {
            buVar.j();
            while (true) {
                bp l2 = buVar.l();
                byte b = l2.b;
                if (b == 0) {
                    break;
                }
                short s = l2.f7102c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            bx.a(buVar, b);
                        } else if (b == 11) {
                            dVar.f7573c = buVar.z();
                            dVar.c(true);
                        } else {
                            bx.a(buVar, b);
                        }
                    } else if (b == 8) {
                        dVar.b = buVar.w();
                        dVar.b(true);
                    } else {
                        bx.a(buVar, b);
                    }
                } else if (b == 13) {
                    br n = buVar.n();
                    dVar.a = new HashMap(n.f7103c * 2);
                    for (int i2 = 0; i2 < n.f7103c; i2++) {
                        String z = buVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(buVar);
                        dVar.a.put(z, eVar);
                    }
                    buVar.o();
                    dVar.a(true);
                } else {
                    bx.a(buVar, b);
                }
                buVar.m();
            }
            buVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new bv("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, d dVar) throws bb {
            dVar.l();
            buVar.a(d.f7567f);
            if (dVar.a != null) {
                buVar.a(d.f7568g);
                buVar.a(new br((byte) 11, (byte) 12, dVar.a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                    buVar.a(entry.getKey());
                    entry.getValue().write(buVar);
                }
                buVar.e();
                buVar.c();
            }
            buVar.a(d.f7569h);
            buVar.a(dVar.b);
            buVar.c();
            if (dVar.f7573c != null) {
                buVar.a(d.f7570i);
                buVar.a(dVar.f7573c);
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

    /* loaded from: classes3.dex */
    public static class c extends cf<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, d dVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(dVar.a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                caVar.a(entry.getKey());
                entry.getValue().write(caVar);
            }
            caVar.a(dVar.b);
            caVar.a(dVar.f7573c);
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, d dVar) throws bb {
            ca caVar = (ca) buVar;
            br brVar = new br((byte) 11, (byte) 12, caVar.w());
            dVar.a = new HashMap(brVar.f7103c * 2);
            for (int i2 = 0; i2 < brVar.f7103c; i2++) {
                String z = caVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(caVar);
                dVar.a.put(z, eVar);
            }
            dVar.a(true);
            dVar.b = caVar.w();
            dVar.b(true);
            dVar.f7573c = caVar.z();
            dVar.c(true);
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d */
    /* loaded from: classes3.dex */
    public static class C0292d implements cd {
        private C0292d() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f7571j = hashMap;
        hashMap.put(ce.class, new b());
        hashMap.put(cf.class, new C0292d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new bh("property", (byte) 1, new bk((byte) 13, new bi((byte) 11), new bm((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new bh("version", (byte) 1, new bi((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bh("checksum", (byte) 1, new bi((byte) 11)));
        Map<e, bh> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f7565d = unmodifiableMap;
        bh.a(d.class, unmodifiableMap);
    }

    public d() {
        this.f7574l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0;
        this.f7573c = null;
    }

    public void d() {
        this.a = null;
    }

    public boolean e() {
        return this.a != null;
    }

    public int f() {
        return this.b;
    }

    public void g() {
        this.f7574l = as.b(this.f7574l, 0);
    }

    public boolean h() {
        return as.a(this.f7574l, 0);
    }

    public String i() {
        return this.f7573c;
    }

    public void j() {
        this.f7573c = null;
    }

    public boolean k() {
        return this.f7573c != null;
    }

    public void l() throws bb {
        if (this.a != null) {
            if (this.f7573c != null) {
                return;
            }
            throw new bv("Required field 'checksum' was not present! Struct: " + toString());
        }
        throw new bv("Required field 'property' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f7571j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f7573c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f7571j.get(buVar.D()).b().a(buVar, this);
    }

    /* loaded from: classes3.dex */
    public enum e implements bc {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d */
        private static final Map<String, e> f7576d = new HashMap();

        /* renamed from: e */
        private final short f7578e;

        /* renamed from: f */
        private final String f7579f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f7576d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f7578e = s;
            this.f7579f = str;
        }

        public static e a(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return CHECKSUM;
                }
                return VERSION;
            }
            return PROPERTY;
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
            return this.f7579f;
        }

        public static e a(String str) {
            return f7576d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f7578e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, eVar);
    }

    public void b(boolean z) {
        this.f7574l = as.a(this.f7574l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f7573c = null;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i2, String str) {
        this();
        this.a = map;
        this.b = i2;
        b(true);
        this.f7573c = str;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: b */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.a = map;
        return this;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public d a(int i2) {
        this.b = i2;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.f7574l = (byte) 0;
        this.f7574l = dVar.f7574l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.a = hashMap;
        }
        this.b = dVar.b;
        if (dVar.k()) {
            this.f7573c = dVar.f7573c;
        }
    }

    public d a(String str) {
        this.f7573c = str;
        return this;
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
            this.f7574l = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
