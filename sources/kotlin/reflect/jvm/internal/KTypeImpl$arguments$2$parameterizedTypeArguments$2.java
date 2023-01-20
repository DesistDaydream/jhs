package kotlin.reflect.jvm.internal;

import h.k2.u.a;
import java.lang.reflect.Type;
import java.util.List;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KTypeImpl$arguments$2$parameterizedTypeArguments$2 extends Lambda implements a<List<? extends Type>> {
    public final /* synthetic */ KTypeImpl$arguments$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KTypeImpl$arguments$2$parameterizedTypeArguments$2(KTypeImpl$arguments$2 kTypeImpl$arguments$2) {
        super(0);
        this.this$0 = kTypeImpl$arguments$2;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends Type> invoke() {
        return ReflectClassUtilKt.d(this.this$0.this$0.c());
    }
}
