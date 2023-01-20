package e.j.d.d;

import com.google.firebase.components.DependencyCycleException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public class n {

    /* loaded from: classes2.dex */
    public static class b {
        private final e<?> a;
        private final Set<b> b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set<b> f11219c = new HashSet();

        public b(e<?> eVar) {
            this.a = eVar;
        }

        public void a(b bVar) {
            this.b.add(bVar);
        }

        public void b(b bVar) {
            this.f11219c.add(bVar);
        }

        public e<?> c() {
            return this.a;
        }

        public Set<b> d() {
            return this.b;
        }

        public boolean e() {
            return this.b.isEmpty();
        }

        public boolean f() {
            return this.f11219c.isEmpty();
        }

        public void g(b bVar) {
            this.f11219c.remove(bVar);
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        private final Class<?> a;
        private final boolean b;

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return cVar.a.equals(this.a) && cVar.b == this.b;
            }
            return false;
        }

        public int hashCode() {
            return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.b).hashCode();
        }

        private c(Class<?> cls, boolean z) {
            this.a = cls;
            this.b = z;
        }
    }

    public static void a(List<e<?>> list) {
        Set<b> c2 = c(list);
        Set<b> b2 = b(c2);
        int i2 = 0;
        while (!b2.isEmpty()) {
            b next = b2.iterator().next();
            b2.remove(next);
            i2++;
            for (b bVar : next.d()) {
                bVar.g(next);
                if (bVar.f()) {
                    b2.add(bVar);
                }
            }
        }
        if (i2 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : c2) {
            if (!bVar2.f() && !bVar2.e()) {
                arrayList.add(bVar2.c());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    private static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    private static Set<b> c(List<e<?>> list) {
        Set<b> set;
        HashMap hashMap = new HashMap(list.size());
        for (e<?> eVar : list) {
            b bVar = new b(eVar);
            for (Class<? super Object> cls : eVar.e()) {
                c cVar = new c(cls, !eVar.l());
                if (!hashMap.containsKey(cVar)) {
                    hashMap.put(cVar, new HashSet());
                }
                Set set2 = (Set) hashMap.get(cVar);
                if (!set2.isEmpty() && !cVar.b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(bVar);
            }
        }
        for (Set<b> set3 : hashMap.values()) {
            for (b bVar2 : set3) {
                for (o oVar : bVar2.c().c()) {
                    if (oVar.b() && (set = (Set) hashMap.get(new c(oVar.a(), oVar.d()))) != null) {
                        for (b bVar3 : set) {
                            bVar2.a(bVar3);
                            bVar3.b(bVar2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set set4 : hashMap.values()) {
            hashSet.addAll(set4);
        }
        return hashSet;
    }
}
