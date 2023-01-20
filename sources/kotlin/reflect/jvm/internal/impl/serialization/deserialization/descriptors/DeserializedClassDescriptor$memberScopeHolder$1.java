package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.l;
import h.k2.v.n0;
import h.p2.b0.g.t.n.e1.h;
import k.e.a.d;
import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor;

/* loaded from: classes3.dex */
public /* synthetic */ class DeserializedClassDescriptor$memberScopeHolder$1 extends FunctionReference implements l<h, DeserializedClassDescriptor.DeserializedClassMemberScope> {
    public DeserializedClassDescriptor$memberScopeHolder$1(DeserializedClassDescriptor deserializedClassDescriptor) {
        super(1, deserializedClassDescriptor);
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    @d
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final h.p2.h getOwner() {
        return n0.d(DeserializedClassDescriptor.DeserializedClassMemberScope.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final String getSignature() {
        return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
    }

    @Override // h.k2.u.l
    @d
    public final DeserializedClassDescriptor.DeserializedClassMemberScope invoke(@d h hVar) {
        return new DeserializedClassDescriptor.DeserializedClassMemberScope(hVar);
    }
}
