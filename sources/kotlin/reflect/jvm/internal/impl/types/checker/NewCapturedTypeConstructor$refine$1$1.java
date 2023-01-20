package kotlin.reflect.jvm.internal.impl.types.checker;

import h.a2.u;
import h.k2.u.a;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.e1.h;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class NewCapturedTypeConstructor$refine$1$1 extends Lambda implements a<List<? extends c1>> {
    public final /* synthetic */ h $kotlinTypeRefiner;
    public final /* synthetic */ NewCapturedTypeConstructor this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewCapturedTypeConstructor$refine$1$1(NewCapturedTypeConstructor newCapturedTypeConstructor, h hVar) {
        super(0);
        this.this$0 = newCapturedTypeConstructor;
        this.$kotlinTypeRefiner = hVar;
    }

    @Override // h.k2.u.a
    @d
    public final List<? extends c1> invoke() {
        List<c1> j2 = this.this$0.j();
        h hVar = this.$kotlinTypeRefiner;
        ArrayList arrayList = new ArrayList(u.Y(j2, 10));
        for (c1 c1Var : j2) {
            arrayList.add(c1Var.N0(hVar));
        }
        return arrayList;
    }
}
