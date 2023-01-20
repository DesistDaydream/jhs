package kotlin.reflect.jvm.internal.impl.types.checker;

import h.k2.u.a;
import h.p2.b0.g.t.n.f0;
import java.util.Set;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1 extends Lambda implements a<String> {
    public final /* synthetic */ Set<f0> $inputTypes;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(Set<? extends f0> set) {
        super(0);
        this.$inputTypes = set;
    }

    @Override // h.k2.u.a
    @d
    public final String invoke() {
        return h.k2.v.f0.C("This collections cannot be empty! input types: ", CollectionsKt___CollectionsKt.Z2(this.$inputTypes, null, null, null, 0, null, null, 63, null));
    }
}
