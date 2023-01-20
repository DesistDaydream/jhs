package h.p2.b0.g.t.e.a.v.i;

import h.a2.t;
import h.a2.u;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.e.a.v.e;
import h.p2.b0.g.t.e.a.x.j;
import h.p2.b0.g.t.e.a.x.y;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public final class d extends h.p2.b0.g.t.c.d1.b {
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    private final e f15289k;
    @k.e.a.d

    /* renamed from: l  reason: collision with root package name */
    private final y f15290l;

    public d(@k.e.a.d e eVar, @k.e.a.d y yVar, int i2, @k.e.a.d k kVar) {
        super(eVar.e(), kVar, new LazyJavaAnnotations(eVar, yVar, false, 4, null), yVar.getName(), Variance.INVARIANT, false, i2, o0.a, eVar.a().v());
        this.f15289k = eVar;
        this.f15290l = yVar;
    }

    private final List<z> I0() {
        Collection<j> upperBounds = this.f15290l.getUpperBounds();
        if (upperBounds.isEmpty()) {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            return t.k(KotlinTypeFactory.d(this.f15289k.d().k().i(), this.f15289k.d().k().I()));
        }
        ArrayList arrayList = new ArrayList(u.Y(upperBounds, 10));
        for (j jVar : upperBounds) {
            arrayList.add(this.f15289k.g().n(jVar, JavaTypeResolverKt.f(TypeUsage.COMMON, false, this, 1, null)));
        }
        return arrayList;
    }

    @Override // h.p2.b0.g.t.c.d1.d
    @k.e.a.d
    public List<z> C0(@k.e.a.d List<? extends z> list) {
        return this.f15289k.a().r().g(this, list, this.f15289k);
    }

    @Override // h.p2.b0.g.t.c.d1.d
    public void G0(@k.e.a.d z zVar) {
    }

    @Override // h.p2.b0.g.t.c.d1.d
    @k.e.a.d
    public List<z> H0() {
        return I0();
    }
}
