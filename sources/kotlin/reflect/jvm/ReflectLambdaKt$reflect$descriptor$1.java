package kotlin.reflect.jvm;

import h.k2.u.p;
import h.p2.b0.g.t.c.n0;
import h.p2.h;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReference;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/SimpleFunctionDescriptor;", "R", "p1", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "p2", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Function;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final /* synthetic */ class ReflectLambdaKt$reflect$descriptor$1 extends FunctionReference implements p<MemberDeserializer, ProtoBuf.Function, n0> {
    public static final ReflectLambdaKt$reflect$descriptor$1 INSTANCE = new ReflectLambdaKt$reflect$descriptor$1();

    public ReflectLambdaKt$reflect$descriptor$1() {
        super(2);
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    public final String getName() {
        return "loadFunction";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final h getOwner() {
        return h.k2.v.n0.d(MemberDeserializer.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
    }

    @Override // h.k2.u.p
    @d
    public final n0 invoke(@d MemberDeserializer memberDeserializer, @d ProtoBuf.Function function) {
        return memberDeserializer.n(function);
    }
}
