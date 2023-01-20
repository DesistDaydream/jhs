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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class a implements av<a, e>, Serializable, Cloneable {

    /* renamed from: e */
    public static final Map<e, bh> f7518e;

    /* renamed from: f */
    private static final long f7519f = 9132678615281394583L;

    /* renamed from: g */
    private static final bz f7520g = new bz("IdJournal");

    /* renamed from: h */
    private static final bp f7521h = new bp("domain", (byte) 11, 1);

    /* renamed from: i */
    private static final bp f7522i = new bp("old_id", (byte) 11, 2);

    /* renamed from: j */
    private static final bp f7523j = new bp("new_id", (byte) 11, 3);

    /* renamed from: k */
    private static final bp f7524k = new bp("ts", (byte) 10, 4);

    /* renamed from: l */
    private static final Map<Class<? extends cc>, cd> f7525l;

    /* renamed from: m */
    private static final int f7526m = 0;
    public String a;
    public String b;

    /* renamed from: c */
    public String f7527c;

    /* renamed from: d */
    public long f7528d;
    private byte n;
    private e[] o;

    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a */
    /* loaded from: classes3.dex */
    public static class C0289a extends ce<a> {
        private C0289a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, a aVar) throws bb {
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
                            if (s != 4) {
                                bx.a(buVar, b);
                            } else if (b == 10) {
                                aVar.f7528d = buVar.x();
                                aVar.d(true);
                            } else {
                                bx.a(buVar, b);
                            }
                        } else if (b == 11) {
                            aVar.f7527c = buVar.z();
                            aVar.c(true);
                        } else {
                            bx.a(buVar, b);
                        }
                    } else if (b == 11) {
                        aVar.b = buVar.z();
                        aVar.b(true);
                    } else {
                        bx.a(buVar, b);
                    }
                } else if (b == 11) {
                    aVar.a = buVar.z();
                    aVar.a(true);
                } else {
                    bx.a(buVar, b);
                }
                buVar.m();
            }
            buVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new bv("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, a aVar) throws bb {
            aVar.n();
            buVar.a(a.f7520g);
            if (aVar.a != null) {
                buVar.a(a.f7521h);
                buVar.a(aVar.a);
                buVar.c();
            }
            if (aVar.b != null && aVar.g()) {
                buVar.a(a.f7522i);
                buVar.a(aVar.b);
                buVar.c();
            }
            if (aVar.f7527c != null) {
                buVar.a(a.f7523j);
                buVar.a(aVar.f7527c);
                buVar.c();
            }
            buVar.a(a.f7524k);
            buVar.a(aVar.f7528d);
            buVar.c();
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
        public C0289a b() {
            return new C0289a();
        }
    }

    /* loaded from: classes3.dex */
    public static class c extends cf<a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, a aVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(aVar.a);
            caVar.a(aVar.f7527c);
            caVar.a(aVar.f7528d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            caVar.a(bitSet, 1);
            if (aVar.g()) {
                caVar.a(aVar.b);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, a aVar) throws bb {
            ca caVar = (ca) buVar;
            aVar.a = caVar.z();
            aVar.a(true);
            aVar.f7527c = caVar.z();
            aVar.c(true);
            aVar.f7528d = caVar.x();
            aVar.d(true);
            if (caVar.b(1).get(0)) {
                aVar.b = caVar.z();
                aVar.b(true);
            }
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
        f7525l = hashMap;
        hashMap.put(ce.class, new b());
        hashMap.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.DOMAIN, (e) new bh("domain", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.OLD_ID, (e) new bh("old_id", (byte) 2, new bi((byte) 11)));
        enumMap.put((EnumMap) e.NEW_ID, (e) new bh("new_id", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new bh("ts", (byte) 1, new bi((byte) 10)));
        Map<e, bh> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f7518e = unmodifiableMap;
        bh.a(a.class, unmodifiableMap);
    }

    public a() {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public a deepCopy() {
        return new a(this);
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
        this.b = null;
        this.f7527c = null;
        d(false);
        this.f7528d = 0L;
    }

    public boolean d() {
        return this.a != null;
    }

    public String e() {
        return this.b;
    }

    public void f() {
        this.b = null;
    }

    public boolean g() {
        return this.b != null;
    }

    public String h() {
        return this.f7527c;
    }

    public void i() {
        this.f7527c = null;
    }

    public boolean j() {
        return this.f7527c != null;
    }

    public long k() {
        return this.f7528d;
    }

    public void l() {
        this.n = as.b(this.n, 0);
    }

    public boolean m() {
        return as.a(this.n, 0);
    }

    public void n() throws bb {
        if (this.a != null) {
            if (this.f7527c != null) {
                return;
            }
            throw new bv("Required field 'new_id' was not present! Struct: " + toString());
        }
        throw new bv("Required field 'domain' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f7525l.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f7527c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f7528d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f7525l.get(buVar.D()).b().a(buVar, this);
    }

    /* loaded from: classes3.dex */
    public enum e implements bc {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");
        

        /* renamed from: e */
        private static final Map<String, e> f7531e = new HashMap();

        /* renamed from: f */
        private final short f7533f;

        /* renamed from: g */
        private final String f7534g;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f7531e.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f7533f = s;
            this.f7534g = str;
        }

        public static e a(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return null;
                        }
                        return TS;
                    }
                    return NEW_ID;
                }
                return OLD_ID;
            }
            return DOMAIN;
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
            return this.f7534g;
        }

        public static e a(String str) {
            return f7531e.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f7533f;
        }
    }

    public a a(String str) {
        this.a = str;
        return this;
    }

    public a b(String str) {
        this.b = str;
        return this;
    }

    public a c(String str) {
        this.f7527c = str;
        return this;
    }

    public void d(boolean z) {
        this.n = as.a(this.n, 0, z);
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
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
        this.f7527c = null;
    }

    public a(String str, String str2, long j2) {
        this();
        this.a = str;
        this.f7527c = str2;
        this.f7528d = j2;
        d(true);
    }

    public a a(long j2) {
        this.f7528d = j2;
        d(true);
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

    public a(a aVar) {
        this.n = (byte) 0;
        this.o = new e[]{e.OLD_ID};
        this.n = aVar.n;
        if (aVar.d()) {
            this.a = aVar.a;
        }
        if (aVar.g()) {
            this.b = aVar.b;
        }
        if (aVar.j()) {
            this.f7527c = aVar.f7527c;
        }
        this.f7528d = aVar.f7528d;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.n = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
