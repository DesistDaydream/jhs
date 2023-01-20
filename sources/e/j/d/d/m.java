package e.j.d.d;

import com.google.firebase.components.MissingDependencyException;
import e.j.a.b.c.r.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class m extends a {

    /* renamed from: e  reason: collision with root package name */
    private static final e.j.d.g.a<Set<Object>> f11216e = l.a();
    private final Map<e<?>, r<?>> a = new HashMap();
    private final Map<Class<?>, r<?>> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, r<Set<?>>> f11217c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final q f11218d;

    public m(Executor executor, Iterable<i> iterable, e<?>... eVarArr) {
        q qVar = new q(executor);
        this.f11218d = qVar;
        ArrayList<e<?>> arrayList = new ArrayList();
        arrayList.add(e.q(qVar, q.class, e.j.d.e.d.class, e.j.d.e.c.class));
        for (i iVar : iterable) {
            arrayList.addAll(iVar.getComponents());
        }
        Collections.addAll(arrayList, eVarArr);
        n.a(arrayList);
        for (e<?> eVar : arrayList) {
            this.a.put(eVar, new r<>((e.j.d.g.a<?>) j.a(this, eVar)));
        }
        h();
        i();
    }

    public static /* synthetic */ Set g(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((r) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private void h() {
        for (Map.Entry<e<?>, r<?>> entry : this.a.entrySet()) {
            e<?> key = entry.getKey();
            if (key.l()) {
                r<?> value = entry.getValue();
                for (Class<? super Object> cls : key.e()) {
                    this.b.put(cls, value);
                }
            }
        }
        j();
    }

    private void i() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<e<?>, r<?>> entry : this.a.entrySet()) {
            e<?> key = entry.getKey();
            if (!key.l()) {
                r<?> value = entry.getValue();
                for (Class<? super Object> cls : key.e()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            this.f11217c.put((Class) entry2.getKey(), new r<>(k.a((Set) entry2.getValue())));
        }
    }

    private void j() {
        for (e<?> eVar : this.a.keySet()) {
            for (o oVar : eVar.c()) {
                if (oVar.c() && !this.b.containsKey(oVar.a())) {
                    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", eVar, oVar.a()));
                }
            }
        }
    }

    @Override // e.j.d.d.a, e.j.d.d.f
    public /* bridge */ /* synthetic */ Object a(Class cls) {
        return super.a(cls);
    }

    @Override // e.j.d.d.f
    public <T> e.j.d.g.a<Set<T>> b(Class<T> cls) {
        r<Set<?>> rVar = this.f11217c.get(cls);
        return rVar != null ? rVar : (e.j.d.g.a<Set<T>>) f11216e;
    }

    @Override // e.j.d.d.a, e.j.d.d.f
    public /* bridge */ /* synthetic */ Set c(Class cls) {
        return super.c(cls);
    }

    @Override // e.j.d.d.f
    public <T> e.j.d.g.a<T> d(Class<T> cls) {
        a0.l(cls, "Null interface requested.");
        return this.b.get(cls);
    }

    public void e(boolean z) {
        for (Map.Entry<e<?>, r<?>> entry : this.a.entrySet()) {
            e<?> key = entry.getKey();
            r<?> value = entry.getValue();
            if (key.i() || (key.j() && z)) {
                value.get();
            }
        }
        this.f11218d.e();
    }
}
