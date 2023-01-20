package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.c.t0;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;

/* loaded from: classes3.dex */
public final class DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1 extends Lambda implements a<List<? extends t0>> {
    public final /* synthetic */ DeserializedClassDescriptor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedClassDescriptor$DeserializedClassTypeConstructor$parameters$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(0);
        this.this$0 = deserializedClassDescriptor;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends t0> invoke() {
        return TypeParameterUtilsKt.d(this.this$0);
    }
}
