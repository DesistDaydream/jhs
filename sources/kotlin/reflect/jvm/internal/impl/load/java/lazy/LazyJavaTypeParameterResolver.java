package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.v.h;
import h.p2.b0.g.t.e.a.x.y;
import h.p2.b0.g.t.e.a.x.z;
import h.p2.b0.g.t.m.g;
import h.p2.b0.g.t.p.a;
import java.util.Map;
import k.e.a.d;

/* loaded from: classes3.dex */
public final class LazyJavaTypeParameterResolver implements h {
    @d
    private final e a;
    @d
    private final k b;

    /* renamed from: c  reason: collision with root package name */
    private final int f16504c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final Map<y, Integer> f16505d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final g<y, h.p2.b0.g.t.e.a.v.i.d> f16506e;

    public LazyJavaTypeParameterResolver(@d e eVar, @d k kVar, @d z zVar, int i2) {
        this.a = eVar;
        this.b = kVar;
        this.f16504c = i2;
        this.f16505d = a.d(zVar.getTypeParameters());
        this.f16506e = eVar.e().g(new LazyJavaTypeParameterResolver$resolve$1(this));
    }

    @Override // h.p2.b0.g.t.e.a.v.h
    @k.e.a.e
    public t0 a(@d y yVar) {
        h.p2.b0.g.t.e.a.v.i.d invoke = this.f16506e.invoke(yVar);
        return invoke == null ? this.a.f().a(yVar) : invoke;
    }
}
