package kotlin.reflect.jvm.internal;

import h.a2.u;
import h.k2.u.a;
import h.p2.b0.g.h;
import h.p2.b0.g.t.n.s0;
import h.p2.t;
import h.w;
import h.z;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "Lkotlin/reflect/KTypeProjection;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KTypeImpl$arguments$2 extends Lambda implements a<List<? extends t>> {
    public final /* synthetic */ a $computeJavaType;
    public final /* synthetic */ KTypeImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KTypeImpl$arguments$2(KTypeImpl kTypeImpl, a aVar) {
        super(0);
        this.this$0 = kTypeImpl;
        this.$computeJavaType = aVar;
    }

    @Override // h.k2.u.a
    public final List<? extends t> invoke() {
        t e2;
        List<s0> H0 = this.this$0.getType().H0();
        if (H0.isEmpty()) {
            return CollectionsKt__CollectionsKt.E();
        }
        w b = z.b(LazyThreadSafetyMode.PUBLICATION, new KTypeImpl$arguments$2$parameterizedTypeArguments$2(this));
        ArrayList arrayList = new ArrayList(u.Y(H0, 10));
        int i2 = 0;
        for (Object obj : H0) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            s0 s0Var = (s0) obj;
            if (s0Var.b()) {
                e2 = t.f15641d.c();
            } else {
                KTypeImpl kTypeImpl = new KTypeImpl(s0Var.getType(), this.$computeJavaType != null ? new KTypeImpl$arguments$2$$special$$inlined$mapIndexed$lambda$1(i2, this, b, null) : null);
                int i4 = h.a[s0Var.c().ordinal()];
                if (i4 == 1) {
                    e2 = t.f15641d.e(kTypeImpl);
                } else if (i4 == 2) {
                    e2 = t.f15641d.a(kTypeImpl);
                } else if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                } else {
                    e2 = t.f15641d.b(kTypeImpl);
                }
            }
            arrayList.add(e2);
            i2 = i3;
        }
        return arrayList;
    }
}
