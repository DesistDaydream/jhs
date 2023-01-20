package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.bb;
import com.umeng.analytics.pro.bc;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.bi;
import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.bp;
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
public class b implements av<b, e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<e, bh> f7535d;

    /* renamed from: e */
    private static final long f7536e = -6496538196005191531L;

    /* renamed from: f */
    private static final bz f7537f = new bz("IdSnapshot");

    /* renamed from: g */
    private static final bp f7538g = new bp("identity", (byte) 11, 1);

    /* renamed from: h */
    private static final bp f7539h = new bp("ts", (byte) 10, 2);

    /* renamed from: i */
    private static final bp f7540i = new bp("version", (byte) 8, 3);

    /* renamed from: j */
    private static final Map<Class<? extends cc>, cd> f7541j;

    /* renamed from: k */
    private static final int f7542k = 0;

    /* renamed from: l */
    private static final int f7543l = 1;
    public String a;
    public long b;

    /* renamed from: c */
    public int f7544c;

    /* renamed from: m */
    private byte f7545m;

    /* loaded from: classes3.dex */
    public static class a extends ce<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, b bVar) throws bb {
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
                        } else if (b == 8) {
                            bVar.f7544c = buVar.w();
                            bVar.c(true);
                        } else {
                            bx.a(buVar, b);
                        }
                    } else if (b == 10) {
                        bVar.b = buVar.x();
                        bVar.b(true);
                    } else {
                        bx.a(buVar, b);
                    }
                } else if (b == 11) {
                    bVar.a = buVar.z();
                    bVar.a(true);
                } else {
                    bx.a(buVar, b);
                }
                buVar.m();
            }
            buVar.k();
            if (bVar.g()) {
                if (bVar.j()) {
                    bVar.k();
                    return;
                }
                throw new bv("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            throw new bv("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, b bVar) throws bb {
            bVar.k();
            buVar.a(b.f7537f);
            if (bVar.a != null) {
                buVar.a(b.f7538g);
                buVar.a(bVar.a);
                buVar.c();
            }
            buVar.a(b.f7539h);
            buVar.a(bVar.b);
            buVar.c();
            buVar.a(b.f7540i);
            buVar.a(bVar.f7544c);
            buVar.c();
            buVar.d();
            buVar.b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b */
    /* loaded from: classes3.dex */
    public static class C0290b implements cd {
        private C0290b() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends cf<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, b bVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(bVar.a);
            caVar.a(bVar.b);
            caVar.a(bVar.f7544c);
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, b bVar) throws bb {
            ca caVar = (ca) buVar;
            bVar.a = caVar.z();
            bVar.a(true);
            bVar.b = caVar.x();
            bVar.b(true);
            bVar.f7544c = caVar.w();
            bVar.c(true);
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements cd {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cd
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f7541j = hashMap;
        hashMap.put(ce.class, new C0290b());
        hashMap.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new bh("identity", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new bh("ts", (byte) 1, new bi((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new bh("version", (byte) 1, new bi((byte) 8)));
        Map<e, bh> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f7535d = unmodifiableMap;
        bh.a(b.class, unmodifiableMap);
    }

    public b() {
        this.f7545m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.a;
    }

    public void c() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.av
    public void clear() {
        this.a = null;
        b(false);
        this.b = 0L;
        c(false);
        this.f7544c = 0;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.f7545m = as.b(this.f7545m, 0);
    }

    public boolean g() {
        return as.a(this.f7545m, 0);
    }

    public int h() {
        return this.f7544c;
    }

    public void i() {
        this.f7545m = as.b(this.f7545m, 1);
    }

    public boolean j() {
        return as.a(this.f7545m, 1);
    }

    public void k() throws bb {
        if (this.a != null) {
            return;
        }
        throw new bv("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f7541j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f7544c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f7541j.get(buVar.D()).b().a(buVar, this);
    }

    /* loaded from: classes3.dex */
    public enum e implements bc {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");
        

        /* renamed from: d */
        private static final Map<String, e> f7547d = new HashMap();

        /* renamed from: e */
        private final short f7549e;

        /* renamed from: f */
        private final String f7550f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f7547d.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f7549e = s;
            this.f7550f = str;
        }

        public static e a(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return VERSION;
                }
                return TS;
            }
            return IDENTITY;
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
            return this.f7550f;
        }

        public static e a(String str) {
            return f7547d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f7549e;
        }
    }

    public b a(String str) {
        this.a = str;
        return this;
    }

    public void b(boolean z) {
        this.f7545m = as.a(this.f7545m, 0, z);
    }

    public void c(boolean z) {
        this.f7545m = as.a(this.f7545m, 1, z);
    }

    public b(String str, long j2, int i2) {
        this();
        this.a = str;
        this.b = j2;
        b(true);
        this.f7544c = i2;
        c(true);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: b */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public b a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    public b a(int i2) {
        this.f7544c = i2;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public b(b bVar) {
        this.f7545m = (byte) 0;
        this.f7545m = bVar.f7545m;
        if (bVar.d()) {
            this.a = bVar.a;
        }
        this.b = bVar.b;
        this.f7544c = bVar.f7544c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f7545m = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
