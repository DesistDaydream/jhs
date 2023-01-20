package h.p2.b0.g.t.e.a.y;

import androidx.exifinterface.media.ExifInterface;
import h.a2.i0;
import h.a2.s0;
import h.a2.u;
import h.o2.q;
import h.t1;
import h.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes3.dex */
public final class i {
    @k.e.a.d
    private final Map<String, h> a = new LinkedHashMap();

    /* loaded from: classes3.dex */
    public final class a {
        @k.e.a.d
        private final String a;

        /* renamed from: h.p2.b0.g.t.e.a.y.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0446a {
            @k.e.a.d
            private final String a;
            @k.e.a.d
            private final List<Pair<String, n>> b = new ArrayList();
            @k.e.a.d

            /* renamed from: c  reason: collision with root package name */
            private Pair<String, n> f15299c = z0.a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);

            public C0446a(@k.e.a.d String str) {
                this.a = str;
            }

            @k.e.a.d
            public final Pair<String, h> a() {
                SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.a;
                String b = a.this.b();
                String b2 = b();
                List<Pair<String, n>> list = this.b;
                ArrayList arrayList = new ArrayList(u.Y(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Pair) it.next()).getFirst());
                }
                String k2 = signatureBuildingComponents.k(b, signatureBuildingComponents.j(b2, arrayList, this.f15299c.getFirst()));
                n second = this.f15299c.getSecond();
                List<Pair<String, n>> list2 = this.b;
                ArrayList arrayList2 = new ArrayList(u.Y(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((n) ((Pair) it2.next()).getSecond());
                }
                return z0.a(k2, new h(second, arrayList2));
            }

            @k.e.a.d
            public final String b() {
                return this.a;
            }

            public final void c(@k.e.a.d String str, @k.e.a.d e... eVarArr) {
                n nVar;
                List<Pair<String, n>> list = this.b;
                if (eVarArr.length == 0) {
                    nVar = null;
                } else {
                    Iterable<i0> Zy = ArraysKt___ArraysKt.Zy(eVarArr);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(q.n(s0.j(u.Y(Zy, 10)), 16));
                    for (i0 i0Var : Zy) {
                        linkedHashMap.put(Integer.valueOf(i0Var.e()), (e) i0Var.f());
                    }
                    nVar = new n(linkedHashMap);
                }
                list.add(z0.a(str, nVar));
            }

            public final void d(@k.e.a.d String str, @k.e.a.d e... eVarArr) {
                Iterable<i0> Zy = ArraysKt___ArraysKt.Zy(eVarArr);
                LinkedHashMap linkedHashMap = new LinkedHashMap(q.n(s0.j(u.Y(Zy, 10)), 16));
                for (i0 i0Var : Zy) {
                    linkedHashMap.put(Integer.valueOf(i0Var.e()), (e) i0Var.f());
                }
                this.f15299c = z0.a(str, new n(linkedHashMap));
            }

            public final void e(@k.e.a.d JvmPrimitiveType jvmPrimitiveType) {
                this.f15299c = z0.a(jvmPrimitiveType.getDesc(), null);
            }
        }

        public a(@k.e.a.d String str) {
            this.a = str;
        }

        public final void a(@k.e.a.d String str, @k.e.a.d h.k2.u.l<? super C0446a, t1> lVar) {
            Map map = i.this.a;
            C0446a c0446a = new C0446a(str);
            lVar.invoke(c0446a);
            Pair<String, h> a = c0446a.a();
            map.put(a.getFirst(), a.getSecond());
        }

        @k.e.a.d
        public final String b() {
            return this.a;
        }
    }

    @k.e.a.d
    public final Map<String, h> b() {
        return this.a;
    }
}
