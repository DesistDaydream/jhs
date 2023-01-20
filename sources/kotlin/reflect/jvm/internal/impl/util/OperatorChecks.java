package kotlin.reflect.jvm.internal.impl.util;

import h.k2.u.l;
import h.k2.v.u;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.o.a;
import h.p2.b0.g.t.o.b;
import h.p2.b0.g.t.o.e;
import h.p2.b0.g.t.o.g;
import h.p2.b0.g.t.o.h;
import h.p2.b0.g.t.o.i;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;

/* loaded from: classes3.dex */
public final class OperatorChecks extends a {
    @d
    public static final OperatorChecks a = new OperatorChecks();
    @d
    private static final List<Checks> b;

    static {
        f fVar = h.f15627j;
        e.b bVar = e.b.b;
        b[] bVarArr = {bVar, new i.a(1)};
        f fVar2 = h.f15628k;
        b[] bVarArr2 = {bVar, new i.a(2)};
        f fVar3 = h.b;
        g gVar = g.a;
        h.p2.b0.g.t.o.d dVar = h.p2.b0.g.t.o.d.a;
        f fVar4 = h.f15624g;
        i.d dVar2 = i.d.b;
        ReturnsCheck.ReturnsBoolean returnsBoolean = ReturnsCheck.ReturnsBoolean.f16881d;
        f fVar5 = h.f15626i;
        i.c cVar = i.c.b;
        b = CollectionsKt__CollectionsKt.L(new Checks(fVar, bVarArr, (l) null, 4, (u) null), new Checks(fVar2, bVarArr2, OperatorChecks$checks$1.INSTANCE), new Checks(fVar3, new b[]{bVar, gVar, new i.a(2), dVar}, (l) null, 4, (u) null), new Checks(h.f15620c, new b[]{bVar, gVar, new i.a(3), dVar}, (l) null, 4, (u) null), new Checks(h.f15621d, new b[]{bVar, gVar, new i.b(2), dVar}, (l) null, 4, (u) null), new Checks(h.f15625h, new b[]{bVar}, (l) null, 4, (u) null), new Checks(fVar4, new b[]{bVar, dVar2, gVar, returnsBoolean}, (l) null, 4, (u) null), new Checks(fVar5, new b[]{bVar, cVar}, (l) null, 4, (u) null), new Checks(h.f15629l, new b[]{bVar, cVar}, (l) null, 4, (u) null), new Checks(h.f15630m, new b[]{bVar, cVar, returnsBoolean}, (l) null, 4, (u) null), new Checks(h.H, new b[]{bVar, dVar2, gVar}, (l) null, 4, (u) null), new Checks(h.f15622e, new b[]{e.a.b}, OperatorChecks$checks$2.INSTANCE), new Checks(h.f15623f, new b[]{bVar, ReturnsCheck.ReturnsInt.f16882d, dVar2, gVar}, (l) null, 4, (u) null), new Checks(h.Q, new b[]{bVar, dVar2, gVar}, (l) null, 4, (u) null), new Checks(h.P, new b[]{bVar, cVar}, (l) null, 4, (u) null), new Checks(CollectionsKt__CollectionsKt.L(h.w, h.x), new b[]{bVar}, OperatorChecks$checks$3.INSTANCE), new Checks(h.R, new b[]{bVar, ReturnsCheck.ReturnsUnit.f16883d, dVar2, gVar}, (l) null, 4, (u) null), new Checks(h.o, new b[]{bVar, cVar}, (l) null, 4, (u) null));
    }

    private OperatorChecks() {
    }

    @Override // h.p2.b0.g.t.o.a
    @d
    public List<Checks> b() {
        return b;
    }
}
