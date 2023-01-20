package h.p2.b0.g.t.e.a.v;

import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.e.a.n;
import h.p2.b0.g.t.m.m;
import h.w;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver;

/* loaded from: classes3.dex */
public final class e {
    @k.e.a.d
    private final b a;
    @k.e.a.d
    private final h b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final w<n> f15286c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final w f15287d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final JavaTypeResolver f15288e;

    public e(@k.e.a.d b bVar, @k.e.a.d h hVar, @k.e.a.d w<n> wVar) {
        this.a = bVar;
        this.b = hVar;
        this.f15286c = wVar;
        this.f15287d = wVar;
        this.f15288e = new JavaTypeResolver(this, hVar);
    }

    @k.e.a.d
    public final b a() {
        return this.a;
    }

    @k.e.a.e
    public final n b() {
        return (n) this.f15287d.getValue();
    }

    @k.e.a.d
    public final w<n> c() {
        return this.f15286c;
    }

    @k.e.a.d
    public final z d() {
        return this.a.m();
    }

    @k.e.a.d
    public final m e() {
        return this.a.u();
    }

    @k.e.a.d
    public final h f() {
        return this.b;
    }

    @k.e.a.d
    public final JavaTypeResolver g() {
        return this.f15288e;
    }
}
