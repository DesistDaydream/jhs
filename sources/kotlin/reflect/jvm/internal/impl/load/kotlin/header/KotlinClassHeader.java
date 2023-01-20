package kotlin.reflect.jvm.internal.impl.load.kotlin.header;

import h.a2.n;
import h.a2.s0;
import h.k2.k;
import h.k2.v.u;
import h.o2.q;
import h.p2.b0.g.t.f.a0.f.e;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes3.dex */
public final class KotlinClassHeader {
    @d
    private final Kind a;
    @d
    private final e b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private final String[] f16573c;
    @k.e.a.e

    /* renamed from: d  reason: collision with root package name */
    private final String[] f16574d;
    @k.e.a.e

    /* renamed from: e  reason: collision with root package name */
    private final String[] f16575e;
    @k.e.a.e

    /* renamed from: f  reason: collision with root package name */
    private final String f16576f;

    /* renamed from: g  reason: collision with root package name */
    private final int f16577g;
    @k.e.a.e

    /* renamed from: h  reason: collision with root package name */
    private final String f16578h;

    /* loaded from: classes3.dex */
    public enum Kind {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);
        
        @d
        public static final a Companion = new a(null);
        @d
        private static final Map<Integer, Kind> entryById;
        private final int id;

        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(u uVar) {
                this();
            }

            @k
            @d
            public final Kind a(int i2) {
                Kind kind = (Kind) Kind.entryById.get(Integer.valueOf(i2));
                return kind == null ? Kind.UNKNOWN : kind;
            }
        }

        static {
            Kind[] values = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(q.n(s0.j(values.length), 16));
            for (Kind kind : values) {
                linkedHashMap.put(Integer.valueOf(kind.getId()), kind);
            }
            entryById = linkedHashMap;
        }

        Kind(int i2) {
            this.id = i2;
        }

        @k
        @d
        public static final Kind getById(int i2) {
            return Companion.a(i2);
        }

        public final int getId() {
            return this.id;
        }
    }

    public KotlinClassHeader(@d Kind kind, @d e eVar, @k.e.a.e String[] strArr, @k.e.a.e String[] strArr2, @k.e.a.e String[] strArr3, @k.e.a.e String str, int i2, @k.e.a.e String str2) {
        this.a = kind;
        this.b = eVar;
        this.f16573c = strArr;
        this.f16574d = strArr2;
        this.f16575e = strArr3;
        this.f16576f = str;
        this.f16577g = i2;
        this.f16578h = str2;
    }

    private final boolean h(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    @k.e.a.e
    public final String[] a() {
        return this.f16573c;
    }

    @k.e.a.e
    public final String[] b() {
        return this.f16574d;
    }

    @d
    public final Kind c() {
        return this.a;
    }

    @d
    public final e d() {
        return this.b;
    }

    @k.e.a.e
    public final String e() {
        String str = this.f16576f;
        if (c() == Kind.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    @d
    public final List<String> f() {
        String[] strArr = this.f16573c;
        if (!(c() == Kind.MULTIFILE_CLASS)) {
            strArr = null;
        }
        List<String> t = strArr != null ? n.t(strArr) : null;
        return t != null ? t : CollectionsKt__CollectionsKt.E();
    }

    @k.e.a.e
    public final String[] g() {
        return this.f16575e;
    }

    public final boolean i() {
        return h(this.f16577g, 2);
    }

    public final boolean j() {
        return h(this.f16577g, 64) && !h(this.f16577g, 32);
    }

    public final boolean k() {
        return h(this.f16577g, 16) && !h(this.f16577g, 32);
    }

    @d
    public String toString() {
        return this.a + " version=" + this.b;
    }
}
