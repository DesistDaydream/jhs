package kotlinx.coroutines.flow.internal;

import h.e2.c;
import h.e2.k.a.j;
import h.k2.u.q;
import h.k2.v.c0;
import h.t1;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u000e\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00002\u0017\u0010\u0006\u001a\u0013\u0018\u00010\u0001¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005H\u0086@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Li/b/v3/f;", "", "p1", "Lh/k0;", "name", "value", "p2", "Lh/t1;", "invoke", "(Li/b/v3/f;Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final /* synthetic */ class SafeCollectorKt$emitFun$1 extends FunctionReferenceImpl implements q<f<? super Object>, Object, c<? super t1>, Object>, j {
    public SafeCollectorKt$emitFun$1() {
        super(3, f.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    @e
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(@d f<Object> fVar, @e Object obj, @d c<? super t1> cVar) {
        c0.e(0);
        Object emit = fVar.emit(obj, cVar);
        c0.e(2);
        c0.e(1);
        return emit;
    }

    @Override // h.k2.u.q
    public /* bridge */ /* synthetic */ Object invoke(f<? super Object> fVar, Object obj, c<? super t1> cVar) {
        return invoke2((f<Object>) fVar, obj, cVar);
    }
}
