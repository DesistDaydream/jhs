package h.p2.b0.g.t.c.b1;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.CompositeAnnotations;

/* loaded from: classes3.dex */
public final class g {
    @k.e.a.d
    public static final e a(@k.e.a.d e eVar, @k.e.a.d e eVar2) {
        return eVar.isEmpty() ? eVar2 : eVar2.isEmpty() ? eVar : new CompositeAnnotations(eVar, eVar2);
    }
}
