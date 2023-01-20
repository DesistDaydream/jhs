package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.k2.u.l;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2 extends Lambda implements l<ProtoBuf.Type, Integer> {
    public static final TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2 INSTANCE = new TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2();

    public TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2() {
        super(1);
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final int invoke2(@d ProtoBuf.Type type) {
        return type.getArgumentCount();
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Integer invoke(ProtoBuf.Type type) {
        return Integer.valueOf(invoke2(type));
    }
}
