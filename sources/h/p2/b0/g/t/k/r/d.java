package h.p2.b0.g.t.k.r;

import h.k2.v.f0;
import h.k2.v.u;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes3.dex */
public final class d {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final a f15480c;

    /* renamed from: d  reason: collision with root package name */
    private static int f15481d;

    /* renamed from: e  reason: collision with root package name */
    private static final int f15482e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f15483f;

    /* renamed from: g  reason: collision with root package name */
    private static final int f15484g;

    /* renamed from: h  reason: collision with root package name */
    private static final int f15485h;

    /* renamed from: i  reason: collision with root package name */
    private static final int f15486i;

    /* renamed from: j  reason: collision with root package name */
    private static final int f15487j;

    /* renamed from: k  reason: collision with root package name */
    private static final int f15488k;

    /* renamed from: l  reason: collision with root package name */
    private static final int f15489l;

    /* renamed from: m  reason: collision with root package name */
    private static final int f15490m;
    private static final int n;
    @h.k2.d
    @k.e.a.d
    public static final d o;
    @h.k2.d
    @k.e.a.d
    public static final d p;
    @h.k2.d
    @k.e.a.d
    public static final d q;
    @h.k2.d
    @k.e.a.d
    public static final d r;
    @h.k2.d
    @k.e.a.d
    public static final d s;
    @h.k2.d
    @k.e.a.d
    public static final d t;
    @h.k2.d
    @k.e.a.d
    public static final d u;
    @h.k2.d
    @k.e.a.d
    public static final d v;
    @h.k2.d
    @k.e.a.d
    public static final d w;
    @h.k2.d
    @k.e.a.d
    public static final d x;
    @k.e.a.d
    private static final List<a.C0465a> y;
    @k.e.a.d
    private static final List<a.C0465a> z;
    @k.e.a.d
    private final List<c> a;
    private final int b;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: h.p2.b0.g.t.k.r.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0465a {
            private final int a;
            @k.e.a.d
            private final String b;

            public C0465a(int i2, @k.e.a.d String str) {
                this.a = i2;
                this.b = str;
            }

            public final int a() {
                return this.a;
            }

            @k.e.a.d
            public final String b() {
                return this.b;
            }
        }

        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int j() {
            int i2 = d.f15481d;
            a aVar = d.f15480c;
            d.f15481d <<= 1;
            return i2;
        }

        public final int b() {
            return d.f15488k;
        }

        public final int c() {
            return d.f15489l;
        }

        public final int d() {
            return d.f15486i;
        }

        public final int e() {
            return d.f15482e;
        }

        public final int f() {
            return d.f15485h;
        }

        public final int g() {
            return d.f15483f;
        }

        public final int h() {
            return d.f15484g;
        }

        public final int i() {
            return d.f15487j;
        }
    }

    static {
        a aVar = new a(null);
        f15480c = aVar;
        f15481d = 1;
        int j2 = aVar.j();
        f15482e = j2;
        int j3 = aVar.j();
        f15483f = j3;
        int j4 = aVar.j();
        f15484g = j4;
        int j5 = aVar.j();
        f15485h = j5;
        int j6 = aVar.j();
        f15486i = j6;
        int j7 = aVar.j();
        f15487j = j7;
        int j8 = aVar.j() - 1;
        f15488k = j8;
        int i2 = j2 | j3 | j4;
        f15489l = i2;
        int i3 = j3 | j6 | j7;
        f15490m = i3;
        int i4 = j6 | j7;
        n = i4;
        o = new d(j8, null, 2, null);
        p = new d(i4, null, 2, null);
        q = new d(j2, null, 2, null);
        r = new d(j3, null, 2, null);
        s = new d(j4, null, 2, null);
        t = new d(i2, null, 2, null);
        u = new d(j5, null, 2, null);
        v = new d(j6, null, 2, null);
        w = new d(j7, null, 2, null);
        x = new d(i3, null, 2, null);
        Field[] fields = d.class.getFields();
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            d dVar = obj instanceof d ? (d) obj : null;
            a.C0465a c0465a = dVar != null ? new a.C0465a(dVar.m(), field2.getName()) : null;
            if (c0465a != null) {
                arrayList2.add(c0465a);
            }
        }
        y = arrayList2;
        Field[] fields2 = d.class.getFields();
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (f0.g(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            a.C0465a c0465a2 = intValue == ((-intValue) & intValue) ? new a.C0465a(intValue, field4.getName()) : null;
            if (c0465a2 != null) {
                arrayList5.add(c0465a2);
            }
        }
        z = arrayList5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(int i2, @k.e.a.d List<? extends c> list) {
        this.a = list;
        for (c cVar : list) {
            i2 &= ~cVar.a();
        }
        this.b = i2;
    }

    public final boolean a(int i2) {
        return (i2 & this.b) != 0;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(d.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
            d dVar = (d) obj;
            return f0.g(this.a, dVar.a) && this.b == dVar.b;
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b;
    }

    @k.e.a.d
    public final List<c> l() {
        return this.a;
    }

    public final int m() {
        return this.b;
    }

    @k.e.a.e
    public final d n(int i2) {
        int i3 = i2 & this.b;
        if (i3 == 0) {
            return null;
        }
        return new d(i3, this.a);
    }

    @k.e.a.d
    public String toString() {
        Object obj;
        boolean z2;
        Iterator<T> it = y.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((a.C0465a) obj).a() == m()) {
                z2 = true;
                continue;
            } else {
                z2 = false;
                continue;
            }
            if (z2) {
                break;
            }
        }
        a.C0465a c0465a = (a.C0465a) obj;
        String b = c0465a == null ? null : c0465a.b();
        if (b == null) {
            List<a.C0465a> list = z;
            ArrayList arrayList = new ArrayList();
            for (a.C0465a c0465a2 : list) {
                String b2 = a(c0465a2.a()) ? c0465a2.b() : null;
                if (b2 != null) {
                    arrayList.add(b2);
                }
            }
            b = CollectionsKt___CollectionsKt.Z2(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + b + ", " + this.a + ')';
    }

    public /* synthetic */ d(int i2, List list, int i3, u uVar) {
        this(i2, (i3 & 2) != 0 ? CollectionsKt__CollectionsKt.E() : list);
    }
}
