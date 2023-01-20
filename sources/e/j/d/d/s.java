package e.j.d.d;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes2.dex */
public final class s extends e.j.d.d.a {
    private final Set<Class<?>> a;
    private final Set<Class<?>> b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Class<?>> f11223c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<Class<?>> f11224d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<Class<?>> f11225e;

    /* renamed from: f  reason: collision with root package name */
    private final f f11226f;

    /* loaded from: classes2.dex */
    public static class a implements e.j.d.e.c {
        private final Set<Class<?>> a;
        private final e.j.d.e.c b;

        public a(Set<Class<?>> set, e.j.d.e.c cVar) {
            this.a = set;
            this.b = cVar;
        }

        @Override // e.j.d.e.c
        public void c(e.j.d.e.a<?> aVar) {
            if (this.a.contains(aVar.getType())) {
                this.b.c(aVar);
                return;
            }
            throw new IllegalArgumentException(String.format("Attempting to publish an undeclared event %s.", aVar));
        }
    }

    public s(e<?> eVar, f fVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        for (o oVar : eVar.c()) {
            if (oVar.b()) {
                if (oVar.d()) {
                    hashSet3.add(oVar.a());
                } else {
                    hashSet.add(oVar.a());
                }
            } else if (oVar.d()) {
                hashSet4.add(oVar.a());
            } else {
                hashSet2.add(oVar.a());
            }
        }
        if (!eVar.f().isEmpty()) {
            hashSet.add(e.j.d.e.c.class);
        }
        this.a = Collections.unmodifiableSet(hashSet);
        this.b = Collections.unmodifiableSet(hashSet2);
        this.f11223c = Collections.unmodifiableSet(hashSet3);
        this.f11224d = Collections.unmodifiableSet(hashSet4);
        this.f11225e = eVar.f();
        this.f11226f = fVar;
    }

    @Override // e.j.d.d.a, e.j.d.d.f
    public <T> T a(Class<T> cls) {
        if (this.a.contains(cls)) {
            T t = (T) this.f11226f.a(cls);
            return !cls.equals(e.j.d.e.c.class) ? t : (T) new a(this.f11225e, (e.j.d.e.c) t);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency %s.", cls));
    }

    @Override // e.j.d.d.f
    public <T> e.j.d.g.a<Set<T>> b(Class<T> cls) {
        if (this.f11224d.contains(cls)) {
            return this.f11226f.b(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", cls));
    }

    @Override // e.j.d.d.a, e.j.d.d.f
    public <T> Set<T> c(Class<T> cls) {
        if (this.f11223c.contains(cls)) {
            return this.f11226f.c(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Set<%s>.", cls));
    }

    @Override // e.j.d.d.f
    public <T> e.j.d.g.a<T> d(Class<T> cls) {
        if (this.b.contains(cls)) {
            return this.f11226f.d(cls);
        }
        throw new IllegalArgumentException(String.format("Attempting to request an undeclared dependency Provider<%s>.", cls));
    }
}
