package kotlin.reflect.jvm.internal.impl.types;

import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;

/* loaded from: classes3.dex */
public final class AbstractTypeConstructor$supertypes$1 extends Lambda implements a<AbstractTypeConstructor.a> {
    public final /* synthetic */ AbstractTypeConstructor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractTypeConstructor$supertypes$1(AbstractTypeConstructor abstractTypeConstructor) {
        super(0);
        this.this$0 = abstractTypeConstructor;
    }

    @Override // h.k2.u.a
    @d
    public final AbstractTypeConstructor.a invoke() {
        return new AbstractTypeConstructor.a(this.this$0.h());
    }
}
