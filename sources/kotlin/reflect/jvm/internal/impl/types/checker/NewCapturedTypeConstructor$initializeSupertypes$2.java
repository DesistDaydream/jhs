package kotlin.reflect.jvm.internal.impl.types.checker;

import h.k2.u.a;
import h.p2.b0.g.t.n.c1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class NewCapturedTypeConstructor$initializeSupertypes$2 extends Lambda implements a<List<? extends c1>> {
    public final /* synthetic */ List<c1> $supertypes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NewCapturedTypeConstructor$initializeSupertypes$2(List<? extends c1> list) {
        super(0);
        this.$supertypes = list;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends c1> invoke() {
        return this.$supertypes;
    }
}
