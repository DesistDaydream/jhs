package h.p2.b0.g.t.c.b1;

import h.k2.v.f0;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes3.dex */
public interface e extends Iterable<c>, h.k2.v.x0.a {
    @k.e.a.d
    public static final a w0 = a.a;

    /* loaded from: classes3.dex */
    public static final class a {
        public static final /* synthetic */ a a = new a();
        @k.e.a.d
        private static final e b = new C0435a();

        /* renamed from: h.p2.b0.g.t.c.b1.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0435a implements e {
            @k.e.a.e
            public Void a(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
                return null;
            }

            @Override // h.p2.b0.g.t.c.b1.e
            public /* bridge */ /* synthetic */ c c(h.p2.b0.g.t.g.c cVar) {
                return (c) a(cVar);
            }

            @Override // h.p2.b0.g.t.c.b1.e
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            @k.e.a.d
            public Iterator<c> iterator() {
                return CollectionsKt__CollectionsKt.E().iterator();
            }

            @Override // h.p2.b0.g.t.c.b1.e
            public boolean n(@k.e.a.d h.p2.b0.g.t.g.c cVar) {
                return b.b(this, cVar);
            }

            @k.e.a.d
            public String toString() {
                return "EMPTY";
            }
        }

        private a() {
        }

        @k.e.a.d
        public final e a(@k.e.a.d List<? extends c> list) {
            return list.isEmpty() ? b : new f(list);
        }

        @k.e.a.d
        public final e b() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        @k.e.a.e
        public static c a(@k.e.a.d e eVar, @k.e.a.d h.p2.b0.g.t.g.c cVar) {
            c cVar2;
            Iterator<c> it = eVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar2 = null;
                    break;
                }
                cVar2 = it.next();
                if (f0.g(cVar2.e(), cVar)) {
                    break;
                }
            }
            return cVar2;
        }

        public static boolean b(@k.e.a.d e eVar, @k.e.a.d h.p2.b0.g.t.g.c cVar) {
            return eVar.c(cVar) != null;
        }
    }

    @k.e.a.e
    c c(@k.e.a.d h.p2.b0.g.t.g.c cVar);

    boolean isEmpty();

    boolean n(@k.e.a.d h.p2.b0.g.t.g.c cVar);
}
