package kotlin.reflect.jvm.internal;

import h.a2.u;
import h.k2.u.a;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KTypeParameterImpl$upperBounds$2 extends Lambda implements a<List<? extends KTypeImpl>> {
    public final /* synthetic */ KTypeParameterImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KTypeParameterImpl$upperBounds$2(KTypeParameterImpl kTypeParameterImpl) {
        super(0);
        this.this$0 = kTypeParameterImpl;
    }

    @Override // h.k2.u.a
    public final List<? extends KTypeImpl> invoke() {
        List<z> upperBounds = this.this$0.e().getUpperBounds();
        ArrayList arrayList = new ArrayList(u.Y(upperBounds, 10));
        for (z zVar : upperBounds) {
            arrayList.add(new KTypeImpl(zVar, null, 2, null));
        }
        return arrayList;
    }
}
