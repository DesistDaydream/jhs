package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import h.k2.u.a;
import h.p2.b0.g.t.i.n;
import h.p2.b0.g.t.i.p;
import java.io.ByteArrayInputStream;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1 extends Lambda implements a<M> {
    public final /* synthetic */ ByteArrayInputStream $inputStream;
    public final /* synthetic */ p<M> $parser;
    public final /* synthetic */ DeserializedMemberScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(p<M> pVar, ByteArrayInputStream byteArrayInputStream, DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.$parser = pVar;
        this.$inputStream = byteArrayInputStream;
        this.this$0 = deserializedMemberScope;
    }

    /* JADX WARN: Incorrect return type in method signature: ()TM; */
    @Override // h.k2.u.a
    @e
    public final n invoke() {
        return (n) this.$parser.d(this.$inputStream, this.this$0.r().c().j());
    }
}
