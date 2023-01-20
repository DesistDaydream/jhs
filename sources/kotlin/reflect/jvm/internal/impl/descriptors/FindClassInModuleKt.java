package kotlin.reflect.jvm.internal.impl.descriptors;

import h.p2.b0.g.t.c.d;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.g.b;
import k.e.a.e;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes3.dex */
public final class FindClassInModuleKt {
    @e
    public static final d a(@k.e.a.d z zVar, @k.e.a.d b bVar) {
        f b = b(zVar, bVar);
        if (b instanceof d) {
            return (d) b;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0116  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final h.p2.b0.g.t.c.f b(@k.e.a.d h.p2.b0.g.t.c.z r6, @k.e.a.d h.p2.b0.g.t.g.b r7) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt.b(h.p2.b0.g.t.c.z, h.p2.b0.g.t.g.b):h.p2.b0.g.t.c.f");
    }

    @k.e.a.d
    public static final d c(@k.e.a.d z zVar, @k.e.a.d b bVar, @k.e.a.d NotFoundClasses notFoundClasses) {
        d a = a(zVar, bVar);
        return a != null ? a : notFoundClasses.d(bVar, SequencesKt___SequencesKt.V2(SequencesKt___SequencesKt.d1(SequencesKt__SequencesKt.o(bVar, FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE), FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2.INSTANCE)));
    }

    @e
    public static final s0 d(@k.e.a.d z zVar, @k.e.a.d b bVar) {
        f b = b(zVar, bVar);
        if (b instanceof s0) {
            return (s0) b;
        }
        return null;
    }
}
