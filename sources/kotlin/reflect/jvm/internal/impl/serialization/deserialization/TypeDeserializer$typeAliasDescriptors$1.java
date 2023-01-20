package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.k2.u.l;
import h.p2.b0.g.t.c.f;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class TypeDeserializer$typeAliasDescriptors$1 extends Lambda implements l<Integer, f> {
    public final /* synthetic */ TypeDeserializer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeDeserializer$typeAliasDescriptors$1(TypeDeserializer typeDeserializer) {
        super(1);
        this.this$0 = typeDeserializer;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ f invoke(Integer num) {
        return invoke(num.intValue());
    }

    @e
    public final f invoke(int i2) {
        f f2;
        f2 = this.this$0.f(i2);
        return f2;
    }
}
