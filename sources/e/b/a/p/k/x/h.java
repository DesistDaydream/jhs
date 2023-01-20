package e.b.a.p.k.x;

import androidx.annotation.Nullable;
import e.b.a.p.k.x.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class h<K extends m, V> {
    private final a<K, V> a = new a<>();
    private final Map<K, a<K, V>> b = new HashMap();

    /* loaded from: classes.dex */
    public static class a<K, V> {
        public final K a;
        private List<V> b;

        /* renamed from: c  reason: collision with root package name */
        public a<K, V> f9607c;

        /* renamed from: d  reason: collision with root package name */
        public a<K, V> f9608d;

        public a() {
            this(null);
        }

        public void a(V v) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(v);
        }

        @Nullable
        public V b() {
            int c2 = c();
            if (c2 > 0) {
                return this.b.remove(c2 - 1);
            }
            return null;
        }

        public int c() {
            List<V> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public a(K k2) {
            this.f9608d = this;
            this.f9607c = this;
            this.a = k2;
        }
    }

    private void b(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.a;
        aVar.f9608d = aVar2;
        aVar.f9607c = aVar2.f9607c;
        g(aVar);
    }

    private void c(a<K, V> aVar) {
        e(aVar);
        a<K, V> aVar2 = this.a;
        aVar.f9608d = aVar2.f9608d;
        aVar.f9607c = aVar2;
        g(aVar);
    }

    private static <K, V> void e(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f9608d;
        aVar2.f9607c = aVar.f9607c;
        aVar.f9607c.f9608d = aVar2;
    }

    private static <K, V> void g(a<K, V> aVar) {
        aVar.f9607c.f9608d = aVar;
        aVar.f9608d.f9607c = aVar;
    }

    @Nullable
    public V a(K k2) {
        a<K, V> aVar = this.b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            this.b.put(k2, aVar);
        } else {
            k2.a();
        }
        b(aVar);
        return aVar.b();
    }

    public void d(K k2, V v) {
        a<K, V> aVar = this.b.get(k2);
        if (aVar == null) {
            aVar = new a<>(k2);
            c(aVar);
            this.b.put(k2, aVar);
        } else {
            k2.a();
        }
        aVar.a(v);
    }

    @Nullable
    public V f() {
        for (a aVar = this.a.f9608d; !aVar.equals(this.a); aVar = aVar.f9608d) {
            V v = (V) aVar.b();
            if (v != null) {
                return v;
            }
            e(aVar);
            this.b.remove(aVar.a);
            ((m) aVar.a).a();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.a.f9607c; !aVar.equals(this.a); aVar = aVar.f9607c) {
            z = true;
            sb.append('{');
            sb.append(aVar.a);
            sb.append(':');
            sb.append(aVar.c());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }
}
