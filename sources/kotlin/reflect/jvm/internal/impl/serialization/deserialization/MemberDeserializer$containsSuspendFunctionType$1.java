package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.k2.v.n0;
import h.p2.b0.g.t.n.z;
import h.p2.h;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1;

/* loaded from: classes3.dex */
public /* synthetic */ class MemberDeserializer$containsSuspendFunctionType$1 extends PropertyReference1 {
    public static final MemberDeserializer$containsSuspendFunctionType$1 INSTANCE = new MemberDeserializer$containsSuspendFunctionType$1();

    @Override // h.p2.p
    @e
    public Object get(@e Object obj) {
        return Boolean.valueOf(h.p2.b0.g.t.b.e.o((z) obj));
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    @d
    public String getName() {
        return "isSuspendFunctionType";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public h getOwner() {
        return n0.h(h.p2.b0.g.t.b.e.class, "deserialization");
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public String getSignature() {
        return "isSuspendFunctionType(Lorg/jetbrains/kotlin/types/KotlinType;)Z";
    }
}
