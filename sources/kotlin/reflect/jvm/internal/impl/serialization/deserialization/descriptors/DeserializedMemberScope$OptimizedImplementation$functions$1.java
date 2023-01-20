package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.l;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.g.f;
import java.util.Collection;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* loaded from: classes3.dex */
public final class DeserializedMemberScope$OptimizedImplementation$functions$1 extends Lambda implements l<f, Collection<? extends n0>> {
    public final /* synthetic */ DeserializedMemberScope.OptimizedImplementation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$OptimizedImplementation$functions$1(DeserializedMemberScope.OptimizedImplementation optimizedImplementation) {
        super(1);
        this.this$0 = optimizedImplementation;
    }

    @Override // h.k2.u.l
    @d
    public final Collection<n0> invoke(@d f fVar) {
        Collection<n0> m2;
        m2 = this.this$0.m(fVar);
        return m2;
    }
}
