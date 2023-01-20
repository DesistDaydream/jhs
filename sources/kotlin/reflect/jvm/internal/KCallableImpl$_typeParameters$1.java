package kotlin.reflect.jvm.internal;

import h.a2.u;
import h.k2.u.a;
import h.p2.b0.g.t.c.t0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "R", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KCallableImpl$_typeParameters$1 extends Lambda implements a<List<? extends KTypeParameterImpl>> {
    public final /* synthetic */ KCallableImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KCallableImpl$_typeParameters$1(KCallableImpl kCallableImpl) {
        super(0);
        this.this$0 = kCallableImpl;
    }

    @Override // h.k2.u.a
    public final List<? extends KTypeParameterImpl> invoke() {
        List<t0> typeParameters = this.this$0.J().getTypeParameters();
        ArrayList arrayList = new ArrayList(u.Y(typeParameters, 10));
        for (t0 t0Var : typeParameters) {
            arrayList.add(new KTypeParameterImpl(this.this$0, t0Var));
        }
        return arrayList;
    }
}
