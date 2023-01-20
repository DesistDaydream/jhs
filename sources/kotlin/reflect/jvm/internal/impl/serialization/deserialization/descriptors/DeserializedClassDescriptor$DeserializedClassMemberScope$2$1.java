package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.g.f;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$DeserializedClassMemberScope$2$1 extends Lambda implements a<List<? extends f>> {
    public final /* synthetic */ List<f> $it;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$DeserializedClassMemberScope$2$1(List<f> list) {
        super(0);
        this.$it = list;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends f> invoke() {
        return this.$it;
    }
}
