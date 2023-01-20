package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.g.f;
import java.util.Collection;
import java.util.Set;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class DeserializedMemberScope$classNames$2 extends Lambda implements a<Set<? extends f>> {
    public final /* synthetic */ a<Collection<f>> $classNames;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DeserializedMemberScope$classNames$2(a<? extends Collection<f>> aVar) {
        super(0);
        this.$classNames = aVar;
    }

    @Override // h.k2.u.a
    @d
    public final Set<? extends f> invoke() {
        return CollectionsKt___CollectionsKt.N5(this.$classNames.invoke());
    }
}
