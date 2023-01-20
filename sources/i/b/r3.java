package i.b;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lh/t1;", "b", "(Lh/e2/c;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", am.av, "(Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class r3 {
    public static final void a(@k.e.a.d CoroutineContext coroutineContext) {
        b2 b2Var = (b2) coroutineContext.get(b2.y0);
        if (b2Var != null && !b2Var.j()) {
            throw b2Var.q();
        }
    }

    @k.e.a.e
    public static final Object b(@k.e.a.d h.e2.c<? super h.t1> cVar) {
        Object obj;
        CoroutineContext context = cVar.getContext();
        a(context);
        h.e2.c d2 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        if (!(d2 instanceof i.b.w3.j)) {
            d2 = null;
        }
        i.b.w3.j jVar = (i.b.w3.j) d2;
        if (jVar != null) {
            if (jVar.f15886g.isDispatchNeeded(context)) {
                jVar.n(context, h.t1.a);
            } else {
                q3 q3Var = new q3();
                CoroutineContext plus = context.plus(q3Var);
                obj = h.t1.a;
                jVar.n(plus, obj);
                if (q3Var.a) {
                    if (i.b.w3.k.h(jVar)) {
                        obj = h.e2.j.b.h();
                    }
                }
            }
            obj = h.e2.j.b.h();
        } else {
            obj = h.t1.a;
        }
        if (obj == h.e2.j.b.h()) {
            h.e2.k.a.f.c(cVar);
        }
        return obj == h.e2.j.b.h() ? obj : h.t1.a;
    }
}
