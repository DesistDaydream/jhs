package h.p2.b0.g.t.f.z;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: classes3.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    @k.e.a.e
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T a(@k.e.a.d GeneratedMessageLite.ExtendableMessage<M> extendableMessage, @k.e.a.d GeneratedMessageLite.f<M, T> fVar) {
        if (extendableMessage.hasExtension(fVar)) {
            return (T) extendableMessage.getExtension(fVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @k.e.a.e
    public static final <M extends GeneratedMessageLite.ExtendableMessage<M>, T> T b(@k.e.a.d GeneratedMessageLite.ExtendableMessage<M> extendableMessage, @k.e.a.d GeneratedMessageLite.f<M, List<T>> fVar, int i2) {
        if (i2 < extendableMessage.getExtensionCount(fVar)) {
            return (T) extendableMessage.getExtension(fVar, i2);
        }
        return null;
    }
}
