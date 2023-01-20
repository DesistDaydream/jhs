package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class an implements av<an, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;

    /* renamed from: k  reason: collision with root package name */
    public static final Map<e, bh> f7009k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f7010l = 420342210744516016L;

    /* renamed from: m  reason: collision with root package name */
    private static final bz f7011m = new bz("UMEnvelope");
    private static final bp n = new bp("version", (byte) 11, 1);
    private static final bp o = new bp("address", (byte) 11, 2);
    private static final bp p = new bp("signature", (byte) 11, 3);
    private static final bp q = new bp("serial_num", (byte) 8, 4);
    private static final bp r = new bp("ts_secs", (byte) 8, 5);
    private static final bp s = new bp("length", (byte) 8, 6);
    private static final bp t = new bp("entity", (byte) 11, 7);
    private static final bp u = new bp("guid", (byte) 11, 8);
    private static final bp v = new bp("checksum", (byte) 11, 9);
    private static final bp w = new bp("codex", (byte) 8, 10);
    private static final Map<Class<? extends cc>, cd> x;
    private static final int y = 0;
    private static final int z = 1;
    private byte C;
    private e[] D;
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f7012c;

    /* renamed from: d  reason: collision with root package name */
    public int f7013d;

    /* renamed from: e  reason: collision with root package name */
    public int f7014e;

    /* renamed from: f  reason: collision with root package name */
    public int f7015f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f7016g;

    /* renamed from: h  reason: collision with root package name */
    public String f7017h;

    /* renamed from: i  reason: collision with root package name */
    public String f7018i;

    /* renamed from: j  reason: collision with root package name */
    public int f7019j;

    /* loaded from: classes3.dex */
    public static class a extends ce<an> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: a */
        public void b(bu buVar, an anVar) throws bb {
            buVar.j();
            while (true) {
                bp l2 = buVar.l();
                byte b = l2.b;
                if (b == 0) {
                    buVar.k();
                    if (anVar.m()) {
                        if (anVar.p()) {
                            if (anVar.s()) {
                                anVar.G();
                                return;
                            }
                            throw new bv("Required field 'length' was not found in serialized data! Struct: " + toString());
                        }
                        throw new bv("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    throw new bv("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                }
                switch (l2.f7102c) {
                    case 1:
                        if (b == 11) {
                            anVar.a = buVar.z();
                            anVar.a(true);
                            break;
                        } else {
                            bx.a(buVar, b);
                            break;
                        }
                    case 2:
                        if (b == 11) {
                            anVar.b = buVar.z();
                            anVar.b(true);
                            break;
                        } else {
                            bx.a(buVar, b);
                            break;
                        }
                    case 3:
                        if (b == 11) {
                            anVar.f7012c = buVar.z();
                            anVar.c(true);
                            break;
                        } else {
                            bx.a(buVar, b);
                            break;
                        }
                    case 4:
                        if (b == 8) {
                            anVar.f7013d = buVar.w();
                            anVar.d(true);
                            break;
                        } else {
                            bx.a(buVar, b);
                            break;
                        }
                    case 5:
                        if (b == 8) {
                            anVar.f7014e = buVar.w();
                            anVar.e(true);
                            break;
                        } else {
                            bx.a(buVar, b);
                            break;
                        }
                    case 6:
                        if (b == 8) {
                            anVar.f7015f = buVar.w();
                            anVar.f(true);
                            break;
                        } else {
                            bx.a(buVar, b);
                            break;
                        }
                    case 7:
                        if (b == 11) {
                            anVar.f7016g = buVar.A();
                            anVar.g(true);
                            break;
                        } else {
                            bx.a(buVar, b);
                            break;
                        }
                    case 8:
                        if (b == 11) {
                            anVar.f7017h = buVar.z();
                            anVar.h(true);
                            break;
                        } else {
                            bx.a(buVar, b);
                            break;
                        }
                    case 9:
                        if (b == 11) {
                            anVar.f7018i = buVar.z();
                            anVar.i(true);
                            break;
                        } else {
                            bx.a(buVar, b);
                            break;
                        }
                    case 10:
                        if (b == 8) {
                            anVar.f7019j = buVar.w();
                            anVar.j(true);
                            break;
                        } else {
                            bx.a(buVar, b);
                            break;
                        }
                    default:
                        bx.a(buVar, b);
                        break;
                }
                buVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cc
        /* renamed from: b */
        public void a(bu buVar, an anVar) throws bb {
            anVar.G();
            buVar.a(an.f7011m);
            if (anVar.a != null) {
                buVar.a(an.n);
                buVar.a(anVar.a);
                buVar.c();
            }
            if (anVar.b != null) {
                buVar.a(an.o);
                buVar.a(anVar.b);
                buVar.c();
            }
            if (anVar.f7012c != null) {
                buVar.a(an.p);
                buVar.a(anVar.f7012c);
                buVar.c();
            }
            buVar.a(an.q);
            buVar.a(anVar.f7013d);
            buVar.c();
            buVar.a(an.r);
            buVar.a(anVar.f7014e);
            buVar.c();
            buVar.a(an.s);
            buVar.a(anVar.f7015f);
            buVar.c();
            if (anVar.f7016g != null) {
                buVar.a(an.t);
                buVar.a(anVar.f7016g);
                buVar.c();
            }
            if (anVar.f7017h != null) {
                buVar.a(an.u);
                buVar.a(anVar.f7017h);
                buVar.c();
            }
            if (anVar.f7018i != null) {
                buVar.a(an.v);
                buVar.a(anVar.f7018i);
                buVar.c();
            }
            if (anVar.F()) {
                buVar.a(an.w);
                buVar.a(anVar.f7019j);
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
    public static class c extends cf<an> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cc
        public void a(bu buVar, an anVar) throws bb {
            ca caVar = (ca) buVar;
            caVar.a(anVar.a);
            caVar.a(anVar.b);
            caVar.a(anVar.f7012c);
            caVar.a(anVar.f7013d);
            caVar.a(anVar.f7014e);
            caVar.a(anVar.f7015f);
            caVar.a(anVar.f7016g);
            caVar.a(anVar.f7017h);
            caVar.a(anVar.f7018i);
            BitSet bitSet = new BitSet();
            if (anVar.F()) {
                bitSet.set(0);
            }
            caVar.a(bitSet, 1);
            if (anVar.F()) {
                caVar.a(anVar.f7019j);
            }
        }

        @Override // com.umeng.analytics.pro.cc
        public void b(bu buVar, an anVar) throws bb {
            ca caVar = (ca) buVar;
            anVar.a = caVar.z();
            anVar.a(true);
            anVar.b = caVar.z();
            anVar.b(true);
            anVar.f7012c = caVar.z();
            anVar.c(true);
            anVar.f7013d = caVar.w();
            anVar.d(true);
            anVar.f7014e = caVar.w();
            anVar.e(true);
            anVar.f7015f = caVar.w();
            anVar.f(true);
            anVar.f7016g = caVar.A();
            anVar.g(true);
            anVar.f7017h = caVar.z();
            anVar.h(true);
            anVar.f7018i = caVar.z();
            anVar.i(true);
            if (caVar.b(1).get(0)) {
                anVar.f7019j = caVar.w();
                anVar.j(true);
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
        x = hashMap;
        hashMap.put(ce.class, new b());
        hashMap.put(cf.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.VERSION, (e) new bh("version", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.ADDRESS, (e) new bh("address", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.SIGNATURE, (e) new bh("signature", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.SERIAL_NUM, (e) new bh("serial_num", (byte) 1, new bi((byte) 8)));
        enumMap.put((EnumMap) e.TS_SECS, (e) new bh("ts_secs", (byte) 1, new bi((byte) 8)));
        enumMap.put((EnumMap) e.LENGTH, (e) new bh("length", (byte) 1, new bi((byte) 8)));
        enumMap.put((EnumMap) e.ENTITY, (e) new bh("entity", (byte) 1, new bi((byte) 11, true)));
        enumMap.put((EnumMap) e.GUID, (e) new bh("guid", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new bh("checksum", (byte) 1, new bi((byte) 11)));
        enumMap.put((EnumMap) e.CODEX, (e) new bh("codex", (byte) 2, new bi((byte) 8)));
        Map<e, bh> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f7009k = unmodifiableMap;
        bh.a(an.class, unmodifiableMap);
    }

    public an() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.f7018i;
    }

    public void B() {
        this.f7018i = null;
    }

    public boolean C() {
        return this.f7018i != null;
    }

    public int D() {
        return this.f7019j;
    }

    public void E() {
        this.C = as.b(this.C, 3);
    }

    public boolean F() {
        return as.a(this.C, 3);
    }

    public void G() throws bb {
        if (this.a != null) {
            if (this.b != null) {
                if (this.f7012c != null) {
                    if (this.f7016g != null) {
                        if (this.f7017h != null) {
                            if (this.f7018i != null) {
                                return;
                            }
                            throw new bv("Required field 'checksum' was not present! Struct: " + toString());
                        }
                        throw new bv("Required field 'guid' was not present! Struct: " + toString());
                    }
                    throw new bv("Required field 'entity' was not present! Struct: " + toString());
                }
                throw new bv("Required field 'signature' was not present! Struct: " + toString());
            }
            throw new bv("Required field 'address' was not present! Struct: " + toString());
        }
        throw new bv("Required field 'version' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: a */
    public an deepCopy() {
        return new an(this);
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
        this.f7012c = null;
        d(false);
        this.f7013d = 0;
        e(false);
        this.f7014e = 0;
        f(false);
        this.f7015f = 0;
        this.f7016g = null;
        this.f7017h = null;
        this.f7018i = null;
        j(false);
        this.f7019j = 0;
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
        return this.f7012c;
    }

    public void i() {
        this.f7012c = null;
    }

    public boolean j() {
        return this.f7012c != null;
    }

    public int k() {
        return this.f7013d;
    }

    public void l() {
        this.C = as.b(this.C, 0);
    }

    public boolean m() {
        return as.a(this.C, 0);
    }

    public int n() {
        return this.f7014e;
    }

    public void o() {
        this.C = as.b(this.C, 1);
    }

    public boolean p() {
        return as.a(this.C, 1);
    }

    public int q() {
        return this.f7015f;
    }

    public void r() {
        this.C = as.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.av
    public void read(bu buVar) throws bb {
        x.get(buVar.D()).b().b(buVar, this);
    }

    public boolean s() {
        return as.a(this.C, 2);
    }

    public byte[] t() {
        a(aw.c(this.f7016g));
        ByteBuffer byteBuffer = this.f7016g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f7012c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f7013d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f7014e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f7015f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f7016g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            aw.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f7017h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f7018i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f7019j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.f7016g;
    }

    public void v() {
        this.f7016g = null;
    }

    public boolean w() {
        return this.f7016g != null;
    }

    @Override // com.umeng.analytics.pro.av
    public void write(bu buVar) throws bb {
        x.get(buVar.D()).b().a(buVar, this);
    }

    public String x() {
        return this.f7017h;
    }

    public void y() {
        this.f7017h = null;
    }

    public boolean z() {
        return this.f7017h != null;
    }

    /* loaded from: classes3.dex */
    public enum e implements bc {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");
        

        /* renamed from: k  reason: collision with root package name */
        private static final Map<String, e> f7028k = new HashMap();

        /* renamed from: l  reason: collision with root package name */
        private final short f7029l;

        /* renamed from: m  reason: collision with root package name */
        private final String f7030m;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f7028k.put(eVar.b(), eVar);
            }
        }

        e(short s, String str) {
            this.f7029l = s;
            this.f7030m = str;
        }

        public static e a(int i2) {
            switch (i2) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
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
            return this.f7030m;
        }

        public static e a(String str) {
            return f7028k.get(str);
        }

        @Override // com.umeng.analytics.pro.bc
        public short a() {
            return this.f7029l;
        }
    }

    public an a(String str) {
        this.a = str;
        return this;
    }

    public an b(String str) {
        this.b = str;
        return this;
    }

    public an c(String str) {
        this.f7012c = str;
        return this;
    }

    public void d(boolean z2) {
        this.C = as.a(this.C, 0, z2);
    }

    public void e(boolean z2) {
        this.C = as.a(this.C, 1, z2);
    }

    public void f(boolean z2) {
        this.C = as.a(this.C, 2, z2);
    }

    public void g(boolean z2) {
        if (z2) {
            return;
        }
        this.f7016g = null;
    }

    public void h(boolean z2) {
        if (z2) {
            return;
        }
        this.f7017h = null;
    }

    public void i(boolean z2) {
        if (z2) {
            return;
        }
        this.f7018i = null;
    }

    public void j(boolean z2) {
        this.C = as.a(this.C, 3, z2);
    }

    public void a(boolean z2) {
        if (z2) {
            return;
        }
        this.a = null;
    }

    public void b(boolean z2) {
        if (z2) {
            return;
        }
        this.b = null;
    }

    public void c(boolean z2) {
        if (z2) {
            return;
        }
        this.f7012c = null;
    }

    public an d(String str) {
        this.f7017h = str;
        return this;
    }

    public an e(String str) {
        this.f7018i = str;
        return this;
    }

    public an(String str, String str2, String str3, int i2, int i3, int i4, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.a = str;
        this.b = str2;
        this.f7012c = str3;
        this.f7013d = i2;
        d(true);
        this.f7014e = i3;
        e(true);
        this.f7015f = i4;
        f(true);
        this.f7016g = byteBuffer;
        this.f7017h = str4;
        this.f7018i = str5;
    }

    public an a(int i2) {
        this.f7013d = i2;
        d(true);
        return this;
    }

    public an b(int i2) {
        this.f7014e = i2;
        e(true);
        return this;
    }

    public an c(int i2) {
        this.f7015f = i2;
        f(true);
        return this;
    }

    public an d(int i2) {
        this.f7019j = i2;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.av
    /* renamed from: e */
    public e fieldForId(int i2) {
        return e.a(i2);
    }

    public an a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public an a(ByteBuffer byteBuffer) {
        this.f7016g = byteBuffer;
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
            this.C = (byte) 0;
            read(new bo(new cg(objectInputStream)));
        } catch (bb e2) {
            throw new IOException(e2.getMessage());
        }
    }

    public an(an anVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = anVar.C;
        if (anVar.d()) {
            this.a = anVar.a;
        }
        if (anVar.g()) {
            this.b = anVar.b;
        }
        if (anVar.j()) {
            this.f7012c = anVar.f7012c;
        }
        this.f7013d = anVar.f7013d;
        this.f7014e = anVar.f7014e;
        this.f7015f = anVar.f7015f;
        if (anVar.w()) {
            this.f7016g = aw.d(anVar.f7016g);
        }
        if (anVar.z()) {
            this.f7017h = anVar.f7017h;
        }
        if (anVar.C()) {
            this.f7018i = anVar.f7018i;
        }
        this.f7019j = anVar.f7019j;
    }
}
