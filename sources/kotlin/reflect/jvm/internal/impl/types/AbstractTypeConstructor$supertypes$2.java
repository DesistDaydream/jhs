package kotlin.reflect.jvm.internal.impl.types;

import h.a2.t;
import h.k2.u.l;
import h.p2.b0.g.t.n.s;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;

/* loaded from: classes3.dex */
public final class AbstractTypeConstructor$supertypes$2 extends Lambda implements l<Boolean, AbstractTypeConstructor.a> {
    public static final AbstractTypeConstructor$supertypes$2 INSTANCE = new AbstractTypeConstructor$supertypes$2();

    public AbstractTypeConstructor$supertypes$2() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ AbstractTypeConstructor.a invoke(Boolean bool) {
        return invoke(bool.booleanValue());
    }

    @d
    public final AbstractTypeConstructor.a invoke(boolean z) {
        return new AbstractTypeConstructor.a(t.k(s.f15604c));
    }
}
