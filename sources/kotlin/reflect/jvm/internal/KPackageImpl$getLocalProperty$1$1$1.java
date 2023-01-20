package kotlin.reflect.jvm.internal;

import h.k2.u.p;
import h.k2.v.n0;
import h.p2.b0.g.t.c.j0;
import h.p2.h;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "p1", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "p2", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Property;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final /* synthetic */ class KPackageImpl$getLocalProperty$1$1$1 extends FunctionReference implements p<MemberDeserializer, ProtoBuf.Property, j0> {
    public static final KPackageImpl$getLocalProperty$1$1$1 INSTANCE = new KPackageImpl$getLocalProperty$1$1$1();

    public KPackageImpl$getLocalProperty$1$1$1() {
        super(2);
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    public final String getName() {
        return "loadProperty";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final h getOwner() {
        return n0.d(MemberDeserializer.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
    }

    @Override // h.k2.u.p
    @d
    public final j0 invoke(@d MemberDeserializer memberDeserializer, @d ProtoBuf.Property property) {
        return memberDeserializer.p(property);
    }
}
