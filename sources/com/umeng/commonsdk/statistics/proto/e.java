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
public class e implements av<e, EnumC0293e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC0293e, bh> f7580d;

    /* renamed from: e */
    private static final long f7581e = 7501688097813630241L;

    /* renamed from: f */
    private static final bz f7582f = new bz("ImprintValue");

    /* renamed from: g */
    private static final bp f7583g = new bp("value", (byte) 11, 1);

    /* renamed from: h */
    private static final bp f7584h = new bp("ts", (byte) 10, 2);

    /* renamed from: i */
    private static final bp f7585i = new bp("guid", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends cc>, cd> f7586j;

    /* renamed from: k */
    private static final int f7587k = 0;
    public String a;
    public long b;

    /* renamed from: c */
    public String f7588c;

    /* renamed from: l */
    private byte f7589l;

    /* renamed from: m */
    private EnumC0293e[] f7590m;

    /* loaded from: classes3.dex */
    public static class a extends ce<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, e eVar) throws bb {
            buVar.j();
            while (true) {
                bp l2 = buVar.l();
                byte b = l2.b;
                if (b == 0) {
                    buVar.k();
                    eVar.k();
                    return;
                }
                short s = l2.f7102c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            bx.a(buVar, b);
                        } else if (b == 11) {
                            eVar.f7588c = buVar.z();
                            eVar.c(true);
                        } else {
                            bx.a(buVar, b);
                        }
                    } else if (b == 10) {
                        eVar.b = buVar.x();
                        eVar.b(true);
                    } else {
                        bx.a(buVar, b);
                    }
                } else if (b == 11) {
                    eVar.a = buVar.z();
                    eVar.a(true);
                } else {
                    bx.a(buVar, b);
                }
                buVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, e eVar) throws bb {
            eVar.k();
            buVar.a(e.f7582f);
            if (eVar.a != null && eVar.d()) {
                buVar.a(e.f7583g);
                buVar.a(eVar.a);
                buVar.c();
            }
            if (eVar.g()) {
                buVar.a(e.f7584h);
                buVar.a(eVar.b);
                buVar.c();
            }
            if (eVar.f7588c != null && eVar.j()) {
                buVar.a(e.f7585i);
                buVar.a(eVar.f7588c);
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
    public static class c extends cf<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, e eVar) throws bb {
            ca caVar = (ca) buVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            caVar.a(bitSet, 3);
            if (eVar.d()) {
                caVar.a(eVar.a);
            }
            if (eVar.g()) {
                caVar.a(eVar.b);
            }
            if (eVar.j()) {
                caVar.a(eVar.f7588c);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, e eVar) throws bb {
            ca caVar = (ca) buVar;
            BitSet b = caVar.b(3);
            if (b.get(0)) {
                eVar.a = caVar.z();
                eVar.a(true);
            }
            if (b.get(1)) {
                eVar.b = caVar.x();
                eVar.b(true);
            }
            if (b.get(2)) {
                eVar.f7588c = caVar.z();
                eVar.c(true);
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
        f7586j = hashMap;
        hashMap.put(ce.class, new b());
        hashMap.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(EnumC0293e.class);
        enumMap.put((EnumMap) EnumC0293e.VALUE, (EnumC0293e) new bh("value", (byte) 2, new bi((byte) 11)));
        enumMap.put((EnumMap) EnumC0293e.TS, (EnumC0293e) new bh("ts", (byte) 2, new bi((byte) 10)));
        enumMap.put((EnumMap) EnumC0293e.GUID, (EnumC0293e) new bh("guid", (byte) 2, new bi((byte) 11)));
        Map<EnumC0293e, bh> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f7580d = unmodifiableMap;
        bh.a(e.class, unmodifiableMap);
    }

    public e() {
        this.f7589l = (byte) 0;
        this.f7590m = new EnumC0293e[]{EnumC0293e.VALUE, EnumC0293e.TS, EnumC0293e.GUID};
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public e deepCopy() {
        return new e(this);
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
        this.f7588c = null;
    }

    public boolean d() {
        return this.a != null;
    }

    public long e() {
        return this.b;
    }

    public void f() {
        this.f7589l = as.b(this.f7589l, 0);
    }

    public boolean g() {
        return as.a(this.f7589l, 0);
    }

    public String h() {
        return this.f7588c;
    }

    public void i() {
        this.f7588c = null;
    }

    public boolean j() {
        return this.f7588c != null;
    }

    public void k() throws bb {
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        f7586j.get(buVar.D()).b().b(buVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f7588c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        f7586j.get(buVar.D()).b().a(buVar, this);
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e */
    /* loaded from: classes3.dex */
    public enum EnumC0293e implements bc {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");
        

        /* renamed from: d */
        private static final Map<String, EnumC0293e> f7592d = new HashMap();

        /* renamed from: e */
        private final short f7594e;

        /* renamed from: f */
        private final String f7595f;

        static {
            Iterator it = EnumSet.allOf(EnumC0293e.class).iterator();
            while (it.hasNext()) {
                EnumC0293e enumC0293e = (EnumC0293e) it.next();
                f7592d.put(enumC0293e.b(), enumC0293e);
            }
        }

        EnumC0293e(short s, String str) {
            this.f7594e = s;
            this.f7595f = str;
        }

        public static EnumC0293e a(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return GUID;
                }
                return TS;
            }
            return VALUE;
        }

        public static EnumC0293e b(int i2) {
            EnumC0293e a = a(i2);
            if (a != null) {
                return a;
            }
            throw new IllegalArgumentException("Field " + i2 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.bc
        public String b() {
            return this.f7595f;
        }

        public static EnumC0293e a(String str) {
            return f7592d.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f7594e;
        }
    }

    public e a(String str) {
        this.a = str;
        return this;
    }

    public void b(boolean z) {
        this.f7589l = as.a(this.f7589l, 0, z);
    }

    public void c(boolean z) {
        if (z) {
            return;
        }
        this.f7588c = null;
    }

    public void a(boolean z) {
        if (z) {
            return;
        }
        this.a = null;
    }

    public e b(String str) {
        this.f7588c = str;
        return this;
    }

    public e(long j2, String str) {
        this();
        this.b = j2;
        b(true);
        this.f7588c = str;
    }

    public e a(long j2) {
        this.b = j2;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public EnumC0293e fieldForId(int i2) {
        return EnumC0293e.a(i2);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new bo(new cg(objectOutputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public e(e eVar) {
        this.f7589l = (byte) 0;
        this.f7590m = new EnumC0293e[]{EnumC0293e.VALUE, EnumC0293e.TS, EnumC0293e.GUID};
        this.f7589l = eVar.f7589l;
        if (eVar.d()) {
            this.a = eVar.a;
        }
        this.b = eVar.b;
        if (eVar.j()) {
            this.f7588c = eVar.f7588c;
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f7589l = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }
}
