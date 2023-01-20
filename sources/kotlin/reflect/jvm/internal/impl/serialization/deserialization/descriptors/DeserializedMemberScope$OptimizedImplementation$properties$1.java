package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.g.f;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* loaded from: classes3.dex */
public final class DeserializedMemberScope$OptimizedImplementation$properties$1 extends Lambda implements l<f, Collection<? extends j0>> {
    public final /* synthetic */ DeserializedMemberScope.OptimizedImplementation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$OptimizedImplementation$properties$1(DeserializedMemberScope.OptimizedImplementation optimizedImplementation) {
        super(1);
        this.this$0 = optimizedImplementation;
    }

    @Override // h.k2.u.l
    @d
    public final Collection<j0> invoke(@d f fVar) {
        Collection<j0> n;
        n = this.this$0.n(fVar);
        return n;
    }
}
