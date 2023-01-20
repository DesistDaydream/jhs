package kotlin.reflect.jvm.internal.impl.types.checker;

import h.k2.u.a;
import h.p2.b0.g.t.n.c1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class NewCapturedTypeConstructor$_supertypes$2 extends Lambda implements a<List<? extends c1>> {
    public final /* synthetic */ NewCapturedTypeConstructor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewCapturedTypeConstructor$_supertypes$2(NewCapturedTypeConstructor newCapturedTypeConstructor) {
        super(0);
        this.this$0 = newCapturedTypeConstructor;
    }

    @Override // h.k2.u.a
    @e
    public final List<? extends c1> invoke() {
        a aVar;
        aVar = this.this$0.b;
        if (aVar == null) {
            return null;
        }
        return (List) aVar.invoke();
    }
}
